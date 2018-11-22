package com.example.administrator.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Goods> goodsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initData();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.Recycler_layout);

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//水平方向滚动，默认垂直
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager
                (2,StaggeredGridLayoutManager.VERTICAL);//两列从垂直布局

        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(goodsList,true,this);
        recyclerView.setAdapter(adapter);

    }

    private void initData(){
        for (int i=0;i<11;i++){
            Goods n1 = new Goods(R.drawable.ic_launcher_background,"ic","100");
            goodsList.add(n1);
        }

    }
}
