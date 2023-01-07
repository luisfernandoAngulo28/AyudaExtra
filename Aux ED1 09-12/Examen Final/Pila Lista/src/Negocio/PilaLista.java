/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class PilaLista {
    Nodo ini; /**CIMA DE LA PILA*/
    int cant;
    public PilaLista (){
    ini= null;
    cant =0;
    }
  public void push (int dato){
  Nodo p = new Nodo(dato);
  if (ini==null){
  ini=p;
  } else {
  p.setEnlace(ini);
  ini=p;
  }
  cant++;
  }
  public Nodo pop() {
     Nodo p = ini;
     ini=ini.getEnlace();
     cant--;
     return p;
     }
  public void push_nodo (Nodo p){
  if (ini==null){
  ini=p;
  } else {
  p.setEnlace(ini);
  ini=p;
  }
  cant++;
  }
 public void insertar_Ultimo (int dato){
     PilaLista p = new PilaLista();
     while (ini!=null){
     p.push(pop().getDato());
     }
     push(dato);
     while (p.ini!=null){
     push(p.pop().getDato());
     }
    }
 public void examen (int dato){
 if (cant%2==0){
 push (dato);
 } else {
 insertar_Ultimo(dato);
 }
 }
 
 
  

    @Override
    public String toString() {
        String s = "Pila[";
        Nodo p = ini;
        for (int i = 1; i <= cant; i++) {
            s = s + "->" + p.getDato();
            p=p.getEnlace();
        }
        s = s + " ]";
        return s;
    }
}

