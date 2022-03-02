

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
	
	public int getAbcisse()
	{
		return this.abscisse;
	}
	
	public int getOrdonne()
	{
		return this.ordonne;
	}

	public String toString() 
	{
		// Cette méthode permet d'afficher une carte sous forme de chaine de caractères 
		return "Carte abscisse=" + abscisse + ", ordonne=" + ordonne;
	}
		
}
