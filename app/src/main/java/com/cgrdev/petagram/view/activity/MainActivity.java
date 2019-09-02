package com.cgrdev.petagram.view.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.cgrdev.petagram.R;
import com.cgrdev.petagram.adapter.MascotaAdaptador;
import com.cgrdev.petagram.adapter.PageAdapter;
import com.cgrdev.petagram.model.ConstructorMascotas;
import com.cgrdev.petagram.model.ConstructorMiMascota;
import com.cgrdev.petagram.model.Database;
import com.cgrdev.petagram.view.fragment.MyPetFragment;
import com.cgrdev.petagram.view.fragment.MainFragment;
import com.cgrdev.petagram.pojo.Mascota;
import com.cgrdev.petagram.pojo.RatedPicture;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {

    public static ArrayList<Mascota> getMascotas() {
        return mascotas;
    }
    public static Database getDatabase() {return database;}
    public static final ArrayList<RatedPicture> getRatedPictures() {return ratedPictures;}

    private static ArrayList<Mascota> mascotas = null;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static Database database = null;
    private static ArrayList<RatedPicture> ratedPictures = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        if (database == null) database = new Database(this);
        if (ratedPictures == null) ratedPictures = new ConstructorMiMascota(this).obtenerMiMascota().getRatedPictures();
        if (mascotas == null) mascotas = new ConstructorMascotas(this).obtenerDatos();

        setupViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments() {

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new MainFragment());
        fragments.add(new MyPetFragment());
        return fragments;
    }

    private void setupViewPager () {

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_icon);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        int id = item.getItemId();

        // Switch para controlar la opción de menú presionada
        switch (id) {
            case R.id.btFavoritos:
                // Creamos intent
                Intent intent = new Intent(this, LastRated.class);

                // Iniciamos la nueva Activity
                startActivity(new Intent(this, LastRated.class));
                return true;

            case R.id.mContacto:
                startActivity(new Intent(this,Contacto.class));
                break;

            case R.id.mAcercaDe:
                startActivity(new Intent(this,AcercaDe.class));
                break;
        }

        return super.onOptionsItemSelected(item);
     }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {

        Log.d("Mascotas: ", "MainActivity: crearAdaptador");
        return null;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        Log.d("Mascotas: ", "MainActivity: inicializarAdaptadorRV");

    }
}
