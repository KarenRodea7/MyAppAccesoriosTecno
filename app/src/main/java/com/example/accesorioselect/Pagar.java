package com.example.accesorioselect;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pagar extends AppCompatActivity {

    SharedPreferences preferences;
    TextView grac, compras, TP;
    Button Pag;

    int Totf;
    String nom, direc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);

        grac = findViewById(R.id.NomPag);
        compras = findViewById(R.id.Compras);
        TP = findViewById(R.id.TotalP);
        Pag = findViewById(R.id.Pagado);

        leerOpc();

        Pag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Pagar.class);
                imprimir();
            }
        });

    }

    private void imprimir() {
        new AlertDialog.Builder(this)
                .setTitle("¡Gracias por su compra!")
                .setMessage("Tu compra ha sido exitosa y ahora se enviarán tus productos a: "+direc)
                .setPositiveButton("Nueva compra", (dialogInterface, i) -> NvaCom())
                .setCancelable(false)
                .show();
    }

    /*private void Cerrar() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        preferences = getSharedPreferences("Variables", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear().commit();
        startActivity(i);
    }*/

    private void NvaCom() {
        Intent i = new Intent(getApplicationContext(), Menu.class);
        preferences = getSharedPreferences("Variables", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear().commit();
        startActivity(i);
    }

    private void leerOpc() {
        preferences=getSharedPreferences("Variables", Context.MODE_PRIVATE);
        Totf = Integer.parseInt(preferences.getString("totf", "0"));
        TP.setText("Total: $"+Totf);
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        nom = preferences.getString("nombre", "0");
        grac.setText("Aquí se muestran sus compras "+nom);
        direc = preferences.getString("direc", "0");
    }
}