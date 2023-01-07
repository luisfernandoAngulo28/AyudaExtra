
package COLA.tres.ColaBanco;

/**
 * Ayudantia 1/2016 Aux. Eddy Escalante
 */
public class ColaB {
     Usuario Q[];
    int F;
    int A;
    int NC;
    int NT;
    int NN;
    int Cant;
    byte Cajas;
    
    
    public ColaB(int cant){
        Q=new Usuario[cant];
        A=-1;
        F=-1;
        Cajas=3;
        NT=0;
        NC=0;
        NN=0;
        Cant=cant;
    }
     private boolean vacia()
    {
        return ((F == -1)&&(F == A));
    }
    
    private boolean llena()
    {
        return (((A+1)%Q.length)==F);
    }
    
    
    
    public void Meter(Usuario ele){
    if (! llena())
        {
            if (vacia())
            {
                F = A = 0;
                Q[F] = ele;
            }else{
                A = (A+1) % Q.length;
                Q[A] = ele;
            }
        }else
            System.out.println("ColaBan::Meter: Error: La cola está llena");    
    }
    public void MeterP(Usuario ele,int pos){
    if (! llena())
        {
            if (vacia())
            {
                F = A = 0;
                Q[F] = ele;
            }else{
                A = (A+1) % Q.length;
                Q[A] = ele;
            }
        }else
            System.out.println("ColaBan::Meter: Error: La cola está llena");    
    }
    public Usuario sacarC()
    {
        if (!vacia())
        {
            Usuario valor = Q[F];
            if (F == A)
                F = A = -1;
            else
                 F = (F + 1) % Q.length;
            return valor;
        }else
            System.out.println("Bicola::sacar: Error: La cola está vacía");
        return null;
    }
    
    public Usuario sacar(int pos)
    {
        if (!vacia())
        {
            Usuario valor = Q[pos];
            
            if (F == A){
                F = A = -1;
            }else{
                for (int i=F;i<pos;i++){
                    
                    Usuario y=sacarC();
                    Meter(y);
                    /*y.SetCliente(Q[i-1].GetClienteSt());
                    y.SetFicha(Q[i-1].GetNFicha());
                    y.SetTransacción(Q[i-1].GetTransacciónSt(Q[i-1].GetTransacción()));*/
                    //Q[i]=y;
                 }  
                Usuario y=sacarC();
                   
                //F = (F + 1) % Q.length;
            }
                 
            return valor;
        }else
            System.out.println("Bicola::sacar: Error: La cola está vacía");
        return null;
    }
    
    public int PosFichaM(){
       int i=(F);
       //int M=Q[i].GetNFicha();
       int M1=i;
      while (i!=(A+1)%Q.length){
          if (Q[i].GetNFicha()<Q[M1].GetNFicha()){
              M1=i;
          }
         i=(i+1)%Q.length; 
      } 
    
    return M1;
    }
    public int PosFichaMayor(){
       int i=(F);
       //int M=Q[i].GetNFicha();
       int M1=i;
      while (i!=(A+1)%Q.length){
          if (Q[i].GetNFicha()>Q[M1].GetNFicha()){
              M1=i;
          }
         i=(i+1)%Q.length; 
      } 
    
    return M1;
    }
    public int PosFichaM(char X){
       int i=(F);
       //int M=Q[i].GetNFicha();
       int M1=PosFichaMayor();
      while (i!=(A+1)%Q.length){
          if ((Q[i].GetNFicha()<Q[M1].GetNFicha())&&(Q[i].GetCliente()==X)){
              M1=i;
          }
         i=(i+1)%Q.length; 
      } 
    
    return M1;
    }
    public boolean Existe(char X){
        int i=(F);
       boolean S=false;
      while (i!=(A+1)%Q.length){
          if (Q[i].GetCliente()==X){
              S=true;
          }
         i=(i+1)%Q.length; 
      } 
    
    return S;
    }
    
    public int FichaM(){
       int i=(F);
       int M=Q[i].GetNFicha();
      while (i!=(A+1)%Q.length){
          if (Q[i].GetNFicha()<M){
              M=Q[i].GetNFicha();
          }
         i=(i+1)%Q.length; 
      } 
    
    return M;
    }
    public int Atender(){
     if (vacia()){
            System.out.println("ColaB::Sacar: Error: La cola está vacía");
            return -1;
     }else{
         /*if (Q.length<=Cajas){
             
             Usuario z=sacar(F);
             return z.GetNFicha();
         }else{*/
             
    if ((NC<4)&&(Existe('C'))){
        int M=PosFichaM('C');
            Usuario z=sacar(M);
            NC++;
            return z.GetNFicha();
        
      }  
    
      if  ((NT<1)&&(Existe('T'))) {
           int M=PosFichaM('T');
            Usuario z=sacar(M);
            NT++;
            return z.GetNFicha();
      
      }
      if ((NN<2)&&(Existe('N'))){
        int M=PosFichaM('N');
            Usuario z=sacar(M);
            NN++;
            if(NN==2){
            NC=NT=NN=0;
            }    
            return z.GetNFicha();
         
      }
      
      Usuario z=sacar(F);
      return -1;
         }            
     }
      
    
    
   public String toString(){
     String S="";
     int i=F;
      while (i!=(A+1)%Q.length) {
          
          S=S+Q[i].GetNFicha()+" "+Q[i].GetClienteSt(Q[i].GetCliente())+" ";
          i=(i+1)%Q.length;
         /* if(i==A){
              S=S+j+" "+Q[i].GetClienteSt(Q[i].GetCliente())+" ";
         } */
      }
      
     return S;
 }
}
