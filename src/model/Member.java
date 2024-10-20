package model;

import java.io.Serializable;

public class Member implements Serializable
{
	//fields
	private Integer id;
	private String name;
	private String account;
	private String password;
	private String email;
	
	//constructors
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String name, String account, String password,String email) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//methods
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
