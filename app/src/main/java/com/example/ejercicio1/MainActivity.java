package com.example.ejercicio1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    private Button  ejercicio1, ejercicio2;
    String _url= "https://github.com/danilo95/parcial01-ficha-de-vendedor-kotlin";
    String _url2="https://github.com/danilo95/kotlin-parcial01-formula-cuadratica";

    TextView mName;
    SharedPreferences ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mName =findViewById(R.id.name);
        ref = getSharedPreferences("myapp", MODE_PRIVATE);
        mName.setText(ref.getString("name", ""));

        ejercicio1= findViewById(R.id.ejercicio1);
        ejercicio2 = findViewById(R.id.ejercicio2);

        ejercicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _link = Uri.parse(_url);
                Intent i=new Intent(Intent.ACTION_VIEW, _link );
                startActivity(i);

            }
        });

        ejercicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _link = Uri.parse(_url2);
                Intent i=new Intent(Intent.ACTION_VIEW, _link );
                startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.logout){
            logout();
        }


        return true;
    }

    private void logout() {
        ref.edit().putBoolean("login",true).apply();
    }
}