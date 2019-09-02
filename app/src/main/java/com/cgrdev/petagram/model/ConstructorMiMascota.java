package com.cgrdev.petagram.model;

import android.content.Context;
import android.content.res.Resources;

import com.cgrdev.petagram.pojo.MiMascota;
import com.cgrdev.petagram.pojo.RatedPicture;

public class ConstructorMiMascota {

    private Context context;

    public ConstructorMiMascota(Context context) {
        this.context = context;
    }

    public MiMascota obtenerMiMascota() {

        MiMascota miMascota = new MiMascota();

        Resources r = context.getResources();
        for (int i = 2; i <= 10; i++) {
            int randomRate = (int) (Math.random() * 100);
            miMascota.addRatedPicture(new RatedPicture(
                    r.getIdentifier("ghost_" + i, "drawable", "com.cgrdev.petagram"), randomRate));

        }

        return miMascota;

    }
}
