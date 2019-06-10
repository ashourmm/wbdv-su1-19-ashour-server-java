package com.example.wbdvsu119ashourserverjava.models;

public class Widget {
	private Long id;
	private String name;
	private String type;
	private String text;
	private int size;
	private String listItems;
	private Boolean ordered;
	
	public Widget(Long id, String name, String type, String text, int size, String listItems, Boolean ordered) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.text = text;
		this.size = size;
		this.listItems = listItems;
		this.ordered = ordered;
	}
	public String getListItems() {
		return listItems;
	}
	public void setListItems(String listItems) {
		this.listItems = listItems;
	}
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Boolean getOrdered() {
		return ordered;
	}
	public void setOrdered(Boolean ordered) {
		this.ordered = ordered;
	}

	public Widget() {
		super();
	}
	

}
