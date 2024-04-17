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

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    Button Registro, btnIniciar;
    EditText user, pass;
    int sum;
    String usu, pswd, nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = (Button) findViewById(R.id.Iniciar);
        Registro = findViewById(R.id.Registrar);
        user = (EditText)findViewById(R.id.User);
        pass = (EditText)findViewById(R.id.Pass);

        leerOpc();

        btnIniciar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(sum<3){
                    sum = sum + 1;

                    Intent intent = new Intent(getApplicationContext(), Menu.class);
                    String datos = user.getText().toString();
                    String contr = pass.getText().toString();


                    if(datos.equals(usu) & contr.equals(pswd)){
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(),"Cuenta o contraseña incorrectos, te quedan:  " +(3-sum)+" Intentos",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Excediste tus oportunidades",Toast.LENGTH_SHORT).show();
                    btnIniciar.setEnabled(false);
                }
            }
        });

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Registro.class);
                startActivity(i);
            }
        });
    }
    private void leerOpc() {
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        usu = preferences.getString("user","No hay datos");
        pswd = preferences.getString("pass", "No hay datos");
        nom = preferences.getString("nombre", "No hay datos");
    }
}