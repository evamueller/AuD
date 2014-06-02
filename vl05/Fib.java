public class Fib {

    public static void fibIterativ(int n) {
	int vorvor = 0;
	int vor = 1;
	
	System.out.println("Iterativ " + n);
	System.out.println(vorvor);
	System.out.println(vor);
	
	for (int i = 0; i < n; i++) {
	    int neu = vorvor + vor;
	    System.out.println(neu);
	    vorvor = vor;
	    vor = neu;
	}
    }
    
    
    public static int fibRekursiv(int n) {
	if (n == 0)
	    return 0;
	else if (n == 1)
	    return 1;
	else
	    return fibRekursiv (n - 1) + fibRekursiv(n - 2);
}
    
    public static void main(String[] args) {
	int fibZahl = 25;
	StopUhr uhr = new StopUhr();
	uhr.start();
		fibIterativ(fibZahl);
	uhr.stop();
	System.out.println("Iterativ Zeit: " + uhr.getDuration());
	
	System.out.println();
	uhr.start();
        	System.out.println("Rekursiv");
        	for (int i = 0; i < fibZahl; i++)
        	    System.out.println(fibRekursiv(i));
	uhr.stop();
	System.out.println("Rekursiv Zeit: " + uhr.getDuration());
    }

}
