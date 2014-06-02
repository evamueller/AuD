// Abstrakter Datentyp Stack realisiert als Java-Schnittstelle

interface StackI<E>
{
	public void push(E element);
	public void pop();
	public E top();
	public boolean isEmpty();
}
