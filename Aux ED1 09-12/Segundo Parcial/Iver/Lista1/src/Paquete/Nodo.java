/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete;

/**
 *
 * @author itachi
 */
public class Nodo {
    Nodo Enlace;
    int Data;
public Nodo(){
    Enlace=null;
    Data=0;
}
public Nodo(int x){
    Enlace=null;
    Data=x;
}
public void setEnlace(Nodo Enlace){
    this.Enlace=Enlace;
}
public void setData(int Data){
    this.Data=Data;
}
public Nodo getEnlace(){
    return Enlace;
}
public int getData(){
    return Data;
}
}
