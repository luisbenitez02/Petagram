package com.example.luisb.petagram;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMiLista;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFav();//llamo el metodo del botoncito flotante

        //creamos el objeto (lo referenciamos)
        sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);

        lstMiLista = (ListView) findViewById(R.id.lstMiLista);

        //le pasamos la lista de planetas definida
        String[] planetas = getResources().getStringArray(R.array.planetas);

        //se lo pasamos al adaptador
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        //simple_list_item_1 se refeire al tipo de layout, o sea una sola linea
        //un list view sencillo

        //setOnRefreshListener(): cuando se haga gesto de refrescar, estara escuchando
        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
    }

    //Este metodo refrescara el contenido del list view
    public void refreshContent(){
        String[] planetas = getResources().getStringArray(R.array.planetas);

        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));

        sfiMiIndicadorRefresh.setRefreshing(false);//indica que ya se refresco la vuelta
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

