/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Juan
 */
public class Lista<T extends Comparable> {
    
            Nodo lista;
            int cant;
            
       public Lista()
       {
           lista = null;
           cant = 0;
       }
       
       public void add(T dato)
       {
           Nodo<T> a = null;
           Nodo<T> b = lista;
           while ((b!= null )&&(b.getDato().compareTo(dato) < 0))
           {
               a = b;
               b = b.getEnlace();
           }
           Nodo aux = new Nodo(dato);
           if (b == null)
           {
               if (a == null)
               {
                   lista = aux;
                   cant++;
               }else
               {
                   a.setEnlace(aux);
                   cant++;
               }
           }else
           {
               if (b.getDato().compareTo(dato) != 0)
               if (a == null)
               {
                   aux.setEnlace(b);
                   lista = aux;
                   cant++;
               }else
               {
                   a.setEnlace(aux);
                   aux.setEnlace(b);
                   cant++;
               }
           }
       }
       
       public String toString()
       {
           String s = "";
           Nodo p = lista;
           while (p != null)
           {
               s = s + "  " + p.getDato();
               p = p.getEnlace();
           }
           return s;
       }
       
       public static void main(String[] args)
       {
           Lista l = new Lista<Integer>();
           l.add(3);
           l.add(1);
           l.add(6);
           l.add(1);
           l.add(4);
           l.add(6);
           System.out.println(l);
       }
    
}
