/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

import sun.tools.jar.Main;

/**
 *
 * @author Juan
 */
public class PilaVBG {
        int cima;
        VectorBGC pila;
    
    public PilaVBG(int cant)
    {
        cima = -1;
        pila = new VectorBGC((int)20,cant);
    }
    
    public void push(int elemento)
    {
        if (cima+1 != ((pila.V.length)*32)/10)
        {
            pila.insertar(elemento);
            cima++;
        }else
            System.out.println("Error: La pila esta llena");
    }
    
    public int pop()
    {
        if (cima != -1)
        {
            cima--;
            int valor = pila.sacar();
            pila.eliminar(pila.dim+1);
            return valor;
        }else
            System.out.println("Error: La pila esta vacia");
        return 0;
    }
    
    public int get()
    {
        if (cima != -1){
            return pila.sacar();
        }else
            System.out.println("Error: La pila esta vacia");
        return 0;
    }
    @Override
    public String toString()
    {
        String s = "";
        PilaVBG aux = new PilaVBG(cima+1);
        int aux2 = cima;
        for (int i = 0; i <= aux2; i++) {
            s = s + "  " + get();
            aux.push(pop());
        }
        for (int i = 0; i <= aux2; i++) {
            push(aux.pop());
        }
        return s;
    }
    
    public boolean iguales(PilaVBG p1, PilaVBG p2)
    {
        if ( p1.cima == p2.cima )
        {
            if (p1.cima > -1)
            {
                int aux1 = p1.pop(); 
                int aux2 = p2.pop();
                boolean sw = false;
                if (aux1 == aux2)
                {
                    sw = iguales(p1,p2);
                    p1.push(aux1);
                    p2.push(aux2);
                }
                return sw;
            }else
                return true;
        }else
            return false;
    }
    
    public void mayorAlFinal()
    {
        PilaVBG a = new PilaVBG(cima+1);
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
    
    public void mayorAlFinalR()
    {
        if (cima > 0)
        {
            int aux = pop();
            int aux2 = pop();
            if (aux > aux2)
            {
                push(aux);
                mayorAlFinalR();
                push(aux2);
            }else{
                push(aux2);
                mayorAlFinalR();
                push(aux);
            }
        }
    }
    
    public void menorAlPrincipioR()
    {
        if (cima > 0)
        {
            int aux = pop();
            int aux2 = pop();
            if (aux < aux2)
            {
                push(aux2);
                menorAlPrincipioR();
                push(aux);
            }else{
                push(aux);
                menorAlPrincipioR();
                push(aux2);
            }
        }
    }
    
    public void bubleSortR()
    {
        if (cima > 0)
        {
            menorAlPrincipioR();
            int aux = pop();
            bubleSortR();
            push(aux);
        }
    }
    
    public void modificar(int antiguo, int nuevo)
    {
        if (cima >= 0)
        {
            int aux = pop();
            if (aux == antiguo)
                aux = nuevo;
            modificar(antiguo,nuevo);
            push(aux);
        }
    }
    
    public void eliminarRep()
    {
        if (cima > 0)
        {
            int aux = pop();
            eliminarRep();
            if (aux != get())
                push(aux);
        }
    }
    
    public static void main(String[] args)
    {
        PilaVBG p1 = new PilaVBG(7);
        p1.push(1);
        p1.push(1);
        p1.push(1);
        p1.push(0);
        p1.push(1);
        p1.push(2);
        p1.push(1028);
        /*p1.eliminarRep();*/
        System.out.println(p1.toString());
    }
    
}
