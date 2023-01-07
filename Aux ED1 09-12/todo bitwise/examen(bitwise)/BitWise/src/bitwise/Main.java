/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitwise;

/**
 *
 * @author ESTUDIANTE
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        // TODO code application logic here
        //FraccionBit b= new FraccionBit(10);
       // b.Insertar(9, 9, 1);    //-1/3
       // b.Insertar(1, 9, 0);    //+1/8
        //b.Insertar(2, 5, 1);    //-2/5
        //for (int i=1;i<=3;i++){
            //System.out.println(b.sacar(i));
       // }
        //ConjuntosBit A= new ConjuntosBit();
        //A.insetar(5);
        //A.insetar(0);
        //A.insetar(20);
        //A.insetar(7);
        //for (int i=0;i<=30;i++){
           // if ((A.Getbit((byte)i)<=30)&&(A.Getbit((byte)i)==1))
                //System.out.println(i+",");
      //  } 
   CintaBitexa C= new CintaBitexa(50);
        C.Insertar('e'); 
        C.Insertar('r');
        C.Insertar('n'); 
        C.Insertar('e');
        C.Insertar('s');
        C.Insertar('t');
        C.Insertar('o');
        C.Insertar(' ');
        C.Insertar('p');
        C.Insertar('e');
        C.Insertar('r');
        C.Insertar('e');
        C.Insertar('z');
        C.Insertar(' ');
        C.Insertar('e'); 
        C.Insertar('r');
        C.Insertar('n'); 
        C.Insertar('e');
        C.Insertar('s');
        C.Insertar('t');
        C.Insertar('o');
        C.Insertar(' ');
        C.Insertar(' ');
        C.Insertar(' ');
        C.Insertar(' ');
        C.Insertar(' ');
        C.Insertar(' ');
        C.Insertar(' ');

        int x=(C.ContPal());
        System.out.println(x);
        System.out.println(C.Mostrarcinta());
        System.out.println(C.Mostrarpalabra());
        System.out.println(C.Mostrarpalabra());
        System.out.println(C.Mostrarpalabra());
        System.out.println(C.Mostrarpalabra());
        C.Eliminarpalabra();
        System.out.println(C.Mostrarcinta());
        System.out.println(C.ContPal());
        
      /* // PilaBit P=new PilaBit(10, 7);
        //P.push(10);
        //P.push(10);
       // P.push(11);
      //  P.push(11);
      //  P.push(11);        
      //  P.Eliminar();
       //for(int i=P.cima;i>=0;i--)
       //     System.out.println(P.pop());*/
        
        
        
        ////////////*************/////////////////
//       PolinomioBit Pl=new PolinomioBit(5, 20);
//        PolinomioBit Q=new PolinomioBit(5,20);
//        PolinomioBit R=new PolinomioBit(5,20);
//        Pl.InsertarMonomio(1, 2);
//        Pl.InsertarMonomio(10, 3);
//        Pl.InsertarMonomio(1, 4);
//        Pl.InsertarMonomio(2, 0);
//        Q.InsertarMonomio(10, 2);
//        Q.InsertarMonomio(1, 0);  
//            //******//R.divicion(Pl, Q); esto estaba en comentario
//        R.Sumar(Pl, Q);
        
        
        //System.out.println("P(X)= "+P.toString()+". Evaluacion de P= "+ (int)P.Evaluar(3));//+". Grado de P="+P.grado());
        //P.EliminarM(2);
        //System.out.println("P(X)= "+P.toString()+". Evaluacion de P= "+ (int)P.Evaluar(3));
        //.Eliminar(3);
        
        
        ////////////*************/////////////////
//        System.out.println("P(X)= "+Pl.toString()+". Evaluacion de P= "+ Pl.Evaluar(3)+". Grado de Q="+Pl.grado());
//        System.out.println("Q(X)= "+Q.toString()+". Evaluacion de Q= "+Q.Evaluar(3)+". Grado de Q="+Q.grado());
//        System.out.println("R(X)= "+R.toString()+". Evaluacion de R= "+R.Evaluar(3)+". Grado de R="+R.grado());
    }
    
}
