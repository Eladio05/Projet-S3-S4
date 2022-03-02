

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Partie 
{
	// Cette classe représente une Partie. Celle ci est caractérisée par une map, une pioche et une liste de joueurs 
	private Map m;
	private DeckCarte pioche;
	private ArrayList<Joueur> listeJoueurs;
	private CompterPoints cp;
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public Partie(Map m)
	{
		// Constructeur de partie. On initialise la map, la pioche et les joueurs 
		//this.m = new Map(6, 3, 3);
		this.m = m;
		this.listeJoueurs = new ArrayList<>();
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void initialiserPioche()
	{
		// Cette méthode permet d'initialiser la pioche (on crée 5 cartes aux coordonnées i;j) 
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
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void melangerPioche()
	{
		// Cette méthode permet de mélanger la pioche après l'avoir initialisée 
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
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public String initialiserCouleursJoueur(int numeroJoueur)
	{
		String couleur = "";
		if (numeroJoueur == 0)
		{
			couleur = "Jaune";
		}
		else if (numeroJoueur == 1)
		{
			couleur = "Violet";
		}
		else if ( numeroJoueur==2 )
		{
			couleur = "Bleu";
		}
		else 
		{
			couleur = "Orange";
		}
		return couleur;
		
	}
	
	public DeckCarte initialiserDeckCarteJoueur(String couleur, String pseudo)
	{
		ArrayList<Carte> lc = new ArrayList<>();
		
		for (int c=0 ; c<4 ; c=c+1)
		{
			lc.add(c, this.pioche.getListCarte().get(c));
			this.pioche.getListCarte().remove(c);
		}
		return new DeckCarte(lc);
	}
	
	public void initialiserJoueurs()
	{
		// Cette méthode permet d'initialiser les joueurs 
		System.out.println("Entrez le nombre de joueurs");
		int nbJoueurs = new Scanner(System.in).nextInt();
		if(nbJoueurs>4 || nbJoueurs<=0) System.out.println("Erreur sur le nombre de joueurs. Celui ci doit être compris entre 1 et 4");
		
		else 
		{
			for (int i=0 ; i<nbJoueurs ; i=i+1)
			{
				System.out.println("Entrez le pseudo du Joueur "+ (i+1));
				String pseudo = new Scanner(System.in).nextLine();
				String couleur = this.initialiserCouleursJoueur(i);
				
				DeckBlocs db = new DeckBlocs(couleur);
				DeckCarte dc = this.initialiserDeckCarteJoueur(couleur, pseudo);
				
				Joueur j = new Joueur(pseudo, dc, db);
				this.listeJoueurs.add(j);
				this.cp = new CompterPoints(this.m, this.listeJoueurs);
			}
		}
	}
	
	public int initialiserNombreManches()
	{
		int nbManches = 0;
		if (this.listeJoueurs.size() == 2 || this.listeJoueurs.size() == 4)
		{
			nbManches = 4;
		}
		else 
		{
			nbManches = 6;
		}

		return nbManches;
	}
	

	public void initialiserCoupJoueur(int indiceJoueur)
	{
		Joueur j = this.listeJoueurs.get(indiceJoueur);
		System.out.println("Au tour de "+j.getPseudo());
	
		System.out.print("Choisir la carte à jouer : ");
		int numeroCarte = new Scanner(System.in).nextInt();
		Carte c = j.getListCartes().getListCarte().get(numeroCarte);
		
		System.out.print("Choisir le bloc à jouer : ");
		int numeroBloc = new Scanner(System.in).nextInt();
		Bloc b = j.getListBlocs().recupererBloc(numeroBloc);
		
		System.out.print("Choisir le quartier où jouer : ");
		System.out.println(this.m);
		int Quartier = new Scanner(System.in).nextInt();
		m.getListeQuartiers()[Quartier].getListesCases()[c.getAbcisse()][c.getOrdonne()].ajouterBloc(b);
		
		this.listeJoueurs.get(indiceJoueur).jouerCoup(numeroBloc, numeroCarte);
		j.piocher(this.pioche);
		System.out.println("--------------------------------------------------------");
	}
	
	
	public void compterPointsManche()
	{
		int joueur1 = this.cp.compterNombrePointsHauteur();
		int joueurs2[] = this.cp.compterNombrePointsPossedeSurMap();
		int joueurs3[] = this.cp.compterNombrePointsPossedeParQuartier();
		
		Joueur gagnantHauteur = this.listeJoueurs.get(joueur1);
		gagnantHauteur.setNbPoints(gagnantHauteur.getNbPoints() + 3);
		
		for (int joueur = 0 ; joueur < this.listeJoueurs.size(); joueur = joueur + 1)
		{
			Joueur gagnantPossedeMap = this.listeJoueurs.get(joueur);
			gagnantPossedeMap.setNbPoints(gagnantPossedeMap.getNbPoints() + joueurs2[joueur]);
		}

		for (int joueur = 0 ; joueur < this.listeJoueurs.size(); joueur = joueur + 1)
		{
			Joueur gagnantPossedeQuartier = this.listeJoueurs.get(joueur);
			gagnantPossedeQuartier.setNbPoints(gagnantPossedeQuartier.getNbPoints() + joueurs3[joueur]);
		}
	}
	
	public int rechercheGagnant()
	{
		int gagnant = 0;
		int nbPointsGagnant = 0;
		int compteurOccurrencesGagnant = 0;
		
		for (int indiceJoueur = 0 ; indiceJoueur < this.listeJoueurs.size(); indiceJoueur = indiceJoueur + 1)
		{
			Joueur j = this.listeJoueurs.get(indiceJoueur);
			int nbPointsJoueur = j.getNbPoints();
			
			if (nbPointsJoueur > nbPointsGagnant)
			{
				gagnant = indiceJoueur;
				nbPointsGagnant = nbPointsJoueur;
				compteurOccurrencesGagnant = 1;
			}
			else if (nbPointsJoueur == nbPointsGagnant)
			{
				compteurOccurrencesGagnant = compteurOccurrencesGagnant + 1;
			}
			
		}
		
		if (compteurOccurrencesGagnant > 1)
		{
			return -1;
		}
		else 
		{
			return gagnant;
		}
	}
	
	public void JouerPartie()
	{
		// Cette méthode permet de jouer une Partie entière 
		int nbManches = this.initialiserNombreManches();
	
		for (int i=0 ; i < nbManches ; i=i+1)
		{
			for(int indiceJoueur = 0 ; indiceJoueur < this.listeJoueurs.size(); indiceJoueur = indiceJoueur + 1) 
			{
				this.initialiserCoupJoueur(indiceJoueur);
			}
			
			this.compterPointsManche();
			
			for (Joueur j : this.listeJoueurs)
			{
				System.out.println("le joueur " + j.getPseudo() + " possede " + j.getNbPoints() + " points ");
			}
			
			
		}
	}
	
	
}