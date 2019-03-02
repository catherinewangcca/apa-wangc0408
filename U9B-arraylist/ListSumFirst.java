import java.util.List;
import java.util.ArrayList;

public class ListSumFirst{
  public int total = 0;
  ArrayList<Integer> numbers = new ArrayList<Integer>();

  public ListSumFirst(){
  }

  public ListSumFirst(ArrayList<Integer> ray){
    setArray(ray);
  }

  public void setArray(ArrayList<Integer> ray){
    numbers = ray;
  }

  public void sum(){
    for (int i = 0; i<numbers.size(); i++)
    {
      if (numbers.get(i)>numbers.get(0))
      {
        total += numbers.get(i);
      }
    }
  }

  public String toString(){
    return total + ""; 
  }
}
