package com.example.administrator.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddAddressActivity extends NoTitleActivity implements View.OnClickListener{

	Button back,right;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_address);

		back = (Button)findViewById(R.id.address_add_back);
		back.setOnClickListener(this);
		right = (Button)findViewById(R.id.address_add_r);
		right.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.address_add_back:
				Intent intent = new Intent(AddAddressActivity.this, AddressActivity.class);
				startActivity(intent);
				break;
			case R.id.address_add_r:

				break;
		}
	}
}
