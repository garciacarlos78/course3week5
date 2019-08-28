package com.cgrdev.petagram.presenter;

import android.content.Context;
import android.util.Log;

import com.cgrdev.petagram.activity.MainActivity;
import com.cgrdev.petagram.database.ConstructorMiMascota;
import com.cgrdev.petagram.fragment.MyPetFragmentInterface;
import com.cgrdev.petagram.pojo.RatedPicture;

import java.util.ArrayList;

public class RecyclerViewMyPetFragmentPresenter implements RecyclerViewMyPetFragmentPresenterInterface {

    private MyPetFragmentInterface myPetFragmentInterface;
    private Context context;
    private ConstructorMiMascota constructorMiMascota;
    private ArrayList<RatedPicture> ratedPictures;

    public RecyclerViewMyPetFragmentPresenter(MyPetFragmentInterface myPetFragmentInterface, Context context) {
        this.myPetFragmentInterface = myPetFragmentInterface;
        this.context = context;
        obtenerMisMAscotasBBDD();
    }

    @Override
    public void obtenerMisMAscotasBBDD() {
        constructorMiMascota = new ConstructorMiMascota(context);
        ratedPictures = MainActivity.getRatedPictures();
        // ratedPictures = constructorMiMascota.obtenerMiMascota().getRatedPictures();
        mostrarMisMascotasRV();
    }

    @Override
    public void mostrarMisMascotasRV() {
        myPetFragmentInterface.inicializarAdaptadorRV(myPetFragmentInterface.crearAdaptador(ratedPictures));
        myPetFragmentInterface.generateGridLayout();
    }
}
