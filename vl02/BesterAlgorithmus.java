public class BesterAlgorithmus
{
	// 1000n
	public static double g1(int n)
	{
	    return 1000 * n;
	}

	
	// 100n * log2(n+1)
	public static double g2(int n)
	{
	    return 100.0 * n * (Math.log10(n + 1) / Math.log10(2));
	}

	// 10 * n * n
	public static double g3(int n)
	{
	    return 10.0 * n * n;
	}

	// n * n * n
	public static double g4(int n)
	{
	    return (double)n * n * n;
	}

	// 2 hoch n
	public static double g5(int n)
	{
	    return Math.pow(n, n);
	}

	// n!
	public static double g6(int n)
	{
	    double fak = 1;
	    for (int i = 1; i <= n; i++)
		fak *= i;
	    return fak;
	}

	// Bestimmt fuer alle 6 Funktionen den Wert von
	// gi(n) und gibt den Index der Funktion mit
	// dem minimalen Wert zurueck
	public static int gewinnerFuerN(int n)
	{
	    double[] werte = new double[6];
	    
	    werte[0] = g1(n);
	    werte[1] = g2(n);
	    werte[2] = g3(n);
	    werte[3] = g4(n);
	    werte[4] = g5(n);
	    werte[5] = g6(n);
		    
	    double min = werte[0];
	    int index = 0;
	    
	    for (int i = 1; i < 6; i++) 
		if (min > werte[i]) {
		    min = werte[i];
		    index = i;
		}
	    
	    return index + 1;
	}

	// Gibt für jede Zahl n zwischen 1 und 2000 aus, welcher der
	// 6 Algorithmen (A1 .. A6) für das betrachtete n der Beste ist
	public static void main(String[] args)
	{
	    for (int i = 1; i <= 2000; i++) {
		System.out.println(i + ": Algorithmus " + gewinnerFuerN(i));
	    }
	}
}