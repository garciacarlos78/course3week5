package com.cgrdev.petagram.presenter;

import android.content.Context;
import android.util.Log;

import com.cgrdev.petagram.activity.MainActivity;
import com.cgrdev.petagram.database.ConstructorMascotas;
import com.cgrdev.petagram.fragment.MainFragmentInterface;
import com.cgrdev.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewMainFragmentPresenter implements RecyclerViewMainFragmentPresenterInterface {

    private MainFragmentInterface mainFragmentInterface;
    private Context context;
    private ArrayList<Mascota> mascotas;

    static {
        Log.d("Mascotas: ", "RVMainFragmentPresenter: static");
    }

    public RecyclerViewMainFragmentPresenter(MainFragmentInterface mainFragmentInterface, Context context) {
        Log.d("Mascotas: ", "RVMainFragmentPresenter: constructor");
        this.mainFragmentInterface = mainFragmentInterface;
        this.context = context;
        obtenerMascotasBBDD();
    }


    @Override
    public void obtenerMascotasBBDD() {
        // constructorMascotas = new ConstructorMascotas(context);
        // mascotas = constructorMascotas.obtenerDatos();
        Log.d("Mascotas: ", "RVMainFragmentPresenter: obtenerMascotasBBDD");
        mascotas = MainActivity.getMascotas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        Log.d("Mascotas: ", "RVMainFragmentPresenter: mostrarMascotasRV");
        mainFragmentInterface.inicializarAdaptadorRV(mainFragmentInterface.crearAdaptador(mascotas));
        mainFragmentInterface.generarLinearLayoutVertical();
    }
}
