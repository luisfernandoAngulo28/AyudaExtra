/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import org.omg.CORBA.MARSHAL;

/**
 *
 * @author Roly
 */
public class fraccion {

    int v[];
    int dim;

    public fraccion(int cant) { // oonstructor
        int x = cant * 9 % 32;
        if (x != 0) {
            v = new int[(cant * 9 / 32) + 1];
        } else {
            v = new int[(cant * 9 / 32)];
        }
        this.dim = 0;
    }

    private int nBit(int pos) {
        return (((pos - 1) * 9) + 1) % 32;
    }

    private int nEnt(int pos) {
        return ((pos - 1) * 9) / 32;
    }

    public void insertar(int n, int d, int s) {
        if (dim == 0) {
            int mask = n;
            d = d << 4;
            mask = mask | d;
            s = s << 8;
            mask = mask | s;
            v[0] = mask;
            dim++;
        } else {
            int x = nBit(dim + 1);
            int y = nEnt(dim + 1);
            if ((x + 9) <= 32) {
                int mask = s;
                mask = mask << 8;
                d = d << 4;
                mask = mask | d;
                mask = mask | n;
                mask = mask << (x - 1);
                v[y] = v[y] | mask;
                dim++;
            } else {
                int mask = n;
                d = d << 4;
                mask = mask | d;
                s = s << 8;
                mask = mask | s;
                int mask1 = mask;
                mask = mask << (x - 1);
                v[y] = v[y] | mask;
                mask1 = mask1 >>> 32 - (x + 1);
                v[y + 1] = v[y + 1] | mask1;
                dim++;
            }
        }
    }

    public int Sacar(int pos) {
        int x = nBit(pos);
        int y = nEnt(pos);
        int num = v[y];
        int mask = (int) Math.pow(2, 9) - 1; //511
        num = num >>> (x - 1);
        num = num & mask;
        if (x + 9 > 32) {
            int num2 = v[y + 1];
            int mask1 = (int) Math.pow(2, 32 - x) - 1;
            num2 = num2 & mask1;
            num2 = num2 << (32 - x) + 1; //recorro parte alta
            num = num | num2;
        }
        return num;
    }

    public String Mostrar() {
        String S = "";
        int i = dim;
        int j = 1;
        while (i > 0) {
            int n = Sacar(j);
            if (n != 0) {
                int num = n;
                num = num & 15;
                int denom = n;
                denom = (denom >>> 4) & 15;
                int sig = n;
                sig = (sig >>> 8) & 1;
                S = num + "/" + denom + S;
                if (sig == 1) {
                    S = "+" + S;
                } else {
                    S = "-" + S;
                }
                S = ", " + S;
                i--;
            }
            j++;
        }
        return S;
    }
}
