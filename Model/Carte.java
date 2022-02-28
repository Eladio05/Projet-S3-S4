package Model;

public class Carte 
{
	// Cette classe repr�sente une carte caract�ris�e par une position en abcisse et en ordonn�e 
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
		// Cette m�thode permet de r�cup�rer l'abcisse d'une carte 
		return abscisse;
	}
	
	// -------------------------------------------------------------------------------------------------

	public void setAbscisse(int abscisse) 
	{
		// Cette m�thode permet de modifier l'abcisse d'une carte
		this.abscisse = abscisse;
	}
	
	// -------------------------------------------------------------------------------------------------

	public int getOrdonne() 
	{
		// Cette m�thode permet de r�cup�rer l'ordonn�e d'une carte 
		return ordonne;
	}

	// -------------------------------------------------------------------------------------------------
	
	public void setOrdonne(int ordonne) 
	{
		// Cette m�thode permet de modifier l'ordonn�e d'une carte 
		this.ordonne = ordonne;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public String toString() 
	{
		// Cette m�thode permet d'afficher une carte sous forme de chaine de caract�res 
		return "Carte abscisse=" + abscisse + ", ordonne=" + ordonne;
	}
	
	
	
	
}
