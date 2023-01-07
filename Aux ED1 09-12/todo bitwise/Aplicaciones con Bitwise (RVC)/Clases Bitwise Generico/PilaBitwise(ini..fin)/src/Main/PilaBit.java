/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

/**
 *
 * @author Roly
 */
public class PilaBit {

    BitWise P;
    int cima;

    public PilaBit(int cant, int ri, int rf) {
        P = new BitWise(cant, ri, rf);
        cima = 0;
    }

    public boolean vacia() {
        return cima == 0;
    }

    public boolean llena() {
        return cima == P.dim;
    }

    public void push(int elem) throws Exception {
        if (llena()) {
            System.out.println("Pilabit::Push::Error la pila esta llena");
        } else {
            cima++;
            P.setDato(cima, elem);
        }
    }

    public int pop() throws Exception {
        if (vacia() == true) {
            throw new Exception("Pilabit::Pop::Error la pila esta vacia)");
        } else {
            int x = P.getDato(cima);
            cima--;
            return x;
        }
    }
}
