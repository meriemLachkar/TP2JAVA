package com.example.tableaux;

public class Spirale {

	/**
	 * Construit et retourne une matrice n x n remplie en spirale (sens horaire)
	 * avec les nombres de 1 à n^2.
	 *
	 * @param n taille de la matrice (n >= 1)
	 * @return matrice n x n remplie en spirale
	 */
	public static int[][] construireSpirale(int n) {
		int[][] matrice = new int[n][n];

		if (n <= 0)
			return matrice;

		int top = 0;
		int bottom = n - 1;
		int left = 0;
		int right = n - 1;

		int valeur = 1;
		while (top <= bottom && left <= right) {
			for (int j = left; j <= right; j++) {
				matrice[top][j] = valeur;
				valeur++;
			}
			top++;

			for (int i = top; i <= bottom; i++) {
				matrice[i][right] = valeur;
				valeur++;
			}
			right--;

			if (top > bottom || left > right) {
				break;
			}
			for (int j = right; j >= left; j--) {
				matrice[bottom][j] = valeur;
				valeur++;
			}
			bottom--;

			for (int i = bottom; i >= top; i--) {
				matrice[i][left] = valeur;
				valeur++;
			}
			left++;
		}

		return matrice;
	}

	/**
	 * Affiche une matrice n x n de manière lisible.
	 */
	public static void afficherMatrice(int[][] m) {
		if (m == null || m.length == 0) {
			System.out.println("matrice vide");
			return;
		}
		int max = m.length * m.length;
		int largeur = String.valueOf(max).length() + 1;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("%" + largeur + "d", m[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// int n = 3; // à modifier pour tester

		int[] tests = { 1, 2, 3, 4, 5 };

		for (int n : tests) {
			System.out.println("\nn = " + n + " ");
			int[][] matrice = construireSpirale(n);
			afficherMatrice(matrice);
		}

	}
}
