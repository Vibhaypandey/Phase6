package com.sportyshoes.spring.sportyshoes.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class PurchaseReport {
@Id
private int id;
private String purchasedBy;
private String category ;

private Date dop;
private String orderlist;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPurchasedBy() {
	return purchasedBy;
}
public void setPurchasedBy(String purchasedBy) {
	this.purchasedBy = purchasedBy;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public Date getDop() {
	return dop;
}
public void setDop(Date dop) {
	this.dop = dop;
}
public String getOrderlist() {
	return orderlist;
}
public void setOrderlist(String orderlist) {
	this.orderlist = orderlist;
}
@Override
public String toString() {
	return "PurchaseReport [id=" + id + ", purchasedBy=" + purchasedBy + ", category=" + category + ", dop=" + dop
			+ ", orderlist=" + orderlist + "]";
}
public PurchaseReport() {
	super();
	// TODO Auto-generated constructor stub
}
public PurchaseReport(int id, String purchasedBy, String category, Date dop, String orderlist) {
	super();
	this.id = id;
	this.purchasedBy = purchasedBy;
	this.category = category;
	this.dop = dop;
	this.orderlist = orderlist;
}
}
