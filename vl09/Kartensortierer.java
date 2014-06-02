public class Kartensortierer
{
	public int[] sortieren(int[] stapel, int laenge)
	{
		quicksort(stapel, 0, laenge - 1);
		return stapel;
	}

	// Hilfsfunktion zur Bestimmung des Medians dreier Zahlen
	private int median(int erster, int zweiter, int dritter)
	{
	    	//System.out.println("1: " + erster);
	    	//System.out.println("2: " + zweiter);
	    	//System.out.println("3: " + dritter);
	    	int median = dritter;
	    	
		if ((erster <= zweiter && zweiter <= dritter)
			|| (erster >= zweiter && zweiter >= dritter))
		    median = zweiter;
		else if ((zweiter <= erster && erster <= dritter)
			|| (zweiter >= erster && erster >= dritter))
		    median = erster;
	
		//System.out.println("Med: " + median);
		return median;
	}

	private void quicksort(int[] a, int links, int rechts)
	{
	        System.out.println("Quicksort von " + links + " bis " + rechts);
		int li = links;
		int re = rechts;
		
		int vergl = median(a[(li + re) / 2], a[li], a[re]);
		System.out.println("Median: " + vergl);
		
		do {
		    while (a[li] < vergl) {
			li += 1;
		    }
		    while (a[re] > vergl) {
			re -= 1;
		    }
		    
		    if (li <= re) {
			int tmp = a[li];
			a[li] = a[re];
			a[re] = tmp;
			li += 1;
			re -= 1;
		    }
		} while (li < re);
		
		if (links < re) {
		    quicksort(a, links, re);
		}
		if (rechts > li) {
		    quicksort(a, li, rechts);
		}
	}
}
