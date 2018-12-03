package com.example.administrator.day1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.day1.LoginPager.LoginActivity;
import com.example.administrator.day1.SQLite.SQLiteManager;
import com.example.administrator.day1.StyleActivity.NoTitleActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends NoTitleActivity {

    boolean isFirst;
    SharedPreferences sp;
    SQLiteManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp  =  getSharedPreferences("data",MODE_PRIVATE);
        isFirst = sp.getBoolean("FIRST",false);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!isFirst) {
                    SharedPreferences.Editor editor  =  sp.edit();
                    editor.putBoolean("FIRST", true);
                    editor.commit();
                    db=new SQLiteManager(MainActivity.this);
                    //user_name , user_password
                    String sql="INSERT INTO user(user_name,user_password,user_pay_password) VALUES("+"2018001,"+"123456,"+"123456"+")";
                    String sql3="INSERT INTO user(user_name,user_password,user_pay_password) VALUES("+"2018002,"+"123456,"+"123456"+")";
                    Log.i("**********",sql3);
                    db.insert(sql);
                    db.insert(sql3);
                    String sql2 = "SELECT * FROM  user";
                    Cursor result =  db.getResult(sql2);
                    result.moveToFirst();
                    while (!result.isAfterLast()) {    //cursor.moveToNext()
                        String a = result.getString(0);
                        String b = result.getString(1);
                        String c = result.getString(2);
                        String d = result.getString(3);
                        String all1 = a+"\n"+b+"\n"+c+"\n"+d+"\n";
                        Log.d("*******",all1);
                        result.moveToNext();
                    }
                    result.close();
                    db.closeDB();
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.schedule(task, 3000);


    }
}
