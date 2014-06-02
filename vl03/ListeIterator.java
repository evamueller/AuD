import java.util.*;

public class ListeIterator implements Iterator
{
	private Link aktuellerLink;
	private Link ende;

	ListeIterator(Link start, Link ende)
	{
		aktuellerLink = start;
		this.ende = ende;
	}

	public boolean hasNext()
	{
		return aktuellerLink != null;
	}

	public Object next()
	{
		Object daten = aktuellerLink.getDaten();
		aktuellerLink = aktuellerLink.naechster;

		return daten;
	}

	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}