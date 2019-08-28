package com.cgrdev.petagram.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.cgrdev.petagram.pojo.Mascota;

import java.util.ArrayList;
import java.util.Date;

public class Database extends SQLiteOpenHelper implements DatabaseInterface {

    private Context context;

    public Database(Context context) {
        super(context, DatabaseConstants.DATABASE_NAME, null, DatabaseConstants.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /*String queryCreatePetTable = "CREATE TABLE " + DatabaseConstants.TABLE_RATED_PETS + "("
                + DatabaseConstants.COL_0 + " INTEGER PRIMARY KEY, "
                + DatabaseConstants.COL_1 + " INTEGER, "
                + DatabaseConstants.COL_2 + " TEXT, "
                + DatabaseConstants.COL_3 + " INTEGER, "
                + DatabaseConstants.COL_4 + " INTEGER"
                + ")";*/

        // Creamos tabla mascota con idéntidos atributos a pojo Mascota
        String queryCreatePetTable = "CREATE TABLE " + DatabaseConstants.TABLE_MASCOTA + "("
                + DatabaseConstants.COL_0 + " INTEGER, "
                + DatabaseConstants.COL_1 + " INTEGER, "
                + DatabaseConstants.COL_2 + " TEXT, "
                + DatabaseConstants.COL_3 + " INTEGER"
                + ")";

        db.execSQL(queryCreatePetTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_RATED_PETS);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_MASCOTA);
        onCreate(db);
    }

    @Override
    public ArrayList<Mascota> getRated() {

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + DatabaseConstants.TABLE_MASCOTA + " ORDER BY ROWID DESC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        // En caso de que haya más de 5 rateados cogemos únicamente los 5 últimos
        for (int i = 0; i < 5 && registros.moveToNext(); i++) {

            int id = registros.getInt(registros.getColumnIndex(DatabaseConstants.COL_0));
            int pictureId = registros.getInt(registros.getColumnIndex(DatabaseConstants.COL_1));
            String name = registros.getString(registros.getColumnIndex(DatabaseConstants.COL_2));
            int rate = registros.getInt(registros.getColumnIndex(DatabaseConstants.COL_3));

            Mascota mascota = new Mascota(id, pictureId, name);
            mascota.setRating(rate);

            mascotas.add(mascota);
        }

        db.close();

        return mascotas;
    }

    @Override
    public void insert(Mascota mascota) {

        SQLiteDatabase db = this.getWritableDatabase();

        // Si la mascota ya estaba en la tabla, la borramos para añadirla con el nuevo datestamp
        db.delete(DatabaseConstants.TABLE_MASCOTA, DatabaseConstants.COL_0 + "=?", new String[]{String.valueOf(mascota.getId())});

        // Creamos el ContentValues para insertar la mascota
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseConstants.COL_0, mascota.getId());
        contentValues.put(DatabaseConstants.COL_1, mascota.getPictureId());
        contentValues.put(DatabaseConstants.COL_2, mascota.getName());
        contentValues.put(DatabaseConstants.COL_3, mascota.getRating());

        // Hacemos la inserción
        db.insert(DatabaseConstants.TABLE_MASCOTA, null, contentValues);

        db.close();
    }

    @Override
    public int getRating(int idMascota) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DatabaseConstants.TABLE_MASCOTA, new String[]{DatabaseConstants.COL_3},
                DatabaseConstants.COL_0 + " = ?", new String[]{String.valueOf(idMascota)}, null, null, null);

        if (cursor.getCount() == 0) {
            db.close();
            return 0;
        }

        cursor.moveToFirst();

        int rating = cursor.getInt(0);

        db.close();

        return rating;

    }

}

