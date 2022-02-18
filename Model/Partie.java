package Model;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public Integer[] convertirTableauEnWrapper(int[] tab)
	{
		Integer[] tab2 = new Integer[tab.length];
		int compteur = 0;
		
		for (int element : tab)
		{
			tab2[compteur] = Integer.valueOf(element);
			compteur = compteur + 1;
		}
		
		return tab2;
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
	

	public int retrouverJoueurCouleurBloc(String couleur)
	{
		int compteur = 0;
		String couleurJoueur = "";
		
		while (couleurJoueur != couleur)
		{
			couleurJoueur = this.listeJoueurs.get(compteur).getListBlocs().getCouleur();
			compteur = compteur + 1;	
		}
		return compteur - 1;	
	}
	
	
	
	
	
	
	public void compterNombrePointsHauteur() 
	{
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
		System.out.println(listeJoueurs);
		this.listeJoueurs.get(j).setNbPoints(listeJoueurs.get(j).getNbPoints() + 3);
	}
	
	public void compterNombrePointsPossedeParQuartier()
	{
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
			
			for (int a : lol)
			{
				System.out.print(a);
			}
			System.out.println("");
		}
		
		
		
	}
	
	public void compterNombrePointsPossedeSurMap()
	{
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
				System.out.println(dernierBloc + " " + joueur);
				lol[joueur] = lol[joueur] + 1;	
			}
		}
		
		for (int e : lol)
		{
			System.out.print(e);
		}
		
		for (int joueur = 0 ; joueur < this.listeJoueurs.size() ; joueur = joueur + 1)
		{
			this.listeJoueurs.get(joueur).setNbPoints(this.listeJoueurs.get(joueur).getNbPoints() + lol[joueur]);
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
			
			//this.compterNombrePointsHauteur();
			//this.compterNombrePointsPossedeParQuartier();
			//this.compterNombrePointsPossedeSurMap();
			
			for (Joueur j : this.listeJoueurs)
			{
				System.out.println("le joueur " + j.getPseudo() + " possede " + j.getNbPoints() + " points ");
			}

		}
	}
			
}






















/*     


------------------------------  SERT DE BACKUP --------------------------------------------------------------


	public void ajouterPoints(int joueur, int nbPointsAAjouter)
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
		j.setNbPoints(j.getNbPoints() + nbPointsAAjouter);	
	}
	
	public void compterNombrePointsHauteur() 
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
					//System.out.println("TEST : " + i + " " + j + " " + k);
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
					
					//System.out.println("test " + c + couleurGagnant);
					
				}
			}
			
		}
		
		this.ajouterPoints(couleurGagnant, taille);
	}
	
	
	public void compterNombrePointsPossedeParQuartier()
	{
		for (int i=0 ; i < this.m.getNbQuartiers() ; i=i+1)
		{
			Quartier q = this.m.getQuartier(i);
			int nbLignes = q.getNbLignes();
			int nbColonnes = q.getNbColonnes();
			
			int[] compteurCasesPossedesQuartier = new int[4];
			String[] couleursBlocsJoueurs = {"Jaune", "Violet", "Bleu", "Orange"};
			
			for (int j=0 ; j < nbLignes ; j=j+1)
			{
				for (int k=0 ; k < nbColonnes ; k=k+1)
				{
					Case c = q.getCase(j, k);
					
					int nbBlocsCase = c.getListeBlocs().size();
					if (nbBlocsCase != 0)
					{
						Bloc dernierBloc = c.getListeBlocs().get(nbBlocsCase - 1);
						String couleurDernierBloc = dernierBloc.getCouleur();
						
						if (couleurDernierBloc == "Jaune")
						{
							compteurCasesPossedesQuartier[0] = compteurCasesPossedesQuartier[0] + 1;
						}
						else if (couleurDernierBloc == "Violet")
						{
							compteurCasesPossedesQuartier[1] = compteurCasesPossedesQuartier[1] + 1;
						}
						else if (couleurDernierBloc == "Bleu")
						{
							compteurCasesPossedesQuartier[2] = compteurCasesPossedesQuartier[2] + 1;
						}
						else if (couleurDernierBloc == "Orange")
						{
							compteurCasesPossedesQuartier[2] = compteurCasesPossedesQuartier[2] + 1;
						}
					}
				}
				
				Arrays.sort(compteurCasesPossedesQuartier);
				int joueurPossedePlusGrandNombreBlocs = compteurCasesPossedesQuartier[3];
				this.ajouterPoints(couleursBlocsJoueurs[joueurPossedePlusGrandNombreBlocs], 2);
				
				for (int l=0 ; l<4 ;l=l+1)
				{
					compteurCasesPossedesQuartier[l] = 0;
				}
			}
		}
	}
	
	public void compterNombrePointsPossedeSurMap()
	{
		int[] compteurCasesPossedesQuartier = new int[] {0, 0, 0, 0};
		String[] couleursBlocsJoueurs = {"Jaune", "Violet", "Bleu", "Orange"};
		
		for (int i=0 ; i < this.m.getNbQuartiers() ; i=i+1)
		{
			Quartier q = this.m.getQuartier(i);
			int nbLignes = q.getNbLignes();
			int nbColonnes = q.getNbColonnes();
			
			for (int j=0 ; j<nbLignes ; j=j+1)
			{
				for (int k=0 ; k<nbColonnes ; k=k+1)
				{
					Case c = q.getCase(j, k);
					int nbBlocsCase = c.getListeBlocs().size();
					
					if (nbBlocsCase != 0)
					{
						Bloc dernierBloc = c.getListeBlocs().get(nbBlocsCase - 1);
						String couleurDernierBloc = dernierBloc.getCouleur();
						
						if (couleurDernierBloc == "Jaune")
						{
							compteurCasesPossedesQuartier[0] = compteurCasesPossedesQuartier[0] + 1;
						}
						else if (couleurDernierBloc == "Violet")
						{
							compteurCasesPossedesQuartier[1] = compteurCasesPossedesQuartier[1] + 1;
						}
						else if (couleurDernierBloc == "Bleu")
						{
							compteurCasesPossedesQuartier[2] = compteurCasesPossedesQuartier[2] + 1;
						}
						else if (couleurDernierBloc == "Orange")
						{
							compteurCasesPossedesQuartier[2] = compteurCasesPossedesQuartier[2] + 1;
						}
					}
							
				}
			}
			
		}
		
		for (int joueur=0 ; joueur<4 ; joueur=joueur+1)
		{
			int nbBlocsPossedeJoueur = compteurCasesPossedesQuartier[joueur];
			this.ajouterPoints(couleursBlocsJoueurs[joueur], 1*nbBlocsPossedeJoueur);
		}
	}
	
}

public int recherchePlusGrand(int[] tableau)
{
	int plusGrand = -1;
	for (int i=0 ; i<tableau.length ; i=i+1)
	{
		if (tableau[i] > plusGrand)
		{
			plusGrand = tableau[i];
		}
	}
	return plusGrand;
}


// ----------------------------- CODE D'ELIOTT -------------------------------------------------
	

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

*/




