/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

/**
 *
 * @author usuario
 */
 
public class Fecha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CBitwise s=new CBitwise();
        s.Setbit1(1);
        s.Setbit1(4);
        s.Setbit1(32);
        System.out.println(s);
        s.Setbit0(32);
        System.out.println(s);

          ConjuntoBit c=new ConjuntoBit(1000);
//     c.InsertarC(1);
         c.InsertarC(2);
         c.InsertarC(3);
         c.InsertarC(4);
//     c.InsertarC(5);
//     c.InsertarC(6);
         c.InsertarC(7);
         c.InsertarC(8);
          c.InsertarC(2);
         c.InsertarC(87);
         c.InsertarC(75);
//     c.InsertarC(5);
//     c.InsertarC(6);
         c.InsertarC(54);
         c.InsertarC(35);
         
      System.out.println(c);
        c.InsertarC(85);
         c.eliminar(87);
          c.eliminar(7);
         c.eliminar(8);
          c.eliminar(2);
         c.InsertarC(87);
         
         System.out.println(c);
        
        System.out.println("pertenece(ele)="+c.pertenece(87)); 
        
  Vector13bit r =new Vector13bit(10);
   r.insertar( 1,1 );
   r.insertar( 2,2 );
   r.insertar( 4,67);
   r.insertar( 3,2 );
   
   
System.out.println(r);   
Fechita a=new Fechita(10);
      
//        Fechita B=new Fechita(10);
   a.SetFechita(1, 15, 6, 2007);
   a.SetFechita(2, 15, 1, 2007);
   a.SetFechita(3, 28, 4, 2008);
   a.SetFechita(4, 15, 9, 1009);
        System.out.println(a);
    
//       
   Vector17bits e=new Vector17bits(10);
   e.insertar( 1,133 );
   e.insertar( 2,1000 );
   e.insertar( 4,622);
   e.insertar( 3,209 );
   
    e.insertar( 1,3 );
   e.insertar( 2,1 );
   e.insertar( 4,22);
   e.insertar( 3,29 );
   
   
System.out.println(e);  
  }
}
    
