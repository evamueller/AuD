public class Matrix
{
	private int[][] data;

	public Matrix(int[][] data)
	{
		this.data = data;
	}

	// Vorbedingung: anzZeilen > 0 und anzSpalten > 0
	public Matrix(int anzZeilen, int anzSpalten)
	{
		assert(anzZeilen > 0);
		assert(anzSpalten > 0);

		data = new int[anzZeilen][anzSpalten];
	}

	// Diese Methode wird für die Aufgabenstellung nicht benötigt,
	// sondern dient der Verdeutlichung und Demonstration
	public void set(int[][] data)
	{
		int anzZeilen = data.length > this.data.length ?
			this.data.length : data.length;
		// Effiziente Form für:
		// int anzZeilen;
		// if (data.length > this.data.length)
		// {
		//   anzZeilen = data.length;
		// }
		// else
		// {
		//   anzZeilen = this.data.length;
		// }

		int anzSpalten = data[0].length > this.data[0].length ?
			this.data[0].length : data[0].length;
		// Effiziente Form für:
		// int anzSpalten;
		// if (data[0].length > this.data[0].length)
		// {
		//   anzSpalten = data[0].length;
		// }
		// else
		// {
		//   anzSpalten = this.data[0].length;
		// }

		for (int a = 0; a < anzZeilen; a++)
			for (int b = 0; b < anzSpalten; b++)
				this.data[a][b] = data[a][b];
	}

/** A.transpose():
 *
 *  A entspricht Matrix, die transponiert werden soll. (Die
 *  zugehörigen Zahlen werden im Attribut 'data' gespeichert)
 *
 *  anzSpalten <- dim(A,1)  // Anzahl Spalten in transp. Matrix
 *  anzZeilen <- dim(A,2)   // Anzahl Zeilen in transp. Matrix
 *
 *  B = create Matrix(anzZeilen, anzSpalten)
 *
 *  for a <- 1 to anzSpalten do
 *    for b <- 1 to anzZeilen do
 *      B[b,a] <- A[a,b]
 *    end for
 *  end for
 *
 *  return B
 */

	public Matrix transpose()
	{
	    int anzSpalten = this.data.length;
	    int anzZeilen = this.data[0].length;
	    
	    Matrix neu = new Matrix (anzZeilen, anzSpalten);
	    for (int a = 0; a < anzSpalten; a++)
		for (int b = 0; b < anzZeilen; b++)
		    neu.data[b][a] = this.data[a][b];
	    
	    return neu;
 	}

	public void print(String text)
	{
		int anzZeilen = data.length;
		int anzSpalten = data[0].length;

		System.out.println(text);

		for (int a = 0; a < anzZeilen; a++)
		{
			for (int b = 0; b < anzSpalten; b++)
				System.out.print((data[a][b] >= 0 ? "\t " : "\t") + data[a][b]);

			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		int[][] data = { { 1, 8, -3 }, { 4, -2, 5 } };

		// Matrix:
		// 1  8 -3
		// 4 -2  5
		Matrix A = new Matrix(data);
		A.print("Matrix A");

		Matrix B = A.transpose();
		B.print("Matrix B");
	}
}
