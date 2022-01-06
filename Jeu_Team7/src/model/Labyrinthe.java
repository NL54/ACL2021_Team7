package model;

public class Labyrinthe {
	private int difficulte;
	public int niveaumax;
	public Labyrinthe(int difficulte){
		this.difficulte=difficulte;
		
	}
	public int Niveaumax() {
		if (this.difficulte==1) {
			this.niveaumax =1;
		}
		if (this.difficulte==2) {
			this.niveaumax =3;
		}
		if (this.difficulte==3) {
			this.niveaumax =5;
		}
		return this.niveaumax;
	}
}
