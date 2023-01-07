/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Aux INF220 - 2/2016
 */
public class CintaBitexa {

    VectorBitG C;
    int dim;
    int pointer;

    public CintaBitexa(int cant) {
        C = new VectorBitG(5, cant);
        dim = -1;
        pointer = 0;
    }

    public void Insertar(char c) {
        int x = (byte) c;
        if (((x >= 65) && (x <= 90)) || (x == 32)) {
            if (x == 32) {
                x = 0;
            } else {
                x -= 64;
            }
            dim++;
            C.Insertar(x, dim);
        }
    }

    public int ContPal() {
        int i = 0;
        int x = 0;
        while ((i <= dim) && (C.sacar(i) == 0)) {
            i++;
        }
        if ((i == dim) || (dim == -1)) {
            return 0;
        }
        while ((i <= dim)) {
            while ((i <= dim) && (C.sacar(i) != 0)) {
                i++;
            }
            x++;
            while ((i <= dim) && (C.sacar(i) == 0)) {
                i++;
            }
        }
        return x;
    }

    public char GetChar() {
        int x = C.sacar(0);
        if (x == 0) {
            x = 32;
        } else {
            x += 96;
        }
        return (char) x;
    }

    public char Get1Char(int pos) {
        int x = C.sacar(pos);
        if (x == 0) {
            x = 32;
        } else {
            x += 64;
        }
        return (char) x;
    }

    public String Mostrarpalabra() {
        String a = "";
        while ((C.sacar(pointer) != 0) && (pointer <= dim)) {
            a = a + Get1Char(pointer);
            pointer++;
        }
        if (C.sacar(pointer) == 0) {
            pointer++;
        } else {
            pointer = 0;
        }
        return a;
    }

    public void Eliminarpalabra() {
        int i = 0;
        while ((C.sacar(i) == 0) && (i <= dim)) {
            i++;
        }
        while ((C.sacar(i) != 0) && (i <= dim)) {
            i++;
        }
        while ((C.sacar(i) == 0) && (i <= dim)) {
            i++;
        }
        for (int j = 0; j <= dim; j++) {
            C.Insertar(C.sacar(i + j), j);
        }
        dim -= i;
        pointer = 0;
    }

    @Override
    public String toString() {
        String a = "[";
        for (int i = 0; i <= dim; i++) {
            a = a + Get1Char(i) + ",";
        }
        a = a.substring(0, a.length() - 1);
        return a + "]";
    }

    public String toStringBit() {
        return C.toString();
    }

    public static void main(String[] args) {
        CintaBitexa C = new CintaBitexa(50);

        C.Insertar('C');
        C.Insertar('A');
        C.Insertar('M');
        C.Insertar('P');
        C.Insertar('O');
        C.Insertar('S');
        

        System.out.println("Cinta = " + C.toString());
      //  System.out.println("Cinta = " + C.toStringBit());

    }

    public String getDim() {
        return "Dim = " + dim;
    }

}
