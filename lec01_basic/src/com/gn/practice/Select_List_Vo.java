package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Test;

public class Select_List_Vo {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mariadb://127.0.0.1:3306/jdbc_basic"
					,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM test");
			List<Test> list = new ArrayList<Test>();
			while(rs.next()) {
				Test t = new Test();
				t.setTestNo(rs.getInt("t_no"));
				t.setTestName(rs.getString("t_name"));
				t.setTestDate(rs.getTimestamp("t_date").toLocalDateTime());
				list.add(t);
			}
			if(list.isEmpty()) {
				System.out.println("조회된 결과가 없습니다.");
			}else {
				for(Test t : list) {
					System.out.println(t);
				}
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
