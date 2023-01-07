/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotdagenericos;

/**
 *
 * @author Usuario
 */
class ListaGenerica <T extends Comparable<T>> {
    NodoS<T> L;
    int cant;
    
 public ListaGenerica()
 {
 L=null; //Referencia nula
 cant=0;
 }
 
 public boolean vacia()
 {
 return(L==null);
 }
 
 public void Insertar(T ele)
 {
  if(vacia())
  {
   NodoS<T> p= new NodoS<T>();
   p.SetDato(ele);
   L=p;
   cant++;
  }
  else //No está vacía
  {
  NodoS<T> ant=null;
  NodoS<T> pos=L;
/*-----*/
     while(((pos!=null) && (pos.Getdato().compareTo(ele)<=0)))
     {
     ant=pos;
     pos=pos.Getenlace();
     }
     
     if(ant==null)
     {
     NodoS<T> p=new NodoS<T>(ele);
     p.SetEnlace(L);
     L=p;
     cant++;
     }
     else  if(ant.Getdato().compareTo(ele)!=0)//Inserta al medio o al final
     {
     NodoS<T> P=new NodoS<T>(ele);
     ant.SetEnlace(P);
     P.SetEnlace(pos);
     cant++;
     }
  }
 }
 
 public void Eliminar(T ele)
 {
  if(vacia())
  {
  //nada
  }
  else
  {
  NodoS<T> ant=null;
  NodoS<T> pos=L;
        while(pos!=null && pos.Getdato().compareTo(ele)!=0)
        {
        ant=pos;
        pos=pos.Getenlace();
            if(ant==null)
            {
            L=pos.Getenlace();
            cant--;
            }
            else if(pos!=null)
            {
            ant.SetEnlace(pos.Getenlace());
            cant--;
            }
        }
  }
 }
 
/* public int compareTo (Object x)
 {
  if(this==x)
  {
  return(0);
  }
  else if(this==x)
  {
  return(1);
  }
 }*/
 @Override
 public String toString()
 { String cad="L<";
  NodoS<T> pos=L;
     for (int i = 1; i <= cant; i++)
     {
      cad=cad+pos.Getdato()+" , ";
      pos=pos.Getenlace();
     }
     cad=cad+">";
     return cad;
 }
 
  //----------Métodos elementales-------------//
 public void Invertir()
 {
 //Máscara
 InvertirR(L);
 }
 
 private void InvertirR(NodoS<T> p)
 {
    
 if(p==null)
 {
 //Nada
 }
 else
 if(p.Getenlace()==null)
 {
 //nada
 }
 else if(p.Getenlace().Getenlace()==null)
 {
  L=p.Getenlace();
  p.Getenlace().SetEnlace(p);
  p.SetEnlace(null);
 }
 else
 {
 InvertirR(p.Getenlace());
 p.Getenlace().SetEnlace(p);
 p.SetEnlace(null);
 }
 }
 
 
 public T Mayor()
 {
  return(MayorR(L));
 }

 private T MayorR(NodoS<T> p)
 {   T may=null;
     if(p==null)
     {
     //nada
     }
    else if(p.Getenlace()==null)
    {
        may=p.Getdato();
    }
    else
    {
        may=MayorR(p.Getenlace());
    }
     return may;
 }
 
 public void IntercambiarPF()
 {
  IntercambiarPFR(L);
 }
 
 private void IntercambiarPFR(NodoS <T> p)
 { NodoS<T> ant=L;
  if(p==null || p.Getenlace()==null)
  {
      //nada
  }
  else if(p.Getenlace().Getenlace()==null)
  {
   L=p.Getenlace();
   p.Getenlace().SetEnlace(p);
   p=null;
  }
  else if(p.Getenlace().Getenlace().Getenlace()==null)
  {
   L=p.Getenlace().Getenlace();
   p.Getenlace().Getenlace().SetEnlace(ant.Getenlace());
   p.Getenlace().SetEnlace(ant);
   ant.SetEnlace(null);
  }  
  else
  {
   IntercambiarPFR(p.Getenlace());
  }
 }
 
 public void InvertitDosenDos()
 {
 InvertitDosenDosR(L);
 }
 
 private void InvertitDosenDosR(NodoS<T>p)
 { 
     if(p!=null && p.Getenlace()!=null)
     {
     InvertitDosenDosR(p.Getenlace().Getenlace());
      T aux= p.Getenlace().Getdato();
      p.Getenlace().SetDato(p.Getdato());
      p.SetDato(aux);
      
     }   
 }
 
//    private NodoS<T> eliminarR(T dato,NodoS<T> p){
//        if(p!=null){
//            if(dato.compareTo(p.Getdato())==0){
//                cant--;
//                return p.Getenlace();
//            }
//            else    
//                p.SetEnlace(eliminarR(dato, p.Getenlace())); 
//        }
//        return p;
//    }
//    
// 
// public void EliminarRe(T dato)
// {
//    L.SetEnlace(eliminarR(dato, L));
// }
 
 
 
 
 
 }
 
    

