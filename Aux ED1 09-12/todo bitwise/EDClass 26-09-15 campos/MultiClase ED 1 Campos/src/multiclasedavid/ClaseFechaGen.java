package multiclasedavid;
public class ClaseFechaGen {
    ClaseVectorBitGen v;
    int pos;
    public ClaseFechaGen (int cant){
        v=new ClaseVectorBitGen(cant,16);
        pos=0;
    }
    public void Insertar(int d, int m, int a){
        int f=0;
        if (((d>0)&&(d<31))&&((m>0)&&(m<13))&&((a>0)&&(a<200))){
            f=d;
            f=f<<4;
            f=f|m;
            f=f<<8;
            f=f|a;
            v.insertar(f, pos);
            pos++;
        }else{
            System.out.println("Error:Fuera de Rango");
        }            
    }
    public int GetDia(int y){
        int d;
        d=y;
        d=d>>>12;        
        return d;
    }
    public int GetMes(int y){
        int m;
        m=y;
        m=m>>>8;
        m=m&15;
        return m;
    }
    public int GetAnio(int y){
        int a;
        a=y;
        a=a&255;
        return a;
    }

    public void mostrar(){
        int i=0;
        while (i<pos){
            int x=v.getdato(i);
            System.out.println(GetDia(x)+"/"+GetMes(x)+"/"+GetAnio(x));
            i++;
        }                    
    }

    public static void main(String[] args) {
        ClaseFechaGen x=new ClaseFechaGen(1);
        x.Insertar(5, 9, 155);
        x.Insertar(9, 11, 15);
        x.mostrar();
    }
    
}
