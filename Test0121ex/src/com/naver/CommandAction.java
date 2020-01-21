package com.naver;

public class CommandAction {
	private boolean isRediret;
	private String where;
	public CommandAction() {
		// TODO Auto-generated constructor stub
	}
	public CommandAction(boolean isRediret, String where) {
		super();
		this.isRediret = isRediret;
		this.where = where;
	}
	public boolean isRediret() {
		return isRediret;
	}
	public void setRediret(boolean isRediret) {
		this.isRediret = isRediret;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	
	
}
