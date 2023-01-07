/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

import pvectorbit.VectorbitG;
import sun.net.www.content.audio.x_aiff;


public class Cartas { VectorbitG v; // nuevo
                int Sim;
                int Num;
    
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
    
    public Cartas()
    {
       
       Sim=0;
       Num=0;
    }
    
    public Cartas(int Numero, int Simbolo,int Cbits,int Ne)
    {   Sim=Simbolo;
        Num=Numero;
        v=new VectorbitG(Ne, Cbits);      
         
   }
    
    public void SetCarta(int sim,int numero,int pos)
    {  int aux1 = sim;
        aux1= aux1 & 3;
        int aux2 = numero;
        aux2 = aux2 >>> 2;
        aux2 = aux2 & 15;
        int U=unionS_N(aux1,aux2);
        v.insertarE(U, pos);   
    
    }
    public String GetCarta( int pos){
        int y=v.getE(pos);
        int s=GetNumero();
        int x=GetNumero();
        return "";
    }
    
    public int unionS_N(int S, int N){
    int x=N;
       x=x<<2;
       x=x|S;
       return x;
    }
 
    
    public int GetSimbolo()
    {
        int aux = Sim;
        aux = aux & 3;
        return aux;
    }
    
    public int GetNumero()
    {   int aux = Num;
       /* aux = aux >>> 2;
        aux = aux & 15;*/
        return aux;
    }
    
    public void SetSimbolo(int valor)
    {
        int mascara = -4;
        Sim= Sim & mascara;
        Sim =Sim | valor;
    }
    
    public void SetNumero(int valor)
    {
        valor = valor << 2;
        int mascara = -61;
        Num = Num & mascara;
        Num = Num | valor;
    }
    
    @Override
    public String toString()
    {
        String cad = "";
        int simbolo = this.GetSimbolo();
        int numero = this.GetNumero();
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
        Cartas c = new Cartas();
        c.SetNumero(Cartas.C_Q);
        c.SetSimbolo(Cartas.TREBOL);
        c.SetNumero(Cartas.C_A);
        c.SetSimbolo(Cartas.CORAZON);
        c.SetNumero(Cartas.C_8);
        c.SetSimbolo(Cartas.ESPADA);
        c.SetNumero(Cartas.C_J);
        c.SetSimbolo(Cartas.DIAMANTE);
        System.out.println(c);
        
    }

   
}
