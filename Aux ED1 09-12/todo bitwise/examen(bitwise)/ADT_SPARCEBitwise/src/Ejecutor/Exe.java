package Ejecutor;

import Clase.SparceBitwise;

public class Exe {

  public static void main(String[] args) {
    SparceBitwise A=new SparceBitwise(3, 3, 60, 100, 60);
    A.Setdata(1, 1, 73);
    A.Setdata(1, 3, 85);
    A.Setdata(3, 1, 99);
    A.Setdata(3, 3, 81);
    A.Setdata(2, 2, 65);
    System.out.println(A.toString());
  }
}
