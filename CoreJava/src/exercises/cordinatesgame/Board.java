package exercises.cordinatesgame;

import java.util.List;

public class Board {

	private char[][] map;
	private Player p1;
	private Opponent pc;
	private boolean gameover = false;

	public Board(Player p1, Opponent pc) {
		this.p1 = p1;
		this.pc = pc;
		this.map = generate(10, 11);
	}

	private char[][] generate(int x, int y) {
		char[][] emptyMap = new char[y + 2][x + 2];

		for (int i = 0; i <= y + 1; i++) {
			x: for (int j = 0; j <= x + 1; j++) {

				if (i > 0 && i < y + 1 && j > 0 && j < x + 1 && i == (y / 2) + 1) {
					emptyMap[i][j] = '-';
					continue x;
				} else if (i > 0 && i < y + 1 && j > 0 && j < x + 1) {
					emptyMap[i][j] = ' ';
				} else {
					emptyMap[i][j] = 'O';
				}
			}
		}
		char[][] finishedMap = populate(emptyMap);
		return finishedMap;
	}

	private char[][] populate(char[][] emptyMap) {
		List<Ship> playerShips = p1.getShips();
		int y;
		int x;
		for (Ship s : playerShips) {
			y = s.getY();
			x = s.getX();
			emptyMap[y][x] = '*';
		}
		return emptyMap;
	}

	private void draw() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
				if (j == map[i].length - 1) {
					System.out.print("\n");
				}
			}
		}
		System.out.println("\n");
	}

	public void shoot(int x, int y) {
		Ship target = null;
		boolean isHit = false;
		List<Ship> PcShips = pc.getShips();
		if (PcShips.isEmpty()) {
			gameover = true;
		} else {
			for (Ship s : PcShips) {
				if (s.getY() == y && s.getX() == x) {
					isHit = true;
					target = s;
				}
			}
		}
		if (!isHit) {
			map[y][x] = '+';
			draw();
			System.out.println("Miss!\n");
		} else {
			map[y][x] = 'X';
			pc.destroyShip(target);
			p1.setScore(1);
			draw();
			System.out.println("Hit!\n");
			if (PcShips.isEmpty()) {
				gameover = true;
			}
		}
	}

	public void pcShoot() {
		Ship target = null;
		boolean isHit = false;
		int x = (int) ((Math.random() * 10) + 1);
		int y = (int) ((Math.random() * 5) + 7);
		List<Ship> ships = p1.getShips();
		if (ships.isEmpty()) {
			gameover = true;
		} else {
			for (Ship s : ships) {
				if (s.getY() == y && s.getX() == x) {
					isHit = true;
					target = s;
				}
			}
		}
		if (!isHit) {
			map[y][x] = '+';
			draw();
		} else {
			map[y][x] = 'X';
			p1.destroyShip(target);
			pc.setScore(1);
			draw();
			if (ships.isEmpty()) {
				gameover = true;
			}
		}
	}

	public void resetMap() {
		this.map = generate(10, 11);
		this.gameover = false;
	}

	public boolean isOver() {
		return gameover;
	}

}
