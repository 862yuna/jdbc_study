package com.gn.study.view;

import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.Controller;
import com.gn.study.model.vo.Car;

// 사용자가 보게될 화면
// - 사용자에게 정보 입력받기
// - 결과 화면 출력
public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Controller controller = new Controller();
	public void mainMenu() {
		while(true) {
			System.out.println("=== 자동차 정보 관리 ===");
			System.out.println("1. 추가");
			System.out.println("2. 목록 조회");
			System.out.println("3. 단일 조회");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : insertCarOne(); break;
				case 2 : selectCarAll(); break;
				case 3 : selectCarByModel(); break;
				case 4 : break;
				case 5 : break;
			}
		}
	}
	public void selectPrint(Car car) {
		if(car != null) System.out.println(car);
		else System.out.println("존재하지 않는 정보입니다.");
	}
	
	public void selectCarByModel() {
		System.out.println("*** 단일 조회 ***");
		System.out.print("모델명 : ");
		String modelName = sc.nextLine();
		Car car = controller.selectCarByModel(modelName);
		selectPrint(car);
		
	}
	
	public void selectCarAll() {
		System.out.println("*** 목록 조회 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
	}
	
	public void printList(List<Car> list) {
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Car c : list) {
				System.out.println(c);
			}
		}
	}
	
	public void insertCarOne() {
		System.out.println("*** 추가 ***");
		System.out.println("다만, 출시일은 반드시 OOOO-OO-OO 형식으로 입력해주세요.");
		System.out.print("모델명 : ");
		String modelName = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("출시일 정보를 입력하시겠습니까?(Y/N) : ");
		String dateFlag = sc.nextLine();
		String date = null;
		if("Y".equals(dateFlag)) {
			System.out.print("출시일 : ");
			date = sc.nextLine();
		}
		int result = controller.insertCarOne(modelName,price,date);
		dmlResultPrint(result,"추가");
	}
	
	public void dmlResultPrint(int result,String menuName) {
		if(result > 0) System.out.println(menuName+"이(가) 정상 수행되었습니다.");
		else System.out.println(menuName+"중 오류가 발생하였습니다.");
	}
}
