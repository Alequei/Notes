package com.example.lab12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro_Lista extends AppCompatActivity {
    EditText txtusuario,txtdescripcion;
    Button btn1;
    BaseDatosLista baseDatos=new BaseDatosLista(this,"bd2",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__lista);
        txtusuario=(EditText)findViewById(R.id.editTextnombre);
        txtdescripcion=(EditText)findViewById(R.id.edittextdescripcion);
        btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.abrir();
                baseDatos.insertar(String.valueOf(txtusuario.getText()),
                        String.valueOf(txtdescripcion.getText()));
                baseDatos.close();
                Toast.makeText(getApplicationContext(),"Registro de almacenamiento exitoso",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),Listado.class);
                startActivity(i);
            }
        });

    }
}
