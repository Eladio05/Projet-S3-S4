package Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Carte;
import Model.DeckBlocs;
import Model.DeckCarte;
import Model.Joueur;

public class TestJoueur 
{
	private Joueur j;
	
	@BeforeEach 
	public void setUp() 
	{
		DeckBlocs db = new DeckBlocs("Vert");
		
		ArrayList<Carte> lc = new ArrayList<>();
		lc.add(new Carte(0, 0));
		lc.add(new Carte(0, 1));
		lc.add(new Carte(0, 2));
		lc.add(new Carte(1, 0));
		
		DeckCarte dc = new DeckCarte(lc);
		
		this.j = new Joueur("Thomas", dc, db); 
	}
	    
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	    
	@AfterEach 
	public void tearDown()
	{
	    this.j = null; 
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void testGetNbPoints()
	{
		assertEquals(0, this.j.getNbPoints());
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void testSetNbPoints()
	{
		this.j.setNbPoints(4);
		assertEquals(4, this.j.getNbPoints());
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test 
	public void testToString()
	{
		assertEquals("Thomas = [ Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=0, ordonne=2 ; Carte abscisse=1, ordonne=0 ;  ]"
				+ "  [ Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, "
				+ "Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4 ] 0", this.j.toString());
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test 
	public void testJouerCoup1()
	{
		this.j.jouerCoup(0, 0);
		assertEquals("Thomas = [ Carte abscisse=0, ordonne=1 ; Carte abscisse=0, ordonne=2 ; Carte abscisse=1, ordonne=0 ;  ]"
				+ "  [ Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, "
				+ "Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4 ] 0", this.j.toString());
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test 
	public void testJouerCoup2()
	{
		this.j.jouerCoup(1, 2);
		assertEquals("Thomas = [ Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=1, ordonne=0 ;  ]"
				+ "  [ Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, "
				+ "Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4 ] 0", this.j.toString());
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test 
	public void testJouerCoup3()
	{
		this.j.jouerCoup(14, 3);
		assertEquals("Thomas = [ Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=0, ordonne=2 ;  ]"
				+ "  [ Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, "
				+ "Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4 ] 0", this.j.toString());
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test 
	public void testJouerCoup4()
	{
		this.j.jouerCoup(19, 2);
		assertEquals("Thomas = [ Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=1, ordonne=0 ;  ]"
				+ "  [ Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, "
				+ "Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4 ] 0", this.j.toString());
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test 
	public void testJouerCoup5()
	{
		this.j.jouerCoup(23, 2);
		assertEquals("Thomas = [ Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=1, ordonne=0 ;  ]"
				+ "  [ Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, "
				+ "Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4 ] 0", this.j.toString());
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void testAnnulerCoup()
	{
		this.j.jouerCoup(14, 2);
		this.j.annulerCoup();
		assertEquals("Thomas = [ Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=1, ordonne=0 ; Carte abscisse=0, ordonne=2 ;  ]"
				+ "  [ Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, "
				+ "Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4, "
				+ "Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=2 ] 0", this.j.toString());
		
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test 
	public void piocher()
	{
		ArrayList<Carte> lc = new ArrayList<>();
		lc.add(new Carte(1, 1));
		lc.add(new Carte(2, 2));
		DeckCarte tasPioche = new DeckCarte(lc);
		
		this.j.piocher(tasPioche);
		
		assertEquals("Thomas = [ Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=0, ordonne=2 ; Carte abscisse=1, ordonne=0 ; Carte abscisse=2, ordonne=2 ;  ]"
				+ "  [ Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, "
				+ "Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=1, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=2, "
				+ "Bloc Couleur=Vert, taille=2, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=3, "
				+ "Bloc Couleur=Vert, taille=3, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4, Bloc Couleur=Vert, taille=4 ] 0", this.j.toString());
		
		assertEquals(" [ Carte abscisse=1, ordonne=1 ;  ] ", tasPioche.toString());
		
	}
	
	
	
	
}
