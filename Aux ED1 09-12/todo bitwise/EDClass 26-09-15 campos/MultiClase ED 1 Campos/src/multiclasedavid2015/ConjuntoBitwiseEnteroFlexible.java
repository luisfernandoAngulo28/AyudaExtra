package multiclasedavid2015;

public class ConjuntoBitwiseEnteroFlexible {

    BitwiseEntero x[];
    int Ini;
    int Fin;
    int Cant;

    public ConjuntoBitwiseEnteroFlexible(int Ini, int Fin) {
        int NE = (Ini-Fin) / 32;
        if (((Ini-Fin) % 32) != 0) 
            NE++;        
        x = new BitwiseEntero[NE];
        for (int i = 0; i < NE; i++) 
            x[i] = new BitwiseEntero();        
        this.Ini = Ini;
        this.Fin=Fin;
        Cant = this.Ini-this.Fin;
    }

    public int Entero(int pos) {        
        if (pos>=Ini && pos<=Fin)
            return ((pos-1)/32);
        else{
            System.err.println("Error fuera de rango");
            return -1;        
        }
    }

    public int NBitsEntero(int pos) {
        if (pos>=Ini && pos<=Fin)
            return ((pos-1)%32+1);
        else{
            System.err.println("Error fuera de rango");
            return -1;
        }            
    }

    public Boolean pertenece(int NEle) {
        Boolean s = false;
        if (NEle >= Ini &&NEle<=Fin) {
            int NE = Entero(NEle);
            int NBE = NBitsEntero(NEle);
            s = x[NE].GetBit((byte) NBE) == 1;            
        }else 
            System.err.println("Error: fuera de rango");        
        return s;
    }

    public void insertar(int NEle) {
        if (NEle <Ini||NEle>Fin || (pertenece(NEle)))
            System.err.println("Error: fuera de rango o elemento repetido");
        else {
            int NE = Entero(NEle);
            int NBE = NBitsEntero(NEle);
            x[NE].SetBit1((byte) NBE);
        }
        Cant++;
    }

    public void eliminar(int NEle) {
       if ((NEle < Ini||NEle>Fin) || (!pertenece(NEle)))
            System.err.println("Error: fuera de rango o elemento no existe");
        else {
            int NE = Entero(NEle);
            int NBE = NBitsEntero(NEle);
            x[NE].SetBit0((byte) NBE);
        }
        Cant--;
    }

    public int sumarElementos() {
        int NE = (Ini-Fin) / 32;
        int suma = 0;
        if ((Ini-Fin) % 32 != 0) 
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
        int NE = (Ini-Fin) / 32;
        if ((Ini-Fin) % 32 != 0) 
            NE++;        
        String s = "\n";
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
        int NE = (Ini-Fin) / 32;
        if ((Ini-Fin) % 32 != 0) 
            NE++;        
        String cad = "\nValor Entero:\n";
        for (int i = 0; i < NE; i++) 
            cad = cad + "Entero:" + i + " = " + x[i].getX() + "\n";        
        return cad;
    }

    public static void main(String[] args) {
        ConjuntoBitwiseEnteroFlexible x = new ConjuntoBitwiseEnteroFlexible(20,30);
        //x.insertar(1);
        x.insertar(33);
        x.insertar(35);
        //x.insertar(96);
        System.out.println(x);
        System.out.println("Cantidad Elementos: " + x.Cant);
        System.out.println("Suma Elementos: " + x.sumarElementos());
        System.out.println("Pertenece: " + x.getEle(160) + ", " + x.pertenece(160));
        System.out.println("GetBit: " + x.getBit(128));
        System.out.println(x.toStringValorEntero());
    }
}

