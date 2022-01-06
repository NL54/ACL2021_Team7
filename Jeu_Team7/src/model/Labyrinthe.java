package model;

public class Labyrinthe {
	private int difficulte;
	public int niveaumax;
	public int hpmax;
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
	public int Hpmax() {
		if (this.difficulte==1) {
			this.hpmax =3;
		}
		if (this.difficulte==2) {
			this.hpmax =4;
		}
		if (this.difficulte==3) {
			this.hpmax =5;
		}
		return this.hpmax;
	}
}
