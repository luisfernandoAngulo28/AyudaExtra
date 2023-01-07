package PilaDinamica;


public class Nodo {

            String dato;
            Nodo enlace;
            
    public Nodo(String dato)
    {
        this.dato = dato;
        enlace = null;
    }
    
    public void setDato(String dato)
    {
        this.dato = dato;
    }
    
    public void setEnlace(Nodo n)
    {
        this.enlace = n;
    }
    
    public String getDato()
    {
        return dato;
    }
    
    public Nodo getEnlace()
    {
        return enlace;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
