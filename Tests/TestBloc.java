package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Bloc;

public class TestBloc
{
	private Bloc b;
	
	// ---------------------------------------------------------------------------
	
    @BeforeEach 
    public void setUp() 
    {
       this.b = new Bloc("Orange", 2); 
    }
    
    // ---------------------------------------------------------------------------
    
    @AfterEach 
    public void tearDown()
    {
        this.b = null; 
    }
    
    // ---------------------------------------------------------------------------
    
    @Test
    public void testGetCouleur()
    {
    	assertEquals("Orange", this.b.getCouleur());
    }
    
    // ---------------------------------------------------------------------------
    
    @Test
    public void testGetTaille()
    {
    	assertEquals(2, this.b.getTaille());
    }
   
    // ---------------------------------------------------------------------------
    
    @Test
    public void testSetCouleur()
    {
    	this.b.setCouleur("Bleu");
    	assertEquals("Bleu", this.b.getCouleur());
    }
 
    // ---------------------------------------------------------------------------
    
    @Test
    public void testSetTaille()
    {
    	this.b.setTaille(3);
    	assertEquals(3, this.b.getTaille());
    }
    
    // ---------------------------------------------------------------------------
    
    @Test
    public void testToString()
    {
    	assertEquals("Bloc Couleur=Orange, taille=2", this.b.toString());
    }
}
