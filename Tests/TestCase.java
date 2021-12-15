package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Case;

public class TestCase
{
	/*
    Changelog : V1
    - Creation de la classe
    */
	private Case c;
	
	// ----------------------------------
	
    @BeforeEach 
    public void setUp() 
    {
       this.c = new Case(0, 0); 
    }
    
    // ----------------------------------

    @AfterEach 
    public void tearDown()
    {
        this.c = null; 
    }
    
    // ----------------------------------
    
    @Test
    public void testGetAbcisse()
    {
    	assertEquals(0, c.getAbcisse());
    }
    
    // ---------------------------------- 
    
    @Test
    public void testGetOrdonnee()
    {
    	assertEquals(0, this.c.getOrdonnee());
    }
    
    // ----------------------------------
    
    @Test
    public void testSetAbcisse()
    {
    	c.setAbcisse(2);
    	assertEquals(2, this.c.getAbcisse());
    }
    
    @Test
    public void testSetOrdonnee()
    {
    	c.setOrdonnee(2);
    	assertEquals(2, this.c.getOrdonnee());
    }
    
    // ----------------------------------
    
    @Test
    public void testToString()
    {
    	
    	assertEquals("[0 0]", this.c.toString());
    }
 
    
}
