/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author maisel
 */
public class HoraN {

    VectorbitG p;

    public HoraN(int CantHora) {
        p = new VectorbitG(CantHora, 17);

    }

    public void inserthora(int hora, int min, int seg, int pos) {
        int valor = 0;
        valor = valor | (hora << 12);
        valor = valor | (min << 6);
        valor = valor | seg;

        p.InsertarenZ(valor, pos);   //OCUPAMOS EL INSERTAR DEL VECTOR GENERICO

    }

    public int gethora(int x) {
        return x >>> 12;

    }

    public int getmin(int x) {
        x = x << 20;
        return x >>> 26;

    }

    public int getseg(int x) {
        x = x << 26;
        return x >>> 26;

    }

    public String mostrar1E() {
        String s1 = "V -> [ ";
        for (int i = 1; i <= p.n; i++) {//n es numero de elemento del vector
            int x = p.get(i);
            s1 = s1 + gethora(x) + ":" + getmin(x) + ":" + getseg(x) + " -> ";
        }
        s1 = s1 + "]";
        return s1;
    }
     public String mostrar2B() {
        String s1 = "V -> [ ";
        for (int i = 1; i <= p.n; i++) {//n es numero de elemento del vector
            int x = p.get(i);
            s1 = s1 + Integer.toBinaryString(gethora(x)) + ":" + Integer.toBinaryString(getmin(x))
                    + ":" + Integer.toBinaryString(getseg(x)) + " -> ";
        }
        s1 = s1 + "]";
        return s1;
    }

    public static void main(String[] args) {
        HoraN hh = new HoraN(7);
        hh.inserthora(11, 59, 30, 1);
        hh.inserthora(10, 59, 12, 2);
        hh.inserthora(24, 16, 59, 5);
        hh.inserthora(23, 58, 60, 4);
        hh.inserthora(22, 50, 23, 6);
        hh.inserthora(20, 30, 30, 3);
        hh.inserthora(24, 60, 60, 7);
        //hh.inserthora(2,2,2,1);//si le mando otra fecha en la
        //misma posicion me lo actualiza y lo cambia
        System.out.println(hh.mostrar1E());
        System.out.println(hh.mostrar2B());
    }
}
