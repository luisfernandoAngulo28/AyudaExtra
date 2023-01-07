/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno.clases;

/**
 * Ayudantia 1/2016 Eddy Escalante
 */
public class sparce {
    // atributos de la clase

    float ve[];    // vector dato
    int vp[];      // vector posicion
    int ep;        // elemento predominante
    int NF;        // nro de filas 
    int NC;        // nro de columnas
    int Ne;        // nro de elementos

    // constructor por parametro
    public sparce(int nfilas, int ncol, int eleP) {
        ve = new float[nfilas * ncol];
        vp = new int[nfilas * ncol];
        ep = eleP;
        NF = nfilas;
        NC = ncol;
        Ne = 0;

    }

    // para buscar la posicion
    public int Buscar(int pos) {
        int i = 0;
        while ((i < Ne) && (pos != vp[i])) {
            i++;
        }
        if (i < Ne) {
            return (i);
        } else {
            return (-1);
        }
    }
    // para meter valor

    public void SetData(int fila, int col, float dato) {
        if ((fila > 0) && (fila <= NF) && (col > 0) && (col <= NC)) {
            int pos = (fila - 1 * NC + col);
            int posx = Buscar(pos);
            if ((posx == -1) && (dato != ep)) {            // inserta al final el dato
                if ((Ne % 10) == 0) { // si el vector esta lleno
                    float vea[] = new float[Ne + 10];
                    int vpa[] = new int[Ne + 10];
                    System.arraycopy(ve, 0, vea, 0, Ne);
                    System.arraycopy(vp, 0, vpa, 0, Ne);
                    ve = new float[Ne + 10];
                    vp = new int[Ne + 10];
                    this.ve = vea;
                    this.vp = vpa;
                }
                Ne++;
                ve[Ne - 1] = dato;
                vp[Ne - 1] = pos;
            } else {
                if ((pos != -1) && (dato != ep)) {     // se modifica el dato
                    ve[posx] = dato;
                } else {                          // el elimina el dato   
                    for (int i = posx; i < Ne; i++) {
                        ve[i] = ve[i + 1];
                        vp[i] = vp[i + 1];
                    }
                    Ne--;
                }
            }


        }

    }
}
