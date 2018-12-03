package com.example.administrator.day1.RecyclerviewAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.day1.GoodsDetails.DetailsActivity;
import com.example.administrator.day1.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Goods> mgoodsList;
    private boolean showq;
    Context context;
    String dela;
    String nameB,priceB;

    /*****************/
	IItem iItem;//创建接口对象
	//此方法就是连接接口与activity的桥梁
	public void setiItem(IItem iItem) {//创建含有接口引用的方法
		this.iItem = iItem;
	}
	/*****************/

    public RecyclerAdapter(List<Goods> goodsList,boolean show,Context context) {
        mgoodsList = goodsList;
        showq = show;
        this.context = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {
        public TextView textView1,textView2,textView3,textView4;
        public ImageView imageView,imageView1;
        public LinearLayout chooseO;

        //初始化viewHolder，此处绑定后在onBindViewHolder中可以直接使用
        public ViewHolder(View itemView){
            super(itemView);
            textView1=(TextView)itemView.findViewById(R.id.Recycler_text);
            textView2=(TextView)itemView.findViewById(R.id.Recycler_text2);
            imageView = (ImageView)itemView.findViewById(R.id.Recycler_icon);
            chooseO = (LinearLayout)itemView.findViewById(R.id.all_layout_linear);

        }

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View views= LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_style,parent,false);
        ViewHolder holder = new ViewHolder(views);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //建立起ViewHolder中试图与数据的关联
        final Goods goods = mgoodsList.get(position);
        holder.imageView.setImageResource(goods.getImageid());
        holder.textView1.setText(goods.getGoods());
        holder.textView2.setText(goods.getPrice());


        holder.chooseO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);
                Goods goodsPrice = mgoodsList.get(position);

                nameB = goodsPrice.getGoods();
                priceB = goodsPrice.getPrice();
				//ToastUtils.showToast(context,""+priceB+goodsPrice);

				/**
				 *
				 * //创建一个接口对象
				 *  IItem iItem;
				 * 	//此方法就是连接接口与activity的桥梁
				 * 	//自定义方法参数为接口对象的引用
				 * 	public void setiItem(IItem iItem) {
				 * 		this.iItem = iItem;
				 *  }
				 *  //合适的地方执行
				 *  iItem.setOnItem(position);
				 * */
				iItem.setOnItem(position,nameB,priceB);

                context.startActivity(intent);
            }
        });
    }

    //activity
    public String getData(){
        return dela;
    }

    //设置显示内容数量(setAdapter的时候调用)
    @Override
    public int getItemCount() {
        if (showq == true){
            return mgoodsList.size();//有多少显示多少
        }else {
            return 6;
        }
    }

}
