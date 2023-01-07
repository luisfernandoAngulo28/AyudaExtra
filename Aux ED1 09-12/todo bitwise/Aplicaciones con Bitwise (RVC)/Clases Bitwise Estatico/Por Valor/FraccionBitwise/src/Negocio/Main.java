/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Roly
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       fraccion f = new fraccion(5);
       f.insertar(3, 2, 1);
       f.insertar(4, 2, 1);
       f.insertar(8, 4, 0);
        System.out.println(f.Mostrar());
       
    }
}
