package com.example.accesorioselect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {

    ImageButton Fundas, Audif, Otro;

    int val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Fundas = findViewById(R.id.Fundas);
        Audif = findViewById(R.id.Audif);
        Otro = findViewById(R.id.Otro);

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
                startActivity(i);
            }
        });


    }
}