package Model;

public class Bloc 
{
	// Cette classe repr�sente un bloc caract�ris� par une couleur et une taille 
	private String Couleur;
	private int taille;
	
	// -------------------------------------------------------------------------------------------------
	
	public Bloc(String couleur, int taille) 
	{
		// Constructeur de Bloc 
		Couleur = couleur;
		this.taille = taille;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public String getCouleur() 
	{
		// Cette m�thode permet de r�cup�rer la couleur d'un bloc
		return Couleur;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	
	public void setCouleur(String couleur) 
	{
		// Cette m�thode permet de modifier la couleur d'un bloc 
		Couleur = couleur;
	}
	
	
	// -------------------------------------------------------------------------------------------------
	
	public int getTaille() 
	{
		// Cette m�thode permet de r�cup�rer la taille d'un bloc 
		return taille;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public void setTaille(int taille) 
	{
		// Cette m�thode permet de modifier la taille d'un bloc
		this.taille = taille;
	}
	
	// -------------------------------------------------------------------------------------------------

	public String toString() 
	{
		// Cette m�thode permet d'afficher un bloc sous forme de chaine de caract�res 
		return "Bloc Couleur=" + Couleur + ", taille=" + taille;
	}
	
}
