package Negocio;


import Negocio.Ficha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iniedu
 */
public class FichaUser2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ficha f=new Ficha();
        f.InsFicha("cj", 1, 'N', 7, 43, 21);
        f.InsFicha("RN", 2, 'D', 8, 0, 0);
        System.out.println(f);
    }
    
}
