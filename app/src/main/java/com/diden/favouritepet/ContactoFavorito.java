package com.diden.favouritepet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactoFavorito extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    RecyclerView listaContactos;

    ImageView imgFotoFav;
    TextView tvNombreFav;
    TextView tvTelefonoFav;
    TextView tvEmailFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_favorito);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setLogo(R.drawable.ic_pets);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);



        Bundle parametros = getIntent().getExtras();

        int foto = parametros.getInt("foto");
        String nombre = parametros.getString("perrito");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");

        imgFotoFav = (ImageView) findViewById(R.id.imgFotoFavorito);
        tvNombreFav = (TextView) findViewById(R.id.tvNombreFavorito);
        tvTelefonoFav = (TextView) findViewById(R.id.tvTelefonoFavorito);
        tvEmailFav = (TextView) findViewById(R.id.tvEmailFavorito);

        imgFotoFav.setImageResource(foto);
        tvNombreFav.setText(nombre);
        tvTelefonoFav.setText(telefono);
        tvEmailFav.setText(email);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

    }


    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.mascota1,"Perrito 1","1234567890","perrito1@email.com"));
        contactos.add(new Contacto(R.drawable.mascota2,"Perrito 2","0987654321","perrito2@email.com"));
        contactos.add(new Contacto(R.drawable.mascota3,"Perrito 3","6789054321","perrito3@email.com"));
        contactos.add(new Contacto(R.drawable.mascota4,"Perrito 4","0987612345","perrito4@email.com"));
        contactos.add(new Contacto(R.drawable.mascota5,"Perrito 5","7654312098","perrito5@email.com"));
        contactos.add(new Contacto(R.drawable.mascota6,"Perrito 6","7890654312","perrito6@email.com"));

    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }
}
