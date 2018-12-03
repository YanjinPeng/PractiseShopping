package com.example.administrator.day1.ShopFragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.administrator.day1.ShopFragment.FourFrag_view.AddressActivity;
import com.example.administrator.day1.ShopFragment.FourFrag_view.MallRevenueActivity;
import com.example.administrator.day1.ShopFragment.FourFrag_view.MyOrderActivity;
import com.example.administrator.day1.R;
import com.example.administrator.day1.ShopFragment.FourFrag_view.UpMarchantsActivity;

public class FourthShopActivity extends Fragment implements View.OnClickListener{



	RelativeLayout fr1,fr2,fr3,fr4,fr5;
	RelativeLayout sr1,sr2,sr3,sr4;
    Button dd1,dd2,up_m;
	int i_value;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mine_shop, container, false);

        fr1 = (RelativeLayout)view.findViewById(R.id.shop_mine_layout1);
        fr2 = (RelativeLayout)view.findViewById(R.id.shop_mine_layout2);
        fr3 = (RelativeLayout)view.findViewById(R.id.shop_mine_layout3);
        fr4 = (RelativeLayout)view.findViewById(R.id.shop_mine_layout4);
        fr5 = (RelativeLayout)view.findViewById(R.id.shop_mine_layout5);
        fr1.setOnClickListener(this);
        fr2.setOnClickListener(this);
        fr3.setOnClickListener(this);
        fr4.setOnClickListener(this);
        fr5.setOnClickListener(this);


		sr1 = (RelativeLayout)view.findViewById(R.id.shop_layout_1);
		sr2 = (RelativeLayout)view.findViewById(R.id.shop_layout_2);
		sr3 = (RelativeLayout)view.findViewById(R.id.shop_layout_3);
		sr4 = (RelativeLayout)view.findViewById(R.id.shop_layout_4);
		sr1.setOnClickListener(this);
		sr2.setOnClickListener(this);
		sr3.setOnClickListener(this);
		sr4.setOnClickListener(this);


        dd1 = (Button)view.findViewById(R.id.shop_mine_all_d);
		dd2 = (Button)view.findViewById(R.id.shop_mine_all_d1);
		dd1.setOnClickListener(this);
		dd2.setOnClickListener(this);
		up_m = (Button)view.findViewById(R.id.up_marchants);
		up_m.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
			case R.id.up_marchants:
				Intent intentup = new Intent(getActivity(), UpMarchantsActivity.class);
				startActivity(intentup);
				break;

			case R.id.shop_mine_all_d:
				Intent intent = new Intent(getActivity(), MyOrderActivity.class);
				SharedPreferences pref = getActivity().getSharedPreferences("data",0);
				SharedPreferences.Editor editor = pref.edit();
				editor.putString("textvalue","0");
				editor.commit();
				startActivity(intent);
				break;

			case R.id.shop_mine_all_d1:
				Intent intent1 = new Intent(getActivity(), MyOrderActivity.class);
				SharedPreferences pref0 = getActivity().getSharedPreferences("data",0);
				SharedPreferences.Editor editor0 = pref0.edit();
				editor0.putString("textvalue","0");
				editor0.commit();
				startActivity(intent1);
				break;

			case R.id.shop_layout_1:
				Intent intents1 = new Intent(getActivity(), MyOrderActivity.class);
				SharedPreferences pref1 = getActivity().getSharedPreferences("data",0);
				SharedPreferences.Editor editor1 = pref1.edit();
				editor1.putString("textvalue","1");
				editor1.commit();
				startActivity(intents1);
				break;

			case R.id.shop_layout_2:
				Intent intents2 = new Intent(getActivity(), MyOrderActivity.class);
				SharedPreferences pref2 = getActivity().getSharedPreferences("data",0);
				SharedPreferences.Editor editor2 = pref2.edit();
				editor2.putString("textvalue","2");
				editor2.commit();
				startActivity(intents2);
				break;
			case R.id.shop_layout_3:
				Intent intents3 = new Intent(getActivity(), MyOrderActivity.class);
				SharedPreferences pref3 = getActivity().getSharedPreferences("data",0);
				SharedPreferences.Editor editor3 = pref3.edit();
				editor3.putString("textvalue","3");
				editor3.commit();
				startActivity(intents3);
				break;
			case R.id.shop_layout_4:
				Intent intents4 = new Intent(getActivity(), MyOrderActivity.class);
				SharedPreferences pref4 = getActivity().getSharedPreferences("data",0);
				SharedPreferences.Editor editor4 = pref4.edit();
				editor4.putString("textvalue","4");
				editor4.commit();
				startActivity(intents4);
				break;

            case R.id.shop_mine_layout1:
				Intent intentsy = new Intent(getActivity(), MallRevenueActivity.class);
				startActivity(intentsy);
                break;
            case R.id.shop_mine_layout2:
				Intent intentdz = new Intent(getActivity(), AddressActivity.class);
				SharedPreferences prefdz = getActivity().getSharedPreferences("data",0);
				SharedPreferences.Editor editordz = prefdz.edit();
				editordz.putString("information","2");
				editordz.commit();
				startActivity(intentdz);
                break;
            case R.id.shop_mine_layout3:
				Intent intentmy = new Intent(getActivity(), MyOrderActivity.class);
				SharedPreferences prefmy = getActivity().getSharedPreferences("data",0);
				SharedPreferences.Editor editormy = prefmy.edit();
				editormy.putString("textvalue","0");
				editormy.commit();
				startActivity(intentmy);
                break;
            case R.id.shop_mine_layout4:
				Intent intentrz = new Intent(getActivity(), UpMarchantsActivity.class);
				startActivity(intentrz);
                break;
            case R.id.shop_mine_layout5:
                restartApplication();
                break;


        }
    }



	/*
    * 重启程序
    * */
    private void restartApplication() {
        Intent i = getActivity().getPackageManager()
                .getLaunchIntentForPackage(getActivity().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
     }
}


