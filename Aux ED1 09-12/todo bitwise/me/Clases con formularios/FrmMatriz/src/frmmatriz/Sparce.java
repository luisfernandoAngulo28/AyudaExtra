/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package frmmatriz;

/**
 *
 * @author Muerto
 */
public class Sparce {

    float vD[]; // vector de datos
    int vP[];   // vector de posicion
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

    public void SetDato(int f, int c, float dato) {
        if (f > 0 && f <= fil && c > 0 && c <= col) {
            if (dato != ePred) {
                if (dim % 10 == 0) {
                    float vDAux[] = new float[dim + 10];
                    int vPAux[] = new int[dim + 10];
                    System.arraycopy(this.vD, 0, vDAux, 0, dim);
                    System.arraycopy(this.vP, 0, vPAux, 0, dim);
                    this.vD = vDAux;
                    this.vP = vPAux;
                }
                if (GetDato(f, c) != ePred) {
                    for (int i = 0; i <= dim; i++) {
                        if (vP[i] == ((f - 1) * col + c)) {
                            vD[i] = dato;
                        }
                    }
                } else {
                    dim++;
                    vD[dim] = dato;
                    vP[dim] = (f - 1) * col + c;
                }
                dim++;
                vD[dim - 1] = dato;     //pa naaa mas tanto if... Simple!
                vP[dim - 1] = (f - 1) * col + c;
            } else {
                int pos = 0;
                for (int i = 0; i <= dim; i++) {
                    if (vP[i] == ((f - 1) * col + c)) {
                        pos = i;
                    }
                }
                for (int j = pos; j < dim; j++) {
                    vD[j] = vD[j + 1];
                    vP[j] = vP[j + 1];
                }
                dim--;
            }
        } else {
            System.out.println("ERROR: Fila o Columna Fuera de Rango");
        }
    }

    public float GetDato(int f, int c) {
        if (f > 0 && f <= fil && c > 0 && c <= col) {
            int x = (f - 1) * col + c;
            boolean sw = true;
            int i = 0;
            while (i <= dim && sw) {
                if (vP[i] == x) {
                    sw = false;
                }
                i++;
            }
            if (sw) {
                return ePred;
            } else {
                return vD[i - 1];
            }
        } else {
            System.out.println("ERROR: Fila o Columna Fuera de Rango");
            return -1;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 1; i <= fil; i++) {
            for (int j = 1; j <= col; j++) {
                s += GetDato(i, j) + "  ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Sparce sparce = new Sparce(3, 3);
        sparce.SetDato(1, 1, 1);
        sparce.SetDato(1, 3, 3);
        sparce.SetDato(2, 2, 5);
        sparce.SetDato(3, 1, 7);
        sparce.SetDato(3, 3, 9);
        System.out.println(sparce.GetDato(1, 2));
        System.out.println(sparce.toString());
    }
}
