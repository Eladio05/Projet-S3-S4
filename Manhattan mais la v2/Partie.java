

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
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public Partie()
	{
		// Constructeur de partie. On initialise la map, la pioche et les joueurs 
		this.m = new Map(6, 3, 3);	
		this.listeJoueurs = new ArrayList<>();
		
		this.initialiserPioche();
		this.melangerPioche();
		this.initialiserJoueurs();
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
			}
		}
		
	}
}