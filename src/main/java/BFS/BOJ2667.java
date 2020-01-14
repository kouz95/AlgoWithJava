package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2667 {
	private static final Scanner scanner = new Scanner(System.in);
	private static final List<Direction> directions = new ArrayList<>();

	public static void main(String[] args) {
		final int mapSize = Integer.parseInt(scanner.nextLine());
		int estateCount = 0;
		Map map = setMap(mapSize);
		setDirections();
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				Position position = new Position(i, j);
				if (map.getIsVisit(position)) {
					continue;
				}
				if (map.isHouse(position)) {
					estateCount++;
					BFS(position, map, estateCount);
				}
			}
		}
		printResult(estateCount, map);
	}

	private static Map setMap(int mapSize) {
		Map map = new Map(mapSize);
		for (int i = 0; i < mapSize; i++) {
			String row = scanner.nextLine();
			map.setWallByRow(Arrays.asList(row.split("")), i);
		}
		return map;
	}

	private static void setDirections() {
		directions.add(new Direction(1, 0));
		directions.add(new Direction(0, 1));
		directions.add(new Direction(-1, 0));
		directions.add(new Direction(0, -1));
	}

	private static void BFS(Position start, Map map, int estateCount) {
		Queue<Position> queue = new <Position>LinkedList();
		queue.add(start);
		map.setIsVisit(start);
		map.setEstateCounts(start, estateCount);
		while (!queue.isEmpty()) {
			Position current = queue.poll();
			for (Direction direction : directions) {
				Position next = current.go(direction);
				if (map.isOutOfRange(next)) {
					continue;
				}
				if (!map.getIsHouse(next)) {
					continue;
				}
				if (map.getIsVisit(next)) {
					continue;
				}
				queue.add(next);
				map.setIsVisit(next);
				map.setEstateCounts(next, estateCount);
			}
		}
	}

	private static void printResult(int estateCount, Map map) {
		System.out.println(estateCount);
		List<Integer> houseCounts = new ArrayList<>();
		for (int i = 0; i < estateCount; i++) {
			houseCounts.add(getHouseCount(i + 1, map));
		}
		Collections.sort(houseCounts);
		for (Integer count : houseCounts) {
			System.out.println(count);
		}
	}

	private static int getHouseCount(int estateCount, Map map) {
		return map.getHouseCount(estateCount);
	}
}

class Map {
	private boolean[][] isVisit;
	private boolean[][] isHouse;
	private int mapSize;
	private int[][] estateCounts;

	Map(int mapSize) {
		this.isVisit = new boolean[mapSize][mapSize];
		this.isHouse = new boolean[mapSize][mapSize];
		this.estateCounts = new int[mapSize][mapSize];
		this.mapSize = mapSize;
		for (int i = 0; i < mapSize; i++) {
			Arrays.fill(isVisit[i], false);
			Arrays.fill(isHouse[i], false);
			Arrays.fill(estateCounts[i], 0);
		}
	}

	void setWallByRow(List<String> row, int rowIndex) {
		for (int i = 0; i < row.size(); i++) {
			if (row.get(i).equals("1")) {
				isHouse[rowIndex][i] = true;
			}
		}
	}

	boolean isHouse(Position position) {
		return isHouse[position.row][position.col];
	}

	void setIsVisit(Position position) {
		isVisit[position.row][position.col] = true;
	}

	boolean isOutOfRange(Position position) {
		if (position.row < 0 || position.row >= mapSize) {
			return true;
		}
		return position.col < 0 || position.col >= mapSize;
	}

	boolean getIsHouse(Position position) {
		return isHouse[position.row][position.col];
	}

	boolean getIsVisit(Position position) {
		return isVisit[position.row][position.col];
	}

	void setEstateCounts(Position position, int estateCount) {
		estateCounts[position.row][position.col] = estateCount;
	}

	int getHouseCount(int estateNumber) {
		int houseCount = 0;
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				if (estateCounts[i][j] == estateNumber) {
					houseCount++;
				}
			}
		}
		return houseCount;
	}
}

class Position {
	int row;
	int col;

	Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	Position go(Direction direction) {
		return new Position(this.row + direction.dRow, this.col + direction.dCol);
	}
}

class Direction {
	int dRow;
	int dCol;

	Direction(int dRow, int dCol) {
		this.dRow = dRow;
		this.dCol = dCol;
	}
}