package com.example.administrator.day1.ShopFragment.FourFrag_view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.administrator.day1.HomeFragment.FragmentActivity;
import com.example.administrator.day1.StyleActivity.NoTitleActivity;
import com.example.administrator.day1.R;
import com.example.administrator.day1.ShopFragment.ShopFragmentActivity;

import java.util.ArrayList;
import java.util.List;

public class AddressActivity extends NoTitleActivity implements View.OnClickListener{
	private List<Address> addressList = new ArrayList<>();
	Button add_address,back;
	int isboolend =0;
	String[] datas ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_address);


		back = (Button)findViewById(R.id.address_back);
		back.setOnClickListener(this);
		add_address = (Button)findViewById(R.id.address_add);
		add_address.setOnClickListener(this);

		SharedPreferences pre = getSharedPreferences("data",0);
		String i = pre.getString("information","");
		isboolend = Integer.parseInt(i);

		//推荐商品数据栏
		//initReComData();

		//获取添加的地址信息
		datas = new AddAddressActivity().getInformationData();
		//添加数据
		Address d1 = new Address(datas[0],datas[1],datas[2]);
		addressList.add(d1);

		RecyclerView recyclerView = (RecyclerView)findViewById(R.id.address_recy);
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);//默认垂直布局
		recyclerView.setLayoutManager(layoutManager);
		AddressAdapter adapter = new AddressAdapter(addressList);
		recyclerView.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.address_back:
				//另一个跳转至ShopFragmentActivity。传值 shopmine，3.

				if (isboolend == 1){
					Intent intent = new Intent(AddressActivity.this, FragmentActivity.class);
					startActivity(intent);
				}else if (isboolend == 2){
					Intent intent = new Intent(AddressActivity.this, ShopFragmentActivity.class);
					startActivity(intent);
				}

				break;

			case R.id.address_add:
				Intent intent1 = new Intent(AddressActivity.this, AddAddressActivity.class);
				startActivity(intent1);
				break;
		}
	}

}
