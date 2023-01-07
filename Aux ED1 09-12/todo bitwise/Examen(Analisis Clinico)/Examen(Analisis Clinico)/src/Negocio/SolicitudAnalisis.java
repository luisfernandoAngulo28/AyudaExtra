/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntArrayData;

/**
 *
 * @author Lab-214-21
 */
public class SolicitudAnalisis { 
    int n;
//    int x;
    public SolicitudAnalisis(){
        n=0;
//        x=0;
    }
    public SolicitudAnalisis(int orina,int sangre,int radiografia,int ecografia,int Urocultivo,int Tomografia,int otro,int PresionMax,int PresionMin
              ){
        
        
        if ((orina>=0)&&(orina<=1)){
            n=orina;
        }else System.out.println("porfavor ingrese '0' o '1' para la orina ");
        if ((sangre>=0)&(sangre<=1)){
            n<<=1;
            
            n=n|sangre;
        }else System.out.println("porfavor ingrese '0' o '1' para la sangre ");
        if ((radiografia>=0)&&(radiografia<=1)){
            n<<=1;
            
            n=n|radiografia;
        }else System.out.println("porfavor ingrese '0' o '1' para la Radiografia ");
        if ((ecografia>=0)&&(ecografia<=1)){
            n<<=1;
            
            n=n|ecografia;
        }else System.out.println("porfavor ingrese '0' o '1' para la Ecografia ");
         if ((Urocultivo>=0)&&(Urocultivo<=1)){
            n<<=1;
            
            n=n|Urocultivo;
        }else System.out.println("porfavor ingrese '0' o '1' para el Urocultivo");
         if ((Tomografia>=0)&&(Tomografia<=1)){
            n<<=1;
            
            n=n|Tomografia;
        }else System.out.println("porfavor ingrese '0' o '1' para la Tomografia");
              if ((otro>=0)&&(otro<=1)){
            n<<=1;           
            n=n|otro;
        }else System.out.println("porfavor ingrese '0' o '1' para Otro ");
              
       if ((PresionMax>=90)&&(PresionMax<=140)){
            n<<=6;
            PresionMax=PresionMax-90;
            n=n|PresionMax;
        }else System.out.println("porfavor ingrese entre '90' o '140' para la Presion Maxima ");
        if ((PresionMin>=30)&&(PresionMin<=89)){
            n<<=6;
            PresionMin=PresionMin-30;
            n=n|PresionMin;
        }else System.out.println("porfavor ingrese '0' o '1' para la Presion Minimo ");
//          if ((Codigo>=1000)&&(Codigo<=2000)){
//        Codigo=Codigo-1000;
//        x=Codigo;
//    }   
//    else{
//        System.out.println("porfavor ingrese '1000' y '2000' para el codigo ");
//    }
//    Estatura=Estatura*100;
//    if ((Estatura>=100)&&(Estatura<=250)){
//        x<<=8;
//        Estatura=Estatura-100;
//        x=x|((int)Estatura);
//    }   
//    else System.out.println("porfavor ingrese '1 metro' o '2,5 metros' para la Estatura ");
//    if ((edad>=10)&&(edad<=90)){
//        x<<=7;
//       edad=edad-10;
//        x=x|edad;
//    }   
//    else System.out.println("Lo siento pero solo es para personas de 10 a 90 años ");
//      if ((Peso>=30)&&(Peso<=110)){
//        Peso=Peso-30;
//          x<<=7;
//        x=x|Peso;
//    }   
//    else System.out.println("Porfavor ingrese un peso entre 30 y 110 ");  
   
        ////// Luegp colocamoj los valores en el VectorBitGenerico
   
}
   public int GetPresionMin(){
       int aux=n;
       aux=aux&63;
       return (aux+30);
   }
   
   public int GetPresionMax(){
       int aux=n;
       aux>>>=6;
       aux=aux&63;
       return (aux+90);
   }
   public int getOtro(){
       int aux=n;
       aux>>>=12;
       aux=aux&1;
       return aux;    
   }
 public int getTomografia(){
       int aux=n;
       aux>>>=13;
       aux=aux&1;
       return aux;    
   }
  public int getUrocultivo(){
       int aux=n;
       aux>>>=14;
       aux=aux&1;
       return aux;    
   }
   public int getEcografia(){
       int aux=n;
       aux>>>=15;
       aux=aux&1;
       return aux;    
   }
    public int getRadiografia(){
       int aux=n;
       aux>>>=16;
       aux=aux&1;
       return aux;    
   }
     public int getSangre(){
       int aux=n;
       aux>>>=17;
       aux=aux&1;
       return aux;    
   }
      public int getOrina(){
       int aux=n;
       aux>>>=18;
       aux=aux&1;
       return aux;    
   }
//    public int GetPeso(){
//       int aux=x;
//     
//       aux=aux&127;
//       return aux;    
//   } 
//    public int GetEdad(){
//       int aux=x;
//     aux>>>=7;
//       aux=aux&127;
//       return aux;    
//   } 
//    
//    public float GetEstatura(){
//       int aux=x;
//     aux>>>=14;
//       aux=aux&255;
//       aux=aux+100;
//       float Y=(float)(((float)(aux))/100);
//       return Y;    
//   } 
//    
//    public int GetCodigo(){
//       int aux=x;
//     aux>>>=22;
//       aux=aux&1023;
//       return (aux+1000);    
//   }
//    
public int GetEnteroN(){
    return this.n;
}
//public int GetEnteroX(){
//    return this.x;
//}
      public void SetEntero(int E){
          this.n=E;
      }
    @Override
    public String toString() {
        String S="";
        S=S+" Presion Minima:"+GetPresionMin() +" Presion Maxima:"+GetPresionMax()+'\12'+"Analisis:"+'\12'+" Orina:"+getOrina()
                +" Sangre:"+getSangre()+" Radiografia:"+getRadiografia()+" Ecografia:"+ getEcografia()+" Urocultivo:"+ getUrocultivo()+" Tomografia:"+getTomografia() +" Otros:"+getOtro()+'\12';        
     

         return S;
    
    }           

    }



