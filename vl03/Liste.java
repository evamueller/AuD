import java.util.*;

public class Liste
{
	protected Link anfang;
	protected Link ende;

	// Vorg�nger von AktuellerZeiger
	protected Link vorgaengerAktuellerZeiger;

	public Liste()
	{
		// Leere Liste anlegen, anfangs- und ende-Zeiger null
		anfang = null;
		ende = null;

		// Vorg�nger-Zeiger ist auch null
		vorgaengerAktuellerZeiger = null;
	}

	public Object naechstesElement() throws NoSuchElementException
	{
		if (aktuellerZeiger() == ende)
		{
			throw new NoSuchElementException("Am Ende der Liste");
		}
		else
			if (vorgaengerAktuellerZeiger == null)
			{
				vorgaengerAktuellerZeiger = anfang;
			}
			else
			{
				vorgaengerAktuellerZeiger = vorgaengerAktuellerZeiger.naechster;
			}

		return vorgaengerAktuellerZeiger.getDaten();
	}

	// Zur�cksetzen des aktuellen Zeigers auf den Listenanfang
	public void setzeAktuellerZeigerZurueck()
	{
		vorgaengerAktuellerZeiger = null;
	}

	// Einf�gen vor die aktuelle Zeigerposition
	public void einfuegenElement(Object neuesElement)
	{
		//Wenn die Liste leer ist, entspricht dies einem anf�gen
		if (istLeer())
		{
			anfuegenElement(neuesElement);
			return;
		}

		Link neu = new Link(neuesElement, aktuellerZeiger());

		// Wenn die Liste nur ein Element hat, muss anfang gesetzt werden
		if (vorgaengerAktuellerZeiger == null)
		{
			anfang = neu;
			vorgaengerAktuellerZeiger = neu;
			return;
		}

		// Vorg�nger-Element von Neu zeigt jetzt auf Neu
		vorgaengerAktuellerZeiger.naechster = neu;
		vorgaengerAktuellerZeiger = neu;
	}

	// Anf�gen am Ende der Liste
	public void anfuegenElement(Object neuesElement)
	{
		// Neuen Link anlegen
		Link neu = new Link(neuesElement, null);

		// Wenn die Liste leer ist, muss anfang und ende gesetzt werden
		if (istLeer())
		{
			// Neuen Link als anfang der Liste
			anfang = neu;
		}
		else
		{
			// Anf�gen des Elements an das bisherige Ende
			ende.naechster = neu;	// Ende-Element zeigt jetzt auf neu
		}

		// Neues Ende
		ende = neu;
	}

	public Object entfernenElement() throws NoSuchElementException
	{
		// Liste leer?
		if (istLeer())
			return null;

		Link zuLoeschendesElement = aktuellerZeiger();

		// Zeiger am Anfang der Liste
		if (vorgaengerAktuellerZeiger == null)
		{
			anfang = anfang.naechster;
		}
		else
		{
			vorgaengerAktuellerZeiger.naechster = zuLoeschendesElement.naechster;

			// Zeiger am Ende der Liste
			if (zuLoeschendesElement == ende)
			{
				ende = vorgaengerAktuellerZeiger;
				vorgaengerAktuellerZeiger = null;
			}
		}

		return zuLoeschendesElement.getDaten();
	}

	// Liefert true, wenn Element in der Liste vorkommt, sonst false.
	// Wenn true zur�ckgegeben wurde, kann mit naechstesElement() auf Element
	// zugegriffen werden, wenn nicht steht aktuellerZeiger am Ende der Liste.
	public boolean suchenElement(Object element)
	{
		Link zeiger = anfang;
		Link backupZeiger = null;

		// Zeiger auf Listenanfang setzen
		vorgaengerAktuellerZeiger = null;

		// Liste leer?
		if (zeiger == null)
			return false;

		// Abfrage auf Gleichheit ist m�glich mit equals (Operation von der Klasse Object)
		while ((zeiger != null) && !zeiger.getDaten().equals(element))
		{
			backupZeiger = vorgaengerAktuellerZeiger;
			vorgaengerAktuellerZeiger = zeiger;

			zeiger = zeiger.naechster;
		}

		// Abfrage auf Ungleichheit
		if (zeiger == null)
		{
			// Zeiger eins zur�cksetzen
			vorgaengerAktuellerZeiger = backupZeiger;

			return false;
		}

		return true;
	}

	public Iterator iterator()
	{
		return new ListeIterator(anfang, ende);
	}

	// Aktuellen Zeiger aus dem gespeicherten vorgaengerAkuellerZeiger ableiten
	public Link aktuellerZeiger()
	{
		return istLeer() ? null: (vorgaengerAktuellerZeiger == null) ? anfang : vorgaengerAktuellerZeiger.naechster;
		// Sonderfallbehandlung; effiziente Kurzform f�r:
		// if (istLeer()) { return null; }
		//  else if (vorgaengerAktuellerZeiger == null) { return anfang; }
		//    else { return vorgaengerAktuellerZeiger.naechster; }
	}

	// true, wenn AktuellerZeiger nicht am Ende der Liste ist
	public boolean weitereElemente()
	{
		return istLeer() ? false : aktuellerZeiger() != ende;
		// Effiziente Kurzform f�r:
		// if (istLeer()) { return false; } else { return aktuellerZeiger() != ende; }
	}

	public Link getAnfang()
	{
		return anfang;
	}

	public Link getEnde()
	{
		return ende;
	}

	// Pr�fen, ob Liste leer ist
	public boolean istLeer()
	{
		// Diese Methode wird im Praktikum implementiert
    	    	return anfang == null;
	}

	public void verketten(Liste zweiteListe)
	{
		// Diese Methode wird im Praktikum implementiert
		this.ende.naechster = zweiteListe.anfang;
		this.ende = zweiteListe.ende;
		zweiteListe.anfang = null;
		zweiteListe.ende = null;
		
		
	}

	public int loescheWerte(int n)
	{
		int anzGeloeschte = 0;

		// Diese Methode wird im Praktikum implementiert
		while (suchenElement(n)) {
		    
		    //  aktuellerZeiger = zu l�schendes Element
		    
		    if (vorgaengerAktuellerZeiger != null) 
			vorgaengerAktuellerZeiger.naechster = aktuellerZeiger().naechster;
		    // das zu l�schende Element ist am Anfang, es gibt keinen Vorg�nger
		    else
			this.anfang = aktuellerZeiger().naechster;
		    
		    anzGeloeschte++;
		}
		
		/*  a
		 *  1 --> 2 --> 3 -->
		 *  v==null
		 */
		return anzGeloeschte;
	}
}


