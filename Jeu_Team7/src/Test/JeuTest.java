package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import engine.Cmd;
import model.Jeu;
import model.Monstre;

class JeuTest {

	private int niveau;
	private Jeu jeu;
	Monstre M = new Monstre(1,8,14);
	private Jeu jeu2;
	@BeforeEach
	void setUp()  {
		niveau=1;
		this.jeu=new Jeu("helpFilePacman.txt",1);
		this.jeu2=new Jeu("helpFilePacman.txt",2);
		this.jeu2.p1.plateau[1][1]=0;
		this.jeu.p1f.plateau[1][1]=0;
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
	void testTresorhaut() { //postresor [17,1][x,y]
		jeu.p1f.plateau[2][17]=2; //ici [y][x]
		jeu.Tresor(niveau,Cmd.UP);
		assertTrue(jeu.Tresor(niveau,Cmd.UP));
		
	}
	@Test
	void testTresorbas() { //postresor [17,1][x,y]
		jeu.p1f.plateau[0][17]=2;
		jeu.Tresor(niveau,Cmd.DOWN);
		assertTrue(jeu.Tresor(niveau,Cmd.DOWN));
		
	}
	@Test
	void testTresorgauche() { //postresor [17,1][x,y]
		jeu.p1f.plateau[1][18]=2;
		jeu.Tresor(niveau,Cmd.LEFT);
		assertTrue(jeu.Tresor(niveau,Cmd.LEFT));
		
	}
	@Test
	void testTresordroit() { //postresor [17,1][x,y]
		jeu.p1f.plateau[1][16]=2;
		jeu.Tresor(niveau,Cmd.RIGHT);
		assertTrue(jeu.Tresor(niveau,Cmd.RIGHT));
		
	}
	
	//Test activeMagie
	
	@Test
	void testactiveMagieHaut() { //postresor [10,11][x,y]
		jeu.p1f.plateau[12][10]=2;
		jeu.activeMagie(niveau,Cmd.UP);
		assertTrue(jeu.activeMagie(niveau,Cmd.UP));
		
	}
	@Test
	void testactiveMagieBas() { //postresor [10,11][x,y]
		jeu.p1f.plateau[10][10]=2;
		jeu.activeMagie(niveau,Cmd.DOWN);
		assertTrue(jeu.activeMagie(niveau,Cmd.DOWN));
		
	}
	@Test
	void testactiveMagieDroit() { //postresor [10,11][x,y]
		jeu.p1f.plateau[11][9]=2;
		jeu.activeMagie(niveau,Cmd.RIGHT);
		assertTrue(jeu.activeMagie(niveau,Cmd.RIGHT));
		
	}
	@Test
	void testactiveMagieGauche() { //postresor [10,11][x,y]
		jeu.p1f.plateau[11][11]=2;
		jeu.activeMagie(niveau,Cmd.LEFT);
		assertTrue(jeu.activeMagie(niveau,Cmd.LEFT));
		
	}
	
	//Test activepiege
	@Test
	void testactivePiegeHaut() { //pos PIEGE [14,14][x,y]
		jeu.p1f.plateau[15][14]=2;
		jeu.activePiege(niveau, Cmd.UP);
		assertTrue(jeu.activePiege(niveau, Cmd.UP));
	}
	@Test
	void testactivePiegeBas() { //posPIEGE [14,14][x,y]
		jeu.p1f.plateau[13][14]=2;
		jeu.activePiege(niveau, Cmd.DOWN);
		assertTrue(jeu.activePiege(niveau, Cmd.DOWN));
	}
	@Test
	void testactivePiegeDroit() { //POSPIEGE [14,14][x,y]
		jeu.p1f.plateau[14][13]=2;
		jeu.activePiege(niveau, Cmd.RIGHT);
		assertTrue(jeu.activePiege(niveau, Cmd.RIGHT));
	}
	@Test
	void testactivePiegeGauche() { //POSPIEGE [14,14][x,y]
		jeu.p1f.plateau[14][15]=2;
		jeu.activePiege(niveau, Cmd.LEFT);
		assertTrue(jeu.activePiege(niveau, Cmd.LEFT));
	}
	//test activePassage
	@Test
	void testactivePassageBas() { //POS passage [4 ,12][x,y]
		jeu2.p1.plateau[11][4]=2;
		jeu2.activePassage(niveau, Cmd.DOWN);
		assertTrue(jeu2.activePassage(niveau, Cmd.DOWN));
	}
	
	@Test
	void testactivePassageHaut() { //POS passage [4 ,12][x,y]
		jeu2.p1.plateau[13][4]=2;
		jeu2.activePassage(niveau, Cmd.UP);
		assertTrue(jeu2.activePassage(niveau, Cmd.UP));
	}
	@Test
	void testactivePassageDroit() { //POS passage [4 ,12][x,y]
		jeu2.p1.plateau[12][3]=2;
		jeu2.activePassage(niveau, Cmd.RIGHT);
		assertTrue(jeu2.activePassage(niveau, Cmd.RIGHT));
	}
	@Test
	void testactivePassageGauche() { //POS passage [4 ,12][x,y]
		jeu2.p1.plateau[12][5]=2;
		jeu2.activePassage(niveau, Cmd.LEFT);
		assertTrue(jeu2.activePassage(niveau, Cmd.LEFT));
	}
	
	//Test deplacerMonstre
	@Test
	void testDeplacerMonstre() { //le monstre M a la position [8,14][y,x]
		jeu.deplace_monstre(M);
		boolean test = false;
		if(jeu.p1.plateau[8][15]==7) { // si le monstres'est deplacé à droite
			test=true;
		}
		else if(jeu.p1.plateau[8][13]==7) { // si le monstres'est deplacé à gauche
			test=true;
		}
		else if(jeu.p1.plateau[9][14]==7) { // si le monstres'est deplacé en bas
			test=true;
		}
		else if(jeu.p1.plateau[7][14]==7) { // si le monstres'est deplacé en haut
			test=true;
		}
		assertTrue(test);
		
	}
	
	
	
}

