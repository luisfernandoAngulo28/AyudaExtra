/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * 
 * By Gabriel Martínez Ayala 13/10/2013
 * 
 */
package bitwisevg;


public class BitwiseVGChar extends BitwiseVG {
    
    int top = 0;
    char [] VC = {'ñ', '.', ',', ' '};
    public BitwiseVGChar(int NEle, int Nbits) {
        super(NEle, Nbits);
    }
    
public int inVC(char b)
 {
     int i=-1;
     boolean s=false;
     while((i<3)&&(s==false))
     {
         i++;
         if(VC[i] == b) {
             s=true;
         }
         
     }
     return (i+26);
 }
    
public void InsertarChar(char a)
{
    int x= (int) a;
    if( (x > 96)&&(x<123)|| (x==122)||(x==44) || (x==46) || (x==32) || (x==241)) {
        top++;
        if(a<123 && a>96)
        {
            Insertar(x - 97,top);
        }
        else
        {
            Insertar((char)inVC(a),top);
        }
        }
    else{
        System.out.println("Error: Carácter inválido");
    }
}

char getchar(int pos)
{
    char y = 160;
    int x = this.GetData(pos);
    if (x>25)
    {
        y= (char) VC[x-26];
    }
    else
    {
        y = (char) (x+97);
    }
       
return y;
}

public String GetCadena()
{
    {
        int i=1;
        String s= "";
        
        while (i <= top)
        {
            s = s + getchar(i) ;
            i++;
        }
        return s;
        }     
}
        
public void InsertarCadena(String c)
{
    int i=0;
    while (i<c.length())
    {
        InsertarChar(c.charAt(i));
        i++;
    }
         
}
}