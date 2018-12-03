package com.example.administrator.day1.Utils.ScanQRCode;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.day1.R;
import com.google.zxing.WriterException;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;
import com.yzq.zxinglibrary.encode.CodeCreator;

public class ScanQRCodeActivity extends AppCompatActivity {
	TextView textView;
	EditText editText;
	ImageView imageView;
	Button button;
	private int REQUEST_CODE_SCAN = 111;//扫一扫界面指定值
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan_qrcode);

		textView = (TextView)findViewById(R.id.resut);
		editText = (EditText)findViewById(R.id.edit_edit);
		imageView = (ImageView)findViewById(R.id.logo_icon);

		button = (Button)findViewById(R.id.test);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//动态申请权限
				if (ContextCompat.checkSelfPermission(ScanQRCodeActivity.this,
						Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED &&
						ContextCompat.checkSelfPermission(ScanQRCodeActivity.this,
								Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED ){
					ActivityCompat.requestPermissions(ScanQRCodeActivity.this,
							new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE},1);
				}else {
					//跳转到扫一扫界面
					Intent intent = new Intent(ScanQRCodeActivity.this, CaptureActivity.class);
					startActivityForResult(intent, REQUEST_CODE_SCAN);
					CreateQRCode();
				}
			}
		});

	}

	/**
	 * 接收扫描结果
	 * */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// 扫描二维码/条码回传
		if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
			if (data != null) {
				String content = data.getStringExtra(Constant.CODED_CONTENT);
				//返回结果显示
				textView.setText("扫描结果为：" + content);
			}
		}
	}

	/**
	 * 生成二维码
	 * */
	public void CreateQRCode(){
		//获取EditText里的内容，进而生成二维码
		String contentEtString = editText.getText().toString().trim();

		if (TextUtils.isEmpty(contentEtString)) {
			Toast.makeText(this, "contentEtString不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		Bitmap bitmap = null;
		try {
			/*
			 * contentEtString：字符串内容
			 * w：图片的宽
			 * h：图片的高
			 * logo：不需要logo的话直接传null
			 * */
			Bitmap logo = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
			bitmap = CodeCreator.createQRCode(contentEtString, 400, 400, logo);
			//二维码显示
			imageView.setImageBitmap(bitmap);
		} catch (WriterException e) {
			e.printStackTrace();
		}
	}

	@Override//权限处理
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		switch (requestCode){
			case 1:
				if (grantResults.length > 0 && grantResults[0] ==PackageManager
						.PERMISSION_GRANTED){
					//跳转到扫一扫界面
					Intent intent = new Intent(ScanQRCodeActivity.this, CaptureActivity.class);
					startActivityForResult(intent, REQUEST_CODE_SCAN);
					CreateQRCode();
				}else {
					//没有授权处理
				}
				break;
		}
	}
}
