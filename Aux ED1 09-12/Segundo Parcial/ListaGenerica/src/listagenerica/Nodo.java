/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listagenerica;

public class Nodo<T> {
    
    private T dato;
    private Nodo<T> enlace;

    public Nodo() {
        this(null);
    }

    public Nodo(T dato) {
       this(dato,null);
    }
    
    public Nodo(T dato, Nodo<T> enlace) {
        this.dato = dato;
        this.enlace = enlace;
    }

    public  T getDato() {
        return dato;
    }

    public  void setDato(T dato) {
        this.dato = dato;
    }

    protected Nodo<T> getEnlace() {
        return enlace;
    }

    protected void setEnlace(Nodo<T> enlace) {
        this.enlace = enlace;
    }
    
    
    
}
