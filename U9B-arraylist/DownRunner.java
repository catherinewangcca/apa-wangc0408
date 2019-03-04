//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.*;

class Main {
  public static void main(String[] args) {
    ArrayList<Integer> entries = new ArrayList<Integer>(Arrays.asList(9,10,-8,10000,-5000,1000));
    ListDown test = new ListDown();
    test.setArray(entries);
    test.checkOrder();
    System.out.print(test);
  }
}
