package com.cgrdev.petagram.view.activity;

import com.cgrdev.petagram.adapter.MascotaAdaptador;
import com.cgrdev.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface MainActivityInterface {

    MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
