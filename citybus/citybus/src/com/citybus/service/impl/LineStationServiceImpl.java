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

	/*˼·����һ����ʾ���Ǻ�վ��һ�����б�--վ���
	 * 	      �ڶ�����ʾ������·���б�--վ����·��+վ����Ϣ��
	 * 1.��ȡ����(service��)��
	 * 		��ͨ����ѯ��ȡ��·��Ϣ���е���������
	 * Map map = new HashMap(String ,List<LineCollect>());
	 * 
	 * List<LineCollect> lc = new  List<LineCollect>();
	 * List<LineStation> ls = lsDao.findAllLineStation();---lid,sid,order
	 * 	for(int i=0;i<ls.count;i++){
	 * 		//��ѯ���е�ls�е�Line��Ϣ
	 * 		List<Line> line = stationdao.query("select *from line where lid=?",)
	 * 		//��ѯ���е���·Station
	 * 		List station = line.query("select order,sname from station t left join linestation  t1 where t1.sid=t.sid order by")
	 * }
	 * 	
	 * 
	 * ͨ�������ӣ�	
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
			}//���վ�����û�У�ֱ�ӷ��ش����ж�
			
			//��վ����ڵ�ʱ�����ҵ���ǰҳ�����·������Ӧ��lid
			String lid = lsdao.finLidByLname(lname);
			//System.out.println(lid);
			//ͨ��lid��stationline���в���lid����Ӧ�����е�sid
			List sid=lsdao.finSidByLid(lid);
			/*for(int i=0;i<sid.size();i++){
				System.out.println(sid.get(i));
			}*/
			
		/*	List sql = new ArrayList();
			//�������е�sid���б���ѭ�����ҵ���Ӧ��sname��
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
			//����lname��ȡlid
			String lid = ldao.getLidByLname(lname);
			//System.out.println(lid);
			//����
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
			//ͨ��lname��ȡlid
			//String lid = ldao.getLidByLname(lname);
			//ͨ��sname��ȡsid
			for(int i=0;i<obj.length;i++){
				obj[i][0] = sdao.findSidBySname(obj[i][0].toString());
			}
			//��ÿ��һά���������lid--ʧ�ܣ�����ĳ��ȹ̶���
			for(int i=0;i<obj.length;i++){
				obj[i][2]=ldao.getLidByLname(obj[i][2].toString());
			}
			//��ӡ���
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
			
			//�ж����ݿ����Ƿ������վ��---��һ�����ж��Ƿ����
			String startSid = sdao.findSidBySname(startStation);
			String endSid = sdao.findSidBySname(endStation);
			if(startSid!=null&&endSid!=null){
				
				
				//����У���ô����������һ��
				//��ȡ������ʼվ�������·��
				List list_start = lsdao.findLidBySid(startSid);
				List list_end = lsdao.findLidBySid(endSid);
				
				//�����Ƿ���ֱ��·�ߣ�
				/**
				 * ˼·���Ծ�����ʼվ���·�߽��б�����---��������list���Ƿ�����ͬ��·��
				 * 
				 */
				//ֱ���ѯ-------------------------------------------------------------
				String zhida="";//�Ƿ���Ҫ����ȫ�ֱ�������
				for(Object o:list_start){
					for(Object o1:list_end){
						if(o.equals(o1)){
							//TODO ��ȡ��ʼվ��orde���յ�վ��orde
							int ordeS = lsdao.findOrdeBySidAndLid(startSid,o.toString());
							int ordeE = lsdao.findOrdeBySidAndLid(endSid,o.toString());
							// TODO Ϊʲô������new�������������أ���ֹ�����ж��ֱ����·
							TransInfo tri = new TransInfo();
							// TODO ��ӿ�ʼվ��
							tri.setSname1(startStation);
							zhida=o.toString();//------��ֱ����·o
							String lname = lsdao.findLnameByLid(o.toString());
							
							//TODO ���orde
							tri.setOrdeS(ordeS);
							tri.setOrdeE(ordeE);
							String pathZ="ֱ����·Ϊ��"+lname+"��·";
							// TODO ����ֱ����·�����ֱ��վ��
							tri.setLname1(lname);
							// TODO ���ĩβ�ڵ�
							tri.setSnameE(endStation);
							// TODO �����ַ���
							String lineString1=lsdao.findRoutListByLname(lname);
							
							List<String> lineString = new ArrayList<String>();
							lineString.add(lineString1);
							tri.setLineString(lineString);
							list.add(tri);
						}
					}
				}
			//���˲�ѯ
			List huancheng = new ArrayList();//---���������
			if(zhida==""){
				for(Object o:list_start){
					for(Object o1:list_end){
						//��ȡ����o��o1������վ��
						List station_PerLine1 = lsdao.finSidByLid(o.toString());
						List station_PerLine2 = lsdao.finSidByLid(o1.toString());
						//compareList(station_PerLine1, station_PerLine2);--��Ϊ���˿��ܲ�֪����һ��ֵ�����Բ�Ҫ��ȡ����
						for (Object o2 : station_PerLine1) {
							for (Object o3 : station_PerLine2) {
								if(o2.equals(o3)){
									
									huancheng.add(o2);//����ʼվ����o2��o2����Ŀ��վ�㣬��ת��·Ϊo1
									String lname_s1 = lsdao.findLnameByLid(o.toString());
									String lname_s2 = lsdao.findLnameByLid(o1.toString());
									String zhong_station = lsdao.findStationBySid(o2.toString());
								String path = "������·Ϊ������ʼվ"+startStation+"��"+lname_s1+"��·��������"+zhong_station+
										"վ�㣬����"+lname_s2+"��·�����������յ�վ"+endStation;
								huancheng.add(path);
								
								//TODO ��ȡ��ʼվ��orde���յ�վ��orde
								int ordeS = lsdao.findOrdeBySidAndLid(startSid,o.toString());
								int ordeE = lsdao.findOrdeBySidAndLid(endSid,o1.toString());
								//TODO ��ȡstationlist
								String lineString1=lsdao.findRoutListByLname(lname_s1);
								String lineString2=lsdao.findRoutListByLname(lname_s2);
								//TODO ����������Ϣ���� 
								TransInfo tsi = new TransInfo();
								//��ȡ��תվ��orde
								//��תվ�ڵ�һ����·�е�orde
								int orde1 = lsdao.findOrdeBySidAndLid(o2.toString(),o.toString());
								//�ڵڶ�����·�е�orde
								int orde2 = lsdao.findOrdeBySidAndLid(o2.toString(),o1.toString());
								//���orde
								tsi.setOrde1(orde1);
								tsi.setOrde2(orde2);
								tsi.setOrdeS(ordeS);
								tsi.setOrdeE(ordeE);
								//�����·
								tsi.setLname1(lname_s1);
								tsi.setLname2(lname_s2);
								//���վ��
								tsi.setSnameS(startStation);
								tsi.setSnameE(endStation);
								tsi.setSname1(zhong_station);
								//���list
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
				//������ʼ�ͽ���վ�������·��
				for(Object o:list_start){
					for(Object o1:list_end){
						//��ȡ����ÿ����·������վ��
						List station_PerLine1 = lsdao.finSidByLid(o.toString());
						List station_PerLine2 = lsdao.finSidByLid(o1.toString());
						//compareList(station_PerLine1, station_PerLine2);--��Ϊ���˿��ܲ�֪����һ��ֵ�����Բ�Ҫ��ȡ����
						//����ÿ���ߵ�վ��
						for (Object o2 : station_PerLine1) {
							for (Object o3 : station_PerLine2) {
								//ÿ��վ�㾭�������е���
								List list_start2 = lsdao.findLidBySid(o2.toString());
								List list_end2 = lsdao.findLidBySid(o3.toString());
								//������·�ļ���
								for (Object start2 : list_start2) {
									for (Object end2 : list_end2) {
										//ͨ��������·�ļ��ϣ��ж���·�Ƿ�����ͬ��
										if(start2.equals(end2)){
											//����lidȡ��lname
											String lname1 = lsdao.findLnameByLid(o.toString());
											String lname2 = lsdao.findLnameByLid(start2.toString());
											String lname3 = lsdao.findLnameByLid(o1.toString());
											//����sidȡ��sname
											String station1 = lsdao.findStationBySid(o2.toString());
											String station2 = lsdao.findStationBySid(o3.toString());
											String path = "������·Ϊ������ʼվ"+startStation+"��"+lname1+"��·��������"+station1+
													"������"+lname2+"��������"+station2+"���ٻ���"+lname3+"��·�����������յ�վ"+endStation;
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
			//�Ƚ��в�ѯ��·����Ϣ
			Line line = ldao.findLineById(lid);
			String lname = lsdao.findLnameByLid(lid);
			//�ٽ��в�ѯ��·
			String stationlist = lsdao.findRoutListByLname(lname);
			
			//��ӵ�businfo��
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
			//�������飬������sid�滻sname
			for(int i=0;i<stationOrde.length;i++){
				stationOrde[i] = sdao.findSidBySname(stationOrde[i]);
			}
			//����stationOrde��lid��������������---������Ƕ�ά����
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
				//���stationline�е���·
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
