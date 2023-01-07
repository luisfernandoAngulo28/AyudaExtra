 
package proyecto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.UnsupportedLookAndFeelException;
import diseño.*;
import java.io.File;
/**
 *
 * @author BELTRAN
 */
public class Herramienta {
    
    public static void guardar(Agenda a, String name)throws IOException{
         ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(name+".obj"));
         salida.writeObject(a);
         salida.close();
    }
    public static Agenda recuperar(File f, Agenda a)throws IOException, ClassNotFoundException{
        ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(f));       
        a=(Agenda)entrada.readObject();
        
        entrada.close();
        return a;
        
    }
  
}
