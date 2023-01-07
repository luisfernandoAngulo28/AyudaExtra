/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotdagenericos;

/**
 *
 * @author estudiante
 */
public class Alumno implements Comparable<Alumno> {
    int registro;
    String nombre;
    int CI;

     public Alumno() {
     
     };
    public Alumno(int registro, String nombre, int CI) {
        this.registro = registro;
        this.nombre = nombre;
        this.CI = CI;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getCI() {
        return CI;
    }

    public int getRegistro() {
        return registro;
    }

    public String getNombre() {
        return nombre;
    }
    
 
    

    @Override
    public int compareTo(Alumno o) {
        int resultado=0;
        if (this.registro<o.registro)
         resultado=-1;
        else
           if (this.registro>o.registro)
         resultado=1;
           else resultado=0;
        
        
        return resultado;
    }

    @Override
    public String toString() {
        return "Alumno{" + "registro=" + registro + ", nombre=" + nombre + ", CI=" + CI + '}';
    }
    
}
