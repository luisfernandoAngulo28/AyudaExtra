/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author MiguelAngel
 */
public class ADT_Catastro {
    Bitwise_Generico A;
    Bitwise_Generico B;
    Bitwise_Generico Superficie;
    Bitwise_Generico Servicios;
    int Cant;
    
    /*
    public ADT_Catastro(){
        A = new Bitwise_Generico(0,(byte) 0);
        B = new Bitwise_Generico(0,(byte) 0);
        C = new Bitwise_Generico(0,(byte) 0);
        D = new Bitwise_Generico(0,(byte) 0);           
    }
    */
    
    public ADT_Catastro(){
        A = new Bitwise_Generico(5,(byte) 14);
        B = new Bitwise_Generico(5,(byte) 11);
        Superficie = new Bitwise_Generico(5,(byte) 9);
        Servicios = new Bitwise_Generico(5,(byte) 7);
        Cant = 0;
    }
    
    public void insertar(int Num_C, int UV, int manzana, int lote, int superficie,
            int Alumbrado, int Alcantarillado, int pavimento, 
            int aseoUrb, int luz, int telef, int agua){
        int pos = Cant +1;
        int X = Num_C;
        X = X <<7; X = X | UV;
        A.insetar(X, pos);
        
        X = manzana; 
        X = X << 6; X = X | lote;
        B.insetar(X, pos);
        
        Superficie.insetar(superficie, pos);
        
        X = Alumbrado;
        X = X << 1; X = X |Alcantarillado;
        X = X << 1; X = X | pavimento;
        X = X << 1; X = X |aseoUrb;
        X = X << 1; X = X |luz;
        X = X << 1; X = X |telef;
        X = X << 1; X = X |agua;
        
        Servicios.insetar(X, pos);
        
        Cant ++;
    }
    public int getCant(){
        return Cant;
    }
    
    public int AUV(int pos){
        int X =  A.getDato(pos);
        int uv = (int)Math.pow(2, 7)-1;
        uv = uv & X;
        
        return uv;
    }
    
    public int ANum_C(int pos){
        int X =  A.getDato(pos);
        int num_c = (int)Math.pow(2, 7)-1;
        num_c = num_c <<7;
        num_c = num_c & X;
        num_c = num_c >>>7;
        return num_c;
    }
    
    public int BLote(int pos){
        int X = B.getDato(pos);
        int Lote = (int)Math.pow(2, 6)-1;
        Lote = Lote & X;
        return Lote;
    }
    
    public int BManzana(int pos){
        int X = B.getDato(pos);
        int manzana = (int)Math.pow(2, 5)-1;
        X = X >>> 6;
        manzana = X & manzana;
        return manzana;        
    }
    
    public String alum(int pos){
        int alumbrado = Servicios.getDato(pos);
        alumbrado = alumbrado >>> 6;
        if (alumbrado == 1) {
            return ("true");
        }
        
        return ("false");
    }
    
    public String alcantari(int pos){
        int X = Servicios.getDato(pos);
        int Y = 1; Y = Y << 5; Y = Y & X;
        Y  = Y >>> 5;
        if (Y == 1) {
            return ("true");
        }
        return ("false");
    }
    
    public String paviment(int pos){
        int X = Servicios.getDato(pos);
        int Y = 1; Y = Y << 4; Y = Y & X;
        Y  = Y >>> 4;
        if (Y == 1) {
            return ("true");
        }
        return ("false");
    }
    
    public String aseourb(int pos){
        int X = Servicios.getDato(pos);
        int Y = 1; Y = Y << 3; Y = Y & X;
        Y  = Y >>> 3;
        if (Y == 1) {
            return ("true");
        }
        return ("false");
    }
    
    public String luz(int pos){
        int X = Servicios.getDato(pos);
        int Y = 1; Y = Y << 2; Y = Y & X;
        Y  = Y >>> 2;
        if (Y == 1) {
            return ("true");
        }
        return ("false");
    }
    
    public String telefono(int pos){
        int X = Servicios.getDato(pos);
        int Y = 1; Y = Y << 1; Y = Y & X;
        Y  = Y >>> 1;
        if (Y == 1) {
            return ("true");
        }
        return ("false");
    }
    
    public String agua(int pos){
        int X = Servicios.getDato(pos);
        int Y = 1; Y = Y & X;
        if (Y == 1) {
            return ("true");
        }
        return ("false");
    }
    
    public String servici(int pos){
        String serv = "";
        serv = " Alumbrado: " + alum(pos)+ " alcantarllado: "+ alcantari(pos)+
                " Pavimento: "+ paviment(pos)+ " Aseo Urbano: "+ aseourb(pos)+
                " Luz: "+ luz(pos)+ " Telf: "+ telefono(pos)+
                " Agua: "+ agua(pos);
        
        return serv;
    }
    public String toString(int pos) {
        String catastro = "";
        catastro = "Nº catastral: "+ ANum_C(pos)+ " U.V. : "+ AUV(pos)+
                " Manzana: " + BManzana(pos) + " Lote: "+ BLote(pos)+
                " Superficie: "+ Superficie.getDato(pos);
       catastro = catastro + servici(pos);
        return catastro;
    }
    
}
    
