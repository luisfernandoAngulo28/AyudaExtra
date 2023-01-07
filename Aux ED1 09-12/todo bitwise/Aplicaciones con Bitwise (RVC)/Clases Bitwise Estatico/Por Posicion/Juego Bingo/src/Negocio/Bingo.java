/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.Random;

/**
 *Esta clase lo q hace es crear un vector bg[] del tipo carton es decir cada elemento del vector bg[] constara
 * de un universo de datos del {0..60}... el campo nroCarton viene hacer la tarea de la cantidad de cartones
 * q se van a crear... el campo cantElem viene hacer el total de nro ganadores q puede tener un Carton para
 * nuestro caso serian 15 nros ganadores pero puede variar dependendiendo del usuario....
 * @author Roly
 */
public class Bingo {

    Carton bg[];
    int nroCarton;
    int cantElem;

    public Bingo(int cantCarton, int cantNro) {
        this.bg = new Carton[cantCarton];
        for (int i = 0; i < cantCarton; i++) {
            bg[i] = new Carton();
        }
        this.nroCarton = cantCarton;
        this.cantElem = cantNro;
    }

    public void hacerCarton() {
        int i = 0;
        while (i < nroCarton) {
            int j = 1;
            Random r = new Random(); //creo una instancia de la clase Random q me proporciona java
            while (j <= cantElem) {
                int nro = r.nextInt(60 + 1);
                bg[i].marcar(nro);
                j++;
            }
            i++;
        }
    }

    public String jugar() {
        Random r = new Random();
        String S = "";
        for (int i = 1; i <= cantElem; i++) {
            int nro = r.nextInt(60 + 1);
            S = S + nro + " ,";
            for (int j = 0; j < nroCarton; j++) {
                bg[j].borrar(nro);
            }
        }
        return S;
    }

    public int Ganador() throws Exception {
        int j = 0, c = 0;
        while (j < nroCarton && c == 0) {
            int i = 0;
            while (i < 61 && bg[j].existe(i) == false) {
                i++;
            }
            if (i == 61) {
                c = 1;
            } else {
                j++;
            }
        }
        if (c == 1) {
            return j + 1;
        } else {
            return -1;
        }
    }

    public String mostrarCartones() {
        String S = "";
        int i = 0;
        while (i < nroCarton) {
            int j = 0;
            S = S + "Carton " + (i + 1) + ": ";
            while (j < 61) {
                if (bg[i].existe(j) == true) {
                    S = S + j + " ,";
                }
                j++;
            }
            S = S + "\n";
            i++;
        }
        return S;
    }
}
