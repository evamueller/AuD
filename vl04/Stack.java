public class Stack<E> implements StackI<E>
{
	// Feld, in dem die Elemente des Stacks gespeichert werden
	// Oberes Ende des Stacks liegt an Position pos-1
	// Ein Feld mit Elementen vom Typ E kann zwar deklariert, aber
	// kein Platz über new dafür angelegt werden (Java-Mangel)
	private Object[] st;

	// Nächste freie Position im Feld
	// Gleichzeitig Anzahl der im Feld/Stack gespeicherten Elemente
	private int pos;

	// Erzeugt ein Stack-Objekt, in dem maximal size Elemente
	// abgespeichert werden können
	public Stack(int size)
	{
		st = new Object[size];
		
	}

	// Legt übergebenes Element auf den Stack, sofern noch Platz ist
	// Das Element wird an Position pos im Feld gespeichert
	public void push(E element)
	{
		if (pos < st.length)
		    st[pos++] = element;
	}

	// Holt oberstes Element vom Stack, sofern der Stack nicht leer ist
	public void pop()
	{
	    	if (pos > 0) 
	    	    st[pos--] = null;
	}

	// Gibt oberstes Element auf dem Stack zurück, sofern der Stack nicht
	// leer ist; bei leerem Stack wird null zurückgegeben
	public E top()
	{
	    if (!isEmpty())
	    	return (E)st[pos - 1];
	    else 
		return null;
	}

	// Gibt true zurück, falls der Stack leer ist, ansonsten false
	public boolean isEmpty()
	{
		return pos == 0;
	}
}