package com.example.accesorioselect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Descripcion extends AppCompatActivity {

    SharedPreferences preferences;
    ImageView ima;
    TextView des, tot;
    Button Menu, Pago;
    ImageButton mas, men;
    EditText cant;

    int val, valP, sum1=0, Total, prec, Totf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        ima = findViewById(R.id.Imagen);
        des = findViewById(R.id.Descrip);
        Menu = findViewById(R.id.MenuD);
        Pago = findViewById(R.id.Pagar);
        mas = findViewById(R.id.M1);
        men = findViewById(R.id.m1);
        cant = findViewById(R.id.Cant);
        tot = findViewById(R.id.Tot);

        leerOpc();

        if(val==1){
            if(valP==1) {
                ima.setImageResource(R.drawable.img_3);
                des.setText("Funda de componentes\n\n" + "Funda de componentes de celular para iPhone 14 Pro, Zero One.\n" + "Color: Negro\n\n"+"$200");
                prec=200;
            }
            if(valP==2){
                ima.setImageResource(R.drawable.img_4);
                des.setText("Funda de mariposas\n\n"+"Funda de teléfono con mariposa de onda brillante y pulsera para iPhone.\n" + "Color: Morado\n\n"+"$120");
                prec=120;
            }
            if(valP==3){
                ima.setImageResource(R.drawable.img_5);
                des.setText("Funda de astronauta\n\n"+"Funda para teléfono Motorola con soporte de Astronauta y correa.\n" + "Color: Negro\n\n$160");
                prec=160;
            }
        }
        if(val==2){
            if(valP==1) {
                ima.setImageResource(R.drawable.img_6);
                des.setText("Audifonos de gato negro\n\n" + "Audifonos bluetooth inalambricos de diadema con radio FM, diseño de Gato negro.\n" + "Color: Negro\n\n$270");
                prec=270;
            }
            if(valP==2){
                ima.setImageResource(R.drawable.img_7);
                des.setText("Audifonos deportivos\n\n"+"Audífonos TWS inalámbricos deportivos con micrófono, intrauditivos con cancelación de ruido y manos libres.\n" + "Color: Multicolor\n\n$100");
                prec=100;
            }
            if(valP==3){
                ima.setImageResource(R.drawable.img_8);
                des.setText("Audifonos con banda para cuello\n\n"+"Audífonos inalámbricos intraauriculares con banda para el cuello y micrófono para llamadas con manos libres.\n" + "Color: Negro\n\n$170");
                prec=170;
            }
        }
        if(val==3){
            if(valP==1) {
                ima.setImageResource(R.drawable.img);
                des.setText("Teclado flexible\n\n" + "Teclado flexible y plegable de Silicona resistente al agua para juegos USB mudo con 85 teclas. \n" + "Color: Negro\n\n$210");
                prec=210;
            }
            if(valP==2){
                ima.setImageResource(R.drawable.img_1);
                des.setText("Teclado mini\n\n"+"Teclado mini con retroiluminación de 7 colores y touchpad con efecto de marquesina. \n" + "Color: Negro\n\n$160");
                prec=160;
            }
            if(valP==3){
                ima.setImageResource(R.drawable.img_2);
                des.setText("Teclado inalámbrico\n\n"+"Teclado bluetooth inalámbrico con Touchpad integrado, multi-dispositivo con soporte para TV, teléfono tableta.\n" + "Color: Negro\n\n$300");
                prec=300;
            }
        }

        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum1>0){
                    sum1--;
                    cant.setText(String.valueOf(sum1));
                }
                Total=sum1*prec;
                tot.setText("Total: $"+Total);
            }
        });

        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum1++;
                cant.setText(String.valueOf(sum1));
                Total= sum1*prec;
                tot.setText("Total: $"+Total);
            }
        });


        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Menu.class);
                Totf = Totf+Total;
                GTotf(Totf);
                startActivity(i);
            }
        });

        Pago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Pagar.class);
                Totf = Totf+Total;
                startActivity(i);
            }
        });


    }

    private void GTotf(int totf) {
        preferences=getSharedPreferences("Variables", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("totf", String.valueOf(totf));
        editor.commit();
    }

    private void leerOpc() {
        preferences = getSharedPreferences("Variables", Context.MODE_PRIVATE);
        val = Integer.parseInt(preferences.getString("val", "0"));
        valP = Integer.parseInt(preferences.getString("valP", "0"));
        Totf = Integer.parseInt(preferences.getString("totf", "0"));
    }
}