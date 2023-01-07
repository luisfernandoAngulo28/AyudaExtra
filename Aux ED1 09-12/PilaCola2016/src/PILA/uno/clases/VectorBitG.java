/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno.clases;

/**
 * Ayudantia 1/2016 Eddy Escalante
 */
public class VectorBitG {
// atributos 

    int v[];
    int cant;
    int cbits;
    int ri;
    int rf;
    
// constructor parametrizado        

    public VectorBitG(int canti, int rin, int rfi) {
        int x = (rf - ri) + 1;
        int i = 1;
        while (((int) Math.pow(2, i)) <= x) {
            i++;
        }
        cbits = i;
        int z = (canti * cbits) % 32;
        int y = (canti * cbits) / 32;
        if (z == 0) {
            v = new int[y];
        } else {
            y++;
            v = new int[y];
        }
        for (int j = 0; j < y; j++) {
            v[j] = 0;
        }
        cant = canti;
        ri = rin;
        rf = rfi;
    }
// entero que voy a trabajar
    public int Nentero(int pos) {
        return (((pos - 1) * cbits) / 32);
    }
// pos desde donde voy a trabajar        
    public int Nbits(int pos) {
        return ((((pos - 1) * cbits) % 32) + 1);
    }

// meter dato
    public void SetData(int pos, int dato) {
        if ((dato >= ri) && (dato <= rf)) {
            int x = Nentero(pos);
            int y = Nbits(pos);
            int m = ((int) Math.pow(2, cbits)) - 1;
            m = m << y - 1;
            m = ~m;
            v[x] = v[x] & m;
            dato = dato - ri;
            int dato1 = dato;
            dato = dato << y - 1;
            v[x] = v[x] | dato;
            int f = ((y - 1) + cbits) - 32; // si f>0 faltan bits
                if (f > 0) {
                     v[x + 1] = v[x + 1] >>> f;
                     v[x + 1] = v[x + 1] << f;
                     dato1 = dato1 >>> (cbits - f);
                     v[x + 1] = v[x + 1] | dato1;
                }

        }
     }
 // sacar dato
    public int GetData(int pos){
        if (pos<=cant){   
            int x=Nentero(pos);
            int y=Nbits(pos);
            int z=v[x];
            z=z>>>y-1;
            int m=((int)Math.pow(2, cbits))-1;
            z=z&m;
            int f=((y-1)+cbits)-32;
                    if (f>0){
                        int w=v[x+1];
                        w=w<<(cbits-f);
                        w=w&m;
                        z=z|w;
                    }
            return (z+ri);        
       }
       return -1; // retorna -1 cuando la posicion es incorrecta
 }

public int Getcant(){
    return cant;
}


}
