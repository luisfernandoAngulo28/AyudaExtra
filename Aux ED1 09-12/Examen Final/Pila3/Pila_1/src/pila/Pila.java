/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Juan
 */
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
    
    public float promedio()
    {
        if (cima > 0)
        {
            int aux = pop(), aux2;
            float prom = aux/(cima+1);
            if ( aux < 0 )
            {
                aux2 = pop();
                prom = aux2/(aux + 2147483647);
                push(aux);
            }else{
                int cim = cima - 2147483645;
                push(cim);
            }
            return prom + promedio();
        }else
            return 0;
    }
    
    public boolean pila_elemRepet()
    {
        return pila_elemR(cima,cima);
    }   
    
    public int segundoMen()
    {
        int salva = 0;
        if (cima == 0)
            return get();
        else
         if (cima==1)
         {   int a1 = pop(), val;
             if (a1 < get())
                 val = get();
             else
                 val = a1;
             push(a1);
             return val;
         }else{
            int aux1 = pop();
            int aux2 = pop();
            int aux3 = pop();
            if ((aux1 < aux2)&&(aux2 > aux3))
            {   salva = aux2;
                if (aux1 < aux3)
                {   push(aux1);
                    push(aux3);
                }else{
                    push(aux3);
                    push(aux1);}
            }else
                if ((aux3 < aux1)&&(aux1 > aux2))
                {   salva = aux1;
                    if (aux3 < aux2)
                    {     push(aux3);
                          push(aux2);
                    }else{
                          push(aux2);
                          push(aux3); }
                }else
                   if ((aux2 < aux3)&&(aux3 > aux1))
                    {   salva = aux3;
                        if (aux1 < aux2)
                        {   push(aux1);
                            push(aux2);
                        }else{
                            push(aux2);
                            push(aux1); }
                    }
             int segunmen = segundoMen();
             push(salva);
             return segunmen;
        }                
    }
    
    private void pintar(Graphics hoja, int y)
    {
        if (!this.vacia())
        {
            hoja.drawRoundRect(0, y, 50, 30, 10, 10);
            hoja.drawOval(0, y, 50, 30);
            int t = pop();
            hoja.drawString(t+"", 20, y+20);
            pintar(hoja,y+30);
            push(t);
        }
    }
    
    public void pintar(Graphics hoja)
    {
        hoja.setColor(Color.white);
        hoja.fillRect(0, 0, 500, 500);
        hoja.setColor(Color.BLACK);
        pintar(hoja,0);
    }
    
    public static void main(String[] args) {
        Pila a = new Pila(7);
        a.push(6);
        a.push(5);
        a.push(4);
        a.push(3);
        a.push(2);
        a.push(1);
        a.push(0);
        System.out.println(a.toString());      
    }
}
