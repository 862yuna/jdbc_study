package com.gn.homework.controller;

import java.util.List;

import com.gn.homework.model.dao.MusicDao;
import com.gn.homework.model.vo.WmSong;
import com.gn.homework.model.vo.WmUser;

public class MusicController {
	public int deleteUser(String memId,String memPw) {
		int result = new MusicDao().deleteUser(memId,memPw);
		return result;
	}
	
	public int editUser(String memPw,String pass) {
		int result = new MusicDao().editUser(memPw,pass);
		return result;
	}
	
	public WmUser selectOneByPw(String memPw) {
		return new MusicDao().selectOneByPw(memPw);
		
	}
	
	public int joinMember(String memberId,String memberPw,String memberName) {
		WmUser u = new WmUser(memberId,memberPw,memberName);
		int result = new MusicDao().joinMember(u);
		return result;
	}
	
	public WmUser selectUserByIdAndPw(String memberId,String memberPw) {
		return new MusicDao().selectUserByIdAndPw(memberId,memberPw);
	}
	
	public int insertMusic(String song,String artist) {
		WmSong s = new WmSong(song,artist);
		int result = new MusicDao().insertMusic(s);
		return result;
	}
	
	public List<WmSong> selectMusicAll(){
		List<WmSong> list = new MusicDao().selectMusicAll();
		return list;
	}
	
	public int selectPlayMusic(int songNum) {
		int result = new MusicDao().selectPlayMusic(songNum);
		return result;
	}
	
	public List<WmSong> countMusic(){
		List<WmSong> list = new MusicDao().countMusic();
		return list;
	}
	
}
