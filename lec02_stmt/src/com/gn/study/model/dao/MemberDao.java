package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gn.study.model.vo.Member;

public class MemberDao {
	public List<Member> selectMemberAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Member> list = new ArrayList<Member>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member");
			while(rs.next()) {
				Member m = new Member();
				m.setMemberNo(rs.getInt("m_no"));
				m.setMemberId(rs.getString("m_id"));
				m.setMemberPw(rs.getString("m_pw"));
				m.setMemberName(rs.getString("m_name"));
				m.setMemberEmail(rs.getString("m_email"));
				m.setMemberPhone(rs.getString("m_phone"));
				m.setMemberGender(rs.getString("m_gender"));
				m.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				m.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(m);
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
		// 전체 member 정보 조회 -> List<Member>
		
		// DB에 SQL문 요청
		return list;
		
		
		
	}
	
	public int insertMember(Member m) {
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
			String sql = "INSERT INTO member(m_id ,m_pw ,m_name ,m_email ,m_phone ,m_gender)\r\n"
					+ "VALUES ('"+m.getMemberId()+"','"+m.getMemberPw()+"'"+ ",'"+m.getMemberName()+"'"+ ""
									+ ",'"+m.getMemberEmail()+"','"+m.getMemberPhone()+"'"+ ",'"+m.getMemberGender()+"')";
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
	
	public List<Member> searchMemberId(String myId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM member WHERE m_id = '"+myId+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				Member m = new Member();
				m.setMemberNo(rs.getInt("m_no"));
				m.setMemberId(rs.getString("m_id"));
				m.setMemberPw(rs.getString("m_pw"));
				m.setMemberName(rs.getString("m_name"));
				m.setMemberEmail(rs.getString("m_email"));
				m.setMemberPhone(rs.getString("m_phone"));
				m.setMemberGender(rs.getString("m_gender"));
				m.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				m.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(m);
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
	
	public List<Member> searchName(String name){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM member "
					+ "WHERE m_name LIKE '%"+name+"%'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Member m = new Member();
				m.setMemberNo(rs.getInt("m_no"));
				m.setMemberId(rs.getString("m_id"));
				m.setMemberPw(rs.getString("m_pw"));
				m.setMemberName(rs.getString("m_name"));
				m.setMemberEmail(rs.getString("m_email"));
				m.setMemberPhone(rs.getString("m_phone"));
				m.setMemberGender(rs.getString("m_gender"));
				m.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				m.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(m);
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
	
	public int checkMember(String memId,String memPw) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "select * from member where m_id = '"
                    + memId + "' and m_pw = '" + memPw + "'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				result = 1;
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
		System.out.println("나는 Dao" + result);
		return result;
	}
	
	public int editPw(String pass, String myId) {
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
			String sql = "UPDATE member"
					+ " SET m_pw = '"+pass+"'"
					+ " WHERE m_id = '"+myId+"'";
					
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
	
}
