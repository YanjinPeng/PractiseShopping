package com.example.administrator.day1.GoodsDetails;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.day1.R;
import com.example.administrator.day1.RecyclerviewAdapter.Goods;
import com.example.administrator.day1.RecyclerviewAdapter.MyPagerAdapter;
import com.example.administrator.day1.ShopFragment.ShopFragmentActivity;
import com.example.administrator.day1.ShopFragment.ShopPageActivity;
import com.example.administrator.day1.ShopFragment.ThreadFrag_view.OrightOrderActivity;
import com.example.administrator.day1.StyleActivity.NoTitleActivity;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends NoTitleActivity implements View.OnClickListener{
	static TextView t1;
	static TextView t2;
	TextView t3;
	TextView t4;
	ImageView imageView;
	Button b_buy;
	LinearLayout l1,l2,l3;

	List<String> strings = new ArrayList<String>();
	String aname,aprice;
	/************************/
	private ViewPager viewPager;
	private LinearLayout pointBar;
	//把图片放入数据中
	int[] imgs = new int[]{R.drawable.center_icon, R.drawable.center_icon,
			R.drawable.center_icon, R.drawable.center_icon,R.drawable.center_icon,
			R.drawable.center_icon, R.drawable.center_icon, R.drawable.center_icon};
	/*************************/

	private List<Goods> goodsList = new ArrayList<>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		b_buy = (Button)findViewById(R.id.layout_goods_buy);
		b_buy.setOnClickListener(this);

		l1 = (LinearLayout)findViewById(R.id.layout_goods_home);
		l1.setOnClickListener(this);
		l2 = (LinearLayout)findViewById(R.id.layout_goods_shop);
		l2.setOnClickListener(this);
		l3 = (LinearLayout)findViewById(R.id.layout_goods_car);
		l3.setOnClickListener(this);


		t1 = (TextView)findViewById(R.id.details_name);
		t2 = (TextView)findViewById(R.id.details_price);
		aname = new ShopPageActivity().getGoodsName();
		aprice = new ShopPageActivity().getGoodsPrice();
		t1.setText(""+aname);
		t2.setText(""+aprice);
		/**
		 * viewpager初始化配置
		 * */
		//初始化控件
		viewPager = findViewById(R.id.view_pager);
		pointBar = findViewById(R.id.point_bar);
		List<View> list = new ArrayList<>();
		//设置ImageView,把图片存入每个ImageView,以便存入list
		for (int i = 0; i < imgs.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(imgs[i]);
			imageView.setId(imgs[i]);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			list.add(imageView);
		}
		//为viewPager设置适配器
		MyPagerAdapter myPagerAdapter = new MyPagerAdapter(list);
		viewPager.setAdapter(myPagerAdapter);
		//ViewPager配置页面改变监听器
		viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int i, float v, int i1) {
				//页面被滑动时所调用的方法
			}
			@Override
			public void onPageSelected(int i) {
				//页面被选择时调用的方法
				setPointBar(i);
			}
			@Override
			public void onPageScrollStateChanged(int i) {
				//页面滚动状态改变时所调用的方法
			}
		});
		//开始时设置小圆点坐标为第一个,否则在应用只会在调用onseleced()方法时才会出现底部栏
		setPointBar(0);
		/***********************/
	}

	/**viewpager设置底部圆点栏**/
	private void setPointBar(int position) {
		//首先移除layout内所有的view,以防出bug
		pointBar.removeAllViews();
		for (int i = 0; i < imgs.length; i++) {
			final int n = i;
			final ImageView imageView = new ImageView(getBaseContext());
			//设置imageview
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
			params.setMargins(10, 0, 10, 0);
			imageView.setLayoutParams(params);
			if (position == i) {
				imageView.setImageResource(R.drawable.green_point);
			} else {
				imageView.setImageResource(R.drawable.blue_point);
				//为每个小圆点设置点击事件,以便于在点击时能切换图片
				imageView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//在点击相对应的底部圆点时切换到对应的图片
						viewPager.setCurrentItem(n);
					}
				});
			}
			pointBar.addView(imageView);
		}
	}/***********************/

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.layout_goods_buy:
				//立即购买
				Intent intentb = new Intent(DetailsActivity.this,OrightOrderActivity.class);

				SharedPreferences prefdz = DetailsActivity.this.getSharedPreferences("data",0);
				SharedPreferences.Editor editordz = prefdz.edit();
				editordz.putString("rightback","2");
				editordz.commit();

				startActivity(intentb);
				break;
			case R.id.layout_goods_home:
				//首页
				Intent intenth = new Intent(DetailsActivity.this,ShopFragmentActivity.class);
				startActivity(intenth);
				break;
			case R.id.layout_goods_shop:
				//联系商家

				break;
			case R.id.layout_goods_car:
				//加入购物车

				break;
		}
	}

}


