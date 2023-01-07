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
        PilaBitwise P = new PilaBitwise(10, 21);
        BitWise bw = null;
        P.pushSord(2, 45, 45, "am");
        P.pushSord(8, 32, 25, "pm");
        P.pushSord(7, 31, 60, "am");
        P.pushSord(4, 17, 32, "pm");
        P.pushSord(1, 45, 18, "am");
        P.pushSord(8, 45, 8, "am");
        P.pushSord(1, 60, 33, "pm");
        
        System.out.println(P.Mostrar());

    }
}
