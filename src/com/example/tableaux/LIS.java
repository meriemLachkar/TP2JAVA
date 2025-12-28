package com.example.tableaux;

public class LIS {

	/**
	 * Retourne la longueur de la plus longue sous-séquence strictement croissante
	 * du tableau t.
	 *
	 * @param t tableau d'entiers, taille <= 1000
	 * @return longueur de la plus longue sous-séquence croissante
	 */
	public static int longueurLIS(int[] t) {
		if (t.length == 0) {
			return 0;
		}

		int n = t.length;
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (t[j] < t[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] > maxLength) {
				maxLength = dp[i];
			}
		}

		return maxLength;

	}

	public static void main(String[] args) {
		int[] t = { 2, 1, 4, 2, 3, 5, 1, 7 };
		System.out.println(longueurLIS(t)); // doit afficher 5
	}
}
