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
        ListaD d=new ListaD();
     //   d.InsertarP(5);
     //   d.InsertarP(6);
     //   d.InsertarP(1);
      //  d.InsertarUl(5);
       // d.InsertarUl(6);
      //  d.InsertarUl(7);
        d.Insertar(5);
       d.Insertar(6);
      d.Insertar(7);
      //  d.Insertar(10);
      //  d.Eliminar(7);
        System.out.println(d.Mostar());
    }

}
