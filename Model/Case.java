package Model;

import java.util.ArrayList;

public class Case 
{
	private int abscisse;
	private int ordonnee;
	private ArrayList<Bloc> listeBlocs;
	
	// -------------------------------------------------------------------------------------------------
	
	public Case(int abscisse, int ordonnee)
	{
		this.abscisse = abscisse; 
		this.ordonnee = ordonnee;
		this.listeBlocs = new ArrayList<>();
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public int getAbscisse()
	{
		return this.abscisse;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public void setAbscisse(int abcisse)
	{
		this.abscisse = abcisse;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public int getOrdonnee()
	{
		return this.ordonnee;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public void setOrdonnee(int ordonnee)
	{
		this.ordonnee = ordonnee;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public ArrayList<Bloc> getListeBlocs()
	{
		return this.listeBlocs;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public void AjoutListeBlocs(Bloc b)
	{
		this.listeBlocs.add(b);
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public Bloc recupererDernierBloc()
	{
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
	
	public String toString()
	{
		return "[" + String.valueOf(this.abscisse) + " " + String.valueOf(this.ordonnee) + "]";
	}
	
	// ------------------------------------------------------------------
	
}


 
