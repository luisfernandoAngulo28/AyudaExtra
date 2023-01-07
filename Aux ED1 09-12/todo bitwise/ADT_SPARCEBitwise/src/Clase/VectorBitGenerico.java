package Clase;

/*
 * @author Aux INF220 - 2/2016
*/
public class VectorBitGenerico {
  private int V[];
  private int CB;
  private int RI;
  private int RF;
  private int Cant;
  
  public VectorBitGenerico (int VInicial, int VFinal,int NElementos) {
    int RR=VFinal-VInicial;
    Cant= NElementos;
    RI=VInicial;
    RF=VFinal;
    int i=0;
      while (Math.pow(2, i)<RR)
        i++;
      CB=i+1;
    
    int X=(CB*Cant)/32;
    int Y=(CB*Cant)%32;
      if (Y==0) V=new int[X];
      else {
        X++;
        V=new int[X];
      }
    for (i=0;i<X;i++) 
      V[i]=0;
  }
  
  private int NEntero (int Posicion) {
    return ((Posicion-1)*CB)/32;
  }
  
  private int NBit (int Posicion) {
    return (((Posicion-1)*CB)%32)+1;
  }
  
  public void SetData(int Valor,int Posicion) {
    if ((Valor>=RI)&&(Valor<=RF)&&(Posicion>0)&&(Posicion<=Cant)) {
      
      int X=NEntero(Posicion);
      int Y=NBit(Posicion);
      Valor=Valor-RI;
      int Valor1=Valor;
      int Mask1=(int)(Math.pow(2, CB)-1);
      Mask1<<=(Y-1);
      V[X]=V[X]&(~Mask1);
      Valor<<=(Y-1);
      V[X]=V[X]|Valor;
        if (((Y-1)+CB)>32) {
          V[X+1]>>>=(CB-(32-(Y-1)));
          V[X+1]<<=(CB-(32-(Y-1)));
          Valor1>>>=(32-(Y-1));
          V[X+1]=V[X+1]|Valor1;
        }
    }
  }
  
  public int GetData(int Posicion) {
    if ((Posicion>0)&&(Posicion<=Cant)) {
      int Mask1=(int)(Math.pow(2,CB)-1);
      int Mask2=Mask1;
      int X=NEntero(Posicion);
      int Y=NBit(Posicion);
        Mask1<<=(Y-1);
        Mask1=Mask1&V[X];
        Mask1>>>=(Y-1);
          if (((Y-1)+CB)<=32) {
            return Mask1+RI;
          } else {
            Mask2>>>=(32-(Y-1));
            Mask2=Mask2&V[X+1];
            Mask2<<=(32-(Y-1));
            return (Mask2|Mask1)+RI;
          }
    } else {
      return -1;
    }
  }
  
  @Override
  public String toString () {
    String T="";
      for (int i=1;i<=Cant;i++) {
        T=T+GetData(i)+' ';
      }
    return T;
  }
  
}
