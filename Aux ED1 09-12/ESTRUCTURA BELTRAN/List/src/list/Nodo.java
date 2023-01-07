package list;

public class Nodo {
    
    Nodo enlace;
    int dato;
    
    public Nodo(){
        enlace=null;
        dato=0;
    }

    public int getdato() {
        return dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setdato(int ele) {
        this.dato = ele;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
    
}
