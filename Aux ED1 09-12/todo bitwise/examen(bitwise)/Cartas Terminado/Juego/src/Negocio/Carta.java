
package Negocio;

public class Carta {
    int n;
    
    public static final int CORAZON = 0;
    public static final int DIAMANTE = 1;
    public static final int ESPADA = 2;
    public static final int TREBOL = 3;
    
    public static final int C_A = 0;
    public static final int C_2 = 1;
    public static final int C_3 = 2;
    public static final int C_4 = 3;
    public static final int C_5 = 4;
    public static final int C_6 = 5;
    public static final int C_7 = 6;
    public static final int C_8 = 7;
    public static final int C_9 = 8;
    public static final int C_10 = 9;
    public static final int C_J = 10;
    public static final int C_Q = 11;
    public static final int C_K = 12;
    
    public Carta()
    {
        n = 0;
    }
    
    public Carta(int Numero, int Simbolo)
    {
        n = Numero;
        n = n << 2;
        n = n | Simbolo;
    }
    
    public Carta(Carta copia)
    {
        this.n = copia.n;
    }
    
    public int getSimbolo()
    {
        int aux = n;
        aux = aux & 3;
        return aux;
    }
    
    public int getNumero()
    {   int aux = n;
        aux = aux >>> 2;
        aux = aux & 15;
        return aux;
    }
    
    public void setSimbolo(int valor)
    {
        int mascara = -4;
        n = n & mascara;
        n = n | valor;
    }
    
    public void setNumero(int valor)
    {
        valor = valor << 2;
        int mascara = -61;
        n = n & mascara;
        n = n | valor;
    }
    
    @Override
    public String toString()
    {
        String cad = "";
        int simbolo = this.getSimbolo();
        int numero = this.getNumero();
        switch(simbolo)
        {
            case CORAZON: cad = "Corazon "; break;
            case DIAMANTE: cad = "Diamante "; break;
            case ESPADA: cad = "Espada ";break;
            case TREBOL: cad = "Trebol ";break;
        }
        switch(numero)
        {
            case C_A: cad = cad + "A"; break;
            case C_2: cad = cad + "2"; break;
            case C_3: cad = cad + "3";break;
            case C_4: cad = cad + "4";break;
            case C_5: cad = cad + "5";break;
            case C_6: cad = cad + "6";break;
            case C_7: cad = cad + "7";break;
            case C_8: cad = cad + "8";break;
            case C_9: cad = cad + "9";break;
            case C_10: cad = cad + "10";break;
            case C_J: cad = cad + "J";break;
            case C_Q: cad = cad + "Q";break;
            case C_K: cad = cad + "K";break;
        }
        return cad;
    }
    
    public static void main(String[] args)
    {
        Carta c = new Carta();
        c.setNumero(Carta.C_Q);
        c.setSimbolo(Carta.TREBOL);
 
        
        
        System.out.println(c);
        
    }
}
