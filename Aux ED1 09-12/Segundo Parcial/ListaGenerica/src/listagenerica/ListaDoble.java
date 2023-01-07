/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listagenerica;

/**
 *
 * @author Usuario
 */

public class ListaDoble<T extends Comparable<T>> {

    private NodoDoble<T> p,u;
    private int cant;
    
    public ListaDoble() {
        u=p=new NodoDoble<>();
        cant=0;
    }

    public int getCant() {
        return cant;
    }
    public boolean vacio(){
        return u.getSiguiente()==null;
    }
    
    private NodoDoble<T> insertarR(T dato , NodoDoble <T> nodo){
        
        if(nodo == null){
            cant++;
            u= new NodoDoble<>(dato,null,u);
            return u;
        }else
            if(dato.compareTo(nodo.getDato())==0)
                return nodo;
        else
            if(dato.compareTo(nodo.getDato())<0){
                nodo.setAnterior(new NodoDoble<>(dato, nodo, nodo.getAnterior()));
                cant++;
            }
        else
              nodo.setSiguiente(insertarR(dato, nodo.getSiguiente()));
        return nodo;
    }
    private String mostrarR(NodoDoble<T> nodo){
        if(nodo!=null){
            return nodo.getDato() +" "+mostrarR(nodo.getSiguiente());
        }
        return "";
    }
    @Override
    public String toString() {
        return "L >>"+ mostrarR(p.getSiguiente());
    }
    
    public void insertar(T dato){
        p.setSiguiente(insertarR(dato, p.getSiguiente()));
    }
    
    private NodoDoble<T> eliminar(T dato , NodoDoble<T> nodo){
        if(nodo == null){
            return nodo;
        }else
            if(dato.compareTo(nodo.getDato())==0){
                cant--;
                if(nodo.getSiguiente()==null){
                    u=nodo.getAnterior();
                    u.setSiguiente(null);
                    if(u.getAnterior()==null){
                        p=u;
                        return null;
                    }
                    else
                        return u;
                }   
                NodoDoble<T> aux=nodo.getSiguiente();
                aux.setAnterior(nodo.getAnterior());     
                return aux;
            }
        else
                nodo.setSiguiente(eliminar(dato, nodo.getSiguiente()));
        return nodo;
    }
    // 5 8 9 6
    // 
    private void invertir(NodoDoble<T> nodo,NodoDoble<T> aux){
       if(nodo.getAnterior()!=null){
           NodoDoble<T> aux1=new NodoDoble<>(nodo.getDato());
           aux1.setAnterior(aux);
           aux.setSiguiente(aux1);
           invertir(nodo.getAnterior(),aux.getSiguiente());
           return ;
       } 
       u=nodo.getSiguiente();
    }
    public void invertir(){
        NodoDoble<T> aux=new NodoDoble<>();
        invertir(u, aux);
        p=aux;
    }
    public void eliminar(T dato){
        p.setSiguiente(eliminar(dato,p.getSiguiente()));
    }
    
}
