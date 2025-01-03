package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Insert_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		System.out.print("이름 : ");
		String str = sc.nextLine();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			String sql = "INSERT INTO test(t_name) "
					+ "VALUES ('"+str+"')";
			int result = stmt.executeUpdate(sql);
			
			if(result >0) {
				System.out.println("성공!!");
			}else {
				System.out.println("실패!!");
			}
			
			
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
		
		
	}
}
