
package COLA.cinco.ColaPrioridad.Paquete.Negocio;

/**
 * Ayudantia 1/2016 Aux. Eddy Escalante
 */

public class ObjPrioridad {
    String Proceso;
    byte Prioridad;
public ObjPrioridad(){
    Proceso="";
    Prioridad=0;
}
public void SetData(String proc,byte priori){
    if(priori>0 && priori<=10 && proc!=""){
        Proceso=proc;
        Prioridad=priori;
    }
    else{
        System.out.println("ObjPrioridad::SetData:Error algun parametro es invalido");
    }
}
public byte GetPrioridad(){
    return Prioridad;
}
public String GetProceso(){
    return Proceso;
}
public String GetData(){
    return GetProceso()+"/"+GetPrioridad();
}
}
