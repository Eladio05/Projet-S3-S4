package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Bloc;
import Model.Partie;

public class TestPartie 
{
	private Partie p;
	
	@BeforeEach 
    public void setUp() 
    {
       this.p = new Partie(); 
    }
    
    // ---------------------------------------------------------------------------
    
    @AfterEach 
    public void tearDown()
    {
        this.p = null; 
    }
    
    // ---------------------------------------------------------------------------
    
    @Test
    public void testInitialiserPioche()
    {
    	this.p.initialiserPioche();
    	assertEquals(" [ Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=1, ordonne=0 ; Carte abscisse=1, ordonne=0 ; Carte abscisse=1, ordonne=0 ; Carte abscisse=1, ordonne=0 ; Carte abscisse=1, ordonne=0 ; Carte abscisse=1, ordonne=1 ; Carte abscisse=1, ordonne=1 ; Carte abscisse=1, ordonne=1 ; Carte abscisse=1, ordonne=1 ; Carte abscisse=1, ordonne=1 ;  ] ", this.p.getPioche().toString());
    }
    
    @Test 
    public void testInitialiserJoueurs()
    {
    	this.p.initialiserPioche();
    	this.p.initialiserJoueurs(); 
    	
    	assertEquals("j1 = [ Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=1 ;  ]  [ Bloc Couleur=Jaune, taille=1, Bloc Couleur=Jaune, taille=1, Bloc Couleur=Jaune, taille=1, Bloc Couleur=Jaune, taille=1, Bloc Couleur=Jaune, taille=1, Bloc Couleur=Jaune, taille=1, Bloc Couleur=Jaune, taille=1, Bloc Couleur=Jaune, taille=1, Bloc Couleur=Jaune, taille=1, Bloc Couleur=Jaune, taille=1, Bloc Couleur=Jaune, taille=1, Bloc Couleur=Jaune, taille=2, Bloc Couleur=Jaune, taille=2, Bloc Couleur=Jaune, taille=2, Bloc Couleur=Jaune, taille=2, Bloc Couleur=Jaune, taille=2, Bloc Couleur=Jaune, taille=2, Bloc Couleur=Jaune, taille=3, Bloc Couleur=Jaune, taille=3, Bloc Couleur=Jaune, taille=3, Bloc Couleur=Jaune, taille=3, Bloc Couleur=Jaune, taille=4, Bloc Couleur=Jaune, taille=4, Bloc Couleur=Jaune, taille=4 ] 0", this.p.getListeJoueurs().get(0).toString());
    	assertEquals("j2 = [ Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=1, ordonne=0 ;  ]  [ Bloc Couleur=Violet, taille=1, Bloc Couleur=Violet, taille=1, Bloc Couleur=Violet, taille=1, Bloc Couleur=Violet, taille=1, Bloc Couleur=Violet, taille=1, Bloc Couleur=Violet, taille=1, Bloc Couleur=Violet, taille=1, Bloc Couleur=Violet, taille=1, Bloc Couleur=Violet, taille=1, Bloc Couleur=Violet, taille=1, Bloc Couleur=Violet, taille=1, Bloc Couleur=Violet, taille=2, Bloc Couleur=Violet, taille=2, Bloc Couleur=Violet, taille=2, Bloc Couleur=Violet, taille=2, Bloc Couleur=Violet, taille=2, Bloc Couleur=Violet, taille=2, Bloc Couleur=Violet, taille=3, Bloc Couleur=Violet, taille=3, Bloc Couleur=Violet, taille=3, Bloc Couleur=Violet, taille=3, Bloc Couleur=Violet, taille=4, Bloc Couleur=Violet, taille=4, Bloc Couleur=Violet, taille=4 ] 0", this.p.getListeJoueurs().get(1).toString());
    	assertEquals("j3 = [ Carte abscisse=0, ordonne=0 ; Carte abscisse=0, ordonne=1 ; Carte abscisse=1, ordonne=0 ; Carte abscisse=1, ordonne=0 ;  ]  [ Bloc Couleur=Bleu, taille=1, Bloc Couleur=Bleu, taille=1, Bloc Couleur=Bleu, taille=1, Bloc Couleur=Bleu, taille=1, Bloc Couleur=Bleu, taille=1, Bloc Couleur=Bleu, taille=1, Bloc Couleur=Bleu, taille=1, Bloc Couleur=Bleu, taille=1, Bloc Couleur=Bleu, taille=1, Bloc Couleur=Bleu, taille=1, Bloc Couleur=Bleu, taille=1, Bloc Couleur=Bleu, taille=2, Bloc Couleur=Bleu, taille=2, Bloc Couleur=Bleu, taille=2, Bloc Couleur=Bleu, taille=2, Bloc Couleur=Bleu, taille=2, Bloc Couleur=Bleu, taille=2, Bloc Couleur=Bleu, taille=3, Bloc Couleur=Bleu, taille=3, Bloc Couleur=Bleu, taille=3, Bloc Couleur=Bleu, taille=3, Bloc Couleur=Bleu, taille=4, Bloc Couleur=Bleu, taille=4, Bloc Couleur=Bleu, taille=4 ] 0", this.p.getListeJoueurs().get(2).toString());
    	assertEquals("j4 = [ Carte abscisse=0, ordonne=1 ; Carte abscisse=1, ordonne=0 ; Carte abscisse=1, ordonne=1 ; Carte abscisse=1, ordonne=1 ;  ]  [ Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=1, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=2, Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=3, Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4, Bloc Couleur=Orange, taille=4 ] 0", this.p.getListeJoueurs().get(3).toString());
    	assertEquals(" [ Carte abscisse=1, ordonne=0 ; Carte abscisse=1, ordonne=1 ; Carte abscisse=1, ordonne=1 ; Carte abscisse=1, ordonne=1 ;  ] ", this.p.getPioche().toString());	
    }
    
    
    
    
}
