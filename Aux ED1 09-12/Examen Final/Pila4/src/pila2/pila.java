/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pila2;

/**
 *
 * @author PC
 */
public class pila {
        VectorBG v;
        int tope;
        
        public pila(int cantele,int nrobit){
            v= new VectorBG(nrobit,cantele);
            tope=-1;
        }
        
        public boolean vacia(){
            return tope == -1;
        }
        
        public boolean llena(){
            return tope == v.Dim;
        }
        
        public void push(int ele){
            if (llena()){
                System.out.println("Error, pila llena");
            }else{
                tope++;
                v.Insertar(ele, tope);
            }
        }
        
        public int pop(){
            if (vacia()){
                return (Integer)null;
            }else{
                tope--;
                return v.sacar(tope+1);
            }
        }
        
        @Override
        public String toString(){
            String s="";
            int x;
            while (!vacia()){
                x=pop();
                s=s+String.valueOf(x)+" | ";
            }
            return s;
        }
    
}
