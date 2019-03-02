import java.util.*;
class Main {
  public static void main(String[] args) {

    ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(-99,1,2,3,4,5,6,7,8,9,10,5));
    ListSumFirst test = new ListSumFirst();
    test.setArray(numList);
    test.sum();
    System.out.println(test);
  }
}
