import java.util.HashSet;

public class Ejercicio {

	public class PairSumProblem {
		// Solución genérica con complejidad O(n^2)
		public static int countPairsBruteForce(int[] arr, int target) {
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] + arr[j] == target) {
						count++;
					}
				}
			}
			return count;

		}

		// Solución optimizada con complejidad O(n)
		public static int countPairsOptimized(int[] arr, int target) {
			HashSet<Integer> seen = new HashSet<>();
			int count = 0;
			for (int num : arr) {
				int complement = target - num;
				if (seen.contains(complement)) {
					count++;
				}
				seen.add(num);
			}
			return count;
		}

		public static void main(String[] args) {
			int[] arr = { 1, 5, 7, -1, 5 };
			int target = 6;

			// Medición de tiempo para solución genérica
			long startBruteForce = System.nanoTime();
			int bruteForceResult = countPairsBruteForce(arr, target);
			long endBruteForce = System.nanoTime();
			System.out.println("Resultado (fuerza bruta): " + bruteForceResult);
			System.out.println("Tiempo (fuerza bruta): " + (endBruteForce - startBruteForce) + " ns");

			// Medición de tiempo para solución optimizada
			long startOptimized = System.nanoTime();
			int optimizedResult = countPairsOptimized(arr, target);
			long endOptimized = System.nanoTime();
			System.out.println("Resultado (optimizada): " + optimizedResult);
			System.out.println("Tiempo (optimizada): " + (endOptimized - startOptimized) + " ns");
		}
	}

}
