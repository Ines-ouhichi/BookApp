package com.example.ktebi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ktebi.ui.DBHelpers3;

public class miseActivity extends AppCompatActivity {
    EditText title_input, desc_input;
    Button update_button,delete_button;

    String id, title, desc;
    DBHelpers3 DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mise);

        title_input = findViewById(R.id.booktitle1);
        desc_input = findViewById(R.id.bookDetail1);
        update_button = findViewById(R.id.update_button);
        delete_button=findViewById(R.id.delete_button);

        getAndSetIntentData();
        ActionBar ab =getSupportActionBar();
        if(ab!=null){

             ab.setTitle(title);}

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DB = new DBHelpers3(miseActivity.this);
               String Title = title_input.getText().toString();
                String Descr = desc_input.getText().toString();

               Boolean add= DB.updateData(id, Title, Descr);
               if(add){
                   Toast.makeText(getApplicationContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show();

               }else{
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });


    }


    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
                getIntent().hasExtra("desc")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            desc = getIntent().getStringExtra("desc");


            title_input.setText(title);
            desc_input.setText(desc);


        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title + " ?");
        builder.setMessage("Are you sure you want to delete " + title + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DB = new DBHelpers3(miseActivity.this);
                boolean deleted=DB.deleteOneRow(id);
                if(deleted){
                    Toast.makeText(getApplicationContext(), "Successfully Deleted!", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(), "Failed to Delete.", Toast.LENGTH_SHORT).show();

                }
                finish();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

}