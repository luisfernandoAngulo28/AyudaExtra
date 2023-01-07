/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

/**
 *
 * @author usuario
 */
public class CBitwise {
    int x;

public CBitwise()
{
    x=0;
}
public void Setbit1(int pos){
    int mask=1;
    mask=mask<<pos-1;
    x=x|mask;
    
}
public void Setbit0(int pos){
    int mask=1;
    mask=mask<<pos-1;
    mask=~mask;
    x=x&mask;
    
}
  public int getbit(int pos){
      int mask=1;
      mask=mask<<pos-1;
      mask=mask&x;
      mask=mask>>>pos-1;


      return mask;

    }

    @Override
    public String toString() {
       String y=" x= ";
        for (int i = 32; i >=1 ; i--) {
            y=y+" "+getbit(i);
       }
        return (y);
    }

}