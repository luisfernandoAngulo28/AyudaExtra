package multiclasedavid2015;
public class BitwiseEntero {
    int x;
    public BitwiseEntero(){
        x=0;        
    }    
    public void SetBit1(byte pos){
        int mask=1;
        mask=mask<<pos-1;
        x=x|mask;
    }
    public void SetBit0 (byte pos){
        int mask=1;
        mask=mask<<pos-1;
        mask=~mask;
        x=x&mask;        
    }
    public int GetBit(byte pos){
        int mask=1;
        mask=mask<<pos-1;
        mask=mask&x;
        mask=mask>>>pos-1;
        return (mask);
    }
    public long getX() {        
        return x;
    }
    public int sumarPos(){        
        int suma=0;
        for (int i = 1; i <= 32; i++) {
            if (GetBit((byte)i)==1)
                suma=suma+i;
        }
        return suma;
    }
    
    @Override
    public String toString() {
        String s ="          <  32  31  30  29  28  27  26  25  24  23  22  21  20  19  18  17  16  15  14  13  12  11  10  09  08  07  06  05  04  03  02  01  >\n";        
        s=s+" Bitwise: <  ";        
        for (int i = 32; i > 1; i--) {
            s = s + (GetBit((byte)i)) + "   ";
        }        
        s = s + GetBit((byte)1) + "   >\n";
        return s;
    }

    public static void main(String[] args) {
        BitwiseEntero x = new BitwiseEntero();
        x.SetBit1((byte) 1);
        x.SetBit1((byte) 2);
        x.SetBit1((byte) 3);
        x.SetBit1((byte) 4);
        x.SetBit1((byte) 5);        
        x.SetBit1((byte) 6);
        x.SetBit1((byte) 7);
        x.SetBit1((byte) 8);
        x.SetBit1((byte) 9);
        x.SetBit1((byte) 10);
        x.SetBit1((byte) 11);
        x.SetBit1((byte) 12);
        x.SetBit1((byte) 13);
        x.SetBit1((byte) 14);
        x.SetBit1((byte) 15);
        x.SetBit1((byte) 16);
        x.SetBit1((byte) 17);
        x.SetBit1((byte) 18);
        x.SetBit1((byte) 19);
        x.SetBit1((byte) 20);
        x.SetBit1((byte) 21);
        x.SetBit1((byte) 22);
        x.SetBit1((byte) 23);
        x.SetBit1((byte) 24);
        x.SetBit1((byte) 25);
        x.SetBit1((byte) 26);
        x.SetBit1((byte) 27);
        x.SetBit1((byte) 28);
        x.SetBit1((byte) 29);
        x.SetBit1((byte) 30);
        x.SetBit1((byte) 31);
        x.SetBit1((byte) 32);
        
        System.out.println(x);
        System.out.println("Numero: "+x.getX());
        System.out.println("Suma de Posiciones: "+x.sumarPos());
    }
}
