/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete.Aplicacion;

/**
 *
 * @author itachi
 */
public class Provedor implements Comparable{
    int Codigo;
    String Nombre;
    String Direccion;
    int Telefono;
    int Nit;
public Provedor(){
    Nombre=Direccion=" ";
    Codigo=Telefono=Nit=0;
}
public Provedor(int cod,String nom,String direc,int telf,int nit){
    Codigo=cod;
    Nombre=nom;
    Direccion=direc;
    Telefono=telf;
    Nit=nit;
}
public void SetCodigo(int cod){
    Codigo=cod;
}
public void SetNombre(String nom){
    Nombre=nom;
}
public void SetDireccion(String dir){
    Direccion=dir;
}
public void SetTelefono(int telf){
    Telefono=telf;
}
public void SetNit(int n){
    Nit=n;
}
public int GetCodigo(){
    return Codigo;
}
public String GetNombre(){
    return Nombre;
}
public String GetDireccion(){
    return Direccion;
}
public int GetTelefono(){
    return Telefono;
}
public int GetNit(){
    return Nit;
}
@Override
public String toString(){
     return "Nombre: "+Nombre+"\nCodigo: "+Codigo+"\nDireccion: "+Direccion+"\nTelefono: "+Telefono+"\nNit: "+Nit;
}
public int compareTo(Object o) { //?1- operadores terneario( : o,? es igual)
    Provedor A=(Provedor )o;//castin declaramos un objeto de tipo alumno
    if (o instanceof Provedor){
        return( (this.Codigo<A.Codigo)?-1:(this.Codigo>A.Codigo)?1:0);//hacemos la comparacion de los registros
    }else{
        return 666;
    }                                                                        //para insertar de manera ordenada
}
/*
"Instanceof" sirve para consultar si un objeto es una instancia de una clase
 determinada, o de su padre. Pareciera absurdo tratar de conocer cuál es la
 clase que da lugar a una instancia específica, sin embargo es de mucha
 utilidad cuando se trabaja con interfaces y herencia a la vez
*/

public void decodifProvedor(String k){
    int i = 0;
    String cod="";
    while(k.charAt(i)!=','){
        cod=cod+k.charAt(i);
        i++;
    }
    this.Codigo=Integer.parseInt(cod);
    i++;
    cod="";
    while(k.charAt(i)!=','){
        cod=cod+k.charAt(i);
        i++;
    }
    this.Nombre=cod;
    i++;
    cod="";
    while(k.charAt(i)!=','){
        cod=cod+k.charAt(i);
        i++;
    }
    this.Direccion=cod;
    i++;
    cod="";
    while(k.charAt(i)!=','){
        cod=cod+k.charAt(i);
        i++;
    }
    this.Telefono=Integer.parseInt(cod);
    i++;
    cod="";
    while(k.charAt(i)!=','){
        cod=cod+k.charAt(i);
        i++;
    }
    this.Nit=Integer.parseInt(cod);
}
}
