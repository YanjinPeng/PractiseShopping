package com.example.administrator.day1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BottomActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView mineImage,moenyImage,homeImage,shopImage;
    boolean isflagm = false,isflags = false,isflagh = false,isflagq = false;
    TextView minetext,moenytext,hometext,shoptext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_style);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();//隐藏系统标题栏
        }

        mineImage = (ImageView)findViewById(R.id.bot_mine);
        mineImage.setOnClickListener(this);
        minetext = (TextView)findViewById(R.id.mine);
        minetext.setOnClickListener(this);
        shopImage = (ImageView)findViewById(R.id.bot_shop);
        shopImage.setOnClickListener(this);
        shoptext = (TextView)findViewById(R.id.shop);
        shoptext.setOnClickListener(this);
        moenyImage = (ImageView)findViewById(R.id.bot_moeny);
        moenyImage.setOnClickListener(this);
        moenytext = (TextView)findViewById(R.id.moeny);
        moenytext.setOnClickListener(this);
        homeImage = (ImageView)findViewById(R.id.bot_home);
        homeImage.setOnClickListener(this);
        hometext = (TextView)findViewById(R.id.home);
        hometext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bot_mine:
                if (!isflagm){
                    isflagm = true;
                    mineImage.setSelected(true);
                    minetext.setTextColor(0xffffffff);
                    moenyImage.setSelected(false);
                    moenytext.setTextColor(0xff888888);
                    homeImage.setSelected(false);
                    hometext.setTextColor(0xff888888);
                    shopImage.setSelected(false);
                    shoptext.setTextColor(0xff888888);
                    isflagm = false;
                    isflags = false;
                    isflagh = false;
                    isflagq = false;
                }
                break;
            case R.id.bot_shop:
                if (!isflags){
                    isflags = true;
                    shopImage.setSelected(true);
                    shoptext.setTextColor(0xffffffff);
                    moenyImage.setSelected(false);
                    moenytext.setTextColor(0xff888888);
                    homeImage.setSelected(false);
                    hometext.setTextColor(0xff888888);
                    mineImage.setSelected(false);
                    minetext.setTextColor(0xff888888);
                    isflagm = false;
                    isflags = false;
                    isflagh = false;
                    isflagq = false;
                }
                break;
            case R.id.bot_moeny:
                if (!isflagq){
                    isflagq = true;
                    moenyImage.setSelected(true);
                    moenytext.setTextColor(0xffffffff);
                    shopImage.setSelected(false);
                    shoptext.setTextColor(0xff888888);
                    homeImage.setSelected(false);
                    hometext.setTextColor(0xff888888);
                    mineImage.setSelected(false);
                    minetext.setTextColor(0xff888888);
                    isflagm = false;
                    isflags = false;
                    isflagh = false;
                    isflagq = false;
                }
                break;
            case R.id.bot_home:
                if (!isflagh){
                    isflagh = true;
                    homeImage.setSelected(true);
                    hometext.setTextColor(0xffffffff);
                    moenyImage.setSelected(false);
                    moenytext.setTextColor(0xff888888);
                    shopImage.setSelected(false);
                    shoptext.setTextColor(0xff888888);
                    mineImage.setSelected(false);
                    minetext.setTextColor(0xff888888);
                    isflagm = false;
                    isflags = false;
                    isflagh = false;
                    isflagq = false;
                }
                break;
            default:
                break;
        }
    }


}