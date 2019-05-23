package com.example.lab12;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnregister,btnigresar;
BaseDatos bd=new BaseDatos(this,"bd1",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnregister=(Button)findViewById(R.id.button2);
        btnigresar=(Button)findViewById(R.id.button);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Registro.class);
                startActivity(intent);
            }
        });
        btnigresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtusu=(EditText)findViewById(R.id.editText2);
                EditText txtclave=(EditText)findViewById(R.id.editText);
                try {
                    Cursor cursor=bd.ConsultaruUsuPas(txtusu.getText().toString(),txtclave.getText().toString());
                    if (cursor.getCount()>0){
                        Intent i=new Intent(getApplicationContext(),Listado.class);
                        startActivity(i);

                    }else {
                        Toast.makeText(getApplicationContext(),"Usuario y  calve son incorrectas",Toast.LENGTH_SHORT).show();
                    }
                    txtusu.setText("");
                    txtclave.setText("");
                    txtusu.findFocus();
                }catch (SQLException e){
                    e.printStackTrace();
                }

            }
        });
    }
}
