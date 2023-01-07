package Negocio;


   public class VectorBitGenerico {
    int V[];//vector de bits
    int cbit; //cantidad de bit
    int dim; //dimension
   public VectorBitGenerico(int cantbit,int Nelementos)
         {
             int x=((Nelementos*cantbit)/32);
             V =new int[x+1];
             cbit=cantbit;
             dim=Nelementos;
         }
   private int elevado(int b,int exp)
        {int res;
            if (exp==0){
               res=1; 
            }else{
                 res=1;
                for (int i=1;i<=exp;i++){
                    res=res*b;
                }
            }
            return res;
        }
            
     private int Nbit(int pos)
        {
          return ((((pos-1)*cbit))%32)+1;
        }
        private int NEnter(int pos)
        {
            return ((((pos-1)*cbit)/32));
        }
        
        public void Insertar(int dato,int pos)
        {
         
            if (pos<=dim){
                int x=Nbit(pos);
                int y=NEnter(pos);
                if(x+cbit<=32) {
                    dato=dato<<x-1;                    
                    int mask1=elevado(2,cbit)-1;
                    mask1=mask1<<x-1;
                    mask1=~mask1;
                    V[y]=V[y]&mask1;
                    V[y]=V[y]|dato;                    
                }else{
                   int dato1=dato;
                   dato=dato<<x-1;
                   int mask1=elevado(2,cbit)-1;
                   mask1=mask1<<x-1;
                   mask1=~mask1;
                   V[y]=V[y]&mask1;
                   V[y]=V[y]|dato;
                   dato1=dato1>>>32-x+1;
                   mask1=elevado(2,cbit)-1;
                   mask1=mask1>>>32-x+1;
                   mask1=~mask1;
                   V[y+1]=V[y+1]&mask1;
                   V[y+1]=V[y+1]|dato1;                   
                }      
            }else{
                System.out.print("Error la capacidad fue sobrepasada aumente elementos");
            }
        }
       
        public int Sacar(int pos)
        {int aux=0;
            if (pos<=dim){
                int x=Nbit(pos);
                int y=NEnter(pos);
                  if (x+cbit<=32){
                       aux=V[y];
                       aux=aux>>>x-1;
                       int mask1=elevado(2,cbit)-1;
                       aux=aux&mask1;                       
                  }else{
                      int aux2=V[y];
                      aux2=aux2>>>x-1;
                      aux=V[y+1];
                      int mask1=elevado(2,cbit)-1;
                      mask1=mask1>>>32-x+1;
                      aux=aux&mask1;
                      aux=aux<<32-x+1;
                      aux=aux|aux2;                     
                       
                  }
            }
          return aux;  
        }
        
        public static void main(String[] args) {
            VectorBitGenerico v = new VectorBitGenerico(20, 50);
            v.Insertar(35, 1);
            v.Insertar(80, 5);
            System.out.println(v.Sacar(5));
        }
}
