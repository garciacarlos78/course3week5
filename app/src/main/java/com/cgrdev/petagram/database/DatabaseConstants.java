package com.cgrdev.petagram.database;

public final class DatabaseConstants {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    // Añadimos la columna "date" para poder determinar el orden de rateados
    public static final String TABLE_RATED_PETS = "ratedPets";
    public static final String COL_0 = "id";
    public static final String COL_1 = "pictureId";
    public static final String COL_2 = "name";
    public static final String COL_3 = "rating";
    public static final String COL_4 = "date";

    public static final String TABLE_PETS = "pets";
    public static final String COL_P0 = "id";
    public static final String COL_P1 = "pictureId";
    public static final String COL_P2 = "name";
    public static final String COL_P3 = "rating";

}