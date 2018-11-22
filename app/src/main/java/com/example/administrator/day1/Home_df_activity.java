package com.example.administrator.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_df_activity extends NoTitleActivity {
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_df_activity);

        back = (Button)findViewById(R.id.df_title_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_df_activity.this, FragmentActivity.class);
                // intent.putExtra("id", 0);
                startActivity(intent);
            }
        });
    }
}
