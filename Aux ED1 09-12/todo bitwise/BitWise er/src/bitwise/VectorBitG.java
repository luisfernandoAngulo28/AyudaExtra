/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwise;

/**
 *
 * @author Ernesto
 */
public class VectorBitG {   int V[];
                            int Dim;
                            int CBit;
                            int MaxValue;
                            
    public VectorBitG(int CantBit,int NElementos){
        
        if ((CantBit>0 )&& (NElementos>0)){
        int x= (NElementos*CantBit)/32;
            if ((NElementos*CantBit)%32 !=0)
                x++;
            CBit=CantBit;
            V= new int [x];
            Dim= NElementos; 
            
            MaxValue=((int)Math.pow(2,CBit))-1;
        }
            else {
                throw new Error ("Los parametros numero de los elementos o canidad de bits no puede ser cero");
            }
 
    }                        
    
    private int NEntero(int pos){
        return (((pos)*CBit)/32);
    }
    
    private int NBit(int pos){
        return (((pos)*CBit)%32);
    }
    
    public void Insertar(int dato, int pos){
        if((pos>=0)&&(pos<Dim)&&(dato<=MaxValue)){
            int x = NEntero(pos);
            int y = NBit(pos);
            int mask = MaxValue;
            mask = ~(mask << y);
            V[x] &=mask;      
            if ((y + CBit) <= 32){
                dato=dato<<y;
                V[x] |= dato;
            }else{
                int dato1 = dato;
                dato <<= y;
                V[x] |= dato;
                mask = MaxValue;
                dato1 = dato1 >>> 32-y;
                mask = ~(mask >>> 32-y);
                V[x+1] = (V[x+1]&mask)|dato1;
            }
        }else throw new Error("Posicion fuera de rango,dato excedió el rango");
    }
        
    public int sacar(int pos){
        if ((pos >= 0)&&(pos < Dim)){
            int x = NEntero(pos);
            int y = NBit(pos);
            int aux = V[x];
            int mask = MaxValue;
            mask = mask << y;
            aux = aux & mask;
            aux = aux >>> y;
            if (y + CBit > 32){
                int aux2 = V[x+1];
                mask = MaxValue;
                mask = mask >>> 32-y;
                aux2 = mask & aux2;
                aux2 = aux2 << 32-y;
                aux = aux|aux2;
            }
            return aux;
        }else  return 0;
    }
}
