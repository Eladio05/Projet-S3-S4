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
		this.initialiserJoueurs();
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
		Random r = new Random();
		for (int i=0 ; i < 2000 ; i=i+1)
		{
			int indiceC1 = r.nextInt(this.pioche.getListCarte().size() - 0) + 0;
			int indiceC2 = r.nextInt(this.pioche.getListCarte().size() - 0) + 0;
			
			Carte c1 = this.pioche.getListCarte().get(indiceC1);
			
			this.pioche.getListCarte().set(indiceC1, this.pioche.getListCarte().get(indiceC2));
			this.pioche.getListCarte().set(indiceC2, c1);
		}
	}
	
	private void initialiserJoueurs()
	{
		
		int nbJoueurs = new Scanner(System.in).nextInt();
		for (int i=0 ; i<nbJoueurs ; i=i+1)
		{
			String pseudo = new Scanner(System.in).nextLine();
			String couleur = "";
			
			
			if (i == 0)
			{
				couleur = "Jaune";
			}
			else if (i == 1)
			{
				couleur = "Violet";
			}
			else if ( i==2 )
			{
				couleur = "Bleu";
			}
			else 
			{
				couleur = "Orange";
			}
			
			DeckBlocs db = new DeckBlocs(couleur);
			ArrayList<Carte> lc = new ArrayList<>();
			
			for (int c=0 ; c<4 ; c=c+1)
			{
				lc.add(c, this.pioche.getListCarte().get(c));
				this.pioche.getListCarte().remove(c);
			}
			
			DeckCarte dc = new DeckCarte(lc);
			Joueur j = new Joueur(pseudo, dc, db);
		}
		
		
		
	}

	
}
