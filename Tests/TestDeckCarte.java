package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.DeckCarte;
import Model.Carte;

public class TestDeckCarte {

	private DeckCarte dc;
	private Carte C1;
	private Carte C2;
	private ArrayList<Carte> Carte;
	
	
	@BeforeEach 
	public void setUp() {
		Carte = new ArrayList<Carte>();
		C1 = new Carte(0,0);
		C2 = new Carte(1,1);
		Carte.add(C1);
		Carte.add(C2);
		this.dc = new DeckCarte(Carte);
	}
	
	@AfterEach
	public void tearDown() {
		this.dc = null;
	}
	
	@Test
	public void testToString() {
		assertEquals(" [ Carte abscisse=0, ordonne=0 ; Carte abscisse=1, ordonne=1 ;  ] ", this.dc.toString());
		
	}
	

}
