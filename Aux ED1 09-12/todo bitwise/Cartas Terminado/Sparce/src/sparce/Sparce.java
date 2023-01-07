/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sparce;

import pvectorbit.VectorbitG;
public class Sparce { VectorbitG v;
                     int NFil;
                     int NCol;
                     int ep;
                     int cant;
public Sparce(int fil, int col, int Ep, int Nbits){
          v=new VectorbitG(10, Nbits);
           NFil=fil;
           NCol=col;
           ep=Ep;
           cant=0;
}
public void Set(int fila, int col, int dato)
{
     int FC=(fila-1)*NCol+col;
    if (dato!=ep){
        cant++;
       
        v.insertarE(FC, dato);
        v.insertarE(dato, cant+1);
    }else{    //borrar
    cant++;
    int i=1;
    while((i<=cant)&&(v.getE(i)!=dato)){
        i=i+2;
        if(i<cant){
            for (int j = i; j < cant-2; j++) {
                v.insertarE(v.getE(i+2), j);
                
            }
            cant=cant-2;
        }
      }  
    }
}
public int Get(int fila, int col){
    int FC = ((fila-1)*NCol)+col;
    int i=1;
    while((i<=cant)&&(v.getE(i)!=FC)){
        i=i+2;
    }
    if(i<cant){
        return (v.getE(i+1));
    }
    else{
        return (ep);
    }
    
    
}

    @Override
    public String toString() {
        String a="La Matriz Sparce es : ";
        //for (int i = 0; i < ; i++) {
            
     //   }
        return super.toString();
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
}
