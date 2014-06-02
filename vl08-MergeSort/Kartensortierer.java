public class Kartensortierer
{
	/**
	 *
	 * @param StapelA  Feld der Schlüssel
	 * @param laenge   Länge des Stapels
	 * @return         Das sortierte Feld
	 */
	public int[] sortieren(int[] StapelA, int laenge)
	{
		int laengeFeld = laenge;

		// Erzeuge einen Hilfsstapel der gleichen Länge
		int [] StapelB = new int[laengeFeld];

		// Länge der zu sortierenden Teilstapel (zu Beginn 1, d.h. sortierter Stapel besteht aus einer Karte
		int laengeTeilfolge = 1;

		// Ggf. kürzere Länge des ersten oder zweiten Stapels
		int laengeTeilfolge1 = 1;
		int laengeTeilfolge2 = 1;

		//Schleifendurchlaufzähler
		int aktDurchlaufAussen = 1;
		int aktDurchlaufInnen = 1;

		// 1. Kartenposition des 1. zu sortierenden Teilstapels
		// Anfangsposition
		int anfang = 0;

		// Richtung des Mischens (von A nach B oder umgekehrt)
		boolean vonAnachB = true;

		// Aufteilung eines Stapels der Länge n in n Stapel der Länge 1
		// Beim Initialisieren der Variablen bereits erfolgt!
		while (laengeTeilfolge1 <= laengeFeld)
		{
			System.out.println(aktDurchlaufAussen + ". Durchlauf der äußeren Schleife");

			// Bei jedem vollständigen Mischen des Stapels verdoppelt sich
			// die Länge der sortierten Teilfolgen
			laengeTeilfolge *= 2;

			// Mischdurchlauf aller Teilstapel des Stapels
			anfang = 0;

			while (anfang < laengeFeld)
			{
				System.out.println("   " + aktDurchlaufInnen + ".  Durchlauf der inneren Schleife: ");

				// Berechnung der beiden Längen
				// Sonderfälle, wenn Stapellänge keine Zweierpotenz ist
				if ((anfang + laengeTeilfolge) > laengeFeld)
				{
					if ((laengeFeld - anfang) > (laengeTeilfolge / 2))
					{
						// Es bleibt zweiter Stapel
						laengeTeilfolge1 = laengeTeilfolge / 2;
						laengeTeilfolge2 = laengeFeld - anfang - laengeTeilfolge1;
					}
					else
					{
						// Es gibt keinen 2. Stapel
						laengeTeilfolge1 = laengeFeld - anfang;
						laengeTeilfolge2 = 0;
					}
				}

				// Mischen der sortierten Teilfolgen
				if (vonAnachB)
				{
					// Von Stapel A nach Stapel B
					mischenStapel(StapelA, StapelB, anfang, laengeTeilfolge1, laengeTeilfolge2);
					ausgeben(StapelB, laengeFeld);
				}
				else
				{
					// Von Stapel B nach Stapel A
					mischenStapel(StapelB, StapelA, anfang, laengeTeilfolge1, laengeTeilfolge2);
					ausgeben(StapelA, laengeFeld);
				}

				// Der Anfang der nächsten Teilfolge liegt um die
				// aktuelle Teilfolgenlänge hoeher
				anfang += laengeTeilfolge;
				aktDurchlaufInnen++;
			}

			// Nach einem vollständigen Mischdurchlauf durch den Stapel
			// ist entweder StapelA nach StapelB oder StapelB nach StapelA
			// gemischt worden, so daß im nächsten Durchlauf Quelle und Ziel
			// vertauscht werden müssen. Die Länge der Teilfolgen verdoppelt sich.
			vonAnachB = !vonAnachB;
			laengeTeilfolge1 = laengeTeilfolge2 = laengeTeilfolge;
			aktDurchlaufAussen++;
		}

		return vonAnachB ? StapelA : StapelB;
		// Effizinte Kurzform für:
		// if (vonAnachB) { return StapelA; } else { return StapelB; }
	}

	/**
	 * Hilfsalgorithmus mischenStapel
	 * Mischen der sortierten Teilstapel aus StapelLinksRechts nach StapelMitte
	 * der ersteTeilstapel beginnt in StapelLinksRechts bei anfang und besitzt die Länge laengeLinks
	 * der zweite Teilstapel beginnt in StapelLinksRechts ab (anfang+laengeLinks)
	 * und besitzt die Länge laengeRechts
	 *
	 * Vorbedingung:
	 * - Es gibt zwei sortierte Kartenstapel
	 * - Ein Stapel kommt auf die linke Seite, der andere auf die rechte Seite
	 * - der mittlere Stapel ist leer
	 *
	 * Nachbedingung:
	 * - Alle Karten befinden sich im sortierten mittleren Stapel
	 *
	 * @param StapelLinksRechts wahlweise rechter oder linker Stapel mit den sortierten Teilfolgen
	 * @param StapelMitte       Mittlerer Stapel
	 * @param anfang            Anfangsposition
	 * @param laengeLinks       Länge des linken Stapels
	 * @param laengeRechts      Länge des rechten Stapels
	 */
	private void mischenStapel(int[] StapelLinksRechts, int[] StapelMitte, int anfang, int laengeLinks, int laengeRechts)
	{
		int obenlinks = anfang;
		int obenmitte = anfang;
		int obenrechts = anfang + laengeLinks;

		/*
		 * Die Karten der beiden urspruenglichen Stapel sind auf 3 sortierte
		 * Kartenstapel verteilt:
		 * - Der linke Stapel enthält nur Karten aus dem 1. (ursprünglichen) Stapel.
		 * - Der mittlere Stapel enthält Karten aus beiden ursprünglichen Stapeln.
		 * - Der rechte Stapel enthält nur Karten aus dem 2. (ursprünglichen) Stapel.
		 *
		 * Alle Karten des mittleren Stapels sind kleiner als alle Karten des linken
		 * und alle Karten des rechten Stapels.
		 */

		// Linker Stapel nicht leer und rechter Stapel nicht leer
		while ((obenlinks < (anfang + laengeLinks)) && (obenrechts < (anfang + laengeLinks + laengeRechts)))
			// Lege die kleinste der beiden obersten Karten des linken
			// und rechten Stapels auf den mittleren Stapel
			StapelMitte[obenmitte++] = (StapelLinksRechts[obenlinks] < StapelLinksRechts[obenrechts]) ? StapelLinksRechts[obenlinks++] : StapelLinksRechts[obenrechts++];
			// Effiziente Kurzform für:
			// if (StapelLinksRechts[obenlinks] < StapelLinksRechts[obenrechts])
			// { StapelMitte[obenmitte++] = StapelLinksRechts[obenlinks++]; }
			// else
			// { StapelMitte[obenmitte++] = StapelLinksRechts[obenrechts++]; }

		// Lege den ganzen verbleibenden linken oder rechten Reststapel auf den mittleren Stapel
		if(obenlinks < (anfang + laengeLinks))
		{
			for (int a = obenlinks; a < (anfang + laengeLinks); a++)
				StapelMitte[obenmitte++] = StapelLinksRechts[a];
		}
		else
		{
			for (int a = obenrechts; a < (anfang + laengeLinks + laengeRechts); a++)
				StapelMitte[obenmitte++] = StapelLinksRechts[a];
		}
	}

	/**
	 *
	 * @param Stapel  Der auszugebende Stapel
	 * @param laenge  Die Länge des Stapels
	 */
	private void ausgeben(int[] Stapel, int laenge)
	{
		System.out.print("        ");
		for (int a = 0; a < laenge; a++)
			System.out.print(Stapel[a] + " ");

		System.out.println();
	}
}