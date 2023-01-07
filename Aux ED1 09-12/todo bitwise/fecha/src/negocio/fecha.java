/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author HP
 */
public class fecha {

    VectorbitG f;

    public fecha(int Cantent) {
        f = new VectorbitG(Cantent, 14);//CANTIDAD DE FECHAS : CADA FECHA CON 14 BITS
    }

    public void insertarFecha(int dia, int mes, int año, int posicion) {

        if ((dia < 32) && (mes < 13) && (año < 23)) {//DIA 2^5 + MES 2^4 + AÑO 2^5 == 14BITS
            int valor = 0;//00000000000000/*15/10/22*/
            valor = valor | (dia << 9);//01111000000000
            valor = valor | (mes << 5);//01111101000000
            valor = valor | año;//01111101010110

            f.InsertarG(valor, posicion);
        } else {
            System.out.println("Error dato incorrecto");
        }
    }

    public int getDia(int valor) {
        return (valor >>> 9);
    }

    public int getMes(int valor) {
        valor = valor << 23;
        return valor >>> 28;

    }

    public int getAno(int valor) {
        valor = valor << 27;
        return (valor >>> 27);

    }

    @Override
    public String toString() {
        String s = "FECHA: -> [ ";
        int ano = 1989;
        for (int i = 1; i <= f.n; i++) {
            int DiaMesAño = f.get(i);
            if (getAno(DiaMesAño) != 0) {
                s = s + Integer.toBinaryString(getDia(DiaMesAño)) + "/" + 
                        Integer.toBinaryString(getMes(DiaMesAño)) + "/" + Integer.toBinaryString(getAno(DiaMesAño) +ano) + " : ";
                //de DiaMesAño solo quiero dia==getDia
            }
        }
        return s + "]";
    }
    public String ToString() {
        String s = "FECHA: -> [ ";
        int ano = 1989;
        for (int i = 1; i <= f.n; i++) {
            int DiaMesAño = f.get(i);
            if (getAno(DiaMesAño) != 0) {
                s = s + (getDia(DiaMesAño)) + "/" +
                        (getMes(DiaMesAño)) + "/" + (getAno(DiaMesAño) + ano) + " : ";
                //de DiaMesAño solo quiero dia==getDia
            }
        }
        return s + "]";
    }

    public static void main(String[] args) {
        fecha f = new fecha(5);//CANTIDAD DE FECHAS A MOSTRAR
        f.insertarFecha(12, 5, 22, 1);//DIA,MES,AÑO,POSICION
        f.insertarFecha(15, 10, 22, 2);
        f.insertarFecha(12, 12, 9, 4);
        f.insertarFecha(30, 9, 22, 3);
        f.insertarFecha(13, 11, 20, 5);//DIA,MES,AÑO,POSICION
        System.out.println(f.toString());
        System.out.println(f.ToString());
    }
}
