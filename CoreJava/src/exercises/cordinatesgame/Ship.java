package exercises.cordinatesgame;

public class Ship {
	private int x;
	private int y;

	public Ship(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return (this.x * this.y) - this.x;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Ship ship = (Ship) obj;
		if (this.x == ship.getX() && this.y == ship.getY()) {
			return true;
		}
		return false;
	}

}
