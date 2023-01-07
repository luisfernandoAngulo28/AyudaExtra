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
        v=new VectorBitGenerico(11, 100);
        
    }
    public void Inserficha(String tipo,int numero,char user){
        int valor=0;
        int s=-1;
        if(tipo.toUpperCase().equals("RN"))
            s=0;
        else
            if(tipo.toUpperCase().equals("CJ"))
                s=1;
            else
                if(tipo.toUpperCase().equals("PF"))
                    s=2;
        valor=valor|s;
        valor=valor<<7;
        if((numero>=1)&&(numero<=100)){
        valor=valor|numero;
        }else{
            System.out.println("Ingrese de 1 a 100 en numero");
        }
        valor=valor<<2;
        int u=-1;
        
            if(user == 'N')
            u=0;
     
            if(user == '3')
                u=1;
            else
                if(user == 'D')
                    u=2;
        
        valor=valor|u;
       cant++;
        v.Insertar(valor, cant);
    }
    public String gettipo(int pos){
       int aux=v.Sacar(pos);
       int mask=(int) Math.pow(2, 2)-1;
        aux=aux>>9;
        mask=mask&aux;
        if(mask==0)
            return "Renta";
        else
            if(mask==1)
                return "Caja";
           else
                if(mask==2)
                    return "Plataforma";
        return "Error:: por favor ingrese RN para renta - CJ para caja - PF para plataforma";
    }
    public int getnumero(int pos){
        int aux=v.Sacar(pos);
        int mask=(int) Math.pow(2, 7)-1;
        aux=aux>>2;
        mask=aux&mask;
        return mask;
    }
    public String getuser(int pos){
        int aux=v.Sacar(pos);
        int mask=(int) Math.pow(2, 2)-1;
        mask=aux&mask;
        if(mask==0)
            return "Normal";
        else
            if(mask==1)
                return "3ra edad";
            else
                if(mask==2)
                    return "discapacitado";
        return "Error:: por favor ingrese N para Usuario Normal - 3 para 3Edad - D para discapacitado" ;
    }
    
    @Override
    public String toString() {
         String s="Ficha ";
        for (int i = 1; i <=cant; i++) {
            s=s+"\n"+"Tipo:"+gettipo(i)+"\n"
                    +"Numero:"+getnumero(i)+"\n"
                    +"User:"+getuser(i);
        }
        return s;
    }
}
