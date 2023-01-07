package proyecto2;

public class Nodo {
      
   public Nodo enlace;
   public String dato;
    
    public Nodo(){
        enlace=null;
        dato="";
    }

    public String getdato() {
        return dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setdato(String ele) {
        this.dato = ele;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
}
