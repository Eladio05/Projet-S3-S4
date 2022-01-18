package Model;

import java.util.ArrayList;

public class Joueur 
{
	private String pseudo;
	private int nbPoints;
	private DeckCarte listCartes;
	private DeckBlocs listBlocs;
	
	private Carte carteSauvegarde;
	private Bloc blocSauvegarde;
	
	// ----------------------------------------------------------------------------------------------------------------

	public Joueur(String pseudo,DeckCarte carte, DeckBlocs blocs) 
	{
		super();
		this.pseudo = pseudo;
		this.nbPoints = 0;
		this.listBlocs = blocs;
		this.listCartes = carte;
		this.carteSauvegarde = null;
		this.blocSauvegarde = null;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public int getNbPoints()
	{
		return this.nbPoints;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public void setNbPoints(int nbPoints)
	{
		this.nbPoints = nbPoints;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public String toString()
	{
		return this.pseudo + " =" + this.listCartes.toString() + " " + this.listBlocs.toString() + " " + this.nbPoints;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public void jouerCoup(int nbBloc, int nbCarte) 
	{
		Bloc b = this.listBlocs.retirerBloc(nbBloc);
		
		Carte c = this.listCartes.getListCarte().get(nbCarte);
		this.listCartes.getListCarte().remove(nbCarte);
		
		this.blocSauvegarde = b;
		this.carteSauvegarde = c;
		
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public void annulerCoup() 
	{
		
		this.listBlocs.ajouterBloc(this.blocSauvegarde);
		this.listCartes.getListCarte().add(this.carteSauvegarde);
		
		this.blocSauvegarde = null;
		this.carteSauvegarde = null;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public DeckCarte piocher(DeckCarte tas)
	{
		Carte c = tas.getListCarte().get(0);
		tas.getListCarte().remove(0);
		this.listCartes.getListCarte().add(c);
		return tas;
	}
	
	
	
	

}
