package multiclasedavid;
public class ClaseFecha {
    int f;
    public ClaseFecha (){
        f=0;
    }
    public void Insertar(int d, int m, int a){
        if (((d>0)&&(d<31))&&((m>0)&&(m<13))&&((a>0)&&(a<200))){
            f=d;
            f=f<<4;
            f=f|m;
            f=f<<8;
            f=f|a;
        }else{
            System.out.println("Error:Fuera de Rango");
        }            
    }
    public int GetDia(){
        int d;
        d=f;
        d=d>>>12;        
        return d;
    }
    public int GetMes(){
        int m;
        m=f;
        m=m>>>8;
        m=m&15;
        return m;
    }
    public int GetAnio(){
        int a;
        a=f;
        a=a&255;
        return a;
    }
    public int getbit(int pos) {
     int mask = 1;
        mask= mask << pos-1;    
        mask=mask&f;
        mask=mask>>>pos-1;
        return (mask);
    }
    public void mostrar(){
        System.out.println(GetDia()+"/"+GetMes()+"/"+GetAnio());
    }
    @Override
    public String toString() {
        String y="x=";        
        int j=8;
        for (int i=17; i>=1; i--)
        {                   
            y=y+' '+getbit(i);        
        }
       return(y); 
    }
    public static void main(String[] args) {
        ClaseFecha x=new ClaseFecha();
        x.Insertar(5, 9, 155);
        x.mostrar();
        System.out.println(x.toString());
        System.out.println(x.GetMes());
    }
    
}
