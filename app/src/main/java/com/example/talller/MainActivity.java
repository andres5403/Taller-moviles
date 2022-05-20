package com.example.talller;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // metodo para llevarlo a la venta de registro

    public void Ventanaregistro(View view){
        Intent ventanaregistro = new Intent(this, Registrarse.class);
        startActivity(ventanaregistro);
    }

}