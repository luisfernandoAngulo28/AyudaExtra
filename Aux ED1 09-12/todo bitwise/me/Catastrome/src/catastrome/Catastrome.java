/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catastrome;

/**
 *
 * @author iniedu
 */
public class Catastrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Catastro c=new Catastro();
        c.inserCatastro(9, 7, 2, 16, 14, "No", "si", "no");
        c.inserCatastro(15, 4, 6, 5, 8, "si", "si", "no");
        System.out.println(c);
    }
    
}
