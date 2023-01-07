
package Negocio;

/*======================== TDA NODO ========================================*/
/* Clase de tipo de autoreferencia tiene un elemento de la misma clase
/*==========================================================================*/

public class ClassNodo {

    int Dato;
    ClassNodo Enlace;

    public void setDato(int Ele) {
        this.Dato = Ele;
    }
    
    public int getDato() {
        return Dato;
    }
    
    public void setEnlace(ClassNodo P) {
        this.Enlace = P;
    }

    public ClassNodo getEnlace() {
        return Enlace;
    }

   public ClassNodo()
   {
     // Enlace no apunta a nadie
       this.Enlace = null;
   }
   // Constructor sobrecargado 
   public ClassNodo(int x)
   {
       this.Dato = x;
       this.Enlace = null;
   }
   

   
}
