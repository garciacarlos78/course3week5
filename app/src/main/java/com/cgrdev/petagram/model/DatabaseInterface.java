package com.cgrdev.petagram.model;

import com.cgrdev.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface DatabaseInterface {

    ArrayList<Mascota> getRated();

    void insert (Mascota mascota);

    int getRating (int id);

}
