/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizer;

import java.util.Stack;

/**
 *
 * @author Estudiante
 */
public class Pila {

    int tope;
    public static final int MAX = 100;
    int[] P;

    public Pila() {
        tope = -1;
        P = new int[MAX];
    }

    boolean Vacia() {
        return (tope == -1);
    }

    boolean Llena() {
        return (tope == MAX);
    }

    void Push(int dato) {
        if (!Llena()) {
            tope++;
            P[tope] = dato;
        } else {
            System.out.println("Pila Llena");
        }
    }

    void Pop() {
        if (!Vacia()) {
            tope--;
        } else {
            System.out.println("Pila Vacia");
        }
    }

    int Get() {
        int dato = 0;
        if (!Vacia()) {
            dato = P[tope];
        } else {
            System.out.println("Pila Vacia");
        }
        return dato;
    }
    
    @Override
    public String toString(){
        String aux = "Pila =[";
        Pila Paux = new Pila();
        while (0 <= tope) {
            Paux.Push(Get());
            aux = aux + " " + Get();
            Pop();
        }///la pila quedo vacia :( 
        while (0< Paux.tope) {
            Push(Paux.Get());
            Paux.Pop();
        }///la pila esta como al principio :)
        return aux + " ]";
    }
    
    public static void main(String[] args) {
        
    //    Stack<Integer> PP = new Stack<Integer>();
        Pila MyPila = new Pila();
        MyPila.Push(3);
        MyPila.Push(8);
        MyPila.Push(4);
        MyPila.Push(1);
        MyPila.Push(7);
        
        System.out.println(MyPila.toString());
    
        
    }

}
