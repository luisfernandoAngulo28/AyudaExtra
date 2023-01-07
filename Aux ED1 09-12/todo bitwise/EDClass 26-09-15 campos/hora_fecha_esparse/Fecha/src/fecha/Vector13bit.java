/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fecha;

/**
 *
 * @author usuario
 */


public class Vector13bit {
   /*dia =5 bit
    * mes=4bit
    * año=4 bit  
    * 13 bit
    */
    int v[];//vector 13 bit
    int cant;// cantidad de elementos
   
    public Vector13bit(int cant){
       int Nbits= cant*13;
       int NE=Nbits/32;
       if(Nbits%32!=0){
           NE++;
        }
       v=new int[NE];
       this.cant=cant;//cant=0;
     };
    public void insertar(int pos,int ele)
    {
        int NE=NEntero(pos);
        int Nb=Nbit(pos);
        int ele1=ele;
        int mask=(int) Math.pow(2,13)-1;//2 ala 13
        //mask=~mask;
        mask=mask<<Nb-1;
         mask=~mask;
        v[NE]=v[NE]& mask;//Borra
        ele=ele<<Nb-1;//Modifica
        v[NE]=v[NE]|ele; //inserta
        if(Nb-1+13>32){
            int bitf=(Nb+13-32)-1;
             mask=(int) Math.pow(2,13)-1;//2 ala 13
//           mask=~mask;
           mask=mask>>>13-bitf;
           mask=~mask;
           v[NE+1]=v[NE+1]&mask;
           ele1=ele1>>>13-bitf;//CAMBIE =ELE A =ELE1
           v[NE+1]=v[NE+1]|ele1;
            
        }
//       cant++;
    };
    private int NEntero(int pos){
    return(((pos-1)*13)/32);
}
    private int Nbit(int pos){
    return((((pos-1)*13) %32)+1);
    
} 
    public int sacar(int pos)
    {
    int NE=NEntero(pos);
        int Nb=Nbit(pos);
       
        int mask=(int) (Math.pow(2,13))-1;//2 ala 13
        mask=mask << Nb-1;
        mask=mask&v[NE];
        mask=mask>>>(Nb-1);
        
        if(Nb-1+13>32){
            int bitf=(Nb+13-32)-1;
            int mask1=(int) (Math.pow(2, 13)-1);
            mask1=mask1>>>13-bitf;
            mask1=mask1&v[NE+1];
            mask1=mask1<<13-bitf;
            mask=mask|mask1;
            
            }
        return mask;
        }

    @Override
    public String toString() {
        
    String s="v=[ ";
        for (int i = 1; i <= cant; i++) {
            s=s+sacar(i);
            s=s + ",";
        }
        s=s+"]";
        return s;
    };



}
    

