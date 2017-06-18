package com.citybus.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.citybus.dao.LineDaoImpl;
import com.citybus.dao.LineStationDaoImpl;
import com.citybus.dao.StationDaoImpl;
import com.citybus.domain.BusInfo;
import com.citybus.domain.Line;
import com.citybus.domain.LineLeftStation;
import com.citybus.domain.LineString;
import com.citybus.domain.Station;
import com.citybus.domain.TransInfo;
import com.citybus.util.ManagerThreadLocal;
import com.citybus.util.UUIDUtil;

public class LineStationServiceImpl {

	/*思路：第一列显示的是和站点一样的列表--站点表
	 * 	      第二列显示的是线路的列表--站点线路表+站点信息表
	 * 1.获取数据(service层)：
	 * 		先通过查询获取线路信息表中的所有内容
	 * Map map = new HashMap(String ,List<LineCollect>());
	 * 
	 * List<LineCollect> lc = new  List<LineCollect>();
	 * List<LineStation> ls = lsDao.findAllLineStation();---lid,sid,order
	 * 	for(int i=0;i<ls.count;i++){
	 * 		//查询所有的ls中的Line信息
	 * 		List<Line> line = stationdao.query("select *from line where lid=?",)
	 * 		//查询所有的线路Station
	 * 		List station = line.query("select order,sname from station t left join linestation  t1 where t1.sid=t.sid order by")
	 * }
	 * 	
	 * 
	 * 通过左连接：	
	 * 	SELECT lname,'type',company,people,tel,sname,orde FROM (stationline LEFT JOIN station ON stationline.`sid`=station.`sid`)LEFT JOIN line ON 
stationline.`lid`=line.`lid` GROUP BY lname ORDER BY orde	
	 * 
	 * */
	
	
	LineStationDaoImpl lsdao = new LineStationDaoImpl();
	LineDaoImpl ldao = new LineDaoImpl();
	StationDaoImpl sdao = new StationDaoImpl();
	
