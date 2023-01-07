
package proyecto2;

import java.util.Vector;

public class Ram {
    public Nodo v[];
    public int dim;
    int pos;
    
    public Ram(){
       
        v=new Nodo[100];
        dim=0;
        pos=0;
    }
    public Ram(int dim){
        this.dim=dim;
        v=new Nodo[dim];
         for(int i=0;i<dim;i++){
            v[i]=null;
        }
      
     
       
    }
    public void Insertar(String nombre){
        boolean bw=true;
        int i=0;
          
              Nodo n=new Nodo();
              n.dato=nombre;
            
              while((i<v.length)&&(bw==true)){
                if(v[i]==null){
                   v[i]=n;
                   if (i==0){
                   
                   }else{
                   insertar_n(v[i]);
                   }
                   bw=false;
                }else{
                i++;
                
                   
                }
           }
            
      
    }
    public int Cantidad_procesos(){
        int c=0;
        for (int i=0;i<v.length;i++){
            if (v[i]!=null){
                c++;
            }
            
        }
        return c;
    }
    
   
  void insertar_n(Nodo l)
    {
       insertar_r(l,v[0],1);
    }
  void insertar_r(Nodo l,Nodo p, int i)
    {
        if( p==null){
            p=l;
            
        }else{
            if (p.getEnlace()==null){
                
                p.setEnlace(l);
            
        }else{
                if (i<get_cantidad())
                {
                    insertar_r(l,p.getEnlace(),i+1);
                }
            }
    }
    
}
  public int obtener_posicion(String ele){
      int i=0;
        while (i<v.length){
            
            if (v[i]==null){
              i++;
          }
            if (v[i].dato.equals(ele)){
                return i;
            }else{
          
            i++;
            }
        }
        return -1;
     
  }
  public boolean existe_proceso(String ele){
      int i=0;
      boolean sw=false;
      while ((i<v.length)&&(sw==false)){
          if (v[i].dato!=ele){
              i++;
          }else{
             sw=true; 
          }
      }
      return sw;
  }
     
   
   
   public void eliminar(String ele){
        int i=0;
                      
         if(v[0]!=null){
            Nodo ant=null;
            Nodo aux=v[0];
            while((aux!=null)&&(!aux.getdato().equals(ele))){
            ant=aux;
            aux=aux.getEnlace();
            i++;
           }
            if(ant==null){
                v[0]=v[0].getEnlace();
                v[0]=null;
                
            }else{
                if(aux!=null){
                ant.setEnlace(aux.getEnlace());
                v[i]=null;
                
                }
            }
       
         }else{
            
                 v[0]=v[0].getEnlace();
                 eliminar(v[0].getdato());
             }
   
             
         
    }
     
  public int get_cantidad(){
     int cant=0; 
     Nodo p=v[0];
        while(p!=null){
         cant++;
         p.setEnlace(p.getEnlace());
         p=p.getEnlace();
     }
        return cant;
    }
    

}
