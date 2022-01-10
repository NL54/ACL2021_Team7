package model;


public class Heros  {

	public int Hp = 3;
	
	Heros( int Hp ){
		this.Hp = Hp;
	}
	public void perdpointdevie(int n) {
		this.Hp=this.Hp-n;
	}

}
