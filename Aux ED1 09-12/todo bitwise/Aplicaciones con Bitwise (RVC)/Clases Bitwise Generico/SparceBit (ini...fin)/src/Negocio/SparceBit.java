/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Roly
 */
public class SparceBit {

    BitWise vD; //vector de Datos
    BitWise vP; // vector de Posicion de los Datos
    int nF;  // nro de fila
    int nC;  // nro de columnas
    int eP;  // elemento Predominante de la Matriz
    int dim;// cant de Elementos

    public SparceBit(int nFilas, int nCol, int elemP, int ri, int rf) {
        this.vD = new BitWise(10, ri, rf);
        this.vP = new BitWise(10, ri, rf);
        this.nF = nFilas;
        this.nC = nCol;
        this.eP = elemP;
        this.dim = 0;
    }

    public void setDato(int fil, int col, int dato) throws Exception {
        if (fil > 0 && fil <= nF && col > 0 && col <= nC) {
            if (dato != eP) {
                if (dim % 10 == 0) {//mis vectores estan llenos y hay q redimensionar
                    vD.dimensionar(dim + 10);
                    vP.dimensionar(dim + 10);
                }
                if (getDato(fil, col) != eP) {//ya existe un dato en esa posicion lo q hago es sobreescrir con el nvo dato a ingresar
                    int i = 1;
                    while (i <= dim) {
                        if (((fil - 1) * nC + col) == vP.getDato(i)) {
                            vD.setDato(i, dato);
                            i = dim + 1;
                        }
                        i++;
                    }
                } else {//introduzco un nvo. dato
                    dim++;
                    vD.setDato(dim, dato);
                    vP.setDato(dim, ((fil - 1) * nC + col));
                }
            } else {//es un elemento pred por tanto elimino los datos de mis vectores vD y vP
                int i = 1, pos = 0;
                while (i <= dim) { // busco el dato a travez de su posicion en el vD
                    if (((fil - 1) * nC + col) == vP.getDato(i)) {
                        pos = i;
                        i = dim + 1;
                    }
                    i++;
                }
                for (int j = pos; j < dim; j++) { // elimino el dato y su posicion de mis vectores
                    vD.setDato(j, vD.getDato(j + 1));
                    vP.setDato(j, vP.getDato(j + 1));
                }
                dim--;
            }
        } else {
            throw new Exception("SparceBit::setDato::Error: fila o columna fuera de rango");
        }
    }

    public int getDato(int fil, int col) throws Exception {
        if (fil > 0 && fil <= nF && col > 0 && col <= nC) {
            boolean sw = false;
            int i = 1;
            while (i <= dim && sw == false) {
                if (vP.getDato(i) == ((fil - 1) * nC + col)) {
                    sw = true;
                }
                i++;
            }
            if (sw == false) {
                return eP;
            } else {
                return vD.getDato(i - 1);
            }

        } else {
            throw new Exception("SparceBit::getDato::Error: fila o columna fuera de rango");
        }
    }

    public String mostrarMatriz() throws Exception {
        int i = 1;
        String S = "";
        while (i <= nF) {
            int j = 1;
            while (j <= nC) {
                S = S + getDato(i, j) + "  ";
                j++;
            }
            S = S + "\n";
            i++;
        }
        return S;
    }

    public String mostrarVD() throws Exception {
        String S = "VD = ";
        for (int i = 1; i <= dim; i++) {
            S = S + vD.getDato(i) + ", ";
        }
        return S;
    }

    public String mostrarVP() throws Exception {
        String S = "VP = ";
        for (int i = 1; i <= dim; i++) {
            S = S + vP.getDato(i) + ", ";
        }
        return S;

    }
}
