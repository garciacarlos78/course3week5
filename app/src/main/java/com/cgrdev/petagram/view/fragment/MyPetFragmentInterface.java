package com.cgrdev.petagram.view.fragment;

import com.cgrdev.petagram.adapter.MiMascotaAdapter;
import com.cgrdev.petagram.pojo.RatedPicture;

import java.util.ArrayList;

public interface MyPetFragmentInterface {

    void generateGridLayout();

    MiMascotaAdapter crearAdaptador(ArrayList<RatedPicture> ratedPictures);

    void inicializarAdaptadorRV(MiMascotaAdapter adapter);

}
