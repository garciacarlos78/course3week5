package com.cgrdev.petagram.database;

import android.content.Context;

import com.cgrdev.petagram.R;
import com.cgrdev.petagram.activity.MainActivity;
import com.cgrdev.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;

    public ConstructorMascotas (Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(1, R.drawable.dog_3,"Tobías"));
        mascotas.add(new Mascota(2, R.drawable.dog_2,"Jeremías"));
        mascotas.add(new Mascota(3, R.drawable.dog_gimp,"Gimpy"));
        mascotas.add(new Mascota(4, R.drawable.beaver_1,"Alvin"));
        mascotas.add(new Mascota(5, R.drawable.ghost_1,"Casper"));
        mascotas.add(new Mascota(6, R.drawable.husky,"Jasqui"));
        mascotas.add(new Mascota(7, R.drawable.fox,"Foxy"));
        mascotas.add(new Mascota(8, R.drawable.owl,"Buhy"));

        // Inicializamos los ratings con los valores que haya en la BBDD
        Database db = MainActivity.getDatabase();
        for (Mascota mascota : mascotas) {

            mascota.setRating(db.getRating(mascota.getId()));

        }

        return mascotas;
    }
}
