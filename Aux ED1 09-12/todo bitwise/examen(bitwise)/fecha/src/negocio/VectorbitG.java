/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author 
 */
public class VectorbitG {

    int z[];//vector de enteros
    int n;//numero de elemetos de un vector
    int bits; //numero de bits q maneja el vector

    public VectorbitG(int cant, int Nbits) {
        int Nb = cant * Nbits;
        int Ne = Nb / 32;
        if (Nb % 32 != 0) {
            Ne++;
        }
        z = new int[Ne];
        n = cant;
        bits = Nbits;
        //For(int i=1;i<=n;i++)
        //z[i-1]=0;
    }

    public int pot(int e, int b) {
        int r;
        if (e == 0) {
            r = 1;
        } else {
            r = pot(e - 1, b);
            r = r * b;
        }
        return r;
    }

    public void InsertarG(int ele, int pos) { //inserta un ele en el vector en la pos especifica
        if (pos <= n) {
            int Ne = ((pos - 1) * bits) / 32;
            int Nb = ((pos - 1) * bits) % 32;
            if (Nb + bits <= 32) {
                int mask = pot(bits, 2) - 1;//(int)math.pow(2,bits)-1;
                mask = mask << Nb;
                mask = ~mask;
                z[Ne] = z[Ne] & mask; //borra los bits especificado
                int valor = ele << Nb;
                z[Ne] = z[Ne] | valor;
            } else {
                z[Ne] = z[Ne] << 32 - Nb;
                z[Ne] = z[Ne] >>> 32 - Nb;
                int valor = ele << Nb;
                z[Ne] = z[Ne] | valor;
                z[Ne + 1] = z[Ne + 1] >>> Nb + bits - 32;
                z[Ne + 1] = z[Ne + 1] << Nb + bits - 32;
                valor = ele >>> 32 - Nb;
                z[Ne + 1] = z[Ne + 1] | valor;
            }
        } else {
            System.out.print("Error funcion fuera de rango");
        }
    }

    public String mostrar() {
        String s1 = "V = [";
        for (int i = 1; i <= n; i++) {
            s1 = s1 + (get(i) + ",");
        }
        s1 = s1 + "]";
        return s1;
    }

    public int get(int pos) {

        int Ne = ((pos - 1) * bits) / 32;
        int Nb = ((pos - 1) * bits) % 32;
        int mask = pot(bits, 2) - 1;
        mask = mask << Nb;
        mask = z[Ne] & mask;
        mask = mask >>> Nb;
        if (Nb + bits > 32) {
            int mask1 = pot(bits, 2) - 1;
            mask1 = mask1 >>> 32 - Nb;
            mask1 = z[Ne + 1] & mask1;
            mask1 = mask1 << 32 - Nb;
            mask = mask | mask1;

        }
        return mask;
    }

    public static void main(String[] args) {
        VectorbitG v = new VectorbitG(10, 15);//el 15 es el ele y 7 es el bits
        v.InsertarG(10, 1);//el 3 es el ele y el 1 es la pos
        v.InsertarG(20, 2);
        v.InsertarG(30, 3);
        v.InsertarG(40, 4);
        v.InsertarG(50, 5);
        v.InsertarG(60, 6);
        v.InsertarG(61, 7);
        v.InsertarG(62, 8);
        v.InsertarG(63, 9);
        v.InsertarG(55, 10);
        int x = v.get(7);//x=3
        System.out.println(v.mostrar());
        System.out.println("EL ELEMENTO ES: "+x);

    }
}
