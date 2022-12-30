package com.example.ktebi.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelpers extends SQLiteOpenHelper {
    public static final String DBNAME="login.db";
    //public static final String TABLE_NAME = "books";
   private static int db_version = 2;


    public DBHelpers(@Nullable Context context) {
        super(context, "login.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key,email TEXT,password TEXT)");
       // db.execSQL("create table "+TABLE_NAME+"(id int primary key autoincrement,name TEXT,description TEXT,rating Text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table if exists users");
        //db.execSQL("drop table if exists books");

        //db.execSQL("create table books (id int primary key autoincrement,name TEXT,description TEXT,rating Text)");
        onCreate(db);

    }


    public boolean insertData(String username,String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put("username",username);
        values.put("email",email);
        values.put("password",password);

        long result=db.insert("users",null,values);
        if(result==-1)
            return false;
        return true;

    }

  /*  public boolean insertBooks(String name,String description,String rating){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put("name",name);
        values.put("description",description);
        values.put("rating",rating);


        long result=db.insert("books",null,values);
        if(result==-1)
            return false;
        return true;

    }*/

    public Boolean checkAccount(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkemailpassword(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email = ? and password = ?", new String[] {email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
