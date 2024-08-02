package com.simple.basic.command;

public class QuizUserVO {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	
	public QuizUserVO() {
	}

	public QuizUserVO(String id, String pw, String name, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "QuizUserVO [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + "]";
	}
	
	

}
