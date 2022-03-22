

import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args)
	{
		// MAP 
		
		/*
		Map m = new Map(6, 3, 3);
		System.out.println(m);
	
		m.getListeQuartiers()[2].getListesCases()[0][1].ajouterBloc(new Bloc("Bleu", 1));
		m.getListeQuartiers()[3].getListesCases()[1][0].ajouterBloc(new Bloc("Violet", 1));
		m.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("Jaune", 1)); //OSEF
		m.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("Bleu", 1)); //OSEF
		
		m.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("Orange", 3)); //OSEF
		m.getListeQuartiers()[1].getListesCases()[1][2].ajouterBloc(new Bloc("Orange", 2));
		m.getListeQuartiers()[5].getListesCases()[1][2].ajouterBloc(new Bloc("Jaune", 4));
		m.getListeQuartiers()[5].getListesCases()[2][1].ajouterBloc(new Bloc("Jaune", 4));
		
		m.getListeQuartiers()[0].getListesCases()[2][2].ajouterBloc(new Bloc("Orange", 2));
		m.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("Orange", 3));
		m.getListeQuartiers()[2].getListesCases()[2][1].ajouterBloc(new Bloc("Bleu", 1));
		m.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("Orange", 2));
		
		m.getListeQuartiers()[5].getListesCases()[0][1].ajouterBloc(new Bloc("Orange", 2));
		m.getListeQuartiers()[4].getListesCases()[1][0].ajouterBloc(new Bloc("Jaune", 4));
		m.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("Violet", 4));
		
		
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

		/*
		Map m = new Map(6, 3, 3);
		
		m.getListeQuartiers()[2].getListesCases()[0][1].ajouterBloc(new Bloc("Bleu", 1));
		m.getListeQuartiers()[3].getListesCases()[1][0].ajouterBloc(new Bloc("Violet", 1));
		m.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("Jaune", 1)); //OSEF
		m.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("Bleu", 1)); //OSEF
		
		m.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("Orange", 3)); //OSEF
		m.getListeQuartiers()[1].getListesCases()[1][2].ajouterBloc(new Bloc("Orange", 2));
		m.getListeQuartiers()[5].getListesCases()[1][2].ajouterBloc(new Bloc("Jaune", 4));
		m.getListeQuartiers()[5].getListesCases()[2][1].ajouterBloc(new Bloc("Jaune", 4));
		
		m.getListeQuartiers()[0].getListesCases()[2][2].ajouterBloc(new Bloc("Orange", 2));
		m.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("Orange", 3));
		m.getListeQuartiers()[2].getListesCases()[2][1].ajouterBloc(new Bloc("Bleu", 1));
		m.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("Orange", 2));
		
		m.getListeQuartiers()[5].getListesCases()[0][1].ajouterBloc(new Bloc("Orange", 2));
		m.getListeQuartiers()[4].getListesCases()[1][0].ajouterBloc(new Bloc("Jaune", 4));
		m.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("Violet", 4));
		
		DeckBlocs db1 = new DeckBlocs("Orange");
		DeckBlocs db2 = new DeckBlocs("Violet");
		DeckBlocs db3 = new DeckBlocs("Bleu");
		DeckBlocs db4 = new DeckBlocs("Jaune");
		
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
		
		System.out.println(cp1.retrouverJoueurCouleurBloc("bleu"));
		System.out.println(cp1.retrouverJoueurCouleurBloc("orange"));
		System.out.println(cp1.retrouverJoueurCouleurBloc("Vert"));
		
		System.out.println(cp1.compterNombrePointsHauteur());

		int[] tab = cp1.compterNombrePointsPossedeSurMap();
		for (int t : tab)
		{
			System.out.print(t + " ");
		}
		
		
		
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
		
		
		
		int[] tab4 = cp1.compterNombrePointsPossedeParQuartier();
		for (int t : tab4)
		{
			System.out.print(t + " ");
		}
		*/ 
		
		Map m = new Map(6, 3, 3);
		
		m.getListeQuartiers()[2].getListesCases()[0][1].ajouterBloc(new Bloc("Bleu", 1));
		m.getListeQuartiers()[3].getListesCases()[1][0].ajouterBloc(new Bloc("Violet", 1));
		m.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("Jaune", 1)); //NON POSSEDE
		m.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("Bleu", 1)); //NON POSSEDE
		
		m.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("Orange", 3)); //NON POSSEDE
		m.getListeQuartiers()[1].getListesCases()[1][2].ajouterBloc(new Bloc("Orange", 2));
		m.getListeQuartiers()[5].getListesCases()[1][2].ajouterBloc(new Bloc("Jaune", 4));
		m.getListeQuartiers()[5].getListesCases()[2][1].ajouterBloc(new Bloc("Jaune", 4));
		
		m.getListeQuartiers()[0].getListesCases()[2][2].ajouterBloc(new Bloc("Orange", 2));
		m.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("Orange", 3));
		m.getListeQuartiers()[2].getListesCases()[2][1].ajouterBloc(new Bloc("Bleu", 1));
		m.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("Orange", 2));
		
		m.getListeQuartiers()[5].getListesCases()[0][1].ajouterBloc(new Bloc("Orange", 2));
		m.getListeQuartiers()[4].getListesCases()[1][0].ajouterBloc(new Bloc("Jaune", 4));
		m.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("Violet", 4));
		
		Partie p1 = new Partie(m);
		p1.initialiserPioche();
		p1.melangerPioche();
		p1.initialiserJoueurs();
		p1.jouerPartie();
		
		
		
		
		
	}
}
