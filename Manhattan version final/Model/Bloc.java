package Model;

public class Bloc 
{
	// Cette classe représente un bloc caractérisé par une couleur et une taille 
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
		// Cette méthode permet de récupérer la couleur d'un bloc
		return Couleur;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public int getTaille() 
	{
		// Cette méthode permet de récupérer la taille d'un bloc 
		return taille;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public String toString() 
	{
		// Cette méthode permet d'afficher un bloc sous forme de chaine de caractères 
		return "Bloc Couleur=" + Couleur + ", taille=" + taille;
	}
	
}
