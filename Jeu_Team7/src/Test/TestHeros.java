package Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import engine.Cmd;
import engine.GameEngineGraphical;
import model.Controlleur;
import model.ErreurHeros;
import model.Jeu;
import model.Monstre;
import model.Painter;
import model.Plateau1;


class TestHeros {
	Jeu jeu;
	int niveau;
	@BeforeEach
	public void setUp() {
		this.jeu=new Jeu("helpFilePacman.txt",1);
		this.niveau=1;		
		for (int i=0;i<jeu.p1f.taille;i++) {
			for (int j=0;j<jeu.p1f.taille;j++) {
				jeu.p1f.plateau[i][j]=0;
			}
		}
		this.jeu.p1f.plateau[1][1]=2;
	}
	@Test
	public void testgetPosHerosSIpasdeHeros() { //on verif la position du heros
		try {
			this.jeu.p1f.plateau[1][1]=0;
			assertThrows(ErreurHeros.class,()->this.jeu.getPosHeros(niveau));
			this.jeu.getPosHeros(niveau);
			fail();
		} catch (ErreurHeros e) {
			// TODO Auto-generated catch block

		}
	}

	@Test
	public void testgetPosHeros() throws ErreurHeros { //on verif la position du heros
		assertTrue(this.jeu.getPosHeros(niveau)[0]==1);
		assertEquals(this.jeu.getPosHeros(niveau)[1],1);
	}
	@Test
	public void testdeplacerherosdroite() throws ErreurHeros { 
		this.jeu.deplacer(Cmd.RIGHT, niveau);
		assertTrue(this.jeu.getPosHeros(niveau)[0]==2);
		assertEquals(this.jeu.getPosHeros(niveau)[1],1);
	}
	@Test
	public void testdeplacerherosbas() throws ErreurHeros { 
		this.jeu.deplacer(Cmd.DOWN, niveau);
		assertTrue(this.jeu.getPosHeros(niveau)[0]==1);
		assertEquals(this.jeu.getPosHeros(niveau)[1],2);
	}
	@Test
	public void testdeplacerheroshaut() throws ErreurHeros { 
		this.jeu.deplacer(Cmd.UP, niveau);
		assertTrue(this.jeu.getPosHeros(niveau)[0]==1);
		assertEquals(this.jeu.getPosHeros(niveau)[1],0);
	}
	@Test
	public void testdeplacerherosgauche() throws ErreurHeros { 
		this.jeu.deplacer(Cmd.LEFT, niveau);
		assertTrue(this.jeu.getPosHeros(niveau)[0]==0);
		assertEquals(this.jeu.getPosHeros(niveau)[1],1);
	}
	@Test
	public void testdeplacerherosExteGauche() throws ErreurHeros { // le heros ne doit pas bouger
		this.jeu.p1f.plateau[1][1]=0;
		this.jeu.p1f.plateau[0][0]=2;
		
		try {
			assertThrows(ErreurHeros.class,()->this.jeu.deplacer(Cmd.LEFT, niveau));
			this.jeu.deplacer(Cmd.LEFT, niveau);
			fail();
		} catch (ErreurHeros e) {
			// TODO Auto-generated catch block

		}
	}
	@Test
	public void testdeplacerherosExteHaut() throws ErreurHeros { // le heros ne doit pas bouger
		this.jeu.p1f.plateau[1][1]=0;
		this.jeu.p1f.plateau[0][0]=2;
		
		try {
			assertThrows(ErreurHeros.class,()->this.jeu.deplacer(Cmd.UP, niveau));
			this.jeu.deplacer(Cmd.UP, niveau);
			fail();
		} catch (ErreurHeros e) {
			// TODO Auto-generated catch block

		}
	}
	@Test
	public void testdeplacerherosExteBas() throws ErreurHeros { // le heros ne doit pas bouger
		this.jeu.p1f.plateau[1][1]=0;
		this.jeu.p1f.plateau[18][18]=2;
		
		try {
			assertThrows(ErreurHeros.class,()->this.jeu.deplacer(Cmd.DOWN, niveau));
			this.jeu.deplacer(Cmd.DOWN, niveau);
			fail();
		} catch (ErreurHeros e) {
			// TODO Auto-generated catch block

		}
	}
	@Test
	public void testdeplacerherosExteDroit() throws ErreurHeros { // le heros ne doit pas bouger
		this.jeu.p1f.plateau[1][1]=0;
		this.jeu.p1f.plateau[18][18]=2;
		
		try {
			assertThrows(ErreurHeros.class,()->this.jeu.deplacer(Cmd.RIGHT, niveau));
			this.jeu.deplacer(Cmd.RIGHT, niveau);
			fail();
		} catch (ErreurHeros e) {
			// TODO Auto-generated catch block

		}
	}
	@Test
	public void testdeplacerherosMurExte() throws ErreurHeros { // le heros ne doit pas bouger
		this.jeu.p1f.plateau[1][0]=10;		
		this.jeu.deplacer(Cmd.LEFT, niveau);
		assertTrue(this.jeu.getPosHeros(niveau)[0]==1);
		assertEquals(this.jeu.getPosHeros(niveau)[1],1);
	}
	@Test
	public void testdeplacerherosMurInte() throws ErreurHeros { // le heros ne doit bouger qu'une fois vers la droite
		this.jeu.p1f.plateau[1][0]=1;
		this.jeu.deplacer(Cmd.LEFT, niveau);
		assertTrue(this.jeu.getPosHeros(niveau)[0]==1);
		assertEquals(this.jeu.getPosHeros(niveau)[1],1);
	}
	@Test
	public void testAtqSimple() throws ErreurHeros { // on considere que tout les monstres ont 1 pv et le heros attaque autour de lui
		this.jeu.p1f.plateau[1][2]=7;
		this.jeu.deplacer(Cmd.ATT, niveau);
		assertTrue(this.jeu.p1f.plateau[1][2]==7);
		
	}
	

}

