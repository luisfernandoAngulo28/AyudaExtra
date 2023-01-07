/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizer;

import PilaDinamica.PilaDinamica;
import java.util.StringTokenizer;

/**
 *
 * @author Estudiante
 */
public class calculadora {
    
    
    public static void main(String[] args) {
        
        PilaDinamica P = new PilaDinamica();
        String s ="3 - ( 20 * 3 / 5 )";
        StringTokenizer tokens = new StringTokenizer(s, " ");
        int cantidad = tokens.countTokens();
        System.out.println("Cantidad : " + cantidad);
        while(tokens.hasMoreTokens()){
            String dato = tokens.nextToken();
            P.push(dato); 
         ///   System.out.println(dato);
        }
        System.out.println(P.toString());
        
    }
 
}
