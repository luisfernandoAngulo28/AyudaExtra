
package Negocio;


/*=========================== TDA LISTA =====================================*/

public class ClassLista {
  
    ClassNodo L;
    int cant;

    public void Lista()
    {
        L = null;
        cant = 0;
    }
   
    public void Insertar (int Ele)
    {
        //creo mi cajita//
        if( Vacia())
        {
            ClassNodo P = new ClassNodo();
            P.setDato(Ele);
            L = P;
            cant ++;
        }
        else{ ClassNodo Aux = L; ClassNodo Ant = null;
        
        while((Aux != null)&&(Aux.getDato()<= Ele))
        {
            // avanso al siguiente
           Ant = Aux;
           Aux = Aux.getEnlace();
        }       
        // 179 196
        if (Ant == null)
        {
            ClassNodo P = new ClassNodo();// inserta en la cabeza
            P.setDato(Ele);
            P.setEnlace(L); // p apunta a L
            L = P; cant ++;
        }else    // L ─│3│─│5│─│7│─│8│─│10│─╬
             {
                 if (Ant.getDato()!= Ele)
                 {
                 ClassNodo P = new ClassNodo();// inserto en el cuerpo o cola
                 P.setDato(Ele);
                 Ant.setEnlace(P);
                 P.setEnlace(Aux);
                 cant ++;
                 }
             }
    }
        
  
    }

    private boolean Vacia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
