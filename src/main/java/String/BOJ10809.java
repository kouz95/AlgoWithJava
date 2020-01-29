package String;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ10809 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputLine = scanner.nextLine();
		List<String> alphabets = new ArrayList<>();
		for (int i = (int)'a'; i <= (int)'z'; i++) {
			alphabets.add((Character.toString((char)i)));
		}

		List<Integer> eachNumbers = getEachNumbers(alphabets, inputLine);
		System.out.println(eachNumbers.stream()
			.map(i -> Integer.toString(i))
			.collect(joining(" ")));
	}

	private static List<Integer> getEachNumbers(List<String> alphabets, String inputLine) {
		List<Integer> eachNumbers = new ArrayList<>();
		for (String alphabet : alphabets) {
			if (inputLine.contains(alphabet)) {
				eachNumbers.add(inputLine.indexOf(alphabet));
				continue;
			}
			eachNumbers.add(-1);
		}
		return eachNumbers;
	}
}
