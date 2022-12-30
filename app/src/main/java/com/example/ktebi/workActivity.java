package com.example.ktebi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ktebi.ui.Adapters.BookAdapter;
import com.example.ktebi.ui.DBHelpers3;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class workActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    DBHelpers3 DB;
    ArrayList<String> book_id, book_title, book_desc;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        DB = new DBHelpers3(this);
        recyclerView = findViewById(R.id.recycerview);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        book_id = new ArrayList<>();
        book_title = new ArrayList<>();
        book_desc = new ArrayList<>();

        storeDataInArrays();

        bookAdapter=new BookAdapter(workActivity.this,book_id,book_title,book_desc);


        recyclerView.setAdapter(bookAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(workActivity.this));

    }

    void storeDataInArrays() {
        Cursor cursor = DB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "  no data", Toast.LENGTH_SHORT).show();


        } else {
            while (cursor.moveToNext()) {
                book_id.add(cursor.getString(0));
                book_title.add(cursor.getString(1));
                book_desc.add(cursor.getString(2));
            }
        }
    }
}