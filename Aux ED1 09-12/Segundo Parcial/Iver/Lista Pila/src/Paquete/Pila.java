/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete;

/**
 *
 * @author itachi
 */
public class Pila {
    Nodo L;
public Pila(){
    L=null;
}
private void Insertar(Nodo Aux,int valor){
    if(Aux==null){
        Nodo p=new Nodo(valor);
        L=p;
    }
    else{
        if(Aux.getData()>valor){
            Nodo p=new Nodo(valor);
            p.setEnlace(Aux);
            L=p;
        }
        else{
            if(Aux.getData()<valor && Aux.getEnlace()==null){
                Nodo p=new Nodo(valor);
                Aux.setEnlace(p);
            }
            else{
                if(Aux.getEnlace().getData()>valor){
                    Nodo p=new Nodo(valor);
                    p.setEnlace(Aux.getEnlace());
                    Aux.setEnlace(p);
                }
                else{
                    Insertar(Aux.getEnlace(), valor);
                }
            }
        }
    }
}
/////////////////////////////////////////////////////////////////////////////
private void PushOrd2(Nodo Aux,int valor){

}
private void PushOrd1(Nodo Aux,int valor){
    if(Aux==null){
    }
    else{
        if(Aux.getEnlace()==null){
            PushOrd2(Aux,valor);
        }
        else{
            PushOrd1(Aux.getEnlace(), valor);
        }
    }
}
public void PushOrd(int valor){
    PushOrd1(L,valor);
}
/////////////////////////////////////////////////////////////////////////////
private void InsertarUl(Nodo Aux,int valor){
    if(Aux==null){
        Nodo p=new Nodo(valor);
        L=p;
    }
    else{
        if(Aux.getEnlace()==null){
            Nodo p=new Nodo(valor);
            Aux.setEnlace(p);
        }
        else{
            InsertarUl(Aux.getEnlace(), valor);
        }
    }
}
public void Push(int valor){
    InsertarUl(L,valor);
}
/////////////////////////////////////////////////////////////////////////////
private  void EliminarUl(Nodo Aux){
    if(Aux.getEnlace()==null || Aux==null){
        L=null;
    }
    else{
        if(Aux.getEnlace().getEnlace()==null){
            Aux.setEnlace(null);
        }
        else{
            EliminarUl(Aux.getEnlace());
        }
    }
}
/////////////////////////////////////////////////////////////////////////////
private int SacarUl(Nodo Aux){
    int x;
    if(Aux==null){
        System.out.println("Plia::Pop::La pila esta vacia");
        return 0;
    }
    else{
        if(Aux.getEnlace()==null){
            x= Aux.getData();
            EliminarUl(L);
        }
        else{
            x= SacarUl(Aux.getEnlace());
        }
    }
    
    return x;
}
public int Pop(){
    return SacarUl(L);
}
/////////////////////////////////////////////////////////////////////////////
public String Mostrar(){
    String t="L =[";
    String coma="";
    Nodo p=L;
    while(p!=null){
        t=t+coma+p.getData();
        coma=", ";
        p=p.getEnlace();
    }
    t=t+"]";
    return t;
}
}
