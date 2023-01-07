package multiclasedavid2015;
public class MatrizSparceVector {
    int VFC[];//VECTOR FILA COLUMNA
    float VD[];//VECTOR DATO
    int Dim;//DIMENSION VECTOR
    int EP;//Nº ELEMENTO PREDOMINANTE
    int NFil;//Nº FILAS
    int NCol;//Nº COLUMNAS
    
    public MatrizSparceVector(int Fil, int Col, int EP){
        VFC=new int[10];
        VD=new float[10];
        Dim=-1;
        this.EP=EP;
        NFil=Fil;
        NCol=Col;
    }
    public void Set(int Fil, int Col, int Ele){
        if (Fil<1 || Fil>NFil|| Col <1|| Col > NCol){
            System.out.println("Error Fila columna fuera de rango");
            return;
        }
        int FC=(NCol*(Fil-1))+Col;        
        if ((!Existe(FC))&&(Ele!=EP)){
            if (Dim==VD.length-1){//Esta lleno
                redimencionar();
            }
            Dim++;
            VD[Dim]=Ele;
            VFC[Dim]=FC;            
        }else{
            if ((Existe(FC))){
                int i=0;
                while (VFC[i]!=FC){
                    i++;
                }
                if (Ele==EP){
                    for (int j = i; j < Dim-1; j++) {
                        VFC[j]=VFC[j+1];
                        VD[j]=VD[j+1];
                    }
                    Dim--;
                }else{
                    VD[i]=Ele;
                    VFC[i]=FC;
                }       
            }            
        }
    }
    
    public float get(int Fil,int Col){
        float x=EP;
        int FC=(NCol*(Fil-1))+Col;
        if (Existe(FC)){
            int i=0;
            while (VFC[i]!=FC){
                i++;
            }
            x=VD[i];
        }
        return (x);
    }
    private Boolean Existe(int FC){
        int i=0;
        while ((i<=Dim)&&(VFC[i]!=FC)){
            i++;
        }
        return (i<=Dim);
        
    }
    public Boolean Vacia(){
        return Dim==-1;
    }
    public void redimencionar(){
        float VAux[] = new float[Dim+10];
        System.arraycopy(VD, 0, VAux, 0, Dim+1);
        VD = new float[Dim+10];
        System.arraycopy(VAux, 0, VD, 0, Dim+1);
        int vfc2[] = new int[Dim+10];
        System.arraycopy(VFC, 0, vfc2, 0, Dim+1);
        VFC = new int[Dim+10];
        System.arraycopy(vfc2, 0, VFC, 0, Dim+1);
    }
    @Override
    public String toString(){
        String S="MATRIS SPARCE\n";
        for (int i = 1; i <= NFil; i++) {
            for (int j = 1; j <= NCol; j++) {
                if (get(i,j)>9)
                    S=S+get(i, j)+" ; ";                
                else
                    S=S+get(i, j)+" ;  ";                
            }
            S=S+"\n";
        }
        return S;
    }
    /*Realizar un metodo del TDA matriz sparce, que me permita 
    neutralizar(volver elemento predominante) a cada columna
    que tenga mas de 3 elementos repetidos*/
    //Matriz
    //1 2 3 4 5
    //1 2 5 4 5
    //1 5 4 4 2
    //1 2 3 8 5
    
    //0 0 3 0 0
    //0 0 5 0 0
    //0 5 4 0 2
    //0 0 3 8 0
    public Boolean ColumaRepetida(int Col, float Ele){
        int c=0;
        for (int i = 1; i <=NFil; i++) {
            if ((get(i, Col)==Ele)&&get(i, Col)!=EP)
                c++;            
        }
        if (c>2)
            return true;
        else
            return false;            
    }        
    public String toString1(){
        String S="MATRIS SPARCE\n";
        for (int i = 1; i <= NFil; i++) {            
            for (int j = 1; j <= NCol; j++) {
                if (!ColumaRepetida(j, get(i, j)))
                    S=S+get(i, j)+" ;  ";                
                else
                    S=S+EP+",0 ;  ";                
            }
            S=S+"\n";
        }
        return S;
    }
    public static void main(String[] args) {
        MatrizSparceVector M=new MatrizSparceVector(6, 5, 0);
//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= 5; j++) {
//                M.Set(i, j, i*j);
//            }            
//        }
//        System.out.println("Get Elemento = "+ M.get(5, 4));        
        M.Set(1, 1, 2);
        M.Set(2, 1, 2);
        M.Set(3, 1, 2);
        M.Set(4, 1, 2);
        M.Set(5, 1, 3);
        M.Set(6, 1, 3);
        M.Set(1, 2, 4);
        M.Set(2, 2, 4);
        M.Set(3, 2, 5);
        M.Set(4, 2, 5);
        M.Set(5, 2, 5);
        M.Set(6, 2, 5);
        M.Set(1, 3, 3);
        M.Set(2, 3, 7);
        M.Set(3, 3, 4);
        M.Set(4, 3, 7);
        M.Set(5, 3, 7);
        M.Set(6, 3, 9);
//        M.Set(6, 1, 3);
        System.out.println(M);
        System.out.println(M.toString1());
    }
}
