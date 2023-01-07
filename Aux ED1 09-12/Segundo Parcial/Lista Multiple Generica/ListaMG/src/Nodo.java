/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Juan
 */
public class Nodo<T> {
            private T dato;
            private Nodo enlace;
            
      public Nodo()
      {
          enlace = null;
      }
      
      public Nodo(T dato)
      {
          this.dato = dato;
          enlace = null;
      }

    /**
     * @return the dato
     */
    public T getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * @return the enlace
     */
    public Nodo getEnlace() {
        return enlace;
    }

    /**
     * @param enlace the enlace to set
     */
    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
      
      
}
