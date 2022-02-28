package Model;

public class DeckBlocs 
{
	/* 
    Cette classe repr�sente la liste des blocs d'un joueur. Elle est caract�ris�e par une liste de blocs, le nombre
	de blocs et la couleur des blocs
	*/
	private Bloc[] listeBlocs;
	private int nbBlocs;
	private String couleur;
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public DeckBlocs(String couleur)
	{
		// Constructeur de DeckBlocs. On cr�e les 24 blocs de chaque taille et couleur 
		this.nbBlocs = 24;
		this.listeBlocs = new Bloc[this.nbBlocs];
		
		this.couleur = couleur;
		
		Bloc bTaille1 = new Bloc(couleur, 1);
		Bloc bTaille2 = new Bloc(couleur, 2);
		Bloc bTaille3 = new Bloc(couleur, 3);
		Bloc bTaille4 = new Bloc(couleur, 4);
		
		for (int i=0 ; i < this.nbBlocs ; i=i+1)
		{
			if (i < 11)
			{
				this.listeBlocs[i] = bTaille1;
			}
			else if (i >= 11 && i <  17)
			{
				this.listeBlocs[i] = bTaille2;
			}
			else if (i >= 17 && i < 21)
			{
				this.listeBlocs[i] = bTaille3;
			}
			else 
			{
				this.listeBlocs[i] = bTaille4;
			}
			
		}
		
	}  
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public int getNbBlocs()
	{
		// Cette m�thode permet de r�cup�rer le nombre de blocs du deck  
		return this.nbBlocs;
	}
	
	public String getCouleur()
	{
		// Cette m�thode permet de r�cup�rer la couleur du deck de blocs 
		return this.couleur;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public Bloc recupererBloc(int numeroBloc)
	{
		// Cette methode permet de r�cup�rer le bloc d'indice "numeroBloc" 
		return this.listeBlocs[numeroBloc];
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public Bloc retirerBloc(int numeroBloc)
	{
		// Cette m�thode permet de retirer le bloc d'indice "numeroBloc" 
		Bloc[] tab = new Bloc[this.nbBlocs - 1];
		Bloc b = null;
		
		for (int i=0 ; i < this.nbBlocs ; i=i+1)
		{
			if (i < numeroBloc)
			{
				tab[i] = this.listeBlocs[i];
			}
			else
			{
				if (i == numeroBloc)
				{
					b = this.listeBlocs[numeroBloc];
				}	
				
				if (i < this.nbBlocs - 1)
				{
					tab[i] = this.listeBlocs[i+1];
				}
				
			}

		}
		
		this.nbBlocs = this.nbBlocs - 1;
		this.listeBlocs = tab;
		return b;
		
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public void ajouterBloc(Bloc b)
	{
		// Cette m�thode permet d'ajouter un bloc � la fin de la liste des blocs 
		Bloc[] tab = new Bloc[this.nbBlocs + 1];
		for (int i=0 ; i < this.nbBlocs ; i=i+1)
		{
			tab[i] = this.listeBlocs[i];
		}
		tab[this.nbBlocs] = b;
		this.listeBlocs = tab;
		this.nbBlocs = this.nbBlocs + 1;
	}
		
	// ----------------------------------------------------------------------------------------------------------------
	
	public String toString()
	{
		// Cette m�thode permet d'afficher des blocs sous forme de chaine de caract�res 
		String s = "[ ";
		int compteur = 0;
		
		for (Bloc b : this.listeBlocs)
		{
			if (compteur == this.nbBlocs - 1)
			{
				s  = s + b.toString() + " ";
			}
			else 
			{
				s  = s + b.toString() + ", ";
			}
			
			compteur = compteur + 1;
		}
		return s + "]";	
	}

	

}
