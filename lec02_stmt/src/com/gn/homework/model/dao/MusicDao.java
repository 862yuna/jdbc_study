package com.gn.homework.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.homework.model.vo.WmSong;
import com.gn.homework.model.vo.WmUser;
import com.gn.study.model.vo.Member;

public class MusicDao {

	public int joinMember(WmUser u) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "INSERT INTO wm_user(u_id ,u_pw ,u_name)"
					+ " VALUES ('"+u.getUserId()+"','"+u.getUserPw()+"'"+ ",'"+u.getUserName()+"')";
			result = stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public WmUser selectUserByIdAndPw(String memId,String memPw) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		WmUser user = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "select * from wm_user where u_id = '"
                    + memId + "' and u_pw = '" + memPw + "'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				user= new WmUser();
				user.setUserNo(rs.getInt("u_no"));
				user.setUserId(rs.getString("u_id"));
				user.setUserPw(rs.getString("u_pw"));
				user.setUserName(rs.getString("u_name"));
				user.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return user;
		
	}
	
	public int insertMusic(WmSong s) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "INSERT INTO wm_song(m_no ,m_title ,m_artist ,m_play) "
					+ "VALUES ('"+s.getmNo()+"','"+s.getmTitle()+"'"+ 
					",'"+s.getmArtist()+",'"+s.getmPlay()+"')";
			result = stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	public List<WmSong> selectMusicAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<WmSong> list = new ArrayList<WmSong>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM wm_song");
			while(rs.next()) {
				WmSong s = new WmSong();
				s.setmNo(rs.getInt("m_no"));
				s.setmTitle(rs.getString("m_title"));
				s.setmArtist(rs.getString("m_artist"));
				s.setmPlay(rs.getInt("m_play"));
				list.add(s);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int selectPlayMusic(int songNum) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		WmSong song = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "UPDATE FROM wm_song "
					+ "SET m_play = m_play + 1 "
					+ "WHERE m_no = '"+songNum+"'";
					
			result = stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public List<WmSong> countMusic(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<WmSong> list = new ArrayList<WmSong>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM wm_song "
					+ "ORDER BY m_play DESC "
					+ "LIMIT 10;");
			while(rs.next()) {
				WmSong s = new WmSong();
				s.setmNo(rs.getInt("m_no"));
				s.setmTitle(rs.getString("m_title"));
				s.setmArtist(rs.getString("m_artist"));
				s.setmPlay(rs.getInt("m_play"));
				list.add(s);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
}
