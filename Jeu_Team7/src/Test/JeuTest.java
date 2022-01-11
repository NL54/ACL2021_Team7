package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import engine.Cmd;
import model.ErreurHeros;
import model.Jeu;
import model.Monstre;
import model.ghost;

class JeuTest {


	private int niveau;
	private Jeu jeu;
	Monstre M = new Monstre(1,14,8);// avec [14,8] [y,x] position initiale du monstre
	private Jeu jeu2;
	private ghost g= new ghost(1,3,6); //[3,6][y,x]
	@BeforeEach
	void setUp()  {
		niveau=1;
		this.jeu=new Jeu("helpFilePacman.txt",1);
		this.jeu2=new Jeu("helpFilePacman.txt",2);
		for (int i=0;i<jeu.p1f.taille;i++) {
			for (int j=0;j<jeu.p1f.taille;j++) {
				jeu.p1f.plateau[i][j]=0;
			}
		}
		for (int i=0;i<jeu2.p1.taille;i++) {
			for (int j=0;j<jeu2.p1.taille;j++) {
				jeu2.p1.plateau[i][j]=0;
			}
		}
	}
	
	@Test
	void testgetPos() {
		jeu.p1f.plateau[15][10]=40;
		//jeu.p2.plateau[15][10]=11;
		int[]position= {10,15};
		int pos = this.jeu.getPos(position,niveau);
		if (niveau==1) {
			assertEquals(pos,40);
					}
		if (niveau==2) {
			assertEquals(pos,11);
					}
	}
	//Test Tresor
	@Test
	void testTresorhaut() throws ErreurHeros {
		jeu.p1f.plateau[4][17]=5; //ici [y][x] postresor
		jeu.p1f.plateau[5][17]=2; // position heros
		jeu.Tresor(niveau,Cmd.UP);
		assertTrue(jeu.Tresor(niveau,Cmd.UP));
		
	}
	@Test
	void testTresorbas() throws ErreurHeros { //postresor [17,1][x,y]
		jeu.p1f.plateau[4][17]=5; //ici [y][x] postresor
		jeu.p1f.plateau[3][17]=2; // position heros
		jeu.Tresor(niveau,Cmd.DOWN);
		assertTrue(jeu.Tresor(niveau,Cmd.DOWN));
		
	}
	@Test
	void testTresorgauche() throws ErreurHeros { //postresor [17,1][x,y]
		jeu.p1f.plateau[4][17]=5; //ici [y][x] postresor
		jeu.p1f.plateau[4][18]=2; // position heros
		jeu.Tresor(niveau,Cmd.LEFT);
		assertTrue(jeu.Tresor(niveau,Cmd.LEFT));
		
	}
	@Test
	void testTresordroit() throws ErreurHeros { //postresor [17,1][x,y]
		jeu.p1f.plateau[4][17]=5; //ici [y][x] postresor
		jeu.p1f.plateau[4][16]=2; // position heros
		jeu.Tresor(niveau,Cmd.RIGHT);
		assertTrue(jeu.Tresor(niveau,Cmd.RIGHT));
		
	}
	
	//Test activeMagie
	
	@Test
	void testactiveMagieHaut() throws ErreurHeros { //postresor [10,11][x,y]
		jeu.p1f.plateau[5][11]=4; //pos magie
		jeu.p1f.plateau[6][11]=2;
		jeu.activeMagie(niveau,Cmd.UP);
		assertTrue(jeu.activeMagie(niveau,Cmd.UP));
		
	}
	@Test
	void testactiveMagieBas() throws ErreurHeros { //postresor [10,11][x,y]
		jeu.p1f.plateau[5][11]=4; //pos magie
		jeu.p1f.plateau[4][11]=2;
		jeu.activeMagie(niveau,Cmd.DOWN);
		assertTrue(jeu.activeMagie(niveau,Cmd.DOWN));
		
	}
	@Test
	void testactiveMagieDroit() throws ErreurHeros { //postresor [10,11][x,y]
		jeu.p1f.plateau[5][11]=4; //pos magie
		jeu.p1f.plateau[5][10]=2;
		jeu.activeMagie(niveau,Cmd.RIGHT);
		assertTrue(jeu.activeMagie(niveau,Cmd.RIGHT));
		
	}
	@Test
	void testactiveMagieGauche() throws ErreurHeros { //postresor [10,11][x,y]
		jeu.p1f.plateau[5][11]=4; //pos magie
		jeu.p1f.plateau[5][12]=2;
		jeu.activeMagie(niveau,Cmd.LEFT);
		assertTrue(jeu.activeMagie(niveau,Cmd.LEFT));
		
	}
	
