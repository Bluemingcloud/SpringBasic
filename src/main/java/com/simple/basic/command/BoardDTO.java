package com.simple.basic.command;

public class BoardDTO {
	
	private int num;
	private String name;
	private String title;
	private String content;
	
	public BoardDTO() {
	}

	public BoardDTO(int num, String name, String title, String content) {
		super();
		this.num = num;
		this.name = name;
		this.title = title;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", name=" + name + ", title=" + title + ", content=" + content + "]";
	}
	

}
