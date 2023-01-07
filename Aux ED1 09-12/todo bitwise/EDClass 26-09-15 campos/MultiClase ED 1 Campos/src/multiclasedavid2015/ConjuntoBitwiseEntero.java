package multiclasedavid2015;

public class ConjuntoBitwiseEntero {

    BitwiseEntero x[];
    int NElemento;
    int Cant;

    public ConjuntoBitwiseEntero(int NEle) {
        int NE = NEle / 32;
        if ((NEle % 32) != 0) 
            NE++;        
        x = new BitwiseEntero[NE];
        for (int i = 0; i < NE; i++) 
            x[i] = new BitwiseEntero();        
        NElemento = NEle;
        Cant = 0;
    }

    public int Entero(int pos) {
//        if (pos % 32 != 0) 
//            return pos / 32;
//         else 
//            return pos / 33;        
        return ((pos-1)/32);
    }

    public int NBitsEntero(int pos) {
////        if (pos % 32 != 0) 
////            pos = pos % 32;        
////        return pos;
        return ((pos-1)%32+1);
    }

    public Boolean pertenece(int NEle) {
        Boolean s = false;
        if (NEle > NElemento) 
            System.err.println("Error: fuera de rango");
        else {
            int NE = Entero(NEle);
            int NBE = NBitsEntero(NEle);
            s = x[NE].GetBit((byte) NBE) == 1;
        }
        return s;
    }

    public void insertar(int NEle) {
        if ((NEle > NElemento) || (pertenece(NEle)))
            System.err.println("Error: fuera de rango o elemento repetido");
        else {
            int NE = Entero(NEle);
            int NBE = NBitsEntero(NEle);
            x[NE].SetBit1((byte) NBE);
        }
        Cant++;
    }

    public void eliminar(int NEle) {
       if ((NEle > NElemento) || (!pertenece(NEle)))
            System.err.println("Error: fuera de rango o elemento no existe");
        else {
            int NE = Entero(NEle);
            int NBE = NBitsEntero(NEle);
            x[NE].SetBit0((byte) NBE);
        }
        Cant--;
    }

    public int sumarElementos() {
        int NE = NElemento / 32;
        int suma = 0;
        if (NElemento % 32 != 0) 
            NE++;       
        for (int i = 0; i < NE; i++) {
            if (x[i].sumarPos() != 0) 
                suma = suma + x[i].sumarPos() + 32 * i;            
        }
        return (suma);
    }

    public int getBit(int pos) {
        int NE = Entero(pos);
        int NBE = NBitsEntero(pos);
        return x[NE].GetBit((byte) NBE);
    }

    public int getEle(int Ele) {
        return Ele;
    }

    @Override
    public String toString() {
        int NE = NElemento / 32;
        if (NElemento % 32 != 0) 
            NE++;        
        String s = "             <  32  31  30  29  28  27  26  25  24  23  22  21  20  19  18  17  16  15  14  13  12  11  10  09  08  07  06  05  04  03  02  01 >\n\n";
        int c = 32;
        for (int i = 0; i < NE; i++) {
            if (c < 100) 
                s = s + "Entero:" + i + "  " + c + " <  ";
            else 
                s = s + "Entero:" + i + " " + c + " <  ";            
            for (int j = 32; j > 1; j--) 
                s = s + x[i].GetBit((byte) j) + "   ";            
            s = s + x[i].GetBit((byte) 1) + "  >  " + (c - 31) + "\n";
            c = c + 32;
        }
        return s;
    }

    public String toStringValorEntero() {
        int NE = NElemento / 32;
        if (NElemento % 32 != 0) 
            NE++;        
        String cad = "\nValor Entero:\n";
        for (int i = 0; i < NE; i++) 
            cad = cad + "Entero:" + i + " = " + x[i].getX() + "\n";        
        return cad;
    }

    public static void main(String[] args) {
        ConjuntoBitwiseEntero x = new ConjuntoBitwiseEntero(160);
        x.insertar(1);
        x.insertar(70);
        x.insertar(98);
        x.insertar(7);
        x.insertar(10);
        x.insertar(33);
        x.insertar(15);
        x.insertar(35);
        x.insertar(96);
        System.out.println(x);
        System.out.println("Cantidad Elementos: " + x.Cant);
        System.out.println("Suma Elementos: " + x.sumarElementos());
        System.out.println("Pertenece: " + x.getEle(160) + ", " + x.pertenece(160));
        System.out.println("GetBit: " + x.getBit(128));
        System.out.println(x.toStringValorEntero());
    }
}
