package com.example.verdadoreto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class preguntas extends AppCompatActivity {

    TextView tv_modojuego,tv_turno,tv_accion,tv_oportunidades,tv_cumplio;
    String modo="";
    ArrayList<String> jugadoresLista = new ArrayList<String>();
    Button btn_reto,btn_verdad,btn_siguiente,btn_si,btn_no;

    int j=0;
    int[] oportunidades = new int[9];

    String verdadesAmigos[]={
            "¿Qué es lo mas vergonsozo que haz hecho?",
            "¿Lo mas raro que haz comido?",
            "¿Qué te da miedo?",
            "¿Dónde te irías de vacaciones?",
            "¿Cuál sería tu trabajo soñado?",
            "Si pudieras entrevistar a alguien, ¿quién sería?",
            "¿Tienes algún libro favorito? ¿Cuál es?",
            "¿Qué significado tiene para ti la libertad?",
            "Si dominaras el mundo, ¿qué harías para cambiarlo?",
            "¿Qué superpoder tendrías si pudieras elegir?",
            "Dime cuatro series que más te gusten",
            "¿Mar o montaña?",
            "¿Cuál es el estado de ánimo más desagradable para ti?",
            "Cuando eras pequeño, ¿qué querías ser de mayor?",
            "¿Qué es lo que más deseas en este mundo?"
    };

    String retosAmigos[]={
            "Tomar una cucharada de picante.",
            "Manda un emoji a tu jefe.",
            "Admite cuál es el mayor ridículo que has hecho nunca.",
            "Hazte pasar por otra persona durante las siguientes 2 rondas del juego.",
            "Demuestra un talento oculto que tengas.",
            "Pedirle el número de teléfono a alguien.",
            "Cantarle a alguien una canción romántica a capela. ",
            "Abraza a la primera persona que encuentres.",
            "Grita a los 4 vientos que te has enamorada.",
            "Llamar a un número desconocido y pedir una pizza. Insistir aunque la persona diga que no es una pizzería.",
            "Subir a Facebook una de tus peores selfies",
            "Publicar un estado de WhatsApp vergonzoso",
            "Manda un mensaje solo con emojis, otra persona de tu elección tendrá que decodificarlos.",
            "Grábate cantando una canción vergonzosa que te guste.",
            "Usar un zapato como teléfono"
    };

    String verdadesPicantes[]={
            "¿Cuál es tu mayor secreto?",
            "¿Te han traicionado alguna vez?",
            "¿Has besado a más de una persona el mismo día? ¿Cuántas?",
            "¿Crees que eres atractivo/a?",
            "¿Cuál es tu técnica de seducción?",
            "¿Cuál es la mayor mentira que has contado?",
            "¿Qué parte de tu cuerpo cambiarías?",
            "¿De este grupo, a quién te llevarías a una isla desierta?",
            "¿Cuál fue el sueño más extraño que has tenido?",
            "¿Si pudieras dejar de ver a alguien, a quién elegirías?",
            "¿Quien te cae mejor del grupo?",
            "¿Has empezado un rumor sobre alguien para hacerle daño?",
            "¿Cómo sería tu experiencia sexual perfecta?",
            "¿Con cuántas personas te has acostado?",
            "¿Te gustan los disfraces eróticos?"
    };

    String retosPicantes[]={
            "Pon una foto de alguien en tu foto de whatsapp",
            "Baila de forma erótica por un minuto",
            "Reto de beso con los ojos vendados",
            "Lameer el piso",
            "Dame un masaje por 5 minutos",
            "Te reto a mirarnos de frente por 90 segundos, sin reírte",
            "Te reto a prestarme tu celular por 30 minutos",
            "Quítate 4 prendas que no podrás volver a usar durante el resto del juego.",
            "Tápate los ojos con una venda y adivina qué estoy haciendo.",
            "Llama a algún número desconocido y canta feliz cumpleaños.",
            "Tómate una foto embarazosa y publícala en tus redes sociales.",
            "Cántale una canción a la persona que tienes a tu derecha.",
            "Baila con una canción que el grupo elija.",
            "Baila sin música durante 1 minuto.",
            "Deja que el grupo vea lo que tienes en tu teléfono durante 1 minuto."
    };

    String castigos[]={
            "Darle $100 al jugador de tu derecha",
            "Darle $50 a todos los jugadores",
            "Recibir una cachetada",
            "Amputarse un dedo",
            "Darle $200 al jugador al frente tuyo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        tv_modojuego = findViewById(R.id.tv_modojuego);
        tv_turno = findViewById(R.id.turno);
        tv_accion = findViewById(R.id.tv_accion);
        tv_oportunidades = findViewById(R.id.tv_oportunidades);
        tv_cumplio = findViewById(R.id.tv_cumplio);

        btn_reto = findViewById(R.id.btn_reto);
        btn_siguiente = findViewById(R.id.btn_siguiente);
        btn_verdad = findViewById(R.id.btn_verdad);
        btn_si = findViewById(R.id.btn_si);
        btn_no = findViewById(R.id.btn_no);

        Intent intent = getIntent();
        modo = intent.getStringExtra("modoJuego");

        tv_modojuego.setText("Modo de juego: "+ modo);

        jugadoresLista = (ArrayList<String>) getIntent().getStringArrayListExtra("jugadoresList");

        tv_turno.setText("Turno de: " + jugadoresLista.get(j));

        btn_siguiente.setEnabled(false);
        btn_si.setEnabled(false);
        btn_no.setEnabled(false);

    }
    public void siguienteJugador(View view){

        if (j==jugadoresLista.size()-1)
            j=0;
        else
            j++;

        tv_turno.setText("Turno de: "+jugadoresLista.get(j));
        tv_accion.setText("");
        tv_cumplio.setText("");
        tv_oportunidades.setText("Verdades: "+oportunidades[j]);
        btn_verdad.setEnabled(true);
        btn_reto.setEnabled(true);
        btn_siguiente.setEnabled(false);
        btn_si.setEnabled(false);
        btn_no.setEnabled(false);
    }

    public void preguntas(View view){
        Random r = new Random();

        switch(view.getId()){
            case R.id.btn_verdad:
                if (modo.equals("amigos")) {

                    if (oportunidades[j]>=3){
                        Toast.makeText(this, "Alcanzaste el limite de verdades", Toast.LENGTH_LONG).show();
                    }else {
                        tv_accion.setText(verdadesAmigos[r.nextInt(verdadesAmigos.length)]);
                        oportunidades[j]++;
                        btn_verdad.setEnabled(false);
                        btn_reto.setEnabled(false);
                        btn_siguiente.setEnabled(false);
                        btn_si.setEnabled(true);
                        btn_no.setEnabled(true);
                    }
                    tv_cumplio.setText("¿"+jugadoresLista.get(j)+" Cumplió?");
                    tv_oportunidades.setText("Verdades: "+oportunidades[j]);
                }else{
                    if (oportunidades[j]>=3){
                        Toast.makeText(this, "Alcanzaste el limite de verdades", Toast.LENGTH_LONG).show();
                    }else {
                        tv_accion.setText(verdadesPicantes[r.nextInt(verdadesPicantes.length)]);
                        oportunidades[j]++;
                        btn_verdad.setEnabled(false);
                        btn_reto.setEnabled(false);
                        btn_siguiente.setEnabled(false);
                        btn_si.setEnabled(true);
                        btn_no.setEnabled(true);
                    }
                    tv_cumplio.setText("¿"+jugadoresLista.get(j)+" Cumplió?");
                    tv_oportunidades.setText("Verdades: "+oportunidades[j]);
                }
                break;

            case R.id.btn_reto:
                if (modo.equals("amigos")) {
                    tv_accion.setText(retosAmigos[r.nextInt(retosAmigos.length)]);
                    tv_cumplio.setText("¿" + jugadoresLista.get(j) + " Cumplió?");
                    btn_verdad.setEnabled(false);
                    btn_reto.setEnabled(false);
                    btn_siguiente.setEnabled(false);
                    btn_si.setEnabled(true);
                    btn_no.setEnabled(true);
                }else {
                    tv_accion.setText(retosPicantes[r.nextInt(retosPicantes.length)]);
                    tv_cumplio.setText("¿" + jugadoresLista.get(j) + " Cumplió?");
                    btn_verdad.setEnabled(false);
                    btn_reto.setEnabled(false);
                    btn_siguiente.setEnabled(false);
                    btn_si.setEnabled(true);
                    btn_no.setEnabled(true);
                }
                break;

            case R.id.btn_si:
                    tv_accion.setText("¡"+jugadoresLista.get(j)+" Cumplió!");
                    btn_siguiente.setEnabled(true);
                break;

            case R.id.btn_no:
                    tv_accion.setText(jugadoresLista.get(j)+" Debes cumplir el castigo de: "+castigos[r.nextInt(castigos.length)]);
                break;
        }
    }
}