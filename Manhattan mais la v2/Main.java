

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
		
		Map m = new Map(6, 3, 3);
		//System.out.println(m);
		
		m.getListeQuartiers()[2].getListesCases()[0][1].ajouterBloc(new Bloc("gris", 1));
		m.getListeQuartiers()[3].getListesCases()[1][0].ajouterBloc(new Bloc("violet", 1));
		m.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("jaune", 1));
		m.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("vert", 1));
		
		m.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("orange", 3));
		m.getListeQuartiers()[1].getListesCases()[1][2].ajouterBloc(new Bloc("rose", 1));
		m.getListeQuartiers()[5].getListesCases()[1][2].ajouterBloc(new Bloc("jaune", 4));
		m.getListeQuartiers()[5].getListesCases()[2][1].ajouterBloc(new Bloc("jaune", 4));
		
		m.getListeQuartiers()[0].getListesCases()[2][2].ajouterBloc(new Bloc("rose", 2));
		m.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("rouge", 3));
		m.getListeQuartiers()[2].getListesCases()[2][1].ajouterBloc(new Bloc("bleu", 1));
		m.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("rose", 2));
		
		m.getListeQuartiers()[5].getListesCases()[0][1].ajouterBloc(new Bloc("rose", 1));
		m.getListeQuartiers()[4].getListesCases()[1][0].ajouterBloc(new Bloc("jaune", 4));
		m.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("violet", 4));
		
		
		/*
		System.out.println(m.recupererListeDerniersBlocsMap());
		
		String[][] couleurDerniersBlocsMap = m.recupererCouleurDerniersBlocsMap();
		for (String[] gne : couleurDerniersBlocsMap)
		{
			for (String gne2 : gne)
			{
				System.out.print(gne2 + " ");
			}
		}
		System.out.println("");
		
		System.out.println(m.recupererListeBlocsMap());
		*/
		
		System.out.println(m.recupererBlocPlusHautMap());
	
	
		
		// DECKBLOCS 
		
		// DECKCARTE 
		
		// JOUEUR 
		
		// COMPTERPOINTS 
		
		
	}
}
