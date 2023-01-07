/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multiclasedavid;

/**
 *
 * @author Juan
 */
public class ClaseColaLista {
            ClaseNodo prin;
            ClaseNodo fin;
            int cant;
            
    public ClaseColaLista(){
        prin = null;
        fin = null;
        cant = 0;
    }
    
    public void colar(int dato){
        ClaseNodo aux = new ClaseNodo(dato);        
        if ( aux != null){
            if ( vacia() )
                prin = fin = aux;
            else{
                fin.setenlace(aux);
                fin = aux;
            }
            cant++;
        }else
            System.out.println("Error: La memoria de la computadora esta llena");
    }
    
    public boolean vacia(){
        return (cant == 0);
    }

    public int decolar(){
        int x = 0;
        if (!vacia()){
            x = prin.getdata();
            prin = prin.getenlace();
            cant--;
        }else
            System.out.println("Error: La cola esta vacia");
        return x;
    }
   
    public int ContR(){
        if (vacia()) {
            return 0;
        }else{
            if (prin==fin) {
                return 1;
            }else{
                int x=decolar();
                int z=ContR();                
                colar(x);
                return z+1;
            }
        }
    }
    public void Intercambiar(int c){
        if (cant/2==c){        
        }else {
            int x=decolar();
            colar(x);
            Intercambiar(c-1);
        }
    }

    @Override
    public String toString(){
	String s = "";
        int c=0;
	while(c<cant){
            int x=decolar();
            colar(x);
            s = s + " " + String.valueOf(x);
            c++;
	}
        return s;
    }
    public void invertir(){
        if(vacia())
            return;
        int x=decolar();
        invertir();
        colar(x);
    }    
    public void invM1(int c){
        if(c==cant/2)
            return;
        colar(decolar());
        invM1(c+1);
    }    
    public void inv2(){
        int x=0;
        while(x<cant/2){
            colar(decolar());
            x++;
        }
    }    
    public int menor(int c){
        if(c==cant -1){
            int x=decolar();
            colar(x);
            return x;
        }
        int x=decolar();
        colar(x);
        int m=menor(c+1);
        if(m>x)
            m=x;
        return m;
    }
    public void solopares(){
        if(vacia())
            return ;
        int x =decolar();
        solopares();
        if(x%2==0){
            colar(x);
        }
    }
    public void eliminarImpares(){
        eliminarImpares(0,cant);
    }
    private void eliminarImpares(int c,int can){
        if(c==can)
            return ;
        int x=decolar();
        if(x%2==0)
            colar(x);        
        eliminarImpares(c+1,can);
    }
    public void ordenar(){
        ordenar(0,cant);
    }
    private void ordenar(int c,int tamIni){
        if(c== tamIni)
            return ;
        int i=0;
        int x = decolar();
            while (i < cant) {
                int y = decolar();
                if (x < y) {
                    colar(x);
                    x=y;
                }else
                    colar(y);
                i++;
            }
        ordenar(c+1, tamIni);
        colar(x);
    }
    public void mostrar(){
        mostrar(cant);
    }
    private void mostrar(int c){
        if (c==0) {
            return;
        }
        int x=decolar();
        System.out.println(x);
        colar(x);
        mostrar(c-1);
    }
    public void elimPos(){
        elimPos(1,cant);
    }
    private void elimPos(int c,int can){
        if(c>can){
            return;
        }  
        int x=decolar();
        if(c%2!=1)
            colar(x);
        elimPos(c+1,can);
    }
    public void desplazar(){
        desplazar(0,cant / 2);
    }
    private void desplazar(int c,int can){
        if(c==can){
            return;
        }  
        colar(decolar());
        desplazar(c+1,can);
    }
    public void desplazar1(){
        desplazar1(0,cant / 2);
    }
    private void desplazar1(int c,int can){
        if(c==can){
            return;
        }  
        int x =decolar();
        desplazar1(c+1,can);
        colar(x);
    }
    public void cambiar(){
        cambiar(cant);
    }
    private void cambiar(int c){
        if (c==0) {
            return;
        }
        if (c>=3) {
            int x=decolar();
            colar(decolar());
            colar(decolar());
            colar(x);
            c=c-3;
        }else{
            colar(decolar());
            c--;
        }
        cambiar(c);
    }
    public void cruzar(ClaseColaLista P){
        cruzar(P,1);
    }
    private void cruzar(ClaseColaLista P,int c){
        if(c>cant)
            return;
        if(c==1 && cant %2==1){
            colar(decolar());
            P.colar(P.decolar());
            c++;
        }else{
            int x = decolar();
            int y = P.decolar();
            colar(P.decolar());
            P.colar(decolar());
            colar(y);
            P.colar(x);
            c=c+2;
        }
        cruzar(P, c);
    }
    public void prueba(){
        if (vacia()) 
            return;        
        int x = decolar();
        prueba();
        if (x % 2 == 0) {
            colar(x);
        }
    }
    public void mitad(){
        mitad(cant);   
    }
    private void mitad(int c){
        if(vacia() || c == cant/2) 
            return;
        colar(decolar());
        mitad(c-1);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ClaseColaLista Q = new ClaseColaLista();
        ClaseColaLista P = new ClaseColaLista();
       
        Q.colar(1);
        Q.colar(2);
        Q.colar(3);
        Q.colar(4);
        Q.colar(5);
        Q.colar(6);
        P.colar(7);
        P.colar(8);
        P.colar(9);
        P.colar(10);
  
//        System.out.println(Q.toString());
//        System.out.println(P.toString());
//        Q.cruzar(P);
//        
//        System.out.println(Q.toString());
//        System.out.println(P.toString());
        System.out.println(Q.toString());
        Q.mitad();
        System.out.println(Q.toString());
       // int y=Q.ContR();
        //System.out.println(y);
//        System.out.println(Q);
        //int x=Q.sacar(true);
        //System.out.println(x);
    }
}
