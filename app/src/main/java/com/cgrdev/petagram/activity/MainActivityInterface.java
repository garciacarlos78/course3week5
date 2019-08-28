package com.cgrdev.petagram.activity;

import com.cgrdev.petagram.adapter.MascotaAdaptador;
import com.cgrdev.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface MainActivityInterface {

    void generarLinearLayoutVertical();

    MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    void inicializarAdaptadorRV(MascotaAdaptador adaptador);

    void inicializarMascotas();
}
