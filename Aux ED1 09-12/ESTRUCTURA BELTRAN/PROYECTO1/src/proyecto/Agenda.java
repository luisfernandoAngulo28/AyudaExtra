package proyecto;
import java.util.*;
import java.io.*;
public class Agenda implements Serializable{
    Vector<Contacto> v;  
    int dim;
    /*MOVIL=0
    CASA=1
    TRABAJO=2
    FAX CASA=3;
    FAX TRABAJO=4
    
    AMIGOS=0
    FAMILIA=1
    TRABAJO=2
    VIP=3
    */
    public Agenda(){
        dim=-1;
        v=new Vector<Contacto>();
    }
    public void insertar_contacto(Contacto c){
        dim++;
        v.add(c);
        
    }

    public Contacto getcontacto(){
        return v.get(dim);
    }
    public Contacto Obtener_Contacto(int i){
        return v.get(i);
    }

    public int getDim() {
        return dim;
    }
    public void vaciar_agenda(){
        v.clear();
        dim=-1;
    }
    
    

    
            
}
