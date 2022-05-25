package com.example.talller;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import org.w3c.dom.Text;

import java.net.DatagramSocket;


public class Loggout extends AppCompatActivity {
    private Button btn_cerrar_sesion,btn_conexion;
    private  ConnectivityManager cm;
    private  NetworkInfo wifi,data;
    private Spinner spinner1;
    private EditText et1,et2;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggout);
        btn_cerrar_sesion = findViewById(R.id.btn_cerrar_sesion);
        btn_conexion = findViewById(R.id.btn_conexion);


        et1 = (EditText) findViewById(R.id.first_number);
        et2 = (EditText) findViewById(R.id.secondnumber);

        tv1 = (TextView) findViewById(R.id.result_text);
        spinner1 = (Spinner) findViewById(R.id.spinner);

        String[] opciones = {"Sumar","Restar","Multiplicar","Dividir"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);

        //comprueba la conexion y si no hay internet vuelve a iniciar sesion
        btn_conexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conexion();

            }
        });
        // es el boton de cerrar sesion
        btn_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Loggout.this,"Sesion cerrada",Toast.LENGTH_SHORT).show();
                irainicio();

            }
        });

    }

    public void calcular(View view){
        String Valor1 = et1.getText().toString();
        String Valor2 = et2.getText().toString();

        int valor_int = Integer.parseInt(Valor1);
        int valor2_int = Integer.parseInt(Valor2);

        String seleccion = spinner1.getSelectedItem().toString();

        if (seleccion.equals("Sumar")){
            int suma = valor_int + valor2_int;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
        } else if(seleccion.equals("Restar")){
            int restar = valor_int - valor2_int;
            String resultado = String.valueOf(restar);
            tv1.setText(resultado);
        }else if(seleccion.equals("Multiplicar")){
            int mul = valor_int * valor2_int;
            String resultado = String.valueOf(mul);
            tv1.setText(resultado);

        }else if (seleccion.equals("Dividir")){

            if (valor2_int !=0) {
                int div = valor_int / valor2_int;
                String resultado = String.valueOf(div);
                tv1.setText(resultado);
            }else{
                Toast.makeText(this,"No se puede dividir entre 0",Toast.LENGTH_LONG).show();
            }

        }

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