/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwise;

import sun.text.CodePointIterator;

/**
 *
 * @author Ernesto
 */
public class CintaBit {VectorBitG C;
                       int dim;
                       int pointer;
                       
    public CintaBit(int cant){
        C=new VectorBitG(6,cant);
        dim=-1;
        pointer=0;                
    }
    public void Insertar(char c){
        int x=(byte)c;
        if(x==-31)
            x=28;
        else if(x==-23)
            x=29;
        else if(x==-19)
            x=30;
        else if(x==-13)
            x=31;
        else if(x==-6)
            x=33;
        else if(x==-4)
            x=34;
        if (((x>=97)&&(x<=122))||((x>=48)&&(x<=57))||(x==32)||(x==-15)||((x>=28)&&(x<=34))){            
            if ((x==32)||(x==-15))
                if(x==32)
                    x=0;
                else
                    x=27;
            else if(((x>=97)&&(x<=122)))
                x-=96;
            else if((x>=48)&&(x<=57)) 
                x-=13;
            dim++;
            C.Insertar(x, dim);                                   
        }
    }

    public char GetChar(int pos){
        int x=C.sacar(pos);
            if(x==28)
                return 'á';
            else if(x==29)
                return 'é';
            else if(x==30)
                return 'í';
            else if(x==31)
                return 'ó';
            else if(x==33)
                return 'ú';
            else if(x==34)
                return 'ü';
            if ((x==0)||(x==27))
                if(x==0)
                    x=32;
                else
                    return 'ñ';
            else if((x>=1)&&(x<=26))
                x+=96;
            else
                x+=13;
        return (char)x;
    }
    public String Mostrarcinta(){
        String a="";
        int j=dim;
        for (int i=0;i<=j;i++){
            a=a+GetChar(i);
        }
        return a;
    }    
}
