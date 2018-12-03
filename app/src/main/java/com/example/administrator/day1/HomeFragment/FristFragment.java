package com.example.administrator.day1.HomeFragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.day1.HomeFragment.FirstFrag_view.Home_df_activity;
import com.example.administrator.day1.HomeFragment.FirstFrag_view.Home_jif_acitivity;
import com.example.administrator.day1.HomeFragment.FirstFrag_view.Home_mc_activity;
import com.example.administrator.day1.HomeFragment.FirstFrag_view.Home_mr_activity;
import com.example.administrator.day1.HomeFragment.FirstFrag_view.Home_yue_activity;
import com.example.administrator.day1.HomeFragment.FirstFrag_view.Home_zc_activity;
import com.example.administrator.day1.HomeFragment.FirstFrag_view.Home_zr_activity;
import com.example.administrator.day1.HomeFragment.FirstFrag_view.QRcode_share;
import com.example.administrator.day1.R;
import com.example.administrator.day1.ShopFragment.ShopFragmentActivity;
import com.example.administrator.day1.Utils.ScanQRCode.ScanQRCodeActivity;
import com.example.administrator.day1.Utils.ToastUtils;
import com.google.zxing.WriterException;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;
import com.yzq.zxinglibrary.encode.CodeCreator;

import static android.app.Activity.RESULT_OK;

public class FristFragment extends Fragment implements View.OnClickListener{

    Button btn_zr,btn_zc,btn_mr,btn_mc,btn_mo,btn_sc,btn_fx,btn_ys,btn_yx,btn_df,btn_td,btn_more;
    Button btn_yue,btn_jif;
    Button btn_scan;
    private int REQUEST_CODE_SCAN = 111;//扫一扫界面指定值
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_homepage, container, false);

        btn_scan = (Button)view.findViewById(R.id.saoma);
        btn_scan.setOnClickListener(this);

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
            case R.id.saoma:
                //
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED &&
                        ContextCompat.checkSelfPermission(getActivity(),
                                Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED ){
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE},1);
                }else {
                    //跳转到扫一扫界面
                    Intent intent = new Intent(getActivity(), CaptureActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_SCAN);
                    //CreateQRCode();
                }
                //Intent intent11 = new Intent(getActivity(), ScanQRCodeActivity.class);
                //startActivity(intent11);
                break;
            default:
                break;
        }
    }
    /**
     * 接收扫描结果
     * */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
                //返回结果显示
               // textView.setText("扫描结果为：" + content);
            }
        }
    }

    /**
     * 生成二维码
     * */
    public void CreateQRCode(){
        //获取EditText里的内容
        /*String contentEtString = editText.getText().toString().trim();

        if (TextUtils.isEmpty(contentEtString)) {
            Toast.makeText(getActivity(), "contentEtString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Bitmap bitmap = null;
        try {*/
            /*
             * contentEtString：字符串内容
             * w：图片的宽
             * h：图片的高
             * logo：不需要logo的话直接传null
             * */
           /* Bitmap logo = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            bitmap = CodeCreator.createQRCode(contentEtString, 400, 400, logo);
            //imageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }*/
    }

    @Override//权限处理
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] ==PackageManager
                        .PERMISSION_GRANTED){
                    //跳转到扫一扫界面
                    Intent intent = new Intent(getActivity(), CaptureActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_SCAN);
                    CreateQRCode();
                }else {
                    //没有授权处理
                }
                break;
        }
    }
}
