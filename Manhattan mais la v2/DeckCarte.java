

import java.util.ArrayList;

public class DeckCarte {
	/* 
	Cette classe repr�sente la liste des cartes d'un joueur. 
	Elle est caract�ris�e par une liste de cartes et un nombre de cartes 
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
		// Cette m�thode permet de r�cup�rer la liste des cartes 
		return listCarte;
	}
	
	public String toString() {
		// Cette m�thode d'afficher une liste de cartes sous forme de chaine de caract�res 
		String s = " [ ";
		for (Carte C : this.listCarte){
			s += C.toString()+ " ; ";
		}
		return s + " ] ";
	}
	

	
	
	
	
}