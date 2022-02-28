package Model;

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
		this.m = new Map();	
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
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public DeckCarte getPioche()
	{
		// Cette méthode permet de récupérer la pioche 
		return this.pioche;
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------

	public ArrayList<Joueur> getListeJoueurs()
	{
		// Cette méthode permet de récupérer la liste des joueurs 
		return this.listeJoueurs;
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public int retrouverJoueurCouleurBloc(String couleur)
	{
		/* 
		Cette méthode permet de retrouver l'indice du joueur de la liste de joueurs
		dont les blocs sont de couleur "couleur"
		*/
		 
		int compteur = 0;
		String couleurJoueur = "";
		
		while (couleurJoueur != couleur)
		{
			couleurJoueur = this.listeJoueurs.get(compteur).getListBlocs().getCouleur();
			compteur = compteur + 1;	
		}
		return compteur - 1;	
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public Integer[] convertirTableauEnWrapper(int[] tab)
	{
		/* 
		Cette methode permet de convertir un int[] et Integer[] 
		Celui ci étant nécessaire pour récupérer l'indice de l'element le plus grand
		utilisé dans compterNombrePointsPossedeParQuartier
		*/
		
		Integer[] tab2 = new Integer[tab.length];
		int compteur = 0;
		
		for (int element : tab)
		{
			tab2[compteur] = Integer.valueOf(element);
			compteur = compteur + 1;
		}
		
		return tab2;
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void compterNombrePointsHauteur() 
	{
		// Cette méthode permet d'ajouter 3 points au joueur qui possède le bloc le plus haut de la map 
		String couleurGagnant="";
		int taille = 0;
		
		ArrayList<ArrayList<Integer>> indicesMap = this.m.applatirMap();
		
		for (ArrayList<Integer> indicesCase : indicesMap)
		{
			Quartier quartier = this.m.getQuartier(indicesCase.get(0));
			Case c = quartier.getCase(indicesCase.get(1), indicesCase.get(2));
			
			Bloc dernierBloc = c.recupererDernierBloc();
			
			if (dernierBloc != null)
			{
				int tailleDernierBloc = dernierBloc.getTaille();
				if (tailleDernierBloc > taille)
				{
					
		
					taille = tailleDernierBloc;
					couleurGagnant = dernierBloc.getCouleur();
				}
			}
			
		}
		
		int j = this.retrouverJoueurCouleurBloc(couleurGagnant);
		System.out.println(j);
		//System.out.println(listeJoueurs);
		this.listeJoueurs.get(j).setNbPoints(listeJoueurs.get(j).getNbPoints() + 3);
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void compterNombrePointsPossedeParQuartier()
	{
		/* 
		Cette méthode permet d'ajouter 2 points au joueur qui possède le plus de blocs sur
		chaque quartier 
		*/
		ArrayList<ArrayList<Integer>> indicesMap = this.m.applatirMap();
		Quartier nouveauQuartier = this.m.getQuartier(indicesMap.get(0).get(0));
		int[] lol = new int[] {0, 0, 0, 0};
		
		
		for (ArrayList<Integer> indicesCase : indicesMap)
		{
			Quartier quartier = this.m.getQuartier(indicesCase.get(0));
		
			if (quartier != nouveauQuartier)
			{
				Integer[] lol2 = this.convertirTableauEnWrapper(lol);
				
				int maxi = Arrays.stream(lol).max().getAsInt();
				
				if (maxi != 0)
				{
					int indiceMax = Arrays.asList(lol2).indexOf(maxi);
					
					this.listeJoueurs.get(indiceMax).setNbPoints(listeJoueurs.get(indiceMax).getNbPoints() + 2);
					lol = new int[] {0, 0, 0, 0}; 
					nouveauQuartier = quartier;
				}
			}
			
			Case c = quartier.getCase(indicesCase.get(1), indicesCase.get(2));
			Bloc dernierBloc = c.recupererDernierBloc();
				
			if (dernierBloc != null)
			{
				String couleur = dernierBloc.getCouleur();
				int joueur = this.retrouverJoueurCouleurBloc(couleur);
				lol[joueur] = lol[joueur] + 1;
				
			}
		}	
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void compterNombrePointsPossedeSurMap()
	{
		/* 
		Cette méthode permet d'ajouter 1 point a chaque fois qu'un joueur
		possède un bloc sur toute la map 
		*/ 
		
		ArrayList<ArrayList<Integer>> indicesMap = this.m.applatirMap();
		
		int[] lol = new int[] {0, 0, 0, 0};
		
		for (ArrayList<Integer> indicesCase : indicesMap)
		{
			
			Quartier quartier = this.m.getQuartier(indicesCase.get(0));
			Case c = quartier.getCase(indicesCase.get(1), indicesCase.get(2));
			Bloc dernierBloc = c.recupererDernierBloc();
			
			if (dernierBloc != null)
			{
				String couleur = dernierBloc.getCouleur();
				int joueur = this.retrouverJoueurCouleurBloc(couleur);
				//System.out.println(dernierBloc + " " + joueur);
				lol[joueur] = lol[joueur] + 1;	
			}
		}
		
		for (int joueur = 0 ; joueur < this.listeJoueurs.size() ; joueur = joueur + 1)
		{
			this.listeJoueurs.get(joueur).setNbPoints(this.listeJoueurs.get(joueur).getNbPoints() + lol[joueur]);
		}
		
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void JouerPartie()
	{
		// Cette méthode permet de jouer une Partie entière 
		
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
				
				System.out.print("Choisir la carte à jouer : ");
				int numeroCarte = new Scanner(System.in).nextInt();
				Carte c = J.getListCartes().getListCarte().get(numeroCarte);
				
				System.out.print("Choisir le bloc à jouer : ");
				int numeroBloc = new Scanner(System.in).nextInt();
				Bloc b = J.getListBlocs().recupererBloc(numeroBloc);
				
				System.out.print("Choisir le quartier où jouer : ");
				System.out.println(this.m);
		
				int Quartier = new Scanner(System.in).nextInt();
				m.getQuartier(Quartier).getCase(c.getAbscisse(), c.getOrdonne()).AjoutListeBlocs(b);
				
				listeJoueurs.get(j).jouerCoup(numeroBloc, numeroCarte);
				J.piocher(this.pioche);
				
				System.out.println("--------------------------------------------------------");
			}
			
			this.compterNombrePointsHauteur();
			this.compterNombrePointsPossedeParQuartier();
			this.compterNombrePointsPossedeSurMap();
			
			for (Joueur j : this.listeJoueurs)
			{
				System.out.println("le joueur " + j.getPseudo() + " possede " + j.getNbPoints() + " points ");
			}

		}
	}
			
}
