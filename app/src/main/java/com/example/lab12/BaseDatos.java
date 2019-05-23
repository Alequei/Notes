package com.example.lab12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String query="create table usuarios(_id integer primary key autoincrement,Usuario text,Nombre text,Correo text,Clave text);";
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
    public void insertar(String usuario,String nombre,String correo,String clave){
        ContentValues valores=new ContentValues();
        valores.put("Usuario",usuario);
        valores.put("Nombre",nombre);
        valores.put("Correo",correo);
        valores.put("Clave",clave);
        this.getWritableDatabase().insert("usuarios",null,valores);
    }
    //Metodo que  permite   validar campos de logeo
    public Cursor ConsultaruUsuPas(String usuario,String clave) throws SQLException {
        Cursor mcursor=null;
        mcursor=this.getReadableDatabase().query("usuarios",new String[]{"_id","Usuario","Nombre","Correo","Clave"},
                "Usuario like'"+usuario+"'and Clave like'"+clave+"'",null,null,null,null);
        return  mcursor;
    }

}
