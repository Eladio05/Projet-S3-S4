package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Bloc;
import Model.DeckBlocs;

public class TestDeckBlocs 
{
	private DeckBlocs db;
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@BeforeEach 
	public void setUp() 
	{
		this.db = new DeckBlocs("Orange"); 
	}
	    
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	    
	@AfterEach 
	public void tearDown()
	{
	    this.db = null; 
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void testToString()
	{
		assertEquals("[ Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4 ]", this.db.toString());
		
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void testAjouterBloc()
	{
		this.db.ajouterBloc(new Bloc("Vert", 5));
		assertEquals("[ Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4, "
				+ "Bloc Couleur=Vert, taille=5 ]", this.db.toString());
		
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void retirerBloc1()
	{
		Bloc b = this.db.retirerBloc(0);
		assertEquals("[ Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4 ]", this.db.toString());
		
		assertEquals("Bloc Couleur=Orange, taille=1", b.toString());
		
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void retirerBloc2()
	{
		Bloc b = this.db.retirerBloc(1);
		assertEquals("[ Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4 ]", this.db.toString());
		
		assertEquals("Bloc Couleur=Orange, taille=1", b.toString());
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void retirerBloc3()
	{
		Bloc b = this.db.retirerBloc(14);
		assertEquals("[ Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4 ]", this.db.toString());
		
		assertEquals("Bloc Couleur=Orange, taille=2", b.toString());
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void retirerBloc4()
	{
		Bloc b = this.db.retirerBloc(19);
		assertEquals("[ Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4 ]", this.db.toString());
		
		assertEquals("Bloc Couleur=Orange, taille=3", b.toString());
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void retirerBloc5()
	{
		Bloc b = this.db.retirerBloc(23);
		assertEquals("[ Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, "
				+ "Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, "
				+ "Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, "
				+ "Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4 ]", this.db.toString());
		
		assertEquals("Bloc Couleur=Orange, taille=4", b.toString());
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
}
