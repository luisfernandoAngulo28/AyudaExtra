/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vectorbitg;

/**
 ** Ayudantia 2/2016 Aux ED1 Eddy
 */
public class VectorBG {

        int V[];
        int dim;
        int cbit;
        
    
    public VectorBG(int cantEle, int cbit){
        int x = cantEle*cbit/32;
        if (cantEle*cbit%32 != 0)
            x++;
        V = new int[x];
        this.cbit = cbit;
        this.dim = cantEle;
    }
    
    public void insertarE(int e, int pos)
    {
        if (pos <= dim)
        {
            int nb = nroBit(pos), ne = nroEnt(pos);
            int e2 = e, mask = (int)Math.pow(2, cbit)-1;
            mask = mask << nb;
            mask = ~ mask;
            V[ne] = V[ne] & mask;
            e = e << nb;
            V[ne] = V[ne] | e;
            if (nb + cbit > 32)
            {
                mask = (int)Math.pow(2, cbit)-1;
                mask = mask >>> (32 - nb);
                V[ne + 1] = V[ne + 1] & mask;
                e2 = e2 >>> (32 - nb);
                V[ne + 1] = V[ne + 1] | e2;
            }
        } // fin del if
    }
    
    public int nroBit(int pos)
    {
        return ((pos-1) * cbit) % 32;
    }
    
    public int nroEnt(int pos)
    {
        return ((pos-1) * cbit) / 32;
    }
    
    public int getE(int pos)
    {   if (pos <= dim)
        {
            int nb = nroBit(pos), ne = nroEnt(pos);
            int e = V[ne], mask = (int)Math.pow(2, cbit)-1;
            e = e >>> nb;
            if (nb + cbit > 32)
            {
                int e2 = V[ne +1];
                e2 = e2 << (32 - nb);
                e = e | e2;
            }
            e = e & mask;
            return e;
        }
        System.out.println("ERROR: posicion fuera de rango");
        return 0;
    }
    
    @Override
    public String toString()
    {
       String s = "V{";
        for (int i = 1; i < dim; i++) {
            s = s + getE(i)+ " , " ;
        }
       s = s + getE(dim)+"}" ;
       return s;
    }
    
    public void ampliar(int cant)
    {
        int x = ((dim + cant)*cbit)/32;
        if (((dim + cant)*cbit)%32 != 0)
            x++;
        int aux[] = new int[x];
        System.arraycopy(V, 0, aux, 0, dim-1);
        V = new int[x];
        System.arraycopy(aux, 0, V, 0, dim-1);
        dim = dim + cant;
    }
    
    public static void main(String[] args) {
        VectorBG a = new VectorBG(5,32);
        a.insertarE(31, 1);
        a.insertarE(132, 2);
        a.insertarE(11111, 3);
        a.insertarE(63, 4);
        a.insertarE(654544, 5);
        a.ampliar(10);
        a.insertarE(2, 6);
        a.insertarE(20, 8);
        
        System.out.println(a.toString());
    }
}
