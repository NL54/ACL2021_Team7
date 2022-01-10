package start;
import javax.swing.*;
import java.awt.event.*;
import model.Painter;

import java.util.Scanner;

import Test.ErreurJeu;
import engine.GameEngineGraphical;
import model.Controlleur;
import model.Jeu;

/**
 * lancement du moteur avec le jeu
 */
public class Main {
	static int diff;
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
		
//		//creation du jeu particulier et de son afficheur
//		Jeu game0 = new Jeu("helpFilePacman.txt",0);
//		Painter painter0 = new Painter(game0);
//		Controlleur controller0 = new Controlleur();
//		// classe qui lance le moteur de jeu generique
//		GameEngineGraphical engine0 = new GameEngineGraphical(game0, painter0, controller0);
//		engine0.run();
//
//		// classe qui lance le moteur de jeu generique
//		GameEngineGraphical engine0 = new GameEngineGraphical(game0, painter0, controller0);
//		engine0.run();
		//Créer un nouveau frame pour stocker le bouton
		JFrame frame = new JFrame("Choix de la difficulté");
	    

	    //Créer le bouton
	    JButton btn1 = new JButton("Difficulté 1");
	    //Définir la position du bouton
	    btn1.setBounds(50,100,150,50);
	    //Créer le bouton
	    JButton btn2 = new JButton("Difficulté 2");
	    //Définir la position du bouton
	    btn2.setBounds(350,100,150,50);
	    
	    //Créer le bouton
	    JButton btn3 = new JButton("Difficulté 3");
	    //Définir la position du bouton
	    btn3.setBounds(650,100,150,50);
	  //Ajouter le bouton et le textArea au frame

	    frame.add(btn1);
	    frame.add(btn2);
	    frame.add(btn3);
	    frame.setSize(900,300);
	    frame.setLayout(null);
	    frame.setVisible(true);  

	    System.out.println(diff);

		while (diff != 1 && diff!=2 && diff!=3) {
			
		    
		    
		    
		  
		    btn1.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent e){
		                diff=1;
		        }
		    });
		    btn2.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent e){
		                diff=2;
		        }
		    });
		    btn3.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent e){
		                diff=3;
		        }
		    });
		    
		}
		int difffinal=diff;
		// creation du jeu particulier et de son afficheur
		Jeu game = new Jeu("helpFilePacman.txt",difffinal);
		Painter painter = new Painter(game);
		Controlleur controller = new Controlleur();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}

}

