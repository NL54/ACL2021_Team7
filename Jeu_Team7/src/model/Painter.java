package model;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.GamePainter;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         afficheur graphique pour le game
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
	 * @param game le jeutest a afficher
	 */
	public Painter(Jeu a) {
		jeu = a;

	}

	/**
	 * methode redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		if (jeu.isFinished()==true) {
			DessinerVictoire(im);
		}
		else {
			if (jeu.niveau == 1) {
				DessinerPlateau1(im, jeu.p1, 1);
			}
			if (jeu.niveau == 2) {
				DessinerPlateau2(im, jeu.p2, jeu.niveau);
			}
			if (jeu.niveau == 3) {
				DessinerPlateau3(im, jeu.p3, jeu.niveau);
			}
			if (jeu.niveau == 4) {
				DessinerPlateau4(im, jeu.p4, jeu.niveau);
			}
			if (jeu.niveau == 5) {
				DessinerPlateau5(im, jeu.p5, jeu.niveau);
			}
			if (jeu.isFinished()==true) {
				DessinerVictoire(im);
			}
		}
	}
	public void DessinerVictoire(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		BufferedImage bufferedImage;
		File file1 = new File("tresor.png");
		try {
			bufferedImage = ImageIO.read(file1);
			crayon.drawImage(bufferedImage, 8 * 40, 14*40 , 400, 400, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File file = new File("heros.png");
		
		try {
			bufferedImage = ImageIO.read(file);
			crayon.drawImage(bufferedImage, 8 * 40, 0 , 400, 400, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		String s = "BRAVO, TU AS GAGNE :)";
		crayon.drawString(s, 15 * 18, 10 * 40 + 60);
	
		
		
	}
	public void DessinerDefaite(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		String s = "BRAVO, TU AS PERDU :)";
		crayon.drawString(s, 15 * 18, 10 * 40 + 60);
	}
	public void DessinerPlateau1(BufferedImage im, Plateau1 p, int niveau) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		String s = "Niveau " + niveau;
		crayon.drawString(s, p.taille * 18, p.taille * 40 + 60);

		for (int i = 0; i < p.taille; i++) {
			for (int j = 0; j < p.taille; j++) {
				if (p.plateau[j][i] == 10) {// murs contour

					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i * 40, j * 40, 40, 40);
				}
				if (p.plateau[j][i] == 1) {// murs

					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i * 40, j * 40, 40, 40);
				}
				if (p.plateau[j][i] == 2) {// hero
					try {
						File file = new File(
								"heros.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 5) {// tresor

					crayon.setColor(Color.YELLOW);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}
				if (p.plateau[j][i] == 6) {// passage

					crayon.setColor(Color.BLUE);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}
				if (p.plateau[j][i] == 7) {// monstre

					crayon.setColor(Color.GRAY);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}
				if (p.plateau[j][i] == 3) {// piege

					crayon.setColor(Color.RED);
					crayon.fillOval(i * 40, j * 40, 40, 40);
//					try {
//						File file = new File(
//								"C:\\Users\\ZBook\\git\\ACL2021_Team7\\piege.png");
//						BufferedImage bufferedImage2 = ImageIO.read(file);
//						crayon.drawImage(bufferedImage2, i * 40, j * 40, 40, 40, null);
//					} catch (IOException e) {
//						e.printStackTrace();
					}
				}

				}

			}
		

	

	public void DessinerPlateau2(BufferedImage im, Plateau2 p, int niveau) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		String s = "Niveau " + niveau;
		crayon.drawString(s, p.taille * 18, p.taille * 40 + 60);

		for (int i = 0; i < p.taille; i++) {
			for (int j = 0; j < p.taille; j++) {
				if (p.plateau[j][i] == 10) {// murs contour

					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i * 40, j * 40, 40, 40);
				}
				if (p.plateau[j][i] == 1) {// murs

					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i * 40, j * 40, 40, 40);
				}
				if (p.plateau[j][i] == 2) {// heros
					try {
						File file = new File(
								"heros.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 5) {// tresor

					crayon.setColor(Color.YELLOW);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}
				if (p.plateau[j][i] == 6) {// passage

					crayon.setColor(Color.BLUE);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}
				if (p.plateau[j][i] == 3) {// piege

					crayon.setColor(Color.RED);
					crayon.fillOval(i * 40, j * 40, 40, 40);
//					try {
//						File file = new File(
//								"C:\\Users\\ZBook\\git\\ACL2021_Team7\\piege.png");
//						BufferedImage bufferedImage = ImageIO.read(file);
//						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
//					} catch (IOException e) {
//						e.printStackTrace();
					

				}

			}
		}

	}

	public void DessinerPlateau3(BufferedImage im, Plateau3 p, int niveau) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		String s = "Niveau " + niveau;
		crayon.drawString(s, p.taille * 18, p.taille * 40 + 60);

		for (int i = 0; i < p.taille; i++) {
			for (int j = 0; j < p.taille; j++) {
				if (p.plateau[j][i] == 10) {// murs contour

					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i * 40, j * 40, 40, 40);
				}
				if (p.plateau[j][i] == 1) {// murs

					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i * 40, j * 40, 40, 40);
				}
				if (p.plateau[j][i] == 2) {// heros
					try {
						File file = new File(
								"heros.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 5) {// tresor

					crayon.setColor(Color.YELLOW);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}
				if (p.plateau[j][i] == 6) {// passage

					crayon.setColor(Color.BLUE);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}
				if (p.plateau[j][i] == 3) {// piege

					crayon.setColor(Color.RED);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}

			}
		}

	}

	public void DessinerPlateau4(BufferedImage im, Plateau4 p, int niveau) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		String s = "Niveau " + niveau;
		crayon.drawString(s, p.taille * 18, p.taille * 40 + 60);

		for (int i = 0; i < p.taille; i++) {
			for (int j = 0; j < p.taille; j++) {
				if (p.plateau[j][i] == 10) {// murs contour

					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i * 40, j * 40, 40, 40);
				}
				if (p.plateau[j][i] == 1) {// murs

					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i * 40, j * 40, 40, 40);
				}
				if (p.plateau[j][i] == 2) {// heros
					try {
						File file = new File(
								"heros.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 5) {// tresor

					crayon.setColor(Color.YELLOW);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}
				if (p.plateau[j][i] == 6) {// passage

					crayon.setColor(Color.BLUE);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}
				if (p.plateau[j][i] == 3) {// piege

					crayon.setColor(Color.RED);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}

			}
		}

	}

	public void DessinerPlateau5(BufferedImage im, Plateau5 p, int niveau) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		String s = "Niveau " + niveau;
		crayon.drawString(s, p.taille * 18, p.taille * 40 + 60);

		for (int i = 0; i < p.taille; i++) {
			for (int j = 0; j < p.taille; j++) {
				if (p.plateau[j][i] == 10) {// murs contour

					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i * 40, j * 40, 40, 40);
				}
				if (p.plateau[j][i] == 1) {// murs

					crayon.setColor(Color.DARK_GRAY);
					crayon.fillRect(i * 40, j * 40, 40, 40);
				}
				if (p.plateau[j][i] == 2) {// heros
					try {
						File file = new File(
								"heros.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 5) {// tresor

					crayon.setColor(Color.YELLOW);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}
				if (p.plateau[j][i] == 6) {// passage

					crayon.setColor(Color.BLUE);
					crayon.fillOval(i * 40, j * 40, 40, 40);

				}
				if (p.plateau[j][i] == 3) {// piege

					crayon.setColor(Color.RED);
					crayon.fillOval(i * 40, j * 40, 40, 40);

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
