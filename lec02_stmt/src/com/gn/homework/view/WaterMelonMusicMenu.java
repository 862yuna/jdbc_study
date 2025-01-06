package com.gn.homework.view;

import java.util.Scanner;

import com.gn.homework.controller.MusicController;

public class WaterMelonMusicMenu {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() {
		System.out.println("환영합니다.");
		while(true) {
			System.out.println("=== 메뉴를 선택해주세요 ===");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 : ");
			
			int menu = sc.nextInt();
			switch(menu) {
				case 1 : joinMember(); break;
				case 2 : login(); break;
				case 0 : System.out.println("프로그램이 종료됩니다."); return;
				default : System.out.println("잘못된 번호입니다."); break;
			}
		}
	}
	// 회원 가입 메뉴
	public void joinMember() {
		System.out.println("=== 회원 가입 ===");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPw = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		System.out.print("이메일 : ");
		String memberEmail = sc.nextLine();
		System.out.print("전화번호(-빼고 입력) : ");
		String memberPhone = sc.nextLine();
		System.out.print("성별 : ");
		String memberGender = sc.nextLine();
//		int result = mc.insertMember(memberId, memberPw, memberName, memberEmail, memberPhone, memberGender);
//		
//		if(result >0) {
//			System.out.println("성공!");
//		}else {
//			System.out.println("실패~");
//		}
		
	}
	
	
	// 로그인 메뉴
	public void login() {
		
	}
	
	
	
}
