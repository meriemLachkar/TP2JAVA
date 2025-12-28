package com.example.tableaux;

public class ElementMajoritaire {

	/**
	 * Retourne l'élément majoritaire du tableau t s'il existe, c'est-à-dire un
	 * entier qui apparaît plus de n/2 fois. Retourne -1 s'il n'existe pas d'élément
	 * majoritaire.
	 *
	 * @param t tableau d'entiers (peut contenir des doublons)
	 * @return entier majoritaire ou -1
	 */

	public static int elementMajoritaire(int[] t) {
		if (t == null || t.length == 0) {
			return -1;
		}

		int candidat = 0;
		int compteur = 0;

		for (int valeur : t) {
			if (compteur == 0) {
				candidat = valeur;
				compteur = 1;
			} else if (valeur == candidat) {
				compteur++;
			} else {
				compteur--;
			}
		}

		int occurrences = 0;
		for (int valeur : t) {
			if (valeur == candidat) {
				occurrences++;
			}
		}

		return (occurrences > t.length / 2) ? candidat : -1;
	}

	public static int elementMajoritaireMap(int[] t) {
		if (t == null || t.length == 0) {
			return -1;
		}

		java.util.Map<Integer, Integer> compteurs = new java.util.HashMap<>();

		for (int valeur : t) {
			compteurs.put(valeur, compteurs.getOrDefault(valeur, 0) + 1);
		}

		int n = t.length;
		for (java.util.Map.Entry<Integer, Integer> entry : compteurs.entrySet()) {
			if (entry.getValue() > n / 2) {
				return entry.getKey();
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[][] tests = { { 3, 3, 4, 3, 5 }, { 1, 2, 3, 4 }, { 2, 2, 2, 2, 2 }, { -1, -1, -1, 2, 3 }, { 7 }, {} };

		for (int[] t : tests) {
			System.out.print("Tableau: ");
			for (int v : t)
				System.out.print(v + " ");
			System.out.println("Avec Résultat: " + elementMajoritaire(t));
		}
	}
}
