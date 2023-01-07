/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete.Aplicacion;

/**
 *
 * @author itachi
 */
public class Producto implements Comparable{
    int Codigo;
    String Nombre;
    String Descripcion;
    String Marca;
    String Procedencia;
public Producto(){
    Codigo=0;
    Descripcion=Marca=Procedencia=Nombre=" ";
}
public Producto(int cod,String nom,String descrip, String marca,String proceden){
    Codigo=cod;
    Nombre=nom;
    Descripcion=descrip;
    Marca=marca;
    Procedencia=proceden;
}
public void SetCodigo(int c){
    Codigo=c;
}
public void SetNombre(String n){
    Nombre=n;
}
public void SetDescripcion(String d){
    Descripcion=d;
}
public void SetMarca(String m){
    Marca=m;
}
public void SetProcedencia(String p){
    Procedencia=p;
}
public int GetCodigo(){
    return Codigo;
}
public String GetNombre(){
    return Nombre;
}
public String GetDescripcion(){
    return Descripcion;
}
public String GetMarca(){
    return Marca;
}
public String GetProcedencia(){
    return Procedencia;
}
@Override
public String toString(){
    return "Nombre: "+Nombre+"\nCodigo: "+Codigo+"\nDescripcion: "+Descripcion+"\nMarca: "+Marca+"\nProcedencia: "+Procedencia;
}
public int compareTo(Object o) { //?1- operadores terneario( : o,? es igual)
    Producto A=(Producto )o;//castin declaramos un objeto de tipo alumno
    if (o instanceof Producto){
        return( (this.Codigo<A.Codigo)?-1:(this.Codigo>A.Codigo)?1:0);//hacemos la comparacion de los registros
    }else{
        return 666;
    }                                                                        //para insertar de manera ordenada
}

public void decodifProducto(String k){
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
    this.Descripcion=cod;
    i++;
    cod="";
    while(k.charAt(i)!=','){
        cod=cod+k.charAt(i);
        i++;
    }
    this.Marca=(cod);
    i++;
    cod="";
    while(k.charAt(i)!=','){
        cod=cod+k.charAt(i);
        i++;
    }
    this.Procedencia=(cod);
}
}
