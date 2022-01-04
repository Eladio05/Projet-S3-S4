import java.util.ArrayList;

public class DeckCarte {
	private ArrayList<Carte> listCarte;
	private int nbCartes;
	
	public DeckCarte(ArrayList<Carte> carte) {
		listCarte = carte;
		nbCartes = listCarte.size();
	}
	
	public String toString() {
		for(Carte c : listCarte) {
			System.out.println("Position X = "+c.getAbscisse()+" Position Y = "+c.getOrdonne());
		}
		return "";
	}
}
