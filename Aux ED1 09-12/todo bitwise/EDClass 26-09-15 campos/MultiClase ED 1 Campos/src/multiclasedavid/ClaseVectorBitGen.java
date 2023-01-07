package multiclasedavid;

public class ClaseVectorBitGen { //BITWISE GENERICO
    //---------VARIABLES----------

    int V[]; //Nuestro Vector Elemenetos
    int Dim; //Dimension de cuantos Elemenetos
    int Nbit; //Cantidad de bits por cada Elemento    

    public ClaseVectorBitGen(int Nelementos, int Nbit) {//Si Nelementos=8, Numero de bits=5
        //--------CONSTRUCTOR---------
        int Cantbitstotal = Nelementos * Nbit; //La cantidad total en bits que ocupara nuestro vector (5*8=40)
        int NEntero = Cantbitstotal / 32;//NEntero=1. Por cada entero hay 32 bits, por lo tanto aqui se define cuantos elementos entran en un entero
        //40 div 32= 1, significa que en este caso hay 2 enteros de 32 bits que ocupara 8 elementos
        if (Cantbitstotal % 32 != 0) {// Si entran 2 enteros entonces se incrementa "NEntero"
            NEntero++;//NEntero=2
            V = new int[NEntero];//Por lo tanto nuestro vector de elementos tendra 2 Enteros de 32 bits que ocupara 8 elementos de 5 bits que seria en total 64 bits
            this.Dim = Nelementos;//Cantidad de Elementos=8
            this.Nbit = Nbit;//Cantidad de Bits=5;
        }
    }

    public int Entero(int pos) {//Ojo: "pos=posicion de elemento", Si pos=7, Devuelve la posicion de un entero si tenemos 2 enteros, entonces;
        return (((pos - 1) * (Nbit)) / 32);//(6*5) div 32= 30 div 32=0; esto quiere decir que el elemento de la pos 7 esta dentro del entero posicion 0
        //si pos =7,entonces 7*5=35,pero la posicion 7 empieza en el entero 0 en el bit 31, por tanto (7-1)*5=30 div 32=0, quiere decir que esta en el entero 0
    }

    public int Bit(int pos) {//Calcula la posicion de bits del elemento, pos=posicion de elemento, si pos=7
        return (((pos - 1) * (Nbit)) % 32) + 1;//((6*5) mod 32)+1=(30 mod 32)+1= 30+1 =31;
    }

    public void insertar(int ele, int pos) {//Como el vector tiene 8 elementos de 5 bits, entonces, Si ele=10, pos=7
        if (pos > Dim | ele > (int) Math.pow(2, Nbit) - 1) {//Dim=Nelementos=8,si (7>8) o (10>31)
            System.out.println("error pos O elemento fuera de rango");    //Error fuera de rango
        } else {
            int ele1 = ele;//ele1=10=00 00000 00000 00000 00000 00000 01010
            int Entero1 = Entero(pos);//Entero1=((7-1)*5) div 32=30 div 32 = 0
            int posbit = Bit(pos);//(posbit=((7-1)*5) mod 32)+1=30 mod 32=30+1=31
            int mask = (int) Math.pow(2, Nbit) - 1;//mask=(2 elevado a 5)-1= 31=11111
            mask = mask << posbit - 1;//<<30                  //11 00000 00000 00000 00000 00000 00000
            mask = ~mask;                                     //00 11111 11111 11111 11111 11111 11111
            V[Entero1] = V[Entero1] & mask;//v[Entero1]=v[0]=[00 00000 00000 00000 00000 00000 00000] 
                                                              //and [00 11111 11111 11111 11111 11111 11111]
                                                              //[00 00000 00000 00000 00000 00000 00000]
            ele = ele << posbit - 1;                          //[10 00000 00000 00000 00000 00000 00000]
            // 7    6     5     4     3     2     1 
            V[Entero1] = V[Entero1] | ele;                 //[00 00000 00000 00000 00000 00000 00000]  
            //or[10 00000 00000 00000 00000 00000 00000]
            //[10 00000 00000 00000 00000 00000 00000]
            if (posbit - 1 + Nbit > 32) {//¿faltan bits? (30+5)>32=V, 
                int bitfal = posbit - 1 + Nbit - 32;//((31-1)+5)-32=35-32=3
                int mask1 = (int) Math.pow(2, Nbit) - 1;//31=11111=00 00000 00000 00000 00000 00000 11111
                mask1 = mask1 >>> Nbit - bitfal;//5-3=2       ---->=00 00000 00000 00000 00000 00000 00111 
                mask1 = ~mask1;//                         ---->=11 11111 11111 11111 11111 11111 11000
                V[Entero1 + 1] = V[Entero1 + 1] & mask1;//      ---->=00 00000 00000 00000 00000 00000 00000
                ele1 = ele1 >>> Nbit - bitfal;//ele1=10=00 00000 00000 00000 00000 00000 01010 >>3 = 00 00000 00000 00000 00000 00000 00010
                V[Entero1 + 1] = V[Entero1 + 1] | ele1;//   00 00000 00000 00000 00000 00000 00000
                //or  00 00000 00000 00000 00000 00000 00010
                //    00 00000 00000 00000 00000 00000 00010
            }
        }
    }

