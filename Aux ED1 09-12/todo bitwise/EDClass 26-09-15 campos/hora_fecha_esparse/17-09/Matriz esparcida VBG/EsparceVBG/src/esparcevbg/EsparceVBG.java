/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esparcevbg;

import vectorbitg.VectorBG;

/**
 *
 * Ayudantia 2/2016 Aux ED1 Eddy
 */
public class EsparceVBG {
    
        float VD[];
        VectorBG VFC;
        int dim;
        int m; //nro de filas
        int n; //nro de columnas
        int ed;

    public EsparceVBG(int nroF, int nroC, int ed)
    {
        VD = new float[10];
        VFC = new VectorBG((int)10,(int)10);
        dim = -1;
        m = nroF;
        n = nroC;
        this.ed = ed;
    }
    
    public void insertarE(int e, int f, int c)
    {
        if ((f >= 0)&&(c >= 0)&&(f < m)&&(c < n))
        {
            if (e != ed)
            {
                if (dim % 10 == 0)
                {
                    VFC.ampliar(10);
                    int aux[] = new int[dim + 10];
                    System.arraycopy(VD, 0, aux, 0, dim);
                    VD = new float[dim + 10];
                    System.arraycopy(aux, 0, VD, 0, dim);
                }
                dim++;
                VD[dim] = e;
                VFC.insertarE(n*(f-1) + c, dim);
            }else
            {
                int i = 0;
                int pos = n*(f-1) + c;
                while ((i < dim)&&(VFC.getE(i+1) != pos))
                    i++;
                if (i != dim)
                {
                    for (int j = i+1; j < dim; j++) {
                        VFC.insertarE(VFC.getE(j+1), j);
                        VD[j-1] = VD[j];
                    }
                    dim--;
                }
            }
        }else
            System.out.println("ERROR: Fila o Columnas fuera de rango");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
