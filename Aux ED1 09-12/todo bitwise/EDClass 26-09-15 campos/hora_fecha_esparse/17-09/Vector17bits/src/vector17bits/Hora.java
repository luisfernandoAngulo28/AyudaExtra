/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vector17bits;

public class Hora {
    Vector17bits v;
    int cant;
    public Hora(int cant){
        v=new Vector17bits(cant);
        this.cant=cant;
    }
    public void setHora(int pos, int hora, int min, int seg){
        hora= hora<<12;
        min=min<<6;
        hora=hora|min;
        hora=hora|seg;
        v.insertar(hora,pos);
    }
//    public String getHora(int pos){
//        int mask=(int)Math.pow(2,6)-1;
//        int hora=v.sacar(pos);
//        int seg=hora&mask;
//        mask=mask<<6;
//        int min=hora&mask;
//        min=min>>>6;
//        hora=hora>>>12;
//        String s=(String)(hora+min+seg);
//        return s;    
//    }
    public int getSeg(int pos){
        int e=v.sacar(pos);
        int mask=(int)Math.pow(2,6)-1;
        mask=e&mask;
        return mask;
    }
    public int getMin(int pos){
        int e=v.sacar(pos);
        int mask=(int)Math.pow(2,6)-1;
        mask=mask<<6;
        mask=e&mask;
        mask=mask>>>6;
        return mask;
    }
    public int getHora(int pos){
        int e=v.sacar(pos);
        int mask=e>>>12;
        return mask;
    }

    @Override
    public String toString() {
        String s="HORA =";
        for (int i = 1; i <=cant; i++) {
            s=s+" ["+getHora(i)+" : " +getMin(i)+" : "+getSeg(i)+"] ; ";
        }
        return s;
    }
    
public static void main(String[] args) {
      Hora h= new Hora(5);
      h.setHora(1, 22, 12, 45);
      h.setHora(2, 12, 38, 60);
      h.setHora(3, 8, 19, 51);
      h.setHora(4, 1, 32, 18);
      h.setHora(5, 8, 00, 59);
      
     
      System.out.println(h);
     h.setHora(3, 18, 29, 41);
     System.out.println(h);
  }
}
