package com.example.lab12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BaseDatosLista extends SQLiteOpenHelper {

    public BaseDatosLista(Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "bd2", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table informe(_id integer primary key autoincrement,Nombre text,Descripcion text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Abrir la base de datos
    public void abrir(){
        this.getWritableDatabase();
    }
    //Cerramos la base de datos
    public void cerrar(){
        this.close();
    }
    //Metodo que me permite ingresar datos
    public void insertar(String nombre,String descripcion){
        ContentValues valores=new ContentValues();
        valores.put("Nombre",nombre);
        valores.put("Descripcion",descripcion);

        this.getWritableDatabase().insert("informe",null,valores);
    }
    //Metodo que  permite   validar campos de logeo
    public List<Modelo> mostrarmodelo(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("select * from informe",null);
        List<Modelo> cursos=new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                cursos.add(new Modelo(cursor.getString(1),cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return  cursos;
    }

}

