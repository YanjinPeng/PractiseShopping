package com.example.administrator.day1;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShopFragmentActivity extends NoTitleActivity implements View.OnClickListener{
    /**
     * 四个导航
     */
    RelativeLayout RelativeOne;
    RelativeLayout RelativeTwo;
    RelativeLayout RelativeThree;
    RelativeLayout RelativeFour;


    /**
     * 作为页面容器的ViewPager
     */
    ViewPager shopViewPager;
    /**
     * 页面集合
     */
    List<Fragment> fragmentList1;

    /**
     * 四个Fragment（页面）
     */
    ShopPageActivity oneFragment1;
    SecondShopActivity twoFragment1;
    ThreadShopActivity threeFragment1;
    FourthShopActivity fourFragment1;

    //屏幕宽度
    int screenWidth;
    //当前选中的项
    int currenttab=-1;


    ImageView mineImage,moenyImage,homeImage,shopImage;
    // boolean isflagm = false,isflags = false,isflagh = false,isflagq = false;
    TextView minetext,moenytext,hometext,shoptext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_fragment);

        mineImage = (ImageView)findViewById(R.id.shop_bot_mine);
        minetext = (TextView)findViewById(R.id.shop_mine);

        shopImage = (ImageView)findViewById(R.id.shop_bot_car);
        shoptext = (TextView)findViewById(R.id.shop_car);

        moenyImage = (ImageView)findViewById(R.id.shop_bot_fenlei);
        moenytext = (TextView)findViewById(R.id.shop_fenlei);

        homeImage = (ImageView)findViewById(R.id.shop_bot_home);
        hometext = (TextView)findViewById(R.id.shop_home);


        RelativeOne=(RelativeLayout)findViewById(R.id.shop_layout_home);
        RelativeTwo=(RelativeLayout)findViewById(R.id.shop_layout_fenlei);
        RelativeThree=(RelativeLayout)findViewById(R.id.shop_layout_car);
        RelativeFour=(RelativeLayout)findViewById(R.id.shop_layout_mine);

        RelativeOne.setOnClickListener(this);
        RelativeTwo.setOnClickListener(this);
        RelativeThree.setOnClickListener(this);
        RelativeFour.setOnClickListener(this);

        shopViewPager=(ViewPager) findViewById(R.id.shop_viewpager);

        fragmentList1 = new ArrayList<Fragment>();
        oneFragment1 = new ShopPageActivity();
        twoFragment1  =  new SecondShopActivity();
        threeFragment1 = new ThreadShopActivity();
        fourFragment1 = new FourthShopActivity();


        fragmentList1.add(oneFragment1);
        fragmentList1.add(twoFragment1);
        fragmentList1.add(threeFragment1);
        fragmentList1.add(fourFragment1);

        shopViewPager.setAdapter(new MyFrageStatePagerAdapter(getSupportFragmentManager()));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.shop_layout_home:
                changeView(0);
                break;
            case R.id.shop_layout_fenlei:
                changeView(1);
                break;
            case R.id.shop_layout_mine:
                changeView(3);
                break;
            case R.id.shop_layout_car:
                changeView(2);
                break;
            default:
                break;
        }
    }


    /**
     * 定义自己的ViewPager适配器。
     */
    class MyFrageStatePagerAdapter extends FragmentStatePagerAdapter
    {

        public MyFrageStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList1.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList1.size();
        }

        /**
         * 每次更新完成ViewPager的内容后，调用该接口，此处复写主要是为了让导航按钮上层的覆盖层能够动态的移动
         */
        @Override
        public void finishUpdate(ViewGroup container)
        {
            super.finishUpdate(container);//这句话要放在最前面，否则会报错
            //获取当前的视图是位于ViewGroup的第几个位置，用来更新对应的覆盖层所在的位置

            int currentItem=shopViewPager.getCurrentItem();
            if (currentItem==currenttab)
            {
                return ;
            }
            //    imageMove(mViewPager.getCurrentItem());

            currenttab=shopViewPager.getCurrentItem();
            if (currenttab==3){

                    mineImage.setSelected(true);
                    minetext.setTextColor(0xffffffff);
                    moenyImage.setSelected(false);
                    moenytext.setTextColor(0xff888888);
                    homeImage.setSelected(false);
                    hometext.setTextColor(0xff888888);
                    shopImage.setSelected(false);
                    shoptext.setTextColor(0xff888888);
            }
            if (currenttab==2){

                    shopImage.setSelected(true);
                    shoptext.setTextColor(0xffffffff);
                    moenyImage.setSelected(false);
                    moenytext.setTextColor(0xff888888);
                    homeImage.setSelected(false);
                    hometext.setTextColor(0xff888888);
                    mineImage.setSelected(false);
                    minetext.setTextColor(0xff888888);

            }
            if (currenttab==1){

                    moenyImage.setSelected(true);
                    moenytext.setTextColor(0xffffffff);
                    shopImage.setSelected(false);
                    shoptext.setTextColor(0xff888888);
                    homeImage.setSelected(false);
                    hometext.setTextColor(0xff888888);
                    mineImage.setSelected(false);
                    minetext.setTextColor(0xff888888);

            }
            if (currenttab==0){

                    homeImage.setSelected(true);
                    hometext.setTextColor(0xffffffff);
                    moenyImage.setSelected(false);
                    moenytext.setTextColor(0xff888888);
                    shopImage.setSelected(false);
                    shoptext.setTextColor(0xff888888);
                    mineImage.setSelected(false);
                    minetext.setTextColor(0xff888888);

            }
        }
    }
    @Override
    protected void onNewIntent(Intent intent) {
        // TODO Auto-generated method stub
        super.onNewIntent(intent);

        int classify = intent.getIntExtra("classify", 0);
        if (classify == 1) {
            changeView(1);
        }

        int shopcar = intent.getIntExtra("shopcar", 0);
        if (shopcar == 2) {
            changeView(2);
        }

        int shopmine = intent.getIntExtra("shopmine", 0);
        if (shopmine == 3) {
            changeView(3);
        }
    }
    //手动设置ViewPager要显示的视图
    private void changeView(int desTab) {
        shopViewPager.setCurrentItem(desTab, true);
    }
}
