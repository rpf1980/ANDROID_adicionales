package com.example.juego3enrayapro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnReset, btnSalir;
    TextView texto;

    //Instanciamos la clase juego3R
    juego3R juego = new juego3R();

    //Variables
    int turno = 1;
    int jugador1, ordenador;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        //Asociamos los componentes de la app con sus id
        btn1 = (Button)(findViewById(R.id.idBtn1));
        btn2 = (Button)(findViewById(R.id.idBtn2));
        btn3 = (Button)(findViewById(R.id.idBtn3));
        btn4 = (Button)(findViewById(R.id.idBtn4));
        btn5 = (Button)(findViewById(R.id.idBtn5));
        btn6 = (Button)(findViewById(R.id.idBtn6));
        btn7 = (Button)(findViewById(R.id.idBtn7));
        btn8 = (Button)(findViewById(R.id.idBtn8));
        btn9 = (Button)(findViewById(R.id.idBtn9));
        btnReset = (Button)(findViewById(R.id.idReset));
        btnSalir = (Button)(findViewById(R.id.idSalir));

        //Preparamos reset y salir para las escuchas de los onClickListener
        btnReset.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        //Aquí empiezan el juego
        Button b = (Button) v;

        while(juego.quedanMovimientos() && !(juego.ganaJugador1() || juego.ganaJugador2()))
        {
            if(turno == 1)
            {
                juego.mueveJugador1(jugador1);
                turno = 2;
            }
            else
            {
                if(!juego.ganaJugador2())
                {
                    //Turno del ordenador
                    juego.mueveOrdenador2();
                    turno = 1;
                }
            }
        }

        //Evento del RESET
        if(v.getId() == R.id.idReset)
        {
            texto.setText("");

            btn1.setEnabled(true);
            btn1.setText("");
            btn2.setEnabled(true);
            btn2.setText("");
            btn3.setEnabled(true);
            btn3.setText("");
            btn4.setEnabled(true);
            btn4.setText("");
            btn5.setEnabled(true);
            btn5.setText("");
            btn6.setEnabled(true);
            btn6.setText("");
            btn7.setEnabled(true);
            btn7.setText("");
            btn8.setEnabled(true);
            btn8.setText("");
            btn9.setEnabled(true);
            btn9.setText("");
        }

        //Evento de SALIR
        if(v.getId() == R.id.idSalir)
        {
            System.exit(0);
        }
    }


    //Método con clase Toast para mostrar mensajes
    public void msgToast(String menaje)
    {
        Toast toast = Toast.makeText(getApplicationContext(), menaje, Toast.LENGTH_SHORT);

        toast.show();
    }
}
