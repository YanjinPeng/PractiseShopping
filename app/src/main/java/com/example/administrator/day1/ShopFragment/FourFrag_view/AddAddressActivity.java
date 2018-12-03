package com.example.administrator.day1.ShopFragment.FourFrag_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.day1.StyleActivity.NoTitleActivity;
import com.example.administrator.day1.R;
import com.example.administrator.day1.Utils.ToastUtils;

public class AddAddressActivity extends NoTitleActivity implements View.OnClickListener{
	public static String[] Information = new String[3];
	Button back,right;
	EditText ed_name,ed_pro,ed_city,ed_zone,ed_address,ed_tel;
	Boolean isRight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_address);

		back = (Button)findViewById(R.id.address_add_back);
		back.setOnClickListener(this);
		right = (Button)findViewById(R.id.address_add_r);
		right.setOnClickListener(this);

		ed_name = (EditText)findViewById(R.id.address_add_name);
		ed_pro = (EditText)findViewById(R.id.address_add_pro);
		ed_city = (EditText)findViewById(R.id.address_add_city);
		ed_zone = (EditText)findViewById(R.id.address_add_zone);
		ed_address = (EditText)findViewById(R.id.address_add_address);
		ed_tel = (EditText)findViewById(R.id.address_add_tel);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.address_add_back:
				Intent intent = new Intent(AddAddressActivity.this, AddressActivity.class);
				startActivity(intent);
				break;
			case R.id.address_add_r:
				/********************/
				checkIsOk();
				if (isRight ==true){
					Intent intent1 = new Intent(AddAddressActivity.this, AddressActivity.class);
					intent1.putExtra("checktrue",1);
					startActivity(intent1);
				}
				break;
		}
	}

	public void checkIsOk(){
		isRight = true;
		int [] stats = new int[6];//存储edittext是否为空
		String information = "";
		String name ;
		String address ;
		String tel ;
		if (ed_name.getText().length()<1){
			information = "姓名不能为空 ";
			stats[0] = 0;
		}else {stats[0] = 1;}
		if (ed_pro.getText().length()<1){
			information += " 省份不能为空 ";
			stats[1] = 0;
		}else {stats[1] = 1;}
		if (ed_city.getText().length()<1){
			information += " 城市不能为空 ";
			stats[2] = 0;
		}else {stats[2] = 1;}
		if (ed_zone.getText().length()<1){
			information += " 区域不能为空 ";
			stats[3] = 0;
		}else {stats[3] = 1;}
		if (ed_address.getText().length()<1){
			information += " 地址不能为空 ";
			stats[4] = 0;
		}else {stats[4] = 1;}
		if (ed_tel.getText().length()<1){
			information += " 电话不能为空 ";
			stats[5] = 0;
		}else {stats[5] = 1;}

		for (int i=0;i<stats.length;i++){
			if (stats[i]==0){//为空
				ToastUtils.showToast(this,information);
				isRight = false;
				i=stats.length;
			}
			if (i==stats.length-1 && isRight==true){
				name = ed_name.getText().toString();
				address  = ed_pro.getText().toString()
						+ed_city.getText().toString()
						+ed_zone.getText().toString()
						+ed_address.getText().toString();
				tel = ed_tel.getText().toString();
				Information[0] = name;
				Information[2] = address;
				Information[1] = tel;
				ToastUtils.showToast(this,Information[0]+"\n"
						+Information[1]+"\n"+Information[2]);
			}
		}
	}
	public String[] getInformationData(){
		return Information;
	}
}
