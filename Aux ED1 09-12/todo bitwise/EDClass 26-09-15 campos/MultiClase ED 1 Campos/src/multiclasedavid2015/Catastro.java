package multiclasedavid2015;
    public class Catastro {         
        int E;
        int F;
    public Catastro(){
        E=0;
        F=0;
    }    
    public void Insertar(int NroCats,int UV, int MZ, int Lote,int Superficie,int alumbrado,int alcantarrillado, int pavimento,
            int aseoU, int luz, int tel, int agua  ){ 
        if ((NroCats>0&&NroCats<=30)&&(UV>0&&UV<=60)&&(MZ>0&&MZ<=15)&&(Lote>0&&Lote<=30)&&(Superficie>=150&&Superficie<=250)&&
                (alumbrado>=0&&alumbrado<=1)&&(alcantarrillado>=0&&alcantarrillado<=1)&&(pavimento>=0&&pavimento<=1)&&(aseoU>=0&&aseoU<=1)&&
                (luz>=0&&luz<=1)&&(tel>=0&&tel<=1&&(agua>=0)&&agua<=1)) {            
            
            E=NroCats;       //0000000000000000000000000 10100 = 20     
            E=E<<6;          //000000000000000000011000 000000  
            
            E=E|UV;          //00000000000000000000011000 011110 = 30
            E=E<<4;          //0000000000000000110000011110 0000  
            
            E=E|MZ;          //0000000000000000110000011110 0010 = 2
            E=E<<5;          //000000000001100000111100010 00000 = 
            
            E=E|Lote;        //000000000001100000111100010 01100 = 12
            E=E<<8;          //000110000011110001001111 00000000 
            
            E=E|Superficie;  //000110000011110001001111 10110100 = 180
            E=E<<1;          //00110000011110001001111 10110100 0 = 
            
            E=E|alumbrado;   //00110000011110001001111 10110100 1 = 1   
            E=E<<1;          //0110000011110001001111 101101001 0 = 
            
         E=E|alcantarrillado;//0110000011110001001111 101101001 0 = 0
            E=E<<1;          //110000011110001001111 1011010010 0 = 
            
            E=E|pavimento;   //110000011110001001111 1011010010 1 = 1            
            
            
            
            
            F=aseoU;
            F=F<<1;      //10
            
            F=F|luz;    //11
            F=F<<1;     //110
            
            F=F|tel;    //110
            F=F<<1;     //1110
            
            F=F|agua;   //1111                                  
        }
    }
    public int getNroCats(){
        int y=E;
        y=y>>>26;
        return(y); 
    }
    public int getUV(){
        int y=E;
        String s="";
        y=y>>>20;
        y=y&63;
        return (y);
    }
    public int getMZ(){
        int y=E;
        y=y>>>16;
        y=y&15;
        return(y);
    }
    public int getLote(){
        int y=E;
        y=y>>>11;
        y=y&31;
        return(y);
    }
    public int getSuperficie(){
        int y=E;
        y=y>>>3;
        y=y&255;
        return(y);
    }
    public String getServicio(){
        String S="";
        int y=E;
        int k=F;
        y=y&7;
        if (((y>>>2)&1)==1) // 001&1=   1==1
            S=S+"   Alumbrado\n";
        if (((y>>>1)&1)==1) // 010&1=0   0==1
            S=S+"   Alcantarrillado\n";
        if (((y)&1)==1) // 101&1=1   1==1
            S=S+"   Pavimento\n";
        
        if ((((k)>>>3)&1)==1)
            S=S+"   Aseo Urbano\n";
        if ((((k)>>>2)&1)==1)
            S=S+"   Luz\n";
        if ((((k)>>>1)&1)==1)
            S=S+"   Telefono\n";
        if ((((k))&1)==1)
            S=S+"   Agua";
        return S;
        
    }    
    public void mostrar(){
        System.out.println("Numero Catastral: "+getNroCats()+"\n"+"UV: "+getUV()+"\n"+"MZ: "+getMZ()+"\n"+"Lote: "
                +getLote()+"\n"+"Superficie: "+getSuperficie()+"\n"+"Servicio:\n"+getServicio());
    }
        public static void main(String[] args) {
            // TODO code application logic here
        Catastro x=new Catastro();  
        x.Insertar(20,30,2, 12, 180,1,1,1,1,1,1,1);
        x.mostrar();
        x.Insertar(30,25,3, 15, 190,0,0,0,1,0,1,0);
        x.mostrar();
        }
}
