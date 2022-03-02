

import java.util.ArrayList;
import java.util.Arrays;

public class CompterPoints 
{
	private Map m;
	private ArrayList<Joueur> listeJoueurs;
	
	public CompterPoints(Map m, ArrayList<Joueur> listeJoueurs)
	{
		this.m = m;
		this.listeJoueurs = listeJoueurs;
	}
	
	public int recupererIndice(int[] tab, int nb)
	{
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
			if (couleur == couleurJoueur)
			{
				indice = compteur;
			}
			compteur = compteur + 1;
		}
		
		return indice; 
	}
	
	public int compterNombrePointsHauteur() 
	{
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
	
	public int[] compterNombrePointsPossedeSurMap()
	{
		//Cette méthode permet d'ajouter 1 point a chaque fois qu'un joueur
		//possède un bloc sur toute la map 
		 
		int[] listePointsJoueurs = new int[] {0, 0, 0, 0};
		
		ArrayList<Bloc> listeDerniersBlocsMap = this.m.recupererListeDerniersBlocsMap();
		
		for (Bloc dernierBloc : listeDerniersBlocsMap)
		{
			String couleur = dernierBloc.getCouleur();
			int joueur = this.retrouverJoueurCouleurBloc(couleur);
			listePointsJoueurs[joueur] = listePointsJoueurs[joueur] + 1;
			
		}

		return listePointsJoueurs;
	}
	
	public int[] compterNbBlocsPossedeParJoueurEtQuartier(int numeroQuartier)
	{                                       //2  3  1  1
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

	public int[] compterNombrePointsPossedeParQuartier()
	{
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
