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

    int x;

    public bitwise() {
        this.x = 0;
    }

    public void setBit(int pos, int estado) {
        int y = 1;
        y = (y << (pos - 1));
        if (estado == 0) {
            y = ~y;
            x = (x & y);
        } else {
            x = (x | y);
        }
    }

    public int getBit(int pos) {
        int y = 1;
        y = (y << (pos - 1));
        y = (y & x);
        y = (y >>> (pos - 1));
        return y;
    }
}
