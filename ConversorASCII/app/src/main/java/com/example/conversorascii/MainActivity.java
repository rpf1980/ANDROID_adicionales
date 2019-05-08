package com.example.conversorascii;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    //Componentes de la app
    TextInputEditText txtChar;
    EditText txtAscii;
    TextView txtHexa;
    Button btnAscii, btnChar, btnReset;

    //Variables
    int codigoAscii = 0;
    int enteroAuxiliar = 0;
    char charAuxiliar;
    String stringAuxiliar;
    String hexadecimal;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asociamos los id a las variables de los componentes de la app
        txtChar = findViewById(R.id.idTextChar);
        txtAscii = findViewById(R.id.idTextAscii);
        txtHexa = findViewById(R.id.idHex);
        btnAscii = findViewById(R.id.idBtnAscii);
        btnChar = findViewById(R.id.idBtnChar);
        btnReset = findViewById(R.id.idBtnReset);
    }

    public void onClickMuestraValorAscii(View v)
    {
        stringAuxiliar = txtChar.getText().toString(); //Guardamos el string del txtChar
        charAuxiliar = stringAuxiliar.charAt(0); //Hacemos casting ( string a char )

        //Una vez que tengamos el dato convertido a char, ya podemos obtener el código ASCII
        codigoAscii = (int) charAuxiliar;

        //Ahora tenemos que convertir el dato int en string para poder mostrarlo
        txtAscii.setText(String.valueOf(codigoAscii));

        //Algoritmo para el código en hexadecimal
        hexadecimal = Integer.toHexString(codigoAscii);
        //Y lo mostramos por el txtHex
        txtHexa.setText(hexadecimal);
    }

    public void onClickMuestraValorChar(View v)
    {
        enteroAuxiliar = Integer.valueOf(txtAscii.getText().toString()); //Guardo el string del txtNumber convertido a entero
        charAuxiliar = (char) enteroAuxiliar; //En esta línea ya tengo el código ascii del char

        //Ahora tengo que pasar el char a string para poder mostrarlo en el txtChar
        txtChar.setText(String.valueOf(charAuxiliar));
    }

    public void onClickReset(View v)
    {
        txtChar.setText("");
        txtAscii.setText("");
        txtHexa.setText("");
    }
}
