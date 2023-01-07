/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listagenerica;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Lista <T extends Comparable<T>> implements Cloneable {
    private Nodo<T> l;
    private int cant;

    public Lista() {
        l=new Nodo<>();
        cant=0;
    }
    private Nodo<T> insertarR(T dato,Nodo<T> p){
        if(p==null){
            cant++;
            return new Nodo<>(dato);
        }
        else
            if(dato.compareTo(p.getDato())==0)
                return p;
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
    
// public String toStr()
// { String cad="L<";
//  Nodo<T> pos=l;
//     for (int i = 1; i <= cant; i++)
//     {
//      cad=cad+pos.getDato()+" , ";
//      pos=pos.getEnlace();
//     }
//     cad=cad+">";
//     return cad;
// }
     
    public void eliminar(T dato){
        l.setEnlace(eliminarR(dato, l.getEnlace()));
    }
    public void insertar(T dato){
        l.setEnlace(insertarR(dato, l.getEnlace()));
    }
// clona el objeto actual
    @Override
    protected Lista<T> clone() throws CloneNotSupportedException {
        return (Lista<T>) super.clone(); //To change body of generated methods, choose Tools | Templates.
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
    
//  public String toString()
// { String cad="L<";
//  Nodo<T> pos=l.getEnlace();
//     for (int i = 1; i <= cant; i++)
//     {
//      cad=cad+pos.getDato()+" , ";
//      pos=pos.getEnlace();
//     }
//     cad=cad+">";
//     return cad;
// }
//    private String mostrarR(Nodo<T> p){
//        if(p!=null){
//            return p.getDato() +" "+mostrarR(p.getEnlace());
//        }
//        return null;
//    }
    @Override
    public String toString() {
        String s="L<";
        try {
            Nodo<T> aux=clone().l.getEnlace();
            for(;aux!=null;aux=aux.getEnlace())
                s+="|"+aux.getDato().toString()+">";
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return s; //To change body of generated methods, choose Tools | Templates.
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
    
    public boolean DosListasIguales(Lista L2)
    {
     return( DosListasIgualesR(this.l.getEnlace(), L2.l.getEnlace()));
    }
    
    private void InvertirenTres(Nodo<T> p)
    {
     if(p==null || p.getEnlace()==null || p.getEnlace()==null)
     {
     //Nada
     }
     else
     {
     T aux =p.getEnlace().getEnlace().getDato();
     p.getEnlace().getEnlace().setDato(p.getDato());
     p.setDato(aux);
     InvertirenTres(p.getEnlace().getEnlace().getEnlace());
     
     }
    }
    
    public void InvertirenTresR()
    {
     InvertirenTres(l.getEnlace());
    }
    
    
    private int Promedio(Nodo <T> p)
    { int pro = 0;
     if(p!=null)
     {
      pro=Promedio(p.getEnlace());
      pro=pro+Integer.valueOf((Integer) p.getDato());
     }
     return pro;
    
    }

    public int promedioR()
    {
     return (Promedio(l.getEnlace()))/cant;
    }
    
    private void Invertir(Nodo <T> p)
    { 
      if((p==null) ||(p.getEnlace()==null))
      {
      //nada
      }
      else if(p.getEnlace().getEnlace()==null)
      {
      l=p.getEnlace();
      p.getEnlace().setEnlace(p);
      p.setEnlace(null);
      }
      else
      {
        Invertir(p.getEnlace());
        p.getEnlace().setEnlace(p);
        p.setEnlace(null);
      }
          
    }
    
    public void InvertirR()
    {
       Invertir(l.getEnlace());
      Nodo<T> x=new Nodo();
        x.setEnlace(l);
        l=x;
    }
    
    
    private Nodo<T> EliminarExtremos(Nodo<T> p)
    {
      if((p==null)||(p.getEnlace()==null))
      {
      return(p.getEnlace());
      }
      else
      {
      p.setEnlace(EliminarExtremos(p.getEnlace()));
      }
        return p;
    }
    
    public void EliminarExtremosR()
    {
    if(l!=null)
    l.setEnlace(EliminarExtremos(l.getEnlace().getEnlace()));
    }
    

    
//        private void EliminarE(Nodo<T> p)
//    {
//      if((p==null)||(p.getEnlace().getEnlace()==null))
//      {
//      p.setEnlace(p.getEnlace().getEnlace());
//      }
//      else
//      {
//      EliminarExtremos(p.getEnlace());
//      }
//    }
//    
//    public void EliminarER()
//    {
//    if(l!=null)
//    l.EliminarER(l.getEnlace().getEnlace());
//    }
    
    
    
    private void InvertirMitadBaja(Nodo<T> p,int c)
    {
       if(p==null || p.getEnlace()==null || p.getEnlace().getEnlace()==null)
       {
       //nada
       }
       else
       {
           if(c==1)
           {
           Nodo<T> aux=l;    
           Invertir(p.getEnlace());
           p.setEnlace(l);
           l=aux;
           }
           else
           {
           InvertirMitadBaja(p.getEnlace(), --c);
           }
       }
       
     
    }
    
    public void InvertirMitadBaja()
    {
    int c=cant/2;
    InvertirMitadBaja(l.getEnlace(), c);
    }
    
    
   public void InvertirMitadAltaR()
   {
   if(l.getEnlace()!=null && l.getEnlace().getEnlace()!=null)
   {
   int c=cant/2;
   InvertirR();
   InvertirMitadBaja();
   InvertirR();
   }
   }
   
   
   public void InvertirMitadesIndependiente()
   {
   InvertirMitadAltaR();
   InvertirMitadBaja();
   }
    
}
