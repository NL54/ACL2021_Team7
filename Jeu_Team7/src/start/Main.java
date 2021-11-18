package start;

import model.Painter;
import engine.GameEngineGraphical;
import model.Controlleur;
import model.Jeu;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		Jeu game = new Jeu("helpFilePacman.txt");
		Painter painter = new Painter(game);
		Controlleur controller = new Controlleur();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}

}
