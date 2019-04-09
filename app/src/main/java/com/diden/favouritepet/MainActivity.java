package com.diden.favouritepet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

ArrayList<Contacto> contactos;
RecyclerView listaContactos;
Toolbar miActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setLogo(R.drawable.ic_pets);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        //Vista en vertical
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Vista de cuadricula, definir el numero de columnas al final
        //GridLayoutManager glm = new GridLayoutManager(this,2);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.starMenu:
                Intent intent = new Intent(MainActivity.this, ContactoFavorito.class);
                intent.putExtra("foto", "Foto Perrito");
                intent.putExtra("perrito", "Nombre del Perrito");
                intent.putExtra("telefono", "Telefono del Perrito");
                intent.putExtra("email", "Email del perrito");
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
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

/*<<<<<<< HEAD
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.starMenu:
                Intent intent = new Intent(MainActivity.this, ContactoFavorito.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
=======


>>>>>>> 5f99d38306acf542cbea685dfa9fb95b469ac222*/
}
