package Clase;

/*
 * @author Aux INF220 - 2/2016
*/
public class SparceBitwise {
  private VectorBitGenerico VP;
  private VectorBitGenerico VE;
  private int EP;
  private int NE;
  private int NC;
  private int NF;
  private int RI;
  private int RF;
  
  public SparceBitwise (int Filas,int Columnas,int ValorInicial,int ValorFinal,int Predominante) {
    NF=Filas;
    NC=Columnas;
    NE=0;
    VP=new VectorBitGenerico(1, NF*NC, NF*NC);
    VE=new VectorBitGenerico(ValorInicial, ValorFinal, NF*NC);
    EP=Predominante;
    RF=ValorFinal;
    RI=ValorInicial;
  }
  
  private int Buscar(int Posicion) {
    int i=1;
      while ((i<NE+1)&&(VP.GetData(i)!=Posicion)) {
        i++;
      }
    if (i!=NE+1) {
      return i;
    } else {
      return -1;
    }
  }
  
  public void Setdata (int Fila,int Columna,int Valor) {
    if ((Fila>0)&&(Fila<=NF)&&(Columna>0)&&(Columna<=NC)&&(Valor>=RI)&&(Valor<=RF)) {
      int P=((Fila-1)*NC)+Columna;
        if (Valor!=EP) {
          int i=Buscar(P);
            if (i==-1) {
              VP.SetData(P, NE+1);
              VE.SetData(Valor, NE+1);
              NE++;
            } else {
              VE.SetData(Valor, i);
            }
        } else {
          int i=Buscar(P);
            if (i!=-1) {
              for (int j=i;j<NE-1;j++) {
                VE.SetData(VE.GetData(j+1), j);
                VP.SetData(VP.GetData(j+1), j);
              }
              NE--;
            }
        }
    }
  }
  
  public int GetData(int Fila,int Columna) {
    int P=(((Fila-1)*NC)+Columna);
    int i=Buscar(P);
      if (i!=-1) {
        return VE.GetData(i);
      } else {
        return EP;
      }
  }
  
  @Override
  public String toString () {
    String T="";
      for (int i=1;i<=NF;i++) {
        for (int j=1;j<=NC;j++) {
          T=T+GetData(i, j)+'~';
        }
        T=T+'\n';
      }
    return T;
  }
  
}
