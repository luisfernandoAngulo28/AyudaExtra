/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete.Negocio;

/**
 *
 * @author itachi
 */
public class Pila {
    int v[];
    int Cima;
public Pila(int cant){
    v=new int[cant];
    Cima=-1;
}
public boolean Llena(){
    return (Cima==v.length);
}
public void Push (int valor){
    if(Llena()==true){
        System.out.println("Pila::Push:Error la pila esta llena");
    }
    else{
        Cima++;
        v[Cima]=valor;
    }
}
public boolean Vacio(){
    return (Cima==-1);
}
public int Pop() {
    if(Vacio()==true){
       System.out.println("Pila::Pop:Error: La Pila esta vacia");
       return 0;
    }
    else{
        int y=v[Cima];
        Cima--;
        return y;
    }
}
public int Cantidad(){
    return (Cima+1);
}
public int GetData(){
    return (v[Cima]);
}
public int Dimension(){
    return v.length;
}
}
