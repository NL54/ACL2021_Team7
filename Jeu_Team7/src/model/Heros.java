package model;


public class Heros  {
	public String image;
	int[]pos;
	public int Hp = 3;
	
	Heros( int Hp ){
		this.Hp = Hp;
		this.image = "heros";
	}
	public void perdpointdevie(int n) {
		this.Hp=this.Hp-n;
	}

}
