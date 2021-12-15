package Model;

public class Quartier 
{
	/*
	Changelog : V1
	- Creation de la classe
	*/
	private int nbLignes;
	private int nbColonnes;
	private Case[][] listeCases;
	
	// ----------------------------------------------------------------------
	
	public Quartier()
	{
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
	
	public Case getCase(int x, int y)
	{
		return this.listeCases[x][y];
	}
	
	// ----------------------------------------------------------------------
	
	public void setCase(Case c, int x, int y)
	{
		this.listeCases[x][y] = c;
	}
	
	// ----------------------------------------------------------------------
	
	public String toString()
	{
		String s = "[ ";
		
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
		}
		
		s = s + " ]";
		return s;
	}
		
}
