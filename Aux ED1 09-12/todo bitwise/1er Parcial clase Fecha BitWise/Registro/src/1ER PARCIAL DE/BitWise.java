/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Roly
 */
public class BitWise {


    int V[];
    int Nbits;
    int Dim;

    private int NEnt(int pos) {
        return ((pos - 1) * Nbits) / 32;
    }

    private int NBit(int pos) {
        return ((pos - 1) * Nbits) % 32;
    }

    public BitWise(int CantElem, int CantBit) {
        int x = (CantBit * CantElem) / 32;
        if ((CantBit * CantElem % 32) != 0) {
            x++;
        }
        this.V = new int[x];
        this.Nbits = CantBit;
        this.Dim = CantElem;
    }

    public void SetDato(int pos, int dato) throws Exception {
        if (dato <= Math.pow(2, this.Nbits) - 1) {
            if (pos <= Dim) {
                int x = NEnt(pos);
                int y = NBit(pos);
                if (y + Nbits <= 32) {
                    dato = dato << y;
                    int mask = (int) Math.pow(2, this.Nbits) - 1;
                    mask = mask << y;
                    mask = ~mask;
                    V[x] = V[x] & mask;
                    V[x] = V[x] | dato;
                } else {
                    int datoaux = dato;
                    dato = dato << y;
                    int mask = (int) Math.pow(2, this.Nbits) - 1;
                    int maskaux = mask;
                    mask = mask << y;
                    mask = ~mask;
                    V[x] = V[x] & mask;
                    V[x] = V[x] | dato;
                    datoaux = datoaux >>> (32 - y);
                    maskaux = maskaux >>> (32 - y);
                    maskaux = ~maskaux;
                    V[x + 1] = V[x + 1] & maskaux;
                    V[x + 1] = V[x + 1] | datoaux;
                }

            } else {
                throw new Exception("Error:Posicion Fuera de Rango");
            }
        } else {
            throw new Exception("Error:Fuera de Rango");
        }
    }

    public int GetDato(int pos) throws Exception {
        if (pos <= this.Dim) {
            int x = NEnt(pos);
            int y = NBit(pos);
            int num = V[x];
            int mask = (int) Math.pow(2, Nbits) - 1;
            num = num >>> y;
            num = num & mask;
            if (y + Nbits > 32) {
                int num2 = V[x + 1];
                int mask2 = (int) Math.pow(2, Nbits) - 1;
                mask2 = mask2 >>> (32 - y);
                num2 = num2 & mask2;
                num2 = num2 << (32 - y);//recorro la parte alta
                num = num | num2;
            }
            return num;
        } else {
            throw new Exception("Error:Posicion Fuera de Rango");
        }
    }
    public String Mostrar() throws Exception{
    String s = "";
        for (int i = Dim; i > 0; i--) {
          s = s + Integer.toString(GetDato(i))+ " ";  
        }
        return s;
    
    }

}