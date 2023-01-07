/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pvectorbit;


public class carta { VectorbitG v;

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
    
    public carta()
    {
        n = 0;
    }
    
    public carta(int Numero, int Simbolo,int Ne, int Cb)
    {  v=new VectorbitG(Ne, Cb);
        n = Numero;
        n = n << 2;
        n = n | Simbolo;
        v.insertarE(n, 1);
    }
    
    public carta(carta copia)
    {
        this.n = copia.n;
    }
    
    public int getSimbolo(int p)
    {
        int aux = v.getE(p);
        aux = aux & 3;
        return aux;
    }
    
    public int getNumero(int p)
    {   int aux = v.getE(p);
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
    public void SetCartaV(int pos){
        v.insertarE(n, pos);
    }
    

    public String toString(int p)
    {    
        String cad = "";
        int simbolo = this.getSimbolo(p);
        int numero = this.getNumero(p);
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
       // VectorbitG vb=new VectorbitG(11,6);
        carta c = new carta(carta.C_A,carta.CORAZON,11,6);
         c.setNumero(carta.C_2);
         c.setSimbolo(carta.DIAMANTE);
       //vb.insertarE((int)(c.getNumero()+c.getSimbolo()),2);
         c.SetCartaV(2);
          c.setNumero(carta.C_3);
         c.setSimbolo(carta.ESPADA);
         c.SetCartaV(3);
          c.setNumero(carta.C_4);
         c.setSimbolo(carta.TREBOL);
         c.SetCartaV(4);
         c.setNumero(carta.C_9);
         c.setSimbolo(carta.ESPADA);
         c.SetCartaV(5);
         
         for (int i = 1; i <=5; i++) {
         System.out.println(c.toString(i));
         
        }
        
        

    }    
}
