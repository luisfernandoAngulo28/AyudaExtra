/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * Gabriel Martínez Ayala 13/10/2013)
 * 
 */
package pila;

/**
 *
 * @author Gabo
 */
public class Pila {
    int P[];
    int Tope;

public Pila(int Cantidad)
{
    P= new int[Cantidad];
    Tope = -1;
}

private boolean llena()
{
    return(Tope == P.length-1);
}

private boolean vacia()
{
    return(Tope == -1);
}

public void push(int Ele)
{
    if (llena())
    {
        System.out.println("Stack Overflow");
    }
    else{ Tope++;
            P[Tope]= Ele;
    }
    
}

public int pop()
{
    Tope--;
    return P[Tope+1];
}

int sim(Pila B, int Dim)
{
    int a = 0;
    if (Dim == -1)
    {
    }
    else
    {
        int z=B.pop();
        a = sim(B, Dim-1);
        if(Dim == 0)
            a=z;
        B.push(z);        
    }
    return a;
}

boolean simetrico(Pila B)
{
    boolean s =true;
    if(vacia())
    { 
    }
    else
    {
        int x = pop();
        s = simetrico(B);
        int y = sim(B, Tope+1);
        if (x != y)
            s= false;
        push(x);
        ;
    }
    return s;
}

}
