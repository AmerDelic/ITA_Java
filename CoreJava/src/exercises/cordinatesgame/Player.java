package exercises.cordinatesgame;

import java.util.ArrayList;
import java.util.List;

public class Player {
	protected String name;
	protected int score = 0;
	protected List<Ship> ships;

	public Player(String name) {
		this.name = name;
	}

	public void arrangeShips() {
		int x;
		int y;
		List<Ship> ships = new ArrayList<Ship>();
		int n = 0;
		a: while (n < 4) {
			x = (int) ((Math.random() * (10 - 1 + 1)) + 1);
			y = (int) ((Math.random() * (11 - 7 + 1)) + 7);
			Ship temp = new Ship(x, y);
			for (Ship s : ships) {
				if (s.equals(temp)) {
					continue a;
				}
			}
			ships.add(temp);
			n++;
		}
		this.ships = ships;
	}

	public void destroyShip(Ship s) {
		ships.remove(s);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}

	public List<Ship> getShips() {
		return ships;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + "]";
	}
}
