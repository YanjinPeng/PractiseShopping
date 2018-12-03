package com.example.administrator.day1.HomeFragment;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.day1.HomeFragment.FirstFrag_view.Home_zc_activity;
import com.example.administrator.day1.R;
import com.example.administrator.day1.Utils.ToastUtils;

public class SecondFragment extends Fragment implements View.OnClickListener{

    Button ent_pay_ol,ent_pay,bt_copy;
    RelativeLayout pro1,pro2,pro3,pro4;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.propertypage, container, false);

        ent_pay = (Button)view.findViewById(R.id.xianj_jiaoyi);
        ent_pay_ol = (Button)view.findViewById(R.id.yue_jiaoyi);
        ent_pay.setOnClickListener(this);
        ent_pay_ol.setOnClickListener(this);
        // bt_pay = (Button)findViewById(R.id.xianj_jiaoyi1);
        // bt_pay_ol = (Button)findViewById(R.id.yue_jiaoyi1);

        pro1 = (RelativeLayout)view.findViewById(R.id.layout_pro_1);
        pro2 = (RelativeLayout)view.findViewById(R.id.layout_pro_2);
        pro3 = (RelativeLayout)view.findViewById(R.id.layout_pro_3);
        pro4 = (RelativeLayout)view.findViewById(R.id.layout_pro_4);
        pro1.setOnClickListener(this);
        pro2.setOnClickListener(this);
        pro3.setOnClickListener(this);
        pro4.setOnClickListener(this);

        bt_copy = (Button)view.findViewById(R.id.button_copy);
        bt_copy.setOnClickListener(this);
        textView = (TextView)view.findViewById(R.id.user_num);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_copy:
                ClipboardManager cmb = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                cmb.setText(textView.getText().toString().trim()); //将内容放入粘贴管理器,在别的地方长按选择"粘贴"即可

				ToastUtils.showToast(getActivity(),"复制成功");
                break;

            case R.id.layout_pro_1:
                Intent intent1 = new Intent(getActivity(), Home_zc_activity.class);
                startActivity(intent1);
                break;

            case R.id.layout_pro_2:
                ToastUtils.showToast(getActivity(),"该功能暂未开放");
                break;

            case R.id.layout_pro_3:
                ToastUtils.showToast(getActivity(),"该功能暂未开放");
                break;

            case R.id.layout_pro_4:
                ToastUtils.showToast(getActivity(),"该功能暂未开放");
                break;

            case R.id.xianj_jiaoyi:
                ToastUtils.showToast(getActivity(),"暂不能现金交易");
                break;

            case R.id.yue_jiaoyi:
                ToastUtils.showToast(getActivity(),"该功能暂未开放");
                break;
        }
    }
}
