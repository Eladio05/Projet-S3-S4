package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Case;
import Model.Map;
import Model.Quartier;

public class TestMap
{
	private Map m;
	private Quartier q;
	private Case c;
	
	// ----------------------------------------------------------------------------------------------------------------
	

    @BeforeEach 
    public void setUp() 
    {
    	this.m = new Map();
    	this.q = new Quartier(); 
    }
    
    // ----------------------------------------------------------------------------------------------------------------

    @AfterEach 
    public void tearDown()
    {
    	this.m = null;
        this.q = null; 
    }
    
    // ----------------------------------------------------------------------------------------------------------------	
    
    @Test
    public void testGetQuartier()
    {
    	assertEquals(this.q.toString(), this.m.getQuartier(5).toString());
    }
    
    // ----------------------------------------------------------------------------------------------------------------
    
	@Test
    public void testSetQuartier()
    {
		Case c = new Case(4, 4);
    	this.q.setCase(c, 1, 2);
    	this.m.setQuartier(this.q, 5);
    	assertEquals("[4 4]", this.m.getQuartier(5).getCase(1, 2).toString());
    }
	
	// ----------------------------------------------------------------------------------------------------------------
   
    @Test
    public void testToString()
    {
    	String text1 = "Quartier : 1\n[\n[0 0], [0 1], [0 2], \n[1 0], [1 1], [1 2], \n[2 0], [2 1], [2 2]\n]\n\n";
    	String text2 = "Quartier : 2\n[\n[0 0], [0 1], [0 2], \n[1 0], [1 1], [1 2], \n[2 0], [2 1], [2 2]\n]\n\n";
    	String text3 = "Quartier : 3\n[\n[0 0], [0 1], [0 2], \n[1 0], [1 1], [1 2], \n[2 0], [2 1], [2 2]\n]\n\n";
    	String text4 = "Quartier : 4\n[\n[0 0], [0 1], [0 2], \n[1 0], [1 1], [1 2], \n[2 0], [2 1], [2 2]\n]\n\n";
    	String text5 = "Quartier : 5\n[\n[0 0], [0 1], [0 2], \n[1 0], [1 1], [1 2], \n[2 0], [2 1], [2 2]\n]\n\n";
    	String text6 = "Quartier : 6\n[\n[0 0], [0 1], [0 2], \n[1 0], [1 1], [1 2], \n[2 0], [2 1], [2 2]\n]\n\n";
    	assertEquals(text1 + text2 + text3 + text4 + text5 + text6, this.m.toString());
    }
    
}

