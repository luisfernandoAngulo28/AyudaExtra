/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.StyledEditorKit.BoldAction;

/**
 *
 *
 */
public class Sparce {

    float vD[]; // vector de datos
    int vP[];   // vector de posicion de los datos
    int dim;    // nro de datos
    int fil;    // nro de filas
    int col;    // nro de columnas
    int ePred;  // elemento predominante

    public Sparce(int nFil, int nCol) {
        this.vD = new float[10];
        this.vP = new int[10];
        this.fil = nFil;
        this.col = nCol;
        this.dim = 0;
        this.ePred = 0;
    }

    public Sparce(int nFil, int nCol, int elemPred) {
        this.vD = new float[10];
        this.vP = new int[10];
        this.fil = nFil;
        this.col = nCol;
        this.dim = 0;
        this.ePred = elemPred;
    }

    public void SetDato(int f, int c, float dato) throws Exception {
        if (f > 0 && f <= fil && c > 0 && c <= col) {
            if (dato != ePred) {
                if (dim % 10 == 0) {//cuando mi vector esta lleno lo vuelvo a dimensionar con 10 casillas nvas.
                    float vDAux[] = new float[dim + 10];
                    int vPAux[] = new int[dim + 10];
                    System.arraycopy(this.vD, 0, vDAux, 0, dim);
                    System.arraycopy(this.vP, 0, vPAux, 0, dim);
                    this.vD = vDAux;
                    this.vP = vPAux;
                }
                if (GetDato(f, c) != ePred) {// //ya existe un dato en esa posicion pero lo sobreescribo con el nvo a ingresar 
                    for (int i = 0; i < dim; i++) {
                        if (vP[i] == ((f - 1) * col + c)) {
                            vD[i] = dato;
                        }
                    }
                } else {//introduzco un nvo dato en VD y su posicion en VP
                    vD[dim] = dato;
                    vP[dim] = (f - 1) * col + c;
                    dim++;
                }
            } else {//elimina el dato y su Posicion del Dato cuando introduzco un elem pred
                int pos = -1;
                for (int i = 0; i < dim; i++) {
                    if (vP[i] == ((f - 1) * col + c)) {
                        pos = i;
                    }
                }
                for (int j = pos; j < dim - 1; j++) {
                    vD[j] = vD[j + 1];
                    vP[j] = vP[j + 1];
                }
                dim--;
            }
        } else {
            throw new Exception("Sparce::SetDato::ERROR: Fila o Columna Fuera de Rango");
        }
    }

    public float GetDato(int f, int c) throws Exception {
        if (f > 0 && f <= fil && c > 0 && c <= col) {
            int x = (f - 1) * col + c;//calculo de la posicion mediante 'f' y 'c'
            boolean sw = false;
            int i = 0;
            while ((i < dim) && (sw == false)) {//busco si existe un dato con la misma Posicion en el VP
                if (vP[i] == x) {
                    sw = true;
                }
                i++;
            }
            if (sw == false) {//me dice q es un nuevo dato
                return ePred;
            } else { //sobre-escribe el dato 
                return vD[i - 1];
            }
        } else {
            throw new Exception("Sparce::GetDat::ERROR: Fila o Columna Fuera de Rango");

        }
    }

    public void permutarFilas(int f1, int f2) throws Exception {
        if ((f1 <= fil) && (f2 <= fil)) {
            for (int j = 1; j < col; j++) {
                float aux = GetDato(f1, j);
                SetDato(f1, j, GetDato(f2, j));
                SetDato(f2, j, aux);
            }
        }
    }

    private int verficarMatriz(Sparce A, int i, int j) throws Exception {
        int kf = 1;
        while (kf <= A.fil && i <= fil) {
            int kc = 1;
            int aux = j;
            while (kc <= A.col && aux <= col) {
                if (A.GetDato(kf, kc) != GetDato(i, aux)) {
                    return 0;
                }
                kc++;
                aux++;
            }
            if (aux > col && kc <= A.col) {
                return 0;
            }
            kf++;
            i++;
        }
        if (i > fil && kf <= A.fil) {
            return 0;
        } else {
            return 1;
        }
    }

    public int subMatriz(Sparce A) throws Exception {
        int i = 1, c = 0;
        while (i <= fil) {
            int j = 1;
            while (j <= col) {
                if (A.GetDato(1, 1) == GetDato(i, j)) {
                    if (verficarMatriz(A, i, j) == 1) {
                        c++;
                    }
                }
                j++;
            }
            i++;
        }
        return c;
    }

    @Override
    public String toString() {
        String s = "";
        try {
            for (int i = 1; i <= fil; i++) {
                for (int j = 1; j <= col; j++) {
                    s += GetDato(i, j) + "  ";
                }
                s += "\n";
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return s;

    }

    public String MostrarVD() {
        String s = "VD= ";
        for (int i = 0; i < dim; i++) {
            s += Float.toString(vD[i]) + ", ";
        }
        return s;
    }

    public String MostrarVP() {
        String s = "VP= ";
        for (int i = 0; i < dim; i++) {
            s += Float.toString(vP[i]) + ", ";
        }
        return s;
    }

    private boolean verificarRestriccion(int f, int c) {
        boolean sw = false;
        if (f == 1 || f == fil) {
            if (c <= col && c > 0) {
                sw = true;
            }
        } else {
            if (f > 1 && f < fil) {
                if (c == 1 || c == col) {
                    sw = true;
                }
            }
        }
        return sw;
    }
}
