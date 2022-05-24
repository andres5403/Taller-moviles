package com.example.talller;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;

import java.net.DatagramSocket;


public class Loggout extends AppCompatActivity {
    private Button btn_cerrar_sesion,btn_conexion;
    private  ConnectivityManager cm;
    private  NetworkInfo wifi,data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggout);
        btn_cerrar_sesion = findViewById(R.id.btn_cerrar_sesion);
        btn_conexion = findViewById(R.id.btn_conexion);





        btn_conexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conexion();

            }
        });



        btn_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Loggout.this,"Sesion cerrada",Toast.LENGTH_SHORT).show();
                irainicio();

            }
        });

    }




    private void irainicio() {
        Intent i = new Intent(this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }


    private void conexion(){


        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        @Deprecated
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo !=null && networkInfo.isConnected()){
            Toast.makeText(Loggout.this,"Con conexion a internet",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(Loggout.this,"Sin conexion a internet",Toast.LENGTH_SHORT).show();
            irainicio();
        }

    }




}