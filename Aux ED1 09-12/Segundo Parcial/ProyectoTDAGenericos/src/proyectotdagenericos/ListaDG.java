/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotdagenericos;

/**
 *
 * @author Usuario
 */
public class ListaDG <T extends Comparable> {

        NodoDG<T> prim;
        NodoDG<T> ult;
        int cant;
        
    public ListaDG()
    {
       prim = new NodoDG<T>();
       ult = prim;
       cant = 0;
    }
    
    public void Insertar(T dato)
    {
        NodoDG<T> p = prim.getEnlaceD();
        while ((p != null)&&(dato.compareTo(p.getDato())>0))
            p = p.getEnlaceD();
        NodoDG<T> dat= new NodoDG<T>(dato);
        if (p == null)
        {
            if (ult != null)
            {
                ult.setEnlaceD(dat);
                dat.setEnlaceI(ult);
            }else
                prim = dat;
            ult = dat;
        }else
        {
            if (p.getDato() != dato)
            {
                dat.setEnlaceD(p);
                dat.setEnlaceI(p.getEnlaceI());
                if (p.getEnlaceI() == null)
                {
                    prim = dat;
                    p.setEnlaceI(dat);
                }else
                {
                    p.getEnlaceI().setEnlaceD(dat);
                    p.setEnlaceI(dat);
                }
            }else
                cant--;
        }
        cant++;
    }
    
    private NodoDG<T> InsertarR(T dato,NodoDG<T> p)
    {
     if(p==null)
     {
      cant++;
      ult=new NodoDG<>(dato,null,ult);
      return ult;
     }
     else
     {
      if(dato.compareTo(p.getDato())==0)
      {
       return p;
      }
     else
      {
        if(dato.compareTo(p.getDato())<0)
        {
        p.setEnlaceI(new NodoDG<T>(dato,p,p.getEnlaceI()));
        p.getEnlaceI().setEnlaceD(p);
        p=p.getEnlaceI();
        cant++;
        }
        else
        {
        p.setEnlaceD(InsertarR(dato, p.getEnlaceD()));
        }
      }  
     }
     return p;

    }
    
    public void InsertarR(T dato)
    {
    prim.setEnlaceD(InsertarR(dato, prim.getEnlaceD()));
    }
    
    
    public boolean vacia()
    {
    return prim==null && ult==null;
    }
    
 private String mostrarReves(NodoDG<T> nodo){
        if(nodo!=prim){
            return nodo.getDato() +" "+mostrarR(ult);
        }
        return "";
    }
    public String toStringReves() {
        return "L >>"+ mostrarReves(ult.getEnlaceI());
    }
        
        
    private String mostrarR(NodoDG<T> nodo){
        if(nodo!=null){
            return nodo.getDato() +" "+mostrarR(nodo.getEnlaceD());
        }
        return "";
    }
    @Override
    public String toString() {
        return "L >>"+ mostrarR(prim.getEnlaceD());
    }
        

     
     public void EliminarExtremos()
     {
        prim.setEnlaceD(prim.getEnlaceD().getEnlaceD());
        prim.getEnlaceD().getEnlaceD().setEnlaceI(null);
        ult=ult.getEnlaceI();
        ult.setEnlaceD(null);
     }
     
     private void Invertir(NodoDG<T> p)
     {
      if(p==null || p.getEnlaceD()==null)
      {
      //Nada
      }
      else if(p.getEnlaceD().getEnlaceD()==null)
      {   prim=p.getEnlaceD();
          p.getEnlaceD().setEnlaceD(p);
          p.getEnlaceD().setEnlaceI(null);
          p.setEnlaceI(prim);
          p.setEnlaceD(null);

      }
      else
      {
          Invertir(p.getEnlaceD());
          p.getEnlaceD().setEnlaceD(p);
          p.setEnlaceI(p.getEnlaceD());
          p.setEnlaceD(null);
          ult=p;
      }
          
     }
     
     public void Invertir()
     {
     Invertir(prim.getEnlaceD());
     NodoDG<T> aux = new NodoDG<T>();
     aux.setEnlaceD(prim);
     prim.setEnlaceI(aux);
     prim=aux;
     }
     
     
     
     private NodoDG<T> InvertirMitad(int i, NodoDG<T> p)
     {
      if(i==0)
      {
          if(p.getEnlaceD().getEnlaceD()==null)
          {
           p.getEnlaceD().setEnlaceD(p);
           p.getEnlaceD().setEnlaceI(null);
           p.setEnlaceI(p.getEnlaceD());
           p.setEnlaceD(null);
           ult=p;
           return p;
          }
          else
          {
           p.setEnlaceD(InvertirMitad(i, p.getEnlaceD()));
           p.getEnlaceD().setEnlaceD(p);
           p.setEnlaceI(p.getEnlaceD());
           p.setEnlaceD(null);  
           return p;
          }
      }
      else
      {
          p.setEnlaceD(InvertirMitad(--i, p.getEnlaceD()));
          p.getEnlaceD().setEnlaceI(p);
      }
      return p;
     }
     
     public void InvertirMitad()
     { int n=cant/2;
      prim.setEnlaceD(InvertirMitad(n, prim.getEnlaceD()));
     }
    
     
          private void InvertirM(int i, NodoDG<T> p)
     {
      if(i==0)
      {
          if(p.getEnlaceD().getEnlaceD()==null)
          {
            NodoDG<T> aux=prim;    
           Invertir(p.getEnlaceD());
           p.setEnlaceD(prim);
           prim=aux;
          }
      }
      else
      {
          p.setEnlaceD(InvertirMitad(--i, p.getEnlaceD()));
          p.getEnlaceD().setEnlaceI(p);
      }
     }
     
     public void InvertirM()
     { int n=cant/2;
     InvertirMitad(n, prim.getEnlaceD());
     }
    
}
