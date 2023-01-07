package multiclasedavid2015;

public class BitwiseByte {

    byte x;
    public BitwiseByte() {
        x = 0;
    }

    public void SetBit1(byte pos) {
        byte mask = 1;
        mask = (byte) (mask << pos - 1);
        x = (byte) (x | mask);
    }

    public void SetBit0(byte pos) {
        byte mask = 1;
        mask = (byte) (mask << pos - 1);
        mask = (byte) ~mask;
        x = (byte) (x & mask);
    }

    public byte getBit(byte pos) {
        byte mask = 1;
        mask = (byte) (mask << pos - 1);
        mask = (byte) (mask & x);
        mask = (byte) (mask >>> pos - 1);
        return (mask);
    }

    public int getX() {
        if ((x>=-128)&&(x<=-1))
            return x+256;
        return x;
    }
    
    @Override
    public String toString() {
        String s = "         <   8     7     6     5     4     3     2     1   >\n         <  128   064   032   016   008   004   002   001  >\n\n";        
        s=s+"Birwise: <   ";        
        for (byte i = 8; i > 1; i--) {
            s = s + Math.abs(getBit(i)) + "     ";
        }        
        s = s + getBit((byte)1) + "   >";
        return s;
    }

    public static void main(String[] args) {
        BitwiseByte x = new BitwiseByte();
        x.SetBit1((byte) 1);
//        x.SetBit1((byte) 2);
        x.SetBit1((byte) 3);
//        x.SetBit1((byte) 4);
        x.SetBit1((byte) 5);
        
//        x.SetBit1((byte) 6);
        x.SetBit1((byte) 7);
        x.SetBit1((byte) 8);
        System.out.println(x);
        System.out.println("Numero: "+x.getX());
    }

}
