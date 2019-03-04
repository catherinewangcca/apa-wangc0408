import java.util.*;
import java.io.*;
import static java.lang.System.*;

class Main {
  public static void main(String[] args) {

    int[] testArray = {5, 6, 7, 3, 7, 2};
    NumberShifter test = new NumberShifter();
    test.setArray(testArray);
    test.moveSevens();
    System.out.println(test);
  }
}

