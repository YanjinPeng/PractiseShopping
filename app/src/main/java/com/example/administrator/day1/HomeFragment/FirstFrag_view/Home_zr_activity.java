package com.example.administrator.day1.HomeFragment.FirstFrag_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.day1.HomeFragment.FragmentActivity;
import com.example.administrator.day1.StyleActivity.NoTitleActivity;
import com.example.administrator.day1.R;

public class Home_zr_activity extends NoTitleActivity {

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuanr);

        back = (Button)findViewById(R.id.title_back_zhuanru);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_zr_activity.this, FragmentActivity.class);
                startActivity(intent);
            }
        });
    }
    /*@Override
    protected void onNewIntent(Intent intent) {
        // TODO Auto-generated method stub
        super.onNewIntent(intent);
        int id = intent.getIntExtra("id", 0);
        if (id == 1) {
            tb.switchContent(homeFragment);
        }
    }*/
}