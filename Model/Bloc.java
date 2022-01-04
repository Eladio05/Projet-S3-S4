package Model;

public class Bloc {
	private String Couleur;
	private int taille;
	
	// -------------------------------------------------------------------------------------------------
	
	public Bloc(String couleur, int taille) {
		super();
		Couleur = couleur;
		this.taille = taille;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public String getCouleur() {
		return Couleur;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public void setCouleur(String couleur) {
		Couleur = couleur;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public int getTaille() {
		return taille;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	// -------------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "Bloc Couleur=" + Couleur + ", taille=" + taille;
	}
	
	
	
	
	
	
}
