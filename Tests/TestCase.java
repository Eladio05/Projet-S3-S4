package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Bloc;
import Model.Case;

public class TestCase
{
	private Case c;
	
	// ---------------------------------------------------------------------------------------------
	
    @BeforeEach 
    public void setUp() 
    {
       this.c = new Case(0, 0); 
    }
    
    // ---------------------------------------------------------------------------------------------

    @AfterEach 
    public void tearDown()
    {
        this.c = null; 
    }
    
    // ---------------------------------------------------------------------------------------------
    
    @Test
    public void testGetAbscisse()
    {
    	assertEquals(0, this.c.getAbscisse());
    }
    
    // ---------------------------------------------------------------------------------------------
    
    @Test
    public void testGetOrdonnee()
    {
    	assertEquals(0, this.c.getOrdonnee());
    }
    
    // ---------------------------------------------------------------------------------------------
    
    @Test
    public void testSetAbscisse()
    {
    	this.c.setAbscisse(2);
    	assertEquals(2, this.c.getAbscisse());
    }
    
    // ---------------------------------------------------------------------------------------------
    
    @Test
    public void testSetOrdonnee()
    {
    	this.c.setOrdonnee(2);
    	assertEquals(2, this.c.getOrdonnee());
    }
    
    // ---------------------------------------------------------------------------------------------
    
    @Test
    public void testgetListeBlocs()
    {
    	Bloc b1 = new Bloc("Orange", 1);
    	Bloc b2 = new Bloc("Bleu", 2);
    	Bloc b3 = new Bloc("Violet", 3);
    	
    	this.c.setListeBlocs(b1);
    	this.c.setListeBlocs(b2);
    	this.c.setListeBlocs(b3);
    	
    	assertEquals("Bloc Couleur=Violet, taille=3", this.c.getListeBlocs().toString());
    }
    
    // ---------------------------------------------------------------------------------------------
    
    @Test
    public void testSetListeBlocs()
    {
    	Bloc b1 = new Bloc("Orange", 1);
    	this.c.setListeBlocs(b1);
    	assertEquals("Bloc Couleur=Orange, taille=1", this.c.getListeBlocs().toString());
    }
    
 // ---------------------------------------------------------------------------------------------
    
    @Test
    public void testToString()
    {
    	
    	assertEquals("[0 0]", this.c.toString());
    }
 
    
}
