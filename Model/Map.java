package Model;


public class Map
{
	
	private Quartier[] listeQuartiers;
	
	// ---------------------------------------------------------------------------
	
	public Map()
	{
		this.listeQuartiers = new Quartier[6];
	
		for (int i = 0 ; i < this.listeQuartiers.length ; i=i+1)
		{
			this.listeQuartiers[i] = new Quartier();
		}
	}
	
	// ---------------------------------------------------------------------------
	
	public void setQuartier(Quartier q, int numero)
	{
		this.listeQuartiers[numero] = q;
	}
	
	// ---------------------------------------------------------------------------
	
	public Quartier getQuartier(int numero)
	{
		return this.listeQuartiers[numero];
	}
	
	// ---------------------------------------------------------------------------
	
	public String toString()
	{
		String s = "";
		int compteur = 1;
		
		for (Quartier q : this.listeQuartiers)
		{
			s = s + "Quartier : " + compteur + "\n" + q.toString() + "\n";
			compteur = compteur + 1;
		}
		
		s = s + "";
		return s;
	}

	public Quartier[] getListeQuartiers() {
		return listeQuartiers;
	}
}