	public List<LineLeftStation> findAllLineStation(){
		try {
			return lsdao.findAllLineStation();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<LineLeftStation> finRouteById(String string) {
		try {
			return lsdao.finRouteById(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LineLeftStation> finRouteByLname(String lname) {
		try {
			return lsdao.finRouteByLname(lname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LineString> findAllLineString() {
		try {
			return lsdao.findAllLineString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public LineString searchLineStation(String string) {
		try {
			return lsdao.searchLineStation(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int searchLineStationCount(String string) {
		try {
			return lsdao.searchLineStationCount(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<LineString> searchLineStation1(String string) {
		try {
			return lsdao.searchLineStation1(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List findStationOnAJAX(String name, String lname) throws SQLException {
		
			Station station = lsdao.finStationByname(name);
			if(station == null){
				return null;
			}//如果站点表中没有，直接返回错误并中断
			
			//当站点存在的时候，先找到当前页面的线路名所对应的lid
			String lid = lsdao.finLidByLname(lname);
			//System.out.println(lid);
			//通过lid在stationline表中查找lid所对应的所有的sid
			List sid=lsdao.finSidByLid(lid);
			/*for(int i=0;i<sid.size();i++){
				System.out.println(sid.get(i));
			}*/
			
		/*	List sql = new ArrayList();
			//对于所有的sid进行便利循环，找到对应的sname；
			for(int i=0;i<sid.size();i++){
				String a = lsdao.findStationBySid(sid.get(i));
				System.out.println(a);
				sql.add(a);
			}*/
			List nameList = lsdao.findStationOnAJAX(sid);
			return nameList;
		
	}

	public List getOrdeByLname(String orde, String lname) {
		try {
			String lid = ldao.getLidByLname(lname);
			List list = lsdao.findOrdeByLid(lid);
			//System.out.println(lname);
			//System.out.println(lid);
			list.add(list.size()+1);
			//System.out.println("size="+list.size());
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public void updateStationOnLine(String sname, String lname, String orde) {
		
		try {
			//根据lname获取lid
			String lid = ldao.getLidByLname(lname);
			//System.out.println(lid);
			//更新
			lsdao.updateStationOnLine(lid,sname,orde);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delStation(String orde, String lname) {
		
		try {
			String lid = ldao.getLidByLname(lname);
			
			lsdao.delStation(orde,lid);
			lsdao.updateSidJ(orde,lid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void batchUpdateOrde(Object[][] obj) {
		try {
			//通过lname获取lid
			//String lid = ldao.getLidByLname(lname);
			//通过sname获取sid
			for(int i=0;i<obj.length;i++){
				obj[i][0] = sdao.findSidBySname(obj[i][0].toString());
			}
			//向每个一维数组中添加lid--失败，数组的长度固定了
			for(int i=0;i<obj.length;i++){
				obj[i][2]=ldao.getLidByLname(obj[i][2].toString());
			}
			//打印输出
			for(int i=0;i<obj.length;i++){
				for(int j=0;j<obj[i].length;j++){
					System.out.print(obj[i][j]+"--");
				}
				System.out.println();
			}
			lsdao.batchUpdateOrde(obj);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String findLidBySid(String sid) {
		
		try {
			 String lid = ldao.getLidBySid(sid);
			 return lid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public List findLnameBySname(String sname) {

		try {
			 List list= ldao.findLnameBySname(sname);
			 return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public List<TransInfo> FindLineByTwoSname(String startStation, String endStation) {
		List<TransInfo> list = new ArrayList();
		try {
			
			//判断数据库中是否包含该站点---第一步，判断是否包含
			String startSid = sdao.findSidBySname(startStation);
			String endSid = sdao.findSidBySname(endStation);
			if(startSid!=null&&endSid!=null){
				
				
				//如果有，那么继续进行下一步
				//获取经过开始站点的所有路线
				List list_start = lsdao.findLidBySid(startSid);
				List list_end = lsdao.findLidBySid(endSid);
				
				//看看是否有直达路线？
				/**
				 * 思路：对经过开始站点的路线进行遍历？---看看两个list中是否有相同的路线
				 * 
				 */
				//直达查询-------------------------------------------------------------
				String zhida="";//是否需要定义全局变量？？
				for(Object o:list_start){
					for(Object o1:list_end){
						if(o.equals(o1)){
							//TODO 获取起始站的orde和终点站的orde
							int ordeS = lsdao.findOrdeBySidAndLid(startSid,o.toString());
							int ordeE = lsdao.findOrdeBySidAndLid(endSid,o.toString());
							// TODO 为什么在这里new而不是在外面呢？防止出现有多个直达线路
							TransInfo tri = new TransInfo();
							// TODO 添加开始站点
							tri.setSname1(startStation);
							zhida=o.toString();//------有直达线路o
							String lname = lsdao.findLnameByLid(o.toString());
							
							//TODO 添加orde
							tri.setOrdeS(ordeS);
							tri.setOrdeE(ordeE);
							String pathZ="直达线路为："+lname+"线路";
							// TODO 存在直达线路，添加直达站点
							tri.setLname1(lname);
							// TODO 添加末尾节点
							tri.setSnameE(endStation);
							// TODO 查找字符串
							String lineString1=lsdao.findRoutListByLname(lname);
							
							List<String> lineString = new ArrayList<String>();
							lineString.add(lineString1);
							tri.setLineString(lineString);
							list.add(tri);
						}
					}
				}
			//换乘查询
			List huancheng = new ArrayList();//---用来做标记
			if(zhida==""){
				for(Object o:list_start){
					for(Object o1:list_end){
						//获取经过o和o1的所有站点
						List station_PerLine1 = lsdao.finSidByLid(o.toString());
						List station_PerLine2 = lsdao.finSidByLid(o1.toString());
						//compareList(station_PerLine1, station_PerLine2);--因为换乘可能不知返回一个值，所以不要抽取函数
						for (Object o2 : station_PerLine1) {
							for (Object o3 : station_PerLine2) {
								if(o2.equals(o3)){
									
									huancheng.add(o2);//从起始站做到o2，o2坐到目的站点，中转线路为o1
									String lname_s1 = lsdao.findLnameByLid(o.toString());
									String lname_s2 = lsdao.findLnameByLid(o1.toString());
									String zhong_station = lsdao.findStationBySid(o2.toString());
								String path = "换乘线路为：从起始站"+startStation+"坐"+lname_s1+"线路公交车到"+zhong_station+
										"站点，换乘"+lname_s2+"线路公交车到达终点站"+endStation;
								huancheng.add(path);
								
								//TODO 获取起始站的orde和终点站的orde
								int ordeS = lsdao.findOrdeBySidAndLid(startSid,o.toString());
								int ordeE = lsdao.findOrdeBySidAndLid(endSid,o1.toString());
								//TODO 获取stationlist
								String lineString1=lsdao.findRoutListByLname(lname_s1);
								String lineString2=lsdao.findRoutListByLname(lname_s2);
								//TODO 创建换乘信息对象 
								TransInfo tsi = new TransInfo();
								//获取中转站的orde
								//中转站在第一条线路中的orde
								int orde1 = lsdao.findOrdeBySidAndLid(o2.toString(),o.toString());
								//在第二条线路中的orde
								int orde2 = lsdao.findOrdeBySidAndLid(o2.toString(),o1.toString());
								//添加orde
								tsi.setOrde1(orde1);
								tsi.setOrde2(orde2);
								tsi.setOrdeS(ordeS);
								tsi.setOrdeE(ordeE);
								//添加线路
								tsi.setLname1(lname_s1);
								tsi.setLname2(lname_s2);
								//添加站点
								tsi.setSnameS(startStation);
								tsi.setSnameE(endStation);
								tsi.setSname1(zhong_station);
								//添加list
								List<String> lineString = new ArrayList<String>();
								lineString.add(lineString1);
								lineString.add(lineString2);
								tsi.setLineString(lineString);
								list.add(tsi);
								}
							}
						}
						
					}
				}
			}//--if(zhida=="")
				//System.out.println(huancheng.size());
			if(zhida==""&&huancheng.size()==0){
				//经过开始和结束站点的所有路线
				for(Object o:list_start){
					for(Object o1:list_end){
						//获取经过每条线路的所有站点
						List station_PerLine1 = lsdao.finSidByLid(o.toString());
						List station_PerLine2 = lsdao.finSidByLid(o1.toString());
						//compareList(station_PerLine1, station_PerLine2);--因为换乘可能不知返回一个值，所以不要抽取函数
						//遍历每条线的站点
						for (Object o2 : station_PerLine1) {
							for (Object o3 : station_PerLine2) {
								//每个站点经过的所有的线
								List list_start2 = lsdao.findLidBySid(o2.toString());
								List list_end2 = lsdao.findLidBySid(o3.toString());
								//遍历线路的集合
								for (Object start2 : list_start2) {
									for (Object end2 : list_end2) {
										//通过遍历线路的集合，判断线路是否有相同的
										if(start2.equals(end2)){
											//根据lid取出lname
											String lname1 = lsdao.findLnameByLid(o.toString());
											String lname2 = lsdao.findLnameByLid(start2.toString());
											String lname3 = lsdao.findLnameByLid(o1.toString());
											//根据sid取出sname
											String station1 = lsdao.findStationBySid(o2.toString());
											String station2 = lsdao.findStationBySid(o3.toString());
											String path = "换乘线路为：从起始站"+startStation+"坐"+lname1+"线路公交车到"+station1+
													"，换乘"+lname2+"公交车到"+station2+"，再换乘"+lname3+"线路公交车到达终点站"+endStation;
											//list.add(path);
										}
								}
							}
						}
						
					}
				}
				
			}
			}
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public BusInfo findBusInfoById(String lid) {
		try {
			BusInfo businfo = new BusInfo();
			//先进行查询线路的信息
			Line line = ldao.findLineById(lid);
			String lname = lsdao.findLnameByLid(lid);
			//再进行查询线路
			String stationlist = lsdao.findRoutListByLname(lname);
			
			//添加到businfo中
			businfo.setLine(line);
			businfo.setStationlist(stationlist);
			return businfo;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	public int insertStationLine(String lid, String[] stationOrde) {
		try {
			String[][] s=new String[stationOrde.length][3];
			//遍历数组，根据用sid替换sname
			for(int i=0;i<stationOrde.length;i++){
				stationOrde[i] = sdao.findSidBySname(stationOrde[i]);
			}
			//传入stationOrde和lid来进行批量更新---传入的是二维数组
			for(int i=0;i<stationOrde.length;i++){
				s[i] = new String[]{stationOrde[i],String.valueOf(i+1),lid};
			}
			for(int i=0;i<stationOrde.length;i++){
				for(int j=0;j<3;j++){
					System.out.print(s[i][j]+",");
				}
				System.out.println();
				System.out.println("_--------");
			}
				ManagerThreadLocal.startTransacation();
				//清空stationline中的线路
				lsdao.delLineByLid(lid);
				lsdao.insertStationLine(s);
				ManagerThreadLocal.commit();
				System.out.println("success");
				return 1;
		} catch (Exception e) {
			ManagerThreadLocal.rollback();
			// TODO: handle exception
		}finally{
			ManagerThreadLocal.close();
		}
		return 0;
	}

	
	
}
