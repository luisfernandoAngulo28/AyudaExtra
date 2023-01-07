/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listagenerica;

/**
 *
 * @author Usuario
 */
public class Cola <T extends Comparable<T>>{
    
    private Nodo<T> f,u;
    private int cant;

    public Cola() {
        f=u=new Nodo<>();
        cant=0;
    }

    public boolean vacio(){
        return f.getEnlace()==null;
    }
 
    public void encolar(T dato){
        u.setEnlace(new Nodo<>(dato));
        cant++;
        u=u.getEnlace();
        
    }
    //p 1 5 9
    private Nodo<T> busca(Nodo<T> nodo){
        if(nodo.getEnlace().getEnlace()!=null){
            return busca(nodo.getEnlace());
        }
        return nodo;
    }
    public void decolar(){
        if(!vacio()){
            cant--;
            f.setEnlace(f.getEnlace().getEnlace());
            if( f.getEnlace()==null)
                u=f;
        }
    }
    public T getDecolar() throws Exception{
        if(!vacio()){
            T aux=getPrimero();
            decolar();
            return aux;
        }
        else
            throw new Exception("la cola esta vacia");
    }
    //c[1]  <--- 1 6 5 8 9
    //           2 1 0
    // menor()
    private T get(Nodo<T> nodo,int i){
        if(nodo.getEnlace()!=null && i!=0){
            return get(nodo.getEnlace(), --i);
        }
        return nodo.getDato();
    }
    private void set(Nodo<T> nodo,int i,T dato){
        if(nodo.getEnlace()!=null && i!=0){
            set(nodo.getEnlace(), --i,dato);
            return ;
        }  
         nodo.setDato(dato);
    }
    public void burbuja(){
        for(int i=0;i<cant-1;i++)
            for(int j=i;j<cant;j++){
                T a=get(f.getEnlace(), i);
                T b=get(f.getEnlace(), j);
                if(a.compareTo(b)<0){
                    T aux=a;
                    set(f.getEnlace(), i,b);
                    set(f.getEnlace(), j,aux);
                }
                    
            }
    }
    public T getUltimo() throws Exception{
        if(!vacio())
            return u.getDato();
        else
            throw new Exception("la cola esta vacia");
    }
    public T getPrimero() throws Exception{
        if(!vacio())
            return f.getEnlace().getDato();
        else
            throw new Exception("la cola esta vacia");
    }
    public int getCant() {
        return cant;
    }
    private String mostrar(Nodo<T> nodo){
        if(nodo.getEnlace()!=null)
            return " "+nodo.getDato().toString()+mostrar(nodo.getEnlace());
        return " "+nodo.getDato().toString();
    }
    @Override
    public String toString() {
       
        return mostrar(f.getEnlace());
    }
    
    
}
