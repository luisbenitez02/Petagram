package com.example.luisb.petagram;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

            }
        });
    }
}

