/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Roly
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conjunto a = new Conjunto(65);
        a.Insertar(31);
        //a.Insertar(5);
        a.Insertar(64);
        a.Insertar(2);
        a.Insertar(45);
        System.out.println("El conjunto A = " + a.Mostrar());

        Conjunto b = new Conjunto(65);
        b.Insertar(4);
        b.Insertar(18);
        b.Insertar(32);
        b.Insertar(64);
        b.Insertar(33);
        b.Insertar(65);
        System.out.println("El conjunto B = " + b.Mostrar());

        Conjunto c = new Conjunto(65);
        c.Union(a, b);
        System.out.println("La union de conjunto es :" + c.Mostrar());

        Conjunto d = new Conjunto(65);
        d.Interseccion(a, b);
        System.out.println("La interseccion de conjunto es :" + d.Mostrar());

    }
}
