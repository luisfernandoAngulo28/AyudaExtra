/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitwise;

/**
 *
 * @author ESTUDIANTE
 */
public class FraccionBit {  int V[];
                            int Dim;

    public FraccionBit(int cant){
            int x =(cant *9)%32;
            int y =(cant *9)/32;
            if (x!=0){
                y++;
            }
            V=new int [y];
            Dim=0;
    }

    public int NBit(int pos){
        return ((((pos-1)*9)+1)%32);
    }

    public int NEnt(int pos){
        return (((pos-1)*9)/32);
    }

    public void Insertar (int N,int D, int S){
        if (Dim==0){
            int mask=N;
            D=D<<4;
            mask=mask|D;
            S=S<<8;
            mask=mask|S;
            V[0]=mask;
            Dim++;
        }else{
            int x=NBit
                    (Dim+1);
            int y=NEnt(Dim+1);
            if ((x+9)<=32){
                int mask=S;
                mask=mask<<8;
                D=D<<4;
                mask=mask|D;
                mask=mask|N;
                mask=mask<<(x-1);
                V[y]=V[y]|mask;
                Dim++;
            }else{
                int mask=N;
                mask=mask|D;
                S=S<<8;
                mask=mask<<(x-1);
                int mask1=mask;
                mask=mask<<(x-1);
                V[y]=V[y]|mask;
                mask1=mask1|32-(x+1);
                V[y+1]=V[y+1]|mask1;
                Dim++;
            }
        }
    }

    public String sacar(int pos){
        String cad="";
        int mask=511;
        int y=NEnt(pos);
        int x=NBit(pos);
        if ((32-x+1)>=9){
            int z=V[y];
            z=z>>>(x-1);
            mask=mask&z;
        }else{
                int w=V[y];
                w=w>>>(x-1);
                mask=mask&w;
                w=V[y+1];
                int b=(32-(9-(32-(x-1))));
                w=w<<9;
                int aux=0;
                aux=aux|w;
                aux=aux>>>(b-(32-x+1));
                mask=mask|mask;
            }
            int N=15;
            N=N&mask;
            mask=mask>>>4;
            int D=15;
            D=D&mask;
            mask=mask>>>4;
            int s=0;
                s=s|mask;
                if (s==0){
                    cad="+"+N+"/"+D+","+cad;
                }else{
                    cad="-"+N+"/"+D+","+cad;
                }
            return cad;
    }

}
