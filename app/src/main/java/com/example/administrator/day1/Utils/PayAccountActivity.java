package com.example.administrator.day1.Utils;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.day1.R;
import com.example.administrator.day1.StyleActivity.NoTitleActivity;
import com.example.administrator.day1.Utils.ToastUtils;

public class PayAccountActivity extends NoTitleActivity implements View.OnClickListener{

	private LinearLayout num_lin,text_lin;
	private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,delet,cleanAll;
	private TextView v1,v2,v3,v4,v5,v6;
	String [] wordlenth = new String[6];
	Boolean InputOver = false;
	public String allkey;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pay_account);

		b0 = (Button)findViewById(R.id.number_0);
		b1 = (Button)findViewById(R.id.number_1);
		b2 = (Button)findViewById(R.id.number_2);
		b3 = (Button)findViewById(R.id.number_3);
		b4 = (Button)findViewById(R.id.number_4);
		b5 = (Button)findViewById(R.id.number_5);
		b6 = (Button)findViewById(R.id.number_6);
		b7 = (Button)findViewById(R.id.number_7);
		b8 = (Button)findViewById(R.id.number_8);
		b9 = (Button)findViewById(R.id.number_9);
		b0.setOnClickListener(this);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
		b9.setOnClickListener(this);

		v1 = (TextView)findViewById(R.id.password_t1);
		v2 = (TextView)findViewById(R.id.password_t2);
		v3 = (TextView)findViewById(R.id.password_t3);
		v4 = (TextView)findViewById(R.id.password_t4);
		v5 = (TextView)findViewById(R.id.password_t5);
		v6 = (TextView)findViewById(R.id.password_t6);


		num_lin = (LinearLayout)findViewById(R.id.input_number);

		text_lin = (LinearLayout)findViewById(R.id.textview_layout);
		text_lin.setOnClickListener(this);

		delet = (Button)findViewById(R.id.number_delete1);
		delet.setOnClickListener(this);
		cleanAll = (Button)findViewById(R.id.clean_all);
		cleanAll.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.number_0:
				String key0 ="0";
				inputPassword(key0);
				break;
			case R.id.number_1:
				String key1 ="1";
				inputPassword(key1);
				break;
			case R.id.number_2:
				String key2 ="2";
				inputPassword(key2);
				break;
			case R.id.number_3:
				String key3 ="3";
				inputPassword(key3);
				break;
			case R.id.number_4:
				String key4 ="4";
				inputPassword(key4);
				break;
			case R.id.number_5:
				String key5 ="5";
				inputPassword(key5);
				break;
			case R.id.number_6:
				String key6 ="6";
				inputPassword(key6);
				break;
			case R.id.number_7:
				String key7 ="7";
				inputPassword(key7);
				break;
			case R.id.number_8:
				String key8 ="8";
				inputPassword(key8);
				break;
			case R.id.number_9:
				String key9 ="9";
				inputPassword(key9);
				break;
			case R.id.number_delete1:
				DeletePassword();
				break;

			case R.id.textview_layout:

				break;
			case R.id.clean_all:
				DeletaAllPassword();
				break;
		}
	}

	/**
	 * 输入密码处理
	 * 参数为对应键值
	 * */
	public void inputPassword(String key){
		if (v1.getText().toString().equals("")){
			v1.setText(key);
			wordlenth[0] = key;
		}else {
			if (v2.getText().toString().equals("")){
				v2.setText(key);
				wordlenth[1] = key;
			}else {
				if (v3.getText().toString().equals("")){
					v3.setText(key);
					wordlenth[2] = key;
				}else {
					if (v4.getText().toString().equals("")){
						v4.setText(key);
						wordlenth[3] = key;
					}else {
						if (v5.getText().toString().equals("")){
							v5.setText(key);
							wordlenth[4] = key;
						}else {
							if (v6.getText().toString().equals("")){
								v6.setText(key);
								wordlenth[5] = key;
								//InputOver = true;
								allkey = ""+wordlenth[0]+wordlenth[1]+wordlenth[2]+wordlenth[3]+wordlenth[4]+wordlenth[5];
								ToastUtils.showToast(this,""+allkey);
							}else {
								ToastUtils.showToast(this,""+key);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 删除密码 (一位一位的删除)
	 * */
	public void DeletePassword(){
		if (!v6.getText().toString().equals("")){
			v6.setText("");
		}else {
			if (!v5.getText().toString().equals("")){
				v5.setText("");
			}else {
				if (!v4.getText().toString().equals("")){
					v4.setText("");
				}else {
					if (!v3.getText().toString().equals("")){
						v3.setText("");
					}else {
						if (!v2.getText().toString().equals("")){
							v2.setText("");
						}else {
							if (!v1.getText().toString().equals("")){
								v1.setText("");
							}else {

							}
						}
					}
				}
			}
		}
	}
	/**
	 * 清空密码
	 * */
	public void DeletaAllPassword(){
		for (int i =0;i<6;i++){
			wordlenth [i] ="";
		}
		v1.setText("");v4.setText("");
		v2.setText("");v5.setText("");
		v3.setText("");v6.setText("");
	}
}
