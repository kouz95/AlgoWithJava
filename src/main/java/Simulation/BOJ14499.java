package Simulation;

import java.util.Scanner;

public class BOJ14499 {
	public static void main(String[] args) {
		Solving14499 solving = new Solving14499();
	}
}

class Solving14499 {
	private static final Scanner scanner = new Scanner(System.in);

	Map map;
	Dice dice;

	public Solving14499() {
		map = setMap(scanner.nextInt(), scanner.nextInt());
		dice = setDice(scanner.nextInt(), scanner.nextInt());
	}

	Map setMap(int width, int height) {
		return new Map(width, height);
	}

	Dice setDice(int col, int row) {
		return new Dice(row, col);
	}
}

class Map {
	private int width;
	private int height;

	Map(int width, int height) {
		if (width < 1 || height > 20) {
			throw new IllegalArgumentException();
		}
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}

class Dice {
	private int row;
	private int col;

	public Dice(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
