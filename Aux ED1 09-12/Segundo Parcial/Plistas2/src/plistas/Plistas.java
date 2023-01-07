/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plistas;

/**
 *
 * @author Lab-214-21
 */
public class Plistas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lista A=new lista();
//        A.insertar(9);
//        A.insertar(1);
//        A.insertar(8);
//        A.insertar(5);
//        A.insertar(8);
//        A.insertar(3);
//        System.out.println(A);
//        A.eliminar(1);
//        A.insertar(4);
//        A.eliminar(15);
//        System.out.println(A);
//        System.out.println("el elemento menor es...");
//        System.out.println(A.Menor());
//        System.out.println("el elemento mayor es...");
//        System.out.println(A.Mayor());
        
        A.insertarSO(2);
         A.insertarSO(7);
          A.insertarSO(4);
           A.insertarSO(9);
            A.insertarSO(1);
//        A.insertarSO(22);
//         A.insertarSO(0);
//          A.insertarSO(14);
//           A.insertarSO(9);
//            A.insertarSO(10);
            
            System.out.println(A);
            
//       System.out.println("el elemento mayor es...");
//         if (A.L!=null)       
////            System.out.println(A.mayorD());
//              System.out.println(A.promedio());
        A.invertir();
        System.out.println(A);
        
    }
}
