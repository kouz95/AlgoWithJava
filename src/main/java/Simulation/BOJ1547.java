package Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1547 {
	public static void main(String[] args) {
		final int CUP_COUNT = 3;
		final Scanner scanner = new Scanner(System.in);

		List<Cup> cups = new ArrayList<>();

		for (int i = 0; i < CUP_COUNT; i++) {
			Cup cup = new Cup(false);
			cups.add(cup);
		}

		cups.get(0).setIsBall(true);

		final int switchingCount = scanner.nextInt();

		int firstCupIndex;
		int secondCupIndex;
		for (int i = 0; i < switchingCount; i++) {
			firstCupIndex = scanner.nextInt() - 1;
			secondCupIndex = scanner.nextInt() - 1;
			Collections.swap(cups, firstCupIndex, secondCupIndex);
		}
		for (int i = 0; i < cups.size(); i++) {
			if (cups.get(i).isBall) {
				System.out.println(i + 1);
			}
		}
	}
}

class Cup {
	boolean isBall;

	public Cup(boolean isBall) {
		this.isBall = isBall;
	}

	public void setIsBall(boolean isBall) {
		this.isBall = isBall;
	}
}

