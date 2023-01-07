/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Roly
 */
public class PilaBitwise {

    BitWise P;
    int cima;

    public PilaBitwise(int CantElem, int CantBits) {
        this.P = new BitWise(CantElem, CantBits);
        this.cima = 0;
    }

    private boolean Llena() {
        return cima == P.Dim;
    }

    private boolean vacia() {
        return cima == 0;
    }

    public void pushSord(int Hora, int Min, int Seg, String F) throws Exception {
        if (Llena() == false) {
            int dato = 0;
            int k = 0;
            if (F.endsWith("am")) {
                k = 0;
            }
            if (F.endsWith("pm")) {//k = 1 xq pm es un horario mas tarde
                k = 1;
            }
            dato = dato * 10 + k;

            dato = dato * 100 + Hora;

            dato = dato * 100 + Min;

            dato = dato * 100 + Seg;

            push(dato);

            OrdenarPush();

        } else {
            System.out.print("Error: La Pila esta llena");
        }
    }

    public void push(int dato) throws Exception {
        if (Llena() == false) {
            cima++;
            P.SetDato(cima, dato);

        } else {
            throw new Exception("Error : Pila Llena");
        }
    }

    public int pop() throws Exception {
        if (vacia() == false) {
            int x = P.GetDato(cima);
            cima--;
            return x;
        } else {
            throw new Exception("Error: Pila Vacia");
        }
    }

    /*public void Ordenar() throws Exception {
        int i = cima;
        while (i > 0) {
            int j = i - 1;
            while (j > 0) {
                if (P.GetDato(j) > P.GetDato(i)) {
                    int aux = P.GetDato(i);
                    P.SetDato(i, P.GetDato(j));
                    P.SetDato(j, aux);
                }
                j--;
            }
            i--;
        }
    }*/

    public void OrdenarPush() throws Exception {
        int i = 1;
        PilaBitwise q = new PilaBitwise(P.Dim, P.Nbits);
        while (i <= cima) {
            int x = pop();
            while (vacia() == false && i <= cima) {
                int y = pop();
                if (y < x) {
                    q.push(x);
                    x = y;
                } else {
                    q.push(y);
                }
            }
            push(x);
            while (q.vacia() == false) {
                push(q.pop());
            }
            i++;
        }
    }

    public int Get() throws Exception {
        if (vacia() == false) {
            return P.GetDato(cima);
        } else {
            throw new Exception("Error Pila Vacia");
        }
    }

    public String Mostrar() throws Exception {
        String S = "";
        int i = 1;
        while (vacia() == false) {
            int x = pop();
            int seg = x % 100;
            x = x / 100;
            int min = x % 100;
            x = x / 100;
            int h = x % 100;
            x = x / 100;
            String formato = "";
            if (x == 0) {
                formato += "am";
            }
            if (x == 1) {
                formato += "pm";
            }
            S = S + Integer.toString(h) + ":" + Integer.toString(min) + ":" + Integer.toString(seg) + " " + formato;

            S = S + "\n";


        }
        return S;
    }
}
