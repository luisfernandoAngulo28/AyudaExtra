
package uno.clases;

/**
 * Ayudantia 1/2016 Eddy Escalante
 */
public class Pila {
    // atributos de la clase
    int v[];
    int cima;
    // constructor parametrizado
    public Pila(int cant){
        v=new int [cant];
        cima=-1;
    }
     
    public void push(int dato){
            if (llena()){
                System.out.println("Pila::push:Error la pila esta llena");
            }else{
                cima++;
                v[cima]=dato;
            }
    }
    
    public int pop(){
            int x=-1;       // retorna -1 cuando la pila esta vacia
            if (vacia()){
                System.out.println("Pila::pop:Error la pila esta vacia");
            }else{
                cima--;
                x=v[cima+1];
            }
        return x;
    }
    
    public boolean llena(){
        return (cima==v.length);
    }
    public boolean vacia(){
        return (cima==-1);
    }
    public void GiraArriba(){
        if (!vacia()){
            int x = pop();
            Pila q = new Pila(cima);
            while (!vacia()){
                q.push(pop());
            
            }
            push(x);
            while (q.vacia()){
                push(q.pop());
            }
        }
    }
    
    public void GirarAbajo(){
        if (!vacia()){
           Pila q = new Pila(cima);
           while(!vacia()){
               q.push(pop());
           }
           int x = q.pop();
           while (!q.vacia()){
               push(q.pop());
           }
           push(x);
        }
    
    }
    public void GirarArribaR(){
        if (cima!=0){
            int x=pop();
            GirarArribaR();
            int y=pop();
            push(x);
            push(y);
        }
    }
    public void GirarAbajoR(){
        if (cima!=0){
            int x=pop();
            int y=pop();
            push(x);
            GirarAbajoR();
            push(y);
            
        }
    }
    
    
}
