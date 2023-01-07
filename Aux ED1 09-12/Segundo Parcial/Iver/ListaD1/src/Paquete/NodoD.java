/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete;

/**
 *
 * @author itachi
 */
public class NodoD {
    NodoD Izq;
    NodoD Der;
    int Data;
public NodoD(){
    Izq=null;
    Der=null;
    Data=0;
}
public NodoD(int x){
    Izq=null;
    Der=null;
    Data=x;
}
public void setEnlaceIzq(NodoD Izq){
    this.Izq=Izq;
}
public void setEnlaceDer(NodoD Der){
    this.Der=Der;
}
public void setData(int Data){
    this.Data=Data;
}
public NodoD getEnlaceIzq(){
    return Izq;
}
public NodoD getEnlaceDer(){
    return Der;
}
public int getData(){
    return Data;
}
}
