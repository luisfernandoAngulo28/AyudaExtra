/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author HP
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        BitWise vG = new BitWise(10, 0, 31);
        vG.setDato(1, 11);
        vG.setDato(4, 11);

        System.out.println(vG.toString());
    }
}
