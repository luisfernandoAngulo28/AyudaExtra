package proyectotdagenericos;
/**
 *
 * @author Usuario
 */
class NodoS <T>
{
  T dato;
  NodoS enlace;
  
  public NodoS()
  {
  dato=null;  //Referencia nula
  enlace=null; //referencia nula
  }
  
  public NodoS(T ele)//Sobrecarga
  {
  dato=ele;
  enlace=null;
  }
  
  public void SetDato(T ele)
  {
  dato=ele;
  }
  
  public void SetEnlace(NodoS p)
  {
  enlace=p;
  }
  
  public T Getdato()
  {
  return(dato);
  }
  
  public NodoS<T> Getenlace()
  {
  return(enlace);
  }
}
