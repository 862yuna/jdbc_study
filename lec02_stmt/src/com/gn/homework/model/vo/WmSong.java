package com.gn.homework.model.vo;

public class WmSong {
	private int mNo;
	private String mTitle;
	private String mArtist;
	private int mPlay;
	
	public WmSong() {}
	public WmSong(String mTitle,String mArtist) {
		this.mTitle = mTitle;
		this.mArtist = mArtist;
	}
	
	public WmSong(int mNo, String mTitle, String mArtist, int mPlay) {
		super();
		this.mNo = mNo;
		this.mTitle = mTitle;
		this.mArtist = mArtist;
		this.mPlay = mPlay;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmArtist() {
		return mArtist;
	}

	public void setmArtist(String mArtist) {
		this.mArtist = mArtist;
	}

	public int getmPlay() {
		return mPlay;
	}

	public void setmPlay(int mPlay) {
		this.mPlay = mPlay;
	}

	@Override
	public String toString() {
		return "음악 [번호=" + mNo + ", 곡명=" + mTitle + ", 아티스트=" + mArtist + ", 재생 횟수=" + mPlay + "]";
	}
	
	
	
}
