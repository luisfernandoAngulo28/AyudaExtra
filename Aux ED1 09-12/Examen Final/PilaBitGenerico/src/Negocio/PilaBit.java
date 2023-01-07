/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author estidiante-1
 */
public class PilaBit {
      VectorBitG p;
      int cima;
   public PilaBit(int cant,int ri,int rf){
     p=new VectorBitG(cant, ri, rf);
     cima=-1;
   }   
   public boolean Vacia(){
     return (cima==-1);
   }
   public boolean Llena(){
     return (cima == p.GetCant());
   }
   public void Push(int elem){
       if (elem>=p.Ri && elem <=p.Rf){
         if (Llena()){
           System.out.println("ERROR");
         }else{  
           cima++; 
           p.SetDato(elem, cima+1);   
         }
       }
   }
   public int pop(){
       if (!Vacia()){ 
          cima--;   
          return p.GetDato(cima+1);      
       }else{
         System.out.println("ERROR");
         return 0;
       }
   }
   public String Mostrar(){
   String s="";
    for (int i=cima+1;i>0;i--){
     s=s+" | "+p.GetDato(i);
    }
    return s;
   }
   
}
