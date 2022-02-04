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
	
	public DeckCarte getPioche()
	{
		return this.pioche;
	}
	
	public ArrayList<Joueur> getListeJoueurs()
	{
		return this.listeJoueurs;
	}

	public void initialiserPioche()
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
	}
	
	public void melangerPioche()
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
	
	public void initialiserJoueurs()
	{
		System.out.println("Entrez le nombre de joueurs");
		int nbJoueurs = new Scanner(System.in).nextInt();
		if(nbJoueurs>4 || nbJoueurs<=0) System.out.println("Erreur sur le nombre de joueur. Celui ci doit être compris entre 1 et 4");
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
				DeckCarte dc = new DeckCarte(lc);
				Joueur j = new Joueur(pseudo, dc, db);
				this.listeJoueurs.add(j);
			}
		}
		
	}
	
	public void JouerPartie()
	{
		
		int nbManches = 0;
		
		if(listeJoueurs.size() == 2 || listeJoueurs.size() == 4) 
		{
			nbManches = 4;
		}
		else if (listeJoueurs.size() == 3)
		{
			nbManches = 6;
		}
		
		for (int i=0 ; i < nbManches ; i=i+1)
		{
			for(int j=0;j<listeJoueurs.size();j++) 
			{
				Joueur J = listeJoueurs.get(j);
				
				System.out.println("Au tour de "+J.getPseudo());
				System.out.println(J);
				
				System.out.println("Choisir le bloc à jouer");
				int numeroBloc = new Scanner(System.in).nextInt();
				Bloc b = J.getListBlocs().recupererBloc(numeroBloc);
				
				System.out.println("Choisir la carte à jouer");
				int numeroCarte = new Scanner(System.in).nextInt();
				Carte c = J.getListCartes().getListCarte().get(numeroCarte);
				
				System.out.println("Choisir le quartier où jouer le bloc");
				System.out.println(this.m);
		
				int Quartier = new Scanner(System.in).nextInt();
				m.getQuartier(Quartier).getCase(c.getAbscisse(), c.getOrdonne()).AjoutListeBlocs(b);
				
				listeJoueurs.get(j).jouerCoup(numeroBloc, numeroCarte);
				J.piocher(this.pioche);
				
				System.out.println("--------------------------------------------------------");
			}
			

			this.compterNombrePointHauteur();
			
			for (Joueur j : this.listeJoueurs)
			{
				System.out.println("le joueur " + j.getPseudo() + " possede " + j.getNbPoints() + " points ");
			}
			 /*
			this.compterNombrePointPossede();
			this.compterNombrePointMajorite();
			*/
		}	
			
	}
	
	public void ajouterPoints(String couleurBloc, int nbPointsAAjouter)
	{
		int indiceJoueur = -1; 
		
		if (couleurBloc == "Jaune")
		{
			indiceJoueur = 0;
		}
		else if (couleurBloc == "Violet")
		{
			indiceJoueur = 1;
		}
		else if (couleurBloc == "Bleu")
		{
			indiceJoueur = 2;
		}
		else if (couleurBloc == "Orange")
		{
			indiceJoueur = 3;
		}
		
		Joueur j = this.listeJoueurs.get(indiceJoueur);
		j.setNbPoints(j.getNbPoints() + 3);	
	}
	
	
	public void compterNombrePointHauteur() 
	{
		String couleurGagnant="";
		int taille = 0;
		

		for(int i=0; i < this.m.getNbQuartiers() ; i++) 
		{
			Quartier q = this.m.getQuartier(i);
			int nbLignes = q.getNbLignes();
			int nbColonnes = q.getNbColonnes();
			
			for (int j=0 ; j < nbLignes ; j=j+1)
			{
				for (int k=0 ; k < nbColonnes ; k=k+1)
				{
					//System.out.println("abc" + i + " " + j + " " + k);
					Case c = q.getCase(j, k);
					
					int nbBlocsCase = c.getListeBlocs().size();
					if (nbBlocsCase != 0)
					{
						Bloc dernierBloc = c.getListeBlocs().get(nbBlocsCase - 1);
						int tailleDernierBloc = dernierBloc.getTaille();

						if (tailleDernierBloc > taille)
						{
							taille = tailleDernierBloc;
							couleurGagnant = dernierBloc.getCouleur();
						}
					}
					
					System.out.println("test " + c + couleurGagnant);
					
				}
			}
			
		}
		
		this.ajouterPoints(couleurGagnant, taille);
	}
	
	/*
	public void compterNombrePointHauteurtest() 
	{
		String couleurGagnant="";
		int taille = 0;
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA2");
		
		for(int i=0;i<m.getListeQuartiers().length;i++) 
		{
			for(int j=0;j<m.getQuartier(i).getListeCases().length;j++) 
			{
				System.out.println("ici");
				System.out.println(m.getQuartier(i) + " ");
				
	
				if(m.getQuartier(i).getCase(i, j).taille()> taille) 
				{
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
	*/ 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
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
	
	*/

	
}
