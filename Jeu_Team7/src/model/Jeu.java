package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import engine.Cmd;
import engine.Game;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class Jeu implements Game {
	

	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	
	Plateau1 p1;
	Plateau2 p2;
	int niveau;
	public Jeu(String source) {
		
		p1 = new Plateau1();
		p2= new Plateau2();
	
		niveau=1;
		BufferedReader helpReader;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
				System.out.println(ligne);
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
		System.out.println("Execute "+commande);
		if (commande==Cmd.LEFT) {
		
			
			//if (activePassage(niveau,"droite")) {// normalement c'est gauche mais on test la droite
				//niveau+=1;} 
			//p1.plateau[getPosHeros(niveau)[0]][getPosHeros(niveau)[1]+1]=2;
			//p1.plateau[getPosHeros(niveau)[0]][getPosHeros(niveau)[1]]=0;
			//if (activePiege(niveau,"droite")) {
				//heros perd 1pv
			//}
			//if (activeMagie(niveau,"droite")) {
				//niveau+=1;
				//p1.plateau[1][1]=0;
				//p1.plateau[1][2]=0;
				//} 
			
			
		}
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		// le jeu n'est jamais fini
		return false;
	}
	public int[] getPosHeros(int niveau) {
		int pos =0;
		int x=0;
		int y=0;
		for (int i=0; i<p1.taille ;i++) {
			for (int j=0; j<p1.taille ;j++) {
				if (niveau==1) {
					if (p1.plateau[j][i]==2) {;
						pos= p1.plateau[j][i];
						x=i;
						y=j;
					}
				}
				if (niveau==2) {
					if (p2.plateau[j][i]==2) {;
						pos= p2.plateau[j][i];
						x=i;
						y=j;
					}
				}
			}
	}
		int position []= {x,y};
		return position ;
	}
	public int getPos(int[] position,int niveau) { // permet d'obtenir ce qu'il y a à un endroit
		int pos=0;
		int x=position[0];
		int y=position[1];
		if (niveau==1) {
			pos=p1.plateau[y][x];
					}
		if(niveau==2) {
			pos=p2.plateau[y][x];
		}
		return pos;
	}
	public boolean activePassage(int niveau,String direction) {
		int [] posfutur = new int[2];
		if (direction == "droite") {
			posfutur[0]= getPosHeros(niveau)[0]+1;
			posfutur[1]= getPosHeros(niveau)[1];
		}
		if (getPos(posfutur,niveau)==5) {
			return true;
		}
		return false;
	}
	public boolean activeMagie(int niveau,String direction) {
		int [] posfutur = new int[2];
		if (direction == "droite") {
			posfutur[0]= getPosHeros(niveau)[0]+1;
			posfutur[1]= getPosHeros(niveau)[1];
		}
		if (getPos(posfutur,niveau)==5) {
			return true;
		}
		return false;
	}
	public boolean activePiege(int niveau,String direction) {
		int [] posfutur = new int[2];
		if (direction == "droite") {
			posfutur[0]= getPosHeros(niveau)[0]+1;
			posfutur[1]= getPosHeros(niveau)[1];
		}
		if (getPos(posfutur,niveau)==5) {
			return true;
		}
		return false;
	}

}
