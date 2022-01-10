package model;
import java.util.ArrayList;
import java.util.Random;

public class Monstre{
	public int point_de_vie;
	public int position_x;
	public int position_y;
	
	
	public Monstre(int point_de_vie, int position_x, int position_y) {
		this.point_de_vie = point_de_vie;
		this.position_x = position_x;
		this.position_y = position_y;
	}
	public boolean testVivant() {
		return (point_de_vie > 0);
	}
	public void subirDegat() {
		this.point_de_vie = Math.max(this.point_de_vie - 1, 0);
	}
	public int genererInt2(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf+random.nextInt(borneSup-borneInf+1);
        return nb;
     }
	public int getX () {
		return this.position_x;
		
	}
	public int getY () {
		return this.position_y;
	}
}