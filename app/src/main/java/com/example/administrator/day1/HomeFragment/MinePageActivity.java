package com.example.administrator.day1.HomeFragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.day1.ShopFragment.FourFrag_view.AddressActivity;
import com.example.administrator.day1.HomeFragment.MinePage_view.BankCardActivity;
import com.example.administrator.day1.ShopFragment.FourFrag_view.MyOrderActivity;
import com.example.administrator.day1.HomeFragment.FirstFrag_view.QRcode_share;
import com.example.administrator.day1.R;
import com.example.administrator.day1.HomeFragment.MinePage_view.ReviseLogpassActivity;
import com.example.administrator.day1.HomeFragment.MinePage_view.ReviseNameActivity;
import com.example.administrator.day1.HomeFragment.MinePage_view.RevisePaypassActivity;
import com.example.administrator.day1.ShopFragment.ShopFragmentActivity;
import com.example.administrator.day1.HomeFragment.MinePage_view.TelNumberActivity;
import com.example.administrator.day1.HomeFragment.MinePage_view.UserSuggestActivity;

public class MinePageActivity extends Fragment implements View.OnClickListener{

    Button exit,mine1,mine2,mine3,mine4,mine5,mine6,mine7,mine8,mine9,mine10,mine11,mine12,mine13;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.minepage, container, false);

        exit = (Button)view.findViewById(R.id.button_exit);
		exit.setOnClickListener(this);

        mine1 = (Button)view.findViewById(R.id.button_nc);
        mine2 = (Button)view.findViewById(R.id.button_sj);
        mine3 = (Button)view.findViewById(R.id.button_yh);
        mine4 = (Button)view.findViewById(R.id.button_dp);
        mine5 = (Button)view.findViewById(R.id.button_dd);
        mine6 = (Button)view.findViewById(R.id.button_dz);
        mine7 = (Button)view.findViewById(R.id.button_fxi);
        mine8 = (Button)view.findViewById(R.id.button_gg);
        mine9 = (Button)view.findViewById(R.id.button_gy);
        mine10 = (Button)view.findViewById(R.id.button_xg);
        mine11 = (Button)view.findViewById(R.id.button_xgzf);
        mine12 = (Button)view.findViewById(R.id.button_jy);
        mine13 = (Button)view.findViewById(R.id.button_bb);
        mine1.setOnClickListener(this);
        mine2.setOnClickListener(this);
        mine3.setOnClickListener(this);
        mine4.setOnClickListener(this);
        mine5.setOnClickListener(this);
        mine6.setOnClickListener(this);
        mine7.setOnClickListener(this);
        mine8.setOnClickListener(this);
        mine9.setOnClickListener(this);
        mine10.setOnClickListener(this);
        mine11.setOnClickListener(this);
        mine12.setOnClickListener(this);
        mine13.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_nc:
                Intent intentnc = new Intent(getActivity(), ReviseNameActivity.class);
                startActivity(intentnc);
                break;
            case R.id.button_sj:
                Intent intentsj = new Intent(getActivity(), TelNumberActivity.class);
                startActivity(intentsj);
                break;
            case R.id.button_yh:
                Intent intentyh = new Intent(getActivity(), BankCardActivity.class);
                startActivity(intentyh);
                break;
            case R.id.button_dp:
                Intent intentdp = new Intent(getActivity(), ShopFragmentActivity.class);
                startActivity(intentdp);
                break;
            case R.id.button_dd:
                Intent intentdd = new Intent(getActivity(), MyOrderActivity.class);
                startActivity(intentdd);
                break;
            case R.id.button_dz:
                Intent intentdz = new Intent(getActivity(), AddressActivity.class);
                SharedPreferences prefdz = getActivity().getSharedPreferences("data",0);
                SharedPreferences.Editor editordz = prefdz.edit();
                editordz.putString("information","1");
                editordz.commit();
                startActivity(intentdz);
                break;
            case R.id.button_fxi:
                Intent intentfx = new Intent(getActivity(), QRcode_share.class);
                startActivity(intentfx);
                break;
            case R.id.button_gg:

                break;
            case R.id.button_gy:

                break;
            case R.id.button_xg:
				Intent intentxg = new Intent(getActivity(), ReviseLogpassActivity.class);
				startActivity(intentxg);
                break;
            case R.id.button_xgzf:
                Intent intentxgzf = new Intent(getActivity(), RevisePaypassActivity.class);
                startActivity(intentxgzf);
                break;
            case R.id.button_jy:
                Intent intentxgjy = new Intent(getActivity(), UserSuggestActivity.class);
                startActivity(intentxgjy);
                break;
            case R.id.button_bb:

                break;

            case R.id.button_exit:
                restartApplication();
                break;
        }
    }
	private void restartApplication() {
		Intent i = getActivity().getPackageManager()
				.getLaunchIntentForPackage(getActivity().getPackageName());
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
}
