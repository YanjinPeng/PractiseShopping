package com.example.administrator.day1.LoginPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.day1.StyleActivity.NoTitleActivity;
import com.example.administrator.day1.R;

public class RetrieveActivity extends NoTitleActivity implements View.OnClickListener{

    EditText ret_yzm;
    Button  ret_back,ret_tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        ret_yzm = (EditText)findViewById(R.id.retrieve_yzm);
        GradientDrawable myGrad1 = (GradientDrawable)ret_yzm.getBackground();
        myGrad1.setColor(Color.parseColor("#b0b0b0"));//设置shape文件的背景颜色
        myGrad1.setStroke(0, Color.parseColor("#00000000"));

        ret_back = (Button)findViewById(R.id.reterieve_back);
        ret_back.setOnClickListener(this);

        ret_tel = (Button)findViewById(R.id.retrieve_tel_yzm);
        ret_tel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reterieve_back:
                Intent intent = new Intent(RetrieveActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.retrieve_tel_yzm:
                //按钮倒计时60秒，不可点击，第二个参数是设置计时的速度，1000就是每秒一次。
                new CountDownTimer(60000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        ret_tel.setEnabled(false);
                        ret_tel.setText(String.format("%ds",millisUntilFinished/1000));
                    }

                    @Override
                    public void onFinish() {
                        ret_tel.setEnabled(true);
                        ret_tel.setText("重新获取验证码");
                    }
                }.start();
                break;
        }
    }
}
