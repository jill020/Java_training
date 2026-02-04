package com.bpi.m4project;

public class Book {
	private Integer id;
	private String title;
	private String author;
	private boolean borrowed;

	public Book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.borrowed = false;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
