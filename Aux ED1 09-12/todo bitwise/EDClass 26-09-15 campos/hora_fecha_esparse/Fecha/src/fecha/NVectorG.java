/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

/**
 *
 * @author usuario
 */
public class NVectorG {
    
                    int z[];
                    int n;
                    int bits;
                    int NE;


public NVectorG(int cant, int Nbits){
    int nb= cant*Nbits;
    int ne=nb/32;
    if (ne%32 !=0)
        ne++;

    z= new int [ne];
    n=cant;
    bits= Nbits;
    NE=ne;
    for(int i=0; i<=ne-1; i++)
        z[i]=0;
}


public void Set(int pos,int ele){
if ( (ele<=((int)Math.pow(2, bits)-1))&&(pos<=n)){
//
        int ne = ((pos-1)*bits)/32;
        int nb = ((pos-1)*bits)%32;
            if ((nb+bits)<=32){
                int mask = (int)Math.pow(2, bits)-1;
                    mask = mask << nb;
                    mask = ~mask;
                    z[ne] = z[ne]& mask;
                    int valor = ele<<nb;
                    z[ne]=z[ne]|valor;
            }else{
                    z[ne]=z[ne]<< (32-nb);
                    z[ne]=z[ne]>>> (32-nb);
                    int valor = ele << nb;
                    z[ne]=z[ne]|valor;
                    z[ne+1]= z[ne+1]>>>((nb+bits)-32);
                    z[ne+1]= z[ne+1]<<((nb+bits)-32);
                    valor = ele>>>(32-nb);
                    z[ne+1]= z[ne+1] | valor;

            }
    }else{
        System.out.println("Error elemento o posicion fuera de rango ");
    }
}


public int Get(int pos){
   int valor=0;
     if(pos <= n){
        int ne=((pos-1)*bits)/32;
        int nb=((pos-1)*bits)%32;
        if (nb+bits <=32){
            int mask = (int)  Math.pow(2, bits)-1;
            mask=mask<<nb;
            valor= z[ne]& mask;
            valor= valor>>>nb;



        }else{
           int mask= (int) (Math.pow(2, bits))-1;
           mask= mask<<nb;
           int valor1= z[ne]&mask;
           valor1= valor1>>>nb;
           int mask2= (int) (Math.pow(2, bits))-1;
                mask2= mask2>>>(32-nb);
           mask2= z[ne+1]&mask2;
           mask2=mask2<<(32-nb);
           valor=valor1|mask2;

        }

     }
return (int) valor;

    }

public void Redimensionar(int cant){   // recibe la cant de elementos a adicionar

     int nb= cant*bits;
    int ne=nb/32;
    if (ne%32 !=0)
        ne++;
    int y[];
    y= new int [ne];
    for(int i=0; i<=ne-1; i++)
        y[i]=0;

    for (int i=0; i<=NE-1; i++)  /// movemos los valores a otro vector
        y[i]= z[i];
     z= new int [ne];
    for(int i=0; i<=ne-1; i++)   // volvemos a construir el vector bitwise
        z[i]=0;

    for(int i=0; i<=ne-1; i++)    // ahora movemos los valores a vector bitwise
            z[i]=y[i];

    NE=ne;
    n=cant;

}
public void Mostrar(){
    System.out.println(" EL VECTOR ES:  " );
//    System.out.print("v[ " );
    for(int i=1; i<=n; i++){
         System.out.print("v"+"["+ i +"]"+ "= "+Get(i)+ " " );

//         System.out.print(Get(i)+ "," );

    }
//     System.out.print(" ]" );
    System.out.println();
}

public void Cargar(){
  //  inserta un elemento en la (pos , ele);
    this.Set(10,1);
//    this.Set(11, 20);
//    this.Set(20, 21);



}
 ///----***--- P R O G R A M A   P R I N C I P A L ---***----///
 public static void main(String[] args) {

  NVectorG v= new NVectorG(10,13);
 

  v.Cargar();
////  System.out.print(v.Get(1));
  v.Mostrar();
//  v.Redimensionar(v.n+12);
// v.Cargar();
//  v.Mostrar();

 }

    
    
    
}
