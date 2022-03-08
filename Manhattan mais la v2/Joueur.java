

import java.util.ArrayList;

public class Joueur 
{
	/* Cette classe repr�sente une joueur caract�ris� par un pseudo, un nombre de points, un deck de blocs et un 
	deck de cartes. Il poss�de �galement une carte et un bloc permettant de sauvegarder le dernier coup jou� 
	(pour pouvoir �ventuellement l'annuler) 
	*/ 
	private String pseudo;
	private int nbPoints;
	private DeckCarte listCartes;
	private DeckBlocs listBlocs;
	private Carte carteSauvegarde;
	private Bloc blocSauvegarde;
	
	// ----------------------------------------------------------------------------------------------------------------

	public Joueur(String pseudo,DeckCarte carte, DeckBlocs blocs) 
	{
		// Constructeur de Joueur 
		this.pseudo = pseudo;
		this.nbPoints = 0;
		this.listBlocs = blocs;
		this.listCartes = carte;
		this.carteSauvegarde = null;
		this.blocSauvegarde = null;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public DeckBlocs getListBlocs() 
	{
		// Cette m�thode permet de r�cup�rer le deck de blocs du joueur 
		return listBlocs;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public DeckCarte getListCartes()
	{
		// Cette m�thode permet de r�cup�rer le deck de cartes du joueur 
		return this.listCartes;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public String getPseudo()
	{
		// Cette m�thode permet de r�cup�rer le pseudo du joueur
		return this.pseudo;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public void setNbPoints(int nbPoints)
	{
		// Cette m�thode permet de modifier le nombre de points d'un joueur 
		this.nbPoints = nbPoints;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public int getNbPoints()
	{
		// Cette m�thode permet de r�cup�rer le nombre de points d'un joueur
		return this.nbPoints;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public void jouerCoup(int nbBloc, int nbCarte) 
	{
		// Cette m�thode permet de jouer un coup (on retire le bloc et la carte des decks et on les sauvegarde) 
		Bloc b = this.listBlocs.retirerBloc(nbBloc);
		Carte c = this.listCartes.getListCarte().get(nbCarte);
		this.listCartes.getListCarte().remove(nbCarte);
		this.blocSauvegarde = b;
		this.carteSauvegarde = c;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public void annulerCoup() 
	{
		// Cette m�thode permet d'annuler un coup (on ajoute le bloc et la carte sauvegard�s aux decks) 
		this.listBlocs.ajouterBloc(this.blocSauvegarde);
		this.listCartes.getListCarte().add(this.carteSauvegarde);
		
		this.blocSauvegarde = null;
		this.carteSauvegarde = null;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	public DeckCarte piocher(DeckCarte tas)
	{
		// Cette m�thode permet de piocher (on r�cup�re la derni�re carte du tas et on l'ajoute au deck de cartes du joueur) 
		int nbCartesTas = tas.getListCarte().size();
		Carte c = tas.getListCarte().get(nbCartesTas - 1);
		tas.getListCarte().remove(nbCartesTas - 1);
		this.listCartes.getListCarte().add(c);
		return tas;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	
	public String toString()
	{
		// Cette m�thode permet d'afficher un joueur sous forme de chaine de caract�res 
		return this.pseudo + " =" + this.listCartes.toString() + " " + this.listBlocs.toString() + " " + this.nbPoints;
	}
	
}
