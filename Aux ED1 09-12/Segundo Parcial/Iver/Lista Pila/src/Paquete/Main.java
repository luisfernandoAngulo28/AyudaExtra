/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete;

/**
 *
 * @author itachi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pila f=new Pila();
      //  f.PushOrd(5);
       // f.PushOrd(7);
       // f.PushOrd(6);
       // f.PushOrd(10);
        f.Push(5);
        f.Push(7);
        f.Push(10);
        System.out.println(f.Pop());
        System.out.println(f.Mostrar());
    }

}
