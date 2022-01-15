package Model;

import java.util.ArrayList;

public class DeckCarte {
	private ArrayList<Carte> listCarte;
	private int nbCartes;
	
	public DeckCarte(ArrayList<Carte> carte) {
		listCarte = carte;
		nbCartes = listCarte.size();
	}
	
	public String toString() {
		String s = " [ ";
		for (Carte C : this.listCarte){
			s += C.toString()+ " ; ";
		}
		return s + " ] ";
	}

	public ArrayList<Carte> getListCarte() {
		return listCarte;
	}

	public void setListCarte(ArrayList<Carte> listCarte) {
		this.listCarte = listCarte;
	}

	public int getNbCartes() {
		return nbCartes;
	}

	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}
	

	
	
	
	
}