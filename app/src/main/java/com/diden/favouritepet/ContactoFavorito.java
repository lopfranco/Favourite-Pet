package com.diden.favouritepet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactoFavorito extends AppCompatActivity {

    RecyclerView rvFavoritos;
    ArrayList<Contacto> contactosFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_favorito);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.ic_pets);

        rvFavoritos = (RecyclerView) findViewById(R.id.rvFavoritos);

        LinearLayoutManager llmf = new LinearLayoutManager(this);
        llmf.setOrientation(LinearLayoutManager.VERTICAL);

        rvFavoritos.setLayoutManager(llmf);


        inicioListado();
        inicializarAdaptador();
    }

    public void inicioListado(){
        contactosFav = new ArrayList<Contacto>();

        contactosFav.add(new Contacto(R.drawable.mascota5,"Perrito 5","7654312098","perrito5@email.com"));
        contactosFav.add(new Contacto(R.drawable.mascota1,"Perrito 1","1234567890","perrito1@email.com"));
        contactosFav.add(new Contacto(R.drawable.mascota3,"Perrito 3","6789054321","perrito3@email.com"));
        contactosFav.add(new Contacto(R.drawable.mascota6,"Perrito 6","7890654312","perrito6@email.com"));
        contactosFav.add(new Contacto(R.drawable.mascota4,"Perrito 4","0987612345","perrito4@email.com"));
        contactosFav.add(new Contacto(R.drawable.mascota2,"Perrito 2","0987654321","perrito2@email.com"));

    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactosFav, this);
        rvFavoritos.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}
