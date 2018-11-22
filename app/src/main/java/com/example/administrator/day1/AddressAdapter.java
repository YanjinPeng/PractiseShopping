package com.example.administrator.day1;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

	private List<Address> maddressList;

	public AddressAdapter(List<Address> addressList){
		maddressList = addressList;
	}

	public class ViewHolder extends RecyclerView.ViewHolder{
		TextView address,name,tel;

		//初始化viewHolder，此处绑定后在onBindViewHolder中可以直接使用
		public ViewHolder(View itemView) {
			super(itemView);
			address = (TextView)itemView.findViewById(R.id.address_text);
			name = (TextView)itemView.findViewById(R.id.address_name);
			tel = (TextView)itemView.findViewById(R.id.address_tel);
		}
	}


	@Override //设置recyclerview item样式
	public AddressAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View views= LayoutInflater.from(viewGroup.getContext()).inflate(
				R.layout.address_adapter,viewGroup,false);
		AddressAdapter.ViewHolder holder = new AddressAdapter.ViewHolder(views);
		return holder;
	}

	@Override
	public void onBindViewHolder(AddressAdapter.ViewHolder viewHolder, int i) {
		//建立起ViewHolder中试图与数据的关联
		Address address = maddressList.get(i);
		viewHolder.name.setText(address.getName());
		viewHolder.tel.setText(address.getTel());
		viewHolder.address.setText(address.getAddress());
	}

	//设置显示内容数量(setAdapter的时候调用)
	@Override
	public int getItemCount() {
		return maddressList.size();
	}
}
