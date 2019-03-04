//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.*;

public class ListDown{
  ArrayList<Integer> numbers = new ArrayList<Integer>();
  boolean descend = true;

  public ListDown(){

  }

  public ListDown(ArrayList<Integer> ray){
    setArray(ray);
  }

  public void setArray(ArrayList<Integer> ray){
    numbers = ray;
  }

  public void checkOrder(){
    for (int i = 0; i<numbers.size()-1; i++){
      if (numbers.get(i)<numbers.get(i+1)){
        descend = false;
        break;
      }
    }
  }

  public String toString(){
    return descend + "";
  }
}
