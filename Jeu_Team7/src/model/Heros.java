package model;

import java.awt.event.KeyEvent;

import engine.Cmd;

public class Heros  {
	int[]pos;
	public int Hp = 3;
	
	Heros( int Hp ){
		this.Hp = Hp;
	}
	public void perdpointdevie(int n) {
		this.Hp=this.Hp-n;
	}

}