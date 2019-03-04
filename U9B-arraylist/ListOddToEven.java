//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.*;

public class ListOddToEven{
  ArrayList<Integer> numbers = new ArrayList<Integer>();

  int distance = -1;
  int odd = -1;
  int even = -1;

public ListOddToEven(){
}

public ListOddToEven(ArrayList<Integer> ray){
  setArray(ray);
}

public void setArray(ArrayList<Integer> ray){
  numbers = ray;
}

public void oddEvenDistance(){
  for (int i = 0; i<numbers.size(); i++){
    if (numbers.get(i) % 2 == 1)
    {
      odd = i;
      break;
    }
  }
  for (int x = numbers.size()-1; x>=0; x--){
    if (numbers.get(x) % 2 == 0)
    {
      even = x;
      break;
    }
  }  
  if (odd != -1 && even != -1)
  {
    distance = even - odd;
  }
}


public String toString(){
  return distance + "";
}

}
