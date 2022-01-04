import java.util.ArrayList;

public class Joueur {
	private String pseudo;
	private int nbPoints;
	private ArrayList<Carte> Listcarte;
	private Bloc[] ListBlocs;
	
	
	public Joueur(String pseudo,ArrayList<Carte> carte, Bloc[] blocs) {
		super();
		this.pseudo = pseudo;
		this.nbPoints = 0;
		this.ListBlocs = blocs;
		this.Listcarte = carte;
		
	}
	
	public void piocher() {
		
	}
	

}
