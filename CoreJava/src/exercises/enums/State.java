package exercises.enums;

public enum State {
	
	Running(1, "It's running!"), Stopped(2, "It's stopped!"), Frozen(3, "It's frozen!");
	
	public int stateId;
	public String desc;
	
	
	private State(int stateId, String desc) {
		this.stateId = stateId;
		this.desc = desc;
	}
}
