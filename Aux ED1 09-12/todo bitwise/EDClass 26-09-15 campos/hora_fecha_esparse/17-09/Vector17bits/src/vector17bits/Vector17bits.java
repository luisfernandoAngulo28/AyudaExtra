
package vector17bits;

public class Vector17bits {
    int v[];
    int cant;

    public Vector17bits(int cant){
        int NBits=cant*17;
        int NE=NBits/32;
        if ((NBits%32)!=0)
            NE++;
        v=new int[NE];
        this.cant=cant;
    }
    public void insertar(int ele,int pos){
        int ele1=ele;
        int NE=NEntero(pos);
        int Nb=NBit(pos);
        int mask=(int)Math.pow(2,17)-1;
        mask=mask<<(Nb-1);
        mask=~mask;
        v[NE]=v[NE]&mask;
        ele=ele<<(Nb-1);
        v[NE]=v[NE]|ele;
        if ((Nb-1+17)>32){
            int bf=(Nb+17-32-1);
            //mask= ((int)(Math.pow(2,bf)))-1;
            mask=(int)Math.pow(2,17)-1;
            mask=mask>>>(17-bf);
            mask=~mask;
            v[NE+1]=v[NE+1]&(mask);
            ele1=ele1>>>(17-bf);
            v[NE+1]=v[NE+1]|ele1;
        }
    }
    public int sacar(int pos){
        int NE=NEntero(pos);
        int Nb=NBit(pos);
        int mask=(int)Math.pow(2,17)-1;
        mask=mask << (Nb-1);
        mask=mask&v[NE];
        mask=mask>>>(Nb-1);
        if ((Nb-1+17)>32){
            int bf=((17-(32-Nb))-1);
            //int mask1=((int)(Math.pow(2,bf)))-1;
            int mask1=(int)Math.pow(2,17)-1;
            mask1=mask1>>>(17-bf);//error solucionado
            mask1=mask1&v[NE+1];
            mask1=mask1<<(17-bf);
            mask=mask|mask1;
        }
        return mask;
    }
    @Override
    public String toString() {
        String s="V=[";
        for (int i = 1; i <= cant; i++) 
            s=s+sacar(i)+" , ";
        s=s+"]";
        return s;
    }
   
    public int NEntero(int pos){
    return (((pos-1)*17)/32);    
    }

    public int NBit(int pos){
    return ((((pos-1)*17)%32)+1);    
    }
public static void main(String[] args) {   
Vector17bits b= new Vector17bits(10);
b.insertar(10,1);
b.insertar(10,2);
b.insertar(30,3);
b.insertar(40,4);
b.insertar(3,5);
b.insertar(15,10);

System.out.println(b);
b.insertar(15,2);
b.insertar(1005,1);

b.insertar(25,5);
System.out.println(b);
}
}
