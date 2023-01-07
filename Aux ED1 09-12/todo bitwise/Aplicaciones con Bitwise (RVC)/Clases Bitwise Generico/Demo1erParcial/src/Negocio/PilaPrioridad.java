/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Esta clase representa una Pila de Prioridades Prioridad = {1..10], Valor = {0..60}
 * La pila debe estar ordenada por Prioridad mayor sera la urgencia de desplazar el elemento...
 * Por tanto utilizare 10 bits para poder representar todo en una casilla
 * 4 bit's para la Prioridad y 6 bit's para el Valor....
 * @author Roly
 */
public class PilaPrioridad {

    BitWise P;
    int cima;

    public PilaPrioridad(int cant) {
        P = new BitWise(cant, 10);
        cima = 0;
    }

    public boolean vacia() {
        return cima == 0;
    }

    public boolean llena() {
        return cima == P.Dim;
    }

    public void push(int elem) {
        if (llena() == false) {
            cima++;
            P.SetDato(cima, elem);
        } else {
            System.out.println("PilaPrioridad::Push::Error la pila esta llena");

        }
    }

    public int pop() {
        if (vacia() == false) {
            int n = P.GetDato(cima);
            cima--;
            return n;
        } else {
            System.out.println("PilaPrioridad::PopDato::Pila esta vacia");
            return -1;
        }
    }

    public int getPriori() {
        int x = P.GetDato(cima);
        x = x >>> 6;
        int mask = 15;
        return x & mask;

    }

    public int getValor() {
        int v = P.GetDato(cima);
        v = v & 63;
        return v;
    }
    //metodo inserta de acuerdo a la prioridad y ademas al orden de llegada
    public void pushDato(int valor, int priori) {
        if (llena() == false) {
            int dato = priori;
            dato = dato << 6;
            dato = dato | valor;
            push(dato);
            Ordenar();
        } else {
            System.out.println("PilaPrioridad::PushDato::Error la pila esta llena");
        }
    }

    public void Ordenar() {
        PilaPrioridad Q = new PilaPrioridad(cima + 1);
        int i = 0;
        while (cima > i) {
            int M = getPriori();
            int aux =  pop();
            while (cima > i) {
                int x = getPriori();
                int y = pop();
                if (x <= M) {
                    M = x;
                    Q.push(aux);
                    aux = y;
                }else{ 
                    Q.push(y);
                }
             }
            push(aux);
            while (Q.vacia() == false) {
                push(Q.pop());
            }
            i++;
        }
    }

    public int getDato(int pos) {
        return P.GetDato(pos);
    }

    public int getCima() {
        return cima;
    }

    public String Mostrar() {
        String S = "";
        int i = cima;
        while (i > 0) {
            int n = P.GetDato(i);
            int n1 = n;
            n1 = n1 & 63;
            n = n >>> 6;
            n = n & 15;
            S = S + "|" + n1 + " ," + n + "|";
            S = S + "\n";
            i--;
        }
        return S;
    }
}
