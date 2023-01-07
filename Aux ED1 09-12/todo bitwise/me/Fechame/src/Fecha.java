
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iniedu
 */
public class Fecha {
    VectorBitGenerico v;
    int cant;
    public Fecha(){
        v=new VectorBitGenerico(15, 100);
        cant=0;    
    }
    public void insertarFecha(int dia,int mes, int año){
        int valor=0;
        valor=valor|dia;
        valor=valor<<4;
        valor=valor|mes;
        valor=valor<<6;
        int a=año-1990;
        valor=valor|a;
        cant++;
                System.out.println(valor);

        v.Insertar(valor, cant);   
    }
      public int getDia(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>>10;
        int mask=(int) Math.pow(2, 5)-1;
        mask=mask&aux;
        
        return mask;
    }
    public int getMes(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>>4;
        int mask=(int) Math.pow(2, 4)-1;
        mask=mask&aux;
        return mask;
    }
    public int getAño(int pos){
        int aux=v.Sacar(pos);
//        aux=aux>>>28;
        int mask=(int) Math.pow(2, 6)-1;
        mask=mask&aux;
        return mask+1990;
    }

    @Override
    public String toString() {
        String s="Fecha:";
        for(int i=1;i<=cant;i++){
            s=s+"\n"+"Fecha: "+getDia(i)+"/"+getMes(i)+"/"+getAño(i);
        }
        return s;
    }
    
}
