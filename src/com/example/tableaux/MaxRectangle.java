package com.example.tableaux;

import java.util.Stack;

public class MaxRectangle {

	/**
	 * Retourne l'aire du plus grand rectangle de 1 dans la matrice m.
	 */
	static class Rectangle {
		int top;
		int left;
		int bottom;
		int right;
		int area;

		@Override
		public String toString() {
			return "Rectangle [top=" + top + ", left=" + left + ", bottom=" + bottom + ", right=" + right + ", area="
					+ area + "]";
		}
	}

	private static int[][] calculerHauteurs(int[][] m) {
		int R = m.length;
		if (R == 0)
			return new int[0][0];

		int C = m[0].length;

		int[][] h = new int[R][C];

		for (int j = 0; j < C; j++) {
			h[0][j] = m[0][j];
		}

		for (int i = 1; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (m[i][j] == 1) {
					h[i][j] = h[i - 1][j] + 1;
				} else {
					h[i][j] = 0;
				}
			}
		}
		return h;
	}

	private static int[] maxRectangleHistogram(int[] hist) {
		int n = hist.length;

		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		int left = 0, right = -1, height = 0;

		for (int i = 0; i <= n; i++) {
			int h = (i == n) ? 0 : hist[i];

			while (!stack.isEmpty() && h < hist[stack.peek()]) {
				int index = stack.pop();
				int currentHeight = hist[index];
				int currentLeft = stack.isEmpty() ? 0 : stack.peek() + 1;
				int currentRight = i - 1;
				int currentArea = currentHeight * (currentRight - currentLeft + 1);

				if (currentArea > maxArea) {
					maxArea = currentArea;
					left = currentLeft;
					right = currentRight;
					height = currentHeight;
				}
			}
			stack.push(i);
		}

		return new int[] { left, right, height, maxArea };

	}

	public static Rectangle trouverMaxRectangle(int[][] m) {
		Rectangle result = new Rectangle();
		result.area = 0;

		if (m == null || m.length == 0 || m[0].length == 0) {
			return result;
		}

		int R = m.length;
		int C = m[0].length;

		int[][] h = calculerHauteurs(m);

		for (int i = 0; i < R; i++) {
			int[] hist = h[i];
			int[] rectInfo = maxRectangleHistogram(hist);

			int left = rectInfo[0];
			int right = rectInfo[1];
			int height = rectInfo[2];
			int area = rectInfo[3];

			if (area > result.area) {
				result.area = area;
				result.left = left;
				result.right = right;
				result.bottom = i;
				result.top = i - height + 1;
			}

		}

		return result;
	}

	public static int maxRectangle(int[][] m) {
		Rectangle r = trouverMaxRectangle(m);
		return r.area;
	}

	public static void afficherMatrice(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("Test 1 : ");
		int[][] m1 = { { 0, 1, 1, 0, 1 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 0, 0, 1 }

		};
		afficherMatrice(m1);
		Rectangle r1 = trouverMaxRectangle(m1);
		System.out.println("Resultat : " + r1);
		System.out.println("Aire : " + maxRectangle(m1));

	}

}
