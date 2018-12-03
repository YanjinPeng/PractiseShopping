package com.example.administrator.day1.ShopFragment.shopPage_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.example.administrator.day1.RecyclerviewAdapter.Goods;
import com.example.administrator.day1.StyleActivity.NoTitleActivity;
import com.example.administrator.day1.R;
import com.example.administrator.day1.RecyclerviewAdapter.RecyclerAdapter;
import com.example.administrator.day1.ShopFragment.ShopFragmentActivity;

import java.util.ArrayList;
import java.util.List;

public class AllNewSActivity extends NoTitleActivity {

    private List<Goods> goodsList = new ArrayList<>();

    Button back ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_new_s);

        back = (Button)findViewById(R.id.new_all_title_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllNewSActivity.this,ShopFragmentActivity.class);
                startActivity(intent);
            }
        });
        //最新商品数据栏
        initNewData();
        RecyclerView recyclerView1 = (RecyclerView)findViewById(R.id.shop_new_all);
        StaggeredGridLayoutManager layoutManager1 = new StaggeredGridLayoutManager
                (2,StaggeredGridLayoutManager.VERTICAL);//两列从垂直布局
        recyclerView1.setLayoutManager(layoutManager1);
        RecyclerAdapter adapter1 = new RecyclerAdapter(goodsList,true,this);
        recyclerView1.setAdapter(adapter1);
    }

    private void initNewData(){
        for (int i=0;i<12;i++){
            Goods n1 = new Goods(R.drawable.ic_launcher_background,"recy","200");
            goodsList.add(n1);
        }
    }
}
