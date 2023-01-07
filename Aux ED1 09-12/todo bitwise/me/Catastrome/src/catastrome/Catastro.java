/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catastrome;

/**
 *
 * @author iniedu
 */
public class Catastro {
    VectorBitGenerico v;
    int cant;
    public Catastro(){
        v=new VectorBitGenerico(31, 10);
        cant=0;
    }
    public void inserCatastro(int NroCatastro,int uv,int mz,int lote,int superficie,String alcantarrillado,String alumbrado,String pavimento){
        int valor=0;
        valor=valor|NroCatastro;
        valor=valor<<6;
        valor=valor|uv;
        valor=valor<<4;
        valor=valor|mz;
        valor=valor<<5;
        valor=valor|lote;
        valor=valor<<8;
        valor=valor|superficie;
        valor=valor<<1;
        int alc=0;
        if(alcantarrillado.toUpperCase().equals("SI"))
            alc=0;
        else
            if(alcantarrillado.toUpperCase().equals("NO"))
            alc=1;
             else 
                System.out.println("Error::Ingrese SI o NO en alcantarrillado");
        valor=valor|alc;
        valor=valor<<1;
        int alu=0;
        if(alumbrado.toUpperCase().equals("SI"))
            alu=0;
        else
            if(alumbrado.toUpperCase().equals("NO"))
            alu=1;
            else
                System.out.println("Error::Ingrese SI o NO en alumbrado");
        valor=valor|alu;
        valor=valor<<1;
        int pav=0;
        if(pavimento.toUpperCase().equals("SI"))
            pav=0;
        else
            if(pavimento.toUpperCase().equals("NO"))
            pav=1;
            else
                System.out.println("Error::Ingrese SI o NO en pavimento");
        valor=valor|pav;
        cant++;
       
        v.Insertar(valor, cant);
    }
    public int getNroCatastro(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>>26;
        int mask=(int) Math.pow(2, 5)-1;
        mask=mask&aux;
        
        return mask;
    }
    public int GetUv(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>>20;
        int mask=(int) Math.pow(2, 6)-1;
        mask=mask&aux;
        return mask;
    }
    public int GetMz(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>>16;
        int mask=(int) Math.pow(2, 4)-1;
        mask=mask&aux;
        return mask;
    }
    public int getLote(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>>11;
        int mask=(int) Math.pow(2, 5)-1;
        mask=mask&aux;
        return mask;
    }
    public int getsuperficie(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>>3;
        int mask=(int) Math.pow(2, 8)-1;
        mask=mask&aux;
        return mask;
    }
    public String getAlcantarrillado(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>>2;
        int mask=(int) Math.pow(2, 1)-1;  
        mask=mask&aux;   
        if(mask==0)
            return "si";
        else if(mask==1)
            return "no";
        else 
      
            return "Error::Ingrese SI o NO";
        
    }
    public String getAlumbrado(int pos){
        int aux=v.Sacar(pos);
        aux=aux>>>1;
        int mask=(int) Math.pow(2, 1)-1;
        mask=mask&aux;
       if(mask==0)
            return "si";
        else if(mask==1)
            return "no";
        else 
      
            return "Error::Ingrese SI o NO";
    }
    public String getpavimento(int pos){
        int aux=v.Sacar(pos);
        int mask=(int) Math.pow(2, 1)-1;
        mask=mask&aux;
        if(mask==0)
            return "si";
        else if(mask==1)
            return "no";
        else 
      
            return "Error::Ingrese SI o NO";
    }

    @Override
    public String toString() {
        String s="Catastro: ";
        for(int i=1;i<=cant;i++){
            s=s+"\n"+"NroCatastral:"+getNroCatastro(i)
                    +"\n"+"Uv:"+GetUv(i)
                    +"\n"+"Mz:"+GetMz(i)
                    +"\n"+"Lote:"+getLote(i)
                    +"\n"+"Superficie:"+getsuperficie(i)
                    +"\n"+"Alcantarillado:"+getAlcantarrillado(i)
                    +"\n"+"Alumbrado:"+getAlumbrado(i)
                    +"\n"+"Pavimento:"+getpavimento(i);
        }
        return s;
    }
    
}
