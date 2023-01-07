/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Roly
 */
public class bitwise {

    int x;

    public bitwise() {
        this.x = 0;
    }
    //le envio la posicion del bit y su estado[0..1] 1 significa q quiero q se active 0 es para desabilitar
    public void setBit(int pos, int estado) {
        int y = 1;
        y = (y << (pos - 1));
        if (estado == 0) {
            y = ~y;
            x = (x & y);
        } else {
            x = (x | y);
        }
    }
    //envio la pos del bit y este metodo me devolvera[0..1] 1 significa q esta activo 0 q no estubo habilitado
    public int getBit(int pos) {
        int y = 1;
        y = (y << (pos - 1));
        y = (y & x);
        y = (y >>> (pos - 1));
        return y;
    }
}
