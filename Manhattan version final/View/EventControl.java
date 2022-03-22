package View;

import java.io.File;
import java.net.MalformedURLException;

// import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class EventControl	// visual feedback deactivated indefinitly, reason:impossible to reverse //
{
	private boolean[] check = { false,false,false };	// check if one object is already selected //
	private int[]     value = { -1 , -1 , -1 };			// register user input to be send to Model //
	private MediaPlayer[] effectlist = new MediaPlayer[4];
	
	public EventControl() throws MalformedURLException
	{
		File file_1 = new File("src\\SoundEffect\\Effect.mp3");
		File file_2 = new File("src\\SoundEffect\\EndTurn.mp3");
		File file_3 = new File("src\\SoundEffect\\BlocEffect.mp3");
		File file_4 = new File("src\\SoundEffect\\CardEffect.mp3");
		
		String tell_1 = file_1.toURI().toURL().toString();	Media sound_1 = new Media(tell_1);	this.effectlist[0] = new MediaPlayer(sound_1);
		String tell_2 = file_2.toURI().toURL().toString();	Media sound_2 = new Media(tell_2);	this.effectlist[1] = new MediaPlayer(sound_2);
		String tell_3 = file_3.toURI().toURL().toString();	Media sound_3 = new Media(tell_3);	this.effectlist[2] = new MediaPlayer(sound_3);
		String tell_4 = file_4.toURI().toURL().toString();	Media sound_4 = new Media(tell_4);	this.effectlist[3] = new MediaPlayer(sound_4);
	}
	
	public void OnClick_Event_Handler(ImageView node,int status,int target,int index,int type,boolean exe)	// activate a feedback // new combination of pressee & release //
	{
		//System.out.println(" control ; " + status + " : " + target + " : " + index + " : " + type);
		     if ( type == 1 && status == target )
		{
		    Play_Effect(3);
				 if ( node.getBlendMode() != null && exe == true )								{ /*node.setBlendMode(null);				*/	this.check[0] = false;	this.value[0] = -1;    }
			else if ( node.getBlendMode() == null && exe == true && this.check[0] == false )	{ /*node.setBlendMode(BlendMode.HARD_LIGHT);*/	this.check[0] = true ;	this.value[0] = index; }
		}
		else if ( type == 2 && status == target )
		{
			Play_Effect(2);
				 if ( node.getBlendMode() != null && exe == true )								{ /*node.setBlendMode(null);				*/	this.check[1] = false;	this.value[1] = -1;    }
			else if ( node.getBlendMode() == null && exe == true && this.check[1] == false )	{ /*node.setBlendMode(BlendMode.HARD_LIGHT);*/	this.check[1] = true ;	this.value[1] = index; }
		}
		
		if ( exe == true  && status == target )	{ node.setOpacity(0.5); }
		if ( exe == false && status == target )	{ node.setOpacity(1.0); }
	}
	
	public void OnClick_Event_Handler(GridPane node,int status,int target,int index,int type,boolean exe)	// activate a feedback // new combination of pressee & release //
	{
		if ( type == 3 )
		{	
			Play_Effect(0);
				 if ( node.getBlendMode() != null && exe == true )								{ /*node.setBlendMode(null);			*/	this.check[2] = false;	this.value[2] = -1;    }
			else if ( node.getBlendMode() == null && exe == true && this.check[2] == false )	{ /*node.setBlendMode(BlendMode.SCREEN);*/	this.check[2] = true ;	this.value[2] = index; }
		}
		
		if ( exe == true  && status == target )	{ node.setOpacity(0.5); }
		if ( exe == false && status == target )	{ node.setOpacity(1.0); }
	}
	
	public boolean Check_MoveSet()	// Verify for Empty spot //
	{ if ( this.value[0] == -1 || this.value[1] == -1 || this.value[2] == -1 )	{ return false; } else { return true; } }
	
	public void Play_Effect(int index)	// ALERTE // BOUTON DE FIN DE TOUR FONCTIONNE 1 FOIS SUR 2 //
	{ this.effectlist[index].play();	this.effectlist[index].stop(); }
	
	public int[] Get_Input()	{ return this.value; }
	
	public void Inverser()
	{
		     if ( this.value[0] == 0 )	{ this.value[0] = 3; }
		else if ( this.value[0] == 1 )	{ this.value[0] = 2; }
		else if ( this.value[0] == 2 )	{ this.value[0] = 1; }
		else if ( this.value[0] == 3 )	{ this.value[0] = 0; }
		     
		     if ( this.value[1] == 0 )	{ this.value[1] = 3; }
		else if ( this.value[1] == 1 )	{ this.value[1] = 2; }
		else if ( this.value[1] == 2 )	{ this.value[1] = 1; }
		else if ( this.value[1] == 3 )	{ this.value[1] = 0; }
	}
	
	public void Reseter()	// to be use when a moveset have been confirmed //
	{
		this.check[0] = false;	this.check[1] = false;	this.check[2] = false;
		this.value[0] = -1;		this.value[1] = -1;		this.value[2] = -1;
	}
}