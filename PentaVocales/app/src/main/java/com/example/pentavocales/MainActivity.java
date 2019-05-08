package com.example.pentavocales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private EditText edtNombreFichero;
    private Button btnCargar;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asociamos con los id
        edtNombreFichero = (EditText) (findViewById(R.id.idNombreFichero));
        btnCargar = (Button) (findViewById(R.id.idBtn));
        lista = (ListView)(findViewById(R.id.idLista));



    }

    public void onClick(View v)
    {
        //Leemos del fichero
        int i;
        String linea;
        String lineaLimpia;
        String[] trozos;
        List<String> listAdapter = new ArrayList<>();

        //Adaptador, la forma visual en que mostraremos nuestros datos
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAdapter);

        //Enlazamos el adaptador con nuestra listView
        this.lista.setAdapter(adapter);

        try
        {
            //Leemos el fichero
            InputStream fr = getResources().openRawResource(R.raw.penta);
            BufferedReader br = new BufferedReader(new InputStreamReader(fr));

            linea = br.readLine();
            while (linea != null)
            {
                //Quitamos todos los caracteres especiales
                 linea = limpiaTexto(linea);

                //Hacemos split por los espacios
                trozos = linea.split(" ");

                //Recorremos el array y comprobamos si contiene elementos pentaVocales (elemto array = palabra del texto)
                for(i = 0; i < trozos.length; i++)
                {
                    if(esPentaVocal(trozos[i]))
                    {
                        listAdapter.add(trozos[i]);
                    }
                }
                linea = br.readLine();
                Collections.sort(listAdapter);
            }

            br.close();
            fr.close();
        } catch (Exception e)
        {
            msg("Error al leer fichero desde recurso raw");
        }
    }

    //Métodos aparte
    public String limpiaTexto(String cadena)
    {
        String copia = "";

        for(int i = 0; i < cadena.length(); i++)
        {
            if(cadena.charAt(i) == ' ' || Character.isLetter(cadena.charAt(i)))
            {
                copia = copia + cadena.charAt(i);
            }
        }
        return copia;
    }

    public boolean esPentaVocal(String cadena)
    {
        boolean esPenta = true;
        int contador = 0;
        int i,j;
        String vocales = "aeiou";
        int[] contVocales = new int[5];

        for(i = 0; i < cadena.length(); i++)
        {
            for(j = 0; j < vocales.length(); j++)
            {
                if(cadena.charAt(i) == vocales.charAt(j))
                {
                    contVocales[j]++;
                }
            }
        }

        for(i = 0; i < contVocales.length; i++)
        {
            if(contVocales[i] == 0)
            {
                esPenta = false;
            }

        }
        return esPenta;
    }

    public void msg(String menaje)
    {
        Toast toast = Toast.makeText(getApplicationContext(), menaje, Toast.LENGTH_LONG);
        toast.show();
    }
}
