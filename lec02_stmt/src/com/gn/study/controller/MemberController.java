package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

public class MemberController {
	
	public List<Member> selectMemberAll() {
		List<Member> list = new MemberDao().selectMemberAll();
		return list;
	}
	
	public int insertMember(String memberId,String memberPw,String memberName
			,String memberEmail,String memberPhone,String memberGender) {
		Member m = new Member(memberId,memberPw,memberName,memberEmail,memberPhone,memberGender);
		int result = new MemberDao().insertMember(m);
		
//		if(result >0) {
//			// 성공
//		}else {
//			// 실패
//		}
		return result;
	}
	
	public List<Member> searchMemberId(String myId) {
		List<Member> list = new MemberDao().searchMemberId(myId);
		return list;
		
	}
	
	public List<Member> searchName(String name){
		List<Member> list = new MemberDao().searchName(name);
		return list;
	}
	
	public int checkMember(String memId,String memPw) {
		int result = new MemberDao().checkMember(memId,memPw);
		System.out.println("나는 Controller" + result);
		return result;
	}
	
	public int editPw(String pass, String myId) {
		int result = new MemberDao().editPw(pass, myId);
		return result;
	}
}
