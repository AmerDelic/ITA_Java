package exercises.cordinatesgame;

import java.util.ArrayList;
import java.util.List;

public class Opponent extends Player {
	
	
	public Opponent() {
		super("Pc");
	}

	@Override
	public void arrangeShips() {
		int x;
		int y;
		List<Ship> ships = new ArrayList<Ship>();
		int n = 0;
		a: while (n < 4) {
			x = (int) ((Math.random() * (10 - 1 + 1)) + 1);
			y = (int) ((Math.random() * (5 - 1 + 1)) + 1);
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

	public List<Ship> getShips() {
		return ships;
	}

	@Override
	public String toString() {
		return "Opponent [name=" + name + "]";
	}
}

