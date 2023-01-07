/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author AsecinoCerebral
 */
public class VectorBitG {
   int V[];
   int Dim;
   int Ri;
   int Rf;
   int CBits;
   private int NEntero(int pos){
     return ((pos-1)*CBits)/32;
   }
   private int NBits(int pos){
       return ((pos-1)*CBits)%32;
   }
   public VectorBitG(int dim1 ,int ri,int rf){
    int x=(rf-ri)+1;
    int i=1;
      while (Math.pow(2, i)<x){
          i++;
      }
      CBits=i+1;
      int z=(dim1*CBits)/32;  int y= ((dim1*CBits)%32);
        if (y==0){
         V=new int [z];
        }else{
         z++;
         V=new int [z];
        }
          Dim=dim1;
          Ri=ri;
          Rf=rf;
   }
   public void SetDato(int dato ,int pos){
        if (pos <= Dim && pos>=0 && dato>=Ri && dato <=Rf)
        {
            int nb = NBits(pos), ne = NEntero(pos);
            int e2 = dato, mask = (int)Math.pow(2, CBits)-1;
            mask = mask << nb;
            mask = ~ mask;
            V[ne] = V[ne] & mask;
            dato = dato << nb;
            V[ne] = V[ne] | dato;
            if (nb + CBits > 32){
               V[ne + 1] = V[ne + 1] >>>(32-nb);
                V[ne + 1] = V[ne + 1] <<(32-nb);
                e2 = e2 >>> (32 - nb);
                V[ne + 1] = V[ne + 1] | e2;
            }
        } 
   }
  public int GetDato(int pos){ 
      if (pos <= Dim && pos >=0)
        {
            int nb = NBits(pos), x = NEntero(pos);
            int z = V[x], mask = (int)Math.pow(2, CBits)-1;
            z = z >>> nb;
              if (nb+CBits >32){
                 int m=V[x+1];
                 m=m<<(32 -nb);
                 z=z|m;
             }  
            z = z & mask;   
            return z;
        }
        System.out.println("ERROR: posicion fuera de rango");
        return 0;
  }
  public int GetCant(){
    return Dim-1;
  }
  public String Mostrar(){
    String s="";
     for (int i=1; i<=Dim;i++){
      s=s+ GetDato(i) +" | ";
     }
     return s;
  } 
}
