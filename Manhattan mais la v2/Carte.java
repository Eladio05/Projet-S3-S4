

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
		// Cette m�thode permet d'afficher une carte sous forme de chaine de caract�res 
		return "Carte abscisse=" + abscisse + ", ordonne=" + ordonne;
	}
		
}
