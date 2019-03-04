import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class NumberShifter{
   int[] numArray = new int[6];
   int[] returnArray = new int[6];
   int count = 0;

  public NumberShifter(){

  }
  public NumberShifter(int rArray[]){
    setArray(rArray);
  }

  public void setArray(int rArray[]){
    numArray = rArray;
  }

  public void moveSevens(){
    for (int i = 0; i<numArray.length; i++){
      if (numArray[i] == 7)
      {
        returnArray[count] = numArray[i];
        count++;
      }
    }
    for (int x = 0; x<numArray.length; x++){
      if (numArray[x] != 7)
      {
        returnArray[count] = numArray[x];
        count++;
      }
    }
  }

  public String toString(){
    return Arrays.toString(returnArray);
  }

}
