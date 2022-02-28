package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Map
{
	/*
	Cette classe repr�sente une map caract�ris�e par un nombre de quartier
	et une liste de quartiers 
	*/
	private int nbQuartiers;
	private Quartier[] listeQuartiers;
	
	// ---------------------------------------------------------------------------
	
	public Map()
	{
		// Constructeur de map. Chaque quartier poss�de le num�ro i 
		this.nbQuartiers = 6;
		this.listeQuartiers = new Quartier[this.nbQuartiers];
	
		for (int i = 0 ; i < this.listeQuartiers.length ; i=i+1)
		{
			this.listeQuartiers[i] = new Quartier();
		}
	}
	
	// ---------------------------------------------------------------------------
	
	public int getNbQuartiers() 
	{
		// Cette m�thode renvoit le nombre de quartiers 
		return this.nbQuartiers;
	}
	
	// ---------------------------------------------------------------------------
	
	public void setQuartier(Quartier q, int numero)
	{
		// Cette m�thode permet de modifier le quartier d'index "numero" 
		this.listeQuartiers[numero] = q;
	}
	
	// ---------------------------------------------------------------------------
	
	public Quartier getQuartier(int numero)
	{
		// Cette m�thode permet de r�cup�rer le quartier d'index "numero" 
		return this.listeQuartiers[numero];
	}
	
	// -----------------------------------------------------------------------------
	
	public ArrayList<ArrayList<Integer>> applatirMap()
	{
		/* 
		Cette m�thode permet d'applatir la map en matrice en matrice d'entiers 
		Chaque ligne poss�de l'indice du quartier, de l'abcisse de la case et de 
		l'ordonnee de la case.
		Cette m�thode est utile dans le calcul de comptage des points (voir Partie)
		pour �viter de r�p�ter du code 
		*/
		
		ArrayList<ArrayList<Integer>> indicesMap = new ArrayList<>();
		
		for (int i=0 ; i < this.getNbQuartiers() ; i=i+1)
		{
			Quartier q = this.getQuartier(i);
			int nbLignes = q.getNbLignes();
			int nbColonnes = q.getNbColonnes();
			
			for (int j=0 ; j<nbLignes ; j=j+1)
			{
				for (int k=0 ; k<nbColonnes ; k=k+1)
				{
					ArrayList<Integer> indicesCase = new ArrayList<>(Arrays.asList(i, j, k));
					indicesMap.add(indicesCase);
				}
			}
		}
		return indicesMap;
	}
		
	// ---------------------------------------------------------------------------
	
	public String toString()
	{
		// Cette m�thode permet d'afficher une map sous forme de chaine de caract�res 
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
