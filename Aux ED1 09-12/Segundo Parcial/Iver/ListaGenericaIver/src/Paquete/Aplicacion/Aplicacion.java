/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete.Aplicacion;

import Paquete.Datos.Archivo;
import Paquete.Negocio.ListaG;
import java.util.StringTokenizer;






/**
 *
 * @author itachi
 */
public class Aplicacion {
   
    ListaG<Cliente> C;
    ListaG<Provedor> Prov;
    ListaG<Producto> Prod;
    Cliente c;
    Provedor prov;
    Producto prod;
    
public Aplicacion() {
    C=new ListaG<Cliente>();
    Prov=new ListaG<Provedor>();
    Prod=new ListaG<Producto>();

    }

/////////////////////////////CLIENTE///////////////////////////////
public void RegistrarCLiente(int cod,String nom,String direc,int telf,int nit){
    c=new Cliente(cod, nom, direc, telf, nit);
    C.InsertarO(c);
}
public void MostrarListaCliente(){
    C.MostrarListaG();
}
public String ToMostrarCliente(ListaG<Cliente> p){
    return C.MosCliente(p);
}
public ListaG<Cliente> getCliente(){
    return C;
}
public boolean ExisteCliente(ListaG<Cliente> p,int cod){
    return C.ExisteCliente(p, cod);
}
public String ObtenerNomCliente(ListaG<Cliente> p,int cod){
    return C.ObtenerNombreCliente(p, cod);
}
public void CargarCliente(String ruta){
    Archivo l = new Archivo();
    String k = l.OpenFile(ruta);
    StringTokenizer t = new StringTokenizer(k);   
    while (t.hasMoreTokens()){
         Cliente h = new Cliente();
        String aux = t.nextToken();
        h.decodifCliente(aux);
        C.InsertarO(h);
  
    }
 }

public void GuardarCliente(String concatenado,String ruta){
    Archivo l=new Archivo();
    l.SaveFile(concatenado, ruta);
}
/////////////////////////////PROVEEDOR/////////////////////////////////
public void RegistrarProveedor(int cod,String nom,String direc,int telf,int nit){
    prov=new Provedor(cod, nom, direc, telf, nit);
    Prov.InsertarO(prov);
}
public void MostrarListaProveedor(){
    Prov.MostrarListaG();
}
public ListaG<Provedor> getProvedor(){
    return Prov;
}
public boolean ExisteProveedor(ListaG<Provedor> p,int cod){//Lo busca mediante el codigo del proveedor
    return Prov.ExisteProveedor(p, cod);
}
public String ObtenerNomProveedor(ListaG<Provedor> p,int cod){
    return Prod.ObtenerNombreProveedor(p, cod);
}
public void CargarProveedor(String ruta){
    Archivo l = new Archivo();
    String k = l.OpenFile(ruta);
    StringTokenizer t = new StringTokenizer(k);
   
    while (t.hasMoreTokens()){
         Provedor h = new Provedor();
        String aux = t.nextToken();
        h.decodifProvedor(aux);
        Prov.InsertarO(h);
    }
}
public void GuardarProvedor(String concatenado,String ruta){
    Archivo l=new Archivo();
    l.SaveFile(concatenado, ruta);
}
public String ToMostrarProvedor(ListaG<Provedor> p){
    return Prov.MosProvedor(p);
}
/////////////////////////////PRODUCTO//////////////////////////////////////
public ListaG<Producto> getProducto(){
    return Prod;
}
public boolean ExisteProducto(ListaG<Producto> p,int cod){
    return Prod.ExisteProducto(p, cod);
}
public void RegistrarProducto(int cod,String nom,String descrip, String marca,String proceden){
    prod=new Producto(cod, nom, descrip, marca, proceden);
    Prod.InsertarO(prod);
}
public void MostrarListaProducto(){
    Prod.MostrarListaG();
}
public void CargarProducto(String ruta){
    Archivo l = new Archivo();
    String k = l.OpenFile(ruta);
    StringTokenizer t = new StringTokenizer(k);
  
    while (t.hasMoreTokens()){
        Producto h = new Producto();
        String aux = t.nextToken();
        h.decodifProducto(aux);
        Prod.InsertarO(h);
    }
}
public String ToMostrarProducto(ListaG<Producto> p){
    return Prod.MosProducto(p);
}
public void GuardarProducto(String concatenado,String ruta){
    Archivo l=new Archivo();
    l.SaveFile(concatenado, ruta);
}
////////////////////////////////////////////////////////////////////////////




}
