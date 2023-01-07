/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listagenerica.pruebas;

import listagenerica.Cola;
import listagenerica.Lista;
import listagenerica.ListaDoble;
import listagenerica.NodoDoble;

/**
 *
 * @author Usuario
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    // 8 5 1 6  a=8
    // 5 1 6  a=5
    // 1 6  a=1
    // 6  a=6
    // 6 1 5 8  m=1
    // 8 5 4  9 
    // 5 4 9 8
    // 4 9 8 5
    // 9 8 5
    public void decolaMenor(Cola<Integer> cc, int m) throws Exception {
        if (!cc.vacio() && cc.getPrimero().compareTo(m) != 0) {
            cc.encolar(cc.getDecolar());
            decolaMenor(cc, m);
            return;
        } else if (cc.getPrimero().compareTo(m) == 0) {
            cc.decolar();
        }
    }

    public int menor(Cola<Integer> cc) throws Exception {
        if (!cc.vacio()) {
            int a = cc.getDecolar();
            int b = menor(cc);
            int m;
            if (a < b) {
                m = a;
            } else {
                m = b;
            }
            // if(m!=a)
            cc.encolar(a);
            return m;
        }
        return Integer.MAX_VALUE;
    }

    public void ordena(Cola<Integer> a, Cola<Integer> b) throws Exception {
        while (!a.vacio()) {
            int menor = menor(a);
            decolaMenor(a, menor);
            b.encolar(menor);
        }
        a = b;
    }

    public static void main(String[] args) throws Exception {
//        // TODO code application logic here
//        Lista<Integer> lista1=new Lista<>();
//        Lista<Integer> lista2=new Lista<>();
//        lista1.insertar(1);
//        lista1.insertar(2);
//        lista1.insertar(3);
//        lista1.insertar(4);
//        
//        lista2.insertar(1);
//        lista2.insertar(2);
//        lista2.insertar(3);
//        lista2.insertar(4);
//        
//        if(lista1.DosListasIguales(lista2)==true)
//        {
//        System.out.println("Ok");
//        }
//        else
//        {
//        System.out.println("Nop");
//        }

        //  8 9 5   4  
        // 9 5 4 8
        // 5 4 8 9  5
        // 4 8 9 

        //  9 5 8
        //  5 8 9   5
        //  4 5 8 9
//        
//        Cola<Integer> c=new Cola<>();
//        c.encolar(1);
//        c.encolar(6);
//        c.encolar(0);
//        c.encolar(5);
//        c.encolar(3); 
//       
//        
//        (new  Prueba()).ordena(c, new Cola<Integer>());
//       // Prueba pp=new Prueba();
//        
//        System.out.println(c);
//        c.burbuja();
//        System.out.println(c);
//        
//        int a=c.getDecolar();
//        
//        ListaRep<Integer> l= new ListaRep<>();
//        l.insertar(1);
//        l.insertar(2);
//        l.insertar(3);
//        l.insertar(2);
//        l.insertar(2);
//        l.insertar(2);
//        System.out.println(l.CantidadDeVecesR(2));
//        System.out.println(l.toString());

//  Lista<Integer> lista= new Lista<>();
//  lista.insertar(1);
//  lista.insertar(2);
//  lista.insertar(3);
//  lista.insertar(4);
//  lista.InvertirR();
//  //lista.InvertirR();
//   System.out.println(lista.toString());
//  lista.insertar(4);
//  lista.insertar(5);
//  lista.insertar(6);
        //lista.CantidadDeVecesR(2);
        // lista.InvertirenTresR();
        //  System.out.println(lista);
        //     System.out.println(lista.toString());

//        
//   ColaSimple c = new ColaSimple(5);
//   c.Encolar(1);
//   c.Encolar(2);
//   c.Encolar(3);
//   c.Encolar(4);
//   c.Encolar(5);
//   c.InvertirMitadR();
//   
//   
//   //c.HacerUnicos();
//        System.out.println(c.toString());
//        
//        ListaRep<Integer> l=new ListaRep<>();
//        l.insertar(5);
//        l.insertar(4);
//        l.insertar(3);
//        l.insertar(5);
//        l.insertar(4);
//        l.insertar(2);
//     //   l.HacerUnicosR();
//
//        System.out.println(l.toString());
        
//        ListaRepDesor<Integer> l = new ListaRepDesor<>();
//        l.insertar(1);
//        l.insertar(2);
//        l.insertar(3);
//        l.insertar(4);
//        l.insertar(3);
//        l.insertar(2);
////        l.insertar(4);
////        l.insertar(3);
//        //l.insertar(2);
//        System.out.println(l);
//        l.EliminarRepetidoR();
//        System.out.println(l);
        
        Lista<Integer> l=new Lista<>();
        l.insertar(0);
        l.insertar(2);
        l.insertar(3);
        l.insertar(4);
        System.out.println(l);
      // l.InvertirMitadAltaR();
//        l.InvertirMitadesIndependiente();
//        System.out.println(l);
        
//        ListaDoble<Integer> lista=new ListaDoble<>();
//        lista.insertar(1);
//        lista.insertar(0);
//        lista.insertar(14);
//        lista.insertar(15);
//        //lista.invertir();
//        System.out.println(lista);
    }
}
