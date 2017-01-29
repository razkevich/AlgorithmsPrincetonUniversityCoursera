public class ThreeSumProblem {
	public static void main(String[] args) {
		System.out.println(calculate(30, -40, -20, -10, 40, 0, 10, 5));
	}

	private static int calculate(int... integers) {
		int count = 0;
		for (int i = 0; i < integers.length; i++) {
			for (int j = i + 1; j < integers.length; j++) {
				for (int k = j + 1; k < integers.length; k++) {
					if (integers[i] + integers[j] + integers[k] == 0) count++;
				}
			}
		}
		return count;
	}
}
