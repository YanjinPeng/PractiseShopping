package com.example.administrator.day1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_mr_activity extends NoTitleActivity implements View.OnClickListener{

    Button back,b500,b1000,b3000,b5000,b10000,b30000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        back = (Button)findViewById(R.id.title_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_mr_activity.this, FragmentActivity.class);
                // intent.putExtra("id", 0);
                startActivity(intent);
            }
        });
        b500 = (Button)findViewById(R.id.mr_500);
        b1000 = (Button)findViewById(R.id.mr_1000);
        b3000 = (Button)findViewById(R.id.mr_3000);
        b5000 = (Button)findViewById(R.id.mr_5000);
        b10000 = (Button)findViewById(R.id.mr_10000);
        b30000 = (Button)findViewById(R.id.mr_30000);
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
            case R.id.mr_500:
                b500.setSelected(true);
                b1000.setSelected(false);
                b3000.setSelected(false);
                b5000.setSelected(false);
                b10000.setSelected(false);
                b30000.setSelected(false);
                break;
            case R.id.mr_1000:
                b500.setSelected(false);
                b1000.setSelected(true);
                b3000.setSelected(false);
                b5000.setSelected(false);
                b10000.setSelected(false);
                b30000.setSelected(false);
                break;
            case R.id.mr_3000:
                b500.setSelected(false);
                b1000.setSelected(false);
                b3000.setSelected(true);
                b5000.setSelected(false);
                b10000.setSelected(false);
                b30000.setSelected(false);
                break;
            case R.id.mr_5000:
                b500.setSelected(false);
                b1000.setSelected(false);
                b3000.setSelected(false);
                b5000.setSelected(true);
                b10000.setSelected(false);
                b30000.setSelected(false);
                break;
            case R.id.mr_10000:
                b500.setSelected(false);
                b1000.setSelected(false);
                b3000.setSelected(false);
                b5000.setSelected(false);
                b10000.setSelected(true);
                b30000.setSelected(false);
                break;
            case R.id.mr_30000:
                b500.setSelected(false);
                b1000.setSelected(false);
                b3000.setSelected(false);
                b5000.setSelected(false);
                b10000.setSelected(false);
                b30000.setSelected(true);
                break;
            default:
                break;
        }
    }
}