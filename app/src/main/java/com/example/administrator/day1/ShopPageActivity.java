package com.example.administrator.day1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShopPageActivity extends Fragment implements View.OnClickListener{

    private List<Goods> goodsList = new ArrayList<>();
    private List<Goods> goodsList1 = new ArrayList<>();
    private List<Goods> goodsList2 = new ArrayList<>();

    public static String goodsname,goodsprice;
    View view;

    EditText serach_edit;

    Button hotsp,newsp;
    Button shop_back;
    RelativeLayout rela_1,rela_2,rela_3,rela_4,rela_5,rela_6,rela_7,rela_8;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //解决重复加载问题
        if (view != null){
            ViewGroup parent = (ViewGroup)view.getParent();
            if (parent != null){
                parent.removeView(view);
            }
        }else {
            view = inflater.inflate(R.layout.shoppingpage, container, false);
            hotsp = (Button)view.findViewById(R.id.shop_btn_rsp);
            newsp = (Button)view.findViewById(R.id.shop_btn_xsp);
            hotsp.setOnClickListener(this);
            newsp.setOnClickListener(this);

            shop_back = (Button)view.findViewById(R.id.shopping_back);
            shop_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),FragmentActivity.class);
                    startActivity(intent);
                }
            });

            rela_1 = (RelativeLayout)view.findViewById(R.id.layout_shop_1);
            rela_2 = (RelativeLayout)view.findViewById(R.id.layout_shop_2);
            rela_3 = (RelativeLayout)view.findViewById(R.id.layout_shop_3);
            rela_4 = (RelativeLayout)view.findViewById(R.id.layout_shop_4);
            rela_5 = (RelativeLayout)view.findViewById(R.id.layout_shop_5);
            rela_6 = (RelativeLayout)view.findViewById(R.id.layout_shop_6);
            rela_7 = (RelativeLayout)view.findViewById(R.id.layout_shop_7);
            rela_8 = (RelativeLayout)view.findViewById(R.id.layout_shop_8);
            rela_1.setOnClickListener(this);
            rela_2.setOnClickListener(this);
            rela_3.setOnClickListener(this);
            rela_4.setOnClickListener(this);
            rela_5.setOnClickListener(this);
            rela_6.setOnClickListener(this);
            rela_7.setOnClickListener(this);
            rela_8.setOnClickListener(this);

            //热门商品数据栏
            initHotData();
            RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.Recycler_remen);
            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager
                    (2,StaggeredGridLayoutManager.VERTICAL);//两列从垂直布局
            recyclerView.setLayoutManager(layoutManager);
            RecyclerAdapter adapter = new RecyclerAdapter(goodsList,false,getActivity());
            recyclerView.setAdapter(adapter);
            //调用adapter中的方法,将position,name传过来
            adapter.setiItem(new IItem() {
                @Override
                public void setOnItem(int position,String name,String price) {//
                    Toast.makeText(getActivity(), ""+ position+","+name+","+price, Toast.LENGTH_SHORT).show();
                	goodsname = name;
                	goodsprice = price;
                }
            });


            //最新商品数据栏
            initNewData();
            RecyclerView recyclerView1 = (RecyclerView)view.findViewById(R.id.Recycler_zuixin);
            StaggeredGridLayoutManager layoutManager1 = new StaggeredGridLayoutManager
                    (2,StaggeredGridLayoutManager.VERTICAL);//两列从垂直布局
            recyclerView1.setLayoutManager(layoutManager1);
            RecyclerAdapter adapter1 = new RecyclerAdapter(goodsList1,false,getActivity());
            recyclerView1.setAdapter(adapter1);
            //调用adapter中的方法,将position,name传过来
            adapter1.setiItem(new IItem() {
                @Override
                public void setOnItem(int position,String name,String price) {//
                    Toast.makeText(getActivity(), ""+ position+","+name+","+price, Toast.LENGTH_SHORT).show();
                    goodsname = name;
                    goodsprice = price;
                }
            });


            //推荐商品数据栏
            initReComData();
            RecyclerView recyclerView2 = (RecyclerView)view.findViewById(R.id.Recycler_tuijian);
            LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());//默认垂直布局
            recyclerView2.setLayoutManager(layoutManager2);
            ListViewAdapter adapter2 = new ListViewAdapter(goodsList2,getActivity());
            recyclerView2.setAdapter(adapter2);

            //调用adapter中的方法,将position,name传过来
            adapter2.setiItemL(new IItem() {
                @Override
                public void setOnItem(int position,String name,String price) {//
                    Toast.makeText(getActivity(), ""+ position+","+name+","+price, Toast.LENGTH_SHORT).show();
                    goodsname = name;
                    goodsprice = price;
                }
             });
        }


        return view;
    }

    /*
    * 初始化数据
    * */
    private void initHotData(){
        for (int i=0;i<8;i++){
            Goods n1 = new Goods(R.drawable.ic_launcher_background,"ic-"+i,"10"+i);
            goodsList.add(n1);
        }
    }
    private void initNewData(){
        for (int i=0;i<8;i++){
            Goods n1 = new Goods(R.drawable.ic_launcher_background,"recy-"+i,"20"+i);
            goodsList1.add(n1);
        }
    }
    private void initReComData(){
        for (int i=0;i<4;i++){
            Goods n1 = new Goods(R.drawable.ic_launcher_background,"Recomgoods-"+i,"300"+i);
            goodsList2.add(n1);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_shop_1:
                Intent intent_1 = new Intent(getActivity(),ShopFragmentActivity.class);
                intent_1.putExtra("classify", 1);
                startActivity(intent_1);
                break;
            case R.id.layout_shop_2:
                Intent intent_2 = new Intent(getActivity(),AllHotSActivity.class);
                startActivity(intent_2);
                break;
            case R.id.layout_shop_3:
                Intent intent_3 = new Intent(getActivity(),AllNewSActivity.class);
                startActivity(intent_3);
                break;
            case R.id.layout_shop_4:
                Intent intent_4 = new Intent(getActivity(),AllHotSActivity.class);
                startActivity(intent_4);
                break;
            case R.id.layout_shop_5:
                Intent intent_5 = new Intent(getActivity(),AllHotSActivity.class);
                startActivity(intent_5);
                break;
            case R.id.layout_shop_6:
                Intent intent_6 = new Intent(getActivity(),ShopFragmentActivity.class);
                intent_6.putExtra("shopmine", 3);
                startActivity(intent_6);
                break;
            case R.id.layout_shop_7:
                ToastUtils.showToast(getActivity(),"暂无福利");
                break;
            case R.id.layout_shop_8:
                ToastUtils.showToast(getActivity(),"该功能暂未开放");
                break;
            case R.id.shop_btn_rsp://热门商品更多
                Intent intent_h = new Intent(getActivity(),AllHotSActivity.class);
                startActivity(intent_h);
                break;
            case R.id.shop_btn_xsp:
                Intent intent_x = new Intent(getActivity(),AllNewSActivity.class);
                startActivity(intent_x);
                break;
        }
    }
	public String getGoodsName(){
		return goodsname;
	}
	public String getGoodsPrice(){
		return goodsprice;
	}
}
