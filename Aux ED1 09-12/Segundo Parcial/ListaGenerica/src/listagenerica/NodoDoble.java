/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listagenerica;

/**
 *
 * @author Usuario
 */
public class NodoDoble<T> extends Nodo<T> {
    
    private NodoDoble<T> anterior;

    public NodoDoble() {
        this(null);
    }

    public NodoDoble(T dato) {
        this(dato,null,null);
    }

    public NodoDoble( T dato, NodoDoble<T> siguiente,NodoDoble<T> anterior) {
        super(dato, siguiente);
        this.anterior = anterior;
    }

    @Override
    public  void setDato(T dato) {
        super.setDato(dato); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  T getDato() {
        return super.getDato(); //To change body of generated methods, choose Tools | Templates.
    }
   

    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public void setSiguiente(NodoDoble<T> siguiente){
        super.setEnlace(siguiente);
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }

    public NodoDoble<T> getSiguiente() {
        return (NodoDoble<T>) super. getEnlace();
    }

    
    
}
