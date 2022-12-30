package com.example.ktebi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ktebi.ui.DBHelpers;
import com.example.ktebi.ui.DBHelpers3;

public class AddActivity extends AppCompatActivity {

    EditText bookTitle,bookDescr ;
    Button add_button;
    DBHelpers3 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        bookTitle = findViewById(R.id.booktitle);
        bookDescr = findViewById(R.id.bookDetail);
        add_button = findViewById(R.id.add_button);
        DB = new DBHelpers3(this);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title = bookTitle.getText().toString();
                String Descr = bookDescr.getText().toString();
              boolean add=  DB.addBook(Title,Descr);
              if(add){
                  Toast.makeText(getApplicationContext(), "  new book added", Toast.LENGTH_SHORT).show();
              }else{
                  Toast.makeText(getApplicationContext(), " book error", Toast.LENGTH_SHORT).show();

              }

            }
        });
    }
}