	//Test activepiege
	@Test
	void testactivePiegeHaut() throws ErreurHeros { //pos PIEGE [14,14][x,y]
		jeu.p1f.plateau[9][13]=3; //position piege
		jeu.p1f.plateau[10][13]=2; //positio heros
		jeu.activePiege(niveau, Cmd.UP);
		assertTrue(jeu.activePiege(niveau, Cmd.UP));
	}
	@Test
	void testactivePiegeBas()throws ErreurHeros { //posPIEGE [14,14][x,y]
		jeu.p1f.plateau[9][13]=3; //position piege
		jeu.p1f.plateau[8][13]=2; //positio heros
		jeu.activePiege(niveau, Cmd.DOWN);
		assertTrue(jeu.activePiege(niveau, Cmd.DOWN));
	}
	@Test
	void testactivePiegeDroit()throws ErreurHeros{ //POSPIEGE [14,14][x,y]
		jeu.p1f.plateau[9][13]=3; //position piege
		jeu.p1f.plateau[9][12]=2; //positio heros
		jeu.activePiege(niveau, Cmd.RIGHT);
		assertTrue(jeu.activePiege(niveau, Cmd.RIGHT));
	}
	@Test
	void testactivePiegeGauche()throws ErreurHeros { //POSPIEGE [14,14][x,y]
		jeu.p1f.plateau[9][13]=3; //position piege
		jeu.p1f.plateau[9][14]=2; //positio heros
		jeu.activePiege(niveau, Cmd.LEFT);
		assertTrue(jeu.activePiege(niveau, Cmd.LEFT));
	}
	//test activePassage
	@Test
	void testactivePassageBas() throws ErreurHeros{ //POS passage [4 ,12][x,y]
		jeu2.p1.plateau[10][4]=6; // pos passage
		jeu2.p1.plateau[9][4]=2;
		if(niveau>jeu2.Niveaumax()) {
			throw new ErreurHeros();
		}
		jeu2.activePassage(niveau, Cmd.DOWN);
		assertTrue(jeu2.activePassage(niveau, Cmd.DOWN));
	}
	
	@Test
	void testactivePassageHaut() throws ErreurHeros{ //POS passage [4 ,12][x,y]
		jeu2.p1.plateau[10][4]=6; // pos passage
		jeu2.p1.plateau[11][4]=2;
		if(niveau>jeu2.Niveaumax()) {
			throw new ErreurHeros();
		}
		jeu2.activePassage(niveau, Cmd.UP);
		assertTrue(jeu2.activePassage(niveau, Cmd.UP));
	}
	@Test
	void testactivePassageDroit()throws ErreurHeros { //POS passage [4 ,12][x,y]
		jeu2.p1.plateau[10][4]=6; // pos passage
		jeu2.p1.plateau[10][3]=2;
		if(niveau>jeu2.Niveaumax()) {
			throw new ErreurHeros();
		}
		jeu2.activePassage(niveau, Cmd.RIGHT);
		assertTrue(jeu2.activePassage(niveau, Cmd.RIGHT));
	}
	@Test
	void testactivePassageGauche()throws ErreurHeros { //POS passage [4 ,12][x,y]
		jeu2.p1.plateau[10][4]=6; // pos passage
		jeu2.p1.plateau[10][5]=2;
		if(niveau>jeu2.Niveaumax()) {
			throw new ErreurHeros();
		}
		jeu2.activePassage(niveau, Cmd.LEFT);
		assertTrue(jeu2.activePassage(niveau, Cmd.LEFT));
	}
	
	//Test deplacerMonstre
	@Test
	void testDeplacerMonstre() throws ErreurHeros { //le monstre M a la position [8,14][x,y]
//		int X = g.getX();
//		int Y =g.getY();
//		if(X<0 || X>18) {
//			throw new ErreurHeros();
//		}
//		if(Y<0 || Y>18) {
//			throw new ErreurHeros();
//		}
		jeu2.deplace_monstre(M,jeu2.h);
		boolean test = false;
		if(jeu2.p1.plateau[14][9]==7) { // si le monstres'est deplacé à droite
			test=true;
		}
		else if(jeu2.p1.plateau[14][7]==7) { // si le monstres'est deplacé à gauche
			test=true;
		}
		else if(jeu2.p1.plateau[15][8]==7) { // si le monstres'est deplacé en bas
			test=true;
		}
		else if(jeu2.p1.plateau[13][8]==7) { // si le monstres'est deplacé en haut
			test=true;
		}
		if(jeu2.p1.plateau[15][9]==7) { // si le monstres'est deplacé à droite
			test=true;
		}
		if(jeu2.p1.plateau[13][9]==7) { // si le monstres'est deplacé à droite
			test=true;
		}
		if(jeu2.p1.plateau[15][7]==7) { // si le monstres'est deplacé à droite
			test=true;
		}
		if(jeu2.p1.plateau[13][7]==7) { // si le monstres'est deplacé à droite
			test=true;
		}
		assertTrue(test);
		
	}
	//deplaceghost
	@Test
	void testDeplacerGhost() throws ErreurHeros { //le ghost g a la position [6,3][x,y]
		jeu2.p1.plateau[3][6]=8;
		jeu2.deplace_ghost(g,jeu2.h);
//		int X = g.getX();
//		int Y =g.getY();
//		if(X<0 || X>18) {
//			throw new ErreurHeros();
//		}
//		if(Y<0 || Y>18) {
//			throw new ErreurHeros();
//		}
		boolean test = false;
		if(jeu2.p1.plateau[3][7]==8) { // si le ghost s'est deplacé à droite
			test=true;
		}
		else if(jeu2.p1.plateau[3][5]==8) { // si le ghost s'est deplacé à gauche
			test=true;
		}
		else if(jeu2.p1.plateau[4][6]==8) { // si le ghost s'est deplacé en bas
			test=true;
		}
		else if(jeu2.p1.plateau[2][6]==8) { // si le ghost s'est deplacé en haut
			test=true;
		}
		else if(jeu2.p1.plateau[2][7]==8) { // si le ghost s'est deplacé en haut à droite
			test=true;
		}
		else if(jeu2.p1.plateau[2][5]==8) { // si le ghost s'est deplacé en haut à droite
			test=true;
		}
		else if(jeu2.p1.plateau[4][7]==8) { // si le ghost s'est deplacé en bas à droite
			test=true;
		}
		else if(jeu2.p1.plateau[4][5]==8) { // si le ghost s'est deplacé en bas à gauche
			test=true;
		}
		
		assertTrue(test);
		
	}
	
	
	
}

