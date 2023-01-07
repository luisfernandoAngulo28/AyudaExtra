/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwise;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 *
 * @author Ernesto
 */
public class MEsparcidasBit {VectorBitG    vfc;
                          VectorBitG    vd;
                          int dim;
                          int nf;
                          int nc;
                          int e;
                          
    public MEsparcidasBit(int elem,int nrof,int nroc,int maxdat){
           vfc=new VectorBitG(10, 11);
           vd=new VectorBitG(10, 11);
           nf=nrof;
           nc=nroc;
           e=elem;  
           dim=-1;
       }
    public void setdato(int f,int c,int dato){
            if ((f>=0)&&(c>=0)&&(f<nf)&&(c<nc)){                    
                int fc=(f*nc)+c;
                int i=0;
                while((i<=dim)&&(fc!=vfc.sacar(i)))
                    i++;
                if(fc==vfc.sacar(i)){
                    if (dato==e){
                        for(int j=i;j<dim;j++){
                            vfc.Insertar(vfc.sacar(j+1), j);
                            vd.Insertar(vd.sacar(j+1), j);
                        } 
                        dim--;
                    }else{
                        if((dim==-1)&&(fc==0))
                                dim++;
                        vd.Insertar(dato, i);                    
                    }
                }else{
                    if(dato!=e){                        
                        dim++;
                        vfc.Insertar(fc, dim);
                        vd.Insertar(dato, dim);
                    }
                    if ((dim%10==0)&&(dim!=0)){
                       VectorBitG vd1=new VectorBitG(10,dim+11);
                       VectorBitG vfc1=new VectorBitG(10,dim+11);
                       System.arraycopy(vd.V, 0, vd1.V, 0, vd.V.length);
                       vd=vd1;
                       System.arraycopy(vfc.V, 0, vfc1.V, 0, vfc.V.length);
                       vfc=vfc1;
                    }
                }                    
            }
       }
    public int getDato(int f,int c){
           if((f>=0)&&(f<nf)&&(c>=0)&&(c<nc)){
               int x=(f*nc)+c;
               int i=0;
               boolean sw=true;
               while((i<=dim)&&sw){
                   if (vfc.sacar(i) ==x)
                       sw=false;
                   if (sw)
                       i++;
               }
               if (!sw)
                   return vd.sacar(i);
               else return e;
           }else throw new Error("Error fila columna");
       }
        public void mostrarMatriz(int nf,int nc){
            for(int i=0;i<nf;i++){
                System.out.println();
                for(int k=0;k<nc;k++){
                    int a=getDato(i, k);
                    System.out.print(a+" ");
                }                    
            }   
            System.out.println();
        }
        public void Matriz1(){
           for(int i=0;i<=nc;i++){
               setdato(0, i, 1);
               setdato(nf-1, i, 1);
           }
           for(int i=1;i<nf-1;i++){
               for(int k=0;k<nc;k++){
                   setdato(i, k, 0);
               }
           }
        }
        public void matrizTriangSup(int d,int f,int c,int t// t=1
               ){
            if (d<=((nf)*(nf+1))/2){
                if (c<nc-1)
                    matrizTriangSup(d+1,f,c+1,t);
                else
                    matrizTriangSup(d+1,f+1,t,t+1);
                setdato(f, c, d);                                
            }
        }
        
        
}
         
