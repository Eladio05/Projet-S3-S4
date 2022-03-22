

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
	
	// -----------------------------------------------------------------------------------------------
	
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
	
	// -----------------------------------------------------------------------------------------------
	
	public int getNbQuartiers() 
	{
		// Cette méthode permet de récupérer le nombre de quartiers 
		return this.nbQuartiers;
	}
	
	// -----------------------------------------------------------------------------------------------
	
	public Quartier[] getListeQuartiers()
	{
		// Cette méthode permet de récupérer la liste des quartiers 
		return this.listeQuartiers;
	}
	
	// -----------------------------------------------------------------------------------------------
	
	public ArrayList<Bloc> recupererListeDerniersBlocsMap()
	{
		// Cette méthode permet de récupérer la liste des derniers blocs de chaque case de la map
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
	
	// -----------------------------------------------------------------------------------------------
	
	
	public String[][] recupererCouleurDerniersBlocsMap()
	{
		/* 
		Cette méthode permet de récupérer la liste des couleurs des derniers blocs de chaque case de la map
		(si la case possède aucun bloc, on ajoute null à la liste)  
		Chaque ligne correspond aux couleurs d'un quartier 
		*/
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
	
	// -----------------------------------------------------------------------------------------------
	
	public Bloc recupererBlocPlusHautMap()
	{
		/* 
		Cette méthode permet de récupérer le premier bloc rencontré de la taille la plus haute de la map
		Par exemple, si il n'y a aucun bloc de taille 4, la taille la plus haute de la map vaut 3 
		et cette méthode renvoit le premier bloc rencontré de taille 3 
		*/
		
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
	
	// -----------------------------------------------------------------------------------------------
	
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

