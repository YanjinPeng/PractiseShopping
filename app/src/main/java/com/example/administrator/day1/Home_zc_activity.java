package com.example.administrator.day1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_zc_activity extends NoTitleActivity {

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuanc);

        back = (Button)findViewById(R.id.title_back_zhuanchu);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_zc_activity.this, FragmentActivity.class);
               // intent.putExtra("id", 0);
                startActivity(intent);
            }
        });
    }
}