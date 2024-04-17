package com.example.accesorioselect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Productos extends AppCompatActivity {

    SharedPreferences preferences;
    ImageButton P1, P2, P3;
    TextView T1, T2, T3;
    Button Menu;
    int val, valP, cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        P1 = findViewById(R.id.Prod1);
        P2 = findViewById(R.id.Prod2);
        P3 = findViewById(R.id.Prod3);
        T1 = findViewById(R.id.Tit1);
        T2 = findViewById(R.id.Tit2);
        T3 = findViewById(R.id.Tit3);
        Menu = findViewById(R.id.MenuP);

        leerOpc();


        if(val == 1){
            P1.setImageResource(R.drawable.img_3);
            P2.setImageResource(R.drawable.img_4);
            P3.setImageResource(R.drawable.img_5);
            T1.setText("Funda de componentes");
            T2.setText("Funda de mariposas");
            T3.setText("Funda de astronauta");
        }
        if(val == 2){
            P1.setImageResource(R.drawable.img_6);
            P2.setImageResource(R.drawable.img_7);
            P3.setImageResource(R.drawable.img_8);
            T1.setText("Audifonos de gato negro");
            T2.setText("Audifonos deportivos");
            T3.setText("Audifonos con banda para cuello");
        }
        if(val == 3){
            P1.setImageResource(R.drawable.img);
            P2.setImageResource(R.drawable.img_1);
            P3.setImageResource(R.drawable.img_2);
            T1.setText("Teclado flexible");
            T2.setText("Teclado mini");
            T3.setText("Teclado inalámbrico");
        }




        P1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Descripcion.class);
                valP = 1;
                Gval(valP);
                startActivity(i);
            }
        });

        P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Descripcion.class);
                valP = 2;
                Gval(valP);
                startActivity(i);
            }
        });

        P3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Descripcion.class);
                valP = 3;
                Gval(valP);
                startActivity(i);
            }
        });

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Menu.class);
                startActivity(i);
            }
        });


    }

    private void Gval(int valP) {
        preferences=getSharedPreferences("Variables", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("valP", String.valueOf(valP));
        editor.commit();
    }

    private void leerOpc() {
        preferences = getSharedPreferences("Variables", Context.MODE_PRIVATE);
        val = Integer.parseInt(preferences.getString("val", "0"));
    }
}