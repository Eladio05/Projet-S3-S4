package Model;

import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args)
	{
		DeckBlocs db = new DeckBlocs("Vert");
		
		Carte c1 = new Carte(0, 0);
		Carte c2 = new Carte(0, 1);
		Carte c3 = new Carte(1, 0);
		Carte c4 = new Carte(1, 1);
		ArrayList<Carte> lc = new ArrayList<>();
		lc.add(c1);
		lc.add(c2);
		lc.add(c3);
		lc.add(c4);
		
		DeckCarte dc = new DeckCarte(lc);
	
		Joueur j = new Joueur("Thomas", dc, db);
		
		System.out.println(j);
		
		j.jouerCoup(0, 0);
		System.out.println(j);
		
		j.jouerCoup(22, 2);
		System.out.println(j);
		
		j.annulerCoup();
		System.out.println(j);
		
		
		
		
	}
}
