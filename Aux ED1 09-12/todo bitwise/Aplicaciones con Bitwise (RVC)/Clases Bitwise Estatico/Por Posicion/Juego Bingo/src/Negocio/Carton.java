/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *Esta clase lo q hace es simular el carton de 1 juego de Bingo... 1 carton tiene un U{0..60} pero en realidad
 * solo se necesita representar 15 nro en total... Por tanto esta clase lo q hace es almacenar un Carton en
 * 2 cajas de un v[] ya q tendran 61 bit's para poder mostrar....
 */
public class Carton {

    bitwise v[];

    public Carton() {
        this.v = new bitwise[2];
        for (int i = 0; i < 2; i++) {
            v[i] = new bitwise();
        }
    }

    private int nBit(int valor) {
        return ((valor % 32) + 1);
    }

    private int nEnt(int valor) {
        return ((valor / 32));
    }
    //lo q hace es marcar o realizar un setDato en el bit q se encuentre el valor
    
    public void marcar(int valor) {
        int x = nBit(valor);
        int y = nEnt(valor);
        if (existe(valor) == false) {
            v[y].setBit(x, 1);
        }
    }
    
    public void borrar(int valor){
        int x = nBit(valor);
        int y = nEnt(valor);
        v[y].setBit(x, 0);
    }

    public boolean existe(int valor) {
        int x = nBit(valor);
        int y = nEnt(valor);
        int k = v[y].getBit(x);
        if (k == 1) {
            return true;
        } else {
            return false;
        }
    }
}
