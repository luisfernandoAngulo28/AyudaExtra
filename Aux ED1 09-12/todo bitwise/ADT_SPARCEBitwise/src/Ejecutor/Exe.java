package Ejecutor;

/*
 * @author Aux INF220 - 2/2016
*/

import Clase.SparceBitwise;

public class Exe {

  public static void main(String[] args) {
    SparceBitwise A=new SparceBitwise(3, 3, 60, 100, 0);
    A.Setdata(1, 1, 5);
    A.Setdata(1, 3, 90);
    A.Setdata(3, 1, 100);
    A.Setdata(3, 3, 81);
    A.Setdata(2, 2, 65);
    System.out.println(A.toString());
  }
}
