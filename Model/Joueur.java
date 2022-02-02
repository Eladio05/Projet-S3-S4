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
	
	public DeckCarte getListCartes() {
		return listCartes;
	}

	public DeckBlocs getListBlocs() {
		return listBlocs;
	}

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
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

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
	
	public Carte getCarteSauvegarde() {
		return carteSauvegarde;
	}

	public Bloc getBlocSauvegarde() {
		return blocSauvegarde;
	}

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
		int nbCartesTas = tas.getListCarte().size();
		
		
		Carte c = tas.getListCarte().get(nbCartesTas - 1);
		tas.getListCarte().remove(nbCartesTas - 1);
		this.listCartes.getListCarte().add(c);
		return tas;
	}
	
	
	
	

}
