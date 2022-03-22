package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Controlleur.Control;
import Controlleur.Observer;

public class Partie
{
	// Cette classe représente une Partie. Celle ci est caractérisée par une map, une pioche et une liste de joueurs 
	private Map m;
	private DeckCarte pioche;
	private ArrayList<Joueur> listeJoueurs;
	private CompterPoints cp;
	private int nbManches;
	private Control C;
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public Partie(Map m,Control c)
	{
		// Constructeur de partie. On initialise la map, la pioche et les joueurs 
		this.m = m;
		this.listeJoueurs = new ArrayList<>();
		this.C = c;
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void initialiserPioche()
	{
		// Cette méthode permet d'initialiser la pioche (on crée 5 cartes aux coordonnées i;j) 
		ArrayList<Carte> lc = new  ArrayList<>();
		
		for (int i=0 ; i<3 ; i=i+1)
		{
			for (int j=0 ; j<3 ; j=j+1)
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
		// Cette méthode permet d'initialiser la couleur du joueur d'indice "numeroJoueur"
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
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public DeckCarte initialiserDeckCarteJoueur(String couleur)
	{
		// Cette méthode permet d'initialiser le deck de cartes du joueur en fonction de sa couleur 
		ArrayList<Carte> lc = new ArrayList<>();
		
		for (int c=0 ; c<4 ; c=c+1)
		{
			lc.add(c, this.pioche.getListCarte().get(c));
			this.pioche.getListCarte().remove(c);
		}
		return new DeckCarte(lc);
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void initialiserJoueurs(int nbJoueurs, List<String> pseudo)	// update : adapter pour MVC //
	{
		// Cette méthode permet d'initialiser les joueurs
		for (int i=0 ; i<nbJoueurs ; i=i+1)
		{
			String couleur = this.initialiserCouleursJoueur(i);
			
			DeckBlocs db = new DeckBlocs(couleur);
			DeckCarte dc = this.initialiserDeckCarteJoueur(couleur);
			
			Joueur j = new Joueur(pseudo.get(i), dc, db);
			this.listeJoueurs.add(j);
			this.cp = new CompterPoints(this.m, this.listeJoueurs);
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public int initialiserNombreManches()
	{
		// Cette méthode permet d'initialiser le nombre de manches d'une partie 
		int nbManches = 0;
		if (this.listeJoueurs.size() == 2)
		{
			nbManches = 4*2;
		}
		else if (this.listeJoueurs.size() == 4)
		{
			nbManches = 4*4;
		}
		else 
		{
			nbManches = 6*3;
		}

		return nbManches;
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void initialiserCoupJoueur(int indiceJoueur, int numeroCarte, int numeroBloc,int Quartier)	/* Mise a jour pour être utilisé dans le cadre du MVC */
	{
		// Cette méthode permet au joueur de jouer un coup
		Carte c = this.listeJoueurs.get(indiceJoueur).getListCartes().getListCarte().get(numeroCarte);
		Bloc b = this.listeJoueurs.get(indiceJoueur).getListBlocs().recupererBloc(numeroBloc);
		m.getListeQuartiers()[Quartier].getListesCases()[c.getAbscisse()][c.getOrdonne()].ajouterBloc(b);
		this.listeJoueurs.get(indiceJoueur).jouerCoup(numeroBloc, numeroCarte);
		this.listeJoueurs.get(indiceJoueur).piocher(this.pioche);
		Observer.Update_HandCard(indiceJoueur,this.listeJoueurs.get(indiceJoueur).getListCartes(),C);
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void compterPointsManche()
	{
		// Cette méthode permet de compter le nombre de points de chaque joueur sur une manche 
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
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public int rechercheGagnant()
	{
		// Cette méthode permet de chercher le gagnant d'une partie (renvoit -1 en cas d'égalité) 
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
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void jouerPartie()
	{
		// Cette méthode permet d'initialiser une Partie
		
		this.nbManches = this.initialiserNombreManches();
		
		
		// TEST
		/*
		this.compterPointsManche();
		
		for (Joueur j : this.listeJoueurs)
		{
			System.out.println("le joueur " + j.getPseudo() + " possede " + j.getNbPoints() + " points ");
		}
		*/
		// FIN DU TEST 
		
		/* RECHERCHE DU GAGNANT
		int gagnant = this.rechercheGagnant();
		
		if (gagnant == -1)
		{
			System.out.println("au moins 2 joueurs ont le meme nombre de points donc personne ne gagne");
		}
		else 
		{
			System.out.println("le joueur" + this.listeJoueurs.get(gagnant).getPseudo() + " a gagne");
		}
		*/
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void Turn_Signal(int player, int card, int bloc, int quarter)
	{
		this.nbManches = this.nbManches - 1;
		this.initialiserCoupJoueur(player,card,bloc,quarter);
	}
}