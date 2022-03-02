

import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args)
	{
		// CASE 
		
		/*
		Case c1 = new Case(0, 0);
		System.out.println(c1.recupererDernierBloc());
		
		
		c1.ajouterBloc(new Bloc("rouge", 2));
		c1.ajouterBloc(new Bloc("vert", 3));
		c1.ajouterBloc(new Bloc("orange", 3));
		c1.ajouterBloc(new Bloc("jaune", 2));
		
		System.out.println(c1.getListeBlocs());
		System.out.println(c1.recupererDernierBloc());
		*/

		// MAP 
		
		/*
		Map m = new Map(6, 3, 3);
		System.out.println(m);
	
		m.getListeQuartiers()[2].getListesCases()[0][1].ajouterBloc(new Bloc("bleu", 1));
		m.getListeQuartiers()[3].getListesCases()[1][0].ajouterBloc(new Bloc("violet", 1));
		m.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("jaune", 1));
		m.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("vert", 1));
		
		m.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("orange", 3));
		m.getListeQuartiers()[1].getListesCases()[1][2].ajouterBloc(new Bloc("orange", 2));
		m.getListeQuartiers()[5].getListesCases()[1][2].ajouterBloc(new Bloc("jaune", 4));
		m.getListeQuartiers()[5].getListesCases()[2][1].ajouterBloc(new Bloc("jaune", 4));
		
		m.getListeQuartiers()[0].getListesCases()[2][2].ajouterBloc(new Bloc("orange", 2));
		m.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("orange", 3));
		m.getListeQuartiers()[2].getListesCases()[2][1].ajouterBloc(new Bloc("bleu", 1));
		m.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("orange", 2));
		
		m.getListeQuartiers()[5].getListesCases()[0][1].ajouterBloc(new Bloc("orange", 2));
		m.getListeQuartiers()[4].getListesCases()[1][0].ajouterBloc(new Bloc("jaune", 4));
		m.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("violet", 4));
		
		
		System.out.println(m.recupererListeDerniersBlocsMap());
		
		String[][] couleurDerniersBlocsMap = m.recupererCouleurDerniersBlocsMap();
		for (String[] gne : couleurDerniersBlocsMap)
		{
			for (String gne2 : gne)
			{
				System.out.print(gne2 + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		System.out.println(m.recupererBlocPlusHautMap());
		*/
		// COMPTERPOINTS 

		Map m = new Map(6, 3, 3);
		
		m.getListeQuartiers()[2].getListesCases()[0][1].ajouterBloc(new Bloc("bleu", 1));
		m.getListeQuartiers()[3].getListesCases()[1][0].ajouterBloc(new Bloc("violet", 1));
		m.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("jaune", 1));
		m.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("vert", 1));
		
		m.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("orange", 3));
		m.getListeQuartiers()[1].getListesCases()[1][2].ajouterBloc(new Bloc("orange", 2));
		m.getListeQuartiers()[5].getListesCases()[1][2].ajouterBloc(new Bloc("jaune", 4));
		m.getListeQuartiers()[5].getListesCases()[2][1].ajouterBloc(new Bloc("jaune", 4));
		
		m.getListeQuartiers()[0].getListesCases()[2][2].ajouterBloc(new Bloc("orange", 2));
		m.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("orange", 3));
		m.getListeQuartiers()[2].getListesCases()[2][1].ajouterBloc(new Bloc("bleu", 1));
		m.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("orange", 2));
		
		m.getListeQuartiers()[5].getListesCases()[0][1].ajouterBloc(new Bloc("orange", 2));
		m.getListeQuartiers()[4].getListesCases()[1][0].ajouterBloc(new Bloc("jaune", 4));
		m.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("violet", 4));
		
		DeckBlocs db1 = new DeckBlocs("orange");
		DeckBlocs db2 = new DeckBlocs("violet");
		DeckBlocs db3 = new DeckBlocs("bleu");
		DeckBlocs db4 = new DeckBlocs("jaune");
		
		ArrayList<Carte> lc = new ArrayList<>();
		lc.add(new Carte(0, 0));
		lc.add(new Carte(0, 1));
		lc.add(new Carte(1, 0));
		lc.add(new Carte(1, 1));
		DeckCarte dc = new DeckCarte(lc);
		
		Joueur j1 = new Joueur("j1", dc, db1);
		Joueur j2 = new Joueur("j2", dc, db2);
		Joueur j3 = new Joueur("j3", dc, db3);
		Joueur j4 = new Joueur("j4", dc, db4);
		
		ArrayList<Joueur> lj = new ArrayList<>();
		lj.add(j1);
		lj.add(j2);
		lj.add(j3);
		lj.add(j4);
		
		CompterPoints cp1 = new CompterPoints(m, lj);
		
		/*
		System.out.println(cp1.retrouverJoueurCouleurBloc("bleu"));
		System.out.println(cp1.retrouverJoueurCouleurBloc("orange"));
		System.out.println(cp1.retrouverJoueurCouleurBloc("Vert"));
		
		System.out.println(cp1.compterNombrePointsHauteur());

		int[] tab = cp1.compterNombrePointsPossedeSurMap();
		for (int t : tab)
		{
			System.out.print(t + " ");
		}
		*/
		
		/*
		int[] tab2 = cp1.compterNbBlocsPossedeParJoueurEtQuartier(0);
		for (int t : tab2)
		{
			System.out.print(t + " ");
		}
		
		int[] tab3 = cp1.compterNbBlocsPossedeParJoueurEtQuartier(5);
		for (int t : tab3)
		{
			System.out.print(t + " ");
		}
		*/
		
		/*
		int[] tab4 = cp1.compterNombrePointsPossedeParQuartier();
		for (int t : tab4)
		{
			System.out.print(t + " ");
		}
		*/
		
		
	}
}
