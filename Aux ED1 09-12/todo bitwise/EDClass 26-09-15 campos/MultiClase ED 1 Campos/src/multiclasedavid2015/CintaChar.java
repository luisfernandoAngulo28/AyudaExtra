package multiclasedavid2015;
public class CintaChar {
    int cabezal;
    char c[];
    int dim;
    public CintaChar(){
        this.dim=-1;
        this.cabezal=-1;
        c=new char[50];       
    }
    public CintaChar(int cantidad){
        c=new char[cantidad];
        this.dim=-1;
        this.cabezal=-1;
    }

    public char getChar(int pos) {
        cabezal=pos;
        return (c[cabezal]);
    }
    public char getC(){
        return (c[cabezal]);
    }    

    public void setChar(char x) {
        if (dim<=c.length-1){
            avanzar();
            this.c[cabezal]=x;
            dim++;
        }                
    }
    public void modificar (int pos,char x){
        if((pos>-1) && (pos<=dim)){
            cabezal=pos-1;
            c[cabezal]=x;
        }
    }
    public void borrar(int pos){
        for (int i = pos-1; i < dim; i++) {
            c[i]=c[i+1];
        }
        cabezal=pos-1;
        dim--;
    }
    public String getPalabra(){
        String s="";
        avanzar(); 
        int i=0;
        while (getChar(i)!=' '){            
            s=s+getC();
            avanzar();
            i++;
        }
        return (s);
    }
    public int cantPalabra(){
        int i=0,C=0;        
        String p="";
        while (i<=dim){
            while ((i<=dim)&&(c[i]==' ')){
                p="";
                i++;                
            }
            while ((i<=dim)&&(c[i]!=' ')){
                p=p+c[i];
                i++;                
            }
            if (p.length()>0){
                C=C+1;
            }
        }
        return C;
    }
    public String obtenerPalabra(int pos){
        int i=0;
        int C=0;
        String p="";
        if ((pos>0)&&(pos<=cantPalabra())){
            while ((i<=dim)&&(C<pos)){
                while ((i<=dim)&&(c[i]==' ')){
                    p="";
                    i++;                
                }
                while ((i<=dim)&&(c[i]!=' ')){
                    p=p+c[i];
                    i++;                
                }
                if (p.length()>0){
                    C=C+1;
                }
            }
            return p;
        }else{
            System.err.println("Error fuera de rango");
            return "No hay palabra";
        }
    }
    public int getDim() {
        return dim+1;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public int getCabezal() {
        return cabezal+1;
    }

    public void setCabezal(int cabezal) {
        this.cabezal = cabezal;
    }
    
    private void avanzar(){
        if (cabezal!=c.length-1)
            cabezal=cabezal+1;        
    }
    private void retroceder(){
        if (cabezal!=-1)
            cabezal=cabezal-1;        
    }

    @Override
    public String toString() {
        String s="\nCinta:    ";
        for (int i = 0; i < dim+1; i++) {
            s=s+c[i];            
        }
        s=s+"\nCabezal: ";
        for (int i = 0; i < getCabezal(); i++) {
            s=s+" ";            
        }
        s=s+"|\n";
        return s;
    }    
    public static void main(String[] args) {
        CintaChar C=new CintaChar(50); 
        C.setChar('H');
        C.setChar('o');
        C.setChar('l');
        C.setChar('a');
        C.setChar(' ');
        C.setChar('M');
        C.setChar('u');
        C.setChar('n');
        C.setChar('d');
        C.setChar('o');
        C.setChar(' ');
        C.setChar('H');
        C.setChar('o');
        C.setChar('l');
        C.setChar('a');
        C.setChar(' ');
        C.setChar('G');
        C.setChar('a');
        C.setChar('b');
        C.setChar('i');
        
        C.modificar(3, 'j');
        System.out.println(C);
        System.out.println("Dimension: "+C.getDim());
        System.out.println("Palabras: "+C.cantPalabra());
        System.out.println(C.obtenerPalabra(4)); 
        System.out.println("Cabezal: "+C.getCabezal());
        C.borrar(3);
        
        System.out.println(C);
    }
}
