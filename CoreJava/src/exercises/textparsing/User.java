package exercises.textparsing;

public class User {
	private String id;
	private String name;
	private String score;

	private User(String id, String name, String score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}

	public static User parse(String info) {
		String[] temp = info.split("-");
		return new User(temp[0], temp[1], temp[2]);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
}
