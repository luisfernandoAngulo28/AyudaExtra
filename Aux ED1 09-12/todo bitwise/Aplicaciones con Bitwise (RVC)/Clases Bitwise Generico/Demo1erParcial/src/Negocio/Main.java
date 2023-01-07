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
    public static void main(String[] args) throws Exception {
        PilaPrioridad p = new PilaPrioridad(8);

        /*p.pushDato(2, 1);
        p.pushDato(1, 3);
        p.pushDato(7, 1);
        p.pushDato(8, 2);
        p.pushDato(2, 3);*/

        p.pushDato(3, 2);
        p.pushDato(1, 3);
        p.pushDato(4, 3);
        p.pushDato(8, 2);
        p.pushDato(1, 2);
        p.pushDato(0, 3);
        p.pushDato(3, 1);
        p.pushDato(5, 1);

        System.out.println(p.Mostrar());
    }
}
