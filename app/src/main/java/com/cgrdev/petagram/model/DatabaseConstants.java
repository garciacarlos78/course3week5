package com.cgrdev.petagram.model;

public final class DatabaseConstants {

    public static final String DATABASE_NAME = "petagram";
    public static final int DATABASE_VERSION = 1;

    // Añadimos la columna "date" para poder determinar el orden de rateados
    public static final String TABLE_MASCOTA = "mascota";
    public static final String COL_0 = "id";
    public static final String COL_1 = "pictureId";
    public static final String COL_2 = "name";
    public static final String COL_3 = "rating";
}