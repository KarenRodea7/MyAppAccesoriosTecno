package com.example.accesorioselect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Productos extends AppCompatActivity {

    ImageButton P1, P2, P3;
    int valP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        P1 = findViewById(R.id.Prod1);
        P2 = findViewById(R.id.Prod2);
        P3 = findViewById(R.id.Prod3);




        P1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Descripcion.class);
                valP = 1;
                startActivity(i);
            }
        });

        P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Descripcion.class);
                valP = 2;
                startActivity(i);
            }
        });

        P3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Descripcion.class);
                valP = 3;
                startActivity(i);
            }
        });


    }
}