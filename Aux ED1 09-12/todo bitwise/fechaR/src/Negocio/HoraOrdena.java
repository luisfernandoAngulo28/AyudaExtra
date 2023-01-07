/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author MAISEL
 */
public class HoraOrdena {

    //int z[];//vector de enteros
     VectorbitG p;
     int n2;
  public HoraOrdena(int cantENT){
      p=new VectorbitG(cantENT,17);
      n2=0;
   }
   
    public void InsertarHoraOrdenado(int hora,int min,int seg,String mm){

       if((hora<12&&min<60&&seg<60)&&(mm.equals("PM")||mm.equals("AM"))){
        int valor=0;
        valor=valor|(hora<<13);
        valor=valor|(min<<7);
        valor=valor|(seg<<1);
       
        if(mm.equals("PM")){
              valor=valor|1; //recorremos para el bit de PM o AM 1 bit
        }
            int i=1;
             while ((i<=n2)&&(ConvertirHoraAseg2(i)<ConvertirHoraAseg1(hora, min, seg))) {
                        i++;
              }
              n2++;
              for (int j = n2; i<j ; j--) {
                    p.InsertarenZ(p.get(j-1), j);
              }
              p.InsertarenZ(valor, i);
       }
       else{
             System.out.println("Error:dato incorrecto");
       }

    }
//--------------------------------------------------------------------------------------------------//
    public int gethora(int valor)
    {
    return valor>>>13;

    }
//--------------------------------------------------------------------------------------------------//
     public int getmin(int valor)
    {
         valor=valor<<19;
         return valor>>>26;
    }
//--------------------------------------------------------------------------------------------------//
    public int getseg(int valor)
    {
    valor=valor<<25;
    return valor>>>26;
//--------------------------------------------------------------------------------------------------//
    }
    public String getmeridiano(int valor){
        valor=valor<<31;
        if(valor>>>31==1){
              return "PM";
        }else{
              return "AM";
        }

    }
//--------------------------------------------------------------------------------------------------//
     public int  ConvertirHoraAseg1(int hora,int min,int seg){//convierte la hora,minuto,segundo que
                                                                                                               //esta ingresando.
          return  hora*3600+min*60+seg;
    }
//--------------------------------------------------------------------------------------------------//
    public int ConvertirHoraAseg2(int pos){//convierte la hora,minuto,segundo que ya estaba insertado
       int HoraMinutoSegundo=p.get(pos);
       int coversionSeg=gethora(HoraMinutoSegundo)*3600+ getmin(HoraMinutoSegundo)*60+getseg(HoraMinutoSegundo);
             return coversionSeg;
    }
 

    public void  mostrar(){
 
        for(int i=1;i<=n2;i++)
        {
            int x=p.get(i);
             System.out.print( gethora(x)+":"+getmin(x)+":"+getseg(x)+" "+getmeridiano(x)+  "  ");
        }
         System.out.println();
    }
public static void main(String[]args){
      HoraOrdena h=new HoraOrdena(6);
      h.InsertarHoraOrdenado(1, 26, 4,"PM");
      h.InsertarHoraOrdenado(2, 3, 10,"PM");
      h.InsertarHoraOrdenado(1, 32, 10,"PM");
      h.InsertarHoraOrdenado(11, 3, 4,"AM");
      h.InsertarHoraOrdenado(5, 3, 4,"PM");
      h.mostrar();
      
     // System.out.println(h.ConvertirHoraAseg1(1, 1, 8));
   //   System.out.println(h.ConvertirHoraAseg2(3));

}

}



