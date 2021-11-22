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
	

	public void deplacer(Cmd commande, int niveau){
		if (commande==Cmd.LEFT) {
			pos=getPosition(niveau);
			if(niveau==1) {
				if(super.p1.plateau[pos[1]][pos[0]-1]!=1){
					p1.plateau[pos[1]][pos[0]-1]=2;
					p1.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
			if(niveau==2) {
				if(super.p2.plateau[pos[1]][pos[0]-1]!=1){
					p2.plateau[pos[1]][pos[0]-1]=2;
					p2.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
		}
		if (commande==Cmd.RIGHT) {
			pos=getPosition(niveau);
			if(niveau==1) {
				if(super.p1.plateau[pos[1]][pos[0]+1]!=1){
					p1.plateau[pos[1]][pos[0]+1]=2;
					p1.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
			if(niveau==2) {
				if(super.p2.plateau[pos[1]][pos[0]+1]!=1){
					p2.plateau[pos[1]][pos[0]+1]=2;
					p2.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
		}
		if (commande==Cmd.UP) {
			pos=getPosition(niveau);
			if(niveau==1) {
				if(super.p1.plateau[pos[1]-1][pos[0]]!=1){
					p1.plateau[pos[1]-1][pos[0]-1]=2;
					p1.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
			if(niveau==2) {
				if(super.p2.plateau[pos[1]-1][pos[0]]!=1){
					p2.plateau[pos[1]-1][pos[0]-1]=2;
					p2.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
		}
		if (commande==Cmd.DOWN) {
			pos=getPosition(niveau);
			if(niveau==1) {
				if(super.p1.plateau[pos[1]+1][pos[0]]!=1){
					p1.plateau[pos[1]+1][pos[0]-1]=2;
					p1.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
			if(niveau==2) {
				if(super.p2.plateau[pos[1]+1][pos[0]]!=1){
					p2.plateau[pos[1]+1][pos[0]]=2;
					p2.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
		}
		
	}
	
	public void attaquer(Cmd commande, int niveau) {
		pos=getPosition(niveau);
		if(commande==Cmd.ATT) {
			if(niveau==1 && super.p1.plateau[pos[1]+1][pos[0]]==7) {
				
			}
		}
	}
}