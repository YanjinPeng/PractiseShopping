package com.example.administrator.day1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import static android.content.ContentValues.TAG;

public class ThreadShopActivity extends Fragment implements View.OnClickListener{

	// 存储勾选框状态的map集合
	public static Map<Integer, Boolean> map = new HashMap<>();

	// 存储选中商品的价格以及名称集合
	public static Map<Integer,String []> goods_map ;
	public static String [] gm_s ;
	/**存储选中商品的价格以及名称集合**/
	public static List<GoodsPrice> goodsList1 = new ArrayList<>();
	public static int price = 0;
	private int pr1;
	boolean a,b;

	private int check_num = 0;

    CheckBoxAdapter adapter;

	View view ;

	int all_price;
	boolean ischeck;

    Button delete,over;
    CheckBox all;
    TextView pricet;

    RelativeLayout heji;
   // CheckBoxAdapter myAdapter;
    private List<GoodsPrice> goodsList = new ArrayList<>();

    boolean isDeist,isOvist;
    private int checkNum; // 记录选中的条目数量
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	if (view != null){
        	ViewGroup parent = (ViewGroup)view.getParent();
        	if (parent != null){
        		parent.removeView(view);
			}
		}else {//解决重复加载问题
			view = inflater.inflate(R.layout.activity_shop_car, container, false);
			pricet = (TextView)view.findViewById(R.id.shopcar_price);
			delete = (Button)view.findViewById(R.id.shopcar_de);
			delete.setOnClickListener(this);
			over = (Button)view.findViewById(R.id.tijiao);
			over.setOnClickListener(this);

			heji = (RelativeLayout)view.findViewById(R.id.shopcar_heji);

			all = (CheckBox)view.findViewById(R.id.check_all);
			all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked) {//选中
						price = 0;
						for (int i=0;i<goodsList.size();i++){
							GoodsPrice goodsPrice1 = goodsList.get(i);
							//b = map.get(i);//当前CheckBox状态
								map.put(i,true);
								price = price + goodsPrice1.getPrice();
							//ischeckall = 0;
						}
						adapter.notifyDataSetChanged();
						pricet.setText(""+price);
					} else {
						//ischeckall = 1;
						for (int i=0;i<goodsList.size();i++){
							GoodsPrice goodsPrice1 = goodsList.get(i);
							map.put(i,false);
						}
						adapter.notifyDataSetChanged();
						price = 0;
						pricet.setText(""+price);
					}
				}
			});
			//推荐商品数据栏
			initReComData();
			price = 0;
			RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.shopping_car);
			LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());//默认垂直布局
			recyclerView.setLayoutManager(layoutManager);
			adapter = new CheckBoxAdapter(goodsList,getActivity());
			recyclerView.setAdapter(adapter);
		}
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shopcar_de:
                if (!isDeist){ //false或null时
                    delete.setText("完成");
                    over.setText("删除");
                    over.setSelected(true);
                    isDeist = true;
                    heji.setVisibility(View.INVISIBLE);
                    //**************************
                }else {
                    delete.setText("管理");
                    over.setText("提交订单");
                    over.setSelected(false);
                    isDeist = false;
					heji.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.tijiao:
                if (!isDeist){
					//提交订单处理
					Intent intent = new Intent(getActivity(),OrightOrderActivity.class);
					/***提交界面店家状态**/
					SharedPreferences prefdz = getActivity().getSharedPreferences("data",0);
					SharedPreferences.Editor editordz = prefdz.edit();
					editordz.putString("rightback","1");
					editordz.commit();
					int n =0;
					goods_map = new HashMap<>();
					//copy goods
					for (int i=0;i<goodsList.size();i++){
						boolean is = map.get(i);//当前CheckBox状态
						if (is == true){//选中状态(所需要删除的选项)
							gm_s= new String[2];
							GoodsPrice goods1 = goodsList.get(i);
							gm_s [0]= ""+goods1.getGoods();
							gm_s [1]= ""+goods1.getPrice();
							goods_map.put(n,gm_s);
							n++;
						}
					}
					/********************************/
					startActivity(intent);

                }else {
                	//删除商品
					for (int i=goodsList.size()-1;i>-1;i--){
						boolean is = map.get(i);//当前CheckBox状态
						if (is == true){//选中状态(所需要删除的选项)
							goodsList.remove(i);
							adapter.notifyItemRemoved(i);//**删除
							adapter.notifyItemRangeChanged(0,goodsList.size()-0);//动画效果
							//adapter.notifyDataSetChanged();
						}
					}
					//重置商品价钱
					price = 0;
					for (int i=0;i<goodsList.size();i++){
						GoodsPrice goodsPrice1 = goodsList.get(i);
						//b = map.get(i);//当前CheckBox状态
						map.put(i,false);
						price = 0;
					}
					pricet.setText(""+price);
                }
                break;
        }
    }
    private void initReComData(){
        for (int i=1;i<9;i++){
            GoodsPrice n1 = new GoodsPrice(R.drawable.ic_launcher_background,"Recomgoods-"+i,i*10);
            goodsList.add(n1);

        }
    }

    /**************************************
	 *
	 * 带有CheckBox的Recyclerview 适配器
	 *
	 * ************************************/
	public class CheckBoxAdapter extends RecyclerView.Adapter<CheckBoxAdapter.ViewHolder> {
		private List<GoodsPrice> mgoodsList;
		Context context;

		//存储数据的数组列表
		ArrayList<String> listData = new ArrayList<String>();


		public CheckBoxAdapter(List<GoodsPrice> goodsList,Context context) {
			mgoodsList = goodsList;
			this.context = context;
			initMap();
		}

		private void initMap() {
			for (int i = 0; i < mgoodsList.size(); i++) {
				map.put(i, false);
			}
		}

		public class ViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {
			public TextView textView3,textView4;
			public ImageView imageView1;
			public CheckBox cb;
			//View checkview;

			//初始化viewHolder，此处绑定后在onBindViewHolder中可以直接使用
			public ViewHolder(View itemView){
				super(itemView);

				textView3=(TextView)itemView.findViewById(R.id.shopcar_name);
				textView4=(TextView)itemView.findViewById(R.id.shopcar_price);
				imageView1 = (ImageView)itemView.findViewById(R.id.shopcar_image);
				cb = (CheckBox)itemView.findViewById(R.id.shopcar_check);

			}
		}
		@Override
		public CheckBoxAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View views= LayoutInflater.from(parent.getContext()).inflate(
					R.layout.shopcar_adapter,parent,false);
			final CheckBoxAdapter.ViewHolder holder = new CheckBoxAdapter.ViewHolder(views);

			return holder;
		}

		@Override
		public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
			//建立起ViewHolder中试图与数据的关联
			try {
				final GoodsPrice goods = mgoodsList.get(position);
				holder.imageView1.setImageResource(goods.getImageid());
				holder.textView3.setText(goods.getGoods());
				String s = Integer.toString(goods.getPrice());
				holder.textView4.setText(s);

				/**
				 * Recyclerview的各个子控件的点击事件
				 * */
				holder.imageView1.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//position 当前条目位置
						String a = map.get(position).toString();
						int i = position;
						//holder.textView4
						GoodsPrice goodsPrice = mgoodsList.get(position);
						int price = goodsPrice.getPrice();
						ToastUtils.showToast(context,a+i+goodsPrice.getPrice());
					}
				});

				holder.cb.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						a = map.get(position);//当前CheckBox状态

						if (a==false){
							map.put(position,true);
						}else {
							map.put(position,false);
						}
						boolean isc = map.get(position);
						GoodsPrice goodsPrice = mgoodsList.get(position);
						pr1 = goodsPrice.getPrice();//获取当前所选价钱
						//ToastUtils.showToast(context,map.toString());
						if (isc == true){
							price =price + pr1;
							pricet.setText(""+price);
							ToastUtils.showToast(getActivity(),""+price);
						}else {
							price = price - pr1;
							pricet.setText(""+price);
							ToastUtils.showToast(getActivity(),""+price);
						}
					}
				});

				if (map.get(position) == null) {
					map.put(position, false);
				}
				holder.cb.setChecked(map.get(position));
			}catch (Exception e){
				e.printStackTrace();
			}
		}

		//设置显示内容数量(setAdapter的时候调用)
		@Override
		public int getItemCount() {
			return mgoodsList.size();//有多少显示多少
			//return 8;
		}
	}
	//其他activity获取总价数据
	public int getPriceData() {
		return price;
	}

	public List<GoodsPrice> getListData() {
		return goodsList1;
	}

	public Map<Integer,String []> getAllData(){
		return goods_map;
	}

}
