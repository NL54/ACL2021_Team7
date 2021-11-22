package model;
import java.util.*;
public class Monstre {
	public int[] position;
	public int pv=1;
	public int type;
	
	Monstre(int[]position,int pv,int type){
		this.position=position;
		this.pv=pv;
		this.type=type;
	}
	
	public int[] getPosition() {
		return position;
	}
	
	public void deplacer() {
		position=getPosition();
		
		Random ran=new Random();
		
		int nxt= ran.nextInt(4);
		
		if(nxt==0) {             //le monstre va a gauche
			position[0]-=1;
		}
		if(nxt==1) {			// le monstre va droite
			position[0]+=1;
		}
		if(nxt==2) {
			position[1]+=1;		//le monstre va en haut
		}
		if(nxt==3) {
			position[1]-=1;
		}
	}
	
	

}