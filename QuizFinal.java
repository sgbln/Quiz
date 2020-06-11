/*
 * Autor: Stefan Gerecke
 * Datum: 23.11.2019  
 */
import java.util.Scanner;
import java.util.Random;

public class QuizFinal {

	static Scanner scanner = new Scanner(System.in);

	static String questArr[][] = {
			{ "Wie heißt der höchste Berg der Erde?", "Mt. Everest", "Fichtelberg", "K2", "Zugspitze" },
			{ "Wie heißt der kleinste Planet unseres Sonnensystems?", "Merkur", "Pluto", "Mars", "Venus" },
			{ "Wie heißt der längste Fluß der Erde?", "Nil", "Elbe", "Rhein", "Ganges" },
			{ "Höchstes Bauwerk der Erde?", "Burj Khalifa", "Taipei 101", "Petronas Towers", "Sears Tower" },
			{ "Kleinstes Land der Erde ohne Vatikan?", "Monaco", "Andorra", "Tonga", "Liechtenstein" } };

	static boolean nochmal = false;
	static int richtig, x, y, z = 0;
	static int zaehler = 0;

	public static void main(String[] args) {

		menu();
	}

	static void menu() {
		boolean anfang = true;
		boolean lebt = true;
		while (lebt) {

			System.out.println("TESTE DEIN WISSEN - ZUM (Q)UIZ ODER ZUM E(X)IT?\n\n");

			while (anfang) {
				System.out.println("Pro richtige Antwort gibt es bis zu 3 Punkte.\n");
				System.out.println("Richtige Antwort im 1. Versuch 3 Punkte");
				System.out.println("Richtige Antwort im 2. Versuch 2 Punkte");
				System.out.println("Richtige Antwort im 3. Versuch 1 Punkt");
				anfang = false;
			}
			zaehler = 0;
			String menu = scanner.next();
			switch (menu.toLowerCase()) {

			case "q": {
				quiz();
				break;
			}

			case "x": {
				scanner.close();
				System.exit(1);
			}
			default: {
				System.out.println("falsche Taste");
				menu();
			}

			}
		}
	}

	public static void quiz() {

		char buchstabe, antwort;

		int fragen[] = r4nd0m(5).clone();

		for (x = 0; x < 5; x++) {

			System.out.println("Frage " + (x + 1) + ": " + questArr[fragen[x]][0] + "\n");

			int antworten[] = r4nd0m(4).clone();

			for (z = 0; z < 4; z++) {

				buchstabe = (char) (z + 65);

				System.out.println("Antwort " + buchstabe + " " + questArr[fragen[x]][(antworten[z] + 1)]);
				if (antworten[z] == 0) {
					richtig = z;

				}

			}

			System.out.println("\n Deine Antwort: ");
			antwort = scanner.next().charAt(0);
			switch (Character.toLowerCase(antwort)) {

			case 'a': {

				antworten(0);

				break;
			}

			case 'b': {
				antworten(1);
				break;
			}

			case 'c': {
				antworten(2);
				break;
			}

			case 'd': {

				antworten(3);
				break;
			}

			default: {
				System.out.println("\n falsche Taste!\n");
			}
			}
		}
		System.out.println("Ergebnis: " + zaehler + " Punkte von 15 möglichen Punkten.\n");
	}

	static void antworten(int korrekt) {

		if (richtig == korrekt) {
			punkte(y);
			nochmal = false;
			y = 0;
		} else
			switch (y) {
			case 0:

				System.out.println("Falsch, 0 Punkte\n");
				System.out.println("\n Noch eine weitere Chance, Versuch Nr. 2\n");
				x--;
				y++;
				nochmal = true;
				break;
			case 1:

				System.out.println("Falsch, 0 Punkte\n");
				System.out.println("\n Deine letzte Chance, Versuch Nr. 3\n");
				x--;
				y++;
				nochmal = true;
				break;
			default:
				if (x < 4) {

					System.out.println("Immer noch falsch!");
					System.out.println("Versuchs mal mit einer anderen Frage!\n");
					y = 0;
					nochmal = false;
				} else {
					System.out.println("Immer noch falsch!\n");
				}

			}

	}

	public static int[] r4nd0m(int groesse) {

		int rrArr[] = new int[groesse];

		for (int i = 0; i < groesse; i++) {
			rrArr[i] = i;
		}

		Random rand = new Random();

		for (int r = 0; r < groesse; r++) {
			int randomIndexToSwap = rand.nextInt(groesse); // Der Var. randomIndexToSwap wird ein Wert zw. 0 u. 5
															// zugewiesen
			int temp = rrArr[randomIndexToSwap]; // Der Var. temp wird der Arraywert von randomIndexToSwap zugewiesen
			rrArr[randomIndexToSwap] = rrArr[r]; // Der Arraypos. randomIndexToSwap wird der Arraywert von r zugewiesen
			rrArr[r] = temp;

		}
		return rrArr;
	}

	static void punkte(int yy) {
		if (yy == 0) {
			System.out.println("Richtig, 3 Punkte\n");
			zaehler += 3;
		}
		if (yy == 1) {

			System.out.println("Richtig, 2 Punkte\n");
			zaehler += 2;
		}
		if (yy == 2) {
			System.out.println("Richtig, 1 Punkt\n");
			zaehler++;
		}

	}

}