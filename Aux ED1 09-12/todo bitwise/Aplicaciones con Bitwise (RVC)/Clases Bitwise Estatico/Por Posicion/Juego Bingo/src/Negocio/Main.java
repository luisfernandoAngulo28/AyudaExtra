/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.Random;

/**
 *
 * @author Roly
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Bingo bing = new Bingo(100,10);
        bing.hacerCarton();
        
        System.out.println(bing.mostrarCartones());
        
        
        System.out.println("Carton Ganador tiene los sgtes nros :"+bing.jugar());
        
        if (bing.Ganador() > -1) {
            System.out.println("El carton ganador es :"+bing.Ganador());
        }else{
           System.out.println("No existe Ganador");  
        }
       

    }
}
