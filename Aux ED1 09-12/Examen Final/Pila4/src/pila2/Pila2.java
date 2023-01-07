/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pila2;

/**
 *
 * @author PC
 */
public class Pila2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        pila p=new pila(5,3);
        p.push(5);
        p.push(4);
        p.push(3);
        p.push(2);
        p.push(1);
        System.out.println(p.toString());
    }
}
