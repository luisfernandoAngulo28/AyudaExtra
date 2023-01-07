/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import negocio.Bitwise_Generico;
import negocio.Nombre;

/**
 *
 * @author MiguelAngel
 */
public class Agenda {
    Nombre nombre[];
    Bitwise_Generico Numero;
    int Cant;
    
    
    public Agenda(){
        Numero = new Bitwise_Generico(20, (byte)29);
        Cant = 0;
        nombre  = new Nombre[20];
        for (int i = 0; i < 20; i++) {
            nombre[i]=new Nombre();
        }
    }
    
    public void insert(String nomb,int nume, int tipo, int pos){
        nombre[pos].setNombre(nomb);
        int x = nume;
        x = x<< 2; x = x | tipo;
        Numero.insetar(x, pos);       
        
    }
    
    public String Tipo(int dato){
        if (dato == 1) {
            return "movil";
        }
        return "fijo";
    }

    public String toString(int pos) {
        String str = "";
        int numero = Numero.getDato(pos);
        int mask = (int)Math.pow(2, 27)-1;
        mask = mask >>>1;
        numero = numero >>> 1;
        numero = numero & mask;
        
        int tipo = 1; tipo = tipo & Numero.getDato(pos);
        str = "nombre: "+ nombre[pos].getNombre()+ " Numero: "+ numero + " Tipo: "+ Tipo(tipo);
    return str;
    }
    
    
    
    
    
    
}
