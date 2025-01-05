package com.gn.study.view;

import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.MemberController;
import com.gn.study.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	// View : 사용자와의 상호작용
	public void mainMenu() {
		System.out.println("환영합니당");
		// 사용자에게 정보 입력 받아서
		// Controller 에게 전달
		while(true) {
			System.out.println("=== 회원 관리 프로그램 ===");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디 검색");
			System.out.println("4. 회원 이름으로 키워드 검색");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 : ");
			
			int menu = sc.nextInt();
			switch(menu) {
				case 1 : createMember(); break;
				case 2 : selectMemberAll(); break;
				case 3 : searchMemberId(); break;
				case 4 : searchName(); break;
				case 5 : editMember(); break;
				case 0 : System.out.println("잘가 앙녕~"); return;
				default : System.out.println("번호가 잘못됐는뎅..."); break;
			
			}
			
		}
	}
	// 전체 회원 조회
	public void selectMemberAll() {
		System.out.println("=== 회원 전체 조회 ===");
		List<Member> list = mc.selectMemberAll();
		// (1) 만약에 list가 비어있다면 -> 조회된 결과가 없습니다.
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Member m : list) {
				System.out.println(m);
			}
		}
		// (2) 그렇지 않다면 Member 목록 출력.
		
	}
	// 회원 추가 화면
	public void createMember() {
		System.out.println("=== 회원 정보 추가 ===");
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
		int result = mc.insertMember(memberId, memberPw, memberName, memberEmail, memberPhone, memberGender);
		
		if(result >0) {
			System.out.println("성공!");
		}else {
			System.out.println("실패~");
		}
		
	}
	
	// 회원 아이디 검색
	public void searchMemberId() {
		System.out.println("=== 회원 아이디 검색 ===");
		System.out.print("아이디를 입력하세요 : ");
		String myId = sc.nextLine();
		
		List<Member> list = mc.searchMemberId(myId);
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Member m : list) {
				System.out.println(m);
			}
		}
		
		
	}
	
	public void searchName() {
		System.out.println("=== 회원 이름 키워드 검색 ===");
		System.out.print("단어를 입력하세요 : ");
		String name = sc.nextLine();
		List<Member> list = mc.searchName(name);
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Member m : list) {
				System.out.println(m);
			}
		}
		
		
	}
	
	public void editMember() {
		System.out.print("아이디를 입력해주세요 : ");
		String memId = sc.nextLine();
		sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 :");
		String memPw = sc.nextLine();
		int result = mc.checkMember(memId,memPw);
		if(result > 0) {
			while(true) {
				System.out.println("=== 회원 정보 수정 ===");
				System.out.println("1. 비밀번호 변경");
				System.out.println("2. 이름 변경");
				System.out.println("3. 이메일 변경");
				System.out.println("4. 전화번호 변경");
				System.out.println("0. 종료 ");
				
				System.out.print("메뉴 : ");
				
				int menu = sc.nextInt();
				sc.nextLine();
				
				switch(menu) {
				case 1 : editPw(); break;
				case 2 : editName(); break;
				case 3 : editEmail(); break;
				case 4 : editPhone(); break;
				case 0 : System.out.println("수정을 종료합니다."); return;
				default : System.out.println("잘못된 번호입니다.");
				}
			}
			
		}else {
			System.out.println("아이디와 비밀번호를 다시 확인해주세요.");
		}
		
	}
	
	public void editPw() {
		System.out.print("고객님의 아이디를 입력하세요 : ");
		String myId = sc.nextLine();
		sc.nextLine();
		System.out.print("변경할 비밀번호를 입력해주세요 : ");
		String pass = sc.nextLine();
		int result = mc.editPw(pass,myId);
		if(result > 0) {
			System.out.println("비밀번호가 변경되었습니다.");
		}else {
			System.out.println("비밀번호 변경에 실패하였습니다.");
		}
		
	}
	
	public void editName() {
		
	}
	public void editEmail() {
		
	}
	public void editPhone() {
		
	}
	
}
