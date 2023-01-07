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
        CintaCaracter cc = new CintaCaracter();
        cc.setCinta("roly TT");
        cc.elimPalb("tt");
        System.out.println(cc.contarPalb());
        System.out.println(cc.mostrarCinta());
    }
}
