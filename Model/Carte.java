package Model;

public class Carte 
{
	// Cette classe représente une carte caractérisée par une position en abcisse et en ordonnée 
	private int abscisse;
	private int ordonne;
	
	// -------------------------------------------------------------------------------------------------
	
	public Carte(int abscisse, int ordonne) 
	{
		// Constructeur de Carte 
		this.abscisse = abscisse;
		this.ordonne = ordonne;
	}
	
	// -------------------------------------------------------------------------------------------------

	public int getAbscisse() 
	{
		// Cette méthode permet de récupérer l'abcisse d'une carte 
		return abscisse;
	}
	
	// -------------------------------------------------------------------------------------------------

	public void setAbscisse(int abscisse) 
	{
		// Cette méthode permet de modifier l'abcisse d'une carte
		this.abscisse = abscisse;
	}
	
	// -------------------------------------------------------------------------------------------------

	public int getOrdonne() 
	{
		// Cette méthode permet de récupérer l'ordonnée d'une carte 
		return ordonne;
	}

	// -------------------------------------------------------------------------------------------------
	
	public void setOrdonne(int ordonne) 
	{
		// Cette méthode permet de modifier l'ordonnée d'une carte 
		this.ordonne = ordonne;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public String toString() 
	{
		// Cette méthode permet d'afficher une carte sous forme de chaine de caractères 
		return "Carte abscisse=" + abscisse + ", ordonne=" + ordonne;
	}
	
	
	
	
}
