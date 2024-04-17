package com.example.accesorioselect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    SharedPreferences preferences;
    EditText nom, usuario, cont, direc;
    Button Reg;

    String Nom, User, Pass, Direc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nom = findViewById(R.id.Nom);
        usuario = findViewById(R.id.Usuario);
        cont = findViewById(R.id.Pass);
        direc = findViewById(R.id.Direc);

        Reg.setOnClickListener(new View.OnClickListener() {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            @Override
            public void onClick(View v) {
                Nom = nom.getText().toString();
                GNom(Nom);
                User = usuario.getText().toString();
                GUs(User);
                Pass = cont.getText().toString();
                GPass(Pass);
                Direc = direc.getText().toString();
                GDir(Direc);

                Toast.makeText(getApplicationContext(),"Registro exitoso",Toast.LENGTH_LONG).show();

                startActivity(i);
            }
        });


    }

    private void GDir(String direc) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("direc",direc);
        editor.commit();
    }

    private void GPass(String pass) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("pass",pass);
        editor.commit();
    }

    private void GUs(String user) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",user);
        editor.commit();
    }

    private void GNom(String nom) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nombre",nom);
        editor.commit();
    }
}