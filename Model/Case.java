package Model;

import java.util.ArrayList;

public class Case 
{
	// Cette classe repr�sente une Case qui est caract�ris�e par une position en abcisse, en ordonn�e et une liste de blocs empil�s 
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
	
	public int getAbscisse()
	{
		// Cette m�thode permet de r�cup�rer l'abcisse d'une case 
		return this.abscisse;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public void setAbscisse(int abcisse)
	{
		// Cette m�thode permet de modifier l'abcisse d'une case 
		this.abscisse = abcisse;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public int getOrdonnee()
	{
		// Cette m�thode permet de r�cup�rer l'ordonn�e d'une case 
		return this.ordonnee;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public void setOrdonnee(int ordonnee)
	{
		// Cette m�thode permet de modifier l'ordonn�e d'une case
		this.ordonnee = ordonnee;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public ArrayList<Bloc> getListeBlocs()
	{
		// Cette m�thode permet de r�cup�rer la liste des blocs d'une case
		return this.listeBlocs;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public void AjoutListeBlocs(Bloc b)
	{
		// Cette m�thode permet d'ajouter un bloc � la fin de la liste des blocs d'une case 
		this.listeBlocs.add(b);
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public Bloc recupererDernierBloc()
	{
		/* Cette m�thode permet de r�cup�rer le dernier bloc de la liste des blocs d'une case
		   (renvoit null si la liste des blocs est vide) 
		 */
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
	
	// ------------------------------------------------------------------
	
	public String toString()
	{
		// Cette m�thode permet d'afficher une case sous forme de chaine de caract�res 
		return "[" + String.valueOf(this.abscisse) + " " + String.valueOf(this.ordonnee) + "]";
	}
	
	// ------------------------------------------------------------------
	
}


 
