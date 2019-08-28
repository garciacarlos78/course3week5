package com.cgrdev.petagram.fragment;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cgrdev.petagram.R;
import com.cgrdev.petagram.activity.MainActivity;
import com.cgrdev.petagram.adapter.MiMascotaAdapter;
import com.cgrdev.petagram.database.ConstructorMiMascota;
import com.cgrdev.petagram.pojo.RatedPicture;
import com.cgrdev.petagram.presenter.RecyclerViewMyPetFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyPetFragment extends Fragment implements MyPetFragmentInterface {

    private RecyclerView rvMiMascota;
    private RecyclerViewMyPetFragmentPresenter presenter;
    private ArrayList<RatedPicture> ratedPictures;

    public MyPetFragment() {
        // Required empty public constructor
    }


/*
    public void setMascotasRated(ArrayList<RatedPicture> mascotasRated) {
        this.mascotasRated = mascotasRated;
    }
*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_pet, container, false);

        rvMiMascota = v.findViewById(R.id.rvMyPet);
        presenter = new RecyclerViewMyPetFragmentPresenter(this, getContext());
        ratedPictures = MainActivity.getRatedPictures();
        return v;
    }

/*
    private void inicializaAdaptador() {

        MiMascotaAdapter miMascotaAdapter = new MiMascotaAdapter(mascotasRated);
        rvMiMascota.setAdapter(miMascotaAdapter);
    }
*/

    @Override
    public void generateGridLayout() {

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvMiMascota.setLayoutManager(glm);

    }

    @Override
    public MiMascotaAdapter crearAdaptador(ArrayList<RatedPicture> ratedPictures) {
        //MiMascotaAdapter mascotaAdapter = new MiMascotaAdapter(new ConstructorMiMascota(getContext()).obtenerMiMascota().getRatedPictures());
        MiMascotaAdapter mascotaAdapter = new MiMascotaAdapter(ratedPictures);
        return mascotaAdapter;
    }

    @Override
    public void inicializarAdaptadorRV(MiMascotaAdapter adapter) {
        rvMiMascota.setAdapter(adapter);
    }
}
