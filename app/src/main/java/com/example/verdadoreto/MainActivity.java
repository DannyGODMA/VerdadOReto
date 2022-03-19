package com.example.verdadoreto;

import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nombre, titulo;
    Button agregarJugador1, empezar;
    ListView muestraNombres;
    ArrayList<String> lista = new ArrayList<String>();
    ArrayAdapter<String> adapatador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo =findViewById(R.id.titulo);
        nombre = findViewById(R.id.nombreJugador);
        muestraNombres = findViewById(R.id.mostrar);
        agregarJugador1= findViewById(R.id.agregarJugador);
        empezar= findViewById(R.id.empezar);
        titulo.setEnabled(false);
        seleccionJugador();

    }

    public void agregarJugador(View view) {


        if(lista.size()>9){
            Toast.makeText(this, "No puede haber más de 10 jugadores", Toast.LENGTH_LONG).show();
            agregarJugador1.setEnabled(false);

        }else{
            switch (view.getId()){
                case R.id.agregarJugador: String texto = nombre.getText().toString().trim();

                    lista.add(texto);

                    nombre.setText("");
                    //nombre.getText().clear();
                    adapatador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
                    muestraNombres.setAdapter(adapatador);
                    //Toast.makeText(this, "s"+lista.size(), Toast.LENGTH_LONG).show();
            }
        }
    }

    public void seleccionJugador(){
        muestraNombres.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> ListView, View view, int posicion, long l) {
                lista.remove(posicion);
                adapatador.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void validar(){

        if(lista.size()>1){
            for (int i=0; i<lista.size(); i++){
                if(!lista.get(i).equals("")){
                    Intent ventana2 = new Intent(MainActivity.this, Juego.class);
                    ventana2.putStringArrayListExtra("jugadoresList", lista);
                    startActivity(ventana2);
                }else{
                    Toast.makeText(this, "No puede haber nombres en blanco", Toast.LENGTH_SHORT).show();
                    break;

                }
            }

        }else{
            Toast.makeText(this, "Debe haber al menos dos jugadores", Toast.LENGTH_LONG).show();

        }

    }

    public void empezarJuego(View view) {
        validar();

        }

    }



