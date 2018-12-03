package com.example.administrator.day1.ShopFragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.day1.R;

public class SecondShopActivity extends Fragment implements View.OnClickListener{

    public static final int r_1 = 1;
    public static final int r_2 = 2;
    public static final int r_3 = 3;
    public static final int r_4 = 4;

    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            switch (message.what){
                case r_1:
                    t1.setTextColor(0xffff0000);
                    rv1.setVisibility(View.VISIBLE);
                    t2.setTextColor(0xff888888);
                    rv2.setVisibility(View.GONE);
                    t3.setTextColor(0xff888888);
                    rv3.setVisibility(View.GONE);
                    t4.setTextColor(0xff888888);
                    rv4.setVisibility(View.GONE);
                    if (!once_ag){
                        c1.setVisibility(View.VISIBLE);
                        b1.setText("v");
                        once_ag = true;
                    }
                    break;
                case r_2:
                    t2.setTextColor(0xffff0000);
                    rv2.setVisibility(View.VISIBLE);
                    t1.setTextColor(0xff888888);
                    rv1.setVisibility(View.GONE);
                    t3.setTextColor(0xff888888);
                    rv3.setVisibility(View.GONE);
                    t4.setTextColor(0xff888888);
                    rv4.setVisibility(View.GONE);
                    if (!once_ag1){
                        c2.setVisibility(View.VISIBLE);
                        b2.setText("v");
                        once_ag1 = true;
                    }
                    //触发点击一次按钮--b2.performClick();
                    break;
                case r_3:
                    t3.setTextColor(0xffff0000);
                    rv3.setVisibility(View.VISIBLE);
                    t1.setTextColor(0xff888888);
                    rv1.setVisibility(View.GONE);
                    t2.setTextColor(0xff888888);
                    rv2.setVisibility(View.GONE);
                    t4.setTextColor(0xff888888);
                    rv4.setVisibility(View.GONE);
                    if (!once_ag2){
                        c3.setVisibility(View.VISIBLE);
                        b3.setText("v");
                        once_ag2 = true;
                    }
                    break;
                case r_4:
                    t4.setTextColor(0xffff0000);
                    rv4.setVisibility(View.VISIBLE);
                    t1.setTextColor(0xff888888);
                    rv1.setVisibility(View.GONE);
                    t2.setTextColor(0xff888888);
                    rv2.setVisibility(View.GONE);
                    t3.setTextColor(0xff888888);
                    rv3.setVisibility(View.GONE);
                    if (!once_ag3){
                        c4.setVisibility(View.VISIBLE);
                        b4.setText("v");
                        once_ag3 = true;
                    }
                    break;
                default:
                    break;
            }
        }
    };

    TextView t1,t2,t3,t4;
    View rv1,rv2,rv3,rv4;
    RelativeLayout re1,re2,re3,re4;
    RelativeLayout c1,c2,c3,c4;
    Button b1,b2,b3,b4;
    boolean once_ag,once_ag1,once_ag2,once_ag3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shop_classify, container, false);

        t1 = (TextView)view.findViewById(R.id.classify_1);
        t2 = (TextView)view.findViewById(R.id.classify_2);
        t3 = (TextView)view.findViewById(R.id.classify_3);
        t4 = (TextView)view.findViewById(R.id.classify_4);


        c1 = (RelativeLayout)view.findViewById(R.id.classify_gone1);
        c2 = (RelativeLayout)view.findViewById(R.id.classify_gone2);
        c3 = (RelativeLayout)view.findViewById(R.id.classify_gone3);
        c4 = (RelativeLayout)view.findViewById(R.id.classify_gone4);

        re1 = (RelativeLayout)view.findViewById(R.id.classify_layout1);
        re2 = (RelativeLayout)view.findViewById(R.id.classify_layout2);
        re3 = (RelativeLayout)view.findViewById(R.id.classify_layout3);
        re4 = (RelativeLayout)view.findViewById(R.id.classify_layout4);
        re1.setOnClickListener(this);
        re2.setOnClickListener(this);
        re3.setOnClickListener(this);
        re4.setOnClickListener(this);

        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);

        rv1 = (View)view.findViewById(R.id.classify_v1);
        rv2 = (View)view.findViewById(R.id.classify_v2);
        rv3 = (View)view.findViewById(R.id.classify_v3);
        rv4 = (View)view.findViewById(R.id.classify_v4);

        b1 = (Button)view.findViewById(R.id.listv_b1);
        b2 = (Button)view.findViewById(R.id.listv_b2);
        b3 = (Button)view.findViewById(R.id.listv_b3);
        b4 = (Button)view.findViewById(R.id.listv_b4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.classify_layout1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = r_1;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.classify_layout2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = r_2;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.classify_layout3:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = r_3;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.classify_layout4:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = r_4;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.listv_b1:
                if (!once_ag){
                    c1.setVisibility(View.VISIBLE);
                    b1.setText("v");
                    once_ag = true;
                }else {
                    c1.setVisibility(View.GONE);
                    b1.setText(">");
                    once_ag = false;
                }
                break;
            case R.id.listv_b2:
                if (!once_ag1){
                    c2.setVisibility(View.VISIBLE);
                    b2.setText("v");
                    once_ag1 = true;
                }else {
                    c2.setVisibility(View.GONE);
                    b2.setText(">");
                    once_ag1 = false;
                }
                break;
            case R.id.listv_b3:
                if (!once_ag2){
                    c3.setVisibility(View.VISIBLE);
                    b3.setText("v");
                    once_ag2 = true;
                }else {
                    c3.setVisibility(View.GONE);
                    b3.setText(">");
                    once_ag2 = false;
                }
                break;
            case R.id.listv_b4:
                if (!once_ag3){
                    c4.setVisibility(View.VISIBLE);
                    b4.setText("v");
                    once_ag3 = true;
                }else {
                    c4.setVisibility(View.GONE);
                    b4.setText(">");
                    once_ag3 = false;
                }
                break;
            default:
                break;
        }
    }
}