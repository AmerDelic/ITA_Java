package exercises.generics;

public class Master implements ICard {

	double ballance;

	public Master(double ballance) {
		this.ballance = ballance;
	}

	@Override
	public void getMoney(double amount) {
		System.out.println("Withdrew " + amount + "$ from Master card." + 
	"\n " + "Remaining ballance: " + (ballance - amount));
	}

}
