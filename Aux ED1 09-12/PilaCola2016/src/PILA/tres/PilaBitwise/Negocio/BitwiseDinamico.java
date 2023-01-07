
package PILA.tres.PilaBitwise.Negocio;


/**
 * Ayudantia 1/2016 Aux. Eddy Escalante
 */

public class BitwiseDinamico {
        int v[];
        int CantElem;
        int CantBits;
        int Inicio;
        int Fin;
public BitwiseDinamico(int Cajas,int initiation,int end){
    int x=(end-initiation)+1;    //saca el valor desde 0 hasta x
    Inicio=initiation;
    Fin=end;
    int bits=1;
    while(Math.pow(2,bits)<=x){ //esta bien, no dudes que esta bien
        bits++;
    }
    CantBits=bits;
    int dimension=(Cajas*CantBits)/32;
    if((Cajas*CantBits)%32==0){
        v=new int[dimension];
    }
    else{
        dimension++;
        v=new int[dimension];
    }
    CantElem=Cajas;
    for(int i=0;i<dimension;i++){
        v[i]=0;
    }
}
private int PosicionVector(int posi){
    return ((posi-1)*CantBits)/32;
}
private int PosicionBits(int posi){
    return (((posi-1)*CantBits)%32)+1;
}
public void Insertar(int valor,int posi){
    if(posi>0 && posi<=CantElem&&valor>=Inicio&&valor<=Fin){
        int x=PosicionVector(posi);
        int y=PosicionBits(posi);
        int w=(int)(Math.pow(2,CantBits))-1;
        valor=valor-Inicio+1;
        int valor1=valor;
        w=w<<y-1;
        w=~w;
        v[x]=v[x]&w;
        valor=valor<<y-1;
        v[x]=v[x]|valor;
        int z=(y-1)+CantBits-32;
        if(z>0){
            int q=(int)Math.pow(2,z)-1;
            v[x+1]=v[x+1]&(~q);
            valor1=valor1>>>(CantBits-z);
            v[x+1]=v[x+1]|valor1;
        }
    }
    else{
        System.out.println("BitwiseDinamico::Insertar:Error algun parametro es invalido");
    }
}

public int Obtener(int posi){
    int z=0;
    if(posi<=CantElem && posi>0){
        int x=PosicionVector(posi);
        int y=PosicionBits(posi);
        z=v[x];
        z=z>>>y-1;
        int w=(int)Math.pow(2,CantBits)-1;
        z=z&w;
        int f=(y-1)+CantBits-32;
        if(f>0){
            int m=v[x+1];
            m=m<<(CantBits-f);
            m=m&w;
            z=z|m;
        }
        if(z==0){
            return 0;
        }
        else{
            return z+Inicio-1;
        }
    }
    else{
        System.out.println("BitwiseDinamico:Error algun parametro es invalido");
        return 0;
    }
     
}
}
