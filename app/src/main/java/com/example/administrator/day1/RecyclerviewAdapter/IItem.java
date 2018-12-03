package com.example.administrator.day1.RecyclerviewAdapter;

/**
 * 通过回调的方式获取到item的position
 * IItem 为回调函数
 * setOnItem()为实现回调的方法
 * **/

public interface IItem {
	void setOnItem(int postion,String name,String price);
}
