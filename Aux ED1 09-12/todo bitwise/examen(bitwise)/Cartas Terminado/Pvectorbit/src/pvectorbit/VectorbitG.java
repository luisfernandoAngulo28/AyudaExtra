/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pvectorbit;

/**
 *
 * @author Lab-214-21
 */
public class VectorbitG {    int V[]; // vector de bits
        int dim;
        int cbit;
        
    
    public VectorbitG(int cantEle, int cbit){ /// dimension, cant bits
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
            int nb = nroBit(pos);
            int ne = nroEnt(pos);
            int e2 = e;
            int mask = (int)Math.pow(2, cbit)-1;
            mask = mask << nb;
            mask = ~ mask;
            V[ne] = V[ne] & mask;// borra los elementos
            e = e << nb;
            V[ne] = V[ne] | e;
            if (nb + cbit > 32)
            {
                mask = (int)Math.pow(2, cbit)-1;
                mask = mask >>> (32 - nb);
                V[ne + 1] = V[ne + 1] & mask;//borro
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
    {   
            int nb = nroBit(pos);
            int ne = nroEnt(pos);
            int e = V[ne];
            int mask = (int)Math.pow(2, cbit)-1;
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
      
   
    
    @Override
    public String toString()
    {
       String s ="   El Vector es V=[";
        for (int i = 1; i <= dim; i++) {
            s = s + getE(i)+" , ";
        }
       s=s+"]";
       return s;
    }

   
    
   

    
    
}
