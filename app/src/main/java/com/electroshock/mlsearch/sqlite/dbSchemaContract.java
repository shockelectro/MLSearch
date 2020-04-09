package com.electroshock.mlsearch.sqlite;

import android.provider.BaseColumns;

public class dbSchemaContract implements BaseColumns {

/*  ======================================
        TABLA USUARIO
    ======================================
*/
    public static abstract class UsuarioEntry implements BaseColumns {
        //Constantes campos tabla usuario
        public static final String TABLA_USUARIO="usuario";
        public static final String CAMPO_ID="id";
        public static final String NOMBRE ="nombre";
        public static final String TELEFONO ="telefono";
    }

    public static final String CREAR_TABLA_USUARIO=
            "CREATE TABLE " + UsuarioEntry.TABLA_USUARIO +" (" +
                    UsuarioEntry.CAMPO_ID + " " + "INTEGER, " +
                    UsuarioEntry.NOMBRE +" TEXT," +
                    UsuarioEntry.TELEFONO +" TEXT )";

    public static final String BORRAR_TABLA_USUARIO=
            "DROP TABLE IF EXISTS " + UsuarioEntry.TABLA_USUARIO;

/*  ===============================================================================================
        TABLA LISTADO ITEMS
    ===============================================================================================
*/
    public static abstract class ListadoItemsEntry implements BaseColumns {
        //Constantes campos tabla items
        public static final String TABLA_ITEMS = "item";
        public static final String COLUM_ID_ITEM = "id_item";
        public static final String COLUM_ITEM_NOMBRE = "nombre_item";
        public static final String COLUM_ID_PRECIOS = "id_precios";
    }

    public static final String CREAR_TABLA_ITEMS =
            "CREATE TABLE " + ListadoItemsEntry.TABLA_ITEMS + " (" +
                    ListadoItemsEntry.COLUM_ID_ITEM +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ListadoItemsEntry.COLUM_ITEM_NOMBRE + " TEXT, " +
                    ListadoItemsEntry.COLUM_ID_PRECIOS + " INTEGER)";

    public static final String BORRAR_TABLA_ITEMS=
            "DROP TABLE IF EXISTS " + ListadoItemsEntry.TABLA_ITEMS;

    /*  ============================================================================================
            TABLA PRECIOS HISTORICOS
        ============================================================================================
    */
    public static abstract class PreciosHistoricosEntry implements BaseColumns {
        //Constantes campos tabla items PRECIOS
        // PK idtem + date
        public static final String TABLA_ITEM_PRECIOS = "precios";
        public static final String COLUM_ID_ITEM = "id_item";
        public static final String COLUM_PRECIO_DATE = "precio_date";
        public static final String COLUM_PRECIO = "precio_valor";
    }

    public static final String CREAR_TABLA_ITEM_PRECIOS =
            "CREATE TABLE " +  PreciosHistoricosEntry.TABLA_ITEM_PRECIOS +" ("
                    + PreciosHistoricosEntry.COLUM_ID_ITEM + " INTEGER NOT NULL, "
                    + PreciosHistoricosEntry.COLUM_PRECIO_DATE + " DATE NOT NULL, "
                    + PreciosHistoricosEntry.COLUM_PRECIO + " FLOAT, "
                    + "PRIMARY KEY (" + PreciosHistoricosEntry.COLUM_ID_ITEM + "," + PreciosHistoricosEntry.COLUM_PRECIO_DATE + "))";

    public static final String BORRAR_TABLA_ITEMS_PRECIOS=
            "DROP TABLE IF EXISTS " + PreciosHistoricosEntry.TABLA_ITEM_PRECIOS;

    /*  ============================================================================================
            TABLA BUSQUEDA
        ============================================================================================
    */
    public static abstract class BusquedasEntry implements BaseColumns {
        //Constantes campos tabla busqueda
        public static final String TABLA_BUSQUEDA = "busqueda";
        public static final String COLUM_ID_BUSQUEDA = "id_busqueda";
        public static final String COLUM_CATEGORIA = "categoria";
        public static final String COLUM_QUERY = "query";
        public static final String COLUM_PRECIO_MIN = "precio_min";
        public static final String COLUM_PRECIO_MAX = "precio_max";
        public static final String COLUM_ESTADO = "item_estado";
    }

