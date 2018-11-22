package com.example.administrator.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UpMarchantsActivity extends NoTitleActivity {

	Button refer,up;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_up_marchants);
		refer = (Button)findViewById(R.id.refer_btn);
		up = (Button)findViewById(R.id.up_back);
		up.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(UpMarchantsActivity.this, ShopFragmentActivity.class);
				intent.putExtra("shopmine", 3);
				startActivity(intent);
			}
		});
	}
}
