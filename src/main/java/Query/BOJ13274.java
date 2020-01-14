package Query;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ13274 {
	private static final Scanner scanner = new Scanner(System.in);
	private static final int ARRAY_SIZE = scanner.nextInt();
	private static final int QUERY_COUNTS = scanner.nextInt();

	public static void main(String[] args) {
		long[] numbers = new long[ARRAY_SIZE];

		for (int i = 0; i < ARRAY_SIZE; i++) {
			numbers[i] = scanner.nextLong();
		}

		for (int i = 0; i < QUERY_COUNTS; i++) {
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			int x = scanner.nextInt();
			LRX(numbers, l, r, x);
		}
		for (int i = 0; i < ARRAY_SIZE; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

	private static void LRX(long[] numbers, int l, int r, int x) {
		Arrays.sort(numbers);
		for (int i = 0; i < ARRAY_SIZE; i++) {
			if (i + 1 >= l && i + 1 <= r) {
				numbers[i] += x;
			}
		}
		Arrays.sort(numbers);
	}
}
