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
	
	public Member selectMemberId(String myId) {
//		Member m = new MemberDao().selectMemberId(myId);
//		return m;
		return new MemberDao().selectMemberId(myId);
	}
	
	public List<Member> searchName(String name){
		List<Member> list = new MemberDao().searchName(name);
		return list;
	}
	
	public Member selectMemberOneByIdAndPw(String memId,String memPw) {
		return new MemberDao().selectMemberOneByIdAndPw(memId,memPw);
		
	}
	
	public int updateMemberInfo(String myId,String name, String phone,String email) {
		int result = new MemberDao().updateMemberInfo(myId,name,phone,email);
		return result;
	}
	
	public int deleteMember(String id,String pw) {
		int result = new MemberDao().deleteMember(id,pw);
		return result;
	}
}
