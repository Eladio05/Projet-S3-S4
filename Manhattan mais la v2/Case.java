

import java.util.ArrayList;

public class Case 
{ 
	/* 
	Cette classe représente une Case qui est caractérisée par une position en abcisse, 
	en ordonnée et une liste de blocs empilés
	 */
	private int abscisse;
	private int ordonnee;
	private ArrayList<Bloc> listeBlocs;
	
	// -------------------------------------------------------------------------------------------------
	
	public Case(int abscisse, int ordonnee)
	{
		// Constructeur de Case 
		this.abscisse = abscisse; 
		this.ordonnee = ordonnee;
		this.listeBlocs = new ArrayList<>();
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public ArrayList<Bloc> getListeBlocs()
	{
		// Cette méthode permet de récupérer la liste des blocs d'une case
		return this.listeBlocs;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public Bloc recupererDernierBloc()
	{
		//Cette méthode permet de récupérer le dernier bloc de la liste des blocs d'une case
		// (renvoit null si la liste des blocs est vide) 
		
		int nbBlocsCase = this.getListeBlocs().size();
		{
			if (nbBlocsCase == 0)
			{
				return null;
			}
			else 
			{
				return this.getListeBlocs().get(nbBlocsCase - 1); 
			}
		}
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public void ajouterBloc(Bloc b)
	{
		// Cette méthode permet d'ajouter un bloc à la fin de la liste des blocs d'une case
	
		Bloc dernierBloc = this.recupererDernierBloc();
		boolean peutAjouter = true;
		
		if (dernierBloc != null)
		{
			if (b.getTaille() < dernierBloc.getTaille())
			{
				peutAjouter = false;
			}
		}
		
		if (peutAjouter == true)
		{
			this.listeBlocs.add(b);
		}
		else 
		{
			System.out.println("On ne peut pas placer un bloc sur un bloc plus petit");
		}
		
		
		
		
		/*
		Bloc dernierBloc = this.recupererDernierBloc();
		boolean peutAjouter = true;
		
		if (dernierBloc != null)
		{
			if (b.getTaille() < dernierBloc.getTaille())
			{
				peutAjouter = false;
			}
		}
		
		if (peutAjouter == true)
		{
			this.listeBlocs.add(b);
		}
		else 
		{
			System.out.println("On ne peut pas placer un bloc sur un bloc plus petit");
		}
		*/
	}
	
	// ------------------------------------------------------------------------------------------------
	
	public String toString()
	{
		// Cette méthode permet d'afficher une case sous forme de chaine de caractères 
		return "[" + String.valueOf(this.abscisse) + " " + String.valueOf(this.ordonnee) + "]";
	}
	
}


 
