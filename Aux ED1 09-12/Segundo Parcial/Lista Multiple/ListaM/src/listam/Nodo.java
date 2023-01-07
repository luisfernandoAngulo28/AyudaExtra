/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listam;

/**
 *
 * @author Juan
 */
public class Nodo {

            int dato;
            Nodo enlace;
            
    public Nodo(int dato)
    {
        this.dato = dato;
        enlace = null;
    }
    
    public void setDato(int dato)
    {
        this.dato = dato;
    }
    
    public void setEnlace(Nodo n)
    {
        this.enlace = n;
    }
    
    public int getDato()
    {
        return dato;
    }
    
    public Nodo getEnlace()
    {
        return enlace;
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
