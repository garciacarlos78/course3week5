package com.cgrdev.petagram.database;

import com.cgrdev.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface DatabaseInterface {

    public ArrayList<Mascota> getRated();

    public void insert(Mascota mascota);

    public int getRating (int idMascota);

    ArrayList<Mascota> getRatedRowid();

    void insertRowid(Mascota mascota);

    int getRatingRowid(int id);
}
