/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Negocio.ListaG;
import Negocio.Registro;
import java.lang.String;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Roly
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        ListaG LR = new ListaG<Registro>();
//        Registro r = new Registro();
//        r.Insertar("Carlos Morales", 4, 21, 10, "Sistemas", 'M');
//        r.Insertar("Roly Vargas Costaleite", 6, 22, 10, "Redes", 'M');
//        r.Insertar("Renato Justo", 1, 19, 10, "Informatica", 'F');
//        r.Insertar("Pedro Gutierrez", 9, 17, 10, "Redes", 'F');
//        r.Insertar("Fernanda Cruz", 8, 24, 10, "Sistemas", 'F');
//        r.Insertar("Ernesto Garcia", 3, 24, 3, "Redes", 'F');
//        r.Insertar("Leonela", 49, 17, 10, "Sistemas", 'F');
//        r.Insertar("Jose", 50, 22, 10, "Sistemas", 'M');
//        r.Insertar("junior", 48, 22, 1, "Redes", 'M');
////      r.Eliminar(10);
//
//        System.out.println(r.Mostrar());
//        System.out.println(r.Dim);
//        System.out.println(r.bw.Dim);

        System.out.println("=====================");

        Fecha f = new Fecha(10);  
       f.setFecha(02, 05, 9);
        
        System.out.println(f.Mostrar());

    }
}
