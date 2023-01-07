
package COLA.cinco.ColaPrioridad.Paquete.Negocio;

/**
 * Ayudantia 1/2016 Aux. Eddy Escalante
 */
public class ColaPrioridad {
    ObjPrioridad Q[];
    int Frente;
    int Atraz;
    int Dimencion;
public ColaPrioridad(int cant){
    Q=new ObjPrioridad[cant];
    Frente=-1;
    Atraz=-1;
    Dimencion=cant;
    for(int i=0;i<cant;i++){
        Q[i]=new ObjPrioridad();
    }
}
private boolean Llena(){
    int Fren=Frente-1;
    if(Fren==-1){
        Fren=Q.length-1;
    }
    return (Fren==Atraz);
}
public void Meter(String proc,byte priori){
    if(Llena()){
        System.out.println("ColaPrioridad::Meter:Error la cola esta llena");
    }
    else{
        if(priori>0 && priori<=10 && proc!=""){
            if(Vacio()){
                Frente=Atraz=0;
                Q[Atraz].SetData(proc, priori);
            }
            else{
                Atraz=(Atraz+1)%Q.length;
                Q[Atraz].SetData(proc, priori);
            }
        }
        else{
            System.out.println("ColaPrioridad::Meter:Error algun parametro es invalido");
        }
    }
}
private boolean Vacio(){
    if(Frente==-1 && Atraz==-1){
        return true;
    }
    else{
        return false;
    }
}
private byte ObtPrioMayor(){
    int Fren=GetFrente()-1;
    byte total=1;                         //La prioridad esta entre 1-10
    while(Fren!=GetAtraz()-1){
        if(total<Q[Fren].GetPrioridad()){ //Saca la prioridad mayor de toda la cola
            total=Q[Fren].GetPrioridad();
        }
        Fren=(Fren+1)%Q.length;
    }
    if(total<Q[Fren].GetPrioridad()){
        total=Q[Fren].GetPrioridad();
    }
    return total;
}
public String Sacar(){
    if(Vacio()){
        System.out.println("ColaPrioridad::Sacar:Error la cola esta vacia");
        return null;
    }
    else{
        if(Frente==Atraz){
        //if(Frente==0 && Atraz==0){
            String total=Q[Frente].GetData();
            Frente=Atraz=-1;
            return total;
        }
        else{
        byte Mayor=ObtPrioMayor();
        while(Q[Frente].Prioridad!=Mayor){
           String proceso1=Q[Frente].GetProceso();
           byte priori1=Q[Frente].GetPrioridad();
           Meter(proceso1, priori1);
           Frente=(Frente+1)%Q.length;
        }
        String total=Q[Frente].GetData();
        Frente=(Frente+1)%Q.length;
        return total;
        }
    }
}
public String GetValor(int posi){
    return Q[posi-1].GetData();
}
public int GetFrente(){
    return Frente+1;
}
public int GetAtraz(){
    return Atraz+1;
}
public int Dimencion(){
    return Dimencion;
}
}
