import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private  String[] wordRay;

  public WordSortTwo()
	{
	}

	public WordSortTwo(String sentence)
	{
    wordRay = sentence.split(" ");
	}

	public void sort()
	{
    Arrays.sort(wordRay);
	}

	public String toString()
	{
		String output=Arrays.toString(wordRay);
		return output+"\n\n";
	}
}
