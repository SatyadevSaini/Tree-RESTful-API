package com.incapp.bean;

import org.springframework.stereotype.Component;

@Component
public class Tree {
   
	private int id;
	private  String name, fruit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFruit() {
		return fruit;
	}
	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
	
}
