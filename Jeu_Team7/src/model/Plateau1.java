package model;

public class Plateau1 {
	int taille;
	int [][] plateau;
	public Plateau1() {
		//1= mur 2= heros 3 piege 4=magie 5=passage 6=tresor
		
		plateau = new int[][] {
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,2,4,1,0,0,0,0,0,0,0,0,0,1,0,0,0,5,1},
		{1,0,0,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,1},
		{1,0,0,1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1},
		{1,0,0,1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1},
		{1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,1,0,0,0,0,0,0,0,0,1,1,1,1,0,0,1},
		{1,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,0,0,1},
		{1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1,1},
		{1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
		{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
		{1,1,1,1,0,0,0,0,0,0,0,0,0,0,3,1,0,0,1},
		{1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1,1},
		{1,0,0,0,0,0,0,1,0,0,0,0,3,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	};
		taille=plateau.length;
		
	}
	public void activemagie() {
		
	}
	
}
