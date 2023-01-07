/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcola;

/**
 *
 * @author HP
 */
public class Tcola {
    Nodo L;
    int cant;

    private Tcola() {
        L=null;
    }
 
    private boolean vacia() {
        return (L==null);
    }

    private int sacar() {
        int x=this.L.getDato();
        this.L=this.L.getEnlace();
        cant--;
        return x;
    }

   public void meter(int dato){
    Nodo p=new Nodo(dato);
    if(L==null){
       L=p;
       cant++;
    }
    else{
       Nodo aux=L;
       while(aux!=null){
            if(aux.getEnlace()==null){
              aux.setEnlace(p);
              cant++;
              return;
             }
       aux=aux.getEnlace();
       }
    }
    
  }

    
    public void IntercambiarExtremos(){
        if(vacia()){
            return;
        }
        if(L.getEnlace()==null){
            return;
        }
        if(L.getEnlace().getEnlace()==null){
            int x = sacar();
            meter(x);
            return;
        }
        int x=sacar();
            Nodo aux = L;
            Nodo aux2=L;
        
        while (aux.getEnlace()!=null){  
            aux=aux.getEnlace();
        }
        int y=sacar();
            meter(y);
        while (aux2.getEnlace()!=aux){
            y = sacar();
            meter(y);
            aux2=aux2.getEnlace();
        }
        meter(x);
    }       //usando cola auxiliar
    
    public void interextremos(){           
        int c = cant;
        int x=sacar();
        c--;      
        while(c-1 > 0){
            int s=sacar();
            c--;
            meter(s);
        }
        meter(x);
    }              //sin cola auxiliar
    
    public void inter2en2(){
      int c=cant;
      if(c % 2 == 0){
        while(c>0){  
          int x=sacar();
          c--;
          int y= sacar();
          c--;
          meter(y);
          meter(x);
        }
      }else{
        while(c>1){  
           int x=sacar();
           c--;
           int y= sacar();
           c--;
           meter(y);
            meter(x);
       }
        int z = sacar();
        meter(z);
      
      }
    }                   //sin cola auxiliar

    
  public void elimedios(){
    int z=sacar();
    int c=cant;
    while(c>1){
     sacar();
      c--;
    }
    meter(z);
    int y=sacar();
    meter(y);
  
  }
  
  public void elimpares(){
      int c = cant;
      while(c>=1){
          int x = sacar();
          if(x % 2 != 0){
              meter(x);
          }
          c --;
      }
      
  }
    
  
   @Override
    public String toString() {
        String S="Cola |";
        Nodo p=L;
         while (p!=null)
         { 
           S=S+p.getDato()+" , ";
           p=p.getEnlace();
         }
       
        S=S+"|";
        return S;
    }  
   
     public static void main(String[] args)  {
        Tcola c = new Tcola();
        c.meter(1);
        c.meter(2);
        c.meter(3);
        c.meter(4);
        c.meter(5);
        c.meter(6);
        c.meter(7);
       
        System.out.println(c.toString());
        // System.out.println("Eliminando pares:");
        //c.elimpares();
       // System.out.println(c.toString());
        
        c.IntercambiarExtremos();
        System.out.println(c.toString()); 
    }

    
}

