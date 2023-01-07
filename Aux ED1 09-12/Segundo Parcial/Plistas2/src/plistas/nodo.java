 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plistas;

/**
 *
 * @author Lab-214-21
 */
public class nodo { int dato;// dato del nodo
                    nodo enlace; // referencia al si nodo

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setEnlace(nodo enlace) {
        this.enlace = enlace;
    }

    public int getDato() {
        return dato;
    }

    public nodo getEnlace() {
        return enlace;
    }

    public nodo() {
        this.enlace = null;
    }

    public nodo(int dato) {
        this.dato = dato;
        this.enlace = null;
    }
                    
                    
                    
    
}
