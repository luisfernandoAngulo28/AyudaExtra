/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Lab-214-21
 */
public class Main {
     public static void main(String [] args){
VectorSolicitud Vs=new VectorSolicitud(50);
Vs.SetDAtos(new SolicitudCliente(1001,25,(float)1.8, 50),
   new SolicitudAnalisis(0,1,1,1,0,0,1,100,50));
Vs.SetDAtos(new SolicitudCliente(1111,45,(float)2.3,60),
        new SolicitudAnalisis(0,0,0,1,0,0,1,110,65));
Vs.SetDAtos(new SolicitudCliente(1250,80,(float)1.5,40),
        new SolicitudAnalisis(1,1,1,1,1,1,1,100,75));        


System.out.println(Vs.toString());        
         
         
     }
}