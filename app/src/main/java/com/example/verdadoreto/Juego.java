package com.example.verdadoreto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Juego extends AppCompatActivity {
    String modoJuego="";
    ArrayList<String> jugadoresLista = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        jugadoresLista = (ArrayList<String>) getIntent().getStringArrayListExtra("jugadoresList");
    }

    public void categoria(View view) {

        switch (view.getId()){
            case R.id.amigos:
                modoJuego="amigos";
                Intent preguntas = new Intent(Juego.this,preguntas.class);
                preguntas.putStringArrayListExtra("jugadoresList", jugadoresLista);
                preguntas.putExtra("modoJuego",modoJuego);
                startActivity(preguntas);
                break;

            case R.id.picante:
                modoJuego="picante";
                Intent preguntas2 = new Intent(Juego.this,preguntas.class);
                preguntas2.putStringArrayListExtra("jugadoresList", jugadoresLista);
                preguntas2.putExtra("modoJuego",modoJuego);
                startActivity(preguntas2);
                break;
        }
    }
}