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
				if (jeu.gagner==true){
						DessinerVictoire(im);
				}
				else {
					DessinerDefaite(im);
				
			}
		}
		else {
			if (jeu.niveau==jeu.niveaumax) {
				if (jeu.niveau==1) {
					DessinerPlateau1avecfin(im,jeu.p1f,jeu.niveau);
					DessinerHP(im, jeu.h.Hp);
				}
				if (jeu.niveau==3) {
					DessinerPlateau3avecfin(im,jeu.p3f,jeu.niveau);
					DessinerHP(im, jeu.h.Hp);
				}
				if (jeu.niveau==5) {
					DessinerPlateau5(im,jeu.p5,jeu.niveau);
					DessinerHP(im, jeu.h.Hp);
				}
				if (jeu.isFinished()==true) {
					DessinerVictoire(im);
				}
			}
			
			else {
				if (jeu.niveau == 1) {
					DessinerPlateau1(im, jeu.p1, 1);
					DessinerHP(im, jeu.h.Hp);
				}
				if (jeu.niveau == 2) {
					DessinerPlateau2(im, jeu.p2, jeu.niveau);
					DessinerHP(im, jeu.h.Hp);
				}
				if (jeu.niveau == 3) {
					DessinerPlateau3(im, jeu.p3, jeu.niveau);
					DessinerHP(im, jeu.h.Hp);
				}
				if (jeu.niveau == 4) {
					DessinerPlateau4(im, jeu.p4, jeu.niveau);
					DessinerHP(im, jeu.h.Hp);
				}
				if (jeu.niveau == 5) {
					DessinerPlateau5(im, jeu.p5, jeu.niveau);
					DessinerHP(im, jeu.h.Hp);
				}
				
			}
		}
	}
	public void DessinerAcceuil(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		String s =  "Bienvenue! Choisissez la difficulté (1,2,3)";
		crayon.drawString(s, 10*10, 10 * 40 + 60);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		String s1 =  "Dans la console";
		crayon.drawString(s1, 35*10, 12 * 40 + 60);
	}
	public void DessinerHP(BufferedImage im, int hp) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		String s = "HP :"+ hp;
		crayon.drawString(s, 33 * 25, 10 * 40 + 60);
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

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
//				if (p.plateau[j][i] == 0) {
//					try {
//						File file = new File(
//								"sol.png");
//						BufferedImage bufferedImage = ImageIO.read(file);
//						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
				if (p.plateau[j][i] == 1) {// murs

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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

					try {
						File file = new File(
								"tresor.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 6) {// passage

					try {
						File file = new File(
								"passage.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 7) {// monstre
					try {
						File file = new File(
								"monstre.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 8) {// monstre
					try {
						File file = new File(
								"Ghost.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 9) {// monstre
					try {
						File file = new File(
								"Ghost_mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 4) {// monstre
					try {
						File file = new File(
								"magie.png");
						
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 3) {// piege

					try {
						File file = new File(
								"piege.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				}
		}

			}
	public void DessinerPlateau1avecfin(BufferedImage im, Plateau1avecfin p, int niveau) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		String s = "Niveau " + niveau;
		crayon.drawString(s, p.taille * 18, p.taille * 40 + 60);

		for (int i = 0; i < p.taille; i++) {
			for (int j = 0; j < p.taille; j++) {
				if (p.plateau[j][i] == 10) {// murs contour

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 0) {
					try {
						File file = new File(
								"sol.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 1) {// murs

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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

					try {
						File file = new File(
								"tresor1.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 6) {// passage

					try {
						File file = new File(
								"passage.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 7) {// monstre
					try {
						File file = new File(
								"monstre.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 8) {// monstre
					try {
						File file = new File(
								"Ghost.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 9) {// monstre
					try {
						File file = new File(
								"Ghost_mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 4) {// monstre
					try {
						File file = new File(
								"magie.png");
						
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 3) {// piege

					try {
						File file = new File(
								"piege.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						File file = new File(
								"piege.png");
						BufferedImage bufferedImage2 = ImageIO.read(file);
						crayon.drawImage(bufferedImage2, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		}

			}
	
	public void DessinerPlateau3avecfin(BufferedImage im, Plateau3avecfin p, int niveau) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint(Color.red);
		crayon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 40));
		String s = "Niveau " + niveau;
		crayon.drawString(s, p.taille * 18, p.taille * 40 + 60);

		for (int i = 0; i < p.taille; i++) {
			for (int j = 0; j < p.taille; j++) {
				if (p.plateau[j][i] == 10) {// murs contour

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 0) {
					try {
						File file = new File(
								"sol.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 1) {// murs

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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

					try {
						File file = new File(
								"tresor1.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 6) {// passage

					try {
						File file = new File(
								"passage.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 7) {// monstre
					try {
						File file = new File(
								"monstre.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 8) {// monstre
					try {
						File file = new File(
								"Ghost.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 9) {// monstre
					try {
						File file = new File(
								"Ghost_mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 4) {// monstre
					try {
						File file = new File(
								"magie.png");
						
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 3) {// piege

					try {
						File file = new File(
								"piege.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 0) {
					try {
						File file = new File(
								"sol.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 1) {// murs

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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

					try {
						File file = new File(
								"tresor1.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 6) {// passage

					try {
						File file = new File(
								"passage.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 7) {// monstre
					try {
						File file = new File(
								"monstre.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 8) {// monstre
					try {
						File file = new File(
								"Ghost.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 9) {// monstre
					try {
						File file = new File(
								"Ghost_mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 4) {// monstre
					try {
						File file = new File(
								"magie.png");
						
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 3) {// piege

					try {
						File file = new File(
								"piege.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 0) {
					try {
						File file = new File(
								"sol.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 1) {// murs

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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

					try {
						File file = new File(
								"tresor1.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 6) {// passage

					try {
						File file = new File(
								"passage.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 7) {// monstre
					try {
						File file = new File(
								"monstre.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 8) {// monstre
					try {
						File file = new File(
								"Ghost.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 9) {// monstre
					try {
						File file = new File(
								"Ghost_mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 4) {// monstre
					try {
						File file = new File(
								"magie.png");
						
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 3) {// piege

					try {
						File file = new File(
								"piege.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 0) {
					try {
						File file = new File(
								"sol.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 1) {// murs

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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

					try {
						File file = new File(
								"tresor1.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 6) {// passage

					try {
						File file = new File(
								"passage.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 7) {// monstre
					try {
						File file = new File(
								"monstre.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 8) {// monstre
					try {
						File file = new File(
								"Ghost.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 9) {// monstre
					try {
						File file = new File(
								"Ghost_mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 4) {// monstre
					try {
						File file = new File(
								"magie.png");
						
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 3) {// piege

					try {
						File file = new File(
								"piege.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 0) {
					try {
						File file = new File(
								"sol.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 1) {// murs

					try {
						File file = new File(
								"mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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

					try {
						File file = new File(
								"tresor1.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 6) {// passage

					try {
						File file = new File(
								"passage.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (p.plateau[j][i] == 7) {// monstre
					try {
						File file = new File(
								"monstre.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 8) {// monstre
					try {
						File file = new File(
								"Ghost.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 9) {// monstre
					try {
						File file = new File(
								"Ghost_mur.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 4) {// monstre
					try {
						File file = new File(
								"magie.png");
						
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (p.plateau[j][i] == 3) {// piege

					try {
						File file = new File(
								"piege.png");
						BufferedImage bufferedImage = ImageIO.read(file);
						crayon.drawImage(bufferedImage, i * 40, j * 40, 40, 40, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
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
