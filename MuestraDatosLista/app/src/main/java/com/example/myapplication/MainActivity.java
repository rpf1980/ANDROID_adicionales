package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private EditText edtProducto;
    private Button btnEnviar;
    private ListView listView;

    //Lista que contendrá los datos a mostrar por la ListView
    List<String> listaDatos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asociamos los id
        edtProducto = (EditText)findViewById(R.id.idProducto);
        btnEnviar = (Button)findViewById(R.id.idEnviar);
        listView = (ListView)findViewById(R.id.idLista);
    }

    public void onClick(View v)
    {
        //Adaptador, la forma visual en que mostraremos nuestros datos
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaDatos);

        //Enlazamos el adaptador con nuestra ListView
        this.listView.setAdapter(adapter);

        listaDatos.add(edtProducto.getText().toString());

        edtProducto.setText("");
    }
}
