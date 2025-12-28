package com.example.tableaux;

public class Pivots {

	/**
	 * Affiche tous les pivots du tableau t, selon la définition donnée dans
	 * l'énoncé.
	 *
	 * Exemple d'affichage : Pivots : 5 ou bien : Aucun pivot
	 */
	public static void afficherPivots(int[] t) {
		int n = t.length;

		if (n < 3) {
			System.out.println("aucun pivot");
			return;
		}

		int[] prefixMax = new int[n];
		prefixMax[0] = t[0];

		for (int i = 1; i < n; i++) {
			prefixMax[i] = Math.max(prefixMax[i - 1], t[i]);
		}

		int[] suffixMin = new int[n];
		suffixMin[n - 1] = t[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			suffixMin[i] = Math.min(suffixMin[i + 1], t[i]);
		}

		boolean trouve = false;
		System.out.println("Pivots : ");

		for (int i = 1; i < n - 1; i++) {
			if (prefixMax[i - 1] <= t[i] && suffixMin[i + 1] >= t[i]) {
				System.out.print(t[i] + " ");
				trouve = true;
			}
		}
		if (!trouve) {
			System.out.println("aucun pivot");
		} else {
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int[] t = { 2, 4, 3, 5, 6 };
		afficherPivots(t); // doit afficher : Pivots : 5
		
		// les tests
		System.out.println("test 2 : ");
		int[] t2 = { 1, 2, 3, 4, 5};
		afficherPivots(t2);
		
		System.out.println("test 3 : ");
		int[] t3 = {5, 4, 3, 2, 1};
		afficherPivots(t3);
		
		System.out.println("test 4 : ");
		int[] t4 = {3, 3, 3, 3};
		afficherPivots(t4);
		
		System.out.println("test 5 : ");
		int[] t5 = {7, 1, 5, 2, 6, 3, 4};
		afficherPivots(t5);
	}
}
