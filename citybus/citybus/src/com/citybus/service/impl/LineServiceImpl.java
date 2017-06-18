package com.citybus.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.citybus.dao.LineDaoImpl;
import com.citybus.dao.LineStationDaoImpl;
import com.citybus.domain.Line;
import com.citybus.domain.PageBean;
import com.citybus.util.ManagerThreadLocal;

public class LineServiceImpl {

	LineDaoImpl lineDao = new LineDaoImpl();
	LineStationDaoImpl lsdao = new LineStationDaoImpl();
	
	public  List<Line> findAllLine(){
		try {
			return lineDao.findAllLines();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public int addLine(Line line) {
		try {
			Line line2 = lineDao.findLineByLname(line.getLname());
			if(line2==null){
				//添加事务
				ManagerThreadLocal.startTransacation();//begin
				lineDao.addLine(line);
				lineDao.addLineIdTo(line);
				ManagerThreadLocal.commit();//提交事务
				return 1;
			}else{
				return 0;
			}
		} catch (SQLException e) {
			ManagerThreadLocal.rollback();//回滚事务
			e.printStackTrace();
		}finally{
			try {
				ManagerThreadLocal.close();
			} catch (Exception e) {
				e.printStackTrace();
			}//关闭
		}
		return 0;
	}


	public Line findLineById(String lid) {

		try {
			return lineDao.findLineById(lid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public void updateLine(Line line) {
		try {
			lineDao.updateLine(line);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public int deleteLineById(String lid) {
		try {
			//添加事务
			ManagerThreadLocal.startTransacation();//begin
			lineDao.deleteLineById(lid);
			int i = lsdao.delLineByLid(lid);
			ManagerThreadLocal.commit();//提交事务
			return i;
		} catch (SQLException e) {
			ManagerThreadLocal.rollback();//回滚事务
			e.printStackTrace();
		}finally{
			try {
				ManagerThreadLocal.close();
			} catch (Exception e) {
				e.printStackTrace();
			}//关闭
		}
		return 0;
	}


	public void batchDeleteLine(String[] ids) {
		try {
			lineDao.deleteLineById(ids);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<Line> searchLine(String lname, String company, String people,
			String type) {

		try {
			return lineDao.searchLine(lname,company,people,type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public PageBean findLinePage(int pageSize, int currentPage) {
		// TODO Auto-generated method stub
		try {
			int count = (int) lineDao.count();
			int totalPage = (int) Math.ceil(count*1.0/pageSize);
			List<Line> list = lineDao.findLinePage(pageSize,currentPage);
			
			PageBean pb = new PageBean();
			pb.setBuss(list);
			pb.setCount(count);
			pb.setCurrentPage(currentPage);
			pb.setPageSize(pageSize);
			pb.setTotalPage(totalPage);
			return pb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public Line finLineByLname(String lname) {
		try {
			return lineDao.findLineByLname(lname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
