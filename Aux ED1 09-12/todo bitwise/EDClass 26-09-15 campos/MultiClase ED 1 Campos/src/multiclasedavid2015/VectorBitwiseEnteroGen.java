package multiclasedavid2015;
public class VectorBitwiseEnteroGen {
    int V[]; 
    int Cant; 
    int Nbit;    
    public VectorBitwiseEnteroGen(int Nelementos, int Nbit) {        
        int Cantbitstotal = Nelementos * Nbit; 
        int NEntero = Cantbitstotal / 32;        
        if (Cantbitstotal % 32 != 0) {
            NEntero++;
            V = new int[NEntero];
            this.Cant = Nelementos;
            this.Nbit = Nbit;
        }
    }

    public int Entero(int pos) {
        return (((pos - 1) * (Nbit)) / 32);        
    }

    public int Bit(int pos) {
        return (((pos - 1) * (Nbit)) % 32) + 1;
    }

    public void insertar(int ele, int pos) {
        if (pos > Cant | ele > (int) Math.pow(2, Nbit) - 1) {
            System.out.println("error pos O elemento fuera de rango");
        } else {
            int ele1 = ele;
            int Entero1 = Entero(pos);
            int posbit = Bit(pos);
            int mask = (int) Math.pow(2, Nbit) - 1;
            mask = mask << posbit - 1;
            mask = ~mask;
            V[Entero1] = V[Entero1] & mask;
            ele = ele << posbit - 1;            
            V[Entero1] = V[Entero1] | ele;            
            if (posbit - 1 + Nbit > 32) {
                int bitfal = posbit - 1 + Nbit - 32;
                int mask1 = (int) Math.pow(2, Nbit) - 1;
                mask1 = mask1 >>> Nbit - bitfal;
                mask1 = ~mask1;
                V[Entero1 + 1] = V[Entero1 + 1] & mask1;
                ele1 = ele1 >>> Nbit - bitfal;
                V[Entero1 + 1] = V[Entero1 + 1] | ele1;                
            }
        }
    }

    public int getdato(int pos) {
        if (pos > Cant) {
            System.out.println("error posicion fuera de rango");
        }
        int entero = Entero(pos);
        int posbit = Bit(pos);
        int mask = (int) Math.pow(2, Nbit) - 1;
        mask = mask << posbit - 1;
        mask = mask & V[entero];        
        mask = mask >>> posbit - 1;
        if (posbit - 1 + Nbit > 32) {
            int bitf = posbit - 1 + Nbit - 32;
            int mask1 = (int) Math.pow(2, Nbit) - 1;
            mask1 = mask1 >>> Nbit - bitf;
            mask1 = mask1 & V[entero + 1];            
            mask1 = mask1 << Nbit - bitf; 
            mask = mask | mask1;                                  
        }
        return mask;  
    }

    @Override
    public String toString() {
        String s = "V=[ ";
        for (int i = 1; i < Cant; i++) 
            s = s + getdato(i) + "; ";        
        s = s + getdato(Cant)+" ]";
        return s;
    }

    public static void main(String[] args) {
        VectorBitwiseEnteroGen V = new VectorBitwiseEnteroGen(8, 5);
        V.insertar(13, 6);
        V.insertar(2, 1);
        V.insertar(5, 7);
        V.insertar(9, 2);
        V.insertar(1, 8);
        V.insertar(7, 3);
        System.out.println(V);
    }
}
