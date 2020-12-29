package exercises.userposition;

public class UserPoint {
	private double x;
	private double y;
	
	public UserPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "X = " + x + "; Y = " + y;
	}
}
