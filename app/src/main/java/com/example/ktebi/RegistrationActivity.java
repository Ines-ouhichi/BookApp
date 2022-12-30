package com.example.ktebi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ktebi.ui.DBHelpers;

public class RegistrationActivity extends AppCompatActivity {

    EditText edUsername,edEmail,edPassword;
    Button btn;
    TextView tv;
    DBHelpers DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        edUsername=findViewById(R.id.EditTextName);
        edEmail=findViewById(R.id.editTextemail);
        edPassword=findViewById(R.id.editTextpassword);
        btn=findViewById(R.id.button1);
        tv=findViewById(R.id.textViewS1);
        DB = new DBHelpers(this);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));


            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                if (email.length() == 0 || password.length() == 0 || username.length() == 0) {
                    Toast.makeText(getApplicationContext(), " Fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (IsValid(password)) {
                        Boolean checkuser = DB.checkAccount(email);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(username, email, password);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), " registered successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "  user already exists", Toast.LENGTH_SHORT).show();

                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "  Password must contain at least 8 characters,having a letter,a digit and a special character", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            });
    }

   /* public void login(View view) {
        startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));

    }*/

    public static boolean IsValid(String password){
        int f1=0,f2=0,f3=0;
        if (password.length()<8){
            return false;
        }else{
            for(int p=0;p<password.length();p++){
                if(Character.isLetter(password.charAt(p))){
                    f1=1;
                }
            }

            for(int r=0;r<password.length();r++){
                if(Character.isDigit(password.charAt(r))){
                    f2=1;
                }
            }

            for (int s=0;s<password.length();s++){
                char c=password.charAt(s);
                if(c>=33&&c<=46 ||c==64){
                    f3=1;
                }
            }

            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }
}