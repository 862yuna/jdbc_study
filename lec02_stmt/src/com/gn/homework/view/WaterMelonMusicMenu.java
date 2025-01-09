package com.gn.homework.view;

import java.util.List;
import java.util.Scanner;

import com.gn.homework.controller.MusicController;
import com.gn.homework.model.vo.WmSong;
import com.gn.homework.model.vo.WmUser;
import com.gn.study.model.vo.Member;

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

		int result = mc.joinMember(memberId, memberPw, memberName);
		
		if(result >0) {
			System.out.println("회원가입이 완료되었습니다.");
		}else {
			System.out.println("동일 아이디가 존재합니다. 회원가입 실패");
		}
		
	}
	
	
	// 로그인 메뉴
	public void login() {
		sc.nextLine();
		System.out.println("=== 로그인 ===");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		 WmUser user = mc.selectUserByIdAndPw(memberId, memberPw);
		// id,pw 를 통해서 로그인을 하고 select 된 정보가 있는지 WmUser 객체자료형으로 가져옴
		// select 된 정보가 있으면 user
//		if(user.getUserId().equals("admin")) {
//			관리자메뉴
//		} else {
//			사용자메뉴
//		}
		if(user != null) {
			System.out.println("로그인에 성공하였습니다.");
			if(user.getUserId().equals("admin")) {
				adminMenu(user);
			}else {
				userMenu(user);
			}
		}else {
			System.out.println("아이디 또는 비밀번호를 확인해주세요.");
		}
		
	}
	// 관리자 메뉴
	public void adminMenu(WmUser user) {
		System.out.println(user.getUserId()+"님, 환영합니다!");
		System.out.println("=== 관리자 메뉴 ===");
		while(true) {
			System.out.println("=== 메뉴를 선택해주세요 ===");
			System.out.println("1. 음악 추가");
			System.out.println("2. 음악 인기 순위 조회");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 : ");
			
			int menu = sc.nextInt();
			switch(menu) {
				case 1 : insertMusic(); break;
				case 2 : countMusic(); break;
				case 0 : System.out.println("프로그램이 종료됩니다."); return;
				default : System.out.println("잘못된 번호입니다."); break;
			}
		}
		
	}
	// 사용자 메뉴
	public void userMenu(WmUser user) {
		System.out.println(user.getUserId()+"님, 환영합니다!");
		while(true) {
			System.out.println("=== 메뉴를 선택해주세요 ===");
			System.out.println("1. 음악 재생");
			System.out.println("2. 개인 정보 수정");
			System.out.println("3. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 : ");
			
			int menu = sc.nextInt();
			switch(menu) {
				case 1 : playMusic(); break;
				case 2 : editUser(); break;
//				case 3 : deleteUser(); break;
				case 0 : System.out.println("프로그램이 종료됩니다."); return;
				default : System.out.println("잘못된 번호입니다."); break;
			}
		}
	}
	// 음악 추가 메뉴(관리자)
	public void insertMusic() {
		sc.nextLine();
		System.out.println("=== 음악 추가하기 ===");
		System.out.print("곡 제목 : ");
		String song = sc.nextLine();
		System.out.print("아티스트 : ");
		String artist = sc.next();
		
		int result = mc.insertMusic(song,artist);
		
		if(result >0) System.out.println("음악이 성공적으로 추가되었습니다.");
		else System.out.println("곡 추가에 실패하였습니다.");
	}
	// 음악 인기 순위 조회(관리자)
	public void countMusic() {
		System.out.println("=== 인기 음악 TOP10 ===");
		List<WmSong> list = mc.countMusic();
		if(list.isEmpty()) System.out.println("조회된 결과가 없습니다.");
		else {
			for(WmSong s : list) {
				System.out.println(s);
			}
		}
	}
	// 음악 재생 메뉴(사용자)
	public void playMusic() {
		System.out.println("=== 사용자 메뉴 ===");
		while(true) {
			System.out.println("=== 메뉴를 선택해주세요 ===");
			System.out.println("1. 전체 음악 목록 출력하기");
			System.out.println("2. 재생 음악 번호 입력");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 : ");
			
			int menu = sc.nextInt();
			switch(menu) {
				case 1 : selectMusicAll(); break;
				case 2 : selectPlayMusicByNumber(); break;
				case 0 : System.out.println("프로그램이 종료됩니다."); return;
				default : System.out.println("잘못된 번호입니다."); break;
			}
		}
	}
	// 전체 음악 목록 출력(번호, 제목, 아티스트) (사용자)
	public void selectMusicAll() {
		System.out.println("=== 전체 음악 목록 출력 ===");
		List<WmSong> list = mc.selectMusicAll();
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(WmSong s : list) {
				System.out.println(s);
			}
		}
	}
	
	// 재생할 음악 번호 입력 -> 재생횟수 증가 (사용자)
	public void selectPlayMusicByNumber() {
		System.out.println("=== 재생할 음악 번호 입력 ===");
		System.out.print("번호를 입력해주세요 : ");
		int songNum = sc.nextInt();
		
		int result = mc.selectPlayMusic(songNum);
		if(result > 0) {
			System.out.println("음악을 재생합니다.");
		}else {
			System.out.println("음악 재생에 실패하였습니다.");
		}
	}
	// 개인 정보 수정
	public void editUser() {
		System.out.println("=== 개인 정보 수정 ===");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		 WmUser user = mc.selectUserByIdAndPw(memberId, memberPw);

		if(user != null) {
			System.out.println("변경할 비밀번호를 입력해주세요");
			System.out.print("비밀번호 : ");
			String pass = sc.nextLine();
//			int result = mc.editUser(pass);
//			if(result > 0) {
//				
//			}
		}else {
			System.out.println("아이디 또는 비밀번호를 확인해주세요.");
		}
	}
	
	
	
	
	
}
