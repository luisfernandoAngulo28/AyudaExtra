/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author ESTUDIANTE
 */
public class NodoG<T> {

    T Dato;
    NodoG<T> Enlace;

    public NodoG() {
        this.Enlace = null;
    }

    public NodoG(T Dato) {
        this.Dato = Dato;
        this.Enlace = null;
    }

    public void SetDato(T Dato) {
        this.Dato = Dato;
    }

    public T GetDato() {
        return this.Dato;
    }

    public void SetEnlace(NodoG<T> P) {
        this.Enlace = P;
    }

    public NodoG<T> GetEnlace() {
        return this.Enlace;
    }

    public int CompareTo(int e) {
        return e;
    }
}
