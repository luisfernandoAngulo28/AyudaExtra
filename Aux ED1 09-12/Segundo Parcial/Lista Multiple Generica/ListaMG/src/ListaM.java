/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Juan
 */
public class ListaM<Q extends Comparable,T extends Comparable> {
            NodoM lista;
            int cant;
            
       public ListaM()
       {
           lista = null;
           cant = 0;
       }
       
       public void add(Q caracter)
       {
           NodoM<T,Q> a = null;
           NodoM<T,Q> b = lista;
           while ((b != null)&&(b.getDato().compareTo(caracter)<0))
           {
               a = b;
               b = b.getD();
           }
           NodoM aux = new NodoM<T,Q>(caracter);
           if (b == null)
           {
               if (a == null)
               {
                   lista = aux;
                   cant++;
               }else
               {
                   a.setD(aux);
                   cant++;
               }
           }else
           {
               if (b.getDato().compareTo(caracter) != 0)
               if (a == null)
               {
                   aux.setD(b);
                   lista = aux;
                   cant++;
               }else
               {
                   a.setD(aux);
                   aux.setD(b);
                   cant++;
               }
           }
       }
       
       public NodoM<T,Q> buscar(Q caracter)
       {
           NodoM<T,Q> pos = lista;
           while ((pos!=null)&&(pos.getDato().compareTo(caracter) != 0))
           {
               pos = pos.getD();
           }
           return pos;
       }
       
       public void add(Q caracter, T entero)
       {
           this.add(caracter);
           NodoM<T,Q> pos = this.buscar(caracter);
           pos.getA().add(entero);
       }
       
       public String getCadena(Q caracter)
       {
           NodoM<T,Q> pos = this.buscar(caracter);
           return caracter.toString() + " -> " + pos.getA().toString();
       }
       
       public void mostrar()
       {
           NodoM pos = lista;
           while (pos != null)
           {
               Q aux = (Q) pos.getDato();
               System.out.println(this.getCadena(aux));
               pos = pos.getD();
           }
       }
       
       public static void main(String[] args)
       {
           ListaM l = new ListaM<String,Integer>();
           l.add("A",1);
           l.add("A",0);
           l.add("A",4);
           l.add("A",5);
           l.add("B", 3);
           l.add("C");
           l.add("D");
           l.add("D",4);
           l.mostrar();
       }
}
