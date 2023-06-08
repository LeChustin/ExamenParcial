package com.velasuez.tutorial1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlLite extends SQLiteOpenHelper {


    public SqlLite(Context context, String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("CREATE TABLE IF NOT EXISTS persona(codigo 'int', funcionario 'varchar', cargo 'varchar', area 'varchar', hijos 'varchar',estado 'varchar', descuento 'varchar')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
