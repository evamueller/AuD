public class Zeitmessung
{
	private static double tuwas()
	{
		return Math.random();
	}

	// Linear
	public static double func1(int n)
	{
		double summe = 0;

		for (int a = 0; a < n; a++)
			summe += tuwas();

		return summe;
	}

	// Quadratisch
	public static double func2(int n)
	{
		double summe = 0;

		for (int a = 0; a < n; a++)
			for(int b = 0; b < n; b++)
				summe += tuwas();

		return summe;
	}

	// log 2(n)
	public static double func6(int n)
	{
		double summe = 0;

		while (n > 0)
		{
			summe += tuwas();
			n /= 2;
		}

		return summe;
	}
	
	public static void main(String[] args) {
	    //n (z.B. 1000, 10000, 100000 und 1000000).
	    
	    for (int n = 1000; n <= 1000000; n *= 10) {
		StopUhr s = new StopUhr();
		
		s.start();
		func1(n);
		s.stop();
		System.out.println("func 1(" + n + "): " + s.getDuration());
		
		s.start();
		func2(n);
		s.stop();
		System.out.println("func 2(" + n + "): " + s.getDuration());
		
		s.start();
		func6(n);
		s.stop();
		System.out.println("func 6(" + n + "): " + s.getDuration());
	    }
	}
}
