/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bismarck
 */
public class BitWise {

    int v[];
    int dim;
    int NBits;
    int ri;
    int rf;

    private int NEnt(int pos) {
        return ((pos - 1) * NBits) / 32;
    }

    private int NBit(int pos) {
        return ((pos - 1) * NBits) % 32;
    }

    public BitWise(int CantElem, int ri, int rf) {
        int x = (rf - ri) + 1; //calculo de la cant de bits
        this.NBits = (int) Math.floor(((Math.log10(x)) / Math.log10(2)) + 2);
        int y = ((CantElem * NBits) % 32);
        int z = ((CantElem * NBits) / 32);
        if (y == 0) {
            this.v = new int[z];
        } else {
            z++;
            this.v = new int[z];
        }
        this.dim = CantElem;
        this.ri = ri;
        this.rf = rf;
        for (int i = 0; i < z; i++) {
            v[i] = 0;
        }
    }

    public void setDato(int pos, int dato) throws Exception {
        if (dato >= ri && dato <= rf) {
            if (pos <= dim) {
                int x = NEnt(pos);
                int y = NBit(pos);
                if (y + NBits <= 32) {
                    dato = dato << y;
                    int mask = (int) Math.pow(2, NBits) - 1;
                    mask = mask << y;
                    mask = ~mask;
                    v[x] = v[x] & mask;
                    v[x] = v[x] | dato;
                } else {
                    int datoAux = dato;
                    dato = dato << y;
                    int mask = (int) Math.pow(2, NBits) - 1;
                    mask = mask << y;
                    mask = ~mask;
                    v[x] = v[x] & mask;
                    v[x] = v[x] | dato;
                    datoAux = datoAux >>> 32 - y;
                    mask = (int) (Math.pow(2, NBits) - 1);
                    mask = mask >>> 32 - y;
                    mask = ~mask;
                    v[x + 1] = v[x + 1] & mask;
                    v[x + 1] = v[x + 1] | datoAux;
                }
            } else {
                throw new Exception("Bitwise::setDato:: ERROR: Posicion Fuera de Rango");
            }
        } else {
            throw new Exception("Bitwise::setDato::ERROR: Dato Fuera de Rango");
        }
    }

    public int getDato(int pos) throws Exception {
        if (pos <= dim) {
            int x = NEnt(pos);
            int y = NBit(pos);
            int num = v[x];
            int mask = (int) Math.pow(2, NBits) - 1;
            num = num >>> y;
            num = num & mask;
            if (y + NBits > 32) {
                int numAux = v[x + 1];
                mask = (int) Math.pow(2, NBits) - 1;
                mask = mask >>> 32 - y;
                numAux = numAux & mask;
                numAux = numAux << 32 - y;
                num = num | numAux;
            }
            return num;
        } else {
            throw new Exception("ERROR: Posicion Fuera de Rango");
        }
    }

    public void dimensionar(int nuevoDim) {
        BitWise bb = new BitWise(nuevoDim, this.ri, this.rf);
        int ne = (dim * NBits) / 32;
        if ((dim * NBits) % 32 != 0) {
            ne++;
        }
        System.arraycopy(this.v, 0, bb.v, 0, ne);
        this.v = bb.v;
        this.dim = nuevoDim;
    }

    @Override
    public String toString() {
        String s = "";
        try {
            for (int i = dim; i > 0; i--) {
                s += "  " + Integer.toString(getDato(i));
            }

        } catch (Exception ex) {
            Logger.getLogger(BitWise.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}
