/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwise;

/**
 *
 * @author blcu
 */
public class StringB {  CintaBit Cinta;
   public StringB(String cad){
       Cinta=new CintaBit(cad.length());
       String cad1=cad.toLowerCase();
       for(int i=0;i<cad1.length();i++){
           Cinta.Insertar(cad1.charAt(i));
       }
   }
   public String toStringg(){
       String a=Cinta.Mostrarcinta();
       return a;
   }
   public static boolean CadenaValida(String c){
       boolean sw=true;
       int i=0;
       while(i<c.length()){
           int x=(byte)c.charAt(i);
           if((x==-31)||(x==-23)||(x==-19)||(x==-13)||(x==-6)||((x>=97)&&(x<=122))||(x==32)||(x==-15))
               sw=false;
           i++;
       }
     return sw;
   }
    
}
