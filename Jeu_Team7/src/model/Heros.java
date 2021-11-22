package model;

import java.awt.event.KeyEvent;

import engine.Cmd;

public class Heros extends Jeu {
	int[]pos;
	public int Hp = 3;
	
	Heros( String source, int Hp ){
		super(source);
		this.Hp = Hp;
	}
	
	public int[] getPosition(int niveau){
		int[] position=super.getPosHeros(niveau);
		return position;
	}
	


}