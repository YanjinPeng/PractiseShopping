package com.example.administrator.day1.HomeFragment.FirstFrag_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.day1.HomeFragment.FragmentActivity;
import com.example.administrator.day1.R;
import com.example.administrator.day1.StyleActivity.NoTitleActivity;

public class QRcode_share extends NoTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenxiang);

        Button back = (Button)findViewById(R.id.title_back_fenxiang);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QRcode_share.this, FragmentActivity.class);
                startActivity(intent);
            }
        });
    }
}
