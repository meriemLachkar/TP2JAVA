package com.example.tableaux;

public class PermutationCirculaire {

	public static boolean estPermutationCirculaire(int[] t) {
		int n = t.length;

		if (n == 0) {
			return false;
		}

		boolean[] vu = new boolean[n + 1];

		for (int valeur : t) {
			if (valeur < 1 || valeur > n) {
				return false;
			}
			if (vu[valeur]) {
				return false;
			}
			vu[valeur] = true;
		}

		int posUn = -1;
		for (int i = 0; i < n; i++) {
			if (t[i] == 1) {
				posUn = i;
				break;
			}
		}

		if (posUn == -1) {
			return false;
		}

		for (int k = 0; k < n; k++) {
			int index = (posUn + k) % n;
			int valeurAttendue = k + 1;

			if (t[index] != valeurAttendue) {
				return false;
			}
		}

		return true;
	}

	public static boolean estPermutationCirculaireAlternative(int[] t) {
		int n = t.length;
		if (n == 0)
			return false;

		int start = -1;
		for (int i = 0; i < n; i++) {
			if (t[i] == 1) {
				start = i;
				break;
			}
		}
		if (start == -1)
			return false;

		for (int i = 1; i < n; i++) {
			int currentIndex = (start + i) % n;
			int previousIndex = (start + i - 1) % n;

			if (t[currentIndex] != t[previousIndex] + 1) {
				if (t[previousIndex] == n && t[currentIndex] == 1) {
					continue;
				}
				return false;
			}
		}

		return true;
	}

	public static boolean estPermutationCirculaireSimple(int[] t) {
		int n = t.length;
		if (n == 0)
			return false;

		int start = -1;
		for (int i = 0; i < n; i++) {
			if (t[i] == 1) {
				start = i;
				break;
			}
		}
		if (start == -1)
			return false;

		boolean[] seen = new boolean[n + 1];

		int expected = 1;
		for (int i = 0; i < n; i++) {
			int index = (start + i) % n;
			int value = t[index];

			if (value < 1 || value > n) {
				return false;
			}

			if (value != expected) {
				return false;
			}

			if (seen[value]) {
				return false;
			}
			seen[value] = true;

			expected = (expected % n) + 1;
		}

		return true;
	}

	public static void main(String[] args) {

		System.out.println("Test : ");

		int[] t1 = { 1, 2, 3, 4, 5 };
		System.out.println("t1 = [1,2,3,4,5]: " + estPermutationCirculaire(t1)); 

		int[] t2 = { 2, 3, 4, 5, 1 };
		System.out.println("t2 = [2,3,4,5,1]: " + estPermutationCirculaire(t2)); 

		int[] t3 = { 5, 1, 2, 3, 4 };
		System.out.println("t3 = [5,1,2,3,4]: " + estPermutationCirculaire(t3)); 

		int[] t4 = { 3, 1, 2, 4, 5 };
		System.out.println("t4 = [3,1,2,4,5]: " + estPermutationCirculaire(t4)); 

		int[] t5 = { 1, 2, 2, 3, 4 };
		System.out.println("t5 = [1,2,2,3,4]: " + estPermutationCirculaire(t5)); 

		int[] t6 = { 0, 1, 2, 3, 4 };
		System.out.println("t6 = [0,1,2,3,4]: " + estPermutationCirculaire(t6));

		int[] t7 = { 1 };
		System.out.println("t7 = [1]: " + estPermutationCirculaire(t7));

		int[] t8 = {};
		System.out.println("t8 = []: " + estPermutationCirculaire(t8)); 

	}
}
