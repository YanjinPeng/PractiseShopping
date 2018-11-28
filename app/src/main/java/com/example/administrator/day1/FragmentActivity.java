package com.example.administrator.day1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends NoTitleActivity implements View.OnClickListener{

   /* public static final int f_home = 1;
    public static final int f_property = 2;
    public static final int f_shop = 3;
    public static final int f_mine = 4;

    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            switch (message.what){

            }
        }
    };
     new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = view_id;
                        handler.sendMessage(message);
                    }
                }).start();
    */

    /**
     * 四个导航
     */
    RelativeLayout lintonOne;
    RelativeLayout lintonTwo;
    RelativeLayout lintonThree;
    RelativeLayout lintonFour;
    /**
     * 作为页面容器的ViewPager
     */
    ViewPager mViewPager;
    /**
     * 页面集合
     */
    List<Fragment> fragmentList;

    /**
     * 四个Fragment（页面）
     */
    FristFragment oneFragment;
    SecondFragment twoFragment;
    //ShopPageActivity threeFragment;
    MinePageActivity fourFragment;

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
        setContentView(R.layout.activity_fragment);



        mineImage = (ImageView)findViewById(R.id.bot_mine);
        minetext = (TextView)findViewById(R.id.mine);

        shopImage = (ImageView)findViewById(R.id.bot_shop);
        shoptext = (TextView)findViewById(R.id.shop);

        moenyImage = (ImageView)findViewById(R.id.bot_moeny);
        moenytext = (TextView)findViewById(R.id.moeny);

        homeImage = (ImageView)findViewById(R.id.bot_home);
        hometext = (TextView)findViewById(R.id.home);


        lintonOne=(RelativeLayout)findViewById(R.id.layout_home);
        lintonTwo=(RelativeLayout)findViewById(R.id.layout_moeny);
        lintonThree=(RelativeLayout)findViewById(R.id.layout_mine);
        lintonFour=(RelativeLayout)findViewById(R.id.layout_shop);

        lintonOne.setOnClickListener(this);
        lintonTwo.setOnClickListener(this);
        lintonThree.setOnClickListener(this);
        lintonFour.setOnClickListener(this);

        mViewPager=(ViewPager) findViewById(R.id.viewpager);

        fragmentList=new ArrayList<Fragment>();
        oneFragment=new FristFragment();
        twoFragment=new SecondFragment();
        //threeFragment=new ShopPageActivity();
        fourFragment=new MinePageActivity();

        fragmentList.add(oneFragment);
        fragmentList.add(twoFragment);
        //fragmentList.add(threeFragment);
        fragmentList.add(fourFragment);

        mViewPager.setAdapter(new MyFrageStatePagerAdapter(getSupportFragmentManager()));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.layout_home:
                changeView(0);
                break;
            case R.id.layout_moeny:
                changeView(1);
                break;
            case R.id.layout_mine:
                changeView(2);
                break;
            case R.id.layout_shop:
                //changeView(2);
                Intent intent = new Intent(FragmentActivity.this,
                        ShopFragmentActivity.class);
                startActivity(intent);
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
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        /**
         * 每次更新完成ViewPager的内容后，调用该接口，此处复写主要是为了让导航按钮上层的覆盖层能够动态的移动
         */
        @Override
        public void finishUpdate(ViewGroup container)
        {
            super.finishUpdate(container);//这句话要放在最前面，否则会报错
            //获取当前的视图是位于ViewGroup的第几个位置，用来更新对应的覆盖层所在的位置

            int currentItem=mViewPager.getCurrentItem();
            if (currentItem==currenttab)
            {
                return ;
            }
            //    imageMove(mViewPager.getCurrentItem());

            currenttab=mViewPager.getCurrentItem();
            if (currenttab==2){
                //if (!isflagm){
                //    isflagm = true;
                    mineImage.setSelected(true);
                    minetext.setTextColor(0xffffffff);
                    moenyImage.setSelected(false);
                    moenytext.setTextColor(0xff888888);
                    homeImage.setSelected(false);
                    hometext.setTextColor(0xff888888);
                    shopImage.setSelected(false);
                    shoptext.setTextColor(0xff888888);

              //  }
            }
            if (currenttab==3){
               // if (!isflags){
                  //  isflags = true;
                    shopImage.setSelected(true);
                    shoptext.setTextColor(0xffffffff);
                    moenyImage.setSelected(false);
                    moenytext.setTextColor(0xff888888);
                    homeImage.setSelected(false);
                    hometext.setTextColor(0xff888888);
                    mineImage.setSelected(false);
                    minetext.setTextColor(0xff888888);
                   /* isflagm = false;
                    isflags = false;
                    isflagh = false;
                    isflagq = false;
                }*/
            }
            if (currenttab==1){
                //if (!isflagq){
                //    isflagq = true;
                    moenyImage.setSelected(true);
                    moenytext.setTextColor(0xffffffff);
                    shopImage.setSelected(false);
                    shoptext.setTextColor(0xff888888);
                    homeImage.setSelected(false);
                    hometext.setTextColor(0xff888888);
                    mineImage.setSelected(false);
                    minetext.setTextColor(0xff888888);
                   /* isflagm = false;
                    isflags = false;
                    isflagh = false;
                    isflagq = false;
                }*/
            }
            if (currenttab==0){
               // if (!isflagh){
                 //   isflagh = true;
                    homeImage.setSelected(true);
                    hometext.setTextColor(0xffffffff);
                    moenyImage.setSelected(false);
                    moenytext.setTextColor(0xff888888);
                    shopImage.setSelected(false);
                    shoptext.setTextColor(0xff888888);
                    mineImage.setSelected(false);
                    minetext.setTextColor(0xff888888);
                  /*  isflagm = false;
                    isflags = false;
                    isflagh = false;
                    isflagq = false;
                }*/
            }
        }
    }
    @Override
    protected void onNewIntent(Intent intent) {
        // TODO Auto-generated method stub
        super.onNewIntent(intent);
        int prop = intent.getIntExtra("prop", 0);
        if (prop == 1) {
            changeView(1);
        }

        int mine = intent.getIntExtra("mine", 0);
        if (mine == 3) {
            changeView(2);
        }
    }
    //手动设置ViewPager要显示的视图
    private void changeView(int desTab) {
        mViewPager.setCurrentItem(desTab, true);
    }
}
