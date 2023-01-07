/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Roly
 */
public class Caracter {

    BitWise chars;
    int dim;

    public Caracter() {
        this.chars = new BitWise(1, 0, 31);
        this.dim = 0;
    }

    public void setCaracter(int pos, char c) throws Exception {
        if (dim % 10 == 0) {
            chars.dimensionar(dim + 10);
        }
        int i = decodeChar(c);
        chars.setDato(pos, i);
        dim++;
    }

    public char getCaracter(int pos) throws Exception {
        return encodeChar(chars.getDato(pos));
    }

    public void elimCaracter(int pos) throws Exception {
        for (int i = pos; i < dim; i++) {
            chars.setDato(i, chars.getDato(i + 1));
        }
        dim--;
    }

    public int decodeChar(char c) {
        int i = 0;
        if (c != ' ') {
            i = (c - 64);
        }
        return i;
    }

    public char encodeChar(int i) {
        char c;
        if (i > 0) {
            c = (char) (64 + i);
        } else {
            c = ' ';
        }
        return c;
    }
}
