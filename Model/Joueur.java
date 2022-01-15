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
	
	public int getNbPoints()
	{
		return this.nbPoints;
	}
	
	public void setNbPoints(int nbPoints)
	{
		this.nbPoints = nbPoints;
	}
	
	public String toString()
	{
		return "";
	}
	
	/* PAS SUR QUE CETTE METHODE SOIT ICI 
	public void piocher(ArrayList<Carte> Pioche)
	{
		listCartes.getListCarte().add(Pioche.get(0));
		Pioche.remove(0);
	}
	*/
	
	public void jouerCoup(int nbBloc, int nbCarte) 
	{
		this.blocSauvegarde = this.listBlocs.retirerBloc(nbBloc);
		this.carteSauvegarde = this.listCartes.getListCarte().get(nbCarte);
		this.listCartes.getListCarte().remove(nbCarte);	
	}
	
	public void annulerCoup() 
	{
		this.listBlocs.ajouterBloc(this.blocSauvegarde);
		this.listCartes.getListCarte().add(this.carteSauvegarde);
		
		this.blocSauvegarde = null;
		this.carteSauvegarde = null;
	}
	

}
