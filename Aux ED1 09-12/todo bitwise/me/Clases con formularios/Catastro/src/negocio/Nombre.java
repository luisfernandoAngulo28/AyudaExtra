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
public class Nombre {
    String nombre;
    
    public Nombre(){
        nombre = new String();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        if ((Nombre != "" )&& Nombre.length() <= 8) {
              nombre = Nombre; 
            }
        
    }
    
    
}
