
/**
 * Ayudantia 1/2016 Aux. Eddy Escalante
 */
public class Cola {

            Nodo prin;
            Nodo fin;
            int cant;
            
    public Cola()
    {
        prin = null;
        fin = null;
        cant = 0;
    }
    
    public void meter(int dato)
    {
        Nodo aux = new Nodo(dato);
        if ( aux != null)
        {
            if ( vacia() )
                prin = fin = aux;
            else
            {
                fin.setEnlace(aux);
                fin = aux;
            }
            cant++;
        }else
            System.out.println("Error: La memoria de la computadora esta llena");
    }
    
    public boolean vacia()
    {
        return (cant == 0);
    }
    
    public int sacar(boolean sw)
    {
        int x = 0;
        sw = !vacia();
        if (sw)
        {
            x = prin.getDato();
            prin = prin.getEnlace();
            cant--;
        }else
            System.out.println("Error: La cola esta vacia");
        return x;
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
