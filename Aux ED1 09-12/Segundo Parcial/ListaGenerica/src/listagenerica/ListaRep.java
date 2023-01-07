/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listagenerica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ListaRep <T extends Comparable<T>> implements Cloneable {
    private Nodo<T> l;
    private int cant;

    public ListaRep() {
        l=new Nodo<>();
        cant=0;
    }
    private Nodo<T> insertarR(T dato,Nodo<T> p){
        if(p==null){
            cant++;
            return new Nodo<>(dato);
        }
//        else
//            if(dato.compareTo(p.getDato())==0)   //Para poder insertar repetidos, se comenta esta línea.
//                return p;
            else
            if(dato.compareTo(p.getDato())>0) 
                 p.setEnlace(insertarR(dato, p.getEnlace()));
            
            else{
                cant++;
                T aux=p.getDato();
                p.setDato(dato);
                p.setEnlace(new Nodo<>(aux, p.getEnlace()));
            }
            return p;    
            
    }  
    private Nodo<T> eliminarR(T dato,Nodo<T> p){
        if(p!=null){
            if(dato.compareTo(p.getDato())==0){
                cant--;
                return p.getEnlace();
            }
            else    
                p.setEnlace(eliminarR(dato, p.getEnlace())); 
        }
        return p;
    }
    public void eliminar(T dato){
        l.setEnlace(eliminarR(dato, l.getEnlace()));
    }
    public void insertar(T dato){
        l.setEnlace(insertarR(dato, l.getEnlace()));
    }
// clona el objeto actual
    @Override
    protected ListaRep<T> clone() throws CloneNotSupportedException {
        return (ListaRep<T>) super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    /*
     ()
     1
     1 2
     2 1
     12346
     21
     */
    private void invertir2(Nodo<T> p){
        if(p==null)
            return ;
        else
            if(p.getEnlace()==null)
                return ;
            
            else{
                T aux=p.getDato();
                p.setDato(p.getEnlace().getDato());
                p.getEnlace().setDato(aux);
                invertir2(p.getEnlace().getEnlace());
            }
    }
    
    public void invertir2(){
        if(cant%2==0)
            invertir2(l.getEnlace());
        else
            invertir2(l.getEnlace().getEnlace());
    }
    private String mostrarR(Nodo<T> p){
        if(p!=null){
            return p.getDato() +" "+mostrarR(p.getEnlace());
        }
        return null;
    }
    @Override
    public String toString() {
        String s="L<";
        try {
            Nodo<T> aux=clone().l.getEnlace();
            for(;aux!=null;aux=aux.getEnlace())
                s+="  "+aux.getDato().toString();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ListaRep.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return s+">"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private boolean DosListasIgualesR(Nodo<T> p, Nodo<T> q)
    {
     boolean sw=false;
     if(p==null && q==null)
     {
     return true;
     }
     else if((p==null&&q!=null) || (p!=null&&q==null))
     {
     return false;
     }
     else
     {
        if((p.getDato().compareTo(q.getDato()))==0)
        {          
        sw=DosListasIgualesR(p.getEnlace(), q.getEnlace());
        }
        else
        {
         return false;   
            
        }
       return sw;
     
    }
    }
    
    public boolean DosListasIguales(ListaRep L2)
    {
     return( DosListasIgualesR(this.l.getEnlace(), L2.l.getEnlace()));
    }

    
        private void invertir3(Nodo<T> p){
        if(p==null)
            return ;
        else
            if(p.getEnlace()==null)
                return ;
            
            else{
                T aux=p.getDato();
                //T aux=p.
                p.setDato(p.getEnlace().getDato());
                p.getEnlace().setDato(aux);
                invertir2(p.getEnlace().getEnlace());
            }
    }
        
  
        private int CantidadRep1(Nodo<T> p)
        { int rep=0;
          boolean sw=true;
          T aux = p.getDato();
         while(p.getEnlace()!=null)
         {
             if((p.getDato().compareTo(p.getEnlace().getDato())==0) &&(p.getDato().compareTo(aux))!=0  ||(sw))
            {
            aux=p.getDato();
            rep++;
            sw=false;
            }
 
          p=p.getEnlace();
         }
         return rep;
        }
        
        public int CantidadRep()
        {
        return CantidadRep1(l.getEnlace());
        }
        
        
        private int ContarRep1R(Nodo<T> p)
         { int rep=0;
          T aux=p.getDato();
          boolean sw=true;
          if((p==null) &&(p.getEnlace()==null))
          {
          return rep;
          }
          else if(p.getEnlace().getEnlace()==null)
          {
           if((p.getDato().compareTo(p.getEnlace().getDato())==0) &&(p.getDato().compareTo(aux))!=0  ||(sw))
            {
            aux=p.getDato();
            rep++;
            sw=false;
            }   
          }
          else
          {
          rep=ContarRep1R(p.getEnlace());
          aux=p.getEnlace().getDato();
           if((p.getDato().compareTo(p.getEnlace().getDato())==0)&&(p.getDato().compareTo(aux))!=0 )
            {
            aux=p.getDato();
            rep++;
            sw=false;
            }     
          }
          return rep;          
        }
        
public int ContarRepR()
{
return ContarRep1R(l.getEnlace());
}


private void LlevarEleAlFinal (Nodo <T> p, Nodo<T> q, int pos)
{ int x=1;
  
  if(p==null)
  {
      
  }
  else if((p.getEnlace()==null))
  {
  q.setEnlace(q.getEnlace().getEnlace());
  p.setEnlace(q.getEnlace());
//  q.getEnlace().setEnlace(null);
  }
  else
  {    
    if(x<pos)
    {        
    x++;
    LlevarEleAlFinal(p.getEnlace(), q.getEnlace(), pos);
    }
    else
    {
    LlevarEleAlFinal(p.getEnlace(), q, pos);
    }
  }
}

public void LlevarElefinalC(int pos)
{
LlevarEleAlFinal(l.getEnlace(), l, pos);
}


    private int CantidadDeVeces(Nodo<T> p,T dato)
    { int c=0;
     if(p!=null)
     {

       c=CantidadDeVeces(p.getEnlace(), dato);
       if(dato.compareTo(p.getDato())==0)
           c++;
     }

     return c;
    }

    public int CantidadDeVecesR(T dato)
    {
    return CantidadDeVeces(l.getEnlace(), dato);
    }

    private void HacerUnicos(Nodo<T> p)
    {
     if((p!=null) && (p.getEnlace()!=null))
     {
     HacerUnicos(p.getEnlace());
     if(p.getDato().compareTo(p.getEnlace().getDato())==0)
     {
      p.setEnlace(p.getEnlace().getEnlace());
     }
     }
    }
    
    public void HacerUnicosR()
    {
     HacerUnicos(l.getEnlace());
    }
    
    private Nodo<T> Delete(Nodo<T> p,T dato){
         if(p!=null)
         {
         p.setEnlace(Delete(p.getEnlace(), dato));
         if(dato.compareTo(p.getDato())==0)
             return (p.getEnlace());
         }
         return p;
    }
    public void Delete(T dato){
        l.setEnlace(Delete(l.getEnlace(),dato));
    }
    

}
