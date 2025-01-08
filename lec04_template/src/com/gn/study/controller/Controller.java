package com.gn.study.controller;

import java.sql.Connection;
import java.util.List;

import com.gn.study.model.service.Service;
import com.gn.study.model.vo.Car;

// View 로부터 전달받은 데이터 가공 -> Service 전달
public class Controller {
	private Service service = new Service();
	
	public int editCarDate(int carNo,String carDate) {
		return service.editCarDate(carNo,carDate);
	}
	
	public int editCarName(int carNo,String modelName) {
//		Car car = new Car(modelName);
		return service.editCarName(carNo,modelName);
	
	}
	
	public int editCarPrice(int carNo,int carPrice) {
		return service.editCarPrice(carNo,carPrice);
	}
	
	
	public int deleteCarOne(int carNo) {
		return service.deleteCarOne(carNo);
	}
	
	public List<Car> searchCarList(int option, Object obj){
		List<Car> list = service.searchCarList(option,obj);
		return list;
	}
	
	public Car selectCarByModel(String modelName) {
		return service.selectCarByModel(modelName);
	}
	
	public List<Car> selectCarAll(){
		return service.selectCarAll();
	}
	
	public int insertCarOne(String modelName,int price, String date) {
		Car car = new Car(modelName,price,date);
		int result = service.insertCarOne(car);
		return result;
	}
}
