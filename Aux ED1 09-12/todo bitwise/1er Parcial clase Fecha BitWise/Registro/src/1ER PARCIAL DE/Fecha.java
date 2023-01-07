/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Roly
 */
public class Fecha {

    BitWise v;
    int Dim;

    public Fecha(int cantF) {
        v = new BitWise(cantF, 14);
        Dim = 0;
    }

    public void setFecha(int Dia, int Mes, int Anio) throws Exception {
        int Dato = Dia;
        int dato1 = Mes;
        dato1 = dato1 << 5;
        Dato = Dato | dato1;
        int dato2 = dato2 = Anio;
        dato2 = dato2 << 9;
        Dato = Dato | dato2;
        v.SetDato(Dim, Dato);
        Dim++;
    }

    public int getDia(int pos) throws Exception {
        int x = v.GetDato(pos);
        int mask = 31;
        x = x & mask;
        return x;

    }

    public int getMes(int pos) throws Exception {
        int x = v.GetDato(pos);
        x = x >>> 5;
        x = x & 15;
        return x;
    }

    public int getAnio(int pos) throws Exception {
        int x = v.GetDato(pos);
        x = x >>> 9;
        x = x & 15;
        return x;
    }

    public String getFecha(int pos) throws Exception {
        String S = "";
        S = S + "Dia:" + getDia(pos) + "/";
        S = S + "Mes:" + getMes(pos) + "/";
        S = S + "Anio:" + "200" + getAnio(pos);
        return S;
    }

    public String Mostrar() throws Exception {
        String S = "";
        int i = 1;
        while (i < v.Dim) {
            int k = v.GetDato(i);
            if (k != 0) {
                S = S + getFecha(i) + "\n";
            }
            i++;
        }
        return S;
    }
}
