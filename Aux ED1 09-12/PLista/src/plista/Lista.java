/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plista;

/**
 *
 * @author Lab-214-21
 */
public class Lista {  Nodo L;
                       int dim;
public Lista()
{  this.L= null;
    this.dim=0;

}
private boolean vacia(){ 
    return (L==null);
}        
public void insertar (int dato)
{
    if (vacia()) {
        Nodo p=new Nodo(dato);
        L=p;
        dim++;
    }else{    // NO ESTA VACIA
        Nodo aux=L;
        Nodo ant=null;
        while((aux!=null)&&(ant.getDato()!=dato))
        {
            ant=aux;
            aux=aux.getEnlace();
        }
        if(ant==null)   //ESTA AL PRINCIPIO
        {  Nodo p=new Nodo(dato);
            p.setEnlace(L);
            L=p;
            dim++;
        }
        if (ant.getDato()!=dato){
            Nodo p=new Nodo(dato);
            ant.setEnlace(p);
            p.setEnlace(aux);
            dim++;
            
        }
    }
}
public void eliminar(int dato){
    if (vacia()){
        System.out.println("Error:: eliminar: la ");
    }else{
    Nodo aux=L;
    Nodo ant=null;
     while((aux!=null)&&(aux.getDato()!=dato)){
         ant=aux;
         aux=aux.getEnlace();
     }
     if(ant==null){   // al principio
         L=aux.getEnlace();
         dim--;
     }else{
         if (aux!=null){  
             ant.setEnlace(aux.getEnlace());
             dim--;
         }
     }
    }
}     

    @Override
    public String toString() {
        String S="L<";
        Nodo p=L;
      
        for(int i=2;i<=dim;i++){
            S=S+p.getDato()+ ",";
            p=p.getEnlace();
       }
        
        S=S+'>';
        return S;
     }
 
 private int menorR(Nodo p)
 {
     return p.getDato();
 }
    
    
    public int menor()
 {
     return(menorR(L));
 }
   
}