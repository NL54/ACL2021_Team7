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
		
//	    JFrame frame = new JFrame("Exemple JButton");
//	    
//	    final JTextArea textArea = new JTextArea();
//	    textArea.setBounds(50,50, 180,20);
//	    
//	    //Créer le bouton
//	    JButton btn1 = new JButton("Cliquez ici");
//	    //Définir la position du bouton
//	    btn1.setBounds(50,100,20,40);
//	    //Créer le bouton
//	    JButton btn2 = new JButton("Cliquez ici");
//	    //Définir la position du bouton
//	    btn2.setBounds(110,100,20,40);
//	    
//	    //Créer le bouton
//	    JButton btn3 = new JButton("Cliquez ici");
//	    //Définir la position du bouton
//	    btn3.setBounds(170,100,20,40);
//	    
//	    
//	 
//	    btn1.addActionListener(new ActionListener(){
//	        public void actionPerformed(ActionEvent e){
//	                this.diff=1;
//	        }
//	    });
//	    btn2.addActionListener(new ActionListener(){
//	        public void actionPerformed(ActionEvent e){
//	                this.diff=2;
//	        }
//	    });
//	    btn3.addActionListener(new ActionListener(){
//	        public void actionPerformed(ActionEvent e){
//	                this.diff=3;
//	        }
//	    });
//	    //Ajouter le bouton et le textArea au frame
//	    frame.add(btn1);
//	    frame.add(btn2);
//	    frame.add(btn3);
//	    frame.add(textArea);
//	    frame.setSize(300,300);
//	    frame.setLayout(null);
//	    frame.setVisible(true);  
//	    System.out.println(diff);
//		int diff=0;
//		while (diff != 1 && diff!=2 && diff!=3) {
//			Scanner clavier = new Scanner(System.in);
//			
//			String diff1 = clavier.nextLine();
//			if (isInteger(diff1)==true) {
//				diff= Integer.parseInt(diff1);
//			}
//			if (diff != 1 && diff!=2 && diff!=3) {
//				System.out.println("La difficulté n'existe pas");
//			}
//			System.out.println(diff);
//		}
		// creation du jeu particulier et de son afficheur
		Jeu game = new Jeu("helpFilePacman.txt",1);
		Painter painter = new Painter(game);
		Controlleur controller = new Controlleur();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}

}

