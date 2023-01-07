/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

/**
 *
 * @author PC
 */
public class mipila {
    int p[];    //vector 
    int tope;   //indica cual es el ultimo elemento
    public mipila(int cant){
        p= new int[cant];
        tope=-1;
    }
    public void push(int ele){
        if (lleno()){
            System.out.println("stack over flow");
        }else{
            tope++;
            p[tope]=ele;
        }
    }
    private boolean lleno(){
        return (tope== p.length-1);
    }
    public int pop(){
        tope--;
        return (p[tope+1]);        
    }
    private boolean vacio(){
        return(tope==-1);
    }
    public String mostrar(){
        String s="";
        while(!vacio()){
            s= String.valueOf(pop())+" | "+s;
        }
        return s;
    }
    public void invertirdosendos(){
        if (vacio() || (tope==0)){
            //nada
        }else{
            int x=pop();
            int y=pop();
            invertirdosendos();
            push(x);
            push(y);
        }
    }
    public void priult(){
        int x;int y=0;int z;
        int i=tope;
        x=pop();
        while(i>1){
            y=(y*10)+(pop());
            i--;
        }
        z=pop();
        push(x);
        while(y!=0){
            x=y%10;
            push(x);
            y=y/10;
        }
        push(z);
    }
    public void priultR(int k,boolean sw){
        int x=0;
        if (tope==1){
            x=pop();
            x=(x*10)+pop();
            push(k);
            push(x/10);
            push(x%10);
        }else{
            if (sw==true){
                k=pop();
                sw=false;
                priultR(k,sw);
            }else{   
                x=pop();
                priultR(k,sw);
                int y=pop();
                push(x);
                push(y);
            }
        }
    }
    public void invertir(){
        int i=tope;
        while (i>-1){
            mipila p=new mipila(tope);
            int x=pop();
            while (!vacio()){
                p.push(pop());
            }
            push(x);
            while (!p.vacio()){
                push(p.pop());
            }
            i--;
        }
    }
    
    public int pri(){
        int x,y;
        if (this.tope==0){
            x=pop();
        }else{
            y=pop();
            x=pri();
            push(y);
        }
        return x;
    }
    
    public int ult(){
        return pop();
    }
    
    public void insertarult(int x){
        if(this.tope==0){
            int y=pop();
            push(x);
            push(y);
        }else{
            int z=pop();
            insertarult(x);
            push(z);
        }
    }
    
    public void invertirR(){
        int x,y;
        if(this.tope==0 || this.tope==-1){
            //nada
        }else{
           x=pri();
           y=ult();
           invertirR();
           insertarult(y);
           push(x);
        }
    }
    
    public void maymen(int may,int men){
            if (tope==0){
                may=pop();
                men=may;
            }else{
                int x=pop();
                maymen(may,men);
                if (x>may)may=x;
                if (x<men)men=x;
            }
        }
    
    public static void main(String[] args) {
     mipila p=new mipila(10);
        for (int i = 1; i <=5; i++) {
            p.push(i);
        }
        System.out.println(p.mostrar());
        p.priult();
        System.out.println(p.mostrar());
    }
}
