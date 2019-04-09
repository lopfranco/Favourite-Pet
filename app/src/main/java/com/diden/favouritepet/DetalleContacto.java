package com.diden.favouritepet;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleContacto extends AppCompatActivity {

    ImageView imgFotoDetalle;
    TextView tvNombreDetalle;
    TextView tvTelefonoDetalle;
    TextView tvEmailDetalle;
    Toolbar miActionBar;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setLogo(R.drawable.ic_pets);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Pone la imagen a un lado del nombre de la pantalla
        //getSupportActionBar().setLogo(R.drawable.ic_star_white);


        Bundle parametros = getIntent().getExtras();

        int foto = parametros.getInt("foto");
        String nombre = parametros.getString("nombre");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");

        imgFotoDetalle = (ImageView) findViewById(R.id.imgFotoDetalle);
        tvNombreDetalle = (TextView) findViewById(R.id.tvNombreDetalle);
        tvTelefonoDetalle = (TextView) findViewById(R.id.tvTelefonoDetalle);
        tvEmailDetalle = (TextView) findViewById(R.id.tvEmailDetalle);

        imgFotoDetalle.setImageResource(foto);
        tvNombreDetalle.setText(nombre);
        tvTelefonoDetalle.setText(telefono);
        tvEmailDetalle.setText(email);

    }

    public void pasarActividad(View v) {
        Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.starMenu:
                Toast.makeText(this,"A donde vas cabron", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}