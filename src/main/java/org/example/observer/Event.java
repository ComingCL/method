package org.example.observer;

import java.util.Date;

public class Event {
	private String uid;
	private String msg;
	private Date time;
	
	public Event(String uid, String msg, Date time) {
		this.uid = uid;
		this.msg = msg;
		this.time = time;
	}
	public String getMsg() {
		return msg;
	}
	public Date getTime() {
		return time;
	}
	public String getUid() {
		return uid;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
}
