package Model;
public class Case 
{
	/*
	changelog : V1
	- Creation de la classe
	*/


	private int abcisse;
	private int ordonnee;
	
	// -------------------------------------------------------------------------------------------------
	
	public Case(int abcisse, int ordonnee)
	{
		this.abcisse = abcisse; 
		this.ordonnee = ordonnee;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public int getAbcisse()
	{
		return this.abcisse;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public void setAbcisse(int abcisse)
	{
		this.abcisse = abcisse;
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
	
	public String toString()
	{
		return "[" + String.valueOf(this.abcisse) + " " + String.valueOf(this.ordonnee) + "]";
	}
	
	// -------------------------------------------------------------------------------------------------
	
	
	public Boolean equals(Case c)
	{
		
		System.out.println("on passe bien par ici");
		if (this.abcisse == c.abcisse && this.ordonnee == c.ordonnee)
		{
			
			return true;
		}
		else 
		{
			
			return false;
		}
	}
	

	
}
