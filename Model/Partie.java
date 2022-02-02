package Model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Partie 
{
	private Map m;
	private DeckCarte pioche;
	private ArrayList<Joueur> listeJoueurs;
	
	
	public Partie()
	{
		this.m = new Map();	
		this.listeJoueurs = new ArrayList<>();
		
		this.initialiserPioche();
		this.initialiserJoueurs();
		this.JouerPartie();
	}

	private void initialiserPioche()
	{
		ArrayList<Carte> lc = new  ArrayList<>();
		
		for (int i=0 ; i<2 ; i=i+1)
		{
			for (int j=0 ; j<2 ; j=j+1)
			{
				for (int carte=0 ; carte<5 ; carte=carte+1)
				{
					lc.add(new Carte(i, j));
				}		
			}
		}
		
		this.pioche = new DeckCarte(lc);
		this.melangerPioche();
	}
	
	private void melangerPioche()
	{
		Random r = new Random();
		for (int i=0 ; i < 2000 ; i=i+1)
		{
			int indiceC1 = r.nextInt(this.pioche.getListCarte().size() - 0) + 0;
			int indiceC2 = r.nextInt(this.pioche.getListCarte().size() - 0) + 0;
			
			Carte c1 = this.pioche.getListCarte().get(indiceC1);
			
			this.pioche.getListCarte().set(indiceC1, this.pioche.getListCarte().get(indiceC2));
			this.pioche.getListCarte().set(indiceC2, c1);
		}
	}
	
	private void initialiserJoueurs()
	{
		System.out.println("Entrez le nombre de joueurs");
		int nbJoueurs = new Scanner(System.in).nextInt();
		if(nbJoueurs>4 || nbJoueurs<=0) System.out.println("Erreur sur le nombre de joueur (ne pas depasser 4)");
		else {
			for (int i=0 ; i<nbJoueurs ; i=i+1)
			{
				System.out.println("Entrez le pseudo du Joueur "+ (i+1));
				String pseudo = new Scanner(System.in).nextLine();
				String couleur = "";
			
			
				if (i == 0)
				{
					couleur = "Jaune";
				}
				else if (i == 1)
				{
					couleur = "Violet";
				}
				else if ( i==2 )
				{
					couleur = "Bleu";
				}
				else 
				{
					couleur = "Orange";
				}
			
				DeckBlocs db = new DeckBlocs(couleur);
				ArrayList<Carte> lc = new ArrayList<>();
			
				for (int c=0 ; c<4 ; c=c+1)
				{
					lc.add(c, this.pioche.getListCarte().get(c));
					this.pioche.getListCarte().remove(c);
				}
				System.out.println("Pioche attribué à chaque joueur");
				DeckCarte dc = new DeckCarte(lc);
				Joueur j = new Joueur(pseudo, dc, db);
				this.listeJoueurs.add(j);
				System.out.println(listeJoueurs.size());
				
			}
		}
		
	}
	
	public void JouerPartie(){
		if(listeJoueurs.size() == 2 || listeJoueurs.size() == 4) {
			for(int i=0; i<4;i++) {
				for(int j=0;j<listeJoueurs.size();j++) {
					Joueur J = listeJoueurs.get(j);
					System.out.println("Au tour de "+J.getPseudo());
					System.out.println("Choisir le bloc à jouer");
					int bloc = new Scanner(System.in).nextInt();
					System.out.println("Choisir la carte à jouer");
					int Carte = new Scanner(System.in).nextInt();
					listeJoueurs.get(j).jouerCoup(bloc, Carte);
					System.out.println("Choisir le quartier où jouer le bloc");
					int Quartier = new Scanner(System.in).nextInt();
					m.getQuartier(Quartier).getCase(J.getCarteSauvegarde().getAbscisse(), J.getCarteSauvegarde().getOrdonne()).AjoutListeBlocs(J.getBlocSauvegarde());
				}
				/*this.compterNombrePointHauteur();
				this.compterNombrePointPossede();
				this.compterNombrePointMajorite();*/
			}
		}
		else if(listeJoueurs.size() == 3) {
			for(int i=0; i<6;i++) {
				for(int j=0;j<listeJoueurs.size();j++) {
					Joueur J = listeJoueurs.get(i);
					System.out.println("Au tour de "+J.getPseudo());
					System.out.println("Choisir le bloc à jouer");
					int bloc = new Scanner(System.in).nextInt();
					System.out.println("Choisir la carte à jouer");
					int Carte = new Scanner(System.in).nextInt();
					listeJoueurs.get(j).jouerCoup(bloc, Carte);
					System.out.println("Choisir le quartier où jouer le bloc");
					int Quartier = new Scanner(System.in).nextInt();
					m.getQuartier(Quartier).getCase(J.getCarteSauvegarde().getAbscisse(), J.getCarteSauvegarde().getOrdonne()).AjoutListeBlocs(J.getBlocSauvegarde());
					System.out.println("Au joueur suivant :");
				}
				/*this.compterNombrePointHauteur();
				this.compterNombrePointPossede();
				this.compterNombrePointMajorite();*/
			}
		}	
	}
	
	public void compterNombrePointHauteur() {
		String couleurGagnant="";
		int taille = m.getQuartier(0).getCase(0, 0).taille();
		for(int i=0;i<m.getListeQuartiers().length;i++) {
			for(int j=0;j<m.getQuartier(i).getListeCases().length;j++) {
				if(m.getQuartier(i).getCase(i, j).taille()> taille) {
					taille = m.getQuartier(i).getCase(i, j).taille();
					Case caseG = m.getQuartier(i).getCase(i, j);
					int nbrBlocG = caseG.getListeBlocs().lastIndexOf(caseG.getListeBlocs());
					Bloc blocG = caseG.getListeBlocs().get(nbrBlocG);
					couleurGagnant = blocG.getCouleur();
				}
			}
		}
		for(int x=0;x<listeJoueurs.size();x++) {
			if(listeJoueurs.get(x).getListBlocs().getCouleur().equals(couleurGagnant)) {
				listeJoueurs.get(x).setNbPoints(listeJoueurs.get(x).getNbPoints()+3);
				System.out.println("Le joueurs qui gagne avec la tour la plus haute est : "+listeJoueurs.get(x).getPseudo());
			}
		}
	}
	
	public void compterNombrePointPossede() {
		for(int i=0;i<m.getListeQuartiers().length;i++) {
			for(int j=0;j<m.getQuartier(0).getListeCases().length;j++) {
				if(m.getQuartier(i).getCase(i, j).getListeBlocs().isEmpty()) {
					String couleur = null;
				}
				else{ 
					int lastBloc = m.getQuartier(i).getCase(i, j).getListeBlocs().lastIndexOf(m.getQuartier(i).getCase(i, j).getListeBlocs());
					String couleur = m.getQuartier(i).getCase(i, j).getListeBlocs().get(lastBloc).getCouleur();
				
					for(int x=0;x<this.listeJoueurs.size();x++) {
						if(this.listeJoueurs.get(x).getListBlocs().getCouleur().equals(couleur)) {
							this.listeJoueurs.get(x).setNbPoints(this.listeJoueurs.get(x).getNbPoints()+1);
						}
					}
				}
			}
		}
	}
	
	public void compterNombrePointMajorite() {
		for(int i=0;i<m.getListeQuartiers().length;i++) {
			int compteViolet=0;
			int compteJaune=0;
			int compteBleu=0;
			int compteOrange=0;
			for(int j=0;j<m.getQuartier(i).getListeCases().length;j++) {
				int lastBloc = m.getQuartier(i).getCase(i, j).getListeBlocs().lastIndexOf(m.getQuartier(i).getCase(i, j).getListeBlocs());
				String couleur = m.getQuartier(i).getCase(i, j).getListeBlocs().get(lastBloc).getCouleur();
				if(couleur.equals("Violet"))  compteViolet += 1;
				else if(couleur.equals("Jaune"))  compteJaune += 1;
				else if(couleur.equals("Bleu"))  compteBleu += 1;
				else if(couleur.equals("Orange"))  compteOrange += 1;
				
			}
			
			if(compteViolet> compteJaune && compteViolet > compteBleu && compteViolet>compteOrange) {
				for(int x=0;x<this.listeJoueurs.size();i++) {
					if(this.listeJoueurs.get(x).getListBlocs().getCouleur().equals("Violet")) {
						this.listeJoueurs.get(x).setNbPoints(this.listeJoueurs.get(x).getNbPoints()+2);
						System.out.println("Gagnant par majorité du quartier "+i+" : "+this.listeJoueurs.get(x).getPseudo());
					}
				}
			}
			
			else if(compteJaune> compteViolet && compteJaune > compteBleu && compteJaune>compteOrange) {
				for(int x=0;x<this.listeJoueurs.size();i++) {
					if(this.listeJoueurs.get(x).getListBlocs().getCouleur().equals("Jaune")) {
						this.listeJoueurs.get(x).setNbPoints(this.listeJoueurs.get(x).getNbPoints()+2);
						System.out.println("Gagnant par majorité du quartier "+i+" : "+this.listeJoueurs.get(x).getPseudo());
					}
				}
			}
			
			else if(compteBleu> compteViolet && compteBleu > compteJaune && compteBleu>compteOrange) {
				for(int x=0;x<this.listeJoueurs.size();i++) {
					if(this.listeJoueurs.get(x).getListBlocs().getCouleur().equals("Bleu")) {
						this.listeJoueurs.get(x).setNbPoints(this.listeJoueurs.get(x).getNbPoints()+2);
						System.out.println("Gagnant par majorité du quartier "+i+" : "+this.listeJoueurs.get(x).getPseudo());
					}
				}
			}
			
			else if(compteOrange> compteViolet && compteOrange > compteJaune && compteOrange>compteBleu) {
				for(int x=0;x<this.listeJoueurs.size();i++) {
					if(this.listeJoueurs.get(x).getListBlocs().getCouleur().equals("Orange")) {
						this.listeJoueurs.get(x).setNbPoints(this.listeJoueurs.get(x).getNbPoints()+2);
						System.out.println("Gagnant par majorité du quartier "+i+" : "+this.listeJoueurs.get(x).getPseudo());
					}
				}
			}
		}
	}

	
}
