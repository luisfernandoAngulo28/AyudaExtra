/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcola;

/**
 *
 * @author Juan
 */
public class Nodo {
        Nodo Enlace;
        int Dato;
        
        public Nodo()
        {
            Enlace = null;

        }
        
        public Nodo(int dato)
        {
            Dato = dato;
            Enlace= null;
        }
        
        public void setEnlace(Nodo l)
        {
            this.Enlace=l;
        }
        
        public void setDato(int dato)
        {
            this.Dato = dato;
        }
        
        
        public Nodo getEnlace()
        {
            return Enlace;
        }
        
        
        public int getDato()
        {
            return Dato;
        }
}

