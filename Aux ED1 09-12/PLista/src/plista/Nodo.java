/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plista;

/**
 *
 * @author Lab-214-21
 */
public class Nodo { int dato; // dato de nodo
                     Nodo enlace;   // 

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
       public int getDato() {
        return dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public Nodo(int dato) {   // ser borra nodo enlace 
        this.dato = dato;
        this.enlace = null;
    }

    
                  
    
}
