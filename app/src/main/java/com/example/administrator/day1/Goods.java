package com.example.administrator.day1;

import java.util.HashMap;

public class Goods {
    String price,goods;
    int Imageid;
    // 用来控制CheckBox的选中状况


    public Goods(int Imageid,String goods,String price) {
        this.goods = goods;
        this.price = price;
        this.Imageid = Imageid;
    }

    public String getPrice() {
        return price;
    }
    public int getImageid() {
        return Imageid;
    }
    public String getGoods() {
        return goods;
    }



}