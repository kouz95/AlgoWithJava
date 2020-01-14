package Simulation;

public class BOJ14499 {
	public static void main(String[] args) {

	}

	public Map setMap(int width, int height) {
		return new Map(width, height);
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
}
