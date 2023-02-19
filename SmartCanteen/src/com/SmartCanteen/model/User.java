package com.SmartCanteen.model;

public class User {
	private String Id;
	private double Account;
	private String name;
	private String PassWord;
	
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public User(String name, String passWord) {
		super();
		this.name = name;
		PassWord = passWord;
	}

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public double getAccount() {
		return Account;
	}
	public void setAccount(double account) {
		Account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
}
