/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

/**
 *
 * @author Gabo (Gabriel Martínez Ayala 13/10/2013)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pila P = new Pila(3);
        Pila P2 = new Pila(3);
    
       

        
        P.push(8);
        P.push(6);
        P.push(1);
        
        P2.push(1);
        P2.push(6);
        P2.push(8);
        
                  
        
        if (P.simetrico(P2)==true){
            System.out.println("Las pilas son simétricas entre si");
                    }
                   
        while (P.Tope > -1)
            System.out.println(P.pop());
        while (P2.Tope > -1)
            System.out.println(P2.pop());
        

 
        
try{
	System.out.println(P.pop());

}catch(Exception e){
	System.out.println("Pila vacía");
} 
    
        
    }
}
