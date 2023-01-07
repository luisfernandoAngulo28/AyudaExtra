package proyecto;
import java.io.*;
/**
 *
 * @author BELTRAN
 */
public class Contacto implements Serializable{
    
    String nombre;
    String apellido1;
    String apellido2;
    
    int num_tipo_grupo;
    
    public Contacto(){
        nombre="";
        apellido1="";
        apellido2="";
        num_tipo_grupo=0;
    }
    public Contacto(String nombre, String apellido1, String apellido2, int numero, int tipo, int grupo){
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        
        num_tipo_grupo=numero;
        num_tipo_grupo=num_tipo_grupo<<3;
        num_tipo_grupo=num_tipo_grupo|tipo;
        num_tipo_grupo=num_tipo_grupo<<2;
        num_tipo_grupo=num_tipo_grupo|grupo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }
    
    public int getnumero(){
        int aux= num_tipo_grupo;
        aux=aux>>>5;
        return aux;
    }
    public int gettipo(){
        int mask=num_tipo_grupo;
        mask=mask>>>2;
        int mask1=7;
        mask=mask&mask1;
        
        return mask;
    }
    public int getgrupo(){
        int mask=3;
        int mask1=num_tipo_grupo;
        mask1=mask1&mask;
        return mask1;
        
    }    
}
