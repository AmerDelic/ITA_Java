package exercises.generics;

public class Visa implements ICard {
	
	double ballance;

	public Visa(double ballance) {
		this.ballance = ballance;
	}

	@Override
	public void getMoney(double amount) {
		System.out.println("Withdrew " + amount + "$ from Visa card." + 
				"\n " + "Remaining ballance: " + (ballance - amount));
	} 
}
