/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

/**
 *
 * @author PC
 */
public class Pila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
mipila p= new mipila(7);
        p.push(5);
        p.push(4);
        p.push(3);
        p.push(2);
        p.push(1);
        //System.out.println();
       
        int may=5; int men=1;
        
        p.maymen(may, men);
        System.out.println(may+" -- "+men); 
    }
}
