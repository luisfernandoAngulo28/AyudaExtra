/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listasc;

/**
 *
 * @author Juan
 */
public class ListasC {

            NodoC v[];
            int cant;
            int prim;
            
    public ListasC()
    {
        v = new NodoC[100];
        cant = 0;
        prim = -1;
    }
    
    public void insertar(int dato)
    {
        NodoC aux = new NodoC(dato);
        if (aux != null)
        {
            if (prim == -1)
            {
                v[0] = aux;
                prim = 0;
            }else
            {
                int pos = buscar(dato);
                int pos2 = buscarVacio();
                int x = v[pos].getEnlace();
                v[x].setEnlace(-2);
                v[pos].setEnlace(pos2);
                v[pos2] = aux;
            }
            cant++;
        }
    }
    
    public int buscar(int ele)
    {
        int t = -1;
        int u = prim;
        while ((u != -1)&&(v[u].getDato() < ele))
        {
            t = u;
            u = v[u].getEnlace();
        }
        return t;
    }
    
    public int buscarVacio()
    {
        int pos = prim;
        while ((pos != -1)&&(v[pos].getEnlace() != -2))
        {
            pos = v[pos].getEnlace();
        }
        return pos;
    }
    
    public void eliminar(int elemento)
    {
        int pos = buscar(elemento);
        int pos2 = v[v[pos].getEnlace()].getEnlace();
        v[v[pos].getEnlace()].setEnlace(-2);
        v[pos].setEnlace(pos2);
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
