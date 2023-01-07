package PilaDinamica;



public class PilaDinamica {

            Nodo cima;//P
            int cant;///tope
            
    public PilaDinamica()
    {
        cima = null;
        cant = 0;
    }
    
    public void push(String dato)
    {
        Nodo aux = new Nodo(dato);
        if (aux != null)
        {
            aux.setEnlace(cima);
            cima = aux;
            cant++;
        }else
            System.out.println("Error: La memoria de la computadora esta llena");
    }
    
    public String pop(boolean sw)
    {
        String x = "";
        sw = !vacia();
        if ( sw )
        {
            x = cima.getDato();
            cima = cima.getEnlace();
            cant--;
        }else
            System.out.println("Error: la pila esta vacia");
        return x;
    }
    
    public boolean vacia()
    {
        return (cant==0);
    }
    
    public String get(boolean sw)
    {
        String x = "";
        sw = !vacia();
        if ( sw )
            x = cima.getDato();
        else
            System.out.println("Error: la pila esta vacia");
        return x;
    }
    
    @Override
    public String toString()
    {
        String s = "";
        Nodo aux = cima;
        for (int i = 0; i < cant; i++) {
            s = s + " & " + aux.getDato();
            aux = aux.getEnlace();
        }
        return s;
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
