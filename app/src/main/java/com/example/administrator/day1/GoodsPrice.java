package com.example.administrator.day1;

public class GoodsPrice {
	String goods;
	int Imageid,price;
	// 用来控制CheckBox的选中状况


	public GoodsPrice(int Imageid,String goods,int price) {
		this.goods = goods;
		this.price = price;
		this.Imageid = Imageid;
	}

	public int getPrice() {
		return price;
	}
	public int getImageid() {
		return Imageid;
	}
	public String getGoods() {
		return goods;
	}



}