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
	//Heros h=new Heros ("helpFilePacman.txt",3);
	Plateau1 p1;
	Plateau2 p2;
	Heros h;
	int niveau;
	public boolean fin;
	public Jeu(String source) {
		fin=false;
		p1 = new Plateau1();
		p2= new Plateau2();
		h=new Heros(3);
	
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
		if (commande==Cmd.RIGHT) {
			if (activePassage(niveau,commande)) {
				niveau+=1;
				} 
			
			else if (activeMagie(niveau,commande)) {
				p1.plateau[1][1]=2;
				
				p1.plateau[getPosHeros(niveau)[1]][getPosHeros(niveau)[0]]=0;
				} 
			else if (activePiege(niveau,commande)) {
				h.perdpointdevie(1);
				deplacer(commande,niveau);
				}
			else if (Tresor(niveau,commande)) {
				fin=true;
				System.out.println("BRAVO TU AS GAGNE");
			}
	
				deplacer(commande,niveau);
		
			
				} 
		if(commande==Cmd.LEFT) {
			if (activePassage(niveau,commande)) {
				niveau+=1;
				} 
			
			else if (activeMagie(niveau,commande)) {
				p1.plateau[1][1]=2;
				if ((getPosHeros(niveau)[0] != 1) && (getPosHeros(niveau)[1]!=1))
					{p1.plateau[getPosHeros(niveau)[1]][getPosHeros(niveau)[0]]=0;}
				} 
			else if (activePiege(niveau,commande)) {
				h.perdpointdevie(1);
				deplacer(commande,niveau);
				}
			else if (Tresor(niveau,commande)) {
				fin=true;
				System.out.println("BRAVO TU AS GAGNE");
			}
			
				deplacer(commande,niveau);
			
			
				} 
		if(commande==Cmd.UP) {
			if (activePassage(niveau,commande)) {
				niveau+=1;
				} 
			
			else if (activeMagie(niveau,commande)) {
				p1.plateau[1][1]=2;
				if ((getPosHeros(niveau)[0] != 1) && (getPosHeros(niveau)[1]!=1))
					{p1.plateau[getPosHeros(niveau)[1]][getPosHeros(niveau)[0]]=0;}
				} 
			else if (activePiege(niveau,commande)) {
				h.perdpointdevie(1);
				deplacer(commande,niveau);
				}
			else if (Tresor(niveau,commande)) {
				fin=true;
				System.out.println("BRAVO TU AS GAGNE");
			}
		
			deplacer(commande,niveau);
			
			
				} 
		if(commande==Cmd.DOWN) {
			if (activePassage(niveau,commande)) {
				niveau+=1;
				} 
			
			else if (activeMagie(niveau,commande)) {
				p1.plateau[1][1]=2;
				if ((getPosHeros(niveau)[0] != 1) && (getPosHeros(niveau)[1]!=1))
					{p1.plateau[getPosHeros(niveau)[1]][getPosHeros(niveau)[0]]=0;}
				} 
			else if (activePiege(niveau,commande)) {
				h.perdpointdevie(1);
				deplacer(commande,niveau);
				}
			else if (Tresor(niveau,commande)) {
				fin=true;
				System.out.println("BRAVO TU AS GAGNE");
			}
			deplacer(commande,niveau);
			
			
				} 
			
		
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		if (fin==true) {
			return true;
			} 
		else {
			return false;
		}
		
		
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
	public boolean activePassage(int niveau,Cmd commande) {
		int [] posfutur = new int[2];
		if (commande == Cmd.RIGHT) {
			posfutur[0]= getPosHeros(niveau)[0]+1;
			posfutur[1]= getPosHeros(niveau)[1];
		}
		if (commande == Cmd.LEFT) {
			posfutur[0]= getPosHeros(niveau)[0]-1;
			posfutur[1]= getPosHeros(niveau)[1];
		}
		if (commande == Cmd.UP) {
			posfutur[0]= getPosHeros(niveau)[0];
			posfutur[1]= getPosHeros(niveau)[1]-1;
		}
		if (commande == Cmd.DOWN) {
			posfutur[0]= getPosHeros(niveau)[0];
			posfutur[1]= getPosHeros(niveau)[1]+1;
		}
		if (getPos(posfutur,niveau)==5) {
			return true;
		}
		return false;
	}
	
	public boolean activeMagie(int niveau,Cmd commande) {
		int [] posfutur = new int[2];
		if (commande == Cmd.RIGHT) {
			posfutur[0]= getPosHeros(niveau)[0]+1;
			posfutur[1]= getPosHeros(niveau)[1];
		}
		if (commande == Cmd.LEFT) {
			posfutur[0]= getPosHeros(niveau)[0]-1;
			posfutur[1]= getPosHeros(niveau)[1];
		}
		if (commande == Cmd.UP) {
			posfutur[0]= getPosHeros(niveau)[0];
			posfutur[1]= getPosHeros(niveau)[1]-1;
		}
		if (commande == Cmd.DOWN) {
			posfutur[0]= getPosHeros(niveau)[0];
			posfutur[1]= getPosHeros(niveau)[1]+1;
		}
		if (getPos(posfutur,niveau)==4) {
			return true;
		}
		return false;
	}
	public boolean activePiege(int niveau,Cmd commande) {
		int [] posfutur = new int[2];
		if (commande == Cmd.RIGHT) {
			posfutur[0]= getPosHeros(niveau)[0]+1;
			posfutur[1]= getPosHeros(niveau)[1];
		}
		if (commande == Cmd.LEFT) {
			posfutur[0]= getPosHeros(niveau)[0]-1;
			posfutur[1]= getPosHeros(niveau)[1];
		}
		if (commande == Cmd.UP) {
			posfutur[0]= getPosHeros(niveau)[0];
			posfutur[1]= getPosHeros(niveau)[1]-1;
		}
		if (commande == Cmd.DOWN) {
			posfutur[0]= getPosHeros(niveau)[0];
			posfutur[1]= getPosHeros(niveau)[1]+1;
		}
		if (getPos(posfutur,niveau)==3) {
			return true;
		}
		return false;
	}
	public boolean Tresor(int niveau,Cmd commande) {
		int [] posfutur = new int[2];
		if (commande == Cmd.RIGHT) {
			posfutur[0]= getPosHeros(niveau)[0]+1;
			posfutur[1]= getPosHeros(niveau)[1];
		}
		if (commande == Cmd.LEFT) {
			posfutur[0]= getPosHeros(niveau)[0]-1;
			posfutur[1]= getPosHeros(niveau)[1];
		}
		if (commande == Cmd.UP) {
			posfutur[0]= getPosHeros(niveau)[0];
			posfutur[1]= getPosHeros(niveau)[1]-1;
		}
		if (commande == Cmd.DOWN) {
			posfutur[0]= getPosHeros(niveau)[0];
			posfutur[1]= getPosHeros(niveau)[1]+1;
		}
		if (getPos(posfutur,niveau)==6) {
			return true;
		}
		return false;
	}
	
	//methode pour deplacer le hero
	int[]pos;
	public void deplacer(Cmd commande, int niveau){
		if (commande==Cmd.LEFT) {
			pos=getPosHeros(niveau);
			if(niveau==1) {
				
				if(p1.plateau[pos[1]][pos[0]-1]!=1){
					p1.plateau[pos[1]][pos[0]-1]=2;
					p1.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
			if(niveau==2) {
				if(p2.plateau[pos[1]][pos[0]-1]!=1){
					p2.plateau[pos[1]][pos[0]-1]=2;
					p2.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
		}
		if (commande==Cmd.RIGHT) {
			pos=getPosHeros(niveau);
			if(niveau==1) {
				System.out.println(pos[0]);
				System.out.println(pos[1]);
				if(p1.plateau[pos[1]][pos[0]+1]!=1){
					p1.plateau[pos[1]][pos[0]+1]=2;
					p1.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
			if(niveau==2) {
				if(p2.plateau[pos[1]][pos[0]+1]!=1){
					p2.plateau[pos[1]][pos[0]+1]=2;
					p2.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
		}
		if (commande==Cmd.UP) {
			pos=getPosHeros(niveau);
			if(niveau==1) {
				if(p1.plateau[pos[1]-1][pos[0]]!=1){
					p1.plateau[pos[1]-1][pos[0]]=2;
					p1.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
			if(niveau==2) {
				if(p2.plateau[pos[1]-1][pos[0]]!=1){
					p2.plateau[pos[1]-1][pos[0]]=2;
					p2.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
		}
		if (commande==Cmd.DOWN) {
			pos=getPosHeros(niveau);
			if(niveau==1) {
				if(p1.plateau[pos[1]+1][pos[0]]!=1){
					p1.plateau[pos[1]+1][pos[0]]=2;
					p1.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
			if(niveau==2) {
				if(p2.plateau[pos[1]+1][pos[0]]!=1){
					p2.plateau[pos[1]+1][pos[0]]=2;
					p2.plateau[pos[1]][pos[0]]=0;
					
				}
				
			}
		}
		
	}
	public void attaquer(Cmd commande, int niveau) {
		pos=getPosHeros(niveau);
		if(commande==Cmd.ATT) {
			if(niveau ==1) {
				if(p1.plateau[pos[1]+1][pos[0]]==7) {
					p1.plateau[pos[1]+1][pos[0]]=0;
				}
				
				if(p1.plateau[pos[1]-1][pos[0]]==7) {
					p1.plateau[pos[1]-1][pos[0]]=0;
				}
				if(p1.plateau[pos[1]][pos[0]-1]==7) {
					p1.plateau[pos[1]][pos[0]-1]=0;
				}
				if(p1.plateau[pos[1]][pos[0]+1]==7) {
					p1.plateau[pos[1]][pos[0]+1]=0;
				}
			}
			if(niveau==2) {
				if(p2.plateau[pos[1]+1][pos[0]]==7) {
					p2.plateau[pos[1]+1][pos[0]]=0;
				}
				
				if(p2.plateau[pos[1]-1][pos[0]]==7) {
					p2.plateau[pos[1]-1][pos[0]]=0;
				}
				if(p2.plateau[pos[1]][pos[0]-1]==7) {
					p2.plateau[pos[1]][pos[0]-1]=0;
				}
				if(p2.plateau[pos[1]][pos[0]+1]==7) {
					p2.plateau[pos[1]][pos[0]+1]=0;
				}
			}
		}
	}


}
