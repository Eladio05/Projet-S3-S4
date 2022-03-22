package Controlleur;

import java.util.ArrayList;
import java.util.List;

import Model.DeckCarte;

public interface Observer
{
	public static void Update_SG(int p, List<String> pseudo,Control C)		// Send to Model the names and number of player
	{
		C.Start_Game(p,pseudo);
	}
	
	public static void Update_3DInput(int np ,int player,int[] parameters,Control C) 			// Send to Model the moveset
	{
		C.Send_Moveset(np,player,parameters[0],parameters[1],parameters[2]);
	}
	
	public static void Recover_HandCard()		// Send to View the Card of the player
	{
		
	}
	
	public static void Update_HandCard(int player, DeckCarte deckCarte, Control C)		// Send the updated version of the card to the View //
	{
		List<Integer> recycled = new ArrayList<Integer>();
		for ( int i = 0 ; i < 4 ; i ++ )
		{
			int abs = deckCarte.getListCarte().get(i).getAbscisse();
			int ord = deckCarte.getListCarte().get(i).getOrdonne();
			
			     if ( abs == 0 && ord == 0 )	{ recycled.add(i,1); }
			else if ( abs == 1 && ord == 0 )	{ recycled.add(i,2); }
			else if ( abs == 2 && ord == 0 )	{ recycled.add(i,3); }
			else if ( abs == 0 && ord == 1 )	{ recycled.add(i,4); }
			else if ( abs == 1 && ord == 1 )	{ recycled.add(i,5); }
			else if ( abs == 2 && ord == 1 )	{ recycled.add(i,6); }
			else if ( abs == 0 && ord == 2 )	{ recycled.add(i,7); }
			else if ( abs == 1 && ord == 2 )	{ recycled.add(i,8); }
			else if ( abs == 2 && ord == 2 )	{ recycled.add(i,9); }
		}
		C.Send_Updated_HandCard(recycled,player);
	}
}
