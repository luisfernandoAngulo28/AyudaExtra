/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

/**
 *
 * @author usuario
 */
public class Fechita {
             Vector13bit V;
             int cant;
   
    public Fechita(int cant){
    V= new Vector13bit(cant);
    this.cant=cant;
        
    };
    public void SetFechita(int pos,int dia ,int mes, int a){ 
        if((a>=2000)&&(a<=2015)){
            a=a-2000;//max es 15 años que luego se sumara 2000
          
        dia=dia<<8;
       
        mes=mes<<4;
        dia=dia|mes;
        dia=dia|a;
//        a=2000+a;
        V.insertar(pos, dia);
          
            
        }else{
        System.out.println("introduzca dentro del rango 2000 a 2015"); 
        //return ;
        }
        
    }
    public int get_a(int pos){
        int e=V.sacar(pos);
        int mask=(int) Math.pow(2, 4)-1;
        mask=e&mask;
        
        return (2000+mask); 
        //2008
    }
 public int get_mes(int pos){//12 meses
        int e=V.sacar(pos);
        int mask=(int) Math.pow(2, 4)-1;
        mask=mask<<4;//no es por eso13-4-4
        mask=e&mask;
        mask=mask>>>4;
        return mask; 
    }
 public int getDia(int pos){//31 dias
     int e=V.sacar(pos);
     int mask=e>>>8; //13 bits-5=8 o 4+4=8
     return mask;
     
 }
    @Override
    public String toString() {
       String s="Fecha ";
        for (int i = 1; i <=cant; i++) {
            s=s+"["+getDia(i)+"/"+get_mes(i)+"/"+get_a(i)+"];";
            
        }
        return s;

           
       }
    }
    
    
    

