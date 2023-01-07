/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete.Negocio;



/**
 *
 * @author itachi
 */
public class PilaBits {
    int v[];
    int inicio;
    int fin;
    int Dimencion;
    int DimencionBits;
    int CantBitsPrioridad;
    int CantBitsValor;

public PilaBits(int Cajas,int initiation,int end){
    int x=(end-initiation)+1;
    inicio=initiation;//atributo
    fin=end;//atributo
    CantBitsValor=CantBitsPrioridad=1;
    while(Math.pow(2,CantBitsValor)<=x){
        CantBitsValor++;//atributo
    }
    while(Math.pow(2,CantBitsPrioridad)<=10){
        CantBitsPrioridad++;//atributo
    }
    int TotalBits=CantBitsPrioridad+CantBitsValor;
    DimencionBits=Cajas;    //atributo
    Dimencion=(Cajas*TotalBits)/32;
    if((Cajas*TotalBits)%32==0){
        v=new int[Dimencion];
    }
    else{                            //atributo dimenscion esta dentro del if
        Dimencion++;
        v=new int[Dimencion];
    }
    for(int i=0;i<Dimencion;i++){
        v[i]=0;
    }
}
private int PosicionVector(int posi){
    return ((posi-1)*(CantBitsPrioridad+CantBitsValor))/32;//examinar las ultimas casillas
}
private int PosicionBit(int posi){
    return (((posi-1)*(CantBitsPrioridad+CantBitsValor))%32)+1;
}
public void InsertarValor(int posi,int valor,int priori){
    if(posi>0 && posi<=DimencionBits && valor>=inicio && valor<=fin && priori>0 && priori<=10){
        int x=PosicionVector(posi);
        int y=PosicionBit(posi);
        int w=(int)Math.pow(2,(CantBitsPrioridad+CantBitsValor))-1;
        valor=valor-inicio+1;    //reducir valor pa que entre
        valor=valor<<CantBitsPrioridad;
        int ValorSegmento=valor|priori;
        int ValorSegmento1=ValorSegmento;
        w=w<<y-1;
        v[x]=v[x]&(~w);
        ValorSegmento=ValorSegmento<<y-1;
        v[x]=v[x]|ValorSegmento;
        int overflow=(y-1)+((CantBitsPrioridad+CantBitsValor)-32);
        if(overflow>0){
            int BitsFaltantes=(int)(Math.pow(2,overflow))-1;
            v[x+1]=v[x+1]&(~BitsFaltantes);
            ValorSegmento1=ValorSegmento1>>>((CantBitsPrioridad+CantBitsValor)-overflow);
            v[x+1]=v[x+1]|ValorSegmento1;
        }
    }
    else{
        System.out.println("PilaBits::InsertarValor:Error algun parametro es invalido");
    }
}
public int Valor(int posi){
    if(posi>0 && posi<=DimencionBits){
        int x=PosicionVector(posi);
        int y=PosicionBit(posi);
        int valor=v[x];
        valor=valor>>>y-1;
        int w=(int)(Math.pow(2,(CantBitsPrioridad+CantBitsValor)))-1;
        valor=valor&w;
        int overflow=(y-1)+((CantBitsPrioridad+CantBitsValor)-32);//ojo sale mayor
        if(overflow>0){
            int BitsFaltan=v[x+1];
            BitsFaltan=BitsFaltan<<((CantBitsPrioridad+CantBitsValor)-overflow);
            BitsFaltan=BitsFaltan&w;
            valor=valor|BitsFaltan;
            valor=valor>>>(CantBitsPrioridad);
        }
        else{
            valor=valor>>>(CantBitsPrioridad); 
        }
        if(valor==0){
            return valor;
        }
        else{
            return valor+inicio-1;
        }
    }
    else{
        System.out.println("PilaBits::Valor:Error la posicion esta fuera de rango");
        return 0;
    }
}
public int Prioridad(int posi){
    if(posi>0 && posi<=DimencionBits){
        int x=PosicionVector(posi);
        int y=PosicionBit(posi);
        int valor=v[x];
        valor=valor>>>y-1;
        int w=(int)(Math.pow(2,(CantBitsPrioridad+CantBitsValor)))-1;
        valor=valor&w;
        int overflow=(y-1)+((CantBitsPrioridad+CantBitsValor)-32);
        int SoloBitPrioridad=(int)(Math.pow(2,CantBitsPrioridad))-1;
        if(overflow>0){
            int BitsFaltan=v[x+1];
            BitsFaltan=BitsFaltan<<((CantBitsPrioridad+CantBitsValor)-overflow);
            BitsFaltan=BitsFaltan&w;
            valor=valor|BitsFaltan;
            valor=valor&SoloBitPrioridad;
            return valor;
        }
        else{
            valor=valor&SoloBitPrioridad;
            return valor;
        }
    }
    else{
        System.out.println("PilaBits::Valor:Error la posicion esta fuera de rango");
        return 0;
    }
}
public int Dimencion(){
    return DimencionBits;
}
}
