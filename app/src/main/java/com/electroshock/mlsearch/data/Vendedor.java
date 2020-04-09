package com.electroshock.mlsearch.data;

import android.content.ContentValues;

import com.electroshock.mlsearch.sqlite.dbSchemaContract.VendedorEntry;

public class Vendedor {
    private String id;
    private String nombre;
    private String telefono;
    private String localidad;

    public Vendedor(String id, String nombre, String telefono, String localidad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.localidad = localidad;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(VendedorEntry.ID, id);
        values.put(VendedorEntry.NOMBRE, nombre);
        values.put(VendedorEntry.TELEFONO, telefono);
       //TODO Dice que no existe la columna localidad:  values.put(VendedorEntry.LOCALIDAD, localidad);
        return values;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }


}
