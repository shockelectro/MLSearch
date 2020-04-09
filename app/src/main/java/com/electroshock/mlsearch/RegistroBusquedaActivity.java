package com.electroshock.mlsearch;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.electroshock.mlsearch.data.DbHelper;
import com.electroshock.mlsearch.sqlite.ConexionSQLiteHelper;
import com.electroshock.mlsearch.sqlite.dbSchemaContract;

public class RegistroBusquedaActivity extends AppCompatActivity {

    EditText campoId, campoCategoria, campoQuery, campoPrecioMin, campoPrecioMax, campoEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_busqueda);

        campoCategoria = (EditText) findViewById(R.id.campoCategoria);
        campoQuery = (EditText) findViewById(R.id.campoQuery);
        campoPrecioMin = (EditText) findViewById(R.id.campoPrecioMin);
        campoPrecioMax = (EditText) findViewById(R.id.campoPrecioMax);
        campoEstado = (EditText) findViewById(R.id.campoEstado);

    }

    public void onClick(View view) {
        registrarBusqueda();
        //registrarUsuariosSql();
    }

    private void registrarUsuariosSql() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"alerta",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        //insert into usuario (id,nombre,telefono) values (123,'Cristian','85665223')



        String insert="INSERT INTO "+ dbSchemaContract.BusquedasEntry.TABLA_BUSQUEDA
                +" ( " +
                dbSchemaContract.BusquedasEntry.COLUM_CATEGORIA + "," +
                dbSchemaContract.BusquedasEntry.COLUM_QUERY +","+
                dbSchemaContract.BusquedasEntry.COLUM_PRECIO_MIN + ","+
                dbSchemaContract.BusquedasEntry.COLUM_PRECIO_MIN + ","+
                dbSchemaContract.BusquedasEntry.COLUM_ESTADO + ")" +
                " VALUES ('"+
                campoCategoria.getText().toString()+"', '"+
                campoQuery.getText().toString()+"','" +
                campoPrecioMin.getText().toString() +"','" +
                campoPrecioMax.getText().toString() +"','" +
                campoEstado.getText().toString() + "')";

        db.execSQL(insert);
        db.close();
    }


    private void registrarBusqueda() {
        DbHelper mItemsDbHelper = new DbHelper(this);

        SQLiteDatabase sqLiteDatabase = mItemsDbHelper.getWritableDatabase();
        //ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"alerta",null,2);

        //SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();

        //values.put(dbSchemaContract.BusquedasEntry.COLUM_ID_BUSQUEDA, campoCategoria.getText().toString());
        values.put(dbSchemaContract.BusquedasEntry.COLUM_CATEGORIA, campoCategoria.getText().toString());
        values.put(dbSchemaContract.BusquedasEntry.COLUM_QUERY, campoQuery.getText().toString());
        values.put(dbSchemaContract.BusquedasEntry.COLUM_PRECIO_MIN, campoPrecioMin.getText().toString());
        values.put(dbSchemaContract.BusquedasEntry.COLUM_PRECIO_MAX, campoPrecioMax.getText().toString());
        values.put(dbSchemaContract.BusquedasEntry.COLUM_ESTADO, campoEstado.getText().toString());


        Long idResultante=sqLiteDatabase.insert(dbSchemaContract.BusquedasEntry.TABLA_BUSQUEDA, null,values);
        if (idResultante == -1)
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();

        //sqLiteDatabase.close();
    }
}