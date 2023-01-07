/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotdagenericos;

/**
 *
 * @author Usuario
 */
class PilaGenerica <tipo> 
{
    Object p[];
    int tope;
    
 public PilaGenerica(int dim)
 {
  tope=-1;
  p=new Object[dim];
 }
 
 public void push(tipo x)
 {
  if(llena())
  {
      System.out.println("Error, pila llena");
  }
  else
  {
      tope++;
      p[tope]=x;
  }
 }
 
 public Object pop()
 {
 tope--;
 return(p[tope+1]);
 }
 
 private boolean llena()
 {
 return(tope==p.length-1);
 }
 
 private boolean vacia()
 {
 return(tope==-1);
 }
 
 

 
}
