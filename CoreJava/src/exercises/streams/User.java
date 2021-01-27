package exercises.streams;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private long jmbg;
	
	public User(int id, String firstName, String lastName, long jmbg) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jmbg = jmbg;
	}

	@Override
	public String toString() {
		return String.format("User Id: %d\n" + "First Name: %s\n" + "Last Name: %s\n" + "Jmbg: %d",
				id, firstName, lastName, jmbg);
	}
	
	
}
