import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMap 
{
	private Map m1;
	private Map m2;
	
	// ----------------------------------------------------------------------------------------------------------------
	

    @BeforeEach 
    public void setUp() 
    {
    	this.m1 = new Map(4, 3, 2); 
    	this.m2 = new Map(6, 3, 3);
    	
    	this.m2.getListeQuartiers()[2].getListesCases()[0][1].ajouterBloc(new Bloc("Bleu", 1));
    	this.m2.getListeQuartiers()[3].getListesCases()[1][0].ajouterBloc(new Bloc("Violet", 1));
    	this.m2.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("Jaune", 1)); //ce bloc n'est pas le dernier
    	this.m2.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("Bleu", 1)); //ce bloc n'est pas le dernier
    	
    	this.m2.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("Orange", 3)); //ce bloc n'est pas le dernier
    	this.m2.getListeQuartiers()[1].getListesCases()[1][2].ajouterBloc(new Bloc("Orange", 2));
    	this.m2.getListeQuartiers()[5].getListesCases()[1][2].ajouterBloc(new Bloc("Jaune", 4));
    	this.m2.getListeQuartiers()[5].getListesCases()[2][1].ajouterBloc(new Bloc("Jaune", 4));
    	
    	this.m2.getListeQuartiers()[0].getListesCases()[2][2].ajouterBloc(new Bloc("Orange", 2));
    	this.m2.getListeQuartiers()[3].getListesCases()[1][2].ajouterBloc(new Bloc("Orange", 3));
    	this.m2.getListeQuartiers()[2].getListesCases()[2][1].ajouterBloc(new Bloc("Bleu", 1));
    	this.m2.getListeQuartiers()[0].getListesCases()[0][0].ajouterBloc(new Bloc("Orange", 2));
    
    	this.m2.getListeQuartiers()[5].getListesCases()[0][1].ajouterBloc(new Bloc("Orange", 2));
    	this.m2.getListeQuartiers()[4].getListesCases()[1][0].ajouterBloc(new Bloc("Jaune", 4));
    	this.m2.getListeQuartiers()[1].getListesCases()[1][1].ajouterBloc(new Bloc("Violet", 4));
    }
    
    // ----------------------------------------------------------------------------------------------------------------

    @AfterEach 
    public void tearDown()
    {
        this.m1 = null; 
        this.m2 = null;
    }
    
    // ----------------------------------------------------------------------------------------------------------------
    
    @Test
    public void testGetNbQuartiers()
    {
    	assertEquals(4, this.m1.getNbQuartiers());
    	assertEquals(6, this.m2.getNbQuartiers());
    }
    
    @Test 
    public void testGetListeQuartiers()
    {
    	String listeBlocsM1PremiereCase = this.m1.getListeQuartiers()[0].getListesCases()[0][0].getListeBlocs().toString();
    	String listeBlocsM2PremiereCase = this.m2.getListeQuartiers()[0].getListesCases()[0][0].getListeBlocs().toString();
    	
    	
    	assertEquals("[]", listeBlocsM1PremiereCase);
    	assertEquals("[Bloc Couleur=Bleu, taille=1, Bloc Couleur=Orange, taille=2]", listeBlocsM2PremiereCase);
    }
    
    @Test 
    public void testRecupererListeDerniersBlocsMap()
    {
    	String listeDerniersBlocsM1 = this.m1.recupererListeDerniersBlocsMap().toString();
    	String listeDerniersBlocsM2 = this.m2.recupererListeDerniersBlocsMap().toString();
    	
    	assertEquals("[]", listeDerniersBlocsM1);
    	assertEquals("[Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Violet, taille=4, Bloc Couleur=Orange, taille=2, "
    			+ "Bloc Couleur=Bleu, taille=1, Bloc Couleur=Bleu, taille=1, Bloc Couleur=Violet, taille=1, Bloc Couleur=Orange, taille=3, "
    			+ "Bloc Couleur=Jaune, taille=4, Bloc Couleur=Orange, taille=2, Bloc Couleur=Jaune, taille=4, "
    			+ "Bloc Couleur=Jaune, taille=4]", listeDerniersBlocsM2);
    }
    
    @Test
    public void testRecupererCouleursDerniersBlocsMap()
    {
    	String[][] listeCouleursDerniersBlocsM1 = this.m1.recupererCouleurDerniersBlocsMap();
    	String[][] listeCouleursDerniersBlocsM2 = this.m2.recupererCouleurDerniersBlocsMap();
    	assertEquals(null , listeCouleursDerniersBlocsM1[0][0]);
    	assertEquals("Orange", listeCouleursDerniersBlocsM2[0][0]);
    	
    	for (String[] couleurQuartier : listeCouleursDerniersBlocsM2)
    	{
    		for (String couleurCase : couleurQuartier)
    		{
    			System.out.print(couleurCase + " ");
    		}
    	}
    }
    
    @Test 
    public void testRecupererBlocPlusHautMap()
    {
    	Bloc blocPlusHautM1 = this.m1.recupererBlocPlusHautMap();
    	Bloc blocPlusHautM2 = this.m2.recupererBlocPlusHautMap();
    	assertEquals(null , blocPlusHautM1);
    	assertEquals("Bloc Couleur=Violet, taille=4", blocPlusHautM2.toString());
    }
    
}
