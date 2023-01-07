/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Bismarck
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Sparce sp = new Sparce(4, 4, 0);

        sp.SetDato(1, 1, 2);
        sp.SetDato(1, 2, 4);
        sp.SetDato(1, 3, 1);
        sp.SetDato(1, 4, 3);
        
        sp.SetDato(2, 1, 2);
        sp.SetDato(2, 2, 4);
        sp.SetDato(2, 3, 2);
        sp.SetDato(2, 4, 4);
        
        
        sp.SetDato(3, 1, 9);
        sp.SetDato(3, 2, 8);
        sp.SetDato(3, 3, 2);
        sp.SetDato(3, 4, 4);
        
        sp.SetDato(4, 1, 7);
        sp.SetDato(4, 2, 2);
        sp.SetDato(4, 3, 2);
        sp.SetDato(4, 4, 3);

        System.out.println(sp.toString());
        System.out.println(sp.MostrarVD());
        System.out.println(sp.MostrarVP());
        System.out.println(sp.dim);
        
        Sparce A = new Sparce(2, 2);
        
        A.SetDato(1, 1, 2);
        A.SetDato(1, 2, 4);
        A.SetDato(2, 1, 2);
        A.SetDato(2, 2, 4);

       System.out.println(A.toString());
       System.out.println("La submatriz se repite: "+sp.subMatriz(A));
    }
}
