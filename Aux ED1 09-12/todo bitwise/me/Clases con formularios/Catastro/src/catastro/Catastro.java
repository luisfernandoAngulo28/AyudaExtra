/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catastro;

import negocio.ADT_Catastro;
import negocio.Agenda;
import presentacion.NewJFrame;
/**
 *
 * @author MiguelAngel
 */
public class Catastro {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        NewJFrame n = new NewJFrame();
//        n.setLocationRelativeTo(null);
//        n.setVisible(true);
      
        
        
        Agenda a = new Agenda();
        a.insert("miguel  ", 75077712, 1, 1);
  
        a.insert("pedro", 3331170, 0, 2);
        
        System.out.println(a.toString(1));
        System.out.println(a.toString(2));
        System.out.println(a.toString(3));
       // */
    }
                
    
  }
