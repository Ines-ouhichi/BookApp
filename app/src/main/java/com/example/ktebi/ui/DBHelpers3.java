package com.example.ktebi.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelpers3 extends SQLiteOpenHelper {

    public static final String DBNAME="works.db";
    private Context context;



    public DBHelpers3(@Nullable Context context) {
        super(context,"works.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table works(id integer primary key,title TEXT,description TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("create table works(id integer primary key,title TEXT,description TEXT)");
        //db.execSQL("drop table if exists works");


    }

    public boolean addBook(String title, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("title", title);
        cv.put("description", description);

        long result = db.insert("works",null, cv);
        if(result == -1){
            return false;
        }else {
           return true;
        }
    }

     public Cursor readAllData(){
        String query = "SELECT * FROM works " ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


   public  boolean updateData(String row_id, String title, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", title);
        cv.put("description", description);

         long result=db.update("works", cv, "id= ?", new String[]{row_id});
       if(result == -1){
           return false;
       }else {
           return true;
       }
    }

    public boolean deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("works", "id=?", new String[]{row_id});
        if(result == -1){
            return false;
            //Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            return true;
           //Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }
}
