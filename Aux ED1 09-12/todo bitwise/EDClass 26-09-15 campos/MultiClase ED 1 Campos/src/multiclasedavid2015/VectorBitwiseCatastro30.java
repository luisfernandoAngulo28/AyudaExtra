 package multiclasedavid2015;

public class VectorBitwiseCatastro30 {
    int v[];
    int cant;
    int Dim;
    public VectorBitwiseCatastro30(int cant){
        int NBits=cant*30;
        int NE=NBits/32;
        if (NBits%32!=0)
            NE++;        
        v=new int[NE];
        this.cant=cant;
        Dim=0;
    }
    public int NEntero(int pos){
        return (((pos-1)*30)/32);    
    }

    public int NBit(int pos){
        return ((((pos-1)*30)%32)+1);    
    }
    public void insertar(int ele,int pos){
        int ele1=ele;
        int NE=NEntero(pos);
        int Nb=NBit(pos);
        int mask=(int)Math.pow(2,30)-1;
        mask=mask<<(Nb-1);
        mask=~mask;
        v[NE]=v[NE]&mask;
        ele=ele<<(Nb-1);
        v[NE]=v[NE]|ele;
        if ((Nb-1+30)>32){
            int bf=(Nb+30-32-1);
            mask= ((int)(Math.pow(2,bf)))-1;            
            mask=~mask;
            v[NE+1]=v[NE+1]&(mask);
            ele1=ele1>>>(30-bf);
            v[NE+1]=v[NE+1]|ele1;
        }        
        Dim++;
    }
    public int sacar(int pos){
        int NE=NEntero(pos);
        int Nb=NBit(pos);
        int mask=(int)Math.pow(2,30)-1;
        mask=mask << (Nb-1);
        mask=mask&v[NE];
        mask=mask>>>(Nb-1);
        if ((Nb-1+30)>32){
            int bf=((30-(32-Nb))-1);
            //int mask1=((int)(Math.pow(2,bf)))-1;
            int mask1=(int)Math.pow(2,30)-1;
            mask1=mask1>>>(30-bf);
            mask1=mask1&v[NE+1];
            mask1=mask1<<(30-bf);
            mask=mask|mask1;
        }
        return mask;
    }
    @Override
    public String toString() {
        String s="Vector=[ ";
        for (int i = 1; i < Dim; i++) 
            s=s+sacar(i)+", ";
        s=s+sacar(Dim)+" ]";        
        return s;
    }
    
    public static void main(String[] args) {   
        VectorBitwiseCatastro30 H= new VectorBitwiseCatastro30(10);
        H.insertar(7,1);
        H.insertar(4,2);
        H.insertar(9,3);
        H.insertar(28,4);
        H.insertar(5, 5);
        System.out.println(H);
    }
}
