package com.example.tableaux;

public class CarreMagique {
	/**
	 * Vérifie si la matrice 3x3 m est un carré magique.
	 *
	 * @param m matrice 3x3 d'entiers
	 * @return true si m est magique, false sinon
	 */
	public static boolean estCarreMagique(int[][] m) {
		int ref = m[0][0] + m[0][1] + m[0][2];

		for (int i = 1; i < 3; i++) {
			if (m[i][0] + m[i][1] + m[i][2] != ref) {
				return false;
			}
		}

		for (int j = 0; j < 3; j++) {
			if (m[0][j] + m[1][j] + m[2][j] != ref) {
				return false;
			}
		}

		if (m[0][0] + m[1][1] + m[2][2] != ref) {
			return false;
		}
		if (m[0][2] + m[1][1] + m[2][0] != ref) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] m1 = { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } };
		int[][] m2 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		int[][] m3 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Test 1: " + (estCarreMagique(m1) ? "Carré magique" : "Pas magique"));
		System.out.println("Test 2: " + (estCarreMagique(m2) ? "Carré magique" : "Pas magique"));
		System.out.println("Test 3: " + (estCarreMagique(m3) ? "Carré magique" : "Pas magique"));
	}
}
