/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iniedu
 */
public class FichaUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ficha f=new Ficha();
        f.Inserficha("RN", 10, 'N');
        f.Inserficha("CJ", 3, '3');
        f.Inserficha("PF", 1, 'D');
        System.out.println(f);
    }
    
}
