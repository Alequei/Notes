package com.example.lab12;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class Listado extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private FloatingActionButton button;
    BaseDatosLista baseDatos=new BaseDatosLista(this,"bd2",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        button=(FloatingActionButton)findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Registro_Lista.class);
                startActivity(i);
            }
        });
        recyclerView=(RecyclerView)findViewById(R.id.list_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new Adapter(baseDatos.mostrarmodelo());
        recyclerView.setAdapter(adapter);

    }
}
