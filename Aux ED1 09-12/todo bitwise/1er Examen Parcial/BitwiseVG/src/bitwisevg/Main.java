/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwisevg;

/**
 *
 * @author Gabo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BitwiseVGChar C = new BitwiseVGChar(29,5);
        String Cadena = "año viejo.";
         
        C.InsertarCadena(Cadena);
        System.out.println(C.GetCadena());
      
    }
}
