package com.example.administrator.day1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrightOrderActivity extends AppCompatActivity {

	private View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()){
				default:
					break;
			}
		}
	};

	String allPrice = null;
	private List<Goods> goodsList = new ArrayList<>();;
	Button back,pay_buy;
	TextView textView,tprice;
	String i;
	private RightOrederAdapter adapter;

	private Map<Integer,String[]> goodsmap = new HashMap<>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_oright_order);
		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.hide();//隐藏系统标题栏
		}

		goodsmap = new ThreadShopActivity().getAllData();

		pay_buy = (Button)findViewById(R.id.enter_pay);
		pay_buy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				PayPopupWindow payPopupWindow = new PayPopupWindow(OrightOrderActivity.this,listener);
				payPopupWindow.showAtLocation(OrightOrderActivity.this.findViewById(R.id.oright_layout), Gravity.CENTER | Gravity.CENTER, 0, 0);
				payPopupWindow.setPayPopWindowText("购买商品","¥ "+allPrice+" 元");
				//Intent intent = new Intent(OrightOrderActivity.this, PayAccountActivity.class);
				//startActivity(intent);
			}
		});

		tprice = (TextView)findViewById(R.id.shopcar_price);

		back = (Button)findViewById(R.id.order_adr_back);
		SharedPreferences pre = getSharedPreferences("data",0);
		i = pre.getString("rightback","");

		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (i.equals("1")){
					Intent intent = new Intent(OrightOrderActivity.this, ShopFragmentActivity.class);
					intent.putExtra("shopcar", 2);
					startActivity(intent);
				}else if (i.equals("2")){
					Intent intent = new Intent(OrightOrderActivity.this, ShopFragmentActivity.class);
					startActivity(intent);
				}
			}
		});

		//推荐商品数据栏,并返回价钱
		tprice.setText(initReComData());
		RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_order);
		LinearLayoutManager layoutManager = new LinearLayoutManager(OrightOrderActivity.this);//默认垂直布局
		recyclerView.setLayoutManager(layoutManager);
		adapter = new RightOrederAdapter(goodsList,this);
		recyclerView.setAdapter(adapter);
	}

	private String initReComData(){

		if (i.equals("2")){
			//单品购买
			//new ShopPageActivity().getGoodsName();
			allPrice = new ShopPageActivity().getGoodsPrice();
			Goods n1 = new Goods(R.drawable.ic_launcher_background,
					""+new ShopPageActivity().getGoodsName(),
					""+new ShopPageActivity().getGoodsPrice());
			goodsList.add(n1);
		}else if (i.equals("1")){
			// 存储选中商品的价格以及名称集合

			for (int i =goodsList.size()-1;i>-1;i--){
				goodsList.remove(i);
				adapter.notifyItemRemoved(i);//**删除
			}
			AddDataList();
			allPrice = ""+new ThreadShopActivity().getPriceData();

			//goodsList = new ThreadShopActivity().getListData();
		}

		return allPrice;
	}

	public void AddDataList(){
		for (int i=0;i<goodsmap.size();i++) {
			String [] gms = new String[2];
			gms = goodsmap.get(i);
			Goods aaa = new Goods(R.drawable.ic_launcher_background,
					""+gms[0],""+gms[1]);
			goodsList.add(aaa);
		}
	}
}
