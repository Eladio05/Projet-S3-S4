import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDeckCartes 
{
	private DeckCarte dc;
	// ---------------------------------------------------------------------------
	
    @BeforeEach 
    public void setUp() 
    {
    	ArrayList<Carte> lc = new ArrayList<>(Arrays.asList (new Carte(0, 0), new Carte(0, 1), new Carte(1, 0), new Carte(1, 1) ) );
        this.dc = new DeckCarte(lc);
    }
    
    // ---------------------------------------------------------------------------
    
    @AfterEach 
    public void tearDown()
    {
        this.dc = null; 
    }
    
    // ---------------------------------------------------------------------------
    
    
    @Test
    public void testGetListeCartes()
    {
    	assertEquals(" [ Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=1, ordonne=0 ; Carte abscisse=1, ordonne=1 ;  ] ", this.dc.toString());
    }
    
}
