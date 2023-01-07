/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listasc;

/**
 *
 * @author Juan
 */
public class NodoC {
        int dato;
        int enlace;
        
    public NodoC()
    {
        enlace = -1;
    }
    
    public NodoC(int dato)
    {
        enlace = -1;
        this.dato = dato;
    }
    
    public void setDato(int dato)
    {
        this.dato = dato;
    }
    
    public void setEnlace(int enlace)
    {
        this.enlace = enlace;
    }
    
    public int getDato()
    {
        return dato;
    }
    
    public int getEnlace()
    {
        return enlace;
    }
}
