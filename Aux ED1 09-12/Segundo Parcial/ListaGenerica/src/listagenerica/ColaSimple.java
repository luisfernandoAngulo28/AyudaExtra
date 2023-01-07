/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listagenerica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ColaSimple implements Cloneable {

            int q[];
            int f;
            int u;
            int cant;
         
    public ColaSimple(int NElementos)
    {
        q = new int[NElementos];
        f = -1;
        u = -1;
        cant=0;
    }
    
    private boolean vacia()
    {
        return ((f == -1)&&(f == u));
    }
    
    private boolean llena()
    {
        return (u-f+1==0)||((u-f+1==q.length)&&(u != -1)&&(f != -1));
    }
    
    public void Encolar(int x)
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
    
    public int Decolar()
    {
        if (!vacia())
        {
            int valor = q[f];
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
            int x = Decolar();
            invertir();
            Encolar(x);
        }
    }
      
    public void Eliminar()
    {
        if ((vacia())||(f==u))
        {
        }else{
            int x = Decolar();
            int y = Decolar();
          
                Eliminar();
                  Encolar(x);
        }
     
    }
 
                                                                                                
    public void ordenar()
    {
        int i = cantidadE();
        while(i > 1)
        {
            int x = Decolar(); 
            int j = i;
            while(j > 1)
            {
                int y = Decolar();
                if (x < y)
                {
                    int m = x;
                    x = y;
                    y = m;
                }
                Encolar(y);
                j--;
            }
            Encolar(x);
            int i2 = i;
            while(i2<cantidadE())
            {
                Encolar(Decolar());
                i2++;
            }
            i--;
        }
    }
    

//    @Override
//    protected Cola clone() throws CloneNotSupportedException {
//        return (Cola) super.clone(); //To change body of generated methods, choose Tools | Templates.
//    }
    
//    @Override
//   public String toString()
// {
//  String cad="";
//                try {
//                    Cola c=clone();
//                    for (int i=1;i<=c.cantidadE();i++)
//                        {
//                         cad="|"+c.Decolar()+"|"+"\n"+cad;
//                        }
//                } catch (CloneNotSupportedException ex) {
//                    Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
//                }
//  
//   
//   return cad;
// }
   @Override
    public String toString()
    { String cad="";
    int longitud=cant;
        for (int i = 0; i < longitud; i++) 
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
   
   public int SacarMenorC()
   {
   int x=Decolar();
       for (int i = 1; i <= cantidadE(); i++) {
           int y=Decolar();
           if(y<x)
           {
           Encolar(x);
           x=y;
           }
           else
           {
           Encolar(y);
           }
           i++;
       }
       return x;
   }
   
   public int SacarMenorCRec()
   {int x=Decolar();
    if(vacia())
    {
    //nada
    }
    else if(cantidadE()==1)
    {
    return Decolar();
    }
    else
    {
    int y=SacarMenorCRec();
    if(y<x)
    {
    Encolar(x);
    x=y;
    }
    else
    {
    Encolar(y);
    }
    
    }
    return x;
   }
   
   
   public void IntercambiarPf()
   {int x;
   int y;
    if(vacia()||cantidadE()==1)
    {
    //nada
    }
    else if(cantidadE()==2)
    {
    x=Decolar();
    y=Decolar();
    Encolar(y);
    Encolar(x);
    }
    else
    {
    int aux=Decolar();
    int aux2=Decolar();
    IntercambiarPf();
    }
   }
   
   
  private void EncolarAlprincipio(int dato,boolean sw)
  { 
  
  if(sw==true)
  {
  sw=false;
  invertir();
  }
   if(vacia())
   {
       Encolar(dato);
       //
   }
   else
   {
   int x=Decolar();
   //int y=Decolar();
   EncolarAlprincipio(dato,sw);
   Encolar(x);
   //Encolar(y);
   }
  }
  
  public void EncolarAlprincip(int ele)
  {
  boolean sw=true;
  EncolarAlprincipio(ele, true);
  }
  
  private void EliminarEle(int ele)
  {
   if(!vacia())
   {
    int x=Decolar();
    EliminarEle(ele);
    if(x!=ele)
     Encolar(x);
   }
  }
  
  public void EliminarE(int ele)
  {
  boolean sw=true;
  EliminarEle(ele);
  invertir();
  }
  
  
  public void HacerUnicos()
  {
   if(!vacia())
   {
   int x=Decolar();
   HacerUnicos();
   EliminarE(x);
   EncolarAlprincip(x);
   }
  }
  
  private void InvertirMitad(int m)
  { 
   if(m!=0)
   {
    int x=Decolar();
    m--;
    InvertirMitad(m);
    Encolar(x);
   }
  }
  
  public void InvertirMitadR()
  {int m=0;
  if(cant%2==0)
   m=cant/2;
  else
   m=cant/2+1;      
  InvertirMitad(m);
  invertir();
  }
}
