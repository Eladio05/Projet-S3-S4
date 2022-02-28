package Model;

public class Quartier 
{
	/* 
	Cette classe représente un quartier caractérisé par un nombre de lignes 
	et de colonnes (par défaut 3;3) et une matrice de Cases 
	*/
	
	private int nbLignes;
	private int nbColonnes;
	private Case[][] listeCases;
	
	// ----------------------------------------------------------------------
	
	public Quartier()
	{
		// Constructeur de Quartier. Chaque case possède les coordonnées (i, j) 
		this.nbLignes = 3;
		this.nbColonnes = 3;
		this.listeCases = new Case[this.nbLignes][this.nbColonnes];
		
		for (int i=0 ; i < this.nbLignes ; i=i+1)
		{
			for (int j=0 ; j < this.nbColonnes ; j=j+1)
			{
				this.listeCases[i][j] = new Case(i, j);
			}
		}
	
	}
	
	// ----------------------------------------------------------------------
	
	public int getNbLignes()
	{
		// Cette méthode permet de récupérer le nombre de lignes 
		return this.nbLignes;
	}
	
	// ----------------------------------------------------------------------
	
	public int getNbColonnes()
	{
		// Cette méthode permet de récupérer le nombre de colonnes 
		return this.nbColonnes;
	}
	
	// ----------------------------------------------------------------------
	
	public Case getCase(int x, int y)
	{
		// Cette méthode permet de récupérer la case aux coordonnées (i, j)
		return this.listeCases[x][y];
	}
	
	// ----------------------------------------------------------------------
	
	public void setCase(Case c, int x, int y)
	{
		// Cette méthode permet de modifier la case aux coordonnées (i, j) 
		this.listeCases[x][y] = c;
	}
	
	// ----------------------------------------------------------------------
	
	public String toString()
	{
		// Cette méthode permet de représenter un quartier sous forme de chaine de caractères 
		String s = "[\n";
		
		for (int i=0 ; i < this.nbLignes ; i=i+1)
		{
			for (int j=0 ; j < this.nbColonnes ; j=j+1)
			{
				if (i == this.nbLignes - 1 && j == this.nbColonnes - 1)
				{
					s = s + this.listeCases[i][j].toString() + "";
				}
				else 
				{
					s = s + this.listeCases[i][j].toString() + ", ";
				}	
			}
			s = s + "\n";
		}
		
		s = s + "]\n";
		return s;
	}

	
		
}
