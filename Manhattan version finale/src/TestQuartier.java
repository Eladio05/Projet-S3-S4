

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestQuartier 
{
	private Quartier q;
	
	// ----------------------------------------------------------------------------------------------------------------
	

    @BeforeEach 
    public void setUp() 
    {
    	this.q = new Quartier(2, 3); 
    }
    
    // ----------------------------------------------------------------------------------------------------------------

    @AfterEach 
    public void tearDown()
    {
        this.q = null; 
    }
    
    // ----------------------------------------------------------------------------------------------------------------
    
    @Test
    public void testGetNbLignes()
    {
    	assertEquals(2, this.q.getNbLignes());
    }
    
    @Test
    public void testGetNbColonnes()
    {
    	assertEquals(3, this.q.getNbColonnes());
    }
    
    @Test
    public void testGetListeCases()
    {
    	Bloc b = new Bloc("Orange", 4);
    	this.q.getListesCases()[0][2].ajouterBloc(b);
    	assertEquals("[Bloc Couleur=Orange, taille=4]", this.q.getListesCases()[0][2].getListeBlocs().toString());
    }
}
