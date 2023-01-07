/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno.clases;

/**
 * Ayudantia 1/2016 Eddy Escalante
 */

public class PilaBit {
// atributos 
    VectorBitG P;
    int cima;
    int ri;
    int rf;
    // constructor de copia
    public PilaBit(PilaBit A){
        cima=A.cima;
        ri=A.ri;
        rf=A.rf;
        P=A.P;
    }
    
// constructor parametrizado
    public PilaBit(int cant,int ini,int fin){
            P=new VectorBitG(cant, ini, fin);
            cima=0;                               // pila vacia
    }
   
    public boolean llena(){
        return (cima==P.Getcant());
    }
    public boolean vacia(){
        return (cima==0);
    }
 // Meter un elemento a la PilaBit
    public void PushBit(int dato){
        if (llena()){
            System.out.println("PilaBit::PusBit:Error la PilaBit esta llena");
        }else{
            cima++;
            P.SetData(cima, dato);
        }
    }
 // Sacar un elemento de la pila   
    public int PopBit(){
        int x=-1;              // retorna -1 cuando la pila esta vacia
        if (vacia()){
           System.out.println("PilaBit::PopBit:Error la PilaBit esta vacia");
        }else {
           x=P.GetData(cima);
           cima--;
        }
        return x;
    }    
    
    public int GetCima(){
        return cima;
    }






}
