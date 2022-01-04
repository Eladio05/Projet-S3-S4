package Model;

public class Main 
{
	public static void main(String[] args)
	{
		
		Bloc b1 = new Bloc("Bleu", 3);
		Bloc b2 = new Bloc("Orange", 2);
		Case c = new Case(1, 1);
		
		c.setListeBlocs(b1);
		c.setListeBlocs(b2);
		c.setListeBlocs(b2);
		
		System.out.println(c.getListeBlocs());
		
		
		
		/*
		Quartier q = new Quartier();
		System.out.println(q);
		
		Case c = new Case(2, 2);
		System.out.println(c.equals(q.getCase(2, 2)));
		*/
	}
}
