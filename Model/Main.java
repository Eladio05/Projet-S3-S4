package Model;

public class Main 
{
	public static void main(String[] args)
	{
		Quartier q = new Quartier();
		System.out.println(q);
		
		Case c = new Case(2, 2);
		System.out.println(c.equals(q.getCase(2, 2)));
	}
}
