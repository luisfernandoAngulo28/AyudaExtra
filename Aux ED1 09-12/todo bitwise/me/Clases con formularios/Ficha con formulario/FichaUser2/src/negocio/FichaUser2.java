package negocio;


import negocio.Ficha;

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
        f.InsFicha("CJ", 1, "NM");
        f.InsFicha("Rn", 2, "3ra");
        System.out.println(f);
       
        System.out.println(f.ver(1));
    }
    
}
