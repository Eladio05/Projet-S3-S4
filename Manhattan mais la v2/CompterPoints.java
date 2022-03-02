

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
	
	public Integer[] convertirTableauEnWrapper(int[] tab)
	{
		//Cette methode permet de convertir un int[] et Integer[] 
		//Celui ci étant nécessaire pour récupérer l'indice de l'element le plus grand
		//utilisé dans compterNombrePointsPossedeParQuartier
		
		
		Integer[] tab2 = new Integer[tab.length];
		int compteur = 0;
		
		for (int element : tab)
		{
			tab2[compteur] = Integer.valueOf(element);
			compteur = compteur + 1;
		}
		
		return tab2;
	}
	
	public int retrouverJoueurCouleurBloc(String couleur)
	{
		/* 
		Cette méthode permet de retrouver l'indice du joueur de la liste de joueurs
		dont les blocs sont de couleur "couleur"
		*/
		
		int indice = 0;
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
			int joueur = this.retrouverJoueurCouleurBloc(couleur);
			listePointsJoueurs[joueur] = listePointsJoueurs[joueur] + 2;
		}
		
		return listePointsJoueurs;
	}

	public int[] compterNombrePointsPossedeParQuartier()
	{
		int[] listePointsJoueurs = new int[] {0, 0, 0, 0};
		for (int numeroQuartier = 0 ; numeroQuartier < this.m.getNbQuartiers() ; numeroQuartier = numeroQuartier + 1)
		{
			
			int[] nbBlocsPossedeParJoueurEtQuartier = this.compterNbBlocsPossedeParJoueurEtQuartier(numeroQuartier);
			Integer[] wrapperNbBlocsPossedeParJoueurEtQuartier  = this.convertirTableauEnWrapper(nbBlocsPossedeParJoueurEtQuartier);
			
			int nbPossedeMaximum = Arrays.stream(nbBlocsPossedeParJoueurEtQuartier).max().getAsInt();
			
			if (nbPossedeMaximum != 0)
			{
				int indiceMax = Arrays.asList(wrapperNbBlocsPossedeParJoueurEtQuartier).indexOf(nbPossedeMaximum);
				listePointsJoueurs[indiceMax] = listePointsJoueurs[indiceMax] + 2;	
			}
			
		}
		return listePointsJoueurs;
	} 
			
}
