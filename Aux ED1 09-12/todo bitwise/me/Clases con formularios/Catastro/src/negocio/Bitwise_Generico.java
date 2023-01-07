/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author MiguelAngel
 */
public class Bitwise_Generico {
    private int V[];
    private byte Cant_Bits;
    private int Max_e;
    
    public Bitwise_Generico(int cant, byte cant_Bits){
        Cant_Bits = cant_Bits;
        Max_e = cant;
        int X = (cant * Cant_Bits)/ 32;
        if (((cant * Cant_Bits)%32) != 0) {
            X++;
        }
        V = new int [X];
    }
    
    public byte Num_Bit(int pos){
        return (byte) (((pos -1)*Cant_Bits)%32);
    }
    
    public int Num_Ent(int pos){
        return (((pos -1)*Cant_Bits)/ 32);
    }
    
    public void insetar(int dato, int pos){
        int dato_1 = dato;
        byte Nb = Num_Bit(pos);
        int  Ne = Num_Ent(pos);
        int mask = (int)Math.pow(2, Cant_Bits)-1;
        
        mask = mask << Nb;
        mask = ~mask;
        V[Ne] = V[Ne] & mask;
        dato = dato << Nb;
        V[Ne] = V[Ne] | dato;
        
        if (Nb + Cant_Bits > 32) {
            mask = (int)Math.pow(2, Cant_Bits)-1;
            mask = mask >>> (32 - Nb);
            V[Ne +1] = V[Ne +1] & mask;
            dato_1 = dato_1 >>>(32 - Nb);
            V[Ne +1] = V[Ne +1] | dato_1;
        }
    }
    
    public int getDato(int pos){
        byte Nb = Num_Bit(pos);
        int  Ne = Num_Ent(pos);
        int mask = (int)Math.pow(2, Cant_Bits)-1;
        int dato = V[Ne];
        dato = dato >>> Nb;
        if (Nb + Cant_Bits > 32) {
            int dato_1 = V[Ne +1];
            dato_1 = dato_1 << (32 -Nb);
            dato = dato | dato_1;
        }
        dato = dato & mask;
        return dato;
    }
    
    public void eliminar(int pos){
        byte Nb = Num_Bit(pos);
        int  Ne = Num_Ent(pos);
        int mask = (int)Math.pow(2, Cant_Bits)-1;
        mask = ~(mask << Nb);
        V[Ne] = V[Ne] & mask;
        
        if (Nb + Cant_Bits > 32) {
            mask = (int)Math.pow(2, Cant_Bits)-1;
            mask = ~(mask >>> (32 -Nb));
            V[Ne +1] = V[Ne +1] & mask;
        }       
    }
    
    public void ampliar(int cant){
        int X = ((Max_e + cant)*Cant_Bits)/32;
        if ((((Max_e + cant)*Cant_Bits) %32) != 0) {
            X++;
        }
        int aux[] = new int [X];
        int y = V.length -1;
        System.arraycopy(V, 0, aux, 0, y);
        
        V = new int [X];
        System.arraycopy(aux, 0, V, 0, y);
        Max_e = Max_e + cant;
    }
    
    public int lenght(){
        return (V.length);
    }
}
