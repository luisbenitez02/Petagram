package com.example.luisb.petagram;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFav();//llamo el metodo del botoncito flotante
    }

    public void agregarFav(){
        FloatingActionButton miFav = (FloatingActionButton) findViewById(R.id.Myfav);

        //vamos a crear una accion al tocarlo
        miFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui escribe lo que quieres que se haga al presionar el boton
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();

                //LENGTH_SHORT = duracion corta
                //LENGTH_LONG = duracion larga

                Snackbar.make(v,getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG).setAction(getResources().getString(R.string.text_action), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("SNACKBAR","Clik en Snackbar");
                    }
                }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();
            }
        });
    }
}

