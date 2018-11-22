package com.example.administrator.day1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class NoTitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();//隐藏系统标题栏
        }

    }
}
