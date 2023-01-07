/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotdagenericos;

/**
 *
 * @author Usuario
 */
class ColaGenerica <Tipo> {
    Object q[];
    int f;
    int u;
    int cant;
   
 public ColaGenerica(int dim)
 {
 q = new Object[dim];
 f=-1;
 u=-1;
 }

 
   private boolean vacia()
    {
        return ((f == -1)&&(f == u));
    }
    
    private boolean llena()
    {
        return (u-f+1==0)||((u-f+1==q.length)&&(u != -1)&&(f != -1));
    }
    
    public void Encolar(Object x)
    {
        if (! llena())
        {
            if (vacia())
            {
                f = u = 0;
                q[f] = x;
            }else{
                u = (u+1) % q.length;
                q[u] = x;
            }
            cant++;
        }else
            System.out.println("Error: La cola esta llena");
    }
    
    public Object Decolar()
    {
        if (!vacia())
        {
            Object valor = q[f];
            if ((f == u)&&(f != -1))
                f = u = -1;
            else
                 f = (f + 1) % q.length;
            cant--;     
            return valor;
        }else
            System.out.println("Error: La cola esta vacia");
        return 0;
    }
    

    
    public void invertir()
    {
        if (! vacia())
        {
            Object x = Decolar();
            invertir();
            Encolar(x);
        }
    }
      
    public void Eliminar()
    {
        if ((vacia())||(f==u))
        {
        }else{
            Object x = Decolar();
            Object y = Decolar();
          
                Eliminar();
                  Encolar(x);
        }
     
    }
 
                                                                                                

    
   public void IntercambiarPf()
  { Object x;
    Object y;
   if(vacia())
   {
   //Nada
   }
   else if(f==u)
   {
   x=Decolar();
   Encolar(x);
   }
   else 
   {
   x=Decolar();
   y =Decolar();
   Encolar(y);
   IntercambiarPf();
   Encolar(x);
  
   }
  }
   
   @Override
   public String toString()
 {
  String cad="";
   for (int i=0;i<=q.length-1;i++)
   {
    cad="|"+Decolar()+"|"+"\n"+cad;
   }
   return cad;
 }
  
   public int cantidadE()
   {
    if(!vacia())
    {
    int m=u+1-f;
        if((f>=u)&&(f!=0))
        m=q.length+m;
        return m;  
    }
    else
    return 0;
    
   }
  
}
