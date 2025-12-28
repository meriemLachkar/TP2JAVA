package com.example.tableaux;

public class MaxSubarray {
	/**
	 * Retourne la somme maximale d'une sous-suite contiguë dans le tableau t.
	 *
	 * @param t tableau d'entiers (positifs et/ou négatifs)
	 * @return somme maximale d'une sous-suite contiguë
	 */

	public static int maxSubarraySum(int[] t) {
		if (t == null || t.length == 0) {
			return 0;
		}

		int currentSum = t[0];
		int maxSum = t[0];

		for (int i = 1; i < t.length; i++) {
			currentSum = Math.max(t[i], currentSum + t[i]);
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}

	public static class Resultat {
		int debut;
		int fin;
		int somme;

		public Resultat(int d, int f, int s) {
			debut = d;
			fin = f;
			somme = s;
		}

		@Override
		public String toString() {
			return String.format("Début: %d, Fin: %d, Somme: %d", debut, fin, somme);
		}
	}

	public static Resultat maxSubarraySumAvecIndices(int[] t) {
		if (t == null || t.length == 0) {
			return new Resultat(-1, -1, 0);
		}

		int currentSum = t[0];
		int maxSum = t[0];
		int currentStart = 0;
		int bestStart = 0;
		int bestEnd = 0;

		for (int i = 1; i < t.length; i++) {
			if (t[i] > currentSum + t[i]) {
				currentSum = t[i];
				currentStart = i;
			} else {
				currentSum = currentSum + t[i];
			}

			if (currentSum > maxSum) {
				maxSum = currentSum;
				bestStart = currentStart;
				bestEnd = i;
			}
		}

		return new Resultat(bestStart, bestEnd, maxSum);
	}

	public static int maxSubarraySumNaif(int[] t) {
		if (t.length == 0)
			return 0;

		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < t.length; i++) {
			int currentSum = 0;
			for (int j = i; j < t.length; j++) {
				currentSum += t[j];
				maxSum = Math.max(maxSum, currentSum);
			}
		}

		return maxSum;
	}

	public static int maxSubarraySumTresNaif(int[] t) {
		if (t.length == 0)
			return 0;

		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < t.length; i++) {
			for (int j = i; j < t.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += t[k];
				}
				maxSum = Math.max(maxSum, sum);
			}
		}

		return maxSum;
	}

	public static void main(String[] args) {

		System.out.println("Algo de Kadane : ");

		int[] t1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.print("Tableau: ");
		for (int v : t1)
			System.out.print(v + " ");
		System.out.println();

		System.out.println("Somme maximale: " + maxSubarraySum(t1)); // 6

		Resultat r1 = maxSubarraySumAvecIndices(t1);
		System.out.println("Avec indices: " + r1);
		System.out.print("Segment: ");
		for (int i = r1.debut; i <= r1.fin; i++) {
			System.out.print(t1[i] + " ");
		}
		System.out.println();

	}
}
