

public class Quartier 
{
	/* 
	Cette classe repr�sente un quartier caract�ris� par un nombre
	de lignes et de colonnes (par d�faut 3;3) et une matrice de Cases 
	*/
	
	private int nbLignes;
	private int nbColonnes;
	private Case[][] listeCases;
	
	// ----------------------------------------------------------------------
	
	public Quartier(int nbLignes, int nbColonnes)
	{
		/* 
		Constructeur de Quartier. Chaque case 
		poss�de les coordonn�es (i, j) 
		*/
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
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
		// Cette m�thode permet de r�cup�rer le nombre de lignes 
		return this.nbLignes;
	}
	
	// ----------------------------------------------------------------------
	
	public int getNbColonnes()
	{
		// Cette m�thode permet de r�cup�rer le nombre de colonnes 
		return this.nbColonnes;
	}
	
	// ----------------------------------------------------------------------
	
	public Case[][] getListesCases()
	{
		// Cette m�thode permet de r�cup�rer la liste des cases 
		return this.listeCases;
	}
	
	// ----------------------------------------------------------------------
	
	public String toString()
	{
		// 
		/* 
		Cette m�thode permet de repr�senter un quartier 
		sous forme de chaine de caract�res 
		*/
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
