/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Juan
 */
public class NodoM<T extends Comparable, Q> {
            private Q dato;
            private NodoM D;
            private Lista A;
            
      public NodoM()
      {
          D = null;
          A = new Lista<T>();
      }
      
      public NodoM(Q dato)
      {
          this.dato = dato;
          D = null;
          A = new Lista<T>();
      }

    /**
     * @return the dato
     */
    public Q getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Q dato) {
        this.dato = dato;
    }

    /**
     * @return the D
     */
    public NodoM getD() {
        return D;
    }

    /**
     * @param D the D to set
     */
    public void setD(NodoM D) {
        this.D = D;
    }

    /**
     * @return the A
     */
    public Lista getA() {
        return A;
    }

    /**
     * @param A the A to set
     */
    public void setA(Lista A) {
        this.A = A;
    }
      
      
    
}
