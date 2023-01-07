/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwise;

/**
 *
 * @author Ernesto
 */
public class PolinomioBit { VectorBitG pol;
                            int dim;
                            
    public PolinomioBit(int CBit,int Cant){
        pol=new VectorBitG(CBit, Cant*2);
        dim=-1;
    }
    
    public void InsertarMonomio(int Coef,int Exp){
        if ((Coef>=(-10))&&(Coef<=20)&&(Exp>=0)&&(Exp<=16)){
            Coef+=10;
            if(dim==-1){
                dim++;
                pol.Insertar(Coef,(dim*2)+1);
                pol.Insertar(Exp, (dim*2));
            }else{
                int i=0;
                while((i<=dim*2)&&(pol.sacar(i)>Exp)){
                    i+=2;                    
                }if ((pol.sacar(i)==Exp)&&(i<=dim*2)){
                    int Suma=((pol.sacar(i+1)-10)+Coef);
                    if (Suma!=0){
                        pol.Insertar(Suma,i+1);                        
                    }else{
                        for(int k=i;k<dim*2;k+=2){
                            pol.Insertar(pol.sacar(k+2),k);
                            pol.Insertar(pol.sacar(k+3),k+1);                            
                        }
                        dim--;
                    }
                }else{
                    for (int k=dim*2;k>=i;k-=2){
                        pol.Insertar(pol.sacar(k),k+2);
                        pol.Insertar(pol.sacar(k+1),k+3);
                    }
                    pol.Insertar(Exp, i);
                    pol.Insertar(Coef, i+1);
                    dim++;
                }
            }
        }
    }
    public void Sumar (PolinomioBit p, PolinomioBit q){
         for (int i = 0; i<= (p.dim)*2; i+=2 ){
             InsertarMonomio(p.pol.sacar(i+1)-10, p.pol.sacar(i));
         }
         for (int j = 0; j<= (q.dim)*2; j+=2 ){
             InsertarMonomio(q.pol.sacar(j+1)-10 , q.pol.sacar(j));
         }
     }
    public void multiplicar(PolinomioBit p, PolinomioBit q){
        for (int i=0; i<=p.dim*2; i+=2){
            for (int j = 0; j<= q.dim*2; j+=2 ){
                InsertarMonomio(((p.pol.sacar(i+1)-10)*((q.pol.sacar(j+1)-10)+10)),(p.pol.sacar(i) + q.pol.sacar(j)));
            }                    
        }   
    }
    
    public int grado(){
         return pol.sacar(0);
     }
    
    @Override
     public String toString(){
        String s="";
         for (int i=0; i<=dim*2; i+=2){
             int x=(pol.sacar(i+1)-10);
             if (x!=1){
                 s=s+x;
             }if (pol.sacar(i) ==0){
                if (x==1){
                    s=s+x; 
                }
             }else {if (pol.sacar(i) ==1){
                        s=s+"x";
                   }else{
                            s=s+"x"+pol.sacar(i);
                        }  
                   }
             if ((i!=dim*2)&&(x>0)){
                s=s+" + ";
             }
         }
         return s;
     }
     public float Evaluar(int x){
         float valor = 0;
         int pv;
                for (int i = 0; i<= dim*2; i+=2 ){
                    int y=(pol.sacar(i+1)-10);
                    if (pol.sacar(i)>1){
                        pv = potencia(x, pol.sacar(i));
                        valor = valor + (pv*y);
                    }else{
                            if (pol.sacar(i)==1){
                                valor = valor +(x*y);
                            }else {
                                        valor = valor + y;
                                  }                            
                        }                        
                }
         return valor;
     }
     public int potencia(int x, int exp){
         int p=x;
         for (int i=1; i<exp;i++){
             p = p * x;
         }
         return p;
     }
}
