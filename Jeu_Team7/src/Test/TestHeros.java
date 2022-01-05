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
import model.Jeu;
import model.Painter;
import model.Plateau1;


class TestHeros {
	Jeu jeu;
	int niveau;
	@BeforeEach
	public void setUp() {
		this.jeu=new Jeu("helpFilePacman.txt",1);
		this.niveau=1;		
	}
	
	@Test
	public void testgetPosHeros() { //on verif la position du heros
		assertTrue(this.jeu.getPosHeros(niveau)[0]==1);
		assertEquals(this.jeu.getPosHeros(niveau)[1],1);
	}
	@Test
	public void testdeplacerherosdroite() { 
		this.jeu.deplacer(Cmd.RIGHT, niveau);
		assertTrue(this.jeu.getPosHeros(niveau)[0]==2);
		assertEquals(this.jeu.getPosHeros(niveau)[1],1);
	}
	@Test
	public void testdeplacerherosbas() { 
		this.jeu.deplacer(Cmd.DOWN, niveau);
		assertTrue(this.jeu.getPosHeros(niveau)[0]==1);
		assertEquals(this.jeu.getPosHeros(niveau)[1],2);
	}
	@Test
	public void testdeplacerheroshaut() { 
		this.jeu.deplacer(Cmd.DOWN, niveau);
		this.jeu.deplacer(Cmd.UP, niveau);
		assertTrue(this.jeu.getPosHeros(niveau)[0]==1);
		assertEquals(this.jeu.getPosHeros(niveau)[1],1);
	}
	@Test
	public void testdeplacerherosgauche() { //reviens au depart
		this.jeu.deplacer(Cmd.RIGHT, niveau);
		this.jeu.deplacer(Cmd.LEFT, niveau);
		assertTrue(this.jeu.getPosHeros(niveau)[0]==1);
		assertEquals(this.jeu.getPosHeros(niveau)[1],1);
	}
	
	@Test
	public void testdeplacerherosMurExte() { // le heros ne doit pas bouger
		this.jeu.deplacer(Cmd.LEFT, niveau);
		assertTrue(this.jeu.getPosHeros(niveau)[0]==1);
		assertEquals(this.jeu.getPosHeros(niveau)[1],1);
	}
	@Test
	public void testdeplacerherosMurInte() { // le heros ne doit bouger qu'une fois vers la droite
		this.jeu.deplacer(Cmd.RIGHT, niveau);
		this.jeu.deplacer(Cmd.RIGHT, niveau);
		assertTrue(this.jeu.getPosHeros(niveau)[0]==2);
		assertEquals(this.jeu.getPosHeros(niveau)[1],1);
	}
	@Test
	public void testAtqSimple() { // on considere que tout les monstres ont 1 pv et le heros attaque autour de lui
		this.jeu.deplacer(Cmd.DOWN, niveau);
		this.jeu.deplacer(Cmd.ATT, niveau);
		assertTrue(this.jeu.p1.plateau[3][1]==7);
		
	}
	

}
