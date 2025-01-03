package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gn.study.model.vo.Test;

public class Insert_Scanner_A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			System.out.print("이름 : ");
			String str = sc.nextLine();
			String sql1 = "INSERT INTO test(t_name) VALUES('"+str+"')";
			int result = stmt.executeUpdate(sql1);
			if(result > 0) {
//				System.out.println("성공!!");
				System.out.println("===== test =====");
				List<Test> list = new ArrayList<Test>();
				String sql2 = "SELECT * FROM test WHERE t_name = '"+str+"'";
				rs = stmt.executeQuery(sql2);
				while(rs.next()) {
					Test t = new Test(rs.getInt("t_no")
							,rs.getString("t_name")
							,rs.getTimestamp("t_date").toLocalDateTime());
					list.add(t);
				}
				System.out.println(list);
				
			} else {
				System.out.println("실패!!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
