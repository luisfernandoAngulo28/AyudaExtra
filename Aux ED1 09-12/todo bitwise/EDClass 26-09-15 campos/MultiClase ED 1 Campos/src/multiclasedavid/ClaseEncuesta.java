package multiclasedavid;
public class ClaseEncuesta { int E;

public ClaseEncuesta(){
    E=0;
}
//Nro=6bits
//Nsigla,Ftu,RR,Fd=3bits
//☺☺☺☺☺☺☺PREGUNTA DE EXAMEN☺☺☺☺☺☺☺☺☺
//REALIZAR UNA ENCUESTA
//Realizar una encuesta que me permita valorar entre 1 y 5 estrellas por las 3 preguntas de cierto 
//partido cuya lista de siglas son:
//1:SIGLA: FTU
//2:SIGLA: RSU
//3:SIGLA: FD
//
public void Insertar(int NroE,int Nsigla, int Ftu,int RR,int Fd ){ //Nsigla=xquien votaria           
    if ((NroE>0)&&(NroE<=50)&&(Nsigla>0)&&(Nsigla<=4)&&((Ftu)>0)&&(Ftu<=5)&&(RR>0)&&(RR<=5)&&(Fd>0)&&(Fd<=5)) {
        E=NroE;
        E=E<<3;
        E=E|Nsigla;
        E=E<<3;
        E=E|Ftu;
        E=E<<3;
        E=E|RR;
        E=E<<3;
        E=E|Fd;
    }
}
public int getNroEncuesta(){
    int y=E;
    y=y>>>12;
    return(y); 
}
public String getNSigla(){
    int y=E;
    String s="";
    y=y>>>9;
    y=y&7;
    if (y==1) {
       s="FTU";
    }if (y==2) {
        s="RSU";
    }if (y==3) {
        s="FD";
    }if (y==4) {
        s="Ninguno";
    }    
    return (s);
}
public int getFTU(){
    int y=E;
    y=y>>>6;
    y=y&7;
    return(y);
}
public int getRR(){
    int y=E;
    y=y>>>3;
    y=y&7;
    return(y);
}
public int getFD(){
    int y=E;
    y=y&7;
    return(y);
}

public void mostrar(){
    System.out.println(getNroEncuesta()+","+getNSigla()+","+"Ftu="+getFTU()+","+"RR="+getRR()+","+"Fd="+getFD());
}
    public static void main(String[] args) {
        // TODO code application logic here
    ClaseEncuesta x=new ClaseEncuesta();  
    x.Insertar(20,2,2, 5, 3);
    x.mostrar();
    }
}
