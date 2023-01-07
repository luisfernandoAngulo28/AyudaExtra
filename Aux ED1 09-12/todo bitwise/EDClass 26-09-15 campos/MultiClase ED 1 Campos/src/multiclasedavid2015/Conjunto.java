package multiclasedavid2015;

public class Conjunto {
    int v[];//Vector de Enteros
    int dim;//Cantidad de elementos
    
    public Conjunto(){
        this.dim=-1;
        v=new int[20];
    }
    public Conjunto(int Cantidad){        
        v=new int[Cantidad];
        this.dim=-1;
    }
    public int cantidad(){
        return (dim+1);
    }
    public Boolean vacia(){
        return (dim==-1);
    }
    private Boolean llena(){
        return (dim==v.length-1);
    }
    public void insertar(int ele){
        if (llena())
            redimencionar();
        if (vacia()){
            dim++;
            v[dim]=ele;
        }else{
            if (!pertenece(ele)){
                dim++;
                v[dim]=ele;
            }
        }
    }
    private void redimencionar(){
        //falta        
//        v=new int [dim+2];
        int v1[]=new int[dim+1];
        //              fuente  dimension       destino
        System.arraycopy(v,     dim+1,          v1,         dim+1, v1.length);
        v=new int [dim+10];
        System.arraycopy(v1, dim+1, v, dim+1, v.length);        
    }
    
    public Boolean pertenece(int ele){
        int i=0;
        while ((i<=dim)&&(v[i]!=ele))
            i++;        
        return (i<=dim);        
    }
    public void eliminar(int ele){
        if (!vacia()){
            if (pertenece(ele)){
                int i=0;
                while (v[i]!=ele)
                    i++;                
                for (int j=i; j<=dim-1;j++)
                    v[j]=v[j+1];                
                dim--;
            }
        }
    }
    public void union(Conjunto A, Conjunto B){
        for (int i=0;i<=A.dim;i++){
            insertar(A.v[i]);
        }
        for (int i=0;i<=B.dim;i++){
            insertar(B.v[i]);
        }
    }
    public void interserccion(Conjunto A, Conjunto B){
        for (int i=0;i<=A.dim;i++){
            if (B.pertenece(A.v[i])){
                insertar(A.v[i]);
            }            
        }
    }    
    
    public void interserccion1(Conjunto A, Conjunto B){
        for (int i=0;i<=A.dim;i++){
            for (int j=0;j<=A.dim;j++){
                if (A.v[i]==B.v[j]){
                    insertar(A.v[i]);
                }
            }
        }
    }
    public Boolean subconjunto(Conjunto x){
        if (this.dim<=x.dim){
            int i=0;
            while ((i<=this.dim)&&(x.pertenece(this.v[i])))
                i++;            
            return (i>dim);
        }else{
            return false;
        }
    }
    @Override
    public String toString() {                
        String cad=""; 
        for (int i=0;i<=dim;i++){
            cad=cad+v[i]+", ";
        }
        return cad;
    }
    public static void main(String[] args) {
        Conjunto A=new Conjunto(50);
        A.insertar(7);
        A.insertar(8);
        A.insertar(10);
        A.insertar(7);
        A.insertar(11);
        System.out.println(A);                
    }
}
