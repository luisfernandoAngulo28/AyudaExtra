/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete;

/**
 *
 * @author itachi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista1 d=new Lista1();
       /* d.InsertarP(5);
         d.InsertarP(7);
          d.InsertarP(9);*/
        /*d.InsertarUl(8);
        d.InsertarUl(7);
        d.InsertarUl(4);*/
      d.InsertarUl(5);
        d.InsertarUl(8);
      d.InsertarUl(10);
       //   d.InsertarUl(1);
      // d.Eliminar(6);
       // d.Ordenar();
       //   d.Invertir();
       d.Insertar(11);
        System.out.println(d.MostrarLista());

    }

}
