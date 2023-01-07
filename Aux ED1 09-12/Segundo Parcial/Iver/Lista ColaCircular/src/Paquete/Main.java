/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaCircular d=new ListaCircular();
        d.InsertarUl(5);
        d.InsertarUl(8);
        d.InsertarUl(4);
       d.InsertarUl(2);
       //  d.InsertarP(1);
      d.Eliminar(4);
     //  d.Insertar(3);
      //d.Insertar(7);
     // d.Insertar(6);
        // d.Insertar(5);
        //   d.Insertar(2);
     //  d.EliminarUl();
        System.out.println(d.Mostrar());
    }

}
