package Model;

import java.util.ArrayList;

public class DeckCarte {
	/* 
	Cette classe représente la liste des cartes d'un joueur. 
	Elle est caractérisée par une liste de cartes et un nombre de cartes 
	 */
	
	private ArrayList<Carte> listCarte;
	private int nbCartes;
	
	// ----------------------------------------------------------------------------------
	
	public DeckCarte(ArrayList<Carte> carte) {
		// Constructeur de DeckCarte 
		listCarte = carte;
		nbCartes = listCarte.size();
	}
	
	// ----------------------------------------------------------------------------------
	
	public ArrayList<Carte> getListCarte() {
		// Cette méthode permet de récupérer la liste des cartes 
		return listCarte;
	}
	
	// ----------------------------------------------------------------------------------

	public void setListCarte(ArrayList<Carte> listCarte) {
		/* 
		Cette méthode permet de remplacer la liste des cartes par une
		autre liste de cartes 
		*/
		this.listCarte = listCarte;
	}
	
	// ----------------------------------------------------------------------------------

	public int getNbCartes() {
		// Cette méthode permet de récupérer le nombre de cartes 
		return nbCartes;
	}
	
	// ----------------------------------------------------------------------------------

	public void setNbCartes(int nbCartes) {
		// Cette méthode permet de modifier le nombre de cartes 
		this.nbCartes = nbCartes;
	}
	
	// ----------------------------------------------------------------------------------
	
	public String toString() {
		// Cette méthode d'afficher une liste de cartes sous forme de chaine de caractères 
		String s = " [ ";
		for (Carte C : this.listCarte){
			s += C.toString()+ " ; ";
		}
		return s + " ] ";
	}
	

	
	
	
	
}