package com.example.administrator.day1.ShopFragment.FourFrag_view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.day1.R;
import com.example.administrator.day1.ShopFragment.ShopFragmentActivity;
import com.example.administrator.day1.StyleActivity.NoTitleActivity;

public class MyOrderActivity extends NoTitleActivity implements View.OnClickListener  {

	/*private Handler handler = new Handler(){
		public void handleMessage(Message message){
			switch (message.what){
			}
		}
	};
	new Thread(new Runnable() {
		@Override
		public void run() {
			Message message = new Message();
			message.what = ;
			handler.sendMessage(message);
		}
	}).start();*/

	Button back;
	TextView t1,t2,t3,t4,t5;
	int re_value;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_order);

		back = (Button)findViewById(R.id.order_title_back);
		back.setOnClickListener(this);

		t1 = (TextView)findViewById(R.id.order_t1);
		t2 = (TextView)findViewById(R.id.order_t2);
		t3 = (TextView)findViewById(R.id.order_t3);
		t4 = (TextView)findViewById(R.id.order_t4);
		t5 = (TextView)findViewById(R.id.order_t5);
		t1.setOnClickListener(this);
		t2.setOnClickListener(this);
		t3.setOnClickListener(this);
		t4.setOnClickListener(this);
		t5.setOnClickListener(this);

		SharedPreferences pre = getSharedPreferences("data",0);
		String i = pre.getString("textvalue","");
		if (i.equals("1")){
			t2.performClick();
		}else if (i.equals("2")){
			t3.performClick();
		}else if (i.equals("3")){
			t4.performClick();
		}else if (i.equals("4")){
			t5.performClick();
		}else if (i.equals("0")){
			t1.performClick();
		}



	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.order_t1:
				t1.setTextColor(0xffff0000);
				t2.setTextColor(0xff888888);
				t3.setTextColor(0xff888888);
				t4.setTextColor(0xff888888);
				t5.setTextColor(0xff888888);
				break;

			case R.id.order_t2:
				t2.setTextColor(0xffff0000);
				t1.setTextColor(0xff888888);
				t3.setTextColor(0xff888888);
				t4.setTextColor(0xff888888);
				t5.setTextColor(0xff888888);
				break;

			case R.id.order_t3:
				t3.setTextColor(0xffff0000);
				t2.setTextColor(0xff888888);
				t1.setTextColor(0xff888888);
				t4.setTextColor(0xff888888);
				t5.setTextColor(0xff888888);
				break;

			case R.id.order_t4:
				t4.setTextColor(0xffff0000);
				t2.setTextColor(0xff888888);
				t3.setTextColor(0xff888888);
				t1.setTextColor(0xff888888);
				t5.setTextColor(0xff888888);
				break;
			case R.id.order_t5:
				t5.setTextColor(0xffff0000);
				t2.setTextColor(0xff888888);
				t3.setTextColor(0xff888888);
				t4.setTextColor(0xff888888);
				t1.setTextColor(0xff888888);
				break;

			case R.id.order_title_back:
				Intent intent = new Intent(MyOrderActivity.this, ShopFragmentActivity.class);
				intent.putExtra("shopmine", 3);
				startActivity(intent);
				break;
		}
	}
	/*@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		Bundle bundle = intent.getExtras();
		int text1 = bundle.getInt("tex1");
		if (text1 == 1) {
			t2.setTextColor(0xffff0000);
		}
		int text2 = bundle.getInt("tex2");
		if (text2 == 2) {
			t3.setTextColor(0xffff0000);
		}
		int text3 = bundle.getInt("tex3");
		if (text3 == 3) {
			t4.setTextColor(0xffff0000);
		}
		int text4 = bundle.getInt("tex4");
		if (text4 == 4) {
			t5.setTextColor(0xffff0000);
		}
	}*/

}
