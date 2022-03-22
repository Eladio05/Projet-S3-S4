import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDeckBlocs
{

	private DeckBlocs db;
	// ---------------------------------------------------------------------------
	
    @BeforeEach 
    public void setUp() 
    {
       this.db = new DeckBlocs("Orange");
    }
    
    // ---------------------------------------------------------------------------
    
    @AfterEach 
    public void tearDown()
    {
        this.db = null; 
    }
    
    // ---------------------------------------------------------------------------
    
    @Test
    public void testGetCouleur()
    {
    	System.out.println(this.db);
    	assertEquals("Orange", this.db.getCouleur());
    }
    
    @Test 
    public void testRecupererBloc()
    {
    	assertEquals("Bloc Couleur=Orange, taille=1", this.db.recupererBloc(0).toString());
    	assertEquals("Bloc Couleur=Orange, taille=1", this.db.recupererBloc(10).toString());
    	assertEquals("Bloc Couleur=Orange, taille=2", this.db.recupererBloc(11).toString());
    	assertEquals("Bloc Couleur=Orange, taille=2", this.db.recupererBloc(16).toString());
    	assertEquals("Bloc Couleur=Orange, taille=3", this.db.recupererBloc(17).toString());
    	assertEquals("Bloc Couleur=Orange, taille=3", this.db.recupererBloc(20).toString());
    	assertEquals("Bloc Couleur=Orange, taille=4", this.db.recupererBloc(21).toString());
    	assertEquals("Bloc Couleur=Orange, taille=4", this.db.recupererBloc(23).toString());
    }
    
    @Test 
    public void testRetirerBloc()
    {
    	assertEquals("Bloc Couleur=Orange, taille=1", this.db.retirerBloc(0).toString());
    	assertEquals("Bloc Couleur=Orange, taille=2", this.db.retirerBloc(14).toString());
    	assertEquals("Bloc Couleur=Orange, taille=4", this.db.retirerBloc(21).toString());
    	System.out.println(this.db);
    }
    
    @Test
    public void testAjouterBloc()
    {
    	System.out.println(this.db.recupererBloc(23));
    	Bloc b = new Bloc("Orange", 1);
    	this.db.ajouterBloc(b);
    	assertEquals("Bloc Couleur=Orange, taille=1", this.db.retirerBloc(24).toString());	
    }
}
