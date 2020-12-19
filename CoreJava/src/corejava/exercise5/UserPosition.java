package corejava.exercise5;

public class UserPosition {
	private int userId;
	private UserPoint position;

	public UserPosition(int userId, UserPoint position) {
		this.userId = userId;
		this.position = position;
	}

	@Override
	public String toString() {
		return "UserPosition [ID = " + userId + "; Position: " + position + "]";
	}
}
