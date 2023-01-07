/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete.Negocio;

/**
 *
 * @author itachi
 */
public class NodoG<TObjeto>{
    TObjeto Data;
    NodoG Enlace;
public NodoG(){
    Data=null;
    Enlace=null;
}
public void SetData(TObjeto valor){
    Data=valor;
}
public void SetEnlace(NodoG p){
    Enlace=p;
}
public TObjeto GetData(){
    return Data;
}
public NodoG GetEnlace(){
    return Enlace;
}

}
