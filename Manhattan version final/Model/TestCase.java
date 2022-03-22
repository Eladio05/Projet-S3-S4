package Model;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void testgetListeBlocs()
    {
    	this.c.ajouterBloc(new Bloc("Orange", 1));
    	this.c.ajouterBloc(new Bloc("Bleu", 2));
    	this.c.ajouterBloc(new Bloc("Violet", 3));
    	System.out.println(this.c.getListeBlocs());
    	
    	
    	assertEquals("[Bloc Couleur=Orange, taille=1, Bloc Couleur=Bleu, taille=2, Bloc Couleur=Violet, taille=3]", this.c.getListeBlocs().toString());
    }
    
    @Test 
    public void testRecupererDernierBloc1()
    {
    	Bloc b1 = new Bloc("Orange", 1);
    	Bloc b2 = new Bloc("Bleu", 2);
    	Bloc b3 = new Bloc("Violet", 3);
    	this.c.ajouterBloc(b1);
    	this.c.ajouterBloc(b2);
    	this.c.ajouterBloc(b3);
    	assertEquals("Bloc Couleur=Violet, taille=3", this.c.recupererDernierBloc().toString());
    }
    
    @Test 
    public void testRecupererDernierBloc2()
    {
    	Bloc b1 = new Bloc("Orange", 1);
    	this.c.ajouterBloc(b1);
    	assertEquals("Bloc Couleur=Orange, taille=1", this.c.recupererDernierBloc().toString());
    }
    
    @Test 
    public void testRecupererDernierBloc3()
    {
    	assertEquals(null, this.c.recupererDernierBloc());
    }
    
    @Test 
    public void testAjouterBloc1()
    {
    	Bloc b1 = new Bloc("Orange", 1);
    	this.c.ajouterBloc(b1);
    	assertEquals("[Bloc Couleur=Orange, taille=1]", this.c.getListeBlocs().toString());
    }
    
    @Test 
    public void testAjouterBloc2()
    {
    	Bloc b1 = new Bloc("Bleu", 2);
    	Bloc b2 = new Bloc("Orange", 1);
    	this.c.ajouterBloc(b1);
    	this.c.ajouterBloc(b2);
    	assertEquals("[Bloc Couleur=Bleu, taille=2]", this.c.getListeBlocs().toString());
    }
    
    // ---------------------------------------------------------------------------------------------
    
    @Test
    public void testToString()
    {
    	assertEquals("[0 0]", this.c.toString());
    }
 
}
