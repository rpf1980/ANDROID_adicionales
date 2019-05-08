package com.example.juego3enrayapro;

import android.widget.Toast;

import java.security.InvalidParameterException;
import java.util.Random;

public class juego3R
{
    //Atributo
    private int[] tablero;

    //Constructor
    public juego3R()
    {
        this.tablero = new int[9];
    }

    //Métodos
    public void mueveJugador1(int pos)
    {
        if (tablero[pos-1] == 0)
        {
            tablero[pos-1] = 1;
        }
    }

    public void mueveJugador2(int pos)
    {
        if (tablero[pos-1] == 0)
        {
            tablero[pos-1] = 2;
        }
    }

    public boolean movimientoValido(int pos)
    {
        boolean esValido = false;
        int i;

        if (tablero[pos] == 0)
        {
            esValido = true;
        }
        return esValido;
    }

    public void mueveOrdenador1()
    {
        Random rd = new Random();
        int posicion = -1;
        int i;

        posicion = rd.nextInt(9);

        while (!movimientoValido(posicion))
        {
            posicion = rd.nextInt(9);
        }
        tablero[posicion] = 1;
    }

    public void mueveOrdenador2()
    {
        Random rd = new Random();
        int posicion = -1;
        int i;

        posicion = rd.nextInt(9) ;

        while (!movimientoValido(posicion))
        {
            posicion = rd.nextInt(9);
        }
        tablero[posicion] = 2;
    }

    public void iniciar()
    {
        int i;

        for (i = 0; i < 9; i++)
        {
            tablero[i] = 0;
        }
    }

    public boolean quedanMovimientos()
    {
        boolean puedesJugar;
        int ceros = 0;
        int i;

        for (i = 0; i < 9; i++)
        {
            if (tablero[i] == 0)
            {
                ceros++;
            }
        }

        if (ceros > 0)
        {
            puedesJugar = true;
        } else
        {
            puedesJugar = false;
        }
        return puedesJugar;
    }

    public boolean compruebaFilas(int jugador)
    {
        boolean filasOk = false;
        int contador;
        int i;

        for (i = 0; i < 9; i = i + 3)
        {
            contador = 0;
            for (int j = i; j < i + 3; j++)
            {
                if (tablero[j] == jugador)
                {
                    contador++;
                }
            }

            if (contador == 3)
            {
                filasOk = true;
            }
        }
        return filasOk;
    }

    public boolean compruebaColumnas(int jugador)
    {
        boolean columnasOk = false;
        int contador;
        int i, j;

        for (i = 0; i < 3; i++)
        {
            contador = 0;
            for (j = i; j < 9; j = j + 3)
            {
                if (tablero[j] == jugador)
                {
                    contador++;
                }
            }

            if (contador == 3)
            {
                columnasOk = true;
            }
        }
        return columnasOk;
    }

    //public int dameNumeroDe

    public boolean compruebaDiagonales(int jugador)
    {
        boolean diagonalesOk = false;
        int i;

        if ((tablero[0] == jugador && tablero[4] == jugador && tablero[8] == jugador) ||
                (tablero[2] == jugador && tablero[4] == jugador && tablero[6] == jugador))
        {
            diagonalesOk = true;
        }

        return diagonalesOk;
    }

    public boolean ganaJugador1()
    {
        boolean ganaJugador1;

        if(compruebaFilas(1) ||
                compruebaColumnas(1) ||
                compruebaDiagonales(1))
        {
            ganaJugador1 = true;
        }
        else
        {
            ganaJugador1 = false;
        }

        return ganaJugador1;
    }

    public boolean ganaJugador2()
    {
        boolean ganaJugador2;

        if(compruebaFilas(2) ||
                compruebaColumnas(2) ||
                compruebaDiagonales(2))
        {
            ganaJugador2 = true;
        }
        else
        {
            ganaJugador2 = false;
        }

        return ganaJugador2;
    }

    public String simboloJuego(int n)
    {
        String simbolo = "";

        switch (n)
        {
            case 0: simbolo = " ";break;
            case 1: simbolo = "X";break;
            case 2: simbolo = "O";break;
        }
        return simbolo;
    }
}
