package multiclasedavid;

public class ClaseNodo {//Clase ClaseNodo (PARA UN DATO)
    //VARIABLES

    int dato;//Elemento
    ClaseNodo enlace;//Caja

    //CONSTRUCTOR POR DEFECTO
    public ClaseNodo() {
        //dato=0;
        enlace = null;//Enlace apunta a CAJA          
    }

    //CONSTRUCTOR SOBRE CARGADO (POR PARAMETRO)
    public ClaseNodo(int dato) {
        enlace = null;//Enlace apunta a CAJA
        this.dato = dato;//se coloca el "THIS" para diferencias del parametro siempre y cuando ambos sean iguales de palabra si son diferentes no es necesario colocar "THIS"
    }
    //SETTERS
    public void setdata(int x){
        dato=x;
    }
    public void setenlace(ClaseNodo enlace){
        this.enlace=enlace;
    }
    //GETTERS
    public int getdata(){
        return dato;
    }
    public ClaseNodo getenlace(){
        return enlace;
    }
    @Override
    public String toString(){
        String cad="L=<";
        ClaseNodo q=new ClaseNodo();
        while (q!=null){
            cad=cad+getdata();
            q=q.getenlace();
        }
        cad=cad+"> ";
        return (cad);
    }
    //MENU
    public static void main(String[] args) {
        ClaseNodo A=new ClaseNodo();
        ClaseNodo B=new ClaseNodo(7);    
        System.out.print(A.getdata());
        System.out.print(A);
        System.out.print(B);                
        System.out.print(B.getdata());
        A.setdata(5);
        System.out.print(A);
        
   }      

}
