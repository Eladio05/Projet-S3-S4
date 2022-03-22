package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class CompterPoints 
{
	/* 
	Cette classe représente le comptage de points. Celle ci est caractérisée 
	par une map et la liste des joueurs 
	 */
	
	private Map m;
	private ArrayList<Joueur> listeJoueurs;
	
	// ----------------------------------------------------------------------------------------------------------------------
	
	public CompterPoints(Map m, ArrayList<Joueur> listeJoueurs)
	{
		// Constructeur de CompterPoints. On initialiser la map et la liste de joueurs 
		this.m = m;
		this.listeJoueurs = listeJoueurs;
	}
	
	// ----------------------------------------------------------------------------------------------------------------------
	
	public int recupererIndice(int[] tab, int nb)
	{
		/* 
		Cette méthode permet de récupérer l'indice ou se situe nb dans tab 
		(si nb est présent plusieurs fois, on renvoit -1) 
		 */
		
		int compteurOccurrencesNb = 0;
		int indiceNb = 0;
		
		for (int i=0 ; i < tab.length ; i=i+1)
		{
			if (tab[i] == nb)
			{
				indiceNb = i;
				compteurOccurrencesNb = compteurOccurrencesNb + 1;
			}
		}
		
		if (compteurOccurrencesNb > 1)
		{
			return -1;
		}
		else 
		{
			return indiceNb;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------------------------

	public int retrouverJoueurCouleurBloc(String couleur)
	{
		/* 
		Cette méthode permet de retrouver l'indice du joueur de la liste de joueurs
		dont les blocs sont de couleur "couleur"
		*/
		
		int indice = -1;
		String couleurJoueur = "";
		int compteur = 0;
		
		for (Joueur j : this.listeJoueurs)
		{
			couleurJoueur = j.getListBlocs().getCouleur();
			if (couleur.equals(couleurJoueur))
			{
				indice = compteur;
			}
			compteur = compteur + 1;
		}
		
		return indice; 
	}
	
	// ----------------------------------------------------------------------------------------------------------------------
	
	public int compterNombrePointsHauteur() 
	{
		// Cette méthode permet de récupérer l'indice du joueur qui possède le bloc le plus haut 
		
		Bloc blocLePlusHaut = this.m.recupererBlocPlusHautMap();
		int gagnant = -1;
		if (blocLePlusHaut != null)
		{
			String couleurGagnant = blocLePlusHaut.getCouleur();
			gagnant = this.retrouverJoueurCouleurBloc(couleurGagnant);
		}
		return gagnant;
		
		//this.p.getListeJoueurs().get(j).setNbPoints(this.p.getListeJoueurs().get(j).getNbPoints() + 3);
	}
	
	// ----------------------------------------------------------------------------------------------------------------------
	
	public int[] compterNombrePointsPossedeSurMap()
	{
	
		//Cette méthode renvoit la liste des points dans laquelle on ajoute 1 point au joueur pour chaque bloc possédé 
		 
		int[] listePointsJoueurs = new int[] {0, 0, 0, 0};
		
		ArrayList<Bloc> listeDerniersBlocsMap = this.m.recupererListeDerniersBlocsMap();
		
		for (Bloc dernierBloc : listeDerniersBlocsMap)
		{
			String couleur = dernierBloc.getCouleur();
			int joueur = this.retrouverJoueurCouleurBloc(couleur);
			
			if (joueur != -1)
			{
				listePointsJoueurs[joueur] = listePointsJoueurs[joueur] + 1;
			}
			
		}

		return listePointsJoueurs;
	}
	
	// ----------------------------------------------------------------------------------------------------------------------
	
	public int[] compterNbBlocsPossedeParJoueurEtQuartier(int numeroQuartier)
	{ 
		/* 
		Cette méthode renvoit la liste des points dans laquelle on ajoute 
		2 points au joueur qui possède le quartier "numeroQuartier
		 */
		int[] listePointsJoueurs = new int[] {0, 0, 0, 0};
		String[][] couleurDerniersBlocsMap = this.m.recupererCouleurDerniersBlocsMap();
		
		for (String couleur : couleurDerniersBlocsMap[numeroQuartier])
		{
			int gagnant = this.retrouverJoueurCouleurBloc(couleur);
			
			if (gagnant != -1)
			{
				listePointsJoueurs[gagnant] = listePointsJoueurs[gagnant] + 2;
			}
			
		}
		
		return listePointsJoueurs;
	}
	
	// ----------------------------------------------------------------------------------------------------------------------

	public int[] compterNombrePointsPossedeParQuartier()
	{
		/* 
		Cette méthode renvoit la liste des points dans laquelle on aoute 2 points
		 à chaque fois qu'un joueur possède un quartier 
		*/
		int[] listePointsJoueurs = new int[] {0, 0, 0, 0};
		for (int numeroQuartier = 0 ; numeroQuartier < this.m.getNbQuartiers() ; numeroQuartier = numeroQuartier + 1)
		{
			
			int[] nbBlocsPossedeParJoueurEtQuartier = this.compterNbBlocsPossedeParJoueurEtQuartier(numeroQuartier);
			
			int nbPossedeMaximum = Arrays.stream(nbBlocsPossedeParJoueurEtQuartier).max().getAsInt();
			
			if (nbPossedeMaximum != 0)
			{
				int indiceMax = this.recupererIndice(nbBlocsPossedeParJoueurEtQuartier, nbPossedeMaximum);
				
				if (indiceMax != -1)
				{
					listePointsJoueurs[indiceMax] = listePointsJoueurs[indiceMax] + 2;	
				}
	
			}
			
		}
		return listePointsJoueurs;
	} 
			
}
