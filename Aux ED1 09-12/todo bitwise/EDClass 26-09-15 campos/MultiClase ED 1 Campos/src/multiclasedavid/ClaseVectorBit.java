package multiclasedavid;
public class ClaseVectorBit { int x;

    public ClaseVectorBit()
    { x=0;
    }
    public void setbit1(int pos) {
            int mask = 1;
            mask= mask << pos-1;
            x=x|mask;
        }
    public void setbit0(int pos) {
            int mask = 1;
            mask= mask << pos-1;
            mask=~mask;
            x=x&mask;
    }

    public int getbit(int pos) {
     int mask = 1;
        mask= mask << pos-1;    
        mask=mask&x;
        mask=mask>>>pos-1;
        return (mask);
    }
    public int getX() {     
        return x;
    }
    @Override
    public String toString() {
        String y="x=";
        for (int i=32; i>=1; i--)
        { y=y+' '+getbit(i);
        
        }
        return(y); 
    }
    public static void main(String[] args) {
        ClaseVectorBit a=new ClaseVectorBit();
        a.setbit1(3);
        a.setbit1(8);
        a.setbit1(35);
        System.out.println(a);
        a.setbit1(32);
        System.out.println(a);        
        System.out.println(a.getbit(8));
   }      
}