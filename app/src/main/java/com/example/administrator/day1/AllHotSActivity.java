package com.example.administrator.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class AllHotSActivity extends NoTitleActivity {

    private List<Goods> goodsList = new ArrayList<>();

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_hot_s);

        back = (Button)findViewById(R.id.hot_all_title_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllHotSActivity.this,ShopFragmentActivity.class);
                startActivity(intent);
            }
        });

        //热门商品数据栏
        initHotData();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.shop_hot_all);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager
                (2,StaggeredGridLayoutManager.VERTICAL);//两列从垂直布局
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(goodsList,true,this);//show为true时显示所有数据，false只显示6条数据
        recyclerView.setAdapter(adapter);
    }

    private void initHotData(){
        for (int i=0;i<12;i++){
            Goods n1 = new Goods(R.drawable.ic_launcher_background,"ic","100");
            goodsList.add(n1);
        }
    }
}
