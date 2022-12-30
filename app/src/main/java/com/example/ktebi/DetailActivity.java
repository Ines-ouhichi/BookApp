package com.example.ktebi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ktebi.databinding.ActivityDetailBinding;
import com.example.ktebi.ui.DBHelpers;
import com.example.ktebi.ui.DBHelpers2;

public class DetailActivity extends AppCompatActivity {
    DBHelpers DB;
    DBHelpers2 DB2;
    Button btn;
    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_detail);


        int image=getIntent().getIntExtra("image",0);
        final String name=getIntent().getStringExtra("name");
        final String description=getIntent().getStringExtra("description");
        final String rating=getIntent().getStringExtra("rating");


       // btn=findViewById(R.id.insertbtn);

        binding.imageViewDetail.setImageResource(image);
        binding.textViewBookName.setText(name);
        binding.bookRating.setText(rating);
        binding.BookDesc.setText(description);


        DB2= new DBHelpers2(this);

        binding.insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(DetailActivity.this,updateActivity.class));
                boolean IsInserted= DB2.insertBooks(name,description,rating,image);
                //startActivity(new Intent(DetailActivity.this,updateActivity.class));

                if(IsInserted){
                   Toast.makeText(DetailActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                   //startActivity(new Intent(DetailActivity.this,updateActivity.class));

               }else{
                   Toast.makeText(DetailActivity.this, "there seems to be a problem,please wait", Toast.LENGTH_SHORT).show();

               }
            }
        });




    }
}