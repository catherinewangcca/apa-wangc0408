//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.*;
class Main {
  public static void main(String[] args) {
  ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(32767,70,4,5,6,7)); 
  ListOddToEven test = new ListOddToEven();
  test.setArray(numList);
  test.oddEvenDistance();
  System.out.print(test.toString());

  }
}
