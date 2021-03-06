package model;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Test.ErreurJeu;

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
public class Jeu extends Labyrinthe implements Game  {
	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	//Heros h=new Heros ("helpFilePacman.txt",3);
	public Plateau1 p1;
	public Plateau2 p2;
	public Plateau3 p3;
	public Plateau1avecfin p1f;
	public Plateau3avecfin p3f;
	public Plateau4 p4;
	public Plateau5 p5;
	public Heros h;
	ghost g = new ghost(1, 8, 9);
	Monstre M = new Monstre(1,16,17);
	Monstre M2 = new Monstre(1,4,10);
	int niveau;
	public boolean fin;
	int niveaumax;
	int hpmax;

	boolean gagner;
	public Jeu(String source,int diff) {
		super(diff);
		niveaumax=super.Niveaumax();
		hpmax=super.Hpmax();
		h= new Heros(hpmax);
		fin=false;
		p1 = new Plateau1();
		p2= new Plateau2();
		p3=new Plateau3();
		p4=new Plateau4();
		p5=new Plateau5();
		p1f=new Plateau1avecfin();
		p3f=new Plateau3avecfin();
		h=new Heros(3);
	
		gagner=false;
		if (diff==0) {
			niveau=0;
		}
		else {
			niveau=1;
		}
		
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
	 * @throws ErreurHeros 
	 */
	@Override
	public void evolve(Cmd commande) {
		System.out.println("Execute "+commande);
		System.out.println("Execute "+commande);
		if (mort()) {
			fin=true;
		}
		if (commande==Cmd.ATT) {
			try {
				attaquer(niveau);
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (commande==Cmd.RIGHT) {
			try {
				if (activePassage(niveau,commande)) {
					niveau+=1;
					} 
				
				else if (activeMagie(niveau,commande)) {
					if (niveau==1) {
					p1.plateau[1][1]=2;
					
					p1.plateau[getPosHeros(niveau)[1]][getPosHeros(niveau)[0]]=0;
					}
					if (niveau==2) {
						p2.plateau[1][1]=2;
						
						p2.plateau[getPosHeros(niveau)[1]][getPosHeros(niveau)[0]]=0;
						}
					if (niveau==3) {
						p3.plateau[1][1]=2;
						
						p3.plateau[getPosHeros(niveau)[1]][getPosHeros(niveau)[0]]=0;
						}
					if (niveau==4) {
						p4.plateau[1][1]=2;
						
						p4.plateau[getPosHeros(niveau)[1]][getPosHeros(niveau)[0]]=0;
						}
					if (niveau==5) {
						p5.plateau[1][1]=2;
						
						p5.plateau[getPosHeros(niveau)[1]][getPosHeros(niveau)[0]]=0;
						}
					} 
				else if (activePiege(niveau,commande)) {
					h.perdpointdevie(1);
		
				
					}
				else if (Tresor(niveau,commande)) {
					gagner=true;
					fin=true;
					System.out.println("BRAVO TU AS GAGNE");
				}
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
				try {
					deplacer(commande,niveau);
				} catch (ErreurHeros e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					deplace_monstre(M,h);
				} catch (ErreurHeros e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					deplace_monstre(M2,h);
				} catch (ErreurHeros e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					deplace_ghost(g,h);
				} catch (ErreurHeros e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(M.getX()+'/'+M.getY());
		
			
				} 
		if(commande==Cmd.LEFT) {
			try {
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
					
					}
				else if (Tresor(niveau,commande)) {
					gagner=true;
					fin=true;
					System.out.println("BRAVO TU AS GAGNE");
				}
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				try {
					deplacer(commande,niveau);
				} catch (ErreurHeros e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					deplace_monstre(M,h);
				} catch (ErreurHeros e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					deplace_monstre(M2,h);
				} catch (ErreurHeros e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					deplace_ghost(g,h);
				} catch (ErreurHeros e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(M.getX()+'/'+M.getY());
			
			
				} 
		if(commande==Cmd.UP) {
			try {
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
				
					}
				else if (Tresor(niveau,commande)) {
					gagner=true;
					fin=true;
					System.out.println("BRAVO TU AS GAGNE");
				}
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			try {
				deplacer(commande,niveau);
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				deplace_monstre(M,h);
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				deplace_monstre(M2,h);
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				deplace_ghost(g,h);
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(M.getX()+'/'+M.getY());
			
			
				} 
		if(commande==Cmd.DOWN) {
			try {
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
				
					}
				else if (Tresor(niveau,commande)) {
					gagner=true;
					fin=true;
					System.out.println("BRAVO TU AS GAGNE");
				}
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				deplacer(commande,niveau);
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				deplace_monstre(M,h);
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				deplace_monstre(M2,h);
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				deplace_ghost(g,h);
			} catch (ErreurHeros e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(M.getX()+'/'+M.getY());
			
			
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
	public  int[] getPosHeros(int niveau) throws ErreurHeros {
		int x = -100;
		int y= -100;
		for (int i=0; i<p1.taille ;i++) {
			for (int j=0; j<p1.taille ;j++) {
				if (niveau==niveaumax) {
					if (niveau==1) {
						if (p1f.plateau[j][i]==2) {
							x=i;
							y=j;
						}
					}
					if (niveau==3) {
						if (p3f.plateau[j][i]==2) {
							x=i;
							y=j;
						}
					}
					if (niveau==5) {
						if (p5.plateau[j][i]==2) {
							x=i;
							y=j;
						}
					}
				}
				else {
					if (niveau==1) {
						if (p1.plateau[j][i]==2) {
							x=i;
							y=j;
						}
					}
					if (niveau==2) {
						if (p2.plateau[j][i]==2) {
							x=i;
							y=j;
						}
					}
					if (niveau==3) {
						if (p3.plateau[j][i]==2) {
							x=i;
							y=j;
						}
					}
					if (niveau==4) {
						if (p4.plateau[j][i]==2) {
							x=i;
							y=j;
						}
					}
					if (niveau==5) {
						if (p5.plateau[j][i]==2) {
							x=i;
							y=j;
						}
					}
				}
			}
	}
	if (x==-100 && y==-100) {
		throw new ErreurHeros();
	}
		int position []= {x,y};
		return position ;
	}
	public int getPos(int[] position,int niveau) { // permet d'obtenir ce qu'il y a ? un endroit
		int pos=0;
		int x=position[0];
		int y=position[1];
		if (niveau==niveaumax) {
			if (niveau==1) {
				pos=p1f.plateau[y][x];
						}
			if (niveau==3) {
				pos=p3f.plateau[y][x];
						}
			if (niveau==5) {
				pos=p5.plateau[y][x];
						}
		}
		else {
			if (niveau==1) {
				pos=p1.plateau[y][x];
						}
			if(niveau==2) {
				pos=p2.plateau[y][x];
			}
			if(niveau==3) {
				pos=p3.plateau[y][x];
			}
			if(niveau==4) {
				pos=p4.plateau[y][x];
			}
			if(niveau==5) {
				pos=p5.plateau[y][x];
			}
		}
		return pos;
	}
	public boolean activePassage(int niveau,Cmd commande) throws ErreurHeros {
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
	
	public boolean activeMagie(int niveau,Cmd commande) throws ErreurHeros {
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
	public boolean activePiege(int niveau,Cmd commande) throws ErreurHeros {
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
	public boolean Tresor(int niveau,Cmd commande) throws ErreurHeros {
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
	public boolean mort() {
		if (h.Hp==0) {
			return true;
		}
		return false;
	}
	//methode pour deplacer le hero
	int[]pos;
	public void deplacer(Cmd commande, int niveau) throws ErreurHeros{
		if (commande==Cmd.LEFT) {
			pos=getPosHeros(niveau);
			if (pos[0]-1>=p1f.plateau.length) {
				throw new ErreurHeros();
			}
			if (pos[0]-1<0) {
				throw new ErreurHeros();
			}
			if (niveau==niveaumax) {
				if(niveau==1) {
					
					if(p1f.plateau[pos[1]][pos[0]-1]!=1){
						if (p1f.plateau[pos[1]][pos[0]-1]!=10) {
						p1f.plateau[pos[1]][pos[0]-1]=2;
						p1f.plateau[pos[1]][pos[0]]=0;
						
					}
					}
				}
					if(niveau==3) {
						
						if(p3f.plateau[pos[1]][pos[0]-1]!=1){
							if (p3f.plateau[pos[1]][pos[0]-1]!=10) {
							p3f.plateau[pos[1]][pos[0]-1]=2;
							p3f.plateau[pos[1]][pos[0]]=0;
							
						}

			}
					}
					if(niveau==5) {
						
						if(p5.plateau[pos[1]][pos[0]-1]!=1){
							if (p5.plateau[pos[1]][pos[0]-1]!=10) {
							p5.plateau[pos[1]][pos[0]-1]=2;
							p5.plateau[pos[1]][pos[0]]=0;
							
						}

			}
					}
			
			}
			else {
				if(niveau==1) {
					
					if(p1.plateau[pos[1]][pos[0]-1]!=1){
						if (p1.plateau[pos[1]][pos[0]-1]!=10) {
						p1.plateau[pos[1]][pos[0]-1]=2;
						p1.plateau[pos[1]][pos[0]]=0;
						
					}
					}
				}
				if(niveau==2) {
					if(p2.plateau[pos[1]][pos[0]-1]!=1){
						if (p2.plateau[pos[1]][pos[0]-1]!=10){
						p2.plateau[pos[1]][pos[0]-1]=2;
						p2.plateau[pos[1]][pos[0]]=0;
						
					}
					}
				}
				if(niveau==3) {
					if(p3.plateau[pos[1]][pos[0]-1]!=1){
						if (p3.plateau[pos[1]][pos[0]-1]!=10){
						p3.plateau[pos[1]][pos[0]-1]=2;
						p3.plateau[pos[1]][pos[0]]=0;
					}
				}
				}
				if (niveau==4) {
					if(p4.plateau[pos[1]][pos[0]-1]!=1){
						if (p4.plateau[pos[1]][pos[0]-1]!=10){
						p4.plateau[pos[1]][pos[0]-1]=2;
						p4.plateau[pos[1]][pos[0]]=0;
				}
				}
				}
				if (niveau==5) {
					if(p5.plateau[pos[1]][pos[0]-1]!=1){
						if (p5.plateau[pos[1]][pos[0]-1]!=10){
						p5.plateau[pos[1]][pos[0]-1]=2;
						p5.plateau[pos[1]][pos[0]]=0;
				}
						
		}
		}
		}
					}
		
		if (commande==Cmd.RIGHT) {
			pos=getPosHeros(niveau);
			if (pos[0]+1>=p1f.plateau.length) {
				throw new ErreurHeros();
			}
			if (pos[0]+1<0) {
				throw new ErreurHeros();
			}
			if (niveau==niveaumax) {
				if(niveau==1) {
					if(p1f.plateau[pos[1]][pos[0]+1]!=1){
						if(p1f.plateau[pos[1]][pos[0]+1]!=10) {
					
						p1f.plateau[pos[1]][pos[0]+1]=2;
						p1f.plateau[pos[1]][pos[0]]=0;
						
					}
					}
					
				}
				if(niveau==3) {
					if(p3f.plateau[pos[1]][pos[0]+1]!=1){
						if(p3f.plateau[pos[1]][pos[0]+1]!=10) {
					
						p3f.plateau[pos[1]][pos[0]+1]=2;
						p3f.plateau[pos[1]][pos[0]]=0;
						
					}
					}
					
				}
				if(niveau==5) {
					if(p5.plateau[pos[1]][pos[0]+1]!=1){
						if(p5.plateau[pos[1]][pos[0]+1]!=10) {
					
						p5.plateau[pos[1]][pos[0]+1]=2;
						p5.plateau[pos[1]][pos[0]]=0;
						
					}
					}
					
				}
			}
			else {
				if(niveau==1) {
					if(p1.plateau[pos[1]][pos[0]+1]!=1){
						if(p1.plateau[pos[1]][pos[0]+1]!=10) {
					
						p1.plateau[pos[1]][pos[0]+1]=2;
						p1.plateau[pos[1]][pos[0]]=0;
						
					}
					}
					
				}
				if(niveau==2) {
					if(p2.plateau[pos[1]][pos[0]+1]!=1){
						if(p2.plateau[pos[1]][pos[0]+1]!=10){
						p2.plateau[pos[1]][pos[0]+1]=2;
						p2.plateau[pos[1]][pos[0]]=0;
						
					}
					
				}
				}
				if(niveau==3) {
					if(p3.plateau[pos[1]][pos[0]+1]!=1){
						if(p3.plateau[pos[1]][pos[0]+1]!=10){
						p3.plateau[pos[1]][pos[0]+1]=2;
						p3.plateau[pos[1]][pos[0]]=0;
						}
				}
				}
				if(niveau==4) {
					if(p4.plateau[pos[1]][pos[0]+1]!=1){
						if(p4.plateau[pos[1]][pos[0]+1]!=10){
						p4.plateau[pos[1]][pos[0]+1]=2;
						p4.plateau[pos[1]][pos[0]]=0;
				}
				}
				}
				if(niveau==5) {
					if(p5.plateau[pos[1]][pos[0]+1]!=1){
						if(p5.plateau[pos[1]][pos[0]+1]!=10){
						p5.plateau[pos[1]][pos[0]+1]=2;
						p5.plateau[pos[1]][pos[0]]=0;
				}
			}
				}
			}
		}
			if (commande==Cmd.UP) {
				pos=getPosHeros(niveau);
				if (pos[1]-1>=p1f.plateau.length) {
					throw new ErreurHeros();
				}
				if (pos[1]-1<0) {
					throw new ErreurHeros();
				}
				if (niveau==niveaumax) {
					if(niveau==1) {
						if(p1f.plateau[pos[1]-1][pos[0]]!=1){
							if (p1f.plateau[pos[1]-1][pos[0]]!=10) {
							p1f.plateau[pos[1]-1][pos[0]]=2;
							p1f.plateau[pos[1]][pos[0]]=0;
							
						}
						}
						
					}
					if(niveau==3) {
						if(p3f.plateau[pos[1]-1][pos[0]]!=1){
							if (p3f.plateau[pos[1]-1][pos[0]]!=10) {
							p3f.plateau[pos[1]-1][pos[0]]=2;
							p3f.plateau[pos[1]][pos[0]]=0;
							
						}
						}
						
					}
					if(niveau==5) {
						if(p5.plateau[pos[1]-1][pos[0]]!=1){
							if (p5.plateau[pos[1]-1][pos[0]]!=10) {
							p5.plateau[pos[1]-1][pos[0]]=2;
							p5.plateau[pos[1]][pos[0]]=0;
							
						}
						}
						
					}
				}
				else {
					if(niveau==1) {
						if(p1.plateau[pos[1]-1][pos[0]]!=1){
							if (p1.plateau[pos[1]-1][pos[0]]!=10) {
							p1.plateau[pos[1]-1][pos[0]]=2;
							p1.plateau[pos[1]][pos[0]]=0;
							
						}
						}
						
					}
					if(niveau==2) {
						if(p2.plateau[pos[1]-1][pos[0]]!=1){
							if (p2.plateau[pos[1]-1][pos[0]]!=10){
							p2.plateau[pos[1]-1][pos[0]]=2;
							p2.plateau[pos[1]][pos[0]]=0;
							
						}
						}
					}
					if(niveau==3) {
						if(p3.plateau[pos[1]-1][pos[0]]!=1){
							if (p3.plateau[pos[1]-1][pos[0]]!=10){
							p3.plateau[pos[1]-1][pos[0]]=2;
							p3.plateau[pos[1]][pos[0]]=0;
					}
						}
					}
					if(niveau==4) {
						if(p4.plateau[pos[1]-1][pos[0]]!=1){
							if (p4.plateau[pos[1]-1][pos[0]]!=10){
							p4.plateau[pos[1]-1][pos[0]]=2;
							p4.plateau[pos[1]][pos[0]]=0;
					}
					}
					}
					if(niveau==5) {
						if(p5.plateau[pos[1]-1][pos[0]]!=1){
							if (p5.plateau[pos[1]-1][pos[0]]!=10){
							p5.plateau[pos[1]-1][pos[0]]=2;
							p5.plateau[pos[1]][pos[0]]=0;
					}
			
						}
			}
			}
		}
		if (commande==Cmd.DOWN) {
			pos=getPosHeros(niveau);
			if (pos[1]+1>=p1f.plateau.length) {
				throw new ErreurHeros();
			}
			if (pos[1]+1<0) {
				throw new ErreurHeros();
			}
			if (niveau==niveaumax) {
				if(niveau==1) {
					if(p1f.plateau[pos[1]+1][pos[0]]!=1){
						if (p1f.plateau[pos[1]+1][pos[0]]!=10) {
						p1f.plateau[pos[1]+1][pos[0]]=2;
						p1f.plateau[pos[1]][pos[0]]=0;
						
					}
					}
					
				}
				if(niveau==3) {
					if(p3f.plateau[pos[1]+1][pos[0]]!=1){
						if (p3f.plateau[pos[1]+1][pos[0]]!=10) {
						p3f.plateau[pos[1]+1][pos[0]]=2;
						p3f.plateau[pos[1]][pos[0]]=0;
						
					}
					}
					
				}
				if(niveau==5) {
					if(p5.plateau[pos[1]+1][pos[0]]!=1){
						if (p5.plateau[pos[1]+1][pos[0]]!=10) {
						p5.plateau[pos[1]+1][pos[0]]=2;
						p5.plateau[pos[1]][pos[0]]=0;
						
					}
					}
					
				}
			}
			else {
				if(niveau==1) {
					if(p1.plateau[pos[1]+1][pos[0]]!=1 ){
						if (p1.plateau[pos[1]+1][pos[0]]!=10) {
						p1.plateau[pos[1]+1][pos[0]]=2;
						p1.plateau[pos[1]][pos[0]]=0;
						
					}
					}
				}
				if(niveau==2) {
					if(p2.plateau[pos[1]+1][pos[0]]!=1 ){
						if (p2.plateau[pos[1]+1][pos[0]]!=10){
						p2.plateau[pos[1]+1][pos[0]]=2;
						p2.plateau[pos[1]][pos[0]]=0;
						
					}
					}
				}
				if(niveau==3) {
					if(p3.plateau[pos[1]+1][pos[0]]!=1 ){
						if (p3.plateau[pos[1]+1][pos[0]]!=10){
						p3.plateau[pos[1]+1][pos[0]]=2;
						p3.plateau[pos[1]][pos[0]]=0;
				}
				}
				}
				if(niveau==4) {
					if(p4.plateau[pos[1]+1][pos[0]]!=1 ){
						if (p4.plateau[pos[1]+1][pos[0]]!=10){
						p4.plateau[pos[1]+1][pos[0]]=2;
						p4.plateau[pos[1]][pos[0]]=0;
				}
				}
				}
				if(niveau==5) {
					if(p5.plateau[pos[1]+1][pos[0]]!=1 ){
						if (p5.plateau[pos[1]+1][pos[0]]!=10){
						p5.plateau[pos[1]+1][pos[0]]=2;
						p5.plateau[pos[1]][pos[0]]=0;
					}
				
					}
				}
			}
		}
		
	}
	public void attaquer( int niveau) throws ErreurHeros {
		pos=getPosHeros(niveau);
		if (niveau==niveaumax) {
			if(niveau ==1) {
				if(p1f.plateau[pos[1]+1][pos[0]]==7) {
					p1f.plateau[pos[1]+1][pos[0]]=0;
				}
				
				if(p1f.plateau[pos[1]-1][pos[0]]==7) {
					p1f.plateau[pos[1]-1][pos[0]]=0;
				}
				if(p1f.plateau[pos[1]][pos[0]-1]==7) {
					p1f.plateau[pos[1]][pos[0]-1]=0;
				}
				if(p1f.plateau[pos[1]][pos[0]+1]==7) {
					p1f.plateau[pos[1]][pos[0]+1]=0;
				}
			}
			if(niveau ==3) {
				if(p3f.plateau[pos[1]+1][pos[0]]==7) {
					p3f.plateau[pos[1]+1][pos[0]]=0;
				}
				
				if(p3f.plateau[pos[1]-1][pos[0]]==7) {
					p3f.plateau[pos[1]-1][pos[0]]=0;
				}
				if(p3f.plateau[pos[1]][pos[0]-1]==7) {
					p3f.plateau[pos[1]][pos[0]-1]=0;
				}
				if(p3f.plateau[pos[1]][pos[0]+1]==7) {
					p3f.plateau[pos[1]][pos[0]+1]=0;
				}
			}
			if(niveau ==5) {
				if(p5.plateau[pos[1]+1][pos[0]]==7) {
					p5.plateau[pos[1]+1][pos[0]]=0;
				}
				
				if(p5.plateau[pos[1]-1][pos[0]]==7) {
					p5.plateau[pos[1]-1][pos[0]]=0;
				}
				if(p5.plateau[pos[1]][pos[0]-1]==7) {
					p5.plateau[pos[1]][pos[0]-1]=0;
				}
				if(p5.plateau[pos[1]][pos[0]+1]==7) {
					p5.plateau[pos[1]][pos[0]+1]=0;
				}
			}
		}
		else {
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
			if(niveau==3) {
				if(p3.plateau[pos[1]+1][pos[0]]==7) {
					p3.plateau[pos[1]+1][pos[0]]=0;
				}
				
				if(p3.plateau[pos[1]-1][pos[0]]==7) {
					p3.plateau[pos[1]-1][pos[0]]=0;
				}
				if(p3.plateau[pos[1]][pos[0]-1]==7) {
					p3.plateau[pos[1]][pos[0]-1]=0;
				}
				if(p3.plateau[pos[1]][pos[0]+1]==7) {
					p3.plateau[pos[1]][pos[0]+1]=0;
				}
			}
		}
		
	}
	public void deplace_monstre(Monstre m, Heros h) throws ErreurHeros {
		int X = g.getX();
		int Y =g.getY();
		if(X<0 || X>18) {
			throw new ErreurHeros();
		}
		if(Y<0 || Y>18) {
			throw new ErreurHeros();
		}
		int A = m.genererInt2(-1, 1);
		int B = m.genererInt2(-1, 1);
		if (niveau==1) {
			if (p1.plateau[m.getX()-1][m.getY()] == 0) {
				
				
				if(A == -1) { 
					p1.plateau[m.getX()][m.getY()] = 0;
					m.position_x = m.position_x - 1;
					p1.plateau[m.getX()][m.getY()] = 7;
			}
			}
			if (p1.plateau[m.getX()+1][m.getY()] == 0 ) {
			
			if(A == 1) { 
				p1.plateau[m.getX()][m.getY()] = 0;
				m.position_x = m.position_x +1;
				p1.plateau[m.getX()][m.getY()] =  7;
			}
			}
			if (p1.plateau[m.getX()][m.getY()-1] == 0 ) {
			if(B == -1) { 
				p1.plateau[m.getX()][m.getY()] = 0;
				m.position_y = m.position_y - 1;
				p1.plateau[m.getX()][m.getY()] =  7;
			}
			}
			if (p1.plateau[m.getX()][m.getY()+1] == 0 ) {
			if(B == 1) { 
				p1.plateau[m.getX()][m.getY()] = 0;
				m.position_y = m.position_y +1;
				p1.plateau[m.getX()][m.getY()] =  7;
			}
			}
			if (p1.plateau[m.getX()-1][m.getY()] == 2) {
				if (A == -1) {
					h.Hp = h.Hp -1;
					
				}
			}
			if (p1.plateau[m.getX()+1][m.getY()] == 2) {
				if (A == 1) {
					h.Hp = h.Hp -1;
					
				}
			}
			if (p1.plateau[m.getX()][m.getY()-1] == 2) {
				if (B == -1) {
					h.Hp = h.Hp -1;
					
				}
			}
			if (p1.plateau[m.getX()][m.getY()+1] == 2) {
				if (B == 1) {
					h.Hp = h.Hp -1;
					
				}
			}
		}
			if (niveau==2) {
				if (p2.plateau[m.getX()-1][m.getY()] == 0) {
					
					
					if(A == -1) { 
						p2.plateau[m.getX()][m.getY()] = 0;
						m.position_x = m.position_x - 1;
						p2.plateau[m.getX()][m.getY()] = 7;
				}
				}
				if (p2.plateau[m.getX()+1][m.getY()] == 0 ) {
				
				if(A == 1) { 
					p2.plateau[m.getX()][m.getY()] = 0;
					m.position_x = m.position_x +1;
					p2.plateau[m.getX()][m.getY()] =  7;
				}
				}
				if (p2.plateau[m.getX()][m.getY()-1] == 0 ) {
				if(B == -1) { 
					p2.plateau[m.getX()][m.getY()] = 0;
					m.position_y = m.position_y - 1;
					p2.plateau[m.getX()][m.getY()] =  7;
				}
				}
				if (p2.plateau[m.getX()][m.getY()+1] == 0 ) {
				if(B == 1) { 
					p2.plateau[m.getX()][m.getY()] = 0;
					m.position_y = m.position_y +1;
					p2.plateau[m.getX()][m.getY()] =  7;
				}
				}
				if (p2.plateau[m.getX()-1][m.getY()] == 2) {
					if (A == -1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p2.plateau[m.getX()+1][m.getY()] == 2) {
					if (A == 1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p2.plateau[m.getX()][m.getY()-1] == 2) {
					if (B == -1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p2.plateau[m.getX()][m.getY()+1] == 2) {
					if (B == 1) {
						h.Hp = h.Hp -1;
						
					}
				}
			}
				if (niveau==3) {
					if (p3.plateau[m.getX()-1][m.getY()] == 0) {
						
						
						if(A == -1) { 
							p3.plateau[m.getX()][m.getY()] = 0;
							m.position_x = m.position_x - 1;
							p3.plateau[m.getX()][m.getY()] = 7;
					}
					}
					if (p3.plateau[m.getX()+1][m.getY()] == 0 ) {
					
					if(A == 1) { 
						p3.plateau[m.getX()][m.getY()] = 0;
						m.position_x = m.position_x +1;
						p3.plateau[m.getX()][m.getY()] =  7;
					}
					}
					if (p3.plateau[m.getX()][m.getY()-1] == 0 ) {
					if(B == -1) { 
						p3.plateau[m.getX()][m.getY()] = 0;
						m.position_y = m.position_y - 1;
						p3.plateau[m.getX()][m.getY()] =  7;
					}
					}
					if (p3.plateau[m.getX()][m.getY()+1] == 0 ) {
					if(B == 1) { 
						p3.plateau[m.getX()][m.getY()] = 0;
						m.position_y = m.position_y +1;
						p3.plateau[m.getX()][m.getY()] =  7;
					}
					}
					if (p3.plateau[m.getX()-1][m.getY()] == 2) {
						if (A == -1) {
							h.Hp = h.Hp -1;
							
						}
					}
					if (p3.plateau[m.getX()+1][m.getY()] == 2) {
						if (A == 1) {
							h.Hp = h.Hp -1;
							
						}
					}
					if (p3.plateau[m.getX()][m.getY()-1] == 2) {
						if (B == -1) {
							h.Hp = h.Hp -1;
							
						}
					}
					if (p3.plateau[m.getX()][m.getY()+1] == 2) {
						if (B == 1) {
							h.Hp = h.Hp -1;
							
						}
					}
				}
					if (niveau==4) {
						if (p4.plateau[m.getX()-1][m.getY()] == 0) {
							
							
							if(A == -1) { 
								p4.plateau[m.getX()][m.getY()] = 0;
								m.position_x = m.position_x - 1;
								p4.plateau[m.getX()][m.getY()] = 7;
						}
						}
						if (p4.plateau[m.getX()+1][m.getY()] == 0 ) {
						
						if(A == 1) { 
							p4.plateau[m.getX()][m.getY()] = 0;
							m.position_x = m.position_x +1;
							p4.plateau[m.getX()][m.getY()] =  7;
						}
						}
						if (p4.plateau[m.getX()][m.getY()-1] == 0 ) {
						if(B == -1) { 
							p4.plateau[m.getX()][m.getY()] = 0;
							m.position_y = m.position_y - 1;
							p4.plateau[m.getX()][m.getY()] =  7;
						}
						}
						if (p4.plateau[m.getX()][m.getY()+1] == 0 ) {
						if(B == 1) { 
							p4.plateau[m.getX()][m.getY()] = 0;
							m.position_y = m.position_y +1;
							p4.plateau[m.getX()][m.getY()] =  7;
						}
						}
						if (p4.plateau[m.getX()-1][m.getY()] == 2) {
							if (A == -1) {
								h.Hp = h.Hp -1;
								
							}
						}
						if (p4.plateau[m.getX()+1][m.getY()] == 2) {
							if (A == 1) {
								h.Hp = h.Hp -1;
								
							}
						}
						if (p4.plateau[m.getX()][m.getY()-1] == 2) {
							if (B == -1) {
								h.Hp = h.Hp -1;
								
							}
						}
						if (p4.plateau[m.getX()][m.getY()+1] == 2) {
							if (B == 1) {
								h.Hp = h.Hp -1;
								
							}
						}
					}
						if (niveau==5) {
							if (p5.plateau[m.getX()-1][m.getY()] == 0) {
								
								
								if(A == -1) { 
									p5.plateau[m.getX()][m.getY()] = 0;
									m.position_x = m.position_x - 1;
									p5.plateau[m.getX()][m.getY()] = 7;
							}
							}
							if (p5.plateau[m.getX()+1][m.getY()] == 0 ) {
							
							if(A == 1) { 
								p5.plateau[m.getX()][m.getY()] = 0;
								m.position_x = m.position_x +1;
								p5.plateau[m.getX()][m.getY()] =  7;
							}
							}
							if (p5.plateau[m.getX()][m.getY()-1] == 0 ) {
							if(B == -1) { 
								p5.plateau[m.getX()][m.getY()] = 0;
								m.position_y = m.position_y - 1;
								p5.plateau[m.getX()][m.getY()] =  7;
							}
							}
							if (p5.plateau[m.getX()][m.getY()+1] == 0 ) {
							if(B == 1) { 
								p5.plateau[m.getX()][m.getY()] = 0;
								m.position_y = m.position_y +1;
								p5.plateau[m.getX()][m.getY()] =  7;
							}
							}
							if (p5.plateau[m.getX()-1][m.getY()] == 2) {
								if (A == -1) {
									h.Hp = h.Hp -1;
									
								}
							}
							if (p5.plateau[m.getX()+1][m.getY()] == 2) {
								if (A == 1) {
									h.Hp = h.Hp -1;
									
								}
							}
							if (p5.plateau[m.getX()][m.getY()-1] == 2) {
								if (B == -1) {
									h.Hp = h.Hp -1;
									
								}
							}
							if (p5.plateau[m.getX()][m.getY()+1] == 2) {
								if (B == 1) {
									h.Hp = h.Hp -1;
									
								}
							}

			
		}
		
	}
	public void deplace_ghost(ghost g, Heros h) throws ErreurHeros {
		int X = g.getX();
		int Y =g.getY();
		if(X<0 || X>18) {
			throw new ErreurHeros();
		}
		if(Y<0 || Y>18) {
			throw new ErreurHeros();
		}
		int A = g.genererInt2(-1, 1);
		int B = g.genererInt2(-1, 1);
		if (niveau==1) {
			if (p1.plateau[g.getX()][g.getY()] == 8 &&  p1.plateau[g.getX()-1][g.getY()] == 0) {
				if(A == -1 ) { 
					p1.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x - 1;
					p1.plateau[g.getX()][g.getY()] = 8;
				}
				}
				if (p1.plateau[g.getX()+1][g.getY()] == 0 && p1.plateau[g.getX()][g.getY()] == 8 ) {
				
				if(A == 1) { 
					p1.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x +1;
					p1.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p1.plateau[g.getX()][g.getY()-1] == 0 && p1.plateau[g.getX()][g.getY()] == 8 ) {
				if(B == -1) { 
					p1.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y - 1;
					p1.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p1.plateau[g.getX()][g.getY()+1] == 0 && p1.plateau[g.getX()][g.getY()] == 8 ) {
				if(B == 1) { 
					p1.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y +1;
					p1.plateau[g.getX()][g.getY()] =  8;
				}
				}

				if (p1.plateau[g.getX()-1][g.getY()] == 1 && p1.plateau[g.getX()][g.getY()] == 9 ) {
				if(A == -1 ) { 
					p1.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x - 1;
					p1.plateau[g.getX()][g.getY()] = 9;
				}
				}
				if (p1.plateau[g.getX()][g.getY()] == 9 && p1.plateau[g.getX()+1][g.getY()] == 1  ) {
				
				if(A == 1) { 
					p1.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x +1;
					p1.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p1.plateau[g.getX()][g.getY()] == 9 && p1.plateau[g.getX()][g.getY()-1] == 1 ) {
				if(B == -1) { 
					p1.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y - 1;
					p1.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p1.plateau[g.getX()][g.getY()+1] == 1 && p1.plateau[g.getX()][g.getY()] == 9 ) {
				if(B == 1) { 
					p1.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y +1;
					p1.plateau[g.getX()][g.getY()] =  9;
				}
				}
			
				if (p1.plateau[g.getX()-1][g.getY()] == 0 && p1.plateau[g.getX()][g.getY()] == 9) {
				if (A == -1){
					p1.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x - 1;
					p1.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p1.plateau[g.getX()+1][g.getY()] == 0 && p1.plateau[g.getX()][g.getY()] == 9) {
				if (A == 1){
					p1.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x + 1;
					p1.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p1.plateau[g.getX()][g.getY()-1] == 0 && p1.plateau[g.getX()][g.getY()] == 9) {
				if (B == -1){
					p1.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y - 1;
					p1.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p1.plateau[g.getX()][g.getY()+1] == 0 && p1.plateau[g.getX()][g.getY()] == 9){
				if (B == 1){
					p1.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y + 1;
					p1.plateau[g.getX()][g.getY()] =  8;
				}
				}
				
				if (p1.plateau[g.getX()-1][g.getY()] == 1 && p1.plateau[g.getX()][g.getY()] == 8) {
				if (A == -1){
					p1.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x - 1;
					p1.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p1.plateau[g.getX()+1][g.getY()] == 1 && p1.plateau[g.getX()][g.getY()] == 8) {
				if (A == 1){
					p1.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x + 1;
					p1.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p1.plateau[g.getX()][g.getY()-1] == 1 && p1.plateau[g.getX()][g.getY()] == 8) {
				if (B == -1){
					p1.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y - 1;
					p1.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p1.plateau[g.getX()][g.getY()+1] == 1 && p1.plateau[g.getX()][g.getY()] == 8){
				if (B == 1){
					p1.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y + 1;
					p1.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p1.plateau[g.getX()-1][g.getY()] == 2) {
					if (A == -1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p1.plateau[g.getX()+1][g.getY()] == 2) {
					if (A == 1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p1.plateau[g.getX()][g.getY()-1] == 2) {
					if (B == -1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p1.plateau[g.getX()][g.getY()+1] == 2) {
					if (B == 1) {
						h.Hp = h.Hp -1;
						
					}
				}
			
			
			}
		if (niveau==2) {
			if (p2.plateau[g.getX()][g.getY()] == 8 &&  p2.plateau[g.getX()-1][g.getY()] == 0) {
				if(A == -1 ) { 
					p2.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x - 1;
					p2.plateau[g.getX()][g.getY()] = 8;
				}
				}
				if (p2.plateau[g.getX()+1][g.getY()] == 0 && p2.plateau[g.getX()][g.getY()] == 8 ) {
				
				if(A == 1) { 
					p2.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x +1;
					p2.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p2.plateau[g.getX()][g.getY()-1] == 0 && p2.plateau[g.getX()][g.getY()] == 8 ) {
				if(B == -1) { 
					p2.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y - 1;
					p2.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p2.plateau[g.getX()][g.getY()+1] == 0 && p2.plateau[g.getX()][g.getY()] == 8 ) {
				if(B == 1) { 
					p2.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y +1;
					p2.plateau[g.getX()][g.getY()] =  8;
				}
				}

				if (p2.plateau[g.getX()-1][g.getY()] == 1 && p2.plateau[g.getX()][g.getY()] == 9 ) {
				if(A == -1 ) { 
					p2.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x - 1;
					p2.plateau[g.getX()][g.getY()] = 9;
				}
				}
				if (p2.plateau[g.getX()][g.getY()] == 9 && p2.plateau[g.getX()+1][g.getY()] == 1  ) {
				
				if(A == 1) { 
					p2.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x +1;
					p2.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p2.plateau[g.getX()][g.getY()] == 9 && p2.plateau[g.getX()][g.getY()-1] == 1 ) {
				if(B == -1) { 
					p2.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y - 1;
					p2.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p2.plateau[g.getX()][g.getY()+1] == 1 && p2.plateau[g.getX()][g.getY()] == 9 ) {
				if(B == 1) { 
					p2.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y +1;
					p2.plateau[g.getX()][g.getY()] =  9;
				}
				}
			
				if (p2.plateau[g.getX()-1][g.getY()] == 0 && p2.plateau[g.getX()][g.getY()] == 9) {
				if (A == -1){
					p2.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x - 1;
					p2.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p2.plateau[g.getX()+1][g.getY()] == 0 && p2.plateau[g.getX()][g.getY()] == 9) {
				if (A == 1){
					p2.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x + 1;
					p2.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p2.plateau[g.getX()][g.getY()-1] == 0 && p2.plateau[g.getX()][g.getY()] == 9) {
				if (B == -1){
					p2.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y - 1;
					p2.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p2.plateau[g.getX()][g.getY()+1] == 0 && p2.plateau[g.getX()][g.getY()] == 9){
				if (B == 1){
					p2.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y + 1;
					p2.plateau[g.getX()][g.getY()] =  8;
				}
				}
				
				if (p2.plateau[g.getX()-1][g.getY()] == 1 && p2.plateau[g.getX()][g.getY()] == 8) {
				if (A == -1){
					p2.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x - 1;
					p2.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p2.plateau[g.getX()+1][g.getY()] == 1 && p2.plateau[g.getX()][g.getY()] == 8) {
				if (A == 1){
					p2.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x + 1;
					p2.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p2.plateau[g.getX()][g.getY()-1] == 1 && p2.plateau[g.getX()][g.getY()] == 8) {
				if (B == -1){
					p2.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y - 1;
					p2.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p2.plateau[g.getX()][g.getY()+1] == 1 && p2.plateau[g.getX()][g.getY()] == 8){
				if (B == 1){
					p2.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y + 1;
					p2.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p2.plateau[g.getX()-1][g.getY()] == 2) {
					if (A == -1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p2.plateau[g.getX()+1][g.getY()] == 2) {
					if (A == 1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p2.plateau[g.getX()][g.getY()-1] == 2) {
					if (B == -1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p2.plateau[g.getX()][g.getY()+1] == 2) {
					if (B == 1) {
						h.Hp = h.Hp -1;
						
					}
				}
			
			
			}
		if (niveau==5) {
			if (p5.plateau[g.getX()][g.getY()] == 8 &&  p5.plateau[g.getX()-1][g.getY()] == 0) {
				if(A == -1 ) { 
					p5.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x - 1;
					p5.plateau[g.getX()][g.getY()] = 8;
				}
				}
				if (p5.plateau[g.getX()+1][g.getY()] == 0 && p5.plateau[g.getX()][g.getY()] == 8 ) {
				
				if(A == 1) { 
					p5.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x +1;
					p5.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p5.plateau[g.getX()][g.getY()-1] == 0 && p5.plateau[g.getX()][g.getY()] == 8 ) {
				if(B == -1) { 
					p5.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y - 1;
					p5.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p5.plateau[g.getX()][g.getY()+1] == 0 && p5.plateau[g.getX()][g.getY()] == 8 ) {
				if(B == 1) { 
					p5.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y +1;
					p5.plateau[g.getX()][g.getY()] =  8;
				}
				}

				if (p5.plateau[g.getX()-1][g.getY()] == 1 && p5.plateau[g.getX()][g.getY()] == 9 ) {
				if(A == -1 ) { 
					p5.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x - 1;
					p5.plateau[g.getX()][g.getY()] = 9;
				}
				}
				if (p5.plateau[g.getX()][g.getY()] == 9 && p5.plateau[g.getX()+1][g.getY()] == 1  ) {
				
				if(A == 1) { 
					p5.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x +1;
					p5.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p5.plateau[g.getX()][g.getY()] == 9 && p5.plateau[g.getX()][g.getY()-1] == 1 ) {
				if(B == -1) { 
					p5.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y - 1;
					p5.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p5.plateau[g.getX()][g.getY()+1] == 1 && p5.plateau[g.getX()][g.getY()] == 9 ) {
				if(B == 1) { 
					p5.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y +1;
					p5.plateau[g.getX()][g.getY()] =  9;
				}
				}
			
				if (p5.plateau[g.getX()-1][g.getY()] == 0 && p5.plateau[g.getX()][g.getY()] == 9) {
				if (A == -1){
					p5.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x - 1;
					p5.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p5.plateau[g.getX()+1][g.getY()] == 0 && p5.plateau[g.getX()][g.getY()] == 9) {
				if (A == 1){
					p5.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x + 1;
					p5.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p5.plateau[g.getX()][g.getY()-1] == 0 && p5.plateau[g.getX()][g.getY()] == 9) {
				if (B == -1){
					p5.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y - 1;
					p5.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p5.plateau[g.getX()][g.getY()+1] == 0 && p5.plateau[g.getX()][g.getY()] == 9){
				if (B == 1){
					p5.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y + 1;
					p5.plateau[g.getX()][g.getY()] =  8;
				}
				}
				
				if (p5.plateau[g.getX()-1][g.getY()] == 1 && p5.plateau[g.getX()][g.getY()] == 8) {
				if (A == -1){
					p5.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x - 1;
					p5.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p5.plateau[g.getX()+1][g.getY()] == 1 && p5.plateau[g.getX()][g.getY()] == 8) {
				if (A == 1){
					p5.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x + 1;
					p5.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p5.plateau[g.getX()][g.getY()-1] == 1 && p5.plateau[g.getX()][g.getY()] == 8) {
				if (B == -1){
					p5.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y - 1;
					p5.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p5.plateau[g.getX()][g.getY()+1] == 1 && p5.plateau[g.getX()][g.getY()] == 8){
				if (B == 1){
					p5.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y + 1;
					p5.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p5.plateau[g.getX()-1][g.getY()] == 2) {
					if (A == -1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p5.plateau[g.getX()+1][g.getY()] == 2) {
					if (A == 1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p5.plateau[g.getX()][g.getY()-1] == 2) {
					if (B == -1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p5.plateau[g.getX()][g.getY()+1] == 2) {
					if (B == 1) {
						h.Hp = h.Hp -1;
						
					}
				}
			
			
			}
		if (niveau==3) {
			if (p3.plateau[g.getX()][g.getY()] == 8 &&  p3.plateau[g.getX()-1][g.getY()] == 0) {
				if(A == -1 ) { 
					p3.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x - 1;
					p3.plateau[g.getX()][g.getY()] = 8;
				}
				}
				if (p3.plateau[g.getX()+1][g.getY()] == 0 && p3.plateau[g.getX()][g.getY()] == 8 ) {
				
				if(A == 1) { 
					p3.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x +1;
					p3.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p3.plateau[g.getX()][g.getY()-1] == 0 && p3.plateau[g.getX()][g.getY()] == 8 ) {
				if(B == -1) { 
					p3.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y - 1;
					p3.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p3.plateau[g.getX()][g.getY()+1] == 0 && p3.plateau[g.getX()][g.getY()] == 8 ) {
				if(B == 1) { 
					p3.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y +1;
					p3.plateau[g.getX()][g.getY()] =  8;
				}
				}

				if (p3.plateau[g.getX()-1][g.getY()] == 1 && p3.plateau[g.getX()][g.getY()] == 9 ) {
				if(A == -1 ) { 
					p3.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x - 1;
					p3.plateau[g.getX()][g.getY()] = 9;
				}
				}
				if (p3.plateau[g.getX()][g.getY()] == 9 && p3.plateau[g.getX()+1][g.getY()] == 1  ) {
				
				if(A == 1) { 
					p3.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x +1;
					p3.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p3.plateau[g.getX()][g.getY()] == 9 && p3.plateau[g.getX()][g.getY()-1] == 1 ) {
				if(B == -1) { 
					p3.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y - 1;
					p3.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p3.plateau[g.getX()][g.getY()+1] == 1 && p3.plateau[g.getX()][g.getY()] == 9 ) {
				if(B == 1) { 
					p3.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y +1;
					p3.plateau[g.getX()][g.getY()] =  9;
				}
				}
			
				if (p3.plateau[g.getX()-1][g.getY()] == 0 && p3.plateau[g.getX()][g.getY()] == 9) {
				if (A == -1){
					p3.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x - 1;
					p3.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p3.plateau[g.getX()+1][g.getY()] == 0 && p3.plateau[g.getX()][g.getY()] == 9) {
				if (A == 1){
					p3.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x + 1;
					p3.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p3.plateau[g.getX()][g.getY()-1] == 0 && p3.plateau[g.getX()][g.getY()] == 9) {
				if (B == -1){
					p3.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y - 1;
					p3.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p3.plateau[g.getX()][g.getY()+1] == 0 && p3.plateau[g.getX()][g.getY()] == 9){
				if (B == 1){
					p3.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y + 1;
					p3.plateau[g.getX()][g.getY()] =  8;
				}
				}
				
				if (p3.plateau[g.getX()-1][g.getY()] == 1 && p3.plateau[g.getX()][g.getY()] == 8) {
				if (A == -1){
					p3.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x - 1;
					p3.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p3.plateau[g.getX()+1][g.getY()] == 1 && p3.plateau[g.getX()][g.getY()] == 8) {
				if (A == 1){
					p3.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x + 1;
					p3.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p3.plateau[g.getX()][g.getY()-1] == 1 && p3.plateau[g.getX()][g.getY()] == 8) {
				if (B == -1){
					p3.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y - 1;
					p3.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p3.plateau[g.getX()][g.getY()+1] == 1 && p3.plateau[g.getX()][g.getY()] == 8){
				if (B == 1){
					p3.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y + 1;
					p3.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p3.plateau[g.getX()-1][g.getY()] == 2) {
					if (A == -1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p3.plateau[g.getX()+1][g.getY()] == 2) {
					if (A == 1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p3.plateau[g.getX()][g.getY()-1] == 2) {
					if (B == -1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p3.plateau[g.getX()][g.getY()+1] == 2) {
					if (B == 1) {
						h.Hp = h.Hp -1;
						
					}
				}
			
			
			}
		if (niveau==4) {
			if (p4.plateau[g.getX()][g.getY()] == 8 &&  p4.plateau[g.getX()-1][g.getY()] == 0) {
				if(A == -1 ) { 
					p4.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x - 1;
					p4.plateau[g.getX()][g.getY()] = 8;
				}
				}
				if (p4.plateau[g.getX()+1][g.getY()] == 0 && p4.plateau[g.getX()][g.getY()] == 8 ) {
				
				if(A == 1) { 
					p4.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x +1;
					p4.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p4.plateau[g.getX()][g.getY()-1] == 0 && p4.plateau[g.getX()][g.getY()] == 8 ) {
				if(B == -1) { 
					p4.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y - 1;
					p4.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p4.plateau[g.getX()][g.getY()+1] == 0 && p4.plateau[g.getX()][g.getY()] == 8 ) {
				if(B == 1) { 
					p4.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y +1;
					p4.plateau[g.getX()][g.getY()] =  8;
				}
				}

				if (p4.plateau[g.getX()-1][g.getY()] == 1 && p4.plateau[g.getX()][g.getY()] == 9 ) {
				if(A == -1 ) { 
					p4.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x - 1;
					p4.plateau[g.getX()][g.getY()] = 9;
				}
				}
				if (p4.plateau[g.getX()][g.getY()] == 9 && p4.plateau[g.getX()+1][g.getY()] == 1  ) {
				
				if(A == 1) { 
					p4.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x +1;
					p4.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p4.plateau[g.getX()][g.getY()] == 9 && p4.plateau[g.getX()][g.getY()-1] == 1 ) {
				if(B == -1) { 
					p4.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y - 1;
					p4.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p4.plateau[g.getX()][g.getY()+1] == 1 && p4.plateau[g.getX()][g.getY()] == 9 ) {
				if(B == 1) { 
					p4.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y +1;
					p4.plateau[g.getX()][g.getY()] =  9;
				}
				}
			
				if (p4.plateau[g.getX()-1][g.getY()] == 0 && p4.plateau[g.getX()][g.getY()] == 9) {
				if (A == -1){
					p4.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x - 1;
					p4.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p4.plateau[g.getX()+1][g.getY()] == 0 && p4.plateau[g.getX()][g.getY()] == 9) {
				if (A == 1){
					p4.plateau[g.getX()][g.getY()] = 1;
					g.position_x = g.position_x + 1;
					p4.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p4.plateau[g.getX()][g.getY()-1] == 0 && p4.plateau[g.getX()][g.getY()] == 9) {
				if (B == -1){
					p4.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y - 1;
					p4.plateau[g.getX()][g.getY()] =  8;
				}
				}
				if (p4.plateau[g.getX()][g.getY()+1] == 0 && p4.plateau[g.getX()][g.getY()] == 9){
				if (B == 1){
					p4.plateau[g.getX()][g.getY()] = 1;
					g.position_y = g.position_y + 1;
					p4.plateau[g.getX()][g.getY()] =  8;
				}
				}
				
				if (p4.plateau[g.getX()-1][g.getY()] == 1 && p4.plateau[g.getX()][g.getY()] == 8) {
				if (A == -1){
					p4.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x - 1;
					p4.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p4.plateau[g.getX()+1][g.getY()] == 1 && p4.plateau[g.getX()][g.getY()] == 8) {
				if (A == 1){
					p4.plateau[g.getX()][g.getY()] = 0;
					g.position_x = g.position_x + 1;
					p4.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p4.plateau[g.getX()][g.getY()-1] == 1 && p4.plateau[g.getX()][g.getY()] == 8) {
				if (B == -1){
					p4.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y - 1;
					p4.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p4.plateau[g.getX()][g.getY()+1] == 1 && p4.plateau[g.getX()][g.getY()] == 8){
				if (B == 1){
					p4.plateau[g.getX()][g.getY()] = 0;
					g.position_y = g.position_y + 1;
					p4.plateau[g.getX()][g.getY()] =  9;
				}
				}
				if (p4.plateau[g.getX()-1][g.getY()] == 2) {
					if (A == -1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p4.plateau[g.getX()+1][g.getY()] == 2) {
					if (A == 1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p4.plateau[g.getX()][g.getY()-1] == 2) {
					if (B == -1) {
						h.Hp = h.Hp -1;
						
					}
				}
				if (p4.plateau[g.getX()][g.getY()+1] == 2) {
					if (B == 1) {
						h.Hp = h.Hp -1;
						
					}
				}
			
			
			}
		}



}