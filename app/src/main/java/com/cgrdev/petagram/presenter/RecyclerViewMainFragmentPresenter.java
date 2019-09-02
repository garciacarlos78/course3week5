package com.cgrdev.petagram.presenter;

import android.content.Context;

import com.cgrdev.petagram.view.activity.MainActivity;
import com.cgrdev.petagram.view.fragment.MainFragmentInterface;
import com.cgrdev.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewMainFragmentPresenter implements RecyclerViewMainFragmentPresenterInterface {

    private MainFragmentInterface mainFragmentInterface;
    private Context context;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewMainFragmentPresenter(MainFragmentInterface mainFragmentInterface, Context context) {

        this.mainFragmentInterface = mainFragmentInterface;
        this.context = context;
        obtenerMascotasBBDD();
    }


    @Override
    public void obtenerMascotasBBDD() {

        mascotas = MainActivity.getMascotas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {

        mainFragmentInterface.inicializarAdaptadorRV(mainFragmentInterface.crearAdaptador(mascotas));
        mainFragmentInterface.generarLinearLayoutVertical();
    }
}
