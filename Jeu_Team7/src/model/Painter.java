package model;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.GamePainter;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class Painter implements GamePainter {
	Jeu jeu;

	/**
	 * la taille des cases
	 */
	protected static final int WIDTH = 1000;
	protected static final int HEIGHT = 1000;

	/**
	 * appelle constructeur parent
	 * 
	 * @param game
	 *            le jeutest a afficher
	 */
	public Painter(Jeu a) {
		jeu = a;
		
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		if (jeu.niveau==1) {
		DessinerPlateau1(im,jeu.p1,1);
		}
		if (jeu.niveau==2) {
			DessinerPlateau2(im,jeu.p2,jeu.niveau);
			}
	}
	public void DessinerPlateau1(BufferedImage im,Plateau1 p,int niveau) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
        String s = "Niveau " + niveau;
        crayon.drawString(s, p.taille*18, p.taille*40+60);

		for (int i=0; i<p.taille ;i++) {
			for (int j=0; j<p.taille ;j++) {
				if (p.plateau[j][i]==10) {//murs contour
					
					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i*40, j*40 , 40, 40);
					}
				if (p.plateau[j][i]==1) {//murs
					
					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i*40, j*40 , 40, 40);
					}
				if (p.plateau[j][i]==2) {//heros
					
					crayon.setColor(Color.MAGENTA);
			crayon.fillOval(i*40, j*40 , 40, 40);
			}
				if (p.plateau[j][i]==5) {//tresor
					
					crayon.setColor(Color.YELLOW);
					crayon.fillOval(i*40, j*40 , 40, 40);
					
			}
				if (p.plateau[j][i]==6) {//passage
					
					crayon.setColor(Color.BLUE);
					crayon.fillOval(i*40, j*40 , 40, 40);
					
			}
				if (p.plateau[j][i]==3) {//piege
					
					crayon.setColor(Color.RED);
					crayon.fillOval(i*40, j*40 , 40, 40);
					
			}
		
			}
		}
		
	}
	public void DessinerPlateau2(BufferedImage im,Plateau2 p,int niveau) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
        String s = "Niveau " + niveau;
        crayon.drawString(s, p.taille*18, p.taille*40+60);

		for (int i=0; i<p.taille ;i++) {
			for (int j=0; j<p.taille ;j++) {
		
				if (p.plateau[j][i]==1) {// les murs
					
					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i*40, j*40 , 40, 40);
					}
				if (p.plateau[j][i]==2) {
					
					crayon.setColor(Color.MAGENTA);
			crayon.fillOval(i*40, j*40 , 40, 40);
			}
				if (p.plateau[j][i]==6) {
					
					crayon.setColor(Color.YELLOW);
					crayon.fillOval(i*40, j*40 , 40, 40);
			}
				if (p.plateau[j][i]==4) {// magie
					
					crayon.setColor(Color.white);
					crayon.fillOval(i*40, j*40 , 40, 40);
			}
				if (p.plateau[j][i]==6) {//passage
					
					crayon.setColor(Color.YELLOW);
					crayon.fillOval(i*40, j*40 , 40, 40);
			}
		
		
			}
		}
		
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

}
