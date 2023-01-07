package multiclasedavid;
public class ClaseConjunto {

    ClaseVectorBit v[];
    int cant;
    int NElementos;
  //constructor
    public ClaseConjunto(int NElementos){    
        int NEnteros =NElementos/32;
        if (NElementos % 32 !=0){
            NEnteros++;
        }
        v=new ClaseVectorBit[NEnteros];
        cant=0;
        for (int i=0;i<NEnteros;i++)
        {   
           v[i]=new ClaseVectorBit();      
        }
        this.NElementos=NElementos;   
    }
    public void insertar(int ele){
        if (ele>NElementos){
            System.out.println("fuera de rango");
        }
        else{
        int NEnt=Enterosmoi(ele);// funcion q dve el entero a mod
        int Nbit=bitsmoi(ele);//encuentra el bit a modificar
        v[NEnt].setbit1(Nbit);
        cant ++;
        }
    }
    public int Enteros(int pos){
        return pos /32;    
    }
    public int bits(int pos){
        return pos %32;    
    }
    public int Enterosmoi(int pos){
        if (pos %32!=0){
            pos =pos/32; 
        }else{
            pos=pos/33;
        }        
        return pos;
    }
    public int bitsmoi(int pos){
        if (pos %32!=0){
            pos =pos%32; 
        }        
        return pos;
    }
    public boolean pertenece(int ele){
        int Nent= Enterosmoi(ele);
        int nbit=bitsmoi(ele);
        return (v[Nent].getbit(nbit)==1);
    }
    @Override
    public String toString() {
        int NEnteros =NElementos/32;
        if (NElementos % 32 !=0){
            NEnteros++;
        }   
        String cad=""; 
        for (int i=0; i<NEnteros; i++)
            cad=cad+"\n"+i+v[i].toString();
        return cad;
    }
    public String toStringX() {
        int NEnteros =NElementos/32;
        if (NElementos % 32 !=0){
            NEnteros++;
        }
        String cad="Nente=";
        for (int i=0; i<NEnteros; i++)
                 cad=cad+" "+v[i].getX();
        return cad;
    }
    public static void main(String[] args) {
        ClaseConjunto a=new ClaseConjunto(100);//dimensiona el universo de bits
//        a.insertar(3);
//        a.insertar(1);
//        a.insertar(63);
//        a.insertar(32);
        a.insertar(60);
        a.insertar(65);
//        int x=64;
//        System.out.println(a.Enterosmoi(x));
     
      //a.insertar(65);
      //a.insertar(34);
      //a.insertar(95); 
      System.out.println(a);//
//        System.out.println(a.toString());//imprime el conjunto
        System.out.println(a.pertenece(64));//dev tru si el ele 35 esta activado
//        System.out.println(a.pertenece(10));//dve si el bit 10 esta esta activado si no false
//      //prueba enteros de bitwise
        System.out.println(a.toStringX());
    }    
}