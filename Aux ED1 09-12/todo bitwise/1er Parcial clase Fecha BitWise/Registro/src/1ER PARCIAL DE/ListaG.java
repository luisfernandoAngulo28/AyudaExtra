/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author ESTUDIANTE
 */
public class ListaG<T extends Comparable> {

    NodoG<T> L;
    int cant;

    public ListaG() {
        this.L = null;
        this.cant = 0;
    }

    public void Insertar(T Dato) {
        NodoG P = new NodoG<T>(Dato);
        if (L == null) {
            P.SetDato(Dato);
            this.L = P;
            cant++;
        } else {
            NodoG<T> ant = null;
            NodoG<T> aux = this.L;
            while ((aux != null) && (aux.GetDato().compareTo(Dato) < 0)) {
                ant = aux;
                aux = aux.GetEnlace();
            }
            if (ant == null) { //inserta al inicio
                P.SetEnlace(L);
                L = P;
                cant++;
            } else {
                ant.SetEnlace(P);
                P.SetEnlace(aux);
                cant++;
            }
        }
    }
    public String Mostrar(){
        String S ="";
        NodoG i = L;
        while(i!=null){
            S = S + i.GetDato() + ",";
            i = i.GetEnlace();
        }
        return S;
    }
}
