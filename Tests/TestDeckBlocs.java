package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		assertEquals("[ [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], " 
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=4], [Bloc Couleur=Orange, taille=4], [Bloc Couleur=Orange, taille=4] ]", this.db.toString());
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void retirerBloc1()
	{
		db.retirerBloc(0);
		assertEquals("[ [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], " 
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=4], [Bloc Couleur=Orange, taille=4], [Bloc Couleur=Orange, taille=4] ]", this.db.toString());
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void retirerBloc2()
	{
		db.retirerBloc(1);
		assertEquals("[ [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], " 
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=4], [Bloc Couleur=Orange, taille=4], [Bloc Couleur=Orange, taille=4] ]", this.db.toString());
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void retirerBloc3()
	{
		db.retirerBloc(14);
		assertEquals("[ [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], " 
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=4], [Bloc Couleur=Orange, taille=4], [Bloc Couleur=Orange, taille=4] ]", this.db.toString());
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void retirerBloc4()
	{
		db.retirerBloc(19);
		assertEquals("[ [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], " 
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=4], [Bloc Couleur=Orange, taille=4], [Bloc Couleur=Orange, taille=4] ]", this.db.toString());
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void retirerBloc5()
	{
		db.retirerBloc(23);
		assertEquals("[ [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], " 
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=4], [Bloc Couleur=Orange, taille=4] ]", this.db.toString());
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void retirerBloc6()
	{
		db.retirerBloc(24);
		assertEquals("[ [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], " 
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], "
				+ "[Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=1], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], "
				+ "[Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=2], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], [Bloc Couleur=Orange, taille=3], "
				+ "[Bloc Couleur=Orange, taille=4], [Bloc Couleur=Orange, taille=4] ]", this.db.toString());
	}
}
