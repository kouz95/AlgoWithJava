package String;

import java.util.Scanner;

public class BOJ1330 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int firstNumber = scanner.nextInt();
		int secondNumber = scanner.nextInt();

		if (firstNumber > secondNumber) {
			System.out.println(">");
		}
		else if (firstNumber < secondNumber) {
			System.out.println("<");
		}
		else {
			System.out.println("==");
		}
	}
}
