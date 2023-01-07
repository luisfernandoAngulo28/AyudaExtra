/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwisevg;



/**
 *
 * @author Gabo
 */
public class BitwiseVG {
    int V[];
    int dim;
    int Nbit;


    
public BitwiseVG(int NEle, int Nbits)
{
    int Cbits = NEle * Nbits;
    int NE = Cbits/32;
    if((Cbits/32)!=0)
        NE++;
    V= new int[NE];
    dim=NEle;
    Nbit = Nbits;
}

private int Numbit(int Pos)
{
    return (((Pos-1)*Nbit)%32);
}

private int NE(int Pos)
{
    return (((Pos-1)*Nbit)/32);
}


public void Insertar(int Ele, int Pos)
{
    if((Ele > (Math.pow(2,Nbit)-1)) || (Pos > dim))
        System.out.println("Error: Posición o valor fuera de rango");
    else{
        
        int Ele1=Ele;
        int mask = (int) (Math.pow(2, Nbit)-1);
        int Pbit = Numbit(Pos);
        int Nent = NE(Pos);
        int aux = V[Nent];
        mask = mask << Pbit;
        mask = ~mask;
        V[Nent] = V[Nent] & mask;
        Ele = Ele << Pbit;
        V[Nent] = V[Nent] | Ele;
        if (Pbit + Nbit > 32)
        {
        int bitF = Pbit + Nbit - 32;
        mask = (int) Math.pow(2,Nbit)-1;
        mask = mask >>> Nbit - bitF;
        mask = -mask;
        V[Nent+1] = V[Nent+1] & mask;
        V[Nent+1] = V[Nent+1] | Ele1;
        }
    }
}

int GetData(int Pos)
{
    int mask = 0;
    if((Pos<0) || (Pos >dim))
        System.out.println("Error: Posición fuera de rango");
    else
    {
        int Pbit = Numbit(Pos);
        mask = (int) Math.pow(2,Nbit)-1;
        mask = mask << Pbit;
        mask = mask & V[NE(Pos)];
        mask = mask >>> Pbit;
        if(Pbit + Nbit > 32)
        {
            int bitF = (Pbit + Nbit - 32);
            int mask2 = (int) Math.pow(2, Nbit)-1;
            mask2 = mask2 >>> Nbit - bitF;
            mask2 = mask2 & V[NE(Pos)+1];
            mask2 = mask2 << Nbit - bitF;
            mask = mask & mask2;            
        }
    }
    return mask;
}
    
}

