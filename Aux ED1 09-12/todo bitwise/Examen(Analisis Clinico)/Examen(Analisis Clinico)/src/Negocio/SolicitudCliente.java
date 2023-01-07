/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Administrador
 */
public class SolicitudCliente {
    int x;
    public SolicitudCliente(){
        x=0;
    }
    public SolicitudCliente(int Codigo,int edad,float Estatura,int Peso)
    {   if ((Codigo>=1000)&&(Codigo<=2000)){
        Codigo=Codigo-1000;
        x=Codigo;
    }   
    else{
        System.out.println("porfavor ingrese '1000' y '2000' para el codigo ");
    }
    Estatura=Estatura*100;
    if ((Estatura>=100)&&(Estatura<=250)){
        x<<=8;
        Estatura=Estatura-100;
        x=x|((int)Estatura);
    }   
    else System.out.println("porfavor ingrese '1 metro' o '2,5 metros' para la Estatura ");
    if ((edad>=10)&&(edad<=90)){
        x<<=7;
       edad=edad-10;
        x=x|edad;
    }   
    else System.out.println("Lo siento pero solo es para personas de 10 a 90 años ");
      if ((Peso>=30)&&(Peso<=110)){
        Peso=Peso-30;
          x<<=7;
        x=x|Peso;
    }   
    else System.out.println("Porfavor ingrese un peso entre 30 y 110 ");  
}
      public int GetPeso(){
       int aux=x;
     
       aux=aux&127;
       return (aux+30);    
   } 
    public int GetEdad(){
       int aux=x;
     aux>>>=7;
       aux=aux&127;
       return (aux+10);    
   } 
    
    public float GetEstatura(){
       int aux=x;
     aux>>>=14;
       aux=aux&255;
       aux=aux+100;
       float Y=(float)(((float)(aux))/100);
       return Y;    
   } 
    
    public int GetCodigo(){
       int aux=x;
     aux>>>=22;
       aux=aux&1023;
       return (aux+1000);    
   }
 
public int GetEnteroX(){
    return this.x;
}

      public void SetEntero(int E){
          this.x=E;
      }
    @Override
    public String toString() {
      String s="";
        return s=s+"Codigo:"+ GetCodigo()  +" Edad:"+GetEdad() +" Estatura:"+GetEstatura() +" Peso:"+GetPeso();
    }

}
