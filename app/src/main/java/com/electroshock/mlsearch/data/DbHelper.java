package com.electroshock.mlsearch.data;
/**
 * Controlador de la bd
 * -->> onCreate() se ejecuta solo una vez, cuando el archivo .db no está creado
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.electroshock.mlsearch.data.ItemContract.ItemEntry;
import com.electroshock.mlsearch.sqlite.dbSchemaContract;


public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "itemsMA7.db";
    //protected static SQLiteDatabase bdAlertas;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Este metodo se ejecuta por unica vez
        db.execSQL(dbSchemaContract.CREAR_TABLA_ITEM);
        db.execSQL(dbSchemaContract.CREAR_TABLA_VENDEDOR);
        db.execSQL(dbSchemaContract.CREAR_TABLA_ALERTA);

        // TInsertar datos ficticios para prueba inicial
        mockItem(db);
        mockAlertas(db);
        mockVendedor(db);
    }



    private void mockItem(SQLiteDatabase sqLiteDatabase) {
        mockItem(sqLiteDatabase, new Item("7658765", "Toshiba n55",
                "12000", "used", "9873241","MLA399858","2018-09-18T03:25:36.000Z","2018-09-25T03:25:36.000Z",
                "2018-09-18T03:25:36.000Z", "2018-09-24T21:17:52.548Z",
                "-34.91102","-57.958046"));
        mockItem(sqLiteDatabase, new Item("5475745", "Lenovo y70",
                "18000", "used", "9873241","MLA453218","2018-09-18T03:25:36.000Z","2018-09-25T03:25:36.000Z",
                "2018-09-18T03:25:36.000Z", "2018-09-24T21:17:52.548Z",
                "-34.91102","-57.958046"));
      /*  mockItem(sqLiteDatabase, new Item("5673456", "Asus",
                "12000", "used", "9873241","MLA985632","2018-09-18T03:25:36.000Z","2018-09-25T03:25:36.000Z",
                "2018-09-18T03:25:36.000Z", "2018-09-24T21:17:52.548Z",
                "-34.91102","-57.958046")); */
    }

    private void mockAlertas(SQLiteDatabase sqLiteDatabase) {
        mockAlerta(sqLiteDatabase, new Alerta("i7","MLA399858", "nuevo","1000","20000"));
        mockAlerta(sqLiteDatabase, new Alerta("i3","MLA098234","usado", "40","10000"));
        mockAlerta(sqLiteDatabase, new Alerta("i5","MLA923842","usado", "0","10000"));
    }

    private void mockVendedor(SQLiteDatabase sqLiteDatabase) {
        mockVendedor(sqLiteDatabase, new Vendedor("0","pedro","4444-5896","Lanus"));
        mockVendedor(sqLiteDatabase, new Vendedor("1","alejandro","4362-5226","Avellaneda"));
        mockVendedor(sqLiteDatabase, new Vendedor("2","javier","4208-3265","Lomas de Zamora"));
    }

    private void mockRegistroBusqueda(SQLiteDatabase sqLiteDatabase){

    }

    public long mockVendedor(SQLiteDatabase db, Vendedor vendedor){
        return db.insert(
                dbSchemaContract.VendedorEntry.TABLE_NAME,
                null,
                vendedor.toContentValues());

    }

    public long mockItem(SQLiteDatabase db, Item item) {
        return db.insert(
                dbSchemaContract.ItemEntry.TABLE_NAME,
                null,
                item.toContentValues());
    }

    public long mockAlerta(SQLiteDatabase db, Alerta alerta) {
        return db.insert(
                dbSchemaContract.AlertaEntry.TABLE_NAME,
                null,
                alerta.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }

    public long saveItem(Item item) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                ItemEntry.TABLE_NAME,
                null,
                item.toContentValues());
    }

    public long saveAlerta(Alerta alerta) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                dbSchemaContract.AlertaEntry.TABLE_NAME,
                null,
                alerta.toContentValues());
    }

    public Cursor getAllItems() {
        return getReadableDatabase()
                .query(
                        ItemEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getAllAlertas() {
        return getReadableDatabase()
                .query(
                        dbSchemaContract.AlertaEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getItemById(String itemId) {

        Cursor c = getReadableDatabase().query(
                ItemEntry.TABLE_NAME,
                null,
                ItemEntry.ID + " LIKE ?",
                new String[]{itemId},
                null,
                null,
                null);
        return c;
    }

    public Cursor getAlertaById(String alertaId) {
        SQLiteDatabase db = getReadableDatabase();
        //String[] largs = new String[] {alertaId};
        Cursor c = db.query(
                dbSchemaContract.AlertaEntry.TABLE_NAME,
                null,
                dbSchemaContract.AlertaEntry._ID + " =?" ,
                new String[] {alertaId},
                null,
                null,
                null);
        return c;
    }

    public int deleteItem(String itemId) {
        return getWritableDatabase().delete(
                ItemEntry.TABLE_NAME,
                ItemEntry.ID + " LIKE ?",
                new String[]{itemId});
    }

    public int deleteAlerta(String alertaId) {
        return getWritableDatabase().delete(
                dbSchemaContract.AlertaEntry.TABLE_NAME,
                dbSchemaContract.AlertaEntry._ID + " LIKE ?",
                new String[]{alertaId});
    }

    public int deleteVendedor(String vendedorId) {
        return getWritableDatabase().delete(
                dbSchemaContract.VendedorEntry.TABLE_NAME,
                dbSchemaContract.VendedorEntry._ID + " LIKE ?",
                new String[]{vendedorId});
    }

    public int updateItem(Item item, String itemId) {
        return getWritableDatabase().update(
                ItemEntry.TABLE_NAME,
                item.toContentValues(),
                ItemEntry.ID + " LIKE ?",
                new String[]{itemId}
        );
    }
    public int updateAlerta(Alerta alerta, String alertaId) {
        return getWritableDatabase().update(
                dbSchemaContract.AlertaEntry.TABLE_NAME,
                alerta.toContentValues(),
                dbSchemaContract.AlertaEntry._ID + " LIKE ?",
                new String[]{alertaId}
        );
    }
}
