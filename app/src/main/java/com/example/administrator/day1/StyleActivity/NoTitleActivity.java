package com.example.administrator.day1.StyleActivity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.day1.R;
import com.example.administrator.day1.Utils.ToastUtils;


public class NoTitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //判断手机版本是否为5.0以上的版本，5.0以上才支持沉浸式效果
		/*if (Build.VERSION.SDK_INT >= 21) {
			View decorView = getWindow().getDecorView();
			//SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION 将导航栏隐藏
			//SYSTEM_UI_FLAG_FULLSCREEN表示全屏的意思，也就是会将状态栏隐藏
			int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
					//| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
					| View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
			decorView.setSystemUiVisibility(option);
			//fitsSystemWindows="true"
			//设置导航栏为透明
			getWindow().setNavigationBarColor(Color.TRANSPARENT);
			//设置状态栏为透明windowTranslucentStatus
			getWindow().setStatusBarColor(Color.TRANSPARENT);

			}*/
			getStatusBarHeight();
			ToastUtils.showToast(this,""+getStatusBarHeight());
		//获取根部局id
		//((ViewGroup)findViewById(android.R.id.content)).getChildAt(0).getId();


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();//隐藏系统标题栏
        }

    }


	/**
	 * 获取状态栏高度
	 * @return
	 */
	private int getStatusBarHeight() {
		int result = 0;
		int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0) {
			result = getResources().getDimensionPixelSize(resourceId);
		}
		return result;
	}

	//设置布局距离状态栏高度
	/*public void setLayoutPadding(Activity activity, DrawerLayout drawerLayout) {
		ViewGroup contentLayout = (ViewGroup) drawerLayout.getChildAt(0);
		contentLayout.getChildAt(1)
				.setPadding(contentLayout.getPaddingLeft(), getStatusBarHeight() + contentLayout.getPaddingTop(),
						contentLayout.getPaddingRight(), contentLayout.getPaddingBottom());
	}

	public void heigVV(){
		this.getWindowManager().getDefaultDisplay();
		Rect outRect = new Rect();
		this.getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
	}*/
}
