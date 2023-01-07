/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete.Negocio;

/**
 *
 * @author itachi
 */
public class PilaBitwise {
    BitwiseDinamico Pila;
    int Cima;
    int inicio;
    int fin;
    int Dimension;
public PilaBitwise(int cantidad,int univInic,int univFin){
    Pila=new BitwiseDinamico(cantidad, univInic,univFin);
    Cima=-1;
    inicio=univInic;
    fin=univFin;
    Dimension=cantidad;
}
private boolean Lleno(){
    return (Cima==Dimension-1);
}
public void Push(int valor){
    if(valor>=inicio && valor<=fin){
        if(Lleno()){
            System.out.println("PilaBitwise::Push:Error la pila esta llena");
        }
        else{
            Cima++;
            Pila.Insertar(valor, Cima+1);
        }
    }
    else{
        System.out.println("PilaBitwise::Push:Error el valor esta fuera del rango");
    }
}
private boolean Vacio(){
    return (Cima==-1);
}
public int Pop(){
    if(Vacio()){
        System.out.println("PilaBitwise::Pop:Error la pila esta vacia");
        return 0;
    }
    else{
        int x=Pila.Obtener(Cima+1);
        Cima--;
        return x;
    }
}
public int getMax(){
    return fin;
}
public int getMin(){
    return inicio;
}
public int Cantidad(){
    return (Cima+1);
}
public int GetValor(){
    return Pila.Obtener(Cima+1);
}
public int Dimen(){
    return Dimension;
}
}
