/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Roly
 */
public class bitwise {

    public bitwise() {
    }

    public void set(byte z, byte pos, byte valor) {
        if (valor == 1) {
            z = set1(z, pos);
        } else {
            z = set0(z, pos);
        }
    }

    private byte set1(byte z, byte pos) {
        byte aux = (byte) Math.pow(2, pos - 1);
        aux = (byte) (aux << (pos - 1));
        z = (byte) (z | aux);
        return z;
    }

    private byte set0(byte z, byte pos) {
        byte aux = 1;
        aux = (byte) (aux << (pos - 1));
        aux = (byte) ~aux;
        z = (byte) (z & aux);
        return z;
    }

    public byte getBit(byte z, byte pos) {
        byte aux = 1;
        aux = (byte) (aux << (pos - 1));
        aux = (byte) (z & aux);
        aux = (byte) (aux >> (pos - 1));
        return aux;
    }
}
