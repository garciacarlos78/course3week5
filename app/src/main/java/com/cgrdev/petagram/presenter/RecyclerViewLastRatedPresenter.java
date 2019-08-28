package com.cgrdev.petagram.presenter;

import android.content.Context;

import com.cgrdev.petagram.activity.LastRatedInterface;
import com.cgrdev.petagram.database.Database;
import com.cgrdev.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewLastRatedPresenter implements RecyclerViewLastRatedPresenterInterface {

    private LastRatedInterface lastRatedInterface;
    private Context context;
    private Database database;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewLastRatedPresenter (LastRatedInterface lastRatedInterface, Context context) {
        this.lastRatedInterface = lastRatedInterface;
        this.context = context;
        obtenerMascotasBBDD();
    }

    @Override
    public void obtenerMascotasBBDD() {
        database = new Database(context);
        mascotas = database.getRated();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        lastRatedInterface.inicializarAdaptadorRV(lastRatedInterface.crearAdaptador(mascotas));
        lastRatedInterface.generarLinearLayoutVertical();
    }
}
