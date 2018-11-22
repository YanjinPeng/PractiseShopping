package com.example.administrator.day1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FristFragment extends Fragment implements View.OnClickListener{

    Button btn_zr,btn_zc,btn_mr,btn_mc,btn_mo,btn_sc,btn_fx,btn_ys,btn_yx,btn_df,btn_td,btn_more;
    Button btn_yue,btn_jif;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_homepage, container, false);

        btn_yue = (Button)view.findViewById(R.id.myzc);
        btn_yue.setOnClickListener(this);
        btn_jif = (Button)view.findViewById(R.id.myjifen);
        btn_jif.setOnClickListener(this);

        btn_zr = (Button)view.findViewById(R.id.button_zr);
        btn_zr.setOnClickListener(this);
        btn_zc = (Button)view.findViewById(R.id.button_zc);
        btn_zc.setOnClickListener(this);
        btn_mr = (Button)view.findViewById(R.id.button_mr);
        btn_mr.setOnClickListener(this);
        btn_mc = (Button)view.findViewById(R.id.button_mc);
        btn_mc.setOnClickListener(this);
        btn_mo = (Button)view.findViewById(R.id.button_sz);
        btn_mo.setOnClickListener(this);
        btn_sc = (Button)view.findViewById(R.id.button_sc);
        btn_sc.setOnClickListener(this);
        btn_fx = (Button)view.findViewById(R.id.button_fx);
        btn_fx.setOnClickListener(this);
        btn_ys = (Button)view.findViewById(R.id.button_ys);
        btn_ys.setOnClickListener(this);
        btn_yx = (Button)view.findViewById(R.id.button_yx);
        btn_yx.setOnClickListener(this);
        btn_df = (Button)view.findViewById(R.id.button_df);
        btn_df.setOnClickListener(this);
        btn_td = (Button)view.findViewById(R.id.button_td);
        btn_td.setOnClickListener(this);
        btn_more = (Button)view.findViewById(R.id.button_gd);
        btn_more.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myzc:
                Intent intentzc = new Intent(getActivity(), Home_yue_activity.class);
                startActivity(intentzc);
                break;
            case R.id.myjifen:
                Intent intentjf = new Intent(getActivity(), Home_jif_acitivity.class);
                startActivity(intentjf);
                break;

            case R.id.button_zr:
                Intent intent0 = new Intent(getActivity(), Home_zr_activity.class);
                startActivity(intent0);
                break;
            case R.id.button_zc:
                Intent intent1 = new Intent(getActivity(), Home_zc_activity.class);
                startActivity(intent1);
                break;
            case R.id.button_mr:
                Intent intent2 = new Intent(getActivity(), Home_mr_activity.class);
                startActivity(intent2);
                break;
            case R.id.button_mc:
                Intent intent3 = new Intent(getActivity(), Home_mc_activity.class);
                startActivity(intent3);
                break;
            case R.id.button_sz:
                Intent intent4 = new Intent(getActivity(), FragmentActivity.class);
                intent4.putExtra("prop", 1);
                startActivity(intent4);
                break;
            case R.id.button_sc:
                Intent intent5 = new Intent(getActivity(), ShopFragmentActivity.class);
                //intent5.putExtra("shop", 2);
                startActivity(intent5);
                break;
            case R.id.button_fx:
                Intent intent6 = new Intent(getActivity(), QRcode_share.class);
                startActivity(intent6);
                break;
            case R.id.button_ys:
                ToastUtils.showToast(getActivity(),"该功能暂未开放");
                break;
            case R.id.button_yx:
                ToastUtils.showToast(getActivity(),"该功能暂未开放");
                break;
            case R.id.button_df:
                Intent intent9 = new Intent(getActivity(), Home_df_activity.class);
                startActivity(intent9);
                break;
            case R.id.button_td:
                ToastUtils.showToast(getActivity(),"该功能暂未开放");
                break;
            case R.id.button_gd:
                ToastUtils.showToast(getActivity(),"该功能暂未开放");
                break;
            default:
                break;
        }
    }
}
