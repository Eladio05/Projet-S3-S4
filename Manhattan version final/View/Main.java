package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application
{
	// Lien Background_Menu : https://www.pexels.com/fr-fr/photo/toits-de-la-ville-a-travers-le-plan-d-eau-pendant-la-nuit-3586966 //
	// Lien Background_A 	: https://www.pexels.com/fr-fr/photo/lumieres-de-la-ville-sous-le-ciel-nocturne-771881 //
	
    @Override
    public void start(Stage stage) throws Exception
    {
    	Menu M = new Menu(null);
    	Scene scene = new Scene(M.Menu_Launch(Screen.getPrimary().getBounds().getWidth(),Screen.getPrimary().getBounds().getHeight()));
	    
	    stage.setFullScreen(true);
	    stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
	    stage.setScene(scene);
	    stage.show();
        stage.setResizable(true);
        stage.setTitle("Prototype Plateau manathan");
    }
    
	public static void main (String [] args)
	{ Application.launch(args); }
}