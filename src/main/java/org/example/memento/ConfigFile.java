package org.example.memento;

import java.util.Date;

public class ConfigFile {
	// 版本号
	private String versionNo;
	// 内容
	private String content;
	// 时间
	private Date dateTime;
	// 操作人
	private String operator;
	public ConfigFile(String versionNo, String content, Date dateTime, String operator) {
		this.versionNo = versionNo;
		this.content = content;
		this.dateTime = dateTime;
		this.operator = operator;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public String getContent() {
		return content;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public String getOperator() {
		return operator;
	}
	public String getVersionNo() {
		return versionNo;
	}
}
