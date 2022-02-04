package Model;


public class Map
{
	private int nbQuartiers;
	private Quartier[] listeQuartiers;
	
	// ---------------------------------------------------------------------------
	
	public Map()
	{
		this.nbQuartiers = 6;
		this.listeQuartiers = new Quartier[this.nbQuartiers];
	
		for (int i = 0 ; i < this.listeQuartiers.length ; i=i+1)
		{
			this.listeQuartiers[i] = new Quartier();
		}
	}
	
	// ---------------------------------------------------------------------------
	
	public int getNbQuartiers() 
	{
		return this.listeQuartiers.length;
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

}
