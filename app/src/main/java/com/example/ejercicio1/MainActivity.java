package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mName;
    SharedPreferences ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mName =findViewById(R.id.name);
        ref = getSharedPreferences("myapp", MODE_PRIVATE);
        mName.setText(ref.getString("name", ""));


    }
}