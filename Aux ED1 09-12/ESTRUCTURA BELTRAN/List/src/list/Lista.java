package list;

public class Lista {
    Nodo L;
    int cantidad;
    
    public Lista(){
        L=null;
        cantidad=0;
    }
    public boolean vacia() {        
        return (L==null);        
    }
    
    public void insertar(int ele){
        if (vacia()){
            Nodo p=new Nodo();
            p.dato=ele;
            L=p;
            cantidad++;
        }else{
            Nodo anterior=null;
            Nodo aux=L;
            while((aux!=null)&&(aux.getdato()<=ele)){
                anterior=aux;
                aux=aux.getEnlace();
            }
            if(anterior==null){  //INSERTA EN EL PRIMER ELEMENTO
                if(aux.getdato()!=ele){
                    Nodo p=new Nodo();
                    p.setdato(ele);
                    p.setEnlace(L);
                    L=p;
                    cantidad++;
                }
                
            }else{
                if(anterior.getdato()!=ele){
                    Nodo p=new Nodo();
                    p.setdato(ele);
                    p.setEnlace(aux);
                    anterior.setEnlace(p);
                    cantidad++;
                }
            }                 
        }
    }   
    public void eliminar(int ele){
        if(!vacia()){
            Nodo ant=null;
            Nodo aux=L;
            while((aux!=null)&&(aux.getdato()!=ele)){
            ant=aux;
            aux=aux.getEnlace();
           }
            if(ant==null){
                L=L.getEnlace();
                cantidad--;
            }else{
                if(aux!=null){
                ant.setEnlace(aux.getEnlace());
                cantidad--;
                }
            }
        }
    }
    public void eliminar_ultimo(Nodo p){
         if (p==null){
            
         }else
            if (p.getEnlace().getEnlace()==null){                
                p.setEnlace(null);
            }else
                 
                     eliminar_ultimo(p.getEnlace());
        
    }
    
    void insertar_n(int l)
    {
       insertar_r(l,L,1);
    }
    void insertar_r(int l,Nodo p, int i)
    {
        Nodo n = new Nodo();
        
        n.dato=l;
        if( p==null){
            L=n;
            
        }else{
            if (p.getEnlace()==null){
               
                p.setEnlace(n);
            
        }else{
                if (i<get_cantidad())
                {
                    insertar_r(l,p.getEnlace(),i+1);
                }
                
            }
    }
    }
    public void EliminarI(Nodo p){
        EliminarIR(L);
    }
    public void EliminarIR(Nodo p){
        if (p==null){
            //nothing
        }else{
            if (p.getEnlace()==null){
                //nothing
            }else{
                p.setEnlace(p.getEnlace().getEnlace());
                EliminarIR(p.getEnlace());
            }
        }
    }
    public int get_cantidad(){
     int cant=0; 
     Nodo p=L;
        while(p!=null){
         cant++;
         p.setEnlace(p.getEnlace());
         p=p.getEnlace();
     }
        return cant;
    }
    public void invertir()
    {
        if (L != null)
        {
            Nodo a = null;
            Nodo b = L;
            Nodo c = b.getEnlace();
            while (c != null)
            {
                b.setEnlace(a);
                a = b;
                b = c;
                c = c.getEnlace();
            }
            b.setEnlace(a);
            L = b;
        }else
            System.out.println("Lista vacia");
    }
    public boolean Capicua(){
        Nodo r=new Nodo();
        r=L;
       return CapicuaR(r);
    }
    public boolean CapicuaR(Nodo p){
        if (p==null){
           return true;
        }else{
            if (p.getEnlace()==null){
               return true;
            }else{
                Nodo nodo_pe=Obtener_ultimo(p);
                if (p.getdato()==nodo_pe.getdato()){
                    eliminar_ultimo(p);
                    return CapicuaR(p.getEnlace());
                }else{
                    return false;
                }
                
            }
        }
    }
 
    public Nodo Obtener_ultimo(Nodo p){
       
        if (p==null)
            return p;
        else 
            if (p.getEnlace()==null)                
                return p;
            else
                if (p.getEnlace().getEnlace()==null){                    
                    return p.getEnlace();
                   
                }else{
                  
                    return Obtener_ultimo(p.getEnlace());
              // 
                }
                
            
        }
    
    public void Intercalar()
  {
      if (L!=null)
         L=IntercalarR(L,L.getEnlace());
  }
  
  public Nodo IntercalarR(Nodo t,Nodo j)
  {
      if ((t==null)||(t.getEnlace()==null)) 
      {
          return t;
      }
      else
      {
          if (j==null)
          {
              return IntercalarR(t, t.getEnlace());
          }
          else 
          {
              if (j.getEnlace()==null)
              {
                  j.setEnlace(t);
                  t=j;
                  t.getEnlace().setEnlace(null);
                  return t;
              }
              t.setEnlace(j.getEnlace());
              j.setEnlace(t);
              j.getEnlace().setEnlace(IntercalarR(j.getEnlace().getEnlace(), null));
              return j;
          }
      }
  }
 
    
    
    public void Intercambiar(){
        Intercambiar_r(L,get_cantidad(),0,0);
    }
    private void Intercambiar_r(Nodo p, int i, int x, int y){
              
        if (p==null){
        
        }else{
            if (p.getEnlace()==null){
            
            }else{
                if (get_cantidad()==i){
                      x=p.getdato();
                      y=Obtener_ultimo(p).getdato();
                }
                     if (p.getEnlace().getEnlace()==null){
                    //   Intercambiar_r(p.getEnlace(),i++)
                         p.getEnlace().setdato(x);
               }else{
                         Intercambiar_r(p.getEnlace(), i+1, x,y);
                     }                   
            }
        }
        if (get_cantidad()==i){
              p.setdato(y);
        }
    }
    
    public void InsertarI(int ele){
        int c=0;
        if (L==null){
            Nodo n=new Nodo();
            n.setdato(ele);
            L=n;
            c=1;
            cantidad++;
        }else{
            Nodo p=L;
          for(int i=1;i<c;i++){
              p=p.getEnlace();
          }
          Nodo q=new Nodo();
          q.setdato(ele);
          p.setEnlace(q);
            
               if (cantidad%2==1){
                   c++;
               }
            }                 
        
            

    }
      
   public void mover_mitad(){
       mover_mitad_r(L, 0);
   }
   private void mover_mitad_r(Nodo p, int y){
       if (p==null){
           
       }else{
           if (p.getEnlace()==null){
           
           }else{
               
                   int x=get_cantidad()/2;
                   y=p.getdato();
                   mover_mitad_r(p.getEnlace(),y);
                   
               }
           
       }
       if (get_cantidad()%2==0){

           p.setdato(y);
       }
   
       
   }
   private void unir(Nodo p,  Nodo q, int med, int i){
       
       if (q==null){
           
       }else{
           if (i==med-1){
              p.setEnlace(q);
           }else{
           unir(p,q.getEnlace(),med,i+1);
         }
       }
   
   }
   
   
   public void Movermitad(){
       Nodo aux=L;
       int c=get_cantidad();
       if (c%2==0){
           int m=c/2;
           int t=m;
           while((!vacia())&&(m>=1)){
               aux=aux.getEnlace();
               m--;
           }
           
           unir(aux,L,t,0);
           
       }else{
       
       }
   }
 
   
	

    @Override
    public String toString() {
       String s="L: ";
       Nodo aux=L;
       for(int i=1;i<=get_cantidad();i++){
           s=s+", "+aux.getdato();
           aux=aux.getEnlace();
       }
       return s;
    }
    
}
