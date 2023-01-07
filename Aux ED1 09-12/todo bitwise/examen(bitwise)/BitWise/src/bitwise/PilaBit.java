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
           new Exception("Error pila esta llena");
       }else{
           cima++;
           P.Insertar(dato, cima+1);
       }           
   }
   public int pop(){
         int x=-1;
         if(vacia()){
            new Exception("Error pila esta vacia"); 
         }else {
             x=P.sacar(cima+1);
             cima--;             
         }return x;
     }
     
        public int get(){
         if(vacia()){
            new Exception("Error pila esta vacia"); 
         }
            return P.sacar(cima);
     }
     public void Eliminar (){
         if(cima>=1){
             int x=pop();
             Eliminar();
             if(x!=get()){
                 push(x);
             }
         }              
     }
    
}
