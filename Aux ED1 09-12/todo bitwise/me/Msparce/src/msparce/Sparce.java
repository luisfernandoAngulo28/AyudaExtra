/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package msparce;

/**
 *
 * @author Juan
 */
public class Sparce {

        float VD[];
        int VFC[];
        int dim;
        int m;
        int n;
        int e;
    
    public Sparce(int nf, int nc, int ele){
        VFC = new int[10];
        VD = new float[10];
        n = nc;
        m = nf;
        dim = -1;
        e = ele;
    }
    
    public void SetDato(int f, int c, float dato)
    {
        if ((f > 0)&&(c > 0)&&(f <= m)&&(c <= n))
        {
            int fc = (f-1)*n + c;
            int pos = buscar(fc);
            if (pos != -1)
            {
                if (dato == e)
                {
                    dim--;
                    for (int i = pos; i < dim; i++) {
                        VFC[i] = VFC[i+1];
                        VD[i] = VD[i+1];
                    }
                }else
                    VD[pos] = dato;
            }else{
                if (dato != e)
                {
                    if ((dim % 9 == 0)&&(dim!=0))
                    {
                        float vaux[] = new float[dim+10];
                        System.arraycopy(VD, 0, vaux, 0, dim+1);
                        VD = new float[dim+10];
                        System.arraycopy(vaux, 0, VD, 0, dim+1);
                        int vfc2[] = new int[dim+10];
                        System.arraycopy(VFC, 0, vfc2, 0, dim+1);
                        VFC = new int[dim+10];
                        System.arraycopy(vfc2, 0, VFC, 0, dim+1);
                    }
                    dim++;
                    VD[dim] = dato;
                    VFC[dim] = (f-1)*n + c;
                }
            }
        }else
            System.out.println("Error: la Fila o Columna esta fuera de rango");
    }
    
    private int buscar(int fc)
    {
        int i = 0;
        while ((i <= dim) && (VFC[i] != fc ))
            i++;
        if (i > dim)
            return -1;
        else
            return i;
    }
    
    public float getDato(int f, int c)
    {
        float valor = e;
        if ((f > 0)&&(c > 0)&&(f <= m)&&(c <= n))
        {
            int pos = buscar((f-1)*n + c);
            if (pos != -1)
            valor = VD[ pos ];            
        }else
            System.out.println("Error: Fila o Columna fuera de rango");
        return valor;
    }
    
    public void permutarF(int f1, int f2)
    {
        if ((f1 > 0) && (f2 > 0) && (f1 <= m) && (f2 <= m))
        {
            for (int i = 0; i < n; i++) {
                int aux = (int)getDato(f1, i+1);
                SetDato(f1, i+1, getDato(f2, i+1));
                SetDato(f2, i+1, aux);
            }
        }
    }
    
    public void rectangulosEntrantes()
    {
        int f1 = 0, f2 = m-1, c1 = 0, c2 = n-1;
        while ((f2>=f1)&&(c2>=c1))
        {
            for (int i = c1; i <= c2; i++) {
                SetDato(f1+1,i+1,f1+1);
                SetDato(f2+1,i+1,f1+1);
            }
            
            for (int i = f1; i <= f2; i++) {
                SetDato(i+1,c1+1,f1+1);
                SetDato(i+1,c2+1,f1+1);
            }
            f1++; f2--;
            c1++; c2--;
        }
    }
    
    public String toStringFila(int fila)
    {
        String s = "";
        if ((fila > 0)&&(fila <=m))
        for (int i = 0; i < n; i++) {
            s = s + "  " + getDato(fila, i+1);
        }
        return s;
    }
    @Override
    public String toString() {
        String s = "";
        try {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    s += getDato(i, j) + "  ";
                }
                s += "\n";
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return s;

    }
    public static void main(String[] args) {
        Sparce a = new Sparce(4,4, 0);
//        a.rectangulosEntrantes();
//        for (int i = 0; i < 15; i++) {
//            System.out.println(a.toStringFila(i+1));
//        }
        Sparce sp=new Sparce(4, 4, 0);
        sp.SetDato(1, 1, 2);
        sp.SetDato(1, 2, 4);
        sp.SetDato(1, 3, 1);
        sp.SetDato(1, 4, 3);
        
        sp.SetDato(2, 1, 2);
        sp.SetDato(2, 2, 4);
        sp.SetDato(2, 3, 2);
        sp.SetDato(2, 4, 4);
        
        
        sp.SetDato(3, 1, 9);
        sp.SetDato(3, 2, 8);
        sp.SetDato(3, 3, 2);
        sp.SetDato(3, 4, 4);
        
        sp.SetDato(4, 1, 7);
        sp.SetDato(4, 2, 2);
        sp.SetDato(4, 3, 2);
        sp.SetDato(4, 4, 3);
        System.out.println(sp);
        sp.permutarF(1, 4);
        System.out.println(sp);
    }
}
