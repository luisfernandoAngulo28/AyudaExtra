/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pregunta;

/**
 *
 * @author usuario
 */
public class Catastro {
   /* nrocatastral=5 bits
    * uv=6 bits
    * mz=4 bits
    * lote=5 bits
    * superficie=150-250 = 7 bits
    * servicios =4 bits
    * 1:alumbrado 
    * 2:alcantarillado
    * 3:pavimento
    */
    
    Vector30bits V;
    int cant;
   
    public Catastro(int cant){
    V= new Vector30bits(cant);
    this.cant=cant;
        
    };
    public void SetCatastro(int pos,int NroC ,int uv, int MZ,int lote,int sup, int alumbrado,int alcantarillado,int pavimento){ 
        if(((sup>=150)&&(sup<=250))&&((pavimento==1)||(pavimento==0))&&
                ((alcantarillado==1)||(alcantarillado==0))&&((alumbrado==1)||(alumbrado==0))
                &&((1<=lote)&&(lote<=30))&&((1<=MZ)&&(MZ<=15))&&((1<=uv)&&(uv<=60))&&((1<=NroC)&&(NroC<=30))){
           
            sup=sup-150;//max es 100  que luego se sumara 150
          
        
        NroC=NroC<<25;//30-5=25
        uv=uv<<19;//25-6
        NroC=NroC|uv;//NroC,uv,,,,,,,,,,......,,,,,,,,,,,
        MZ=MZ<<15;//19-4......,MZ........................
        NroC=NroC|MZ;//NroC,uv,MZ,.......................
        lote=lote<<10;  //15-5...,lote...................
        NroC=NroC|lote; //NroC,uv,MZ,lote,......
        sup=sup<<3;//10-7.............,sup......
        NroC=NroC|sup;//NroC,uv,MZ,lote,sup,
        alumbrado=alumbrado<<2;//3-1
        NroC=NroC|alumbrado;//NroC,uv,MZ,lote,sup,alumbrado,....
        alcantarillado=alcantarillado<<1;//2-1 NroC,uv,MZ,lote,sup,alumbrado,.
        NroC=NroC|alcantarillado;// NroC,uv,MZ,lote,sup,alumbrado,alcantarillado,.
        NroC=NroC|pavimento;
   
//        a=2000+a;
        V.insertar(pos, NroC);
       
    
        }else{
            System.out.println("introduzca valores validos"+"\n"+
                    "Nro Catastral: 1- 30"+"\n"+
                    "UV:1 - 60"+"\n"+
                    "MZ: 1 - 15 "+"\n"+
                    "lote: 1-30"+"superficie: 150 - 250"+"\n"+
                    "alumbrado publico: 1=Si o 0=No"+"\n"+
                    "alcantarillado: 1=Si o 0=No"+"\n"+"pavimento: 1=Si o 0=NO "); 
              
                  
                  
                  }
        
            
        }
    
    
    
    
    public int get_pav(int pos){
        int e=V.sacar(pos);
        int mask=(int) Math.pow(2, 1)-1;
        mask=e&mask;
        return mask;
//        ¨ 
        //2008
    }
 public int get_alcan(int pos){
        int e=V.sacar(pos);
        int mask=(int) Math.pow(2, 1)-1;
        mask=mask<<1;//10
        mask=e&mask;
        mask=mask>>>1;
        return mask; 
    }
 public int get_alum(int pos){//alumbrado
        int e=V.sacar(pos);
        int mask=(int) Math.pow(2, 1)-1;//1 
        mask=mask<<2;//      1-   100
        mask=e&mask;
        mask=mask>>>2;
        return mask; 
    }
 
 public int get_sup(int pos){//sup
        int e=V.sacar(pos);
        int mask=(int) Math.pow(2, 7)-1;
        mask=mask<<3;//2 mas 7
        mask=e&mask;
        mask=mask>>>3;
        return (150+mask); 
    }
public int get_lote(int pos){//lote
        int e=V.sacar(pos);
        int mask=(int) Math.pow(2, 5)-1;
        mask=mask<<10;//10=7bit+1bit+1bit+1bit
        mask=e&mask;
        mask=mask>>>10;
        return mask;
        
}
public int get_MZ(int pos){//MZ
        int e=V.sacar(pos);//
        int mask=(int) Math.pow(2, 4)-1;//4 bits=15 como maximo 
        mask=mask<<15;//10bits anteriores+5 bit de lote
        mask=e&mask;
        mask=mask>>>15;
        return mask;
    
}
public int get_UV(int pos){//uv
        int e=V.sacar(pos);
        int mask=(int) Math.pow(2, 6)-1;//6 bits
        mask=mask<<19;//15bits anteriores+4bits de MZ
        mask=e&mask;
        mask=mask>>>19;
        return mask;
            
        }
 public int get_NroC(int pos){
     int e=V.sacar(pos);
     int mask=e>>>25; //19bits anteriores +6bits de UV o 30 bits-5=25
     return mask;
     
 }

    @Override
    public String toString() {
         String s="Catastro ";
        for (int i = 1; i <=cant; i++) {
            s=s+"\n"+"Nro Catastral: "+get_NroC(i)+"\n"
                    +"UV: "+get_UV(i)+"\n"
                    +"MZ: "+get_MZ(i)+"\n"
                    +"lote: "+get_lote(i)+"\n"
                    +"Superficie: "+get_sup(i)+"\n"+"Servicios: "+"\n"
                    +"Alumbrado publico:"+get_alum(i)+"\n"+ "Alcantarillado: "
                    +get_alcan(i)+"\n"+"Pavimento:"+get_pav(i);
            
        }
        return s;
    }
    
}
