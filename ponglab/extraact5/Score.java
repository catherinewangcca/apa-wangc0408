public class Score{

	private int points = 0;
	private String pName = "";

	public Score(){
		pName = "Player One";
	}

	public Score(String name){
		pName = name;
	}

	public int getPoints(){
		return points;
	}

	public void addPoints(){
		points++;
	}

	public void setPoints(int pts){
		points = pts;
	}

	public String toString(){
		return pName + " " + points;
	}
}