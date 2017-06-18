package com.citybus.service.impl;

import java.util.List;

import com.citybus.dao.GuestBookDaoImpl;
import com.citybus.domain.GuestAndReplay;
import com.citybus.domain.GuestBook;
import com.citybus.domain.GuestBook_Left_Two;
import com.citybus.domain.PageBean_GuestAndReplay;
import com.citybus.domain.PageBean_GuestBook_Two;
import com.citybus.domain.Replay;
import com.citybus.web.servlet.behind.GuestbookReplay;

public class GuestBookServiceImpl {
	GuestBookDaoImpl gbdi = new GuestBookDaoImpl();
	
	public List<GuestAndReplay> finAllGuestBookAndReplay() {
		try {
			return gbdi.finAllGuestBookAndReplay();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public PageBean_GuestBook_Two finGuestPage(int currentPage, int pageSize) {
		try {
			PageBean_GuestBook_Two pbg = new PageBean_GuestBook_Two();
			int count  = gbdi.count();
			int totalPage = (int) Math.ceil(1.0*count/pageSize);
			List<GuestBook_Left_Two> list =  gbdi.finGuestPage(currentPage, pageSize);
			pbg.setCount(count);
			pbg.setCurrentPage(currentPage);
			pbg.setList(list);
			pbg.setPageSize(pageSize);
			pbg.setTotalPage(totalPage);
			
			return pbg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		return null;
	}

	public int addGuest(GuestBook gb) {
		try {
			GuestBook gb1 = gbdi.findGuestById(gb.getGid());
			if(gb1==null){
			return gbdi.addGuest(gb);
			}else{
				return gbdi.updateGuest(gb);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public PageBean_GuestBook_Two findGuestPageById(String nickname, int currentPage, int pageSize) {
		try {
			PageBean_GuestBook_Two pbg = new PageBean_GuestBook_Two();
			int count =gbdi.countByNickname(nickname);
			int totalPage=(int) Math.ceil(count*1.0/pageSize);
			
			List list =  gbdi.findGuestPageById(nickname,currentPage,pageSize);
			
			pbg.setCount(count);
			pbg.setCurrentPage(currentPage);
			pbg.setList(list);
			pbg.setPageSize(pageSize);
			pbg.setTotalPage(totalPage);
			return pbg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		return null;
	}

	public PageBean_GuestAndReplay findAllGuestBook(int currentPage, int pageSize) {
		try {
			PageBean_GuestAndReplay  pgb = new PageBean_GuestAndReplay();
			int count = gbdi.count();
			int totalPage=(int) Math.ceil(1.0*count/pageSize);
			List list=gbdi.finGuestPage(currentPage, pageSize);
			pgb.setCount(count);
			pgb.setCurrentPage(currentPage);
			pgb.setList(list);
			pgb.setPageSize(pageSize);
			pgb.setTotalPage(totalPage);
			return pgb;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int delGuestbookByGid(String gid) {
		try {
			return gbdi.delGuestbookByGid(gid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public GuestAndReplay finGuestByIdAndTime(String gid, String addtime) {
		try {
			return gbdi.finGuestByIdAndTime(gid,addtime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public int addReplay(Replay replay) {
		try {
			Replay r  = gbdi.findReplayById(replay);
			if(r!=null){
				return gbdi.updateReplay(replay);
			}else{
			return gbdi.addReplay(replay);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

}
