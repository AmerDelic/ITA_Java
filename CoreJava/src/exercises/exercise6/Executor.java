package exercises.exercise6;

public class Executor {
	public static void main(String[] args) {
		final String testA = "(22052014,44.756364,20.412598,051230,123143124122)";
		final String testB = "(051230,44.756364,20.412598,22052014,123143124122,H)";
		
		System.out.println(SpaceTime.getInstance(testA));
		System.out.println(SpaceTime.getInstance(testB));
	}
}
