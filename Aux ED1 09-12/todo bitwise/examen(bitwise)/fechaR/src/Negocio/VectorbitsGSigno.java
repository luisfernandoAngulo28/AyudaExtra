/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author MAISEL
 */
public class VectorbitsGSigno {
          private int z[];
          private int n;
          private int bits;
          int cantidad;

      public  VectorbitsGSigno(int canElem, int canBits) {
              int Nb=canElem*canBits+1;
              int NE=Nb/32;
                 if(Nb%32!=0){
                       NE++;
                 }
               z=new int[NE];
               n=canElem;
               bits=canBits+1;
               cantidad = 0;
      }

      public void insertar(int Elem, int pos) {
         if (pos<=n )
        { int Ne=((pos-1)*bits)/32;
          int Nb=((pos-1)*bits)%32;

          if (Elem<0){ //aqui coloco el bit de signo al numero
                Elem=Elem*(-1);
                int a = 1;
                a = a<<(bits-1);
                Elem = Elem|a;
          }

           if (Nb+bits<=32){
                  int mask=   (int) (Math.pow(2, bits) - 1);
                  mask=mask<<Nb;
                  mask= ~mask;
                  z[Ne]=z[Ne] & mask; //borra los bits especificado
                  int valor=Elem<<Nb;
                  z[Ne]=z[Ne]| valor;
            }
           else{//
                  z[Ne]=z[Ne]<<32-Nb;
                  z[Ne]=z[Ne]>>>32-Nb;
                  int valor=Elem<<Nb;
                  z[Ne]=z[Ne]|valor;
                  z[Ne+1]=z[Ne+1]>>>Nb+bits-32;
                  z[Ne+1]=z[Ne+1]<<Nb+bits-32;
                  valor=Elem>>>32-Nb;
                  z[Ne+1]=z[Ne+1]|valor;
            }
            cantidad++;
        }else{
            System.out.print("Error poscicion fuera de rango");
        }
      }

      public int getElemento(int pos){

       int Ne=((pos-1)*bits)/32;
       int Nb=((pos-1)*bits)%32;
        int mask=(int) (Math.pow(2, bits) - 1);
        mask=mask<<Nb;
        mask=z[Ne] & mask;
        mask=mask>>>Nb;
        if (Nb+bits>32){
            int mask1=(int) (Math.pow(2, bits) - 1);
            mask1=mask1>>>32-Nb;
            mask1= z[Ne+1] & mask1;
            mask1=mask1<<32-Nb;
            mask=mask |mask1;

        }
        int a = mask>>(bits-1);//aqui se le coloca el signo al numero si este es negativo
        if (a==1) {
               a = (int) Math.pow(2, bits-1)-1;
                mask = mask&a;
                mask = mask*(-1);
              }
         return mask;
       }

      public void imprimir() {
            int i = 1;
            while (i<=cantidad) {
                  System.out.print(getElemento(i)+" ");
                  i++;
            }
            System.out.println();
      }

      public static void main(String args[]) {
            VectorbitsGSigno vs = new VectorbitsGSigno(10,7);
            vs.insertar(-12, 1);
            vs.insertar(-5, 2);
            vs.insertar(10, 3);
            vs.insertar(-2, 4);
            vs.insertar(5, 5);
            vs.insertar(-127, 6);
            vs.insertar(-3, 8);
            vs.imprimir();
            vs.insertar(121, 1);
            vs.imprimir();
      }
}
