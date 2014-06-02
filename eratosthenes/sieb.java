package eratosthenes;

public class sieb {
    public static void main(String[] args) {
	sieben(1000);
    }

    public static void sieben(int MAX) {
	boolean[] sieb = new boolean[MAX];

	for (int n = 1; n < sieb.length; n++) 
	    sieb[n] = true;

	for (int n = 2; n < Math.sqrt(MAX); n++) 
	    if (sieb[n] == true) 
		for (int m = n * n; m < sieb.length; m += n) 
			sieb[m] = false;
	
	// ggf. Ausgabe
	System.out.println("Sieb des Eratosthenes bis " + MAX);
	for (int n = 0; n < sieb.length; n++) 
	    if (sieb[n])
		System.out.print(n + " ");
    }
}
