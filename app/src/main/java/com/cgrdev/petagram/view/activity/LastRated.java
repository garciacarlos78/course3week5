package com.cgrdev.petagram.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.cgrdev.petagram.R;
import com.cgrdev.petagram.adapter.MascotaAdaptador;
import com.cgrdev.petagram.model.Database;
import com.cgrdev.petagram.pojo.Mascota;
import com.cgrdev.petagram.presenter.RecyclerViewLastRatedPresenter;

import java.util.ArrayList;

public class LastRated extends AppCompatActivity implements LastRatedInterface {

    private RecyclerView rvMascotasFavoritas;
    private RecyclerViewLastRatedPresenter presenter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_rated);

        toolbar = findViewById(R.id.toolbarLastRated);
        if (toolbar != null) setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotasFavoritas = findViewById(R.id.rvMascotasFavoritas);

        presenter = new RecyclerViewLastRatedPresenter(this, getBaseContext());

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFavoritas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(new Database(this).getRated(), false);
        return mascotaAdaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotasFavoritas.setAdapter(adaptador);
    }
}
