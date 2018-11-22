package com.example.administrator.day1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddressActivity extends NoTitleActivity implements View.OnClickListener{
	Button add_address,back;
	int isboolend =0;
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
