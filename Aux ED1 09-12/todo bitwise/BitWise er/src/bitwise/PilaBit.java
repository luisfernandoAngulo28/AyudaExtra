/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwise;

/**
 *
 * @author Ernesto
 */
public class PilaBit {VectorBitG P;
                        int cima;
                        int top;  
                        
   public PilaBit(int cant,int NBit){
       P=new VectorBitG(NBit,cant);
       cima=-1;
       top=cant;
   }           
   private boolean llena(){
       return (cima==top);
   }
   private boolean vacia(){
       return (cima==-1);
   }
   public void push(int dato){
       if (llena()){
           throw new Error("Error pila esta llena");
       }else{
           cima++;
           P.Insertar(dato, cima);
       }           
   }
   public int pop(){
         int x=-1;
         if(vacia()){
            throw new Error("Error pila esta vacia"); 
         }else {
             x=P.sacar(cima);
             cima--;             
         }return x;
     }
     
        public int get(){
         if(vacia()){
            throw new Error("Error pila esta vacia"); 
         }
            return P.sacar(cima);
     }
     public void Eliminar (){
         if(cima>=1){
             int x=pop();
             Eliminar();
             if(x!=get())
                 push(x);
         }              
     }
     public void Eliminar1(){
         PilaBit Q=new PilaBit(cima,7);
         int f=0;
         while(cima>=f){
             int x=pop();
             while(cima>=f){
                 int y=pop();
                 if(x!=y)
                     Q.push(y);
             }
             push(x);
             while(!Q.vacia())
                 push(Q.pop());
             f++;                         
         }
     }
     public void Invertir(){
         PilaBit Q=new PilaBit(cima,7);
         int f=0;
         while(cima>=f){
             int x=pop();
             while(cima>=f)
                Q.push(pop());
             push(x);
             while(!Q.vacia())
                 push(Q.pop());
             f++;                         
         }
     }     
     public void Invertir1(PilaBit Q,boolean sw){
         if(sw){
                sw=false;
                while(cima>=0)
                    Q.push(pop());
         }
         if(!Q.vacia()){
             int x=Q.pop();
             Invertir1(Q, sw);
             push(x);
         }                
     }     
     public void ordenarAsc(){
         PilaBit Q=new PilaBit(cima,7);
         int i=0;
         while(cima>=i){
             int x=pop();
             while(cima>=i){                 
                 if(x>get()){
                     Q.push(x);
                     x=pop();
                 }else
                     Q.push(pop());
             }
             push(x);
             while(!Q.vacia())
                 push(Q.pop());
             i++;
         }
     }     
     public boolean Simetria(){
         PilaBit Q=new PilaBit(cima,7);
         int i=cima;
         int j=0;
         boolean sw=true;
         while((i>=j)&&(sw)){
             while(cima>i)
                 Q.push(pop());
             int x=get();
             while(cima>j)
                 Q.push(pop());
             int y=get();
             if (x!=y)
                 sw=false;             
             j++;
             i--;
             while(!Q.vacia())
                 push(Q.pop());                 
         }   
         return sw;
     }                  
     public String pilatoString(){
         String a="";
         if(cima>=0){             
             int x=pop();
             if (cima==-1)
                a=a+x;
             else a=pilatoString()+","+x;
             push(x);             
         }return a;
     }
}
