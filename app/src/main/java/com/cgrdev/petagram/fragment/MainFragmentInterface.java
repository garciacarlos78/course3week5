package com.cgrdev.petagram.fragment;

import com.cgrdev.petagram.adapter.MascotaAdaptador;
import com.cgrdev.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface MainFragmentInterface {

    void generarLinearLayoutVertical();

    MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
