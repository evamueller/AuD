import java.util.*;

public class BaumTraversieren
{
	private AVLBaum einBaum;

	public BaumTraversieren(AVLBaum einBaum)
	{
		this.einBaum = einBaum;
	}

	// Pre-Order
	public String traversierePreOrder()
	{
		// Wurzel, Links, Rechts
	    	if (einBaum.getWurzel() == null)
			return "Der Baum ist leer.";

		String traverse = new String();
		
		Deque<AVLKnoten> q = new LinkedList<>();
		AVLKnoten element = einBaum.getWurzel();
				
		q.push(element);
		
		while (!q.isEmpty())
		{
		    element = q.pop();
		    
		    if (element.getKnotenRechts() != null) 
			q.push(element.getKnotenRechts());
		    if (element.getKnotenLinks() != null)
			q.push(element.getKnotenLinks());
		    		    
		    traverse += element.getDaten().toString() + " ";
		}

		return traverse;
	}
}