    public int getdato(int pos) { //Obtener Dato, si pos=7
        if (pos > Dim) {//7>8
            System.out.println("error posicion fuera de rango");
        }
        int entero = Entero(pos);//entero=0
        int posbit = Bit(pos);//posbit=31
        int mask = (int) Math.pow(2, Nbit) - 1;//mask=31=00 00000 00000 00000 00000 00000 11111
        mask = mask << posbit - 1;//30<<            mask=11 00000 00000 00000 00000 00000 00000 
        mask = mask & V[entero];//                mask=11 00000 00000 00000 00000 00000 00000
        //         and v[entero]=10 00000 00000 00000 00000 00000 00000    
        //  mask=10 00000 00000 00000 00000 00000 00000
        mask = mask >>> posbit - 1;             //  mask=00 00000 00000 00000 00000 00000 00010
        if (posbit - 1 + Nbit > 32) {//(31-1+5)>35>32
            int bitf = posbit - 1 + Nbit - 32;//35-32=3
            int mask1 = (int) Math.pow(2, Nbit) - 1;//mask1=00 00000 00000 00000 00000 00000 11111=31 
            mask1 = mask1 >>> Nbit - bitf;//5-3=2>>   mask1=00 00000 00000 00000 00000 00000 00111=7
            mask1 = mask1 & V[entero + 1];//          mask1=00 00000 00000 00000 00000 00000 00111
            // and v[entero+1]=00 00000 00000 00000 00000 00000 00010
            //mask1=00 00000 00000 00000 00000 00000 00010
            mask1 = mask1 << Nbit - bitf;           //mask1=00 00000 00000 00000 00000 00000 01000
            mask = mask | mask1;                  //mask =00 00000 00000 00000 00000 00000 00010
            //or    mask1=00 00000 00000 00000 00000 00000 01000
            //  mask =00 00000 00000 00000 00000 00000 01010
        }
        return mask;  //mask =00 00000 00000 00000 00000 00000 01010=10
    }

    @Override
    public String toString() {
        String s = "V=[";
        for (int i = 1; i <= Dim; i++) {
            s = s + getdato(i) + ";";
        }
        s = s + "]";
        return s;
    }

    public static void main(String[] args) {
        ClaseVectorBitGen b = new ClaseVectorBitGen(8, 5);
        b.insertar(11, 6);
        b.insertar(31, 1);
        b.insertar(25, 7);
        b.insertar(9, 2);
        b.insertar(29, 8);
        b.insertar(7, 3);
        System.out.println(b.toString());
    }

}
