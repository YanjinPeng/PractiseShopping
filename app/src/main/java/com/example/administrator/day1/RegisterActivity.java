package com.example.administrator.day1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends NoTitleActivity implements View.OnClickListener{

    public static final int CreateCode = 1;

    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            switch (message.what){
                case CreateCode:
                    imageView.setImageBitmap(RandomCode.getInstance().createBitmap());
                    randomcode = RandomCode.getInstance().getCode();
                    //.equalsIgnoreCase()不区分 英文字母大小写 对比
                    ToastUtils.showToast(RegisterActivity.this,""+randomcode);
                    //textView.setText(RandomCode.getInstance().getCode());
                    break;
            }
        }
    };

    String randomcode;

    EditText re_captcha,re_phone_captcha;
    Button tel_captcha,btn_regsiter,btn_back;
    EditText r_name,r_password,r_repassword,r_pay_password;
    String n1,psw1,psw2;
    SQLiteManager db;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imageView = (ImageView)findViewById(R.id.random_code);
        imageView.setOnClickListener(this);

        re_phone_captcha = (EditText)findViewById(R.id.registe_tel_yzm_edit);
        GradientDrawable myGrad1 = (GradientDrawable)re_phone_captcha.getBackground();
        myGrad1.setColor(Color.parseColor("#b0b0b0"));//设置shape文件的背景颜色
        myGrad1.setStroke(0, Color.parseColor("#00000000"));

        tel_captcha = (Button)findViewById(R.id.registe_tel_yzm);
        tel_captcha.setOnClickListener(this);

        btn_regsiter = (Button)findViewById(R.id.registe_button);
        GradientDrawable myGrad = (GradientDrawable)btn_regsiter.getBackground();
        myGrad.setColor(Color.parseColor("#5069ff"));//设置shape文件的背景颜色
        btn_regsiter.setOnClickListener(this);
        btn_back = (Button)findViewById(R.id.registe_back);
        GradientDrawable myGradb2 = (GradientDrawable)btn_back.getBackground();
        myGradb2.setColor(Color.parseColor("#5069ff"));//设置shape文件的背景颜色
        btn_back.setOnClickListener(this);

        r_name=(EditText)findViewById(R.id.registe_name) ;
        r_password=(EditText)findViewById(R.id.registe_password);
        r_repassword=(EditText)findViewById(R.id.registe_repassword);
        r_pay_password=(EditText)findViewById(R.id.registe_pay_password);

        imageView.setImageBitmap(RandomCode.getInstance().createBitmap());
        randomcode = RandomCode.getInstance().getCode();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registe_back:
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.registe_button:
                n1=r_name.getText().toString();
                psw1=r_password.getText().toString();
                psw2=r_repassword.getText().toString();
                if(psw1.equals(psw2)&&(!psw1.equals(""))&&(!n1.equals(""))) {
                    db=new SQLiteManager(RegisterActivity.this);
                    String sql="INSERT INTO user(user_name,user_password,user_pay_password) VALUES("+n1+","+psw1+","+psw2+")";
                    db.insert(sql);
                    db.closeDB();

                    ToastUtils.showToast(RegisterActivity.this,"注册成功");
                    Intent intent1=new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent1);
                }else {
                    ToastUtils.showToast(RegisterActivity.this,"注册失败(用户名和密码不能为空)");
                }break;

            case R.id.random_code:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = CreateCode;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.registe_tel_yzm:
                //按钮倒计时60秒，60秒内不可点击。第二个参数是设置计时的速度，1000就是每秒一次。
                new CountDownTimer(60000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        tel_captcha.setEnabled(false);
                        tel_captcha.setText(String.format("%ds",millisUntilFinished/1000));
                    }

                    @Override
                    public void onFinish() {
                        tel_captcha.setEnabled(true);
                        tel_captcha.setText("重新获取验证码");
                    }
                }.start();
                break;
            default:
                break;
        }
    }
}
