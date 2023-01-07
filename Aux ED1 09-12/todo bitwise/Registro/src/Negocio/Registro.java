/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.logging.Level;
import java.util.logging.Logger;

/********************************************************************************************
 * representacion del registro para 50 alum de las carreras de ings.Inform,Redes y Sistemas,*
 *  para el sgte. universo Codigo = 1..50                                                   *
 *                          edad  = 15-30                                                  *
 *                          sexo  = f-m                                                    *
 *                          carrera = Informatica,Redes,Sistemas                            *
 *                          semestre = 1-10                                                 *
 * ******************************************************************************************
 * @author ESTUDIANTE
 */
public class Registro implements Comparable<Object> {

    String nombre[]; //vector para almacenar el nombre
    BitWise bw;     //vector para el codigo,edad,semestre,carrera,sexo
    int Dim;        //cantidad de elementos

    public Registro() {
        this.nombre = new String[50];
        this.bw = new BitWise(50, 18);
        this.Dim = 0;
    }

    public String GetNombre(int pos) {
        return nombre[pos - 1];
    }

    public int GetCod(int Pos) throws Exception {
        int x = bw.GetDato(Pos);
        ///////////////////
        int mask1 = (int) Math.pow(2, 6) - 1;
        x = x & mask1;
        return x;
    }

    public int GetEdad(int Pos) throws Exception {
        /////////////////////
        int x = bw.GetDato(Pos);
        x = x >>> 6;
        int mask2 = (int) Math.pow(2, 5) - 1;
        mask2 = mask2;
        x = x & mask2;
        return x;
        ///////////////////
    }

    public int GetSem(int Pos) throws Exception {
        int x = bw.GetDato(Pos);
        x = x >>> 11;
        int mask3 = (int) Math.pow(2, 4) - 1;
        mask3 = mask3;
        x = x & mask3;
        return x;
    }

    public int GetCarrera(int Pos) throws Exception {
        int x = bw.GetDato(Pos);
        x = x >>> 15;
        int mask4 = (int) Math.pow(2, 2) - 1;
        mask4 = mask4;
        x = x & mask4;
        return x;
    }

    public int GetSex(int Pos) throws Exception {
        int x = bw.GetDato(Pos);
        x = x >>> 17;
        int mask5 = (int) Math.pow(2, 1) - 1;
        mask5 = mask5;
        x = x & mask5;
        return x;
    }

    public void Insertar(String nomb, int Cod, int Edad, int Sem, String Carr, char Sex) throws Exception {
        if ((Cod > 0 && Cod < 51) && (Edad > 14 && Edad < 31) && (Sem > 0 && Sem < 11) && (Carr == "Informatica" || Carr == "Sistemas" || Carr == "Redes") && (Sex == 'M' || Sex == 'F')) {
            int dato = Cod;

            int dato1 = Edad;
            dato1 = dato1 << 6;
            dato = dato | dato1;

            int dato2 = Sem;
            dato2 = dato2 << 11;
            dato = dato | dato2;

            int dato3 = 0;
            if (Carr == "Redes") {
                dato3 = 1;
            } else {
                if (Carr == "Sistemas") {
                    dato3 = 2;
                }
            }
            dato3 = dato3 << 15;
            dato = dato | dato3;

            int dato4 = 0;
            if (Sex == 'F') {
                dato4 = 1;
            }
            dato4 = dato4 << 17;
            dato = dato | dato4;

            nombre[Cod - 1] = nomb;
            bw.SetDato(Cod, dato);
            this.Dim = Dim + 1;
        } else {
            throw new Exception("Error:Dato Fuera de Rango Verique Por Favor");
        }
    }

    public String SacarReg(int Pos) throws Exception {
        String S = "";
        ///////////////////
        S = S + "Nombre:" + nombre[Pos - 1];
        S = S + "\n";
        ///////////////////
        int dato = GetCod(Pos);
        S = S + "Codigo:" + Integer.toString(dato) + " ";
        S = S + "\n";
        /////////////////////
        dato = GetEdad(Pos);
        S = S + "Edad:" + Integer.toString(dato) + " ";
        S = S + "\n";
        ///////////////////
        dato = GetSem(Pos);
        S = S + "Semestre:" + Integer.toString(dato) + " ";
        S = S + "\n";
        ///////////
        dato = GetCarrera(Pos);
        if (dato == 0) {
            S = S + "Carrera:" + "Ing.Informatica" + " ";
        }
        if (dato == 1) {
            S = S + "Carrera:" + "Ing. en Redes" + " ";
        }
        if (dato == 2) {
            S = S + "Carrera:" + "Ing. en Sistemas" + " ";
        }
        S = S + "\n";

        //////////////
        dato = GetSex(Pos);
        if (dato == 0) {
            S = S + "Sexo:" + "Varon" + " ";
        }
        if (dato == 1) {
            S = S + "Sexo:" + "Mujer" + " ";
        }
        S = S + "\n";
        //////////////
        return S;
    }

    public void Eliminar(int Sem) throws Exception {
        int i = 1;
        while (i <= bw.Dim) {
            int dato = bw.GetDato(i);
            int aux = dato;
            int mask = (int) Math.pow(2, 4) - 1;
            aux = aux >>> 11;
            aux = aux & mask;
            if (aux == Sem) {
                /*for (int j = i; j < nombre.length; j++) { //*****************************************************
                if (j < bw.Dim) {                       //*Esto no se debe hacer ya q si yo qiero volver      *
                bw.SetDato(j, bw.GetDato(j + 1));   //*a poner otro dato en la misma posicion             *
                }                                       //*no podre insertarlo ya q esa casila no exitira     *
                nombre[j - 1] = nombre[j];              //*****************************************************
                }
                bw.Dim--;*/
                bw.SetDato(i, 0);
                nombre[i - 1] = null;
                this.Dim--;
            } else {
                i++;
            }
        }
    }

    public String Mostrar() throws Exception {
        String S = "";
        int i = 1;
        while (i <= bw.Dim) {
            int k = bw.GetDato(i);
            if (k != 0) {
                S = S + SacarReg(i) + "\n";
            }
            i++;
        }
        return S;
    }

    @Override
    public int compareTo(Object o) {//?1- operadores terneario( : o,? es igual)
        Registro A = (Registro) o;//castin declaramos un objeto de tipo alumno
        if (o instanceof Registro) {
            try {
                return ((A.bw.GetDato(Dim) < A.bw.GetDato(Dim)) ? -1 : (A.bw.GetDato(Dim) > A.bw.GetDato(Dim)) ? 1 : 0);//hacemos la comparacion de los registros
            } catch (Exception ex) {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                return 555;
            }
        } else {
            return 666;
        }                                                                        //para insertar de manera ordenada
    }
}
