/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

/**
 *
 * @author Juan
 */
public class Pila {

            Nodo cima;
            int cant;
            
    public Pila()
    {
        cima = null;
        cant = 0;
    }
    
    public void push(int e)
    {
        Nodo aux = new Nodo(e);
        if (aux != null)
        {
            aux.setEnlace(cima);
            cima = aux;
            cant++;
        }else
            System.out.println("Error: La memoria de la computadora esta llena");
    }
    
    public int pop(boolean sw)
    {
        int x = 0;
        sw = !vacia();
        if ( sw )
        {
            x = cima.getDato();
            cima = cima.getEnlace();
            cant--;
        }else
            System.out.println("Error: la pila esta vacia");
        return x;
    }
    
    public boolean vacia()
    {
        return (cant==0);
    }
    
    public int get(boolean sw)
    {
        int x = 0;
        sw = !vacia();
        if ( sw )
            x = cima.getDato();
        else
            System.out.println("Error: la pila esta vacia");
        return x;
    }
    
    @Override
    public String toString()
    {
        String s = "";
        Nodo aux = cima;
        for (int i = 0; i < cant; i++) {
            s = s + "  " + aux.getDato();
            aux = aux.getEnlace();
        }
        return s;
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
