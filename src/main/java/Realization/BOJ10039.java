package Realization;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ10039 {
	public static void main(String[] args) {
		Solution10039 solution10039 = new Solution10039();
		solution10039.printSolution();
	}
}

class Solution10039 {
	private static final Scanner scanner = new Scanner(System.in);

	private final List<Student> students;

	public Solution10039() {
		this.students = inputStudents();
	}

	private List<Student> inputStudents() {
		return IntStream.range(0, 5)
			.map(scanner::nextInt)
			.mapToObj(i -> new Student(new Score(i)))
			.collect(Collectors.toList());
	}

	public void printSolution() {
		System.out.println(getAverageScore());
	}

	private int getAverageScore() {
		return (int) students.stream()
			.mapToInt(student -> student.getScore().toInt())
			.average()
			.getAsDouble();
	}
}

class Student {
	private final Score score;

	public Student(Score score) {
		this.score = score;
	}

	public Score getScore() {
		return score;
	}
}

class Score {
	private final int score;

	public Score(int score) {
		this.score = Math.max(score, 40);
	}

	public int toInt() {
		return score;
	}
}