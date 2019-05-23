package com.example.lab12;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    Button btnusuario;
    EditText txtusuario,txtnombres,txtcorreo,txtclave;
    BaseDatos baseDatos=new BaseDatos(this,"bd1",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnusuario=(Button)findViewById(R.id.Registrar);
        txtusuario=(EditText)findViewById(R.id.editTextusuario);
        txtnombres=(EditText)findViewById(R.id.editTextcnombre);
        txtcorreo=(EditText)findViewById(R.id.editTextcorreo);
        txtclave=(EditText)findViewById(R.id.editTextclave);

        btnusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.abrir();
                baseDatos.insertar(String.valueOf(txtusuario.getText()),
                        String.valueOf(txtnombres.getText()),
                        String.valueOf(txtcorreo.getText()),
                        String.valueOf(txtclave.getText()));
                baseDatos.close();

                Toast.makeText(getApplicationContext(),"Registro de almacenamiento exitoso",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }

}
