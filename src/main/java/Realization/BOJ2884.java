package Realization;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2884 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String userTime = inputTime();
		Time time = new Time(getHours(userTime), getMinutes(userTime));
		System.out.println(time.minus(45));
	}

	public static String inputTime() {
		return scanner.nextLine();
	}

	public static int getHours(final String time) {
		return Integer.parseInt(Arrays.asList(time.split(" ")).get(0));
	}

	public static int getMinutes(String time) {
		return Integer.parseInt(Arrays.asList(time.split(" ")).get(1));
	}


}

class Time {
	private int hours;
	private int minutes;

	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}

	public String minus(int minutes) {
		if (this.minutes >= 45) {
			return hours + " " + (this.minutes - minutes);
		}
		if (hours == 0) {
			return "23 " + (this.minutes - minutes + 60);
		}
		return (hours - 1) + " " + (this.minutes - minutes + 60);
	}
}