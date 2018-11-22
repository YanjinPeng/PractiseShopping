package com.example.administrator.day1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_jif_acitivity extends NoTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balance_recode);

        Button back = (Button)findViewById(R.id.ba_record_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_jif_acitivity.this, FragmentActivity.class);
                // intent.putExtra("id", 0);
                startActivity(intent);
            }
        });
    }
}