/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multiclasedavid2015;

import multiclasedavid2015.VectorBitwiseEnteroGen2;

/**
 *
 * @author Juan
 */
public class MatrizSparceVectorGen {    
        float VD[];
        VectorBitwiseEnteroGen2 VFC;
        int dim;
        int m; //nro de filas
        int n; //nro de columnas
        int ed;

    public MatrizSparceVectorGen(int nroF, int nroC, int ed)
    {
        VD = new float[10];
        VFC = new VectorBitwiseEnteroGen2((int)10,(int)10);
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
        MatrizSparceVectorGen M=new MatrizSparceVectorGen(5, 5, 0);
        M.insertarE(5, 2, 2);
        System.out.println(M);
        // TODO code application logic here
    }
}
