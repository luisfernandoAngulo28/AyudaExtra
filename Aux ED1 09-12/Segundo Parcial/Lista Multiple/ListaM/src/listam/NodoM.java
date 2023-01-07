/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listam;

/**
 *
 * @author Juan
 */
public class NodoM {
        char dato;
        NodoM enlaceD;
        Lista enlaceA;
        
        public NodoM()
        {
             dato = 0;
             enlaceD = null;
             enlaceA = new Lista();
        }
        
        public NodoM(char Dato)
        {
            this.dato = Dato;
            enlaceD = null;
            enlaceA = new Lista();
        }
        
        public void setEnlaceD(NodoM enlace)
        {
            this.enlaceD = enlace;
        }
        
        public void setEnlaceA(Lista enlace)
        {
            this.enlaceA = enlace;
        }
        
        public NodoM getEnlaceD()
        {
            return enlaceD;
        }
        
        public Lista getEnlaceA()
        {
            return enlaceA;
        }
        
        public void setDato(char letra)
        {
            this.dato = letra;
        }
        
        public char getDato()
        {
            return dato;
        }
        
}
