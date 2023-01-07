/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Cola.dos.Paquete.Negocio;

/**
 * Ayudantia 1/2016 Aux. Eddy Escalante
 */
public class Cola {
    int Q[];
    int Dim;
    int CantElem;
public Cola(int cant){
    Q=new int[cant];
    Dim=-1;
    CantElem=cant;
}
private boolean Lleno(){
    return (Dim==Q.length-1);
}
public void Meter(int elem){
    if(Lleno()){
        System.out.println("Cola::Meter:Error la cola esta llena");
    }
    else{
        Dim++;
        Q[Dim]=elem;
    }
}
private boolean Vacio(){
    return (Dim==-1);
}
public int Sacar(){
    if(Vacio()){
        System.out.println("Cola::Sacar:Error la cola esta vacia");
        return 0;
    }
    else{
        int x=Q[0];
        for(int i=0;i<Dim;i++){
            Q[i]=Q[i+1];
        }
        Dim--;
        return x;
    }
}
public int GetValor(int posi){
    return Q[posi-1];
}
public int Dim(){
    return Dim+1;
}
public int Dimencion(){
    return (CantElem);
}

}
