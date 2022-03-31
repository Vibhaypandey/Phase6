package com.sportyshoes.spring.sportyshoes.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shoe {
	@Id
	private int id;
	private String name;
	private String category;
	private double price;
	public Shoe(int id, String name, String category, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	public Shoe() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ShoeDetaits [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
