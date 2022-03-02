

import java.util.ArrayList;
import java.util.Arrays;

public class Map
{
	/*
	Cette classe représente une map caractérisée par un nombre de quartier
	et une liste de quartiers 
	*/
	
	private int nbQuartiers;
	private Quartier[] listeQuartiers;
	
	// ---------------------------------------------------------------------------
	
	public Map(int nbQuartiers, int nbLignes, int nbColonnes)
	{
		// Constructeur de map. Chaque quartier possède le numéro i 
		this.nbQuartiers = nbQuartiers;
		this.listeQuartiers = new Quartier[this.nbQuartiers];
	
		for (int i = 0 ; i < this.listeQuartiers.length ; i=i+1)
		{
			this.listeQuartiers[i] = new Quartier(nbLignes, nbColonnes);
		}
	}
	
	// ---------------------------------------------------------------------------
	
	public int getNbQuartiers() 
	{
		// Cette méthode renvoit le nombre de quartiers 
		return this.nbQuartiers;
	}
	
	public Quartier[] getListeQuartiers()
	{
		return this.listeQuartiers;
	}
	
	public ArrayList<Bloc> recupererListeDerniersBlocsMap()
	{
		ArrayList<Bloc> listeDerniersBlocsMap = new ArrayList<>();
		for (Quartier q : this.listeQuartiers)
		{
			for (Case[] listeCases : q.getListesCases())
			{
				for (Case c : listeCases)
				{
					Bloc dernierBloc = c.recupererDernierBloc();
					
					if (dernierBloc != null)
					{
						listeDerniersBlocsMap.add(dernierBloc);
					}
				}
			}
		}
		
		return listeDerniersBlocsMap;
	}
	
	
	public String[][] recupererCouleurDerniersBlocsMap()
	{
		int nbCases = this.listeQuartiers[0].getNbLignes() * this.listeQuartiers[0].getNbColonnes();
		String[][] couleurDerniersBlocsMap = new String[this.nbQuartiers][nbCases];
		int compteurQuartier = 0;
		int compteurCase = 0;
		
		
		for (Quartier q : this.listeQuartiers)
		{
			for (Case[] listeCases : q.getListesCases())
			{
				for (Case c : listeCases)
				{
					Bloc dernierBloc = c.recupererDernierBloc();
					
					if (dernierBloc != null)
					{
						String couleurDernierBloc = dernierBloc.getCouleur();
						couleurDerniersBlocsMap[compteurQuartier][compteurCase] = couleurDernierBloc;
					}
					compteurCase = compteurCase + 1;
				}
			}
			compteurQuartier = compteurQuartier + 1;
			compteurCase = 0;
		}
		
		return couleurDerniersBlocsMap;
	}
	
	public Bloc recupererBlocPlusHautMap()
	{
		Bloc blocLePlusHaut = null;
		int tailleBlocLePlusHaut = -1;
		ArrayList<Bloc> listeDerniersBlocsMap = this.recupererListeDerniersBlocsMap();
		
		for (Bloc dernierBloc : listeDerniersBlocsMap)
		{
			int tailleDernierBloc = dernierBloc.getTaille();
	
			if (tailleDernierBloc > tailleBlocLePlusHaut)
			{
				blocLePlusHaut = dernierBloc;
				tailleBlocLePlusHaut = dernierBloc.getTaille();
				
			}
		}
		return blocLePlusHaut;	
	}
	
	
	
	
	// ---------------------------------------------------------------------------
	
	public String toString()
	{
		// Cette méthode permet d'afficher une map sous forme de chaine de caractères 
		String s = "";
		int compteur = 1;
		
		for (Quartier q : this.listeQuartiers)
		{
			s = s + "Quartier : " + compteur + "\n" + q.toString() + "\n";
			compteur = compteur + 1;
		}
		
		s = s + "";
		return s;
	}
	

}

