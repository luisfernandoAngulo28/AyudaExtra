/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete;

import com.sun.org.apache.xpath.internal.axes.AxesWalker;

/**
 *
 * @author itachi
 */
public class ListaD {
    NodoD Izq;
    NodoD Der;
    int nroNodo;
public ListaD(){
    Izq=null;
    Der=null;
    nroNodo=0;
}
public void InsertarP(int valor){
    NodoD p=new NodoD(valor);
    if(Izq==null){
        Izq=p;
        Der=p;
        nroNodo++;
    }
    else{
        p.setEnlaceDer(Izq);
        Izq.setEnlaceIzq(p);
        Izq=p;
        nroNodo++;
    }
}
/////////////////////////////////////////////////////////////////////////////
public void InsertarUl(int valor){
    NodoD p=new NodoD(valor);
    if(Der==null){
        Izq=p;
        Der=p;
        nroNodo++;
    }
    else{
        p.setEnlaceIzq(Der);
        Der.setEnlaceDer(p);
        Der=p;
        nroNodo++;
    }
}
/////////////////////////////////////////////////////////////////////////////
private void InsertarR(NodoD Aizq,int valor){
    if(Izq==null){
        NodoD p=new NodoD(valor);
        Izq=p;
        Der=p;
        nroNodo++;
    }
    else{
        if(Aizq.getData()>valor){
            NodoD p=new NodoD(valor);
            p.setEnlaceDer(Izq);
            Izq.setEnlaceIzq(p);
            Izq=p;
            nroNodo++;
        }
        else{
            if(Aizq.getData()<valor && Aizq.getEnlaceDer()==null){
                NodoD p=new NodoD(valor);
                Der.setEnlaceDer(p);
                p.setEnlaceIzq(Der);
                Der=p;
                nroNodo++;
            }
            else{
                if(Aizq.getEnlaceDer().getData()>valor){
                    NodoD p=new NodoD(valor);
                    p.setEnlaceDer(Aizq.getEnlaceDer());
                    Aizq.getEnlaceDer().setEnlaceIzq(p);
                    Aizq.setEnlaceDer(p);
                    p.setEnlaceIzq(Aizq);
                    nroNodo++;
                }
                else{
                    InsertarR(Aizq.getEnlaceDer(), valor);
                }
            }

        }
    }
}
public void Insertar(int valor){
    InsertarR(Izq,valor);
}
/////////////////////////////////////////////////////////////////////////////
private void EliminarR(NodoD Aux,int valor){
    if(Aux==null){
    }
    else{
        if(Aux.getData()==valor && Izq==Der){
            Izq=null;
            Der=null;
            nroNodo++;
        }
        else{
            if(Aux.getData()==valor){
                Izq=Aux.getEnlaceDer();
                Aux.getEnlaceDer().setEnlaceIzq(null);
                nroNodo++;
            }
            else{
                if(Aux.getData()!=valor && Aux.getEnlaceDer()==null){
                }
                else{
                    if(Aux.getEnlaceDer().getData()==valor && Aux.getEnlaceDer().getEnlaceDer()==null){
                        Der=Aux;
                        Aux.setEnlaceDer(null);
                    }
                    else{
                        if(Aux.getEnlaceDer().getData()==valor){
                            Aux.getEnlaceDer().getEnlaceDer().setEnlaceIzq(Aux);
                            Aux.setEnlaceDer(Aux.getEnlaceDer().getEnlaceDer());
                        }
                        else{
                            EliminarR(Aux.getEnlaceDer(), valor);
                        }
                    }
                }
            }
        }
    }
}
public void Eliminar(int valor){
    EliminarR(Izq,valor);
}
/////////////////////////////////////////////////////////////////////////////
public String Mostar(){   //Para mostrar la lista, cuando se use System.out.println(ListaX);
        String S="L =[";
        String Coma ="";
        NodoD p=Izq;
        while (p!=null){
            S += Coma+p.getData();
            Coma =", ";
            p=p.getEnlaceDer();
        }
        return S + "]";
    }
}
