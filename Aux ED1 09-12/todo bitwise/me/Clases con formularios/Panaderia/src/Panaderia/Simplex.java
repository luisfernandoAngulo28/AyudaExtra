/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panaderia;

/**
 *
 * @author Bismarck
 */
public class Simplex {

    float m[][];
    float mAux[][];
    int fil;
    int col;
    int filI;
    int colI;
    float pivote[];
    boolean sw;

    public Simplex(int fil, int col) {
        this.m = new float[fil][col + fil - 1];
        this.mAux = new float[fil][col + fil - 1];
        this.fil = fil;
        this.col = col;
        this.filI = fil;
        this.colI = col + fil - 1;
        this.pivote = new float[3];
        sw = true;
    }

    public void setData(int f, int c, float data) {
        m[f][c] = data;
    }

    public float getData(int f, int c) {
        return m[f][c];
    }

    public boolean revisarFinal(float a[][], int c) {
        for (int j = 0; j < c - 1; j ++) {
            if (a[fil - 1][j] != 0) {
                return false;
            }
        }
        return true;
    }

    public void prepararM(float a[][], int f, int c) {
        for (int i = 0; i < f - 1; i ++) {
            for (int j = 0; j < c - 1; j ++) {
                setData(i, j, a[i][j]);
                if (i == j) {
                    setData(i, j + c - 1, 1);
                } else {
                    setData(i, j + c - 1, 0);
                }
            }
        }
        for (int i = 0; i < fil; i ++) {
            setData(i, colI - 1, a[i][c - 1]);
        }
        for (int j = 0; j < c - 1; j ++) {
            setData(f - 1, j, a[f - 1][j] * -1);
            setData(f - 1, j + col - 1, 0);
        }
    }

    public void hallarPivote() {
        float menor = m[fil - 1][0];
        for (int j = 1; j < col - 1; j ++) {
            if (menor > m[fil - 1][j]) {
                menor = m[fil - 1][j];
                pivote[1] = j;
            }
        }
        float v[] = new float[fil - 1];
        for (int i = 0; i < fil - 1; i ++) {
            v[i] = m[i][colI - 1] / m[i][(int)pivote[1]];
        }
        menor = v[0];
        for (int i = 1; i < fil - 1; i ++) {
            if (menor > v[i]) {
                menor = v[i];
                pivote[0] = i;
            }
        }
        pivote[2] = m[(int) pivote[0]][(int)pivote[1]];
    }

    public void Pivotear(float a[][], int c) {
        for (int j = 0; j < c; j ++) {
            a[(int) pivote[0]][j] = m[(int) pivote[0]][j] / pivote[2];
        }
    }

    public void Interaccion() {
        if (sw == true) {
            sw = false;
        } else {
            hallarPivote();
            Pivotear(mAux, colI);
            for (int i = 0; i < filI; i ++) {
                if (i != pivote[0]) {
                    float aux = m[i][(int) pivote[1]] * -1;
                    for (int j = 0; j < colI; j ++) {
                         mAux[i][j] = m[i][j] + (mAux[(int) pivote[0]][j] * aux);
                    }
                }
            }
            for (int i = 0; i < filI; i ++) {
                for (int j = 0; j < colI; j ++) {
                    m[i][j] = mAux[i][j];
                }
            }
        }
    }
}
