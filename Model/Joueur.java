import java.util.ArrayList;

public class Joueur {
	private String pseudo;
	private int nbPoints;
	private DeckCarte Listcarte;
	private DeckBlocs ListBlocs;
	
	
	public Joueur(String pseudo,DeckCarte carte, DeckBlocs blocs) {
		super();
		this.pseudo = pseudo;
		this.nbPoints = 0;
		this.ListBlocs = blocs;
		this.Listcarte = carte;
		
	}
	
	public void piocher(ArrayList<Carte> Pioche){
		Listcarte.getListCarte().add(Pioche.get(0));
		Pioche.remove(0);
	}
	
	public void jouerCoup() {
		
	}
	
	public void annulerCoup() {
		
	}

}
