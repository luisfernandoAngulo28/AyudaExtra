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
        SparceBit sp = new SparceBit(4, 4, 0, 0, 50);
        int i = 1;
        while (i <= sp.nF) {
            int j = 1;
            while (j <= sp.nC) {
                sp.setDato(i, j, i+j);
                j++;
            }
            i++;
        }
        sp.setDato(4, 4, 0);
        System.out.println(sp.mostrarMatriz());
        System.out.println(sp.mostrarVD());
        System.out.println(sp.mostrarVP());
    }
}
