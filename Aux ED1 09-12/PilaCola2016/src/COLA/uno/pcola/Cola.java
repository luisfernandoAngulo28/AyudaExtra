


package Cola.uno.pcola;
/**
 * Ayudantia 1/2016 Aux. Eddy Escalante
 */
public class Cola {

            int Q[];
            int frente;
            int atras;
         
    public Cola(int NElementos)
    {
        Q = new int[NElementos];
        frente = -1;
        atras = -1;
    }
    
    private boolean vacia()
    {
        return ((frente == -1)&&(frente == atras));
    }
    
    private boolean llena()
    {
        return (atras-frente+1==0)||((atras-frente+1==Q.length)&&(atras != -1)&&(frente != -1));
    }
    
    public void meter(int x)
    {
        if (! llena())
        {
            if (vacia())
            {
                frente = atras = 0;
                Q[frente] = x;
            }else{
                atras = (atras+1) % Q.length;
                Q[atras] = x;
            }
        }else
            System.out.println("Error: La cola esta llena");
    }
    
    public int sacar()
    {
        if (!vacia())
        {
            int valor = Q[frente];
            if ((frente == atras)&&(frente != -1))
                frente = atras = -1;
            else
                 frente = (frente + 1) % Q.length;
            return valor;
        }else
            System.out.println("Error: La cola esta vacia");
        return 0;
    }
    
    public int cantidadE()
    {
        if (!vacia())
        {
            int m = atras + 1 - frente;
            if ((frente >= atras)&&(frente != 0))
                m = Q.length + m;
            return m;
        }else
            return 0;
    }
    
    public void invertir()
    {
        if (! vacia())
        {
            int x = sacar();
            invertir();
            meter(x);
        }
    }
      
    public void Eliminar()
    {
        if ((vacia())||(frente==atras))
        {
        }else{
            int x = sacar();
            int y = sacar();
          
                Eliminar();
                  meter(x);
        }
     
    }
 
                                                                                                
    public void ordenar()
    {
        int i = cantidadE();
        while(i > 1)
        {
            int x = sacar(), j = i;
            while(j > 1)
            {
                int y = sacar();
                if (x < y)
                {
                    int m = x;
                    x = y;
                    y = m;
                }
                meter(y);
                j--;
            }
            meter(x);
            int i2 = i;
            while(i2<cantidadE())
            {
                meter(sacar());
                i2++;
            }
            i--;
        }
    }
    
    @Override
    public String toString()
    {
        String s = "";
        int constante = cantidadE();
        for (int i = 0; i < constante; i++) {
            s = s + "  " + sacar();
        }
        return s;
    }
    
    public static void main(String[] args) {
        Cola c = new Cola(3);
        c.meter(1);
        //System.out.println(c);
        c.meter(2);
        c.meter(3);
        //c.meter(4);
        //c.ordenar();
       
   
        c.Eliminar();
        System.out.println(c.toString());
    }
}
