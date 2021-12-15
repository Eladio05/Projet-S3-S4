package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Case;
import Model.Quartier;

public class TestQuartier 
{
    /*
    Changelog : V2
    - Correction de la methode testToString
    */
	private Case c;
	private Quartier q;
	
	// ----------------------------------------------------------------------------------------------------------------
	

    @BeforeEach 
    public void setUp() 
    {
    	this.c = new Case(1, 2);
    	this.q = new Quartier(); 
    }
    
    // ----------------------------------------------------------------------------------------------------------------

    @AfterEach 
    public void tearDown()
    {
    	this.c = null;
        this.q = null; 
    }
    
    // ----------------------------------------------------------------------------------------------------------------	
    
    @Test
    public void testGetCase()
    {
    	assertEquals(this.c.toString(), this.q.getCase(1, 2).toString());
    }
    
    // ----------------------------------------------------------------------------------------------------------------
    
	@Test
    public void testSetCase()
    {
    	Case c2 = new Case(4, 4);
    	this.q.setCase(c2, 1, 2);
    	assertEquals("[4 4]", this.q.getCase(1, 2).toString());
    }
	
	// ----------------------------------------------------------------------------------------------------------------
    
    @Test
    public void testToString()
    {
    	
    	assertEquals("[\n[0 0], [0 1], [0 2], \n[1 0], [1 1], [1 2], \n[2 0], [2 1], [2 2]\n]\n", this.q.toString());
    }
}
