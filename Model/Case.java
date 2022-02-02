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
	
	public String toString()
	{
		return "[" + String.valueOf(this.abscisse) + " " + String.valueOf(this.ordonnee) + "]";
	}
	
	// ------------------------------------------------------------------
	
	public int taille() {
		int cpt = 0;
		for(int i=0;i<this.listeBlocs.size();i++) {
			cpt += this.listeBlocs.get(i).getTaille();
		}
		return cpt;
	}
	
}


 
