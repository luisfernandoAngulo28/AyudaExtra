/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete.Negocio;

import Paquete.Aplicacion.Cliente;
import Paquete.Aplicacion.Producto;
import Paquete.Aplicacion.Provedor;


/**
 *
 * @author itachi
 */
public class ListaG <TObjeto extends Comparable>{
    NodoG<TObjeto> L;
    int NroNodo;
public ListaG(){
    L=null;
    NroNodo=0;
}
public void InsetarP(TObjeto valor){
    NodoG p=new NodoG();
    p.SetData(valor);
    if(L==null){
        L=p;
        NroNodo++;
    }
    else{
        p.SetEnlace(L);
        L=p;
        NroNodo++;
    }
}
public void InsertarO(TObjeto e){
    NodoG p= new NodoG <TObjeto>();
    p.SetData(e);
    if (NroNodo==0) { //la lista esta vacia
        L=p;
        NroNodo++;
    }else{ //la lista tiene elementos
        NodoG<TObjeto> ant = null; //punteros
        NodoG<TObjeto> aux = L;
        while ((aux!=null)&&(aux.GetData().compareTo(e)<0)) {
            ant=aux;
            aux=aux.GetEnlace();
        }
        if (ant==null) {
            p.SetEnlace(L);
            L=p;
            NroNodo++;
        }else{
            ant.SetEnlace(p);
            p.SetEnlace(aux);
            NroNodo++;
        }
    }
}
public void MostrarListaG(){
    NodoG<TObjeto> Aux=L;
    while(Aux!=null){
        System.out.println("-------------------------------------------------------------------");
        System.out.println(Aux.GetData().toString());//toString es un metodo de la clase Comparable
        Aux=Aux.GetEnlace();                         //Al parecer solo el objeto tiene acceso a los metodos
    }                                                //de la clase Comparar
     System.out.println("-------------------------------------------------------------------");
}
public boolean Existe(TObjeto x){
    NodoG<TObjeto> p = L;
    while(p != null){
        if( p.GetData()== x)
            return true;
        p = p.GetEnlace();
        break;
    }
    return false;
}
////////////////////////PROVEEDOR//////////////////////////////////////////
public boolean ExisteProveedor(ListaG<Provedor> t,int cod){
    NodoG<Provedor> p=t.L;
    boolean a=false;
    while(p!=null){
        if(p.GetData().GetCodigo()==cod){
            return true;
        }
        p=p.GetEnlace();
    }
    return a;
}
public String ObtenerNombreProveedor(ListaG<Provedor> t,int cod){
    NodoG<Provedor> p=t.L;
    boolean a=false;
    while(p!=null){
        if(p.GetData().GetCodigo()==cod){
            return p.GetData().GetNombre();
        }
        p=p.GetEnlace();
    }
    return "";
}
public String MosProvedor(ListaG<Provedor> t){
    String todo="";
        NodoG<Provedor> p=t.L;
    while(p!=null){
       todo=todo+p.GetData().GetCodigo()+","+p.GetData().GetNombre()+","+p.GetData().GetDireccion()+","+p.GetData().GetTelefono()+","+p.GetData().GetNit()+","+"\n";
        p=p.GetEnlace();
    }
        return todo;
}
/////////////////////////////////////////////////////////////////////////////
//////////////////////////////CLIENTE///////////////////////////////////////////
public boolean ExisteCliente(ListaG<Cliente> t,int cod){
    NodoG<Cliente> p=t.L;
    boolean a=false;
    while(p!=null){
        if(p.GetData().GetCodigo()==cod){
            return true;
        }
        p=p.GetEnlace();
    }
    return a;
}
public String ObtenerNombreCliente(ListaG<Cliente> t,int cod){
    NodoG<Cliente> p=t.L;
    boolean a=false;
    while(p!=null){
        if(p.GetData().GetCodigo()==cod){
            return p.GetData().GetNombre();
        }
        p=p.GetEnlace();
    }
    return "";
}
public String MosCliente(ListaG<Cliente> t){
    String todo="";
        NodoG<Cliente> p=t.L;
    while(p!=null){
       todo=todo+p.GetData().GetCodigo()+","+p.GetData().GetNombre()+","+p.GetData().GetDireccion()+","+p.GetData().GetTelefono()+","+p.GetData().GetNit()+","+"\n";
        p=p.GetEnlace();
    }
        return todo;
}
/////////////////////////////////////////////////////////////////////////////
////////////////////////PRODUCTO/////////////////////////////////////////////
public String MosProducto(ListaG<Producto> t){
    String todo="";
        NodoG<Producto> p=t.L;
    while(p!=null){
       todo=todo+p.GetData().GetCodigo()+","+p.GetData().GetNombre()+","+p.GetData().GetDescripcion()+","+p.GetData().GetMarca()+","+p.GetData().GetProcedencia()+","+"\n";
        p=p.GetEnlace();
    }
        return todo;
}
public boolean ExisteProducto(ListaG<Producto> t,int cod){
    NodoG<Producto> p=t.L;
    boolean a=false;
    while(p!=null){
        if(p.GetData().GetCodigo()==cod){
            return true;
        }
        p=p.GetEnlace();
    }
    return a;
}
}

