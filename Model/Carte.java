package Model;

public class Carte {
	private int abscisse;
	private int ordonne;
	
	// -------------------------------------------------------------------------------------------------
	
	public Carte(int abscisse, int ordonne) {
		super();
		this.abscisse = abscisse;
		this.ordonne = ordonne;
	}
	
	// -------------------------------------------------------------------------------------------------
	

	@Override
	public String toString() {
		return "Carte abscisse=" + abscisse + ", ordonne=" + ordonne;
	}

	// -------------------------------------------------------------------------------------------------

	public int getAbscisse() {
		return abscisse;
	}
	
	// -------------------------------------------------------------------------------------------------

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}
	
	// -------------------------------------------------------------------------------------------------

	public int getOrdonne() {
		return ordonne;
	}

	// -------------------------------------------------------------------------------------------------
	
	public void setOrdonne(int ordonne) {
		this.ordonne = ordonne;
	}
	
	
	
	
}