    public static final String CREAR_TABLA_BUSQUEDA =
            "CREATE TABLE " +  BusquedasEntry.TABLA_BUSQUEDA + " (" +
                    BusquedasEntry.COLUM_ID_BUSQUEDA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    BusquedasEntry.COLUM_CATEGORIA + " TEXT, " +
                    BusquedasEntry.COLUM_QUERY + " TEXT, " +
                    BusquedasEntry.COLUM_PRECIO_MIN + " INTEGER," +
                    BusquedasEntry.COLUM_PRECIO_MAX + " INTEGER," +
                    BusquedasEntry.COLUM_ESTADO + " TEXT)";

    public static final String BORRAR_TABLA_BUSQUEDA=
            "DROP TABLE IF EXISTS " + BusquedasEntry.TABLA_BUSQUEDA;

 /*  ============================================================================================
        TABLA ITEM
     ============================================================================================
*/
    public static abstract class ItemEntry implements BaseColumns {
        public static final String TABLE_NAME ="item";
        public static final String ID = "id";
        public static final String TITTLE = "tittle";
        public static final String STATUS = "status";
        public static final String SELLER_ID = "seller_id";
        public static final String CATEGORY_ID = "category_id";
        public static final String START_TIME = "start_time";
        public static final String STOP_TIME = "stop_time";
        public static final String LAST_UPDATE = "last_update";
        public static final String DATE_CREATED = "date_created";
        public static final String GEOLAT = "geolat";
        public static final String GEOLON = "geolon";
        public static final String PRECIOS = "prices";
    }

    public static final String CREAR_TABLA_ITEM =
            "CREATE TABLE " + ItemEntry.TABLE_NAME + " ("
                    + ItemEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + ItemEntry.ID + " TEXT NOT NULL,"
                    + ItemEntry.TITTLE + " TEXT NOT NULL,"
                    + ItemEntry.STATUS + " TEXT,"
                    + ItemEntry.SELLER_ID + " INT,"
                    + ItemEntry.CATEGORY_ID + " TEXT NOT NULL,"
                    + ItemEntry.START_TIME + " DATETIME,"
                    + ItemEntry.STOP_TIME + " DATETIME,"
                    + ItemEntry.LAST_UPDATE + " DATETIME,"
                    + ItemEntry.DATE_CREATED + " DATETIME,"
                    + ItemEntry.GEOLAT + " POINT,"
                    + ItemEntry.GEOLON + " POINT,"
                    + ItemEntry.PRECIOS + " TEXT,"
                    + "UNIQUE (" + ItemEntry.ID + "))";

    public static final String BORRAR_TABLA_ITEM=
            "DROP TABLE IF EXISTS " + ItemEntry.TABLE_NAME;

    /*  ============================================================================================
        TABLA ALERTA
        ============================================================================================
    */
    private static abstract class AlertaEntry implements BaseColumns {
        public static final String TABLE_NAME ="alerta";

        public static final String _ID = "_id";
        public static final String ID = "id";
        public static final String TITTLE = "tittle";
        public static final String CATEGORY_ID = "category_id";
        public static final String STATUS = "status";
        public static final String START_TIME = "start_time";
        public static final String STOP_TIME = "stop_time";
        public static final String DATE_CREATED = "date_created";
        public static final String PRECIO_INF = "precio_inf";
        public static final String PRECIO_SUP = "precio_sup";
    }

    public static final String CREAR_TABLA_ALERTA =
            "CREATE TABLE " + AlertaEntry.TABLE_NAME + " ("
                    + AlertaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + AlertaEntry.TITTLE + " TEXT NOT NULL,"
                    + AlertaEntry.STATUS + " TEXT,"
                    + AlertaEntry.CATEGORY_ID + " TEXT NOT NULL,"
                    + AlertaEntry.START_TIME + " DATETIME,"
                    + AlertaEntry.STOP_TIME + " DATETIME,"
                    + AlertaEntry.DATE_CREATED + " DATETIME,"
                    + AlertaEntry.PRECIO_INF + " INTEGER,"
                    + AlertaEntry.PRECIO_SUP + " INTEGER,"
                    + "UNIQUE (" + AlertaEntry._ID + "))";

    public static final String BORRAR_TABLA_ALERTA=
            "DROP TABLE IF EXISTS " + AlertaEntry.TABLE_NAME;
}
