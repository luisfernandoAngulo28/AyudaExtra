
package list;

/**
 *
 * @author BELTRAN
 */
public class List {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Lista l=new Lista();
        
        l.insertar(1);
        l.insertar(2);
        l.insertar(3);
        l.insertar(4);
        l.insertar(5);
        l.insertar(6);
        l.Movermitad();
       
       
        System.out.println(l);
    }
    
}
