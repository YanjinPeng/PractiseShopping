package com.example.administrator.day1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 登录界面
 * 主要：button响应改变string内容
 * */

public class LoginActivity extends NoTitleActivity implements View.OnClickListener{

    public static final SpannableString eng1 = new SpannableString("Molie/UID");
    public static final SpannableString eng2 = new SpannableString("Login password");
    public static final SpannableString eng3 = new SpannableString("Login");
    public static final SpannableString eng4 = new SpannableString("No account");
    public static final SpannableString eng5 = new SpannableString("Forget password");
    public static final SpannableString cn1 = new SpannableString("请输入用户名");
    public static final SpannableString cn2 = new SpannableString("输入登录密码");
    public static final SpannableString cn3 = new SpannableString("登录");
    public static final SpannableString cn4 = new SpannableString("没有账户?");
    public static final SpannableString cn5 = new SpannableString("忘记密码");
    public static final int UpText_chinese = 1;
    public static final int UpText_english = 2;

    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            switch (message.what){
                case UpText_chinese:
                    e1.setHint(cn1);
                    e2.setHint(cn2);
                    bt_login.setText(cn3);
                    bt_register.setText(cn4);
                    bt_forget.setText(cn5);
                    GradientDrawable myGrad1 = (GradientDrawable)bt_chinese.getBackground();
                    myGrad1.setColor(Color.parseColor("#5069ff"));//设置shape文件的背景颜色
                    GradientDrawable myGrad2 = (GradientDrawable)bt_english.getBackground();
                    myGrad2.setColor(Color.parseColor("#00000000"));//设置shape文件的背景颜色
                    break;
                case UpText_english:
                    e1.setHint(eng1);
                    e2.setHint(eng2);
                    bt_login.setText(eng3);
                    bt_register.setText(eng4);
                    bt_forget.setText(eng5);
                    GradientDrawable myGrad11 = (GradientDrawable)bt_chinese.getBackground();
                    myGrad11.setColor(Color.parseColor("#00000000"));//设置shape文件的背景颜色
                    GradientDrawable myGrad22 = (GradientDrawable)bt_english.getBackground();
                    myGrad22.setColor(Color.parseColor("#5069ff"));//设置shape文件的背景颜色
                    break;
                default:
                    break;
            }
        }
    };

    SQLiteManager db;
    Button bt_login,bt_chinese,bt_english,bt_forget,bt_register;
    EditText e1,e2;
    int i=1,flog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1=(EditText)findViewById(R.id.edit_name);///*****Molie/UID
        e2=(EditText)findViewById(R.id.edit_password);//*******Login password
        e2.setTransformationMethod(PasswordTransformationMethod.getInstance());

        bt_chinese = (Button)findViewById(R.id.chinese);
        bt_chinese.setOnClickListener(this);
        bt_english = (Button)findViewById(R.id.english);
        bt_english.setOnClickListener(this);

        bt_login = (Button)findViewById(R.id.login_button);//******Login
        bt_login.setOnClickListener(this);
        bt_register = (Button)findViewById(R.id.login_registe);//*****No account
        bt_register.setOnClickListener(this);
        bt_forget = (Button)findViewById(R.id.login_forget);//*****Forget password
        bt_forget.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button:
               /* db=new SQLiteManager(LoginActivity.this);
                String name = e1.getText().toString();
                String password = e2.getText().toString();
                String sql2 = "SELECT * FROM  user";
                Cursor result=db.getResult(sql2);
                result.moveToFirst();
                while (!result.isAfterLast()) {    //cursor.moveToNext()
                    String a=result.getString(1);
                    String b=result.getString(2);
                    if(a.equals(name)&&b.equals(password))
                    {
                        if((!a.equals(null))&&(!b.equals(null))) {
                            flog=1;
                        }
                    }
                    result.moveToNext();
                }
                result.close();
                db.closeDB();
                if(flog==1){*/
                    Intent intent=new Intent(LoginActivity.this,FragmentActivity.class);
                    startActivity(intent);
                /*}
                else {
                    Toast.makeText(LoginActivity.this,"用户名不存在或者密码错误",Toast.LENGTH_SHORT).show();
                }*/
                break;


            case R.id.chinese:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UpText_chinese;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.english:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UpText_english;
                        handler.sendMessage(message);
                    }
                }).start();
                    break;
            case R.id.login_forget:
                Intent intent_f=new Intent(LoginActivity.this,RetrieveActivity.class);
                startActivity(intent_f);
                break;
            case R.id.login_registe:
                Intent intent_r=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent_r);
                break;
            default:
                break;
        }
    }
}
