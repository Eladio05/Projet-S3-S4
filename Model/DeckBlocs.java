package Model;

public class DeckBlocs 
{
	
	private Bloc[] listeBlocs;
	private int nbBlocs;
	private String couleur;
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public DeckBlocs(String couleur)
	{
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
	
	public Bloc retirerBloc(int numeroBloc)
	{
		Bloc[] tab = new Bloc[this.nbBlocs - 1];
		Bloc b = null;
		
		for (int i=0 ; i < this.nbBlocs - 1 ; i=i+1)
		{
			if (i < numeroBloc)
			{
				tab[i] = this.listeBlocs[i];
			}
			else if (i == numeroBloc)
			{
				b = this.listeBlocs[numeroBloc];
				tab[i] = this.listeBlocs[i+1];
			}
			else 
			{
				tab[i] = this.listeBlocs[i+1];
			}
		}
		
		this.nbBlocs = this.nbBlocs - 1;
		this.listeBlocs = tab;
		return b;
		
	}
		
	// ----------------------------------------------------------------------------------------------------------------
	
	public String toString()
	{
		System.out.println("test :" + this.nbBlocs);
		
		
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
