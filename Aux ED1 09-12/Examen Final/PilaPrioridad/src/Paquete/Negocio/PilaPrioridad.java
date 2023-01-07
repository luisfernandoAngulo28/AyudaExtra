/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete.Negocio;



/**
 *
 * @author itachi
 */
public class PilaPrioridad {
    PilaBits Pila;
    int inicio;
    int fin;
    int Cima;
    int Valor;
    int PrioridadInic;
    int PrioridadFin;

public PilaPrioridad(int cant,int initiation,int end){
    Pila=new PilaBits(cant, initiation, end);
    inicio=initiation;
    fin=end;
    PrioridadInic=1;
    PrioridadFin=10;
    Cima=-1;
}

private  boolean Lleno(){
    return (Pila.Dimencion()==Cima+1);
}
public void Push(int val,int priori){
    if(Lleno()){
        System.out.println("PilaPrioridad::Push:Error la pila esta llena");
    }
    else{
        if(val>=inicio && val<=fin && priori>0 && priori<=PrioridadFin){
            if(Cima==-1){
                Cima++;
                Pila.InsertarValor(Cima+1, val, priori);
            }
            else{
                if(priori>=Pila.Prioridad(Cima+1)){
                    Cima++;
                    Pila.InsertarValor(Cima+1, val, priori);
                }
                else{
                    int valor1=PopValor(); //Siempre primero PopValor() ;cima no decrementa
                    int priori1=PopPriori(); //Siempre despues de PopValor() ;aqui decrementa
                    Push(val, priori);                                       //cima
                    Cima++;
                    Pila.InsertarValor(Cima+1, valor1, priori1);
                }
            }
        }
        else{
            System.out.println("PilaPrioridad::Push:Error algun parametro es invalido");
        }
    }
}
private boolean Vacio(){
    return (Cima==-1);
}
private int PopValor(){
    if(Vacio()){
        System.out.println("PilaPrioridad::PopValor::Error la pila esta vacia");
        return 0;
    }
    else{
        int val=Pila.Valor(Cima+1);
        return val;
    }
}
private  int PopPriori(){
    if(Vacio()){
        System.out.println("PilaPrioridad::PopPriori::Error la pila esta vacia");
        return 0;
    }
    else{
        int val=Pila.Prioridad(Cima+1);
        Cima--;
        return val;
    }
}
public String PopPilaPrioridad(){
    return (PopValor()+"/"+PopPriori());
}
public int Dimenc(){
    return Pila.DimencionBits;
}
public int GetCima(){
    return Cima+1;
}
public int GetValor(int posi){
    return Pila.Valor(posi);
}
public int GetPrioridad(int posi){
    return Pila.Prioridad(posi);
}
public int getMax(){
    return fin;
}
public int getMin(){
    return inicio;
}
}
