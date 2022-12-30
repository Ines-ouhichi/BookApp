package com.example.ktebi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.ktebi.databinding.ActivityMainBinding;
import com.example.ktebi.ui.Adapters.MainAdapter;
import com.example.ktebi.ui.DBHelpers2;
import com.example.ktebi.ui.Models.MainModel;

import java.util.ArrayList;

public class updateActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    DBHelpers2 DB2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DB2= new DBHelpers2(this);

        ArrayList<MainModel> list=DB2.getBooks();



        MainAdapter adapter=new MainAdapter(list,this);
        binding.recycerview.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recycerview.setLayoutManager(layoutManager);



    }
}