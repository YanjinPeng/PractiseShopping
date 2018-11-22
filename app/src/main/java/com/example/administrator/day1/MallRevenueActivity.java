package com.example.administrator.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MallRevenueActivity extends NoTitleActivity {

	Button back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mall_revenue);
		back = (Button)findViewById(R.id.mall_record_back);
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MallRevenueActivity.this, ShopFragmentActivity.class);
				intent.putExtra("shopmine", 3);
				startActivity(intent);
			}
		});
	}
}
