package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    EditText nName,mEmail,mPassword;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nName =findViewById(R.id.fullname);
        mEmail=findViewById(R.id.email);
        mPassword=findViewById(R.id.password);
        ref=getSharedPreferences("myapp",MODE_PRIVATE);

    }

    public void signup(View view) {
        String name=nName.getText().toString();
        String email=mEmail.getText().toString();
        String password=mPassword.getText().toString();

        ref.edit().putString("name",name).apply();
        ref.edit().putString("email",email).apply();
        ref.edit().putString("password",password).apply();
        ref.edit().putBoolean("login",true).apply();

        Intent i =new Intent(Signup.this,MainActivity.class);
        startActivity(i);

    }
}