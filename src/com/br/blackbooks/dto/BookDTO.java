package com.br.blackbooks.dto;

public class BookDTO {
	private int id;
	private String title;
	private String description;
	private float price;
	
	public BookDTO(int id, String title, String description, float price) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
	}
	
	public BookDTO(String title, String description, float price) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
