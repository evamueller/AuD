public class Link
{
	private Object daten;
	protected Link naechster;

	public Link(Object daten, Link naechster)
	{
		this.daten = daten;
		this.naechster = naechster;
	}

	public Object getDaten()
	{
		return daten;
	}

	public void setDaten(Object daten)
	{
		this.daten = daten;
	}
}