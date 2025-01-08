package com.gn.study.model.dao;

import static com.gn.study.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Car;
public class Dao {
	public Car selectCarByModel(String modelName,Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Car car = new Car();
		try {
			String sql = "SELECT * FROM car WHERE car_model = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modelName);
			rs = pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(rs.next()) {

				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				if(rs.getDate("car_date") != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				} else {
					car.setCarDate("");
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return car;
	}
	
	public List<Car> selectCarAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		try {
			String sql = "SELECT * FROM car";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next()) {
//				Car car = new Car(rs.getInt("car_no"),
//						rs.getString("car_model"),
//						rs.getInt("car_price"),
//						sdf.format(rs.getDate("car_date")));
				Car car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				if(rs.getDate("car_date") != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				} else {
					car.setCarDate("");
				}
				list.add(car);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int insertCarOne(Car car, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO car (car_model,car_price,car_date) "
					+ "VALUES(?,?,STR_TO_DATE(?,'%Y-%m-%d')) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getCarModel());
			pstmt.setInt(2, car.getCarPrice());
			pstmt.setString(3, car.getCarDate());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
//			try {
//				if(pstmt != null) pstmt.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
		}
		return result;
	}
}
