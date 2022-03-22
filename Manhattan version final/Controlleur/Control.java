package Controlleur;

import java.util.List;

import Model.Map;
import Model.Partie;
import View.Menu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Control extends Application
{
		// Lien Background_Menu  : https://www.pexels.com/fr-fr/photo/toits-de-la-ville-a-travers-le-plan-d-eau-pendant-la-nuit-3586966 //
		// Lien Background_A 	 : https://www.pexels.com/fr-fr/photo/lumieres-de-la-ville-sous-le-ciel-nocturne-771881 //
		// Date Début assemblage : 09/03/2022 //
		// Auteur Model :
		// Auteur View  :
	
	private Partie p;
	private int NumberLoop;
	
	    @Override
	    public void start(Stage stage) throws Exception
	    {
	    	Menu M = new Menu(this);
	    	Scene scene = new Scene(M.Menu_Launch(Screen.getPrimary().getBounds().getWidth(),Screen.getPrimary().getBounds().getHeight()));
	    	/*----------------------*/
		    stage.setFullScreen(true);
		    stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		    stage.setScene(scene);
		    stage.show();
	        stage.setResizable(true);
	    }
	    
	    public void Start_Game(int nbrplayer, List<String> pseudo)	// start a game //
	    {
	    	Map m = new Map(6, 3, 3);	// liée avec towerlist coté View //
	    	this.p = new Partie(m,this);
	    	this.NumberLoop = p.initialiserNombreManches();
	    	
	    	p.initialiserPioche();
			p.melangerPioche();
			p.initialiserJoueurs(nbrplayer,pseudo);
			p.jouerPartie();
	    }
	    
	    public void Send_Updated_HandCard(List<Integer> values, int player)
	    {
	    	// require acces to plateau object //
	    }
	    
	    public void Send_Moveset(int np,int player,int card, int bloc, int quarter) // send the corresponding moveset //
	    {
	    	int real_player = -1;
	    	     if ( np == 2 )	{ if ( player == 1 ) { real_player = 0; }		else if ( player == 3 ) { real_player = 1; } }
	    	else if ( np == 3 )	{ if ( player == 1 ) { real_player = 0; }		else if ( player == 2 ) { real_player = 1; }		else if ( player == 4 ) { real_player = 2; } }
	    	else if ( np == 4 )	{ if ( player == 1 ) { real_player = 0; }		else if ( player == 2 ) { real_player = 1; }		else if ( player == 3 ) { real_player = 2; }		else if ( player == 4 ) { real_player = 3; } }
	    	
	    	this.p.Turn_Signal(real_player,card,bloc,quarter);
	    	this.NumberLoop = this.NumberLoop - 1;
	    }
	    
	    public void Is_End_Loop()
	    {
	    	// when a series of turn is over //
	    }
	    
		public static void main (String [] args)
		{ Application.launch(args); }
}