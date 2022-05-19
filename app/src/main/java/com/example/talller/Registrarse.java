package com.example.talller;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Registrarse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
    }
    public void Volverlogin(View view){
        Intent volverlogin= new Intent(this, MainActivity.class);
        startActivity(volverlogin);
    }
}