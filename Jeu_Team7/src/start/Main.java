package start;

import model.Painter;

import java.util.Scanner;

import engine.GameEngineGraphical;
import model.Controlleur;
import model.Jeu;

/**
 * lancement du moteur avec le jeu
 */
public class Main {
	public static boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}

	public static void main(String[] args) throws InterruptedException {
		int diff=0;
		
		while (diff != 1 && diff!=2 && diff!=3) {
			Scanner clavier = new Scanner(System.in);
			System.out.println("Choisissez la difficulté (1,2,3)");
			String diff1 = clavier.nextLine();
			if (isInteger(diff1)==true) {
				diff= Integer.parseInt(diff1);
			}
			if (diff != 1 && diff!=2 && diff!=3) {
				System.out.println("La difficulté n'existe pas");
			}
			System.out.println(diff);
		}
		// creation du jeu particulier et de son afficheur
		Jeu game = new Jeu("helpFilePacman.txt",diff);
		
		Painter painter = new Painter(game);
		Controlleur controller = new Controlleur();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}

}
