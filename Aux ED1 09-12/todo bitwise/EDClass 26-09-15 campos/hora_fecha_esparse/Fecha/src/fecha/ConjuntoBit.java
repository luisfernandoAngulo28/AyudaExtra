/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

/**
 *
 * @author usuario
 */
public class ConjuntoBit {
    CBitwise x[];
    int cant;
//    int dim;
    public ConjuntoBit(int cant){
//        dim=10;
        int NE=cant/32;
        if((cant%32)!=0){
            NE++;
        }
    x=new CBitwise[NE];
        for (int i = 1; i < NE; i++) {
            x[i-1]= new CBitwise();
            
        }
        cant=0;
    }
public void InsertarC(int ele)
 { if(!pertenece(ele)){
    int Nbw=Nbitwise(ele);
    int Nbit=Nbitw(ele);
    x[Nbw].Setbit1(Nbit);
    cant++;
  }
 }
public void eliminar(int ele){
     int Nbw=Nbitwise(ele);
     int Nbit=Nbitw(ele);
     x[Nbw].Setbit0(Nbit);
     cant--;
}
private int Nbitwise(int pos){
    return((pos-1)/32);
}
private int Nbitw(int pos){
    return(((pos-1)%32)+1);
    
} 
public boolean pertenece(int ele){
int Nbw=Nbitwise(ele);
 int Nbit=Nbitw(ele);
return (x[Nbw].getbit(Nbit)==1);    
}  

//    @Override
    public String toString() {
        String s="conjunto [";
 int dim; 
 dim=cant;// Es necesario crear una variable en caso
          // contrario cant se modificaria y retornaria error
        for (int i = 1; i <=dim; i++) {
            
          if( pertenece(i)){
          s=s+"  "+i; //posicion
          }else{
            dim=dim+1;// cant incrementa si i no pertenece
                        // al conjunto, para mostrar todos los elementos
                        //del conjunto
          }
        }
        
    s=s+']';   
return s;
    }

    

}




