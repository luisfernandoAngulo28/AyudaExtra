/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author Samuel
 */
public class VectorbitG {
        int Z[];//vector de ENTEROS
        int n;  //Nº de elementos del vector
        int bits;//Nº de bits que maneja el vector

        public VectorbitG(int CantEle,int Cantbits){//Cantbits=cantidad de bits para reprecentar un numero
                 int Nb=CantEle*Cantbits;
                 int NE=Nb/32;
                 if(Nb%32!=0){
                       NE++;
                 }
             Z=new int[NE];
             n=CantEle;
             bits=Cantbits;
        }                                                                                   //bits=5 n=8 NE=2     z[0] z[1]
 //--------------------------------------------------------------------------------------------------//
         public void InsertarenZ(int ele,int pos){ //inserta un ele en el vector en la pos especifica
        if (pos<=n)
        { int Ne=((pos-1)*bits)/32;
          int Nb=((pos-1)*bits)%32;

           if (Nb+bits<=32){
            int mask=   (int) (Math.pow(2, bits) - 1);
            mask=mask<<Nb;
            mask= ~mask;
            Z[Ne]=Z[Ne] & mask; //borra los bits especificado
            int valor=ele<<Nb;
            Z[Ne]=Z[Ne]| valor;
            }
           else{//
                  Z[Ne]=Z[Ne]<<32-Nb;
                  Z[Ne]=Z[Ne]>>>32-Nb;
                  int valor=ele<<Nb;
                  Z[Ne]=Z[Ne]|valor;
                  Z[Ne+1]=Z[Ne+1]>>>Nb+bits-32;
                  Z[Ne+1]=Z[Ne+1]<<Nb+bits-32;
                  valor=ele>>>32-Nb;
                  Z[Ne+1]=Z[Ne+1]|valor;
            }
        }else{
          System.out.print("Error funcion fuera de rango");
        }
    }
//--------------------------------------------------------------------------------------------------//
          public int get(int pos){

       int Ne=((pos-1)*bits)/32;
       int Nb=((pos-1)*bits)%32;
        int mask=(int) (Math.pow(2, bits) - 1);
        mask=mask<<Nb;
        mask=Z[Ne] & mask;
        mask=mask>>>Nb;
        if (Nb+bits>32){
            int mask1=(int) (Math.pow(2, bits) - 1);
            mask1=mask1>>>32-Nb;
            mask1= Z[Ne+1] & mask1;
            mask1=mask1<<32-Nb;
            mask=mask |mask1;

        }
         return mask;
       }
      @Override
public String toString(){
String s="[";
            for (int i = 1; i <=n; i++) {
                  s=s+get(i)+",";

            }
      s=s+"]";
      return s;
}
      public String ToString(){
String s="[";
            for (int i = 1; i <=n; i++) {
                  s=s+Integer.toBinaryString(get(i))+",";

            }
      s=s+"]";
      return s;
}
//****************************************************************************************************//
      public static void main(String[]args){
      VectorbitG v=new VectorbitG(10,6);//EL 10 ES CANTIDAD DE ELEMENTOS Y EL 6 ES CANTIDAD DE BITS
        v.InsertarenZ(3,1);//el 3 es el ele y el 1 es la pos
        v.InsertarenZ(1,2);
        v.InsertarenZ(8,3);
        v.InsertarenZ(29,4);
        v.InsertarenZ(5,5);
        v.InsertarenZ(2,6);
        v.InsertarenZ(63,10);
       // int x=v.get(3);//x=3
        System.out.println(v.toString());
        System.out.println(v.ToString());
      }

}
