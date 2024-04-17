package com.example.accesorioselect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Menu extends AppCompatActivity {
    SharedPreferences preferences;
    ImageButton Fundas, Audif, Otro;
    TextView N;
    int val, nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        leerOpc();

        Fundas = findViewById(R.id.Fundas);
        Audif = findViewById(R.id.Audif);
        Otro = findViewById(R.id.Otro);
        N = findViewById(R.id.Nom);

        Fundas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Productos.class);
                val = 1;
                startActivity(i);
            }
        });

        Audif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Productos.class);
                val = 2;
                startActivity(i);
            }
        });

        Otro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Productos.class);
                val = 3;
                Gval(val);
                startActivity(i);
            }
        });
    }

    private void Gval(int val) {
        preferences=getSharedPreferences("Variables", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("val", String.valueOf(val));
        editor.commit();
    }


    private void leerOpc() {
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        nom = Integer.parseInt(preferences.getString("nombre", "0"));
        N.setText("Binvenido "+nom);
    }
}