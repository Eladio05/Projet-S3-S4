package Model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Partie 
{
	private Map m;
	private DeckCarte pioche;
	private ArrayList<Joueur> listeJoueurs;
	
	
	public Partie()
	{
		this.m = new Map();	
		
		this.listeJoueurs = new ArrayList<>();
		
		this.initialiserPioche();
		//this.initialiserJoueurs();
	}

	private void initialiserPioche()
	{
		ArrayList<Carte> lc = new  ArrayList<>();
		
		for (int i=0 ; i<2 ; i=i+1)
		{
			for (int j=0 ; j<2 ; j=j+1)
			{
				for (int carte=0 ; carte<5 ; carte=carte+1)
				{
					lc.add(new Carte(i, j));
				}		
			}
		}
		
		this.pioche = new DeckCarte(lc);
		this.melangerPioche();
	}
	
	private void melangerPioche()
	{
		System.out.println(this.pioche);
		
		
		Random r = new Random();
		for (int i=0 ; i < 2000 ; i=i+1)
		{
			int indiceC1 = r.nextInt(this.pioche.getListCarte().size() - 0) + 0;
			int indiceC2 = r.nextInt(this.pioche.getListCarte().size() - 0) + 0;
			
			Carte c1 = this.pioche.getListCarte().get(indiceC1);
			
			this.pioche.getListCarte().set(indiceC1, this.pioche.getListCarte().get(indiceC2));
			this.pioche.getListCarte().set(indiceC2, c1);
		}
		
		System.out.println(this.pioche);
	}
	
	/*
	0-0 : IIIII
	0-1 : IIIII
	1-0 : IIIII
	1-1 : IIIII
	 */
	
	
	
	/*
	private void initialiserJoueurs()
	{
		
	}
	*/
}
