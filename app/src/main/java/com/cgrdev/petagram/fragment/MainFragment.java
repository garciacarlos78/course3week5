package com.cgrdev.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cgrdev.petagram.activity.MainActivity;
import com.cgrdev.petagram.R;
import com.cgrdev.petagram.adapter.MascotaAdaptador;
import com.cgrdev.petagram.pojo.Mascota;
import com.cgrdev.petagram.presenter.RecyclerViewMainFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainFragmentInterface {

    private RecyclerView listaMascotas;
    private RecyclerViewMainFragmentPresenter presenter;
    static {
        Log.d("Mascotas: ", "MainFragment: static.");
    }

    public MainFragment() {
        // Required empty public constructor
        Log.d("Mascotas: ", "MainFragment: constructor");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Mascotas: ", "MainFragment: onCreateView");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        listaMascotas = v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewMainFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        Log.d("Mascotas: ", "MainFragment: generarLinearLayoutVertical");
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        Log.d("Mascotas: ", "MainFragment: crearAdaptador");
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas, true);
        return mascotaAdaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        Log.d("Mascotas: ", "MainFragment: inicializarAdaptadorRV");
        listaMascotas.setAdapter(adaptador);
    }
}
