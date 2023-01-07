/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwise;

import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author Ernesto
 */
public class ConjuntosBit {int A;
    
    public ConjuntosBit(){
            A=0;                            
    }
    
    public void set(byte pos,byte valor){
        if (valor==1){
            A=set1(A,pos);
        }else{
            A=set0(A,pos);
        }            
    }
    
    private int set1(int z,byte pos){
        int aux=1;
        aux<<=pos-1;
        z|=aux;
        return z;                    
    }
    private int set0(int z,byte pos){
        int aux=1;
        return z&(~(aux<<pos-1));
    }
    
    public int Getbit(byte pos){
        int aux=1;
        aux<<=pos-1;
        aux&=A;
        aux>>>=pos-1;
        return aux;
    }
    
    public void insetar(int dato){
        if (dato<=30){
            set((byte)dato,(byte)1);
        }
    }
    
    public void eliminar(int dato){
        if (dato<=30){
            set((byte)dato,(byte)0);
        }            
    }
    
}
