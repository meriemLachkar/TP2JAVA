package com.example.tableaux;

public class ElementsManquants {
	/**
	 * Affiche tous les entiers entre 1 et n qui ne sont pas présents dans le
	 * tableau t.
	 *
	 * @param t tableau d'entiers de taille n, valeurs dans [1..n]
	 */
	public static void afficherElementsManquants(int[] t) {
		int n = t.length;
		boolean[] present = new boolean[n + 1];

		for (int valeur : t) {
			if (valeur >= 1 && valeur <= n) {
				present[valeur] = true;
			}
		}

		boolean aucunManquant = true;
		System.out.print("Éléments manquants: ");

		for (int i = 1; i <= n; i++) {
			if (!present[i]) {
				System.out.print(i + " ");
				aucunManquant = false;
			}
		}

		if (aucunManquant) {
			System.out.println("aucun");
		} else {
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] t1 = { 1, 3, 3, 5 };
		afficherElementsManquants(t1);

		int[] t2 = { 1, 2, 3, 4 };
		afficherElementsManquants(t2);
	}

}
