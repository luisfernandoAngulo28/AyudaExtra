/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listam;

/**
 *
 * @author Juan
 */
public class ListaM {

            NodoM lista;
            int cant;
            
    public ListaM()
    {
        lista = null;
        cant = 0;
    }
    
    public void insertarLetra(char letra)
    {
        NodoM b = lista;
        NodoM a = null;
        while ((b != null)&&(b.getDato() <= letra))
        {
            a = b;
            b = b.getEnlaceD();
        }
        NodoM aux = new NodoM(letra);
        if (b == null)
        {
            if (a != null)
                a.setEnlaceD(aux);
            else
                lista = aux;
        }else
            if (b.getDato() != letra)
            {
                aux.setEnlaceD(b);
                if (a == null)
                    lista = aux;
                else
                    a.setEnlaceD(aux);
            }else
                cant--;
        cant++;
    }
    
    public void insertarNumero(int nro, char letra)
    {
        this.insertarLetra(letra);
        NodoM pos = buscarLetra(letra);
        pos.getEnlaceA().insertar(nro);
    }
    
    public char getLetra(int pos)
    {
        if (pos <= cant)
        {
            NodoM aux = lista;
            while ((aux != null)&&(pos > 1))
                aux = aux.getEnlaceD();
            if (aux != null)
                return aux.getDato();
            return '0';
        }
        return 0;
    }
    
    public String toString()
    {
        String s = "";
        NodoM aux = lista;
        while (aux != null)
        {
            s = s + " -> " + aux.getDato();
            aux = aux.getEnlaceD();
        }
        return s;
    }
    
    public String toStringLetra(char letra)
    {
        NodoM pos = buscarLetra(letra);
        return letra + " -> " + pos.getEnlaceA().toString();
    }
    
    private NodoM buscarLetra(char letra) {
        NodoM pos = lista;
        while ((pos != null) && (pos.getDato() != letra ))
            pos = pos.getEnlaceD();
        return pos;
    }
    
    public static void main(String[] args) {
           ListaM a = new ListaM();
           a.insertarLetra('A');
           a.insertarLetra('B');
           a.insertarLetra('C');
           a.insertarNumero(1, 'D');
           a.insertarLetra('E');
           a.insertarLetra('F');
           a.insertarLetra('G');
           System.out.println(a.toStringLetra('D'));
    }

}
