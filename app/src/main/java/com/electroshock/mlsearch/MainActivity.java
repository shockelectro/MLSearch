package com.electroshock.mlsearch;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.electroshock.mlsearch.consulta.ConsultaActivity;
import com.electroshock.mlsearch.data.DbHelper;
import com.electroshock.mlsearch.sqlite.DatabaseAdapter;

import static com.electroshock.mlsearch.R.layout.activity_main;


public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    DatabaseAdapter dba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main); //Error

        //dba = new DatabaseAdapter(getApplicationContext());

        //ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_items",null,1);
        //db=conn.getWritableDatabase();

    }


    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            // TODO btnListaBusquedas completar y revisar
            case R.id.btnListaBusquedas:
                miIntent=new Intent(MainActivity.this,ConsultaActivity.class);
                break;
            case R.id.btnRegistroBusqueda:
                miIntent=new Intent(MainActivity.this,RegistroBusquedaActivity.class);
                break;

                /* TODO Implementar botones de menu principal
            case R.id.btnConsultaIndividual:
                miIntent=new Intent(MainActivity.this,ConsultaActivity.class);
                break;
            case R.id.btnConsultaSpinner:
                miIntent=new Intent(MainActivity.this,ConsultaActivity.class);
                break;
            case R.id.btnConsultaLista:
                miIntent=new Intent(MainActivity.this,ConsultaActivity.class);
                break;
            case R.id.btnConsultaListaMascota:
                miIntent=new Intent(MainActivity.this,ConsultaActivity.class);
                break;
            case R.id.btnConsultaListaPersonasRecycler:
                miIntent=new Intent(MainActivity.this,ConsultaActivity.class);
                break;
                */
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }

    }

    protected void onDestroy() {
        // TODO Auto-generated method stub
        getBaseContext().deleteDatabase(DbHelper.DATABASE_NAME);

        super.onDestroy();

        // Close The Database
        //dba.close();

    }

}
