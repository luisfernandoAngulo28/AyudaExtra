/*Realizar una encuesta que me permita valorar, entre 1 y 5 estrellas por 
  cada pregunta, las cuales son 3 preguntas
    //y de esas 3 preguntas de ciertos partidos cuya lista donde existira el numero
    //de encuesta, el numero de pregunta y posteriormente pregunta 1 2 3 4 5
    //..el usuario tiene que introducir como parametro el numero de encuesta
    //el numero 
    */
package pregunta;

public class Pregunta {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Vector30bits c=new Vector30bits(10);
       c.insertar(1, 18);
       c.insertar(2, 20);
       c.insertar(3, 10);
       c.insertar(4, 50);
       c.insertar(5, 88);
       c.insertar(1, 98);
       c.insertar(2, 2);
       c.insertar(3, 10);
       c.insertar(4, 80);
       c.insertar(5, 8);
        c.insertar(9, 80);
       c.insertar(8, 8);
       
       System.out.println(c);
      Catastro f=new Catastro(1);
      f.SetCatastro(1, 3, 30, 10, 20,180,1, 0, 1);
//      f.SetCatastro(2, 31, 60 , 15, 30,250,0, 1, 1);
      
        System.out.println(f);
    }
}
