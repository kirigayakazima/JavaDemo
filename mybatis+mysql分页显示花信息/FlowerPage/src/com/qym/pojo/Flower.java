package com.qym.pojo;

public class Flower {
	private int num;
	private String uname;
	private double price;
	private String production;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	@Override
	public String toString() {
		return "Flower [num=" + num + ", uname=" + uname + ", price=" + price
				+ ", production=" + production + "]";
	}
	
}
