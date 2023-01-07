/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *Esta clase representa un U = {0..cant} es decir desde 0 a la cantidad ingresada, y lo unico q se hace
 * es prender el bit en esa posicion si el nro fue ingresado. Por ejemplo si introduzca el 3 entonces en el
 * bw[0] el bit 4 se prenderera ya q va desde 0.... Otro caso si introduzco el nro 32 entonces se prendera
 * el b[1] el bit 1.....
 */
public class Conjunto {

    bitwise bw[];

    public Conjunto(int cant) {
        int z = cant / 32;
        if (cant % 32 == 0) {
            this.bw = new bitwise[(z)];
        } else {
            z++;
            this.bw = new bitwise[(z)];
        }
        for (int i = 0; i < z; i++) {
            bw[i] = new bitwise();
        }
    }

    private int nEntero(int valor) {
        return (valor / 32);
    }

    private int nBit(int valor) {
        return ((valor % 32) + 1);
    }

    public void Insertar(int p) {
        int y = nEntero(p);
        int w = nBit(p);
        bw[y].setBit(w, 1);
    }

    public void eliminar(int p) {
        int y = nEntero(p);
        int w = nBit(p);
        bw[y].setBit(w, 0);
    }
    //me dice si el bit en una determ posicion si se encuentra en 1 o 0 

    public boolean pertenece(int p) {
        int w = nBit(p);
        int y = nEntero(p);
        int x = bw[y].getBit(w);
        if (x == 1) {
            return true;
        } else {
            return false;
        }
    }
    //realiza la union de dos Conjuntos

    public void Union(Conjunto A, Conjunto B) {
        for (int i = 0; i <= 64; i++) {
            if (A.pertenece(i) || B.pertenece(i)) {
                Insertar(i);
            }
        }
    }

    public void Interseccion(Conjunto A, Conjunto B) {
        for (int i = 0; i <= 64; i++) {
            if (A.pertenece(i) && B.pertenece(i)) {
                Insertar(i);
            }
        }
    }

    public String Mostrar() {
        String S = "";
        int i = 0;
        while (i <= 64) {
            if (pertenece(i) == true) {
                S = S + i + ", ";
            }
            i++;
        }
        return S;
    }
}
