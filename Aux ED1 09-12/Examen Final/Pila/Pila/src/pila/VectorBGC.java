/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

/**
 *
 * @author Juan
 */
public class VectorBGC {
        int dim;
        int V[];
        int cbit;
    
    public VectorBGC(int cbit, int cant)
    {
        dim = -1;
        int x = (cbit*cant)/32;
        if ((cbit*cant) % 32 != 0)
            x++;
        V = new int[x];
        this.cbit = cbit;
    }
    
    public void insertar(int elemento)
    {
        dim++;
        int nroB = nroB(dim);
        int nroE = nroE(dim);
        elemento = elemento + (int)(Math.pow(2, (cbit-1))-1);
        int e2 = elemento;
        elemento = elemento << nroB;
        V[nroE] = V[nroE] | elemento;
        if (nroB + cbit > 32)
        {
            e2 = e2 >>> (32 - nroB);
            V[nroE + 1] = V[nroE + 1] | e2;
        }
    }
    
    private int nroB(int pos)
    {
        return ((pos)*cbit) % 32;
    }
    
    private int nroE(int pos)
    {
        return ((pos)*cbit) / 32;
    }
    
    public int sacar()
    {
        int nroB = nroB(dim);
        int nroE = nroE(dim);
        int e = V[nroE];
        e = e >>> nroB;
        e = e & ((int)Math.pow(2, cbit)-1);
        if (nroB + cbit > 32)
        {
            int e2 = V[nroE + 1];
            e2 = e2 << (32 - nroB);
            e = e | e2;
            e = e & ((int)Math.pow(2, cbit)-1);
        }
        return (e-((int)Math.pow(2, (cbit-1))-1));
    }
    
    public int get(int posicion)
    {
        int nroB = nroB(posicion-1);
        int nroE = nroE(posicion-1);
        int e = V[nroE];
        e = e >>> (nroB);
        e = e & ((int)Math.pow(2, cbit)-1);
        if (nroB + cbit > 32)
        {
            int e2 = V[nroE + 1];
            e2 = e2 << (32 - nroB);
            e = e | e2;
            e = e & ((int)Math.pow(2, cbit)-1);
        }
        return (e-((int)Math.pow(2, (cbit-1))-1));
    }
    
    public void eliminar(int pos)
    {
        int aux = sacar();
        int nroB = nroB(dim);
        int nroE = nroE(dim);
        int mask = (int)Math.pow(2, nroB)-1;
        V[nroE] = V[nroE] & mask;
        if (nroB + cbit > 32)
            V[nroE + 1] = V[nroE + 1] & (int)0;
        dim--;
        if (dim+1 >= pos)
        {
            eliminar(pos);
            insertar(aux);
        }
    }
    
    @Override
    public String toString()
    {
        String s = "";
        for (int i = 0; i <= dim; i++) {
            s = s + "  " + get(i+1);
        }
        return s;
    }
    
    public static void main(String[] args)
    {
        VectorBGC v = new VectorBGC(5,6);
        v.insertar(1);
        v.insertar(3);
        v.insertar(-2);
        v.insertar(12);
        System.out.println(v.toString());
    }
    
}
