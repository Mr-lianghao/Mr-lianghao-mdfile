package com.citybus.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.citybus.domain.GuestAndReplay;
import com.citybus.domain.GuestBook;
import com.citybus.domain.GuestBook_Left_Two;
import com.citybus.domain.PageBean_GuestAndReplay;
import com.citybus.domain.PageBean_GuestBook_Two;
import com.citybus.domain.Replay;
import com.citybus.util.C3P0Util;
import com.citybus.web.servlet.behind.GuestbookReplay;

public class GuestBookDaoImpl {

	public List<GuestAndReplay> finAllGuestBookAndReplay() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from guestbook_replay", new BeanListHandler<GuestAndReplay>(GuestAndReplay.class));
	}

	public int count() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		return (Integer) qr.query("select count(*) from guestbook_replay", new ScalarHandler());
	}

	public List<GuestBook_Left_Two> finGuestPage(int currentPage, int pageSize) throws SQLException {
		//exec guest_page_not_in
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("exec guestTwo_page_not_in ?,?", new BeanListHandler<GuestBook_Left_Two>(GuestBook_Left_Two.class),currentPage,pageSize);

	}

	public int addGuest(GuestBook gb) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "insert into guestbook (gid,nickname,email,qq,content1,addtime)values(?,?,?,?,?,?)";
		return qr.update(sql,gb.getGid(), gb.getNickname(),gb.getEmail(),gb.getQq(),gb.getContent1(),gb.getAddtime());
	}

	public List findGuestPageById(String nickname, int currentPage, int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("exec guest_page_two_not_in_nickname ?,?,?", new BeanListHandler<GuestBook_Left_Two>(GuestBook_Left_Two.class), currentPage,pageSize,nickname);
	}

	public int countByNickname(String nickname) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		return (Integer) qr.query("select count(*) from guestbook_replay where nickname=?", new ScalarHandler(),nickname);

	}

	public List<GuestBook> findAllGuestBook() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from guestbook", new BeanListHandler<GuestBook>(GuestBook.class));
	}

	public int delGuestbookByGid(String gid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());		
		return qr.update("delete from guestbook where gid=?",gid);
	}

	public GuestAndReplay finGuestByIdAndTime(String gid, String addtime) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());	
		return qr.query("select * from guestbook_replay where gid=? and addtime=?", new BeanHandler<GuestAndReplay>(GuestAndReplay.class), gid,addtime);
	}

	public int addReplay(Replay replay) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());	
		return qr.update("insert into replay (id,replaycontent,username,replaytime,replayer)values(?,?,?,?,?)",replay.getId(),replay.getReplaycontent(),replay.getUsername(),replay.getReplaytime(),replay.getReplayer());
	}

	public Replay findReplayById(Replay replay) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());	

		return qr.query("select * from replay where id=?", new BeanHandler<Replay>(Replay.class), replay.getId());
	}

	public int updateReplay(Replay replay) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());	
		return qr.update("update replay set replaycontent=? , replaytime=? , replayer=? ,username=? where id=?", replay.getReplaycontent(),replay.getReplaytime(),replay.getReplayer(),replay.getUsername(),replay.getId());
		
	}

	public GuestBook findGuestById(Integer gid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());	
		return qr.query("select * from guestbook where gid=?", new BeanHandler<GuestBook>(GuestBook.class), gid);
		
	}

	public int updateGuest(GuestBook gb) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "update  guestbook set nickname=? , email=? , qq=? , content1=? , addtime=?  where gid=?";
		return qr.update(sql,gb.getNickname(),gb.getEmail(),gb.getQq(),gb.getContent1(),gb.getAddtime(),gb.getGid());
	}

}
