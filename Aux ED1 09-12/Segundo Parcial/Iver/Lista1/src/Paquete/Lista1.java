/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete;

/**
 *
 * @author itachi
 */
public class Lista1 {
    Nodo L;
    int nroNodo;
public Lista1(){
    L=null;
    nroNodo=0;
}
public void InsertarP(int valor){
    Nodo p=new Nodo(valor);
    if(L==null){
        L=p;
        nroNodo++;
    }
    else{
        p.setEnlace(L);
        L=p;
        nroNodo++;
    }
}
public String MostrarLista(){   //Para mostrar la lista, cuando se use System.out.println(ListaX);
        String S="L =[";
        String Coma ="";
        Nodo p=L;
        while (p!=null){
            S += Coma+p.getData();
            Coma =", ";
            p=p.getEnlace();
        }
        return S + "]";
}
//////////////////////////////////////////////////////////////////////////////
private void InsertarU(Nodo Aux,int valor){
    if(L==null){
        Nodo p=new Nodo(valor);
        L=p;
        nroNodo++;
    }
    else{
        if(Aux.getEnlace()==null){
            Nodo p=new Nodo(valor);
            Aux.setEnlace(p);
            nroNodo++;
        }
        else{
            InsertarU(Aux.getEnlace(), valor);
        }
    }
}
public void InsertarUl(int valor){
    InsertarU(L,valor);
}
//////////////////////////////////////////////////////////////////////////////
private void EliminarR(Nodo Aux,int valor){
    if(L==null){
    }
    else{
        if(Aux.getData()==valor){
            L=Aux.getEnlace();
            nroNodo--;
        }
        else{
            if(Aux.getData()!=valor && Aux.getEnlace()==null){
            }
            else{
                if(Aux.getEnlace().getData()==valor){
                    Aux.setEnlace(Aux.getEnlace().getEnlace());
                    nroNodo--;
                }
                else{
                    EliminarR(Aux.getEnlace(), valor);
                }
            }
        }
      
    }
}
public void Eliminar(int valor){
    EliminarR(L,valor);
}
//////////////////////////////////////////////////////////////////////////////
private void OrdenarR1(Nodo Aux){
    if(Aux==null || Aux.getEnlace()==null){     
    }
    else{
        if(Aux.getData()>Aux.getEnlace().getData()){
            int x=Aux.getData();
            Aux.setData(Aux.getEnlace().getData());
            Aux.getEnlace().setData(x);
            OrdenarR1(Aux.getEnlace());
        }
        else{
            OrdenarR1(Aux.getEnlace());
        }
    }
}
private void OrdenarR(Nodo Aux){
    if(Aux==null || Aux.getEnlace()==null){
    }
    else{
        OrdenarR1(L);
        OrdenarR(Aux.getEnlace());
    }
}
public void Ordenar(){
    OrdenarR(L);
}
//////////////////////////////////////////////////////////////////////////////
private void InvertirR(Nodo Aux){
    if(Aux==null || Aux.getEnlace()==null){
        L=Aux;
    }
    else{
        InvertirR(Aux.getEnlace());
        Aux.getEnlace().setEnlace(Aux);
        Aux.setEnlace(null);
    }
}
public void Invertir(){
    InvertirR(L);
}
//////////////////////////////////////////////////////////////////////////////
private void InsertarR(Nodo Aux,int valor){
    if(Aux==null){
        Nodo p=new Nodo(valor);
        L=p;
        nroNodo++;
    }
    else{
        if(Aux.getData()>valor){
            InsertarP(valor);
        }
        else{
            if(Aux.getData()<valor && Aux.getEnlace()==null){
                InsertarUl(valor);
            }
            else{
                if(Aux.getEnlace().getData()>valor){
                    Nodo p=new Nodo(valor);
                    p.setEnlace(Aux.getEnlace());
                    Aux.setEnlace(p);
                    nroNodo++;
                }
                else{
                    InsertarR(Aux.getEnlace(), valor);
                }
            }
        }
    }
}
public void Insertar(int valor){
    InsertarR(L,valor);
}
}
