package com.example.ktebi.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ktebi.ui.Models.MainModel;

import java.util.ArrayList;

public class DBHelpers2  extends SQLiteOpenHelper {

    public static final String DBNAME="books.db";
    public DBHelpers2(@Nullable Context context) {
        super(context, "books.db", null , 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db1) {
       //db1.execSQL("create table books (id integer primary key autoincrement ,name TEXT,description TEXT,rating Text,image int)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int i, int i1) {
        db1.execSQL("create table books (id integer primary key autoincrement ,name TEXT,description TEXT,rating Text,image int)");
        //db1.execSQL("drop table if exists books");

        onCreate(db1);


    }
    public boolean insertBooks(String name,String description,String rating, int image){
        SQLiteDatabase db1=this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("name",name);
        values.put("description",description);
        values.put("rating",rating);
        values.put("image",image);


        long result=db1.insert("books",null,values);
        if(result==-1)
            return false;
        return true;

    }

    public ArrayList<MainModel> getBooks(){
        ArrayList<MainModel> books =new ArrayList<>();
        SQLiteDatabase db1=this.getWritableDatabase();
        Cursor cur =db1.rawQuery("select id ,name,description ,rating ,image from books",null);
        if(cur.moveToFirst()){
            while(cur.moveToNext()){
                MainModel model =new MainModel();
                model.setId(cur.getString(0));
                model.setName(cur.getString(1));
                model.setDescription(cur.getString(2));
                model.setRating(cur.getString(3));
                model.setImage(cur.getInt(4));
                books.add(model);
            }
        }
        cur.close();
        db1.close();
        return books;
    }

    public int DeleteBook(String name){
        SQLiteDatabase db1=this.getWritableDatabase();
        return db1.delete("books","name="+name,null);
    }


}
