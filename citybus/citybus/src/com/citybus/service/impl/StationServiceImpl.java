package com.citybus.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.citybus.dao.LineStationDaoImpl;
import com.citybus.dao.StationDaoImpl;
import com.citybus.domain.LineStation;
import com.citybus.domain.Station;
import com.citybus.util.ManagerThreadLocal;

public class StationServiceImpl {

	StationDaoImpl stationDao =new StationDaoImpl();
	LineStationDaoImpl lsdao = new LineStationDaoImpl();
	public List<Station> findAllStation() {
		try {
			return stationDao.findAllStation();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addStation(Station station) {
		try {
			stationDao.addBook(station);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteStation(String sid) {
		try {
			//�ȴ�stationline�л�ȡsid��Ӧ��orde---list
			List<LineStation> listo = lsdao.findOrdeBySid(sid);
			//��������
			ManagerThreadLocal.startTransacation();
			//ɾ��station�е�
			stationDao.deleteStation(sid);
			//ɾ��stationline�е�
			lsdao.deleteStation(sid);
			//����stationline�е�˳��
			for (int i = 0; i < listo.size(); i++) {
				lsdao.updateOrde(listo.get(i));
			}
			ManagerThreadLocal.commit();
		} catch (SQLException e) {
			ManagerThreadLocal.rollback();
			e.printStackTrace();
		}finally{
			ManagerThreadLocal.close();
		}
		
	}

	public void batchDeleteBook(String[] ids) {
		try {
			stationDao.batchDeleteBook(ids);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Station findStationById(String id) {
		
		try {
			return stationDao.findStationById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateStation(String sid, String sname) throws SQLException {
		return stationDao.updateStation(sid,sname);
		
	}

	public List<Station> searchStation(String sid, String sname) {
		try {
			return stationDao.searchStation(sid,sname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String findStationBySname(String sname) {
		try {
			return stationDao.findSidBySname(sname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
