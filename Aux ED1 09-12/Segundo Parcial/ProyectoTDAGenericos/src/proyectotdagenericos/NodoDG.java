/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotdagenericos;

/**
 *
 * @author Usuario
 */
class NodoDG <T> {
    T Dato;
    NodoDG<T> EnlaceD;
    NodoDG<T> EnlaceI;
    
    
    
  public NodoDG()
  {
    Dato=null;
    EnlaceD=null;
    EnlaceI=null;
  }
  
  public NodoDG(T Dato)
  {
  this.Dato=Dato;
  EnlaceI=null;
  EnlaceD=null;
  }
  
   public NodoDG( T dato, NodoDG<T> EnlaceD,NodoDG<T> EnlaceI) {
        this.EnlaceI = EnlaceI;
        this.EnlaceD = EnlaceD;
        this.Dato=dato;
    }

    //Setrers
    public void setDato(T Dato) {
        this.Dato = Dato;
    }

    public void setEnlaceD(NodoDG<T> EnlaceD) {
        this.EnlaceD = EnlaceD;
    }

    public void setEnlaceI(NodoDG<T> EnlaceI) {
        this.EnlaceI = EnlaceI;
    }

    public T getDato() {
        return Dato;
    }

    public NodoDG<T> getEnlaceD() {
        return EnlaceD;
    }

    public NodoDG<T> getEnlaceI() {
        return EnlaceI;
    }
  

}
