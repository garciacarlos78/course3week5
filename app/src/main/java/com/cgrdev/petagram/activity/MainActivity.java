package com.cgrdev.petagram.activity;

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
import com.cgrdev.petagram.database.ConstructorMascotas;
import com.cgrdev.petagram.database.ConstructorMiMascota;
import com.cgrdev.petagram.database.Database;
import com.cgrdev.petagram.database.DatabaseInterface;
import com.cgrdev.petagram.fragment.MyPetFragment;
import com.cgrdev.petagram.fragment.MainFragment;
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
    static {
        Log.d("Mascotas: ", "MainActivity: static.");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Mascotas: ", "MainActivity: onCreate.");
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

        // Testeo de BBDD sin primary key, utilizando ROWID
        //testingBBDD();


    }

    private void testingBBDD() {

        // Generamos 10 mascotas al azahar
        ArrayList<Mascota> mascotas = giveMe10Random();

        // Ingresamos las 5 primeras en la BBDD
        DatabaseInterface dbi = new Database(this);
        for (int i=0; i<5; i++){
            dbi.insert(mascotas.get(i));
        }

        // Las recogemos y comprobamos en qué orden se devuelven
        Log.d("Petagram: ", "Primera devolución tras la inserción de 0 a 4.");
        ArrayList<Mascota> mascotasReturn = dbi.getRated();
        for (Mascota mascota: mascotasReturn) {
            Log.d("Petagram: ", "Mascota: " + mascota.toString());
        }

        // Agregamos otra con id superior a todas y volvemos a comprobar en qué orden se devuelven
        Log.d("Petagram: ", "\nDevolución tras la inserción de id 7.");
        dbi.insert(mascotas.get(7));
        mascotasReturn = dbi.getRated();
        for (Mascota mascota: mascotasReturn) {
            Log.d("Petagram: ", "Mascota: " + mascota.toString());
        }

        // Agregamos otra con id inferior y volvemos a comprobar
        Log.d("Petagram: ", "\nDevolución tras la inserción de id 2.");
        dbi.insert(mascotas.get(2));
        mascotasReturn = dbi.getRated();
        for (Mascota mascota: mascotasReturn) {
            Log.d("Petagram: ", "Mascota: " + mascota.toString());
        }

        Log.d("Petagram: ", "\nDevolución tras la inserción de id 4.");
        dbi.insert(mascotas.get(4));
        mascotasReturn = dbi.getRated();
        for (Mascota mascota: mascotasReturn) {
            Log.d("Petagram: ", "Mascota: " + mascota.toString());
        }
    }

    private ArrayList<Mascota> giveMe10Random() {

        ArrayList<Mascota> mascotas = new ArrayList<>();

        for (int i=0; i<10; i++) {
            Mascota mascota = new Mascota(i, i+1, "Mascota_" + i);
            mascotas.add(mascota);
        }
        return mascotas;
    }

    private ArrayList<Fragment> agregarFragments() {
        Log.d("Mascotas: ", "MainActivity: agregarFragments");
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new MainFragment());
        fragments.add(new MyPetFragment());
        return fragments;
    }

    private void setupViewPager () {
        Log.d("Mascotas: ", "MainActivity: setupViewPager");
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_icon);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        Log.d("Mascotas: ", "MainActivity: onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        Log.d("Mascotas: ", "MainActivity: onOptionsItemSelected");

        int id = item.getItemId();

        // Switch para controlar el menú presionado
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
    public void generarLinearLayoutVertical() {
        Log.d("Mascotas: ", "MainActivity: generarLinearLayoutVertical");
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

    @Override
    public void inicializarMascotas() {
        Log.d("Mascotas: ", "MainActivity: inicializarMascotaas.");

    }
}
