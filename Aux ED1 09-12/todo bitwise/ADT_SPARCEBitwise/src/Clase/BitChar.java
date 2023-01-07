/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

/**
 *
 * @author Eddy
 */
public class BitChar {

    int dim;
    VectorBitGenerico C;

    public BitChar(VectorBitGenerico C, int cant) {
        C = new VectorBitGenerico(5, 10, cant);
        dim = -1;
    }

    public int ToChar(char c) {
        int x = (byte) c;
        if (((x >= 65) && (x <= 90)) || (x == 32)) {
            if (x == 32) {
                x = 0;
            } else {
                x -= 64;
            }
        }
       return x;
    }

    public char GetChar(int pos) {
        int x = C.GetData(pos);
        if (x == 0) {
            x = 32;
        } else {
            x += 64;
        }
        return (char) x;
    }

    @Override
    public String toString() {
        String a = "[";
        for (int i = 0; i <= dim; i++) {
            a = a + GetChar(i) + ",";
        }
        a = a.substring(0, a.length() - 1);
        return a + "]";
    }

}
