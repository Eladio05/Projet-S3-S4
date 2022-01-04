package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Carte;

public class TestCarte 
{
	private Carte c;
	
	// -----------------------------------------------------------------------
	
    @BeforeEach 
    public void setUp() 
    {
       this.c = new Carte(0, 0); 
    }
    
    // -----------------------------------------------------------------------

    @AfterEach 
    public void tearDown()
    {
        this.c = null; 
    }
    
    // -----------------------------------------------------------------------
    
    @Test
    public void testGetAbcisse()
    {
    	assertEquals(0, this.c.getAbscisse());
    }
    
    // -----------------------------------------------------------------------
    
    @Test
    public void testGetOrdonnee()
    {
    	assertEquals(0, this.c.getOrdonne());
    }
    
    // -----------------------------------------------------------------------
    
    @Test
    public void testSetAbcisse()
    {
    	this.c.setAbscisse(2);
    	assertEquals(2, this.c.getAbscisse());
    }
    
    // -----------------------------------------------------------------------
    
    @Test
    public void testSetOrdonnee()
    {
    	this.c.setOrdonne(2);
    	assertEquals(2, this.c.getOrdonne());
    }
    
    // -----------------------------------------------------------------------
    
    @Test
    public void testToString()
    {
    	assertEquals("Carte abscisse=0, ordonne=0", this.c.toString());
    }
}
