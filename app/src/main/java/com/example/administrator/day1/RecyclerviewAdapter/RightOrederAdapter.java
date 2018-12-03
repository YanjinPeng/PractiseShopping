package com.example.administrator.day1.RecyclerviewAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.day1.R;

import java.util.List;

public class RightOrederAdapter extends RecyclerView.Adapter<RightOrederAdapter.ViewHolder> {
	private List<Goods> mgoodsList;
	private Context context;
	String lname,lprice;
	/********************************/
	IItem iItem;
	/***此方法就是连接接口与activity的桥梁***/
	public void setiItemL(IItem iItem) {
		this.iItem = iItem;
	}
	/********************************/
	public RightOrederAdapter(List<Goods> goodsList,Context context) {
		mgoodsList = goodsList;
		this.context =context;
	}


	public class ViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {
		public TextView textView3,textView4;
		public ImageView imageView1;
		LinearLayout l1;


		//初始化viewHolder，此处绑定后在onBindViewHolder中可以直接使用
		public ViewHolder(View itemView){
			super(itemView);
			textView3=(TextView)itemView.findViewById(R.id.recom_name);
			textView4=(TextView)itemView.findViewById(R.id.recom_price);
			imageView1 = (ImageView)itemView.findViewById(R.id.recom_image);
			l1 =(LinearLayout)itemView.findViewById(R.id.goods_layout);
		}
	}
	@Override
	public RightOrederAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View views= LayoutInflater.from(parent.getContext()).inflate(
				R.layout.activity_listview_layout,parent,false);
		RightOrederAdapter.ViewHolder holder = new RightOrederAdapter.ViewHolder(views);
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
		//建立起ViewHolder中试图与数据的关联
		Goods goods = mgoodsList.get(position);
		viewHolder.imageView1.setImageResource(goods.getImageid());
		viewHolder.textView3.setText(goods.getGoods());
		viewHolder.textView4.setText(goods.getPrice());
		viewHolder.l1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			}
		});
	}


	//设置显示内容数量(setAdapter的时候调用)
	@Override
	public int getItemCount() {
		return mgoodsList.size();//有多少显示多少
		// return 5;
	}
}
