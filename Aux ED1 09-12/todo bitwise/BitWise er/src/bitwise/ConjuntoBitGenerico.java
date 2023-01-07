/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwise;

/**
 *
 * @author Ernesto
 */
public class ConjuntoBitGenerico {  int CG[];
                                    int Inicio;
                                    int Fin;
    public ConjuntoBitGenerico(int RangoMenor, int RangoMayor){
        int cant=RangoMayor-RangoMenor+1;
        if (cant%31==0)
            CG=new int[cant/31];
        else CG=new int[(cant/31)+1];        
        Inicio=RangoMenor;
        Fin=RangoMayor;
    }
    private int NEntero(int datoImg){
        return (datoImg/32);
    }
    
    private int NBit(int datoImg){
        return (datoImg%32);
    }
    public void Insertar(int dato,int valor){
        int datoImg=dato-Inicio;
        int x=NEntero(datoImg);
        int y=NBit(datoImg);
        if (valor==1)
            CG[x]=set1(CG[x],(byte)y);
        else   CG[x]=set0(CG[x],(byte)y);        
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
    public int Getbit(byte datoImg){
        int x=NEntero(datoImg);
        int y=NBit(datoImg);                
        int aux=1;
        aux<<=y-1;
        aux&=CG[x];
        aux>>>=y-1;
        return aux;
    }
}
