/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plistas;

/**
 *
 * @author Lab-214-21
 */
public class lista { nodo L;
                      int dim;

    public lista() {
        this.L = null;
        this.dim =0;
    }
  private boolean vacia(){
  return (L==null);
    }  
  public void insertar(int dato){
  if (vacia()){
  nodo p=new nodo(dato);
  L=p;
  dim++;
  }
  else{// no esta vacia
  nodo aux=L;
  nodo ant=null;
  while ((aux!=null)&&(aux.getDato()<=dato))
  {  ant=aux;
     aux=aux.getEnlace();
  }
  if (ant==null)//esta al principio
  {  nodo p=new nodo(dato);
     p.setEnlace(aux);
     L=p;
     dim++;
  }
  else{   if (ant.getDato()!=dato)
            { nodo p=new nodo(dato);
              ant.setEnlace(p);
              p.setEnlace(aux);
              dim++;
            }  
       }
      }
}
  
 public void eliminar(int dato){
 if (vacia()){
 System.out.println("Error:: eliminar: la lista esta vacia");
 }
 else{ nodo aux=L;
        nodo ant=null;
        while((aux!=null)&&(aux.getDato()!=dato))
        {   ant=aux;
            aux=aux.getEnlace();
        }
      if (ant==null){
            L=aux.getEnlace();
            dim--;
       }
      else{
           if(aux!=null){
            ant.setEnlace(aux.getEnlace());
           dim--;
           }
      }
 
 }
 
 }
 
 public void insertarSO(int dato){
  if (vacia()){
  nodo p=new nodo(dato);
  L=p;
  dim++;
  }
  else {
      
  nodo aux=L;
  nodo ant=null;
  while (aux!=null)
  {  ant=aux;
     aux=aux.getEnlace();
  }
  nodo p=new nodo(dato);
  ant.setEnlace(p);
  p.setEnlace(aux);
  dim++;
 }
 }
 private float promedioR(nodo P){
 if (P.getEnlace()==null)
     return(P.getDato());
 else{
     float x= promedioR(P.getEnlace());
     x=x+P.getDato();
     if (P==L)
      return(x/dim);
     else
      return(x);   
  }
 }
 public float promedio(){
 return (promedioR(L));
 
 }
private void invertirR(nodo P){
if (P==null)// caso base 1
{// nada}
}
else// caso base 2
{  if (P.getEnlace()==null){
  L=P;
}
else{// caso gral
  invertirR(P.getEnlace());
  P.getEnlace().setEnlace(P);
  P.setEnlace(null);
}

}

} 
public void invertir(){
invertirR(L);

}
 
    @Override
    public String toString() {
        String S="L<";
        nodo p=L;
         while (p!=null)
        { 
           S=S+p.getDato()+" , ";
           p=p.getEnlace();
         }
       
        S=S+">";
        return S;
    }
private int menorR(nodo p){
return p.getDato();

}      
public int Menor()
{
 return(menorR(L));
}

private int mayorR(nodo p){
if (p.getEnlace()==null)
    return(p.getDato());
else{
   int x=mayorR(p.getEnlace());
      return x;
}

}      
public int Mayor()
{
 return(mayorR(L));
}
private int mayorDR(nodo P)
{
if (P.getEnlace()==null)// caso base
    return (P.getDato());
else// caso gral
{ int x=mayorDR(P.getEnlace());
   if (P.getDato()>x)
    return (P.getDato());
   else
         return x;
}

}

public int mayorD(){
return (mayorDR(L));
}
    
}
