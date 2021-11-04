import java.util.ArrayList;
import java.util.List;

public class Plateau {
	int taille=7;
	
	int[][] plateau=new int[taille][taille];
	List positionpiege = new ArrayList();
	List positiontresor = new ArrayList();
	List positionmagique = new ArrayList();
	List positionpassage = new ArrayList();
	
	
	public int[][] genererPlateau0(){ // génère un plateau avec uniquement des zeros (pas de murs, piege,magique,tresor)
		for (int i = 0; i < taille; i++) {
		      for (int j = 0; j < taille; j++) {
		        plateau[i][j] = 0;}
		}
		return plateau;
	
	}
	public int[][] genererPlateau1(){
		int[][]plateau1=plateau;
		plateau1[5][2]=1;
		plateau1[4][2]=1;
		plateau1[3][3]=1;
		plateau1[2][3]=1;
		plateau1[1][4]=1;
		plateau1[1][5]=1;
		plateau1[5][2]=1;
		plateau1[5][2]=1;
		plateau1[5][2]=1;
		plateau1[5][2]=1;
		return plateau1;
	}
	
}