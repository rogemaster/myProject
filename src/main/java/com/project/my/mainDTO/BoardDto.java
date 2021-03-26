package com.project.my.mainDTO;

import java.util.Date;

public class BoardDto {
	
	private int no;
	private String title;
	private String contents;
	private String writer;
	private Date reg_date;
	private String sessionId;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", title=" + title + ", contents=" + contents + ", writer=" + writer
				+ ", reg_date=" + reg_date + ", sessionId=" + sessionId + "]";
	}
	

	
	
	
	

}
