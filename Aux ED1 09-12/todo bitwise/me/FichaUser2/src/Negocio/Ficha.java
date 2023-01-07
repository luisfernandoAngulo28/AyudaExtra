package Negocio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iniedu
 */
public class Ficha {
    VectorBitGenerico v;
    int cant;
    public Ficha(){
        v=new VectorBitGenerico(28, 100);
        cant=0;
    }
    public void InsFicha(String tipo,int numero,char user,int hora,int minuto, int segundo){
        int valor=0;
        int t=-1;
        if(tipo.toUpperCase().equals("RN"))
           t=0;
        else
            if(tipo.toUpperCase().equals("CJ"))
                t=1;
            else
                if(tipo.toUpperCase().equals("PF"))
                    t=2;
        valor=valor|t;
        valor=valor<<7;
        valor=valor|numero;
        valor=valor<<2;
        int u=-1;
        if(user=='N')
            u=0;
        else
            if(user=='3')
                u=1;
            else
                if(user=='D')
                    u=2;
        valor=valor|u;
        valor=valor<<5;
        valor=valor|hora;
        valor=valor<<6;
        valor=valor|minuto;
        valor=valor<<6;
        valor=valor|segundo;
        cant++;
        v.Insertar(valor, cant);
    }
    public String getTipo(int pos){
        int aux=v.Sacar(pos);
        int mask=(int) Math.pow(2, 2)-1;
        aux=aux>>>26;
        mask=mask&aux;
        if(mask==0){
            return "Renta"; 
        }else
            if(mask==1)
                return "Caja";
            else
                if(mask==2)
                    return "Plataforma";
                else
                    return "Error::Ingrese RN - CJ - PF";
    }
    public int getNum(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>19;
        int mask=(int) Math.pow(2, 7)-1;
        mask=mask&aux;
        return mask;
    }
    public String getUser(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>>17;
        int mask=(int) Math.pow(2, 2)-1;
        mask=mask&aux;
        if(mask==0)
            return "Normal";
        else 
            if(mask==1)
                return "3ra edad";
            else
                if(mask==2)
                    return "discapacitado";
            else
                    return "error:: ingrese N - 3 - D";
    }
    public int getHora(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>>12;
        int mask=(int) Math.pow(2, 5)-1;
        mask=mask&aux;
        return mask;
    }
    public int getMinuto(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>>6;
        int mask=(int) Math.pow(2, 6)-1;
        mask=mask&aux;
        return mask;
    }
    public int getSegundo(int pos){
        int aux=v.Sacar(pos);
        int mask=(int) Math.pow(2, 6)-1;
        mask=mask&aux;
        return mask;
    }
    @Override
    public String toString() {
        String s="Ficha;";
        for(int i=1;i<=cant;i++){
            s=s+"\n"+"Tipo: "+getTipo(i)
                    +"\n"+"Numero: "+getNum(i)
                    +"\n"+"Usuario: "+getUser(i)
                    +"\n"+"Hora: "+getHora(i)+":"+getMinuto(i)+":"+getSegundo(i);
        }
        return s;
    }
    
}
