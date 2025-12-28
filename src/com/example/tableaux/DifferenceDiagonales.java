package com.example.tableaux;

public class DifferenceDiagonales {
	/**
	 * Calcule et affiche : - la somme de la diagonale principale, - la somme de la
	 * diagonale secondaire, - la valeur absolue de leur différence.
	 *
	 * @param m matrice carrée n x n
	 * @return valeur absolue de la différence entre les deux sommes
	 */

	public static int differenceDiagonales(int[][] m) {
		int n = m.length;
		int sommePrincipale = 0;
		int sommeSecondaire = 0;

		for (int i = 0; i < n; i++) {
			sommePrincipale += m[i][i];
			sommeSecondaire += m[i][n - 1 - i];
		}

		int difference = Math.abs(sommePrincipale - sommeSecondaire);

		System.out.println("Diagonale principale: " + sommePrincipale);
		System.out.println("Diagonale secondaire: " + sommeSecondaire);
		System.out.println("Différence absolue: " + difference);

		return difference;
	}

	public static void main(String[] args) {

		int[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("Test 1:");
		differenceDiagonales(m1);
		System.out.println();

		int[][] m2 = { { 1, 3, 5 }, { 2, 4, 6 }, { 7, 8, 9 } };
		System.out.println("Test 2:");
		differenceDiagonales(m2);
		System.out.println();

		int[][] m3 = { { 5 } };
		System.out.println("Test 3:");
		differenceDiagonales(m3);
		System.out.println();

		int[][] m4 = { { -1, 2 }, { 3, -4 } };
		System.out.println("Test 4:");
		differenceDiagonales(m4);
	}
}
