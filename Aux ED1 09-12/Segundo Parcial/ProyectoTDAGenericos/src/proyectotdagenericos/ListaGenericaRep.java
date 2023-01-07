/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotdagenericos;

/**
 *
 * @author Usuario
 */
class ListaGenericaRep <Tipo extends Comparable> {
    NodoS<Tipo> L;
    int cant;
    
 public ListaGenericaRep()
 {
 L=null; //Referencia nula
 cant=0;
 }
 
 public boolean vacia()
 {
 return(L==null);
 }
 
 public void Insertar(Tipo ele)
 {
  if(vacia())
  {
   NodoS<Tipo> p= new NodoS<Tipo>();
   p.SetDato(ele);
   L=p;
   cant++;
  }
  else //No está vacía
  {
  NodoS<Tipo> ant=null;
  NodoS<Tipo> pos=L;
/*-----*/
     while(((pos!=null) && (pos.Getdato().compareTo(ele)<=0)))
     {
     ant=pos;
     pos=pos.Getenlace();
     }
     
     if(ant==null)
     {
     NodoS<Tipo> p=new NodoS<Tipo>(ele);
     p.SetEnlace(L);
     L=p;
     cant++;
     }
     else  if(ant.Getdato().compareTo(ele)!=0)//Inserta al medio o al final
     {
     NodoS<Tipo> P=new NodoS<Tipo>(ele);
     ant.SetEnlace(P);
     P.SetEnlace(pos);
     cant++;
     }
  }
 }
 
 public void Eliminar(Tipo ele)
 {
  if(vacia())
  {
  //nada
  }
  else
  {
  NodoS<Tipo> ant=null;
  NodoS<Tipo> pos=L;
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
  NodoS<Tipo> pos=L;
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
 
 private void InvertirR(NodoS<Tipo> p)
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
 
 
 public Tipo Mayor()
 {
  return(MayorR(L));
 }

 private Tipo MayorR(NodoS<Tipo> p)
 {   Tipo may=null;
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
 
 private void IntercambiarPFR(NodoS <Tipo> p)
 { NodoS<Tipo> ant=L;
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
 
 private void InvertitDosenDosR(NodoS<Tipo>p)
 { NodoS<Tipo> ant=p;
  if(p==null || p.Getenlace()==null)
  {
  //Nada
  }
  else if(p.Getenlace().Getenlace()==null)
  {
  L=p.Getenlace();
  p.Getenlace().SetEnlace(p);
  p.SetEnlace(ant);
  
  }
  else 
  {
      InvertitDosenDosR(p.Getenlace());
      p.Getenlace();
      p.Getenlace().SetEnlace(p);
      p.SetEnlace(ant);
  }

      
 }
 
 
 
 }
 
    

