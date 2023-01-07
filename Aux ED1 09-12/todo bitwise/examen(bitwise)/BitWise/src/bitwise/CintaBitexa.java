/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwise;

/**
 *
 * @author Ernesto
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
        if (((x >= 97) && (x <= 122)) || (x == 32)) {
            if (x == 32) {
                x = 0;
            } else {
                x -= 96;
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
            x += 96;
        }
        return (char) x;
    }

    public String Mostrarcinta() {
        String a = "";
        int j = dim;
        for (int i = 0; i <= j; i++) {
            a = a + Get1Char(i);
        }
        return a;
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

}
