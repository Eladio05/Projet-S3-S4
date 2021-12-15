package Model;
public class Case 
{
	private int abcisse;
	private int ordonnee;
	
	public Case(int abcisse, int ordonnee)
	{
		this.abcisse = abcisse; 
		this.ordonnee = ordonnee;
	}
	
	public int getAbcisse()
	{
		return this.abcisse;
	}
	
	public void setAbcisse(int abcisse)
	{
		this.abcisse = abcisse;
	}
	
	public int getOrdonnee()
	{
		return this.ordonnee;
	}
	
	public void setOrdonnee(int ordonnee)
	{
		this.ordonnee = ordonnee;
	}
	
	public String toString()
	{
		return String.valueOf(this.abcisse) + " " + String.valueOf(this.ordonnee);
	}
}
