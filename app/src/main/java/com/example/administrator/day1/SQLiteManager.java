package com.example.administrator.day1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteManager {
    private SQLiteHelper helper;
    private SQLiteDatabase db;

    public SQLiteManager(Context context) {
        helper = new SQLiteHelper(context);
        db = helper.getWritableDatabase();  //db = helper.getReadableDatabase();
    }
    public void insert(String sql) {
        db.execSQL(sql);
    }
    public Cursor getResult(String sql) {
        return  db.rawQuery(sql,null);
    }
    public void closeDB() {
        db.close();
    }
}