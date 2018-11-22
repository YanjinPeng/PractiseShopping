package com.example.administrator.day1;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


/**
 *  PopupWindow弹窗
 *  PayPopupWindow payPopupWindow = new PayPopupWindow(Home_mc_activity.this,listener);
 *  payPopupWindow.showAtLocation(Home_mc_activity.this.findViewById(R.id.home_mc_act), Gravity.CENTER | Gravity.CENTER, 0, 0);
 *	调用上面的方法即可弹出输入支付密码界面
 * **/
public class PayPopupWindow extends PopupWindow implements View.OnClickListener{
	private View window;

	private LinearLayout num_lin,text_lin;
	private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,delet,cleanAll,back;
	private TextView v1,v2,v3,v4,v5,v6,vprice,vname;
	private String [] wordlenth = new String[6];
	private Boolean InputOver = false;
	public String allkey;
	public PayPopupWindow(Context context, View.OnClickListener listener){
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		window = inflater.inflate(R.layout.activity_pay_account, null);

		b0 = (Button)window.findViewById(R.id.number_0);
		b1 = (Button)window.findViewById(R.id.number_1);
		b2 = (Button)window.findViewById(R.id.number_2);
		b3 = (Button)window.findViewById(R.id.number_3);
		b4 = (Button)window.findViewById(R.id.number_4);
		b5 = (Button)window.findViewById(R.id.number_5);
		b6 = (Button)window.findViewById(R.id.number_6);
		b7 = (Button)window.findViewById(R.id.number_7);
		b8 = (Button)window.findViewById(R.id.number_8);
		b9 = (Button)window.findViewById(R.id.number_9);
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

		v1 = (TextView)window.findViewById(R.id.password_t1);
		v2 = (TextView)window.findViewById(R.id.password_t2);
		v3 = (TextView)window.findViewById(R.id.password_t3);
		v4 = (TextView)window.findViewById(R.id.password_t4);
		v5 = (TextView)window.findViewById(R.id.password_t5);
		v6 = (TextView)window.findViewById(R.id.password_t6);

		vprice = (TextView)window.findViewById(R.id.pay_goods_price);
		vname = (TextView)window.findViewById(R.id.pay_goods_name);

		num_lin = (LinearLayout)window.findViewById(R.id.input_number);

		text_lin = (LinearLayout)window.findViewById(R.id.textview_layout);
		text_lin.setOnClickListener(this);

		delet = (Button)window.findViewById(R.id.number_delete1);
		delet.setOnClickListener(this);
		cleanAll = (Button)window.findViewById(R.id.clean_all);
		cleanAll.setOnClickListener(this);
		back = (Button)window.findViewById(R.id.shut_back);
		back.setOnClickListener(this);


		//设置SelectPicPopupWindow的View
		this.setContentView(window);

		//设置SelectPicPopupWindow弹出窗体的宽
		this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);

		//设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

		//设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);

		//实例化一个ColorDrawable颜色为半透明
		ColorDrawable dw = new ColorDrawable(0xb0000000);

		//设置SelectPicPopupWindow弹出窗体的背景
		this.setBackgroundDrawable(dw);

		//设置SelectPicPopupWindow弹出窗体动画效果(从底部弹出效果)
		this.setAnimationStyle(R.style.pop_anim_style);

		//mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
		window.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {

				int height = window.findViewById(R.id.pay_account_r).getTop();
				int y=(int) event.getY();
				if(event.getAction()==MotionEvent.ACTION_UP){
					if(y<height){
						dismiss();
					}
				}
				return true;
			}
		});
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

			case R.id.shut_back:
				dismiss();
				break;
			case R.id.clean_all:
				DeletaAllPassword();

				break;
			case R.id.textview_layout:
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
								allkey = ""+wordlenth[0]+wordlenth[1]+wordlenth[2]+wordlenth[3]+wordlenth[4]+wordlenth[5];
								ToastUtils.showToast(MyApplication.getContext(),""+allkey);
								//dismiss();
							}else {
								ToastUtils.showToast(MyApplication.getContext(),""+key);
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

	/**
	 * 设置支付框内的数据
	 * */
	public void setPayPopWindowText(String payName,String payPrice){
		vprice.setText(payPrice);
		vname.setText(payName);
	}
}
