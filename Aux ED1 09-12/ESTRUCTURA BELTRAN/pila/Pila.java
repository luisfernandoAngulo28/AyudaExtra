
package pila;

public class Pila {
        
        int V[];
        int cima;
        
    public Pila(int cant)
    {
        cima = -1;
        V = new int[cant];
    }
    
    public boolean llena()
    {
        return (cima == V.length-1);
    }
    
    public boolean vacia()
    {
        return (cima == -1);
    }
    
    public void push(int elemento)
    {
        if (! llena())
        {
            cima++;
            V[cima] = elemento;
        }else
            System.out.println("Error: La pila esta llena");
    }
    
    public int pop()
    {
        if (! vacia())
        {
            cima--;
            return V[cima+1];
        }else
            System.out.println("Error: La pila esta vacia");
        return 0;
    }
    
    public int get()
    {
        if (! vacia())
            return V[cima];
        else
            System.out.println("Error: La pila esta vacia");
        return 0;
    }
    
    public void eliminarRep()
    {
        Pila q = new Pila(cima+1);
        int cont = 0;
        while (cima != cont-1)
        {
            int x = pop();
            while (cima != cont-1)
            {
                int y = pop();
                if (x != y)
                    q.push(y);
            }
            push(x);
            while(! q.vacia())
                push(q.pop());
            cont++;
        }
    }
    
    public void delRepPilaOrden()
    {
        if ((!vacia())&&(!(cima ==0)))
        {
            int salva = pop();
            delRepPilaOrden();
            int x = get();
            if (x != salva)
                push(salva);
        }
    }
    
    @Override
    public String toString()
    {
        String s = "";
        Pila salva = new Pila(cima+1);
        for (int i = 0; i < salva.V.length; i++) {
            salva.push(get());
            s = s + pop()+", ";
        }
        
        for (int i = 0; i < salva.V.length; i++) {
            push(salva.pop());
        }
        if (s.length() > 0)
            return s.substring(0, s.length()-2);
        else
            return "";
    }
    
    public void invertir()
    {
        Pila aux = new Pila(cima+1);
        int cont = 1;
        for (int i = 0; i < aux.V.length; i++) {
            int x = pop();
            for (int j = cont; j < aux.V.length; j++)
                aux.push(pop());
            aux.push(x);
            for (int j = 0; j < aux.V.length-cont+1; j++)
                push(aux.pop());
            cont++;
        }
    }
    
    public boolean simetrica()
    {
        int aux = cima+1, j = 0;
        Pila a = new Pila(cima);
        boolean sw = true;
        while (sw && (j != aux/2))
        {
            int valor = 0;
            for (int i = 0; i < aux; i++) {
                if (i == j)
                    valor = pop();
                else
                    a.push(pop());
                if ((aux - i-1 == j)&&( a.get() != valor ))
                    sw = false;
            }
            for (int i = 0; i < aux; i++) {
                if (aux - i-1 == j)
                    push(valor);
                else
                    push(a.pop());
            }
            j++;
        }
        return sw;
    }
    
    public void eliminar(int nro)
    {
        Pila b = new Pila(cima+1);
        int aux = cima+1;
        for (int i = 0; i < aux; i++) {
            if ( get() == nro)
            {
                pop();
            }else
                b.push(pop());                        
        }
        aux = b.cima+1;
        for (int i = 0; i < aux; i++) {
            push(b.pop());
        }
    }
    
    public void eliminar2(int nro)
    {
        if (cima != -1)
        {
            if (get() != nro)
            {
                int aux = pop();
                eliminar2(nro);
                push(aux);
            }else{
                pop();
                eliminar2(nro);
            }
        }
    }
    
    public void reemplazar(int nuevo, int viejo)
    {
        if (cima != -1)
        {
            int aux = pop();
            if (aux == viejo)
                aux = nuevo;
            reemplazar(nuevo,viejo);
            push(aux);
        }
    }
    
    public void mayorAlFinal()
    {
        Pila a = new Pila(cima+1);
        int may = pop();
        while (cima > -1)
        {
            int cmp = pop();
            if (cmp > may)
            {
                a.push(may);
                may = cmp;
            }else
                a.push(cmp);            
        }
        push(may);
        while(a.cima > -1)
            push(a.pop());
    }
    
    public boolean pila_elemR(int k, int constante)
    {
        boolean sw = false;
        if (cima > 0)
        {
            int aux = pop();
            int aux2 = pop();
            if (aux == aux2)
            {
                push(aux2);
                push(aux);
                return true;
            }
            push(aux);
            sw = pila_elemR(k,constante);
            push(aux2);
                                    
        }
        if (cima == constante)
        if (k >0)
        {
            k--;
            return pila_elemR(k,constante);
        }else
            return sw;
        return false;
    }
    

    public boolean pila_elemRepet()
    {
        return pila_elemR(cima,cima);
    }   
    
    
    
    
    //EXAMEN CAMPOS 1-2015
    public void Intercalar(Pila q){
        int x=q.cima;
        Pila aux=new Pila((q.cima+1)*2);
        int i=0;
        while(i<=x){        
            aux.push(pop());
            i++;   
        }
        while(!llena()){       
            push(aux.pop());
            if (!llena())
            push(q.pop());            
        }
        while(!q.vacia()){
            aux.push(q.pop());
            
        }
        while (!q.llena()){
            q.push(aux.pop());
            aux.invertir();
        }
              
        
    }
     
    public static void main(String[] args) {
        
        Pila p = new Pila(5);
        Pila q = new Pila(5);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);
//        p.push(12);
        
        q.push(6);
        q.push(7);
        q.push(8);
        q.push(9);
        q.push(10);
//        q.push(44);
        p.Intercalar(q);
       
        System.out.println("PILA P: "+p);
        System.out.println();
         System.out.println("PILA Q: "+q);
        System.out.println();
       // System.out.println(q.toString());
        
              
    }
}
