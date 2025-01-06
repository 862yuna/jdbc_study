package com.gn.homework.vo;

public class WmPlay {
	private int pNo;
	private int pUserNo;
	private int pMusicNo;
	
	public WmPlay() {}

	public WmPlay(int pNo, int pUserNo, int pMusicNo) {
		this.pNo = pNo;
		this.pUserNo = pUserNo;
		this.pMusicNo = pMusicNo;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public int getpUserNo() {
		return pUserNo;
	}

	public void setpUserNo(int pUserNo) {
		this.pUserNo = pUserNo;
	}

	public int getpMusicNo() {
		return pMusicNo;
	}

	public void setpMusicNo(int pMusicNo) {
		this.pMusicNo = pMusicNo;
	}

	@Override
	public String toString() {
		return "재생목록 [번호=" + pNo + ", 사용자 번호=" + pUserNo + ", 음악 번호=" + pMusicNo + "]";
	}
	
	
}
