package com.javaex.vo;

public class BoardVo {
	
	private int num;
	private String title;
	private String id;
	private String content;
	private int views;
	private String regDate;
	
	public BoardVo(int num, String title, String id, String content, int views, String regDate) {
		this.num = num;
		this.title = title;
		this.id = id;
		this.content = content;
		this.views = views;
		this.regDate = regDate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "boardVo [num=" + num + ", title=" + title + ", id=" + id + ", content=" + content + ", views=" + views
				+ ", regDate=" + regDate + "]";
	}
	
	
	

}
