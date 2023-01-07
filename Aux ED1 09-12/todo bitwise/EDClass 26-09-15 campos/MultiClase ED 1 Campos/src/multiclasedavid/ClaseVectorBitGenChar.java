//Primer parcial II/2013, Estructuras de Datos con el Ing. Mario Campos.
//1.- Crear una clase bitwise para contener los caracteres en minuscula de la 'a' hasta la 'z' (incluyendo 'ñ',',','.','space')
//R.- lo construí usando la Clase Bitwise por Valor Genérico (BitwiseVG), y con la ayuda de los caracteres ascii, también usando un vector auxiliar para los carácteres que no son minúsculas, y ñ VC('ñ',',','.','space').
package multiclasedavid;
public class ClaseVectorBitGenChar extends ClaseVectorBitGen{    
    int top = 0;
    char [] VC = {'ñ', '.', ',', ' '};
    public ClaseVectorBitGenChar(int NEle, int Nbits) {
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
                insertar(x - 97,top);
            }
            else{
                insertar((char)inVC(a),top);
            }
        }else{
            System.out.println("Error: Carácter inválido");
        }
    }

    char getchar(int pos)
    {
        char y = 160;
        int x = this.getdato(pos);
        if (x>25){
            y= (char) VC[x-26];
        }else{
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
    public static void main(String[] args) {
        // TODO code application logic here
        
        ClaseVectorBitGenChar C = new ClaseVectorBitGenChar(29,5);
        String Cadena = "año viejo.";
        C.InsertarCadena(Cadena);
        System.out.println(C.GetCadena());
      
    }
}