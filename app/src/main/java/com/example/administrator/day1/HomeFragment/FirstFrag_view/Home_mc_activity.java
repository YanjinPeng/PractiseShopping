package com.example.administrator.day1.HomeFragment.FirstFrag_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.day1.HomeFragment.FragmentActivity;
import com.example.administrator.day1.StyleActivity.NoTitleActivity;
import com.example.administrator.day1.Utils.PayPopupWindow;
import com.example.administrator.day1.R;

public class Home_mc_activity extends NoTitleActivity implements View.OnClickListener{

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                default:
                    break;
            }
        }
    };

    Button back,pay,exit_pop;
    Button b500,b1000,b3000,b5000,b10000,b30000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_edit);

        pay = (Button)findViewById(R.id.buy_paying);
        pay.setOnClickListener(this);

        back = (Button)findViewById(R.id.title_back_buy_edit);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_mc_activity.this, FragmentActivity.class);
                // intent.putExtra("id", 0);
                startActivity(intent);
            }
        });
        b500 = (Button)findViewById(R.id.mc_500);
        b1000 = (Button)findViewById(R.id.mc_1000);
        b3000 = (Button)findViewById(R.id.mc_3000);
        b5000 = (Button)findViewById(R.id.mc_5000);
        b10000 = (Button)findViewById(R.id.mc_10000);
        b30000 = (Button)findViewById(R.id.mc_30000);
        b500.setOnClickListener(this);
        b1000.setOnClickListener(this);
        b3000.setOnClickListener(this);
        b5000.setOnClickListener(this);
        b10000.setOnClickListener(this);
        b30000.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mc_500:
                b500.setSelected(true);
                b1000.setSelected(false);
                b3000.setSelected(false);
                b5000.setSelected(false);
                b10000.setSelected(false);
                b30000.setSelected(false);
                break;
            case R.id.mc_1000:
                b500.setSelected(false);
                b1000.setSelected(true);
                b3000.setSelected(false);
                b5000.setSelected(false);
                b10000.setSelected(false);
                b30000.setSelected(false);
                break;
            case R.id.mc_3000:
                b500.setSelected(false);
                b1000.setSelected(false);
                b3000.setSelected(true);
                b5000.setSelected(false);
                b10000.setSelected(false);
                b30000.setSelected(false);
                break;
            case R.id.mc_5000:
                b500.setSelected(false);
                b1000.setSelected(false);
                b3000.setSelected(false);
                b5000.setSelected(true);
                b10000.setSelected(false);
                b30000.setSelected(false);
                break;
            case R.id.mc_10000:
                b500.setSelected(false);
                b1000.setSelected(false);
                b3000.setSelected(false);
                b5000.setSelected(false);
                b10000.setSelected(true);
                b30000.setSelected(false);
                break;
            case R.id.mc_30000:
                b500.setSelected(false);
                b1000.setSelected(false);
                b3000.setSelected(false);
                b5000.setSelected(false);
                b10000.setSelected(false);
                b30000.setSelected(true);
                break;
            case R.id.buy_paying:
                /*****************/
                PayPopupWindow payPopupWindow = new PayPopupWindow(Home_mc_activity.this,listener);
                payPopupWindow.showAtLocation(Home_mc_activity.this.findViewById(R.id.home_mc_act), Gravity.CENTER | Gravity.CENTER, 0, 0);
                //Intent intent = new Intent(Home_mc_activity.this,PayAccountActivity.class);
                //startActivity(intent);
            default:
                break;
        }
    }
}