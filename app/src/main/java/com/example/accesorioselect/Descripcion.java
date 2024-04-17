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

    int val, valP, sum1, Total, prec, Totf;

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
                des.setText("Funda de componentes\n\n" + "Funda de componentes de celular para iPhone 14 Pro, Zero One.\n" + "Color: Negro\n" + "$200");
                prec=200;
                sum1=0;
                cant.setText(String.valueOf(sum1));
            }
            else if(valP==2){
                ima.setImageResource(R.drawable.img_4);
                des.setText("Funda de mariposas\n\n"+"Funda de teléfono con mariposa de onda brillante y pulsera para iPhone.\n" + "Color: Morado\n"+"$120");
                prec=120;
                sum1=0;
                cant.setText(String.valueOf(sum1));
            }
            else if(valP==3){
                ima.setImageResource(R.drawable.img_5);
                des.setText("Funda de astronauta\n\n"+"Funda para teléfono Motorola con soporte de Astronauta y correa.\n" + "Color: Negro\n$160");
                prec=160;
                sum1=0;
                cant.setText(String.valueOf(sum1));
            }
        }
        else if(val==2){
            if(valP==1) {
                ima.setImageResource(R.drawable.img_6);
                des.setText("Audifonos de gato negro\n\n" + "Audifonos bluetooth inalambricos de diadema con radio FM.\n" + "Color: Negro\n$270");
                prec=270;
                sum1=0;
                cant.setText(String.valueOf(sum1));
            }
            else if(valP==2){
                ima.setImageResource(R.drawable.img_7);
                des.setText("Audifonos deportivos\n\n"+"Audífonos inalámbricos deportivos con micrófono y con cancelación de ruido y manos libres.\n" + "Color: Multicolor\n$100");
                prec=100;
                sum1=0;
                cant.setText(String.valueOf(sum1));
            }
            else if(valP==3){
                ima.setImageResource(R.drawable.img_8);
                des.setText("Audifonos con banda para cuello\n\n"+"Audífonos inalámbricos intraauriculares con banda para el cuello y micrófono.\n" + "Color: Negro\n$170");
                prec=170;
                sum1=0;
                cant.setText(String.valueOf(sum1));
            }
        }
        else if(val==3){
            if(valP==1) {
                ima.setImageResource(R.drawable.img);
                des.setText("Teclado flexible\n\n" + "Teclado flexible y plegable de Silicona resistente al agua para juegos USB mudo. \n" + "Color: Negro\n$210");
                prec=210;
                sum1=0;
                cant.setText(String.valueOf(sum1));
            }
            else if(valP==2){
                ima.setImageResource(R.drawable.img_1);
                des.setText("Teclado mini\n\n"+"Teclado mini con retroiluminación de 7 colores y touchpad con efecto de marquesina. \n" + "Color: Negro\n$160");
                prec=160;
                sum1=0;
                cant.setText(String.valueOf(sum1));
            }
            else if(valP==3){
                ima.setImageResource(R.drawable.img_2);
                des.setText("Teclado inalámbrico\n\n"+"Teclado bluetooth inalámbrico con Touchpad integrado, multi-dispositivo con soporte para TV, teléfono tableta.\n" + "Color: Negro\n$300");
                prec=300;
                sum1=0;
                cant.setText(String.valueOf(sum1));
            }
        }


        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum1>0){
                    sum1--;
                    cant.setText(String.valueOf(sum1));
                    Gsum1(sum1);
                }
                Total=sum1*prec;
                GTot(Total);
                tot.setText("Total: $"+Total);
            }
        });

        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum1++;
                cant.setText(String.valueOf(sum1));
                Gsum1(sum1);
                Total= sum1*prec;
                GTot(Total);
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
                GTotf(Totf);
                startActivity(i);
            }
        });


    }
    private void GTot(int Total) {
        preferences=getSharedPreferences("Variables", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Total", String.valueOf(Total));
        editor.commit();
    }
    private void Gsum1(int sum1) {
        preferences=getSharedPreferences("Variables", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("sum1", String.valueOf(sum1));
        editor.commit();
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
        sum1 = Integer.parseInt(preferences.getString("sum1", "0"));
        cant.setText(String.valueOf(sum1));
        Total = Integer.parseInt(preferences.getString("Total", "0"));
    }